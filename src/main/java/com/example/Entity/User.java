package com.example.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import jdk.nashorn.internal.scripts.JO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

@Entity
@Table(name = "users")
@JsonIgnoreProperties(ignoreUnknown = true)
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @ApiModelProperty(dataType = "integer", value = "Customer ID")
    public @Getter @Setter Integer user_id;

    @Column
    public @Getter @Setter String username;

    @Column
    @ApiModelProperty(dataType = "string", value = "Email Address")
    public @Getter @Setter String email;

    @Column
    //@JsonIgnore
    public @Getter @Setter String password;

    @Column
    public @Getter @Setter String telephone;

    @Column
    @GeneratedValue
    public @Getter @Setter Timestamp registration_date;

    @Column
    public @Getter @Setter String status;

    public User(){
    }

    public User(String username, String email, String password, String telephone, String status) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.telephone = telephone;
        this.status = status;
    }



}
