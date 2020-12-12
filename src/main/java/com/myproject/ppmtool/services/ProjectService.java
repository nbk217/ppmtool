package com.myproject.ppmtool.services;

import com.myproject.ppmtool.domain.Project;
import com.myproject.ppmtool.repositories.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

//    public void findAllProjects(Long id){
//
//       return projectRepository.findAllById(id);
//    }

    public Project saveOrUpdateProject(Project project){

        return projectRepository.save(project);
    }
}
