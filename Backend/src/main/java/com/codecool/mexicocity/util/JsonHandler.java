package com.codecool.mexicocity.util;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.IOException;
import java.util.List;

public class JsonHandler {

    private static JsonHandler ourInstance = new JsonHandler();

    public static JsonHandler getInstance() {
        return ourInstance;
    }

    private JsonHandler() {
    }


    public String jsonifyList(List list) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        //Set pretty printing of json
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);

        //1. Convert List of Person objects to JSON
        String arrayToJson = objectMapper.writeValueAsString(list);

        return arrayToJson;
    }

    /*public List<Object> listOfObjectsFromJson(String json, Rooster rooster){
        TypeReference<List<rooster>> mapType = new TypeReference<List<rooster>>() {};
        List<Person> jsonToPersonList = objectMapper.readValue(arrayToJson, mapType);
    }*/

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
