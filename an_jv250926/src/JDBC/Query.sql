create database db_degree__management ;
use db_degree__management ;

create table degrees(
    degree_id int primary key auto_increment,
    degree_name varchar(150) not null,
    emp_id varchar(15) not null,
    degree_date datetime not null,
    school_name varchar(100) not null,
    degree_year int not null,
    degree_classification varchar(20) not null
);

-- Procedure thực hiện lấy danh sách tất cả các bằng cấp.
    delimiter $$
    create procedure getAllDegrees()
    begin
        select * from degrees;
    end ;
    delimiter $$
--  Procedure thực hiện thêm mới một bằng cấp
delimiter $$
create procedure addNewDegrees(degree_name_in varchar(150),emp_id_in varchar(15),
                               degree_date_in datetime,school_name_in varchar(100),
                               degree_year_in int ,degree_classification_in varchar(20))
begin
    insert into degrees (degree_name, emp_id, degree_date, school_name, degree_year, degree_classification)
        values (
                   degree_name_in,emp_id_in,degree_date_in,school_name_in,
                   degree_year_in,degree_classification_in
               );
end ;
delimiter $$
-- Procedure thực hiện lấy thông tin bằng cấp theo emp_id
delimiter $$
create procedure getDegreeByEmId(in empID varchar(15))
begin
    select * from degrees where emp_id = empID;
end ;
delimiter $$
-- Procedure thực hiện cập nhật thông tin bằng cấp
delimiter $$
create procedure updateDegrees(degree_id_in int,degree_name_in varchar(150),emp_id_in varchar(15),
                               degree_date_in datetime,school_name_in varchar(100),
                               degree_year_in int ,degree_classification_in varchar(20))
begin
    update degrees
        set
            degree_name = degree_name_in,
            emp_id =emp_id_in,
            degree_date = degree_date_in,
            school_name = school_name_in,
            degree_year = degree_year_in,
            degree_classification = degree_classification_in
    where degree_id = degree_id_in;
end ;
delimiter $$
-- Procedure thực hiện tìm kiếm bằng cấp theo degree_name (Tìm gần đúng)
delimiter $$
create procedure findDegreesByName(in findDegreeName varchar (150))
begin
    select * from degrees
        where LOWER(degree_name) LIKE  LOWER (concat('%',findDegreeName,'%'));
end ;
delimiter $$
-- Procedure thực hiện xóa bằng cấp
delimiter $$
create procedure deleteDegreeById(in degreeID int)
begin
    delete from degrees where degree_id = degreeID;
end ;
delimiter $$
