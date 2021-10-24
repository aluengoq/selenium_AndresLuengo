Feature: Airbnb Test

  Scenario Outline: Search for accommodation in <location>
    Given the user is at the homepage
    When the user searches for "<location>"
    And selects "2021-11-07" as check in date
    And selects "2021-11-15" as check out date
    And adds 2 adults as guests
    And clicks on search
    Then the user should see the title Stays in "<place>" and <numberOfMatches> matches with the number of guests in the results

    Examples:
      | location                         | place     | numberOfMatches |
      | New York, NY                     | New York  | 15              |
      | Abu Dhabi - United Arab Emirates | Abu Dhabi | 15              |
      | Oslo, Norway                     | Oslo      | 14              |

  Scenario Outline: Search for experiences in <location>
    Given the user is at the homepage
    And the user goes to "EXPERIENCES" section
    When the user searches for "<location>"
    And selects "2021-11-07" as date
    And clicks on search
    Then the user should see <numberOfResults> results for "<place>"

    Examples:
      | location                         | numberOfResults | place     |
      | New York, NY                     | 182             | New York  |
      | Abu Dhabi - United Arab Emirates | 9               | Abu Dhabi |
      | Oslo, Norway                     | 6               | Oslo      |

  Scenario: Check nearby places
    Given the user is at the homepage
    Then the user should see the list of nearby places and how many hours away they are
