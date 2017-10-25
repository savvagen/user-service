package com.example.Repository;

import com.example.Entity.Job;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface JobRepository extends CrudRepository<Job, Integer> {

    Iterable<Job> findAllByUser(Integer id);


}
