package ru.rest.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.Data;

@Data
@JsonDeserialize
public class Client {

    private Integer id;
    @JsonProperty(defaultValue = "name")
    private String name;
    @JsonProperty(defaultValue = "email")
    private String email;
    @JsonProperty(defaultValue = "phone")
    private String phone;
}
