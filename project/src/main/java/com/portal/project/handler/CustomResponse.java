package com.portal.project.handler;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class CustomResponse {
    //GET ->STATUS CODE,MESSAGE,DATA
    public static ResponseEntity<Object> generate(HttpStatus httpStatus,String message,Object data){
        Map<String,Object> map=new HashMap<>();
        map.put("statusCode", httpStatus);
        map.put("message", message);
        map.put("result", data);

        return new ResponseEntity<Object>(map,httpStatus);
    }

    //POST & DELETE -> STATUS CODE,MESSAGE
    public static ResponseEntity<Object> generate(HttpStatus httpStatus,String message){
        Map<String,Object> map=new HashMap<>();
        map.put("statusCode", httpStatus);
        map.put("message", message);

        return new ResponseEntity<Object>(map,httpStatus);
    }
}
