pipeline {
  agent any

  tools {
    maven 'maven'
  }

  parameters {
      choice(name: 'TESTNG', choices: ['engineering-offices', 'appeals', 'reports', 'visits', 'visits-violations'], description: 'Module TestNG XML File')
      choice(name: 'MODULE_NAME', choices: ['Engineering Offices', 'Appeals', 'Reports', 'Visits', 'Visits Violations'], description: 'Module Name in Extent Reports')
      choice(name: 'DOCKER_REGISTRY', choices: ['registry.sumerge.local', 'registry.momra.gov.sa'], description: 'Docker Registry')
  }


  options {
    skipStagesAfterUnstable()
    disableConcurrentBuilds()
  }

  stages {
    stage('Maven Prepare') {
      steps {
        sh 'sed -i "s|TEST_SUITE|${TESTNG}|g" $WORKSPACE/Dockerfile'
      }
    }

    stage('Maven Build') {
      steps {
        sh 'mvn clean -Pdev -DemailProperties=debugMailConfig -DmoduleName="${MODULE_NAME}" package'
      }
    }

    stage('Docker Build') {
      steps {
        sh '''
        export POM_VERSION=`mvn --non-recursive help:evaluate -Dexpression=project.version -q -DforceStdout`
        export POM_ARTIFACTID=`mvn --non-recursive help:evaluate -Dexpression=project.artifactId -q -DforceStdout`
        docker build -t ${DOCKER_REGISTRY}/momra/${POM_ARTIFACTID}:${POM_VERSION} .
        '''
      }
    }

    stage('Docker Push') {
      steps {
        sh '''
        export POM_VERSION=`mvn --non-recursive help:evaluate -Dexpression=project.version -q -DforceStdout`
        export POM_ARTIFACTID=`mvn --non-recursive help:evaluate -Dexpression=project.artifactId -q -DforceStdout`
        docker push ${DOCKER_REGISTRY}/momra/${POM_ARTIFACTID}:${POM_VERSION}
        '''
      }
    }

    stage ('K8s Prepare') {
      steps {
        sh '''
        export POM_VERSION=`mvn --non-recursive help:evaluate -Dexpression=project.version -q -DforceStdout`
        sed -i "s|DOCKER-REGISTRY|${DOCKER_REGISTRY}/momra|g" $WORKSPACE/kubernetes/e2e-ui-module-job.yaml
        sed -i "s|VERSION|${POM_VERSION}|g" $WORKSPACE/kubernetes/e2e-ui-module-job.yaml
        sed -i "s|MODULE_NAME|-${TESTNG}|g" $WORKSPACE/kubernetes/e2e-ui-module-job.yaml
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