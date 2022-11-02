create database java3
go
use java3
go


CREATE TABLE DaoTao(
	student_id varchar(10) primary key,
	name nvarchar(50) not null,
	phone nvarchar(15) not null,
	sex nvarchar(15) not null,
	dateOfBirth date not null,
	address nvarchar(50) not null,
	note nvarchar(550) not null
)

CREATE TABLE GiangVien(
	id int identity primary key,
	student_id varchar(10) foreign key references DaoTao(student_id),
	en float null,
	it float null,
	java float null
	
)
delete from DaoTao
-- rese
DBCC CHECKIDENT ('DaoTao', RESEED, 0);
CREATE TABLE USERS(
	username nvarchar(50) primary key,
	password nvarchar(50) null,
	role nvarchar(50) null
)select * from daoTao
select * from GiangVien
select * from USERS

select * from USERS where username = ? and password = ? and role = ?

insert into USERS(username,password,role) values(N'daoTao',N'123',N'DaoTao'),
                                                (N'giangVien',N'456',N'GiangVien')

select daoTao.student_id , daoTao.name , en,it,java, AVG(en+it+java)/3 as DiemTb 
from daoTao join GiangVien on daoTao.student_id = GiangVien.student_id 
group by daoTao.student_id , daoTao.name , en,it,java
insert into DaoTao(student_id,name,phone,sex,dateOfBirth,address,note) values('PH01',N'Công Tiến','0387627207',N'Nam','2003-06-24',N'Thái Bình',N'Đẹp Trai'),
                                                                             ('PH02',N'Linh Anh','0444627207',N'Nữ','2003-04-14',N'Hà Nội',N'Xinh'),
																			 ('PH03',N'Hạnh','037434207',N'Nữ','2002-01-24',N'Thái Bình',N'Đẹp')
insert into GiangVien(student_id) values('PH01'),
                                        ('PH02'),
										('PH03')
select top 3 GiangVien.student_id, name ,en,it,java ,avg(en+it+java)/3 as diemTB 
from GiangVien join DaoTao on GiangVien.student_id = DaoTao.student_id 
group by GiangVien.student_id,name,en,it,java 
order by diemTB desc

















