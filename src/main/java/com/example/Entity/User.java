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
    private  @Getter @Setter Integer user_id;

    @Column
    private @Getter @Setter String username;

    @Column
    @ApiModelProperty(dataType = "string", value = "Email Address")
    private @Getter @Setter String email;

    @Column
    @JsonIgnore
    private @Getter @Setter String password;

    @Column
    private @Getter @Setter String telephone;

    @Column
    @GeneratedValue
    private @Getter @Setter Timestamp registration_date;

    @JoinColumn(name = "user_status", referencedColumnName = "status id")
    @Column
    private @Getter @Setter Integer status_id;

    public User(){
    }

    public User(String username, String email, String password, String telephone, Integer status_id) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.telephone = telephone;
        this.status_id = status_id;
    }



}
