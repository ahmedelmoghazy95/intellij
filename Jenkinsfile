pipeline {
  agent any

  tools {
    maven 'maven'
  }

  environment {
      //Use Pipeline Utility Steps plugin to read information from pom.xml into env variables
      POM_ARTIFACTID = readMavenPom().getArtifactId()
      POM_VERSION = readMavenPom().getVersion()
  }

  options {
    skipStagesAfterUnstable()
    disableConcurrentBuilds()
  }

  stages {
    stage('Maven Prepare') {
      steps {
        sh 'sed -i "s|TEST_SUITE|engineering-offices|g" $WORKSPACE/Dockerfile'
      }
    }

    stage('Maven Build') {
      steps {
        sh 'mvn clean -Pdev -DemailProperties=debugMailConfig -DmoduleName="Engineering Offices" package'
      }
    }

    stage('Docker Build') {
      steps {
        sh 'docker build -t registry.sumerge.local/momra/${POM_ARTIFACTID}:${POM_VERSION} .'
      }
    }

    stage('Docker Push') {
      steps {
        sh 'docker push registry.sumerge.local/momra/${POM_ARTIFACTID}:${POM_VERSION}'
      }
    }

    stage ('K8s Prepare') {
      steps {
        sh '''
        sed -i "s|DOCKER-REGISTRY|registry.sumerge.local/momra|g" $WORKSPACE/kubernetes/e2e-ui-module-job.yaml
        sed -i "s|VERSION|${POM_VERSION}|g" $WORKSPACE/kubernetes/e2e-ui-module-job.yaml
        sed -i "s|MODULE_NAME|-engineering-offices|g" $WORKSPACE/kubernetes/e2e-ui-module-job.yaml
        '''
      }
    }

    stage ('K8s Deploy') {
      steps {
        sh '''
        kubectl delete --ignore-not-found -f $WORKSPACE/kubernetes/e2e-ui-module-job.yaml -n momra-inspections
        kubectl create -f $WORKSPACE/kubernetes/e2e-ui-module-job.yaml -n momra-inspections
        '''
      }
    }
  }
}
