package com.myproject.ppmtool.services;

import com.myproject.ppmtool.domain.Project;
import com.myproject.ppmtool.exceptions.ProjectIdException;
import com.myproject.ppmtool.repositories.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    public Project findProject(String id){
       return projectRepository.findById(Long.parseLong(id)).get();
    }

    public Project findProjectByIdentitifer(String projectId){

        Project project= projectRepository.findByProjectIdentifier(projectId.toUpperCase());

        if(project==null){
            throw new ProjectIdException("Project ID '"+ projectId.toUpperCase()+"' doesn't exist");

        }
        return project;
    }
    public Project saveOrUpdateProject(Project project){

        try{
            project.setProjectIdentifier(project.getProjectIdentifier().toUpperCase());
            return projectRepository.save(project);
        }catch(Exception e){
            throw new ProjectIdException("Project ID '"+ project.getProjectIdentifier().toUpperCase()+"' already exists");
        }
    }
}
