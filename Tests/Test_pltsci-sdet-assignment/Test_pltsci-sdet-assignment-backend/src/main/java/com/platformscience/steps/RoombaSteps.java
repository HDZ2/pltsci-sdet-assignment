package com.platformscience.steps;

import com.platformscience.models.PltsciRequest;
import com.platformscience.models.PltsciResponse;
import com.platformscience.utilities.Utilities;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
public class RoombaSteps {




    private Map<Integer, Integer> RoomSize ;
    private Map<Integer, Integer> Coords;
    private List<Map<Integer, Integer>> Patches;
    private String Instructions;

    private Map<Integer, Integer> RoombaFinalPosition;

    @Given("Send RoomSize {int} and {int}")
    public void sendRoomSize(int x, int y) {
        this.RoomSize = new HashMap<Integer, Integer>();
        this.RoomSize.put(x,y);
    }

    @And("Roomba Coordinates {int} and {int}")
    public void roombacoordinates(int x, int y) {

        this.Coords = new HashMap<Integer, Integer>();
        this.Coords.put(x,y);
    }

    @And("Dirt Patches Locations:")
    public void dirtPatchesLocations(DataTable dataTable) {
        List<Map<Integer, Integer>> patches = dataTable.asMaps(Integer.class, Integer.class);
        this.Patches = patches;
    }

    @When("Instructions are provided {string}")
    public void instructionsAreProvided(String instructions) {
        this.Instructions = instructions;
    }

    @Then("Send Request to Cloud")
    public PltsciRequest sendRequestToCloud() {
        return new PltsciRequest(
                this.RoomSize,
                this.Coords,
                this.Patches,
                this.Instructions
        );
    }

    @Then("Get Response from Cloud")
    public PltsciResponse getResponseFromCloud() {
        Utilities utility = new Utilities();
        return utility.PostAsync(sendRequestToCloud());
    }

    @Then("Validate expected output is {int} and Roombar Final Coordiantes are  {int} and {int}")
    public void validateExpectedOutputIsAndRoombarFinalCoordiantesAreAnd(int numPatches, int x, int y) {
        this.RoombaFinalPosition = new HashMap<Integer, Integer>();
        this.RoombaFinalPosition.put(x,y);
        PltsciResponse actualResponse = new PltsciResponse((Map<Integer, Integer>) this.RoombaFinalPosition,numPatches);
        assert (getResponseFromCloud() == actualResponse);
    }
}
