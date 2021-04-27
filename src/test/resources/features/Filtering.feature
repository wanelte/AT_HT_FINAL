Feature: filtering searched results
  As a: customer
  I want: to filter given searching results
  So that: I have results given type

  Scenario: Using Buy it now filter
    Given Customer performs search for 'product.name'
    When Customer clicks on Buy it now filter
    Then Customer can buy product on position 'product.position.nr' right now

  Scenario: Using Auction filter
    Given Customer performs search for 'product.name'
    When Customer clicks on Auction filter
    Then Customer can bid for product on position 'product.position.nr'