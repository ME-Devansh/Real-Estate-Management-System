drop database if exists db_re;
create database db_re;
use db_re;
create table Agent(
	agent_id integer(5) primary key,
	agent_name varchar(30) not null,
	agent_contact varchar(10)
	);
create table Property(
	reg_no integer(5) primary key,
	cost integer(10),
	status varchar(5),
	locality varchar(20),
	size integer(5),
	no_bedrooms integer(2),
	address varchar(30)
	);
create table Rental(
	reg_no integer(5) primary key,
	rent integer(10),
	status varchar(5),
	locality varchar(20),
	size integer(5),
	no_bedrooms integer(2),
	address varchar(30)
	);
create table Handles_property(
	agent_id integer(5),
	reg_no integer(5),
	foreign key(agent_id) references Agent(agent_id),
	foreign key(reg_no) references Property(reg_no),
	primary key(agent_id,reg_no)
	);
create table Handles_rental(
	agent_id integer(5),
	reg_no integer(5),
	foreign key(agent_id) references Agent(agent_id),
	foreign key(reg_no) references Rental(reg_no),
	primary key(agent_id,reg_no)
	);
create table Sold(
	agent_id integer(5),
	reg_no integer(5),
	selling_date varchar(10),
	foreign key(agent_id) references Agent(agent_id),
	foreign key(reg_no) references Property(reg_no),
	primary key(agent_id,reg_no,selling_date)
	);
create table Rented(
	agent_id integer(5),
	reg_no integer(5),
	start_date varchar(10),
	end_date varchar(10),
	foreign key(agent_id) references Agent(agent_id),
	foreign key(reg_no) references Rental(reg_no),
	primary key(agent_id,reg_no,start_date)
	);

