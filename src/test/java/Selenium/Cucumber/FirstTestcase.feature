Feature: E2E Test 

	Background: 
	Given: navigate to based url
	
  Scenario Outline: positive E2E Test
    Given login with username <name> and password <password>
    When add product <product> to cart and checkout
    Then verfiy details "***"

    Examples: 
      | name      | password  | product    |
      | Sam@1.com | 12345     | Nikon D300 |
      
