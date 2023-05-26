Feature: Roomba hovers over the room
  Scenario: Assignment example
    Given Send RoomSize 5 and 5
    And Roomba Coordinates 1 and 2
    And Dirt Patches Locations:
      | 1 | 0 |
      | 2 | 2 |
      | 2 | 3 |
    When Instructions are provided "NNESEESWNWW"
    Then Send Request to Cloud
    Then Get Response from Cloud
    Then Validate expected output is 1 and Roombar Final Coordiantes are  1 and 3

  Scenario: Roomba is placed at the last point
    Given Send RoomSize 5 and 5
    And Roomba Coordinates 5 and 5
    And Dirt Patches Locations:
      | 1 | 0 |
      | 2 | 2 |
      | 2 | 3 |
    When Instructions are provided "NN"
    Then Send Request to Cloud
    Then Get Response from Cloud
    Then Validate expected output is 1 and Roombar Final Coordiantes are  1 and 3

  Scenario: Roomba is placed at the last point
    Given Send RoomSize 5 and 5
    And Roomba Coordinates 1 and 2
    And Dirt Patches Locations:
      | 1 | 0 |
      | 2 | 2 |
      | 2 | 3 |
    When Instructions are provided "NNESEESWNWW"
    Then Send Request to Cloud
    Then Get Response from Cloud
    Then Validate expected output is 1 and Roombar Final Coordiantes are  1 and 3

  Scenario: Roomba is placed at the last point
    Given Send RoomSize 5 and 5
    And Roomba Coordinates 1 and 2
    And Dirt Patches Locations:
      | 1 | 0 |
      | 2 | 2 |
      | 2 | 3 |
    When Instructions are provided "NNESEESWNWW"
    Then Send Request to Cloud
    Then Get Response from Cloud
    Then Validate expected output is 1 and Roombar Final Coordiantes are  1 and 3

  Scenario: Roomba is placed at the last point
    Given Send RoomSize 5 and 5
    And Roomba Coordinates 1 and 2
    And Dirt Patches Locations:
      | 1 | 0 |
      | 2 | 2 |
      | 2 | 3 |
    When Instructions are provided "NNESEESWNWW"
    Then Send Request to Cloud
    Then Get Response from Cloud
    Then Validate expected output is 1 and Roombar Final Coordiantes are  1 and 3