package com.example.Entity;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user_status")
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Status {

    @Id
    private @Getter @Setter Integer status_id;
    @Column
    private @Getter @Setter String status;

    public Status(){}

    public Status(Integer status_id, String status) {
        this.status_id = status_id;
        this.status = status;
    }
}
