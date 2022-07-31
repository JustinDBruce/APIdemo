package com.example.demo.controller;

import com.example.demo.entity.apiEntriesWrapper;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;

@Controller
public class homeController {


    @GetMapping("/")
    public String index(Model model){
        return "start";
    }

    @GetMapping("/apiCall")
    public String apiCall(Model model) throws JsonProcessingException {
        //create a mapper to map json string to POJO
        ObjectMapper mapper = new ObjectMapper();
        //Create headers for api call
        HttpHeaders headers = new HttpHeaders();
        headers.add("user-agent", "Application");
        HttpEntity<String> entity = new HttpEntity<>(headers);

        String url = "https://api.publicapis.org/entries";
        //Create a rest tempplate to call api and get a String object in return
        RestTemplate restTemplate = new RestTemplate();
        String payload = restTemplate.exchange(url, HttpMethod.GET, entity, String.class).getBody();

        //Fill mapper with payload
        apiEntriesWrapper apiEntriesWrapper = mapper.readValue(payload, apiEntriesWrapper.class);

        //Add list of apiEntries to model for result page to build a table
        model.addAttribute("apiList", apiEntriesWrapper.getApiEntries());
        return "results";
    }

}
