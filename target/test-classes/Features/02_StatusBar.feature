#Author: stephen.john@anywhere.co
@StatusBar
Feature: Status Bar

  Scenario: To verify the current status set to Im available by default
    Given check whether the status is available or not
    Then validate the Im available status

  Scenario: To verify the user can double tap on the status bar to change the status
    Given check the current status
    When double tap on the status layout
    Then validate the updated status header
    Then validate the updated status sub header

  Scenario: To verify the user can change the status to IN A MEETING, FURTHER NOTICE
    Given check the current status
    When tap on more status icon
    And tap on In a Meeting
    Then validate the In a Meeting header
    And tap on Further Notice
    And tap on Done
    Then validate the updated status header
    Then validate the updated status sub header for further notice

  Scenario: To verify the user can change the status to IN A MEETING, NEXT HOUR
    Given check the current status
    When tap on more status icon
    And tap on In a Meeting
    Then validate the In a Meeting header
    And tap on Next Hour
    And tap on Done
    Then validate the updated status header
    Then validate the updated status sub header for next hour

  Scenario: To verify the user can change the status to IN A MEETING, NEXT 2 HOURS
    Given check the current status
    When tap on more status icon
    And tap on In a Meeting
    Then validate the In a Meeting header
    And tap on Next 2 Hours
    And tap on Done
    Then validate the updated status header
    Then validate the updated status sub header for next 2 hours

  #Scenario: To verify the user can change the status to IN A MEETING, CUSTOM
    #Given check the current status
    #When tap on more status icon
    #And tap on In a Meeting
    #Then validate the In a Meeting header
    #And tap on Custom
    #And choose a time picker for In a Meeting
    #And tap on Done
    #Then validate the updated status header
    #Then validate the updated status sub header

  Scenario: To verify the user can change the status to AT LUNCH, 15 MINUTES
    Given check the current status
    When tap on more status icon
    And tap on At Lunch
    Then validate the Lunch header
    And tap on 15 Minutes
    And tap on Done
    Then validate the updated status header
    Then validate the updated status sub header for 15 minutes

  Scenario: To verify the user can change the status to AT LUNCH, 30 MINUTES
    Given check the current status
    When tap on more status icon
    And tap on At Lunch
    Then validate the Lunch header
    And tap on 30 Minutes
    And tap on Done
    Then validate the updated status header
    Then validate the updated status sub header for 30 minutes

  Scenario: To verify the user can change the status to AT LUNCH, NEXT HOUR
    Given check the current status
    When tap on more status icon
    And tap on At Lunch
    Then validate the Lunch header
    And tap on Next Hour
    And tap on Done
    Then validate the updated status header
    Then validate the updated status sub header for next hour

  #Scenario: To verify the user can change the status to AT LUNCH, CUSTOM
    #Given check the current status
    #When tap on more status icon
    #And tap on At Lunch
    #Then validate the Lunch header
    #And tap on Custom
    #And choose a time picker for Lunch
    #And tap on Done
    #Then validate the updated status header
    #Then validate the updated status sub header

  Scenario: To verify the user can change the status to ON VACATION, 1 DAY
    Given check the current status
    When tap on more status icon
    And tap on On Vacation
    Then validate the Vacation header
    And tap on 1 Day
    And tap on Done
    Then validate the updated status header
    Then validate the updated status sub header for 1 day

  Scenario: To verify the user can change the status to ON VACATION, 2 DAYS
    Given check the current status
    When tap on more status icon
    And tap on On Vacation
    Then validate the Vacation header
    And tap on 2 Days
    And tap on Done
    Then validate the updated status header
    Then validate the updated status sub header for 2 days

  Scenario: To verify the user can change the status to ON VACATION, 1 Week
    Given check the current status
    When tap on more status icon
    And tap on On Vacation
    Then validate the Vacation header
    And tap on 1 Week
    And tap on Done
    Then validate the updated status header
    Then validate the updated status sub header for 1 week

  #Scenario: To verify the user can change the status to ON VACATION, CUSTOM
    #Given check the current status
    #When tap on more status icon
    #And tap on On Vacation
    #Then validate the Vacation header
    #And tap on Custom
    #And choose a date and time picker for Vacation
    #And tap on Done
    #Then validate the updated status header
    #Then validate the updated status sub header
