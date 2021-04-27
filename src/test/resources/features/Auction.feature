Feature: bidding
  As a: customer
  I want: to bid for chosen product
  So that: I could win auction and buy it

  Scenario: Biding zero
    Given Customer logs on site
    And Customer performs search for 'product.name'
    When Customer clicks on Auction filter
    And Customer clicks for product on position 'product.position.nr'
    And Customer passes zero to bid
    Then Customer is asked to place valid amount
