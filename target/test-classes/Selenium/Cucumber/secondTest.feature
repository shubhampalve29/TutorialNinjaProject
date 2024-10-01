Feature: validata invalid test case

  Scenario Outline: verfyinvalid login
    Given navigate to based url
    When login with username <name> and password <password>
    Then I verify details valid or not

    Examples: 
      | name  | value | status  |
      | name1 |     5 | success |
      | name2 |     7 | Fail    |
