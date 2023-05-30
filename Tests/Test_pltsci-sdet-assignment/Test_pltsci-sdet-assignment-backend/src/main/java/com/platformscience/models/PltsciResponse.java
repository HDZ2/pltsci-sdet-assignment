package com.platformscience.models;

import com.google.gson.Gson;

import java.util.Map;

public class PltsciResponse {
    private Map<Integer, Integer> Coords;
    private Integer Patches;

    public PltsciResponse( Map<Integer, Integer> coords, Integer patches) {
        this.Coords = coords;
        this.Patches = patches;
    }
    public Map<Integer, Integer> getCoords() {
        return Coords;
    }

    public Integer getPatches() {
        return Patches;
    }

    public String toJson() {
        Gson gson = new Gson();
        return gson.toJson(this);
    }

    public static PltsciResponse fromJson(String json) {
        Gson gson = new Gson();
        return gson.fromJson(json, PltsciResponse.class);
    }

}
