package com.pl.springboot.mvc.jpa.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "jobtitle")
@AllArgsConstructor
@NoArgsConstructor
@Data
@NamedQuery(name = "JobTitle.getJobTitleById",
            query = "Select jt From JobTitle jt Where id_job_title = ?1")
public class JobTitle {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id_job_title;

    private String name;

}
