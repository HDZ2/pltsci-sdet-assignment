package com.platformscience.models;

import com.google.gson.Gson;

import java.util.List;
import java.util.Map;

public class PltsciRequest {
    private Map<Integer, Integer> RoomSize;
    private Map<Integer, Integer> Coords;
    private List<Map<Integer, Integer>> Patches;
    private String Instructions;

    // Constructor
    public PltsciRequest(Map<Integer, Integer> roomSize, Map<Integer, Integer> coords, List<Map<Integer, Integer>> patches, String instructions) {
        this.RoomSize = roomSize;
        this.Coords = coords;
        this.Patches = patches;
        this.Instructions = instructions;
    }
    public Map<Integer, Integer> getRoomSize() {
        return RoomSize;
    }

    public Map<Integer, Integer> getCoords() {
        return Coords;
    }

    public List<Map<Integer, Integer>> getPatches() {
        return Patches;
    }

    public String getInstructions() {
        return Instructions;
    }
    public String toJson() {
        Gson gson = new Gson();
        return gson.toJson(this);
    }

    public static PltsciRequest fromJson(String json) {
        Gson gson = new Gson();
        return gson.fromJson(json, PltsciRequest.class);
    }
}


