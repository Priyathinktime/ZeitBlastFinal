@CreateMultipleMarkets
@entiretest
@test
Feature: TC_09 Verify that the Admin can able to create multiple Markets with duplicate area codes with different call forwarding number
 
Scenario: 01 Delete all existing documents in MongoDB
Given the user initializes the MongoDB connection
    When the user deletes all existing documents from the collection
    Then no documents should exist in the collection
    And the user closes the MongoDB connection
    
 Scenario: 02 Create multiple Markets with duplicate area codes with different call forwarding number
 Given The user logs in the Zeitblast application with "super admin" credentials
    When The user creates a new market and enters the market name "Market01", Area code "470", and Call forwarding number "4704704707"
    Then The user should observe a success message confirming the creation of the new market
    When The user creates a new market and enters the market name "Market02", Area code "470", and Call forwarding number "4604789507"
    Then The user should observe a success message confirming the creation of the new market
    When The user creates a new market and enters the market name "Market03", Area code "470", and Call forwarding number "4909876490"
    Then The user should observe a success message confirming the creation of the new market
    And The user logs out from the Zeitblast application