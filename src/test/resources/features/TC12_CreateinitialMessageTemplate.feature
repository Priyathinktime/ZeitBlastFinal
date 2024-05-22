@createintialmessagetemplate

@test
Feature: TC_12 Create initial message template in the Zeitblast application 


Scenario Outline: 01 Delete particular documents from MongoDB collection
    Given the user initializes the MongoDB connection
    When the user changes the value of initial message
    When the user deletes documents with "<field_name>" equal to "<value>" from the "<collection_name>" collection
    Then those documents with "<field_name>" equal to "<value>" should no longer exist in the "<collection_name>" collection
    And the user closes the MongoDB connection
    Examples:
      | field_name | value              | collection_name                    |
      | name       | QA initial message | initialandfollowtemplates          |
   
Scenario: 02 To create inital message template
Given The user logs in the Zeitblast application with "super admin" credentials
   When The User should be able to navigate the Templates page
   And The user click the create new button in the Templates page
   And The user enters the Template Name as "QA initial message" and selects the Template Type as "Pre-Foreclosure / Liens / Auction"
   And The user enters all the "initial" messages
   And The user saves the message templates
   Then The user should observe a success message confirming the message templates created successfully
   And The user logs out from the Zeitblast application