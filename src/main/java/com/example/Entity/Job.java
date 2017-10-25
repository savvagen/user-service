package com.example.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "jobs")
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Job {

    @Id
    private  @Getter @Setter Integer job_id;

    @JoinColumn(name = "users", referencedColumnName = "user_id")
    @Column
    private @Getter @Setter Integer user;

    @Column
    private @Getter @Setter String company;

    @Column
    private @Getter @Setter String position;

    @Column
    @JsonIgnore
    private @Getter @Setter Integer salary;

    @Column
    private  @Getter @Setter String responsibilities;




}
