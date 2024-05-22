@createdrip
@entiretest
@test
Feature: TC_24 Create Drip    
   
Scenario Outline: 01 Delete particular documents from MongoDB collection
    Given the user initializes the MongoDB connection
    When the user deletes documents with "<field_name>" equal to "<value>" from the "<collection_name>" collection
    Then those documents with "<field_name>" equal to "<value>" should no longer exist in the "<collection_name>" collection
    And the user closes the MongoDB connection
    Examples:
      | field_name | value             | collection_name                    |
      | name       |QA_Drip_01 | dripautomations          |
  
Scenario: 02 Create Drip Automation
  Given The user logs in the Zeitblast application with "super admin" credentials
   When The User should be able to navigate the Drip Automations page
   And The User clicks the Create New Drip
  And The User enters the Drip Automation name as "QA_Drip_01" 
  And The User enters the message 
  And The User saves the Drip Automation
  Then The user should observe a success message confirming the drip is created successfully
  And The user logs out from the Zeitblast application