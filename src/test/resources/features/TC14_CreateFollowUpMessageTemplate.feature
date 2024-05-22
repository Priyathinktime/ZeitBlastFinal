@createfollowupmessagetemplate
@entiretest
@test
Feature: TC_14 Create Follow-up Template in the Zeitblast application

Scenario Outline: 01 Delete particular documents from MongoDB collection
    Given the user initializes the MongoDB connection
    When the user deletes documents with "<field_name>" equal to "<value>" from the "<collection_name>" collection
    Then those documents with "<field_name>" equal to "<value>" should no longer exist in the "<collection_name>" collection
    And the user closes the MongoDB connection
    Examples:
      | field_name | value               | collection_name                    |
      | name       | QA followup message | initialandfollowtemplates          |
     
Scenario: 02 To create follow-up message template
    Given The user logs in the Zeitblast application with "super admin" credentials
    When The User should be able to navigate the Templates page
    When The user clicks the follow up message tab
    And The user click the create new button in the Templates page
   And The user enters the Template Name as "QA followup message" and selects the Template Type as "Pre-Foreclosure / Liens / Auction"
   And The user enters all the "followup" messages
   And The user saves the message templates
   Then The user should observe a success message confirming the message templates created successfully
   And The user logs out from the Zeitblast application