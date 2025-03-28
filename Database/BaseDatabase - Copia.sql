create database if not exists gitfit; 
use gitfit; 
create table ExercisesList (
id int auto_increment primary key, 
listName varchar(100) not null, 
length time not null
);
create table Goals ( 
id int auto_increment primary key
); 
create table Progress (
id int auto_increment primary key
); 
create table UserProfile (
id int auto_increment primary key, 
firstname varchar (50) not null,
surname varchar(50) not null, 
weight decimal(5, 2) not null, 
height int not null, 
gender boolean not null, 
eMail varchar(50) not null, 
codice varchar(50) not null); 

