package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class apiEntriesWrapper {

    @JsonProperty("count")
    String count;

    @JsonProperty("entries")
    List<apiEntries> apiEntries;
}
