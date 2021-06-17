package com.techelevator.projects.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.sql.DataSource;

import com.techelevator.projects.model.Department;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import com.techelevator.projects.model.Project;

public class JdbcProjectDao implements ProjectDao {

	private final JdbcTemplate jdbcTemplate;

	public JdbcProjectDao(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public Project getProject(Long projectId) {
		Project project = null;
		String sql = "SELECT project_id, name, from_date, to_date " +
				"FROM project " +
				"WHERE project_id =?; ";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sql, projectId);
		if (results.next()) {
			project = mapRowToProject(results);
		}
		return project;

	}

	@Override
	public List<Project> getAllProjects() {
		List<Project> project = new ArrayList();
		String sql = "SELECT project_id, name, from_date, to_date FROM project;";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
		while(results.next()){
			project.add(mapRowToProject(results));
		}
		return project;

	}

	@Override
	public Project createProject(Project newProject) {
		String sql = "INSERT INTO project (project_id, name, from_date, to_date) VALUES (?, ?,?,?)";
		int rows = jdbcTemplate.update(sql, newProject.getId(), newProject.getName(), newProject.getFromDate(), newProject.getToDate());
		return newProject;
		}


	@Override
	public void deleteProject(Long projectId) {
		String sql = "DELETE FROM project_employee WHERE project_id = ?;";
		jdbcTemplate.update(sql, projectId);
		sql = "DELETE FROM project WHERE project_id = ?;";
		jdbcTemplate.update(sql, projectId);
	}

	private Project mapRowToProject(SqlRowSet rowSet) {
		Project project = new Project();

		project.setName(rowSet.getString("name"));
		project.setId(rowSet.getLong("project_id"));
		if (!(rowSet.getDate("from_date") ==null)) {
			project.setFromDate(rowSet.getDate("from_date").toLocalDate());
		};
		if (!(rowSet.getDate("to_date") ==null)) {
			project.setToDate(rowSet.getDate("to_date").toLocalDate());
		};
		return project;
	}
}
