TRUNCATE employee, department, project, project_employee, timesheet CASCADE;

-- Need a department so we can add employees
INSERT INTO department (department_id, name)
VALUES (1, 'Department 1');

-- Need employees so we can add timesheets
INSERT INTO employee (employee_id, department_id, first_name, last_name, birth_date, hire_date)
VALUES (1, 1, 'First1', 'Last1', '1981-01-01', '2001-01-02'),
       (2, 1, 'First2', 'Last2', '1982-02-01', '2002-02-03');

-- Need projects so we can add timesheets
INSERT INTO project (project_id, name, from_date, to_date)
VALUES (1, 'Project 1', '2000-01-02', '2000-12-31'),
       (2, 'Project 2', NULL, NULL);

INSERT INTO timesheet (timesheet_id, employee_id, project_id, date_worked, hours_worked, billable, description)
VALUES (1, 1, 1, '2021-01-01', 1.0, true, 'Timesheet 1'),
       (2, 1, 1, '2021-01-02', 1.5, true, 'Timesheet 2'),
       (3, 2, 1, '2021-01-01', 0.25, true, 'Timesheet 3'),
       (4, 2, 2, '2021-02-01', 2.0, false, 'Timesheet 4');

ALTER SEQUENCE timesheet_timesheet_id_seq RESTART WITH 10; -- make sure there's no chance new records will have conflicting ids
