@AgentLogin
@entiretest
@test
Feature: TC_01 Login as Agent in the Zeitblast Application    
    
Scenario: 01 Login as Agent
Given The user logs in the Zeitblast application with "agent" credentials
  When The User should be in the dashboard page
  Then The User should be able to navigate the Inbox page
  Then The User should be able to navigate the Direct Import page
  Then The User should be able to navigate the Batches page
  Then The User should be able to navigate the Campaigns page
  Then The User should be able to navigate the Templates page
  Then The User should not be able to navigate the Settings page
  Then The User should not be able to navigate the Drip Automation page
  And The user logs out from the Zeitblast application
  

  