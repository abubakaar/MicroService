package com.example.classservice.repository;

import com.example.classservice.model.ClassModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ClassRepo extends JpaRepository<ClassModel, Integer> {

    Optional<ClassModel> findByLevel(int level);
}
