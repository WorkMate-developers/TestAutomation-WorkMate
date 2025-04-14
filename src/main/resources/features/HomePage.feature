Feature: Basic Home Page tests

  Scenario Outline: Verify text in Home Page cards
    When I open the Home Page
    Then Card <card> title matches <title> value
    And Card <card> text matches <text> value
    Examples:
      | card                         | title                        | text                                      |
      | Settings                     | Settings                     | Manage your preferences                   |
      | Software Installation        | Software Installation        | Software Installation Admin Space         |
      | Software Option              | Software Option              | Software Options Admin Place              |
      | Software Option Installation | Software Option Installation | Software Options Installation Admin Place |
      | Instrument Installation      | Instrument Installation      | Instrument Installation Admin Place       |
