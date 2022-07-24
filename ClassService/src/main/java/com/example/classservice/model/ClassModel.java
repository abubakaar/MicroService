package com.example.classservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "class_model")
public class ClassModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private int level;
}
