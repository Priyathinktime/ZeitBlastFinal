@UTC

Feature: Change the Time Zone to UTC

#Scenario: 01 Change the Time Zone to UTC
    #Given the user turns on the server using valid credentials
    #When the user sets the time zone to UTC on the server
    #And the user turns off the server

#Scenario: 04 Changing the Time Zone to market hours (8:00 AM EST)
  #Given the user turns on the server using valid credentials
  #When the EST timing is adjusted for today
    #Then the user turns off the server
    
  Scenario: 02 Delete all existing documents in MongoDB
Given the user initializes the MongoDB connection
    When the user deletes all existing documents from the collection
    Then no documents should exist in the collection
    And the user closes the MongoDB connection
    
    
    #Scenario: 06 Changing the EST Time Zone after a week
  #Given the user turns on the server using valid credentials
  #When changing the EST timing to next Week
   #Then the user turns off the server
   
 #Scenario:01 change the initalmsg
 #Given the user initializes the MongoDB connection
 #When change the value in initail massege  
  #Then the user closes the MongoDB connection
 
    