@UTC
@entiretest
@test
Feature: Change the Time Zone to UTC

Scenario: 01 Change the Time Zone to UTC
    Given the user turns on the server using valid credentials
    When the user sets the time zone to UTC on the server
    And the user turns off the server



  