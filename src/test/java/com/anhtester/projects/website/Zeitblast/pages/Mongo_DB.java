package com.anhtester.projects.website.Zeitblast.pages;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.bson.Document;

import com.anhtester.constants.FrameworkConstants;
import com.mongodb.MongoConfigurationException;
import com.mongodb.MongoException;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.UpdateOptions;
import com.mongodb.client.model.Updates;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;

public class Mongo_DB {
	private MongoClient mongoClient;
	private MongoCollection<Document> batchesCollection;
	private Exception exception;
	List<String[]> csvDataList;
	
	int BatchNO = 1;

	public void initializeMongoDB() throws InterruptedException {

		int retryInterval = 5000; // 1 second
		
		    try {
		    	mongoClient = MongoClients.create(
						FrameworkConstants.MONGODB_URL);
		    	Thread.sleep(10000);

		    
		    } catch (MongoConfigurationException  e) {
		    	System.err.println("MongoConfigurationException: " + e.getMessage());
		        
		        Thread.sleep(retryInterval);
		        mongoClient = MongoClients.create(
		        		FrameworkConstants.MONGODB_URL);
		    }
		}
	


	 public void fetchdatafromDB(String phone, String bandID, String filename) throws InterruptedException, IOException {try {
		    MongoDatabase database = mongoClient.getDatabase("launch_control");

		    MongoCollection<Document> batchesCollection = database.getCollection("batches");
		    Document batchDoc = batchesCollection.find(Filters.eq("batchNumber", BatchNO)).first();
		    String batchId = batchDoc.getObjectId("_id").toString();

		    // Create a new workbook
		    Workbook workbook = new XSSFWorkbook();
		    Sheet sheet = workbook.createSheet("Data");

		    // Write headers to Excel sheet
		    Row headerRow = sheet.createRow(0);
		    headerRow.createCell(0).setCellValue("phone1");
		    headerRow.createCell(1).setCellValue("bandwithsendId");

		    // Fetch data from csvdatas collection and write directly to Excel sheet
		    MongoCollection<Document> csvDatasCollection = database.getCollection("csvdatas");
		    FindIterable<Document> cursor = csvDatasCollection.find(Filters.eq("batchId", batchId));
		    int rowCount = 1; // Start writing data from row 1
		    for (Document doc : cursor) {
		        try {
		            String Phone = doc.getString(phone);
		            String bandWithSendId = doc.getString(bandID);
		            if (bandWithSendId != null) {
		                Row row = sheet.createRow(rowCount++);
		                row.createCell(0).setCellValue(Phone);
		                row.createCell(1).setCellValue(bandWithSendId);
		            }
		        } catch (Exception e) {
		            // Handle any exceptions that occur during data retrieval
		            e.printStackTrace();
		            // You can log the exception or perform other error handling actions here
		        }
		    }

		    // Write workbook to file
		    FileOutputStream fileOut = new FileOutputStream(FrameworkConstants.TESTDATA_FILE_PATH + File.separator + filename);
		    workbook.write(fileOut);
		    fileOut.close();
		    workbook.close();
		} catch (Exception e) {
		    // Handle any exceptions that occur during the main execution
		    e.printStackTrace();
		    // You can log the exception or perform other error handling actions here
		}}
	public void deleteMongoDBDocuments(String collectionName) {
		
			// Initialize database and get the collection
			MongoDatabase database = mongoClient.getDatabase("launch_control");
			batchesCollection = database.getCollection(collectionName);

			DeleteResult deleteResult = batchesCollection.deleteMany(new Document());
			System.out.println(deleteResult.getDeletedCount() + " documents deleted successfully.");
		
	}
	public void deleteDocuments(String field, String value, String collectionName) {
		MongoDatabase database = mongoClient.getDatabase("launch_control");
        MongoCollection<Document> initialCollection = database.getCollection(collectionName);
  
        Document filter = new Document(field, value);
        
        initialCollection.deleteMany(filter);
        System.out.println("Documents deleted successfully from the 'initial' collection.");
    }
	
	
	

	public void closeMongoClient() {
		// Close MongoDB client
		if (mongoClient != null) {
			mongoClient.close();
		}
	}

	public void updateverified(String name,int no,int noofverifed) throws InterruptedException, IOException {
		FileInputStream inputStream = new FileInputStream(FrameworkConstants.TESTDATA_FILE_PATH + File.separator + name);
		Workbook workbook = new XSSFWorkbook(inputStream);
		Sheet sheet = workbook.getSheetAt(0);

		for (int i = 1; i <=noofverifed; i++) { // Start from 1 to skip header
		    Row row = sheet.getRow(i);

		    if (row != null) { // Check if the row is not null
		        Cell phoneCell = row.getCell(0);
		        if (phoneCell != null) {
		            String phoneNumber = phoneCell.getStringCellValue();
		            MongoDatabase database = mongoClient.getDatabase("launch_control");

		            MongoCollection<Document> csvDatasCollection = database.getCollection("csvdatas");
		            MongoCollection<Document> inboxesCollection = database.getCollection("inboxes");
		            UpdateResult csvUpdateResult;
		            UpdateResult inboxUpdateResult;

		            // Modify the condition based on the specific criterion for each phone number
		            if (no==1) {
		                csvUpdateResult = csvDatasCollection.updateMany(Filters.eq("phone1", phoneNumber),
		                        Updates.set("isPhone1Verified", true));

		                 inboxUpdateResult = inboxesCollection.updateMany(Filters.eq("to", phoneNumber),
		                        Updates.combine(
		                                Updates.set("isVerifiedNumber", true),
		                                Updates.set("isRead", true),
		                                Updates.set("messages.$[elem].isViewed", true)
		                        ),
		                        new UpdateOptions().arrayFilters(List.of(Filters.eq("elem.isViewed", false)))
		                );
		            } else if (no==2) {
		               csvUpdateResult = csvDatasCollection.updateMany(Filters.eq("phone2", phoneNumber),
		                        Updates.set("isPhone2Verified", true));

		                 inboxUpdateResult = inboxesCollection.updateMany(Filters.eq("phone2", phoneNumber),
		                        Updates.combine(
		                                Updates.set("isVerifiedNumberPhone2", true),
		                                Updates.set("isRead", true),
		                                Updates.set("messages.$[elem].isViewed", true)
		                        ),
		                        new UpdateOptions().arrayFilters(List.of(Filters.eq("elem.isViewed", false)))
		                );
		            } else if (no==3) {
		               csvUpdateResult = csvDatasCollection.updateMany(Filters.eq("phone3", phoneNumber),
		                        Updates.set("isPhone3Verified", true));

		              inboxUpdateResult = inboxesCollection.updateMany(Filters.eq("phone3", phoneNumber),
		                        Updates.combine(
		                                Updates.set("isVerifiedNumberPhone3", true),
		                                Updates.set("isRead", true),
		                                Updates.set("messages.$[elem].isViewed", true)
		                        ),
		                        new UpdateOptions().arrayFilters(List.of(Filters.eq("elem.isViewed", false)))
		                );
		            }
		        }
		    }
		}

				
			
		
	}
	public void exceldatadeleted(String name) {
		try {
		    FileInputStream inputStream = new FileInputStream(FrameworkConstants.TESTDATA_FILE_PATH + File.separator + name);
		    Workbook workbook = WorkbookFactory.create(inputStream);
		    Sheet sheet = workbook.getSheetAt(0); // Assuming you want to delete data from the first sheet

		    // Clear data from each row
		    for (Row row : sheet) {
		        for (Cell cell : row) {
		            cell.setCellValue(""); // Clear cell contents
		        }
		    }

		    // Writing changes back to the file
		    FileOutputStream outputStream = new FileOutputStream(FrameworkConstants.TESTDATA_FILE_PATH + File.separator + name);
		    workbook.write(outputStream);

		    // Close resources
		    outputStream.close();
		    workbook.close();
		    inputStream.close();

		    System.out.println("Data deleted successfully from the Excel file.");
		} catch (IOException | EncryptedDocumentException ex) {
			 System.out.println("Data not deleted from the Excel file.");
		   
		}

	}
	public boolean isCollectionEmpty(String collectionName) {
	    // Initialize database and get the collection
	    MongoDatabase database = mongoClient.getDatabase("launch_control");
	    MongoCollection<Document> collection = database.getCollection(collectionName);

	    // Get the count of documents in the collection
	    long count = collection.countDocuments();

	    // Return true if the count is 0, indicating that the collection is empty
	    return count == 0;
	}
	
	public boolean isparticulardocumentdeleted(String field, String value, String collectionName) {
		  MongoDatabase database = mongoClient.getDatabase("launch_control");
		 MongoCollection<Document> initialCollection = database.getCollection(collectionName);
	       
	        Document filter = new Document(field, value);
	        long count = initialCollection.countDocuments(filter);
	       
			return count == 0;
	}
	
	
	public void isParticularDocumentChanged(String field, String value, String collectionName,int arrayvalue) throws ParseException {
	    MongoDatabase database = mongoClient.getDatabase("launch_control");
	    MongoCollection<Document> inboxesCollection = database.getCollection(collectionName);

	    // Find the document where "to" is "4010006"
	    Document query = new Document(field, value);
	    Document documentToUpdate = inboxesCollection.find(query).first();
	    LocalDate today = LocalDate.now();

	    // Check if documentToUpdate is not null
	    if (documentToUpdate != null) {
	        // Get the dripAutomationSchedule array
	        List<Document> dripAutomationSchedule = (List<Document>) documentToUpdate.get("dripAutomationSchedule");

	        // Access the first element directly
	        Document schedule = dripAutomationSchedule.get(arrayvalue);

	        // Update the date field
	        Date date = schedule.getDate("date");
	        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
	        String dateString = dateFormat.format(date);
	        String[] parts = dateString.split("T");
	        String timeAndOffset = parts[1];
	        String newDate = today + "T" + timeAndOffset;

	        // Set the new date
	        schedule.put("date", dateFormat.parse(newDate));

	        // Update the document in MongoDB
	        inboxesCollection.replaceOne(query, documentToUpdate);
	        System.out.println("Document updated successfully.");
	    } else {
	        System.out.println("Document not found with '" + field + "' field equal to '" + value + "'.");
	    }
	}
	
	public void changetheintialmsg(String field, String value, String collectionName) {
	    MongoDatabase database = mongoClient.getDatabase("launch_control");
	    MongoCollection<Document> inboxesCollection = database.getCollection(collectionName);

	    // Find the document where "to" is "4010006"
	    Document query = new Document(field, value);
	    Document documentToUpdate = inboxesCollection.find(query).first();
	 documentToUpdate.put("quantity", 0);

	 // Update the document in the collection
	 inboxesCollection.replaceOne(query, documentToUpdate);
	    
	}
	}

