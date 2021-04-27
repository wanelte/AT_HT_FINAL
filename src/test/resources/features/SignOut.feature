Feature: sign out
  As a: customer
  I want: to may sign out
  So that: my data are no longer available

  Scenario: Signing out
    Given Customer logs on site
    When Customer performs singing out
    Then Customer is logged out
