package com.example.Services;

import com.example.Entity.Job;
import com.example.Entity.Status;
import com.example.Entity.User;
import com.example.Repository.JobRepository;
import com.example.Repository.StatusRepository;
import com.example.Repository.UserRepository;
import jdk.nashorn.internal.scripts.JO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {


    @Autowired
    public UserRepository userRepository;

    @Autowired
    public StatusRepository statusRepository;

    @Autowired
    public JobRepository jobRepository;


    public Iterable<User> findAll(){
        return userRepository.findAll();
    }

    public User findOneById(Integer id){
        return userRepository.findOne(id);
    }

    public User findOneByEmail(String email){
        return userRepository.findOneByEmail(email);
    }

    public void save(User user){
        userRepository.save(user);
    }

    public void delete(User user){
        userRepository.delete(user);
    }

    public void delete(Integer id){
        userRepository.delete(id);
    }

    public Status getUserStatus(Integer id){
        User user = userRepository.findOne(id);
        return statusRepository.findOne(user.getStatus_id());
    }

    public void addStatusOnline(Integer id){
        User user = userRepository.findOne(id);
        user.setStatus_id(1);
        userRepository.save(user);
    }

    public void addStatusOffline(Integer id ){
        User user = userRepository.findOne(id);
        user.setStatus_id(2);
        userRepository.save(user);
    }

    public Iterable<Job> getAllJobsByUserId(Integer id){
        return jobRepository.findAllByUser(id);
    }




}
