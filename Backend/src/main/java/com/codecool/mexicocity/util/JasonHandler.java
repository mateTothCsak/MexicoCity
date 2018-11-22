package com.codecool.mexicocity.util;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

public class JasonHandler {

    private static JasonHandler ourInstance = new JasonHandler();

    public static JasonHandler getInstance() {
        return ourInstance;
    }

    private JasonHandler() {
    }


    public String jsonify(Object data) {
        ObjectMapper mapper = new ObjectMapper();

        String jsonString = "";
        try{
            jsonString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(data);
        }
        catch (JsonParseException e) { e.printStackTrace();}
        catch (JsonMappingException e) { e.printStackTrace(); }
        catch (IOException e) { e.printStackTrace(); }
        return jsonString;
    }


    public Object objectFromJson(String json, Class expectedClass) {
        ObjectMapper mapper = new ObjectMapper();
        try{
            Object object = mapper.readValue(json, expectedClass);
            return object;
        }
        catch (JsonParseException e) { e.printStackTrace();}
        catch (JsonMappingException e) { e.printStackTrace(); }
        catch (IOException e) { e.printStackTrace(); }
        return null;
    }
}
