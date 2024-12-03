create database practice;
use practice;
CREATE TABLE Employees(
empId int primary key auto_increment,
empName varchar(50) not null,
doj date not null,
deptId int not null,
deptName varchar(20),
salary double not null,
 foreign key (deptId) references Departments(deptId)
);

CREATE TABLE Departments(
deptId int primary key,
deptName varchar(20),
deptManager varchar(25)
);

-- Insert 10 departments into the Departments table
INSERT INTO Departments (deptId, deptName, deptManager)
VALUES
    (1, 'Sales', 'Alice Johnson'),
    (2, 'Marketing', 'Bob Smith'),
    (3, 'IT', 'Charlie Brown'),
    (4, 'HR', 'Diana Lee'),
    (5, 'Finance', 'Edward Davis'),
    (6, 'Operations', 'Frank Miller'),
    (7, 'Customer Support', 'Grace Taylor'),
    (8, 'Legal', 'Hannah Clark'),
    (9, 'Research', 'Isaac Moore'),
    (10, 'Procurement', 'Jackie Green');
    
    -- Inserting 10 employees into Employees table
INSERT INTO Employees (empName, doj, deptId, deptName, salary)
VALUES
    ('John Doe', '2020-01-15', 1, 'Sales', 55000.00),
    ('Sarah Williams', '2021-06-20', 2, 'Marketing', 60000.00),
    ('Michael Brown', '2022-03-05', 3, 'IT', 75000.00),
    ('Emily Davis', '2019-09-10', 4, 'HR', 48000.00),
    ('David Wilson', '2021-12-12', 5, 'Finance', 80000.00),
    ('Sophia Martinez', '2023-02-18', 6, 'Operations', 67000.00),
    ('James Taylor', '2022-07-25', 7, 'Customer Support', 42000.00),
    ('Linda Anderson', '2020-08-30', 8, 'Legal', 95000.00),
    ('Daniel Lee', '2019-11-05', 9, 'Research', 72000.00),
    ('Olivia Clark', '2023-04-10', 10, 'Procurement', 60000.00);
--     1. Write a query to display all rows and columns from the employees table.
    select * from Employees;
    
--     2. Retrieve only the name and salary of all employees from the employees table.
select empName,salary from Employees;

-- 3. Write a query to find all employees whose salary is greater than 50,000.
select empName from Employees where salary>50000;
-- 4. List all employees who joined the company in the year 2020.
select empName from Employees where year(doj)=2020;

-- 5. Retrieve the details of employees whose names start with the letter 'A'.
select empName from Employees where empName like "a%";

-- 1. Write a query to calculate the average salary of all employees.
select avg(salary) from Employees;

-- 2. Find the total number of employees in the company.
select count(empId) from Employees;
-- 3. Write a query to find the highest salary in the employees table.
select max(salary) from Employees;
-- 4. Calculate the total salary paid by the company for all employees.
select sum(salary) from Employees;
-- 5. Find the count of employees in each department.
select deptName,count(*) from Employees group by deptName;

-- 1. Write a query to retrieve employee names along with their department names (using employees and departments tables).
select Employees.empName, Departments.deptName from Employees right join Departments on Departments.deptId=Employees.deptId;

-- 2. List all employees who have a manager (self-join on employees table).
select empName from Employees where deptId in (select deptId from Departments where deptManager <>" ");
select a.empName,a.deptId,b.deptManager from Employees a, Departments b where a.deptId=b.deptId and b.deptManager<>" ";
-- 3. Find the names of employees who are working on multiple projects (using employees and projects tables).
CREATE TABLE Projects(
projectId varchar(5) primary key,
proName varchar(20),
empId int
);
alter table Projects modify column proName varchar(50); 
INSERT INTO Projects (projectId, proName, empId)
VALUES
    ('P001', 'Website Redesign', 11),
    ('P002', 'Marketing Campaign', 12),
    ('P003', 'Server Upgrade', 11),
    ('P004', 'Employee Recruitment', 14),
    ('P005', 'Quarterly Financial Report', 25),
    ('P006', 'Supply Chain Optimization', 26),
    ('P007', 'Customer Support System', 25),
    ('P008', 'Legal Compliance Audit', 16),
    ('P009', 'Product Research', 12),
    ('P010', 'Procurement Strategy', 29);
-- select a.empName,count(b.proName) from Employees a, Projects b where a.empId=b.empId group by (select * from b having count(b.empId)>1);
SELECT a.empName, COUNT(b.proName) AS project_count FROM Employees a JOIN Projects b ON a.empId = b.empId GROUP BY a.empName HAVING COUNT(b.proName) > 1;

-- 4. Write a query to display all projects and the employees assigned to them.
select a.proName, b.empName from Projects a, Employees b where a.empId=b.empId;

-- 5. Retrieve the names of employees who do not belong to any department.
select a.empName from Employees a join Departments b on a.deptId = b.deptId where a.deptId is null;

-- 1. Write a query to find the employees with the second-highest salary.
select empId,empName,salary from Employees where salary = (select max(salary) from Employees where salary <(select max(salary) from Employees));

-- 2. Retrieve the names of employees whose salary is above the department average salary.

-- 3. Find employees who earn more than the average salary of the entire company.
select empName, salary from Employees where salary > (select avg(salary) from Employees);
select avg(salary) from Employees;
-- 4. Write a query to find the department with the highest number of employees.
SELECT e.deptName, COUNT(*) AS num_employees FROM Employees e GROUP BY e.deptName ORDER BY num_employees DESC LIMIT 1;
-- 5. List all employees who work in a department located in 'New York'.
select e.empName from Employees e, Departments d where d.deptName="HR";

-- 1. Write a query to find employees who work in either the 'HR' or 'Finance' department.
SELECT empName, deptName
FROM Employees
WHERE deptName IN ('HR', 'Finance');

-- 2. Retrieve the names of employees who are working on both Project A and Project B.
SELECT e.empName
FROM Employees e
JOIN Projects p ON e.empId = p.empId
WHERE p.proName IN ('IT', 'HR')
GROUP BY e.empId, e.empName
HAVING COUNT(DISTINCT p.proName) = 2;
-- 3. Find employees who are not assigned to any project.
select empName from Employees e , Projects p where e.empId=p.empId and p.proName=" ";

-- 4. Write a query to get all unique job titles across all departments.
SELECT DISTINCT deptName FROM Employees;

-- 5. Combine two tables (employees and former_employees) and remove duplicates.
CREATE TABLE ExEmployees (
    empId INT PRIMARY KEY,
    empName VARCHAR(50) NOT NULL,
    doj DATE NOT NULL,
    deptId INT NOT NULL,
    deptName VARCHAR(20),
    salary DOUBLE NOT NULL,
    leaveDate DATE,  -- Assuming we store when the employee left
    reasonForLeaving VARCHAR(100),
    FOREIGN KEY (deptId) REFERENCES Departments(deptId)
);
INSERT INTO ExEmployees (empId, empName, doj, deptId, deptName, salary, leaveDate, reasonForLeaving)
VALUES
    (11, 'John Doe', '2018-05-01', 1, 'Sales', 55000.00, '2022-06-30', 'Personal Reasons'),
    (12, 'Sarah Williams', '2016-08-20', 2, 'Marketing', 60000.00, '2023-01-15', 'Job Offer'),
    (13, 'Michael Brown', '2015-04-12', 3, 'IT', 75000.00, '2022-12-05', 'Retirement');
    
SELECT empId, empName, doj, deptId, deptName, salary
FROM Employees
UNION
SELECT empId, empName, doj, deptId, deptName, salary
FROM ExEmployees;

