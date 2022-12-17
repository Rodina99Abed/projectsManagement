package com.rodina.springbootapp.reposotories;

import com.rodina.springbootapp.models.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectsRepository extends JpaRepository<Project, Integer> {

}
