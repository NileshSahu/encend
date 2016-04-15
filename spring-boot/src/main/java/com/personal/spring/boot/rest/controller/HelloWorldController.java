package com.personal.spring.core.rest.controller;

import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.Date;

/**
 * Created by Nilesh on 3/24/2016.
 */
@RestController
public class HelloWorldController {

    @RequestMapping(value = "/hello", method = {RequestMethod.GET})
    public @ResponseBody Response helloWorld(@RequestParam(name = "name")String name) throws IOException {
        Response response = new Response();
        response.setResponse(new String("result:Hello "+   name +" at "+new Date()));
        return response;
    }

    @RequestMapping(value = "/hello/{name}", method = {RequestMethod.GET},  consumes = "application/xml", produces = {"text/plain", "application/*"})
    public @ResponseBody String helloWorldName(@PathVariable("name") String name){
        return "Hello "+   name +" at "+new Date();
    }

    private class Response{

        private String response;

        public String getResponse() {
            return response;
        }

        public void setResponse(String response) {
            this.response = response;
        }
    }
}
