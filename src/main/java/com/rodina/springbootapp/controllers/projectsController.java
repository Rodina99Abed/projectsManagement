package com.rodina.springbootapp.controllers;

import com.rodina.springbootapp.models.Project;
import com.rodina.springbootapp.reposotories.ProjectsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class projectsController {
    @Autowired
    ProjectsRepository projectsRepository;

    @RequestMapping("/projects/new/{name}/{details}")
    public String newProject(@PathVariable String name,
                             @PathVariable String details){
        Project project = new Project();
        project.setName(name);
        project.setDetails(details);
        projectsRepository.save(project);
        return "Saved successfully!";
    }

    @RequestMapping("/projects/recent")
    public String recentProjects(){
        List<Project> projecstList = projectsRepository.findAll();
        String str = "";

        for (Project p: projecstList){
            str += p + "<br>";
        }

        return str;
    }

    @RequestMapping("/projects/{id}")
    public String newProject(@PathVariable Integer id){
        Project project = projectsRepository.findById(id).get();
        return project.toString();
    }
}
