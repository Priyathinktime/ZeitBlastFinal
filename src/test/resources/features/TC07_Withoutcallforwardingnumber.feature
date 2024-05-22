@Withoutcallforwardingnumber
@entiretest
@test
Feature: TC_07 Verify that the admin should not be able to create market without Call forwarding Number
 
Scenario: 01 To create market without call forwarding number
 Given The user logs in the Zeitblast application with "super admin" credentials
    When The user creates a new market and enters the market name "Market01", Area code "470", and Call forwarding number ""