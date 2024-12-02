package com.example.hiringProcess.Evaluation;

import jakarta.persistence.*;
//import org.springframework.data.annotation.Id;

import java.util.ArrayList;
import java.util.List;


@Entity
@Table
public class Evaluation {
    @Id
    @SequenceGenerator(
            name = "candidate_sequence",
            sequenceName = "candidate_sequence",
            allocationSize = 1

    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "candidate_sequence"
    )

    private int id;
    private String name;

    //  private List<String> uploadedFiles;
    public Evaluation(int id, String name) {
        this.name = name;
        this.id = id;
        // this.uploadedFiles = getUploadedFiles();
    }

    public Evaluation(String name) {
        this.name = name;
        // this.uploadedFiles = getUploadedFiles();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Candidate{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}

