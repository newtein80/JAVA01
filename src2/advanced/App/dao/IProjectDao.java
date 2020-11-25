package advanced.App.dao;

import java.util.Collection;

import advanced.App.dto.Project;

public interface IProjectDao {
    public void addProject(Project project);
    public Project getProject(int id);
    public void updateProject(Project project);
    public void deleteProject(int id);
    public Collection<Project> getProjectList();
    public void close();
}
