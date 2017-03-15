package com.pl.springboot.mvc.jpa.dao;

import com.pl.springboot.mvc.jpa.model.JobTitle;
import org.springframework.data.repository.CrudRepository;

public interface JobTitleDao extends CrudRepository<JobTitle,Long>{
    public JobTitle getJobTitleById(int id);
}
