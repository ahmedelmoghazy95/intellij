package com.sumerge.momra.utilities;



import com.mongodb.*;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import org.bson.Document;
import org.bson.types.ObjectId;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static com.mongodb.client.model.Filters.eq;

public class MongoDBUtils {

    public MongoClient mongo ;

    public MongoDBUtils(String DBUrl) throws MongoSecurityException,MongoSocketException {

        try {
            ServerAddress serverAddress = new ServerAddress(DBUrl, Integer.parseInt("27017"));
            MongoCredential credential = MongoCredential.createCredential("mongoadmin", "admin",
                    "adminpassword".toCharArray());

            List<MongoCredential> credentials = new ArrayList<>();
            credentials.add(credential);
            mongo = new MongoClient(serverAddress, credentials);
        }
        //Todo : fix catch statements since they don't work
        catch ( MongoSecurityException e){
            System.out.println("Wrong MongoDB Credentials");
            System.exit(1);
        }
        catch (MongoSocketException e){
            System.out.println("Couldn't Connect to MongoDB");
            System.exit(1);
        }

    }

    public Document checkVisitIsUpdated (String visitId) throws Exception{

        Thread.sleep(1000);
        MongoDatabase database = mongo.getDatabase("admin");
        MongoCollection<Document> mongoCollection = database.getCollection("visits");
        Document visitDetailsDoc;
        try {
            visitDetailsDoc = mongoCollection.find(eq("_id", new ObjectId(visitId))).first();
            return visitDetailsDoc;
        }
        catch (Exception e){

            System.out.println("Visit Doc is not Found");
            return null ;
        }
    }

    public String createNewVisit(String visitStatus , LocalDateTime visitDate){

        ObjectId visitID = new ObjectId();
        Document visitDocument = new Document("_id", visitID);
        visitDocument.append("status" , visitStatus);
        visitDocument.append("licenseId" , "LcdeWTdXPlQgjMVXbpRYzBT");
        visitDocument.append("siteName" , "Rest Assured Site Name");
        visitDocument.append("licenseIssueDate" , "2021-05-25T09:25:13.647");
        visitDocument.append("licenseExpiryDate" , "2025-05-25T09:25:13.647");
        visitDocument.append("address" , "Rest Assured Address");
        visitDocument.append("licenseOwnerName" , "Rest Assured Owner Name");
        visitDocument.append("numberOfBeds" , "200");
        visitDocument.append("visitDate" , visitDate);
        visitDocument.append("inspectorId" , "TiQaUNWftniOAotnzWvkQt");
        visitDocument.append("latitude" , "Rest Assured Lat");
        visitDocument.append("longitude" , "Rest Assured Long");
        visitDocument.append("baladyaName" , "Rest Assured Balady");
        visitDocument.append("amanaName" , "Rest Assured amana");
        visitDocument.append("districtName" , "Rest Assured district");
        visitDocument.append("situation" , "OPENED");
        visitDocument.append("suspensionReason" , "Rest Assured Suspension");
        visitDocument.append("engineeringOfficeId" , "RestAssuredOfficeID");
        visitDocument.append("finedVisit" , false);
        visitDocument.append("activity" , "Rest Assured Activity");

        visitDocument.append("licensePhone" , "01023456789");
        visitDocument.append("visitNumber" , "Rest Assured visitNumber");
        visitDocument.append("visitRecordDocumentId" , "Rest Assured RecordDocId");
        visitDocument.append("signedRecord" , false);
        visitDocument.append("amanaId" , "Rest Assured amanaId");
        visitDocument.append("licenseStatus" , "Rest Assured licenseStatus");
        visitDocument.append("inspectorName" , "Rest Assured inspectorName");
        visitDocument.append("sadadBillNumber" , "Rest Assured sadadBillNumber");

        visitDocument.append("creationTimestamp" , LocalDateTime.of(2021,
                LocalDateTime.now().getMonth().minus(1) , 25, 1, 1));

        visitDocument.append("updateTimestamp" , LocalDateTime.of(2021,
                LocalDateTime.now().getMonth().minus(1) , 25, 1, 1));

        visitDocument.append("submitDate" , LocalDateTime.of(2021,
                LocalDateTime.now().getMonth().minus(1) , 25, 1, 1));


        visitDocument.append("appealSubmissionDeadline" , LocalDateTime.of(2021,
                LocalDateTime.now().getMonth().minus(1) , 25, 1, 1));

        mongo.getDatabase("admin").getCollection("visits").insertOne(visitDocument);
        return visitID.toString();


    }

    public void deleteVisit (String visitDocumentIdToBeDeleted) {
        mongo.getDatabase("admin").getCollection("visits").
                deleteOne(Filters.eq("_id", new ObjectId(visitDocumentIdToBeDeleted)));

    }


    public String createNewViolation(String visitID , Integer fineAmount, String violationStatus ){

        List<String> inspectorAttachments;
        inspectorAttachments = new ArrayList<>();
        inspectorAttachments.add("restAssured inspectorAttachments");

        List<String> appealAttachments;
        appealAttachments = new ArrayList<>();
        appealAttachments.add("restAssured appealAttachments");

        ObjectId violationId = new ObjectId();
        ObjectId clauseId = new ObjectId();
        ObjectId visitObjectId = new ObjectId(visitID);

        Document violationDocument = new Document("_id", violationId);
        violationDocument.append("visitId" , visitObjectId);
        violationDocument.append("clauseId" , clauseId);
        violationDocument.append("status" , violationStatus);
        violationDocument.append("fineAmount" , fineAmount);

        violationDocument.append("remarks" , "Rest assured  remarks");
        violationDocument.append("appealComments" , "Rest assured appealComments");

        violationDocument.append("submitDate" ,  LocalDateTime.of(2021,
                LocalDateTime.now().getMonth().minus(1) , 25, 1, 1));
        violationDocument.append("paymentDate" ,  LocalDateTime.of(2021,
                LocalDateTime.now().getMonth().minus(1) , 25, 1, 1));
        violationDocument.append("acceptanceDate" ,  LocalDateTime.of(2021,
                LocalDateTime.now().getMonth().minus(1) , 25, 1, 1));

        violationDocument.append("inspectorAttachments",inspectorAttachments);
        violationDocument.append("appealAttachments",appealAttachments);

        mongo.getDatabase("admin").getCollection("violations").insertOne(violationDocument);
        return violationId.toString();

    }

    public void deleteViolation (String violationDocumentIdToBeDeleted) {
        mongo.getDatabase("admin").getCollection("violations").
                deleteOne(Filters.eq("_id", new ObjectId(violationDocumentIdToBeDeleted)));

    }

}
