@createquickreplytemplate

@test
Feature: TC_13 To create quick reply message template in the Zeitblast apllication  

Scenario Outline: 01 Delete particular documents from MongoDB collection
    Given the user initializes the MongoDB connection
    When the user deletes documents with "<field_name>" equal to "<value>" from the "<collection_name>" collection
    Then those documents with "<field_name>" equal to "<value>" should no longer exist in the "<collection_name>" collection
    And the user closes the MongoDB connection
    Examples:
      | field_name | value                  | collection_name               |
      | name       | QA quick reply message |  quickreplycategories         |
      | title      | QA TEST                |    quickreplytemplates        |
   
Scenario: 02 To create quick reply message template
    Given The user logs in the Zeitblast application with "super admin" credentials
    When The User should be able to navigate the Templates page
    When The user clicks the quick reply message tab
    And The user click the create new button in the Templates page
    And The user Create New Category as "QA quick reply message" in the Templates page
    And The user selects "QA quick reply message" from the list of categories
    And The user enters the title name as "QA TEST"
    And The user enters the "Hi all..." message
    And The user saves the quick reply message
    Then The user should observe a success message confirming the Quickreply message templates created successfully
     And The user logs out from the Zeitblast application