Feature: sign in
  As a: customer
  I want: to may sign in
  So that: my data are available

  Scenario: Sign in page visibility
    Given Customer is on page with url 'home.page.url'
    When Customer clicks on sign in link
    Then Page title contains 'Sign in'

  Scenario: Correct sign in
    Given Customer is on sign in page
    When Customer passes 'default.user.email' to email field
    And Customer passes 'default.user.password' to password field
    Then Customer is logged on a site


  Scenario: Wrong email
    Given Customer is on sign in page
    When Customer passes 'incorrect.user.email' to email field
    Then Error login message is visible

  Scenario: Wrong password
    Given Customer is on sign in page
    When Customer passes 'default.user.email' to email field
    And Customer passes 'incorrect.user.password' to password field
    Then Error login message is visible
