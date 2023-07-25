create table emp(
emp_id int not null,
emp_name varchar(50) not null,
emp_salary double precision not null,
emp_designation varchar(50) not null
);
create table designationTable(designationname varchar(50) not null);

create table users(
username varchar(50) not null,
password varchar(50) not null,
enabled boolean not null,
role varchar(50)
)