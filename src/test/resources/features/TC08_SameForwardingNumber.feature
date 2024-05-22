@SameCallForwardingNumber
@entiretest
@test
Feature: TC_08 Verify that the admin can use the same call-forwarding number for multiple markets with same and different area code
 
Scenario: 01 Delete all existing documents in MongoDB
    Given the user initializes the MongoDB connection
    When the user deletes all existing documents from the collection
    Then no documents should exist in the collection
    And the user closes the MongoDB connection
    
 Scenario: 02 To create multiple markets using same call-forwarding number with same and different area code
     Given The user logs in the Zeitblast application with "super admin" credentials
     When The user creates a new market and enters the market name "Market04", Area code "470", and Call forwarding number "4704704707"
     Then The user should observe a success message confirming the creation of the new market
     When The user creates a new market and enters the market name "Market05", Area code "470", and Call forwarding number "4704704707"
     Then The user should observe a success message confirming the creation of the new market
     When The user creates a new market and enters the market name "Market06", Area code "305", and Call forwarding number "4704704707"
     Then The user should observe a success message confirming the creation of the new market
     And The user logs out from the Zeitblast application