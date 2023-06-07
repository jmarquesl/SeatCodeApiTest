Feature: Github repository information Endpoint

  Scenario: The endpoint returns a valid Schema
    Given user can create REST API calls
    When they call the repository information endpoint
    Then the response follows the repository json schema

  Scenario: The endpoint returns a valid owner value
    Given user can create REST API calls
    When they call the repository information endpoint
    Then the response has the correct owner value

  @ignore
  Scenario: The endpoint returns an invalid owner value
    Given user can create REST API calls
    When they call the repository information endpoint
    Then the response has the incorrect owner value

  @ignore
  Scenario: The endpoint returns an invalid Schema
    Given user can create REST API calls
    When they call the repository information endpoint
    Then the response follows the wrong json schema