package com.example.Entity;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Status {

    private @Getter @Setter Integer id;
    private @Getter @Setter String status;

    public Status(){}

    public Status(Integer id, String status) {
        this.id = id;
        this.status = status;
    }
}
