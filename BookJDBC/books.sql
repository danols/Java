create database books;
use books;
create table category (
    id int not null auto_increment,
    category_description varchar(20) not null,
    primary key(id)
);

create table book (
    id int not null auto_increment,
    category_id int not null,
    book_title varchar(60) not null,
    publisher varchar(60) not null,
    primary key(id),
    constraint fk_book foreign key (category_id) references category(id)
);

create table author (
    id int not null auto_increment,
    book_id int not null,
    first_name varchar(20) not null,
    last_name varchar(20) not null,
    primary key(id),
    constraint fk_author foreign key (book_id) references book(id)
);

insert into category (category_description) values ('Clojure');
insert into category (category_description) values ('Groovy');
insert into category (category_description) values ('Java');
insert into category (category_description) values ('Scala');

insert into book (category_id, book_title, publisher) values (1, 'Practical Clojure', 'Apress');
insert into book (category_id, book_title, publisher) values (2, 'Beginning Groovy, Grails and Griffon', 'Apress');
insert into book (category_id, book_title, publisher) values (2, 'Definitive Guide to Grails 2','Apress');
insert into book (category_id, book_title, publisher) values (2, 'Groovy and Grails Recipes','Apress');
insert into book (category_id, book_title, publisher) values (3, 'Modern Java Web Development','Apress');
insert into book (category_id, book_title, publisher) values (3, 'Java 7 Recipes', 'Apress');
insert into book (category_id, book_title, publisher) values (3, 'Java EE 7 Recipes', 'Apress');
insert into book (category_id, book_title, publisher) values (3, 'Beginning Java 7 ', 'Apress');
insert into book (category_id, book_title, publisher) values (3, 'Pro Java 7 NIO.2', 'Apress');
insert into book (category_id, book_title, publisher) values (3, 'Java 7 for Absolute Beginners','Apress');
insert into book (category_id, book_title, publisher) values (3, 'Oracle Certified Java Enterprise Architect Java EE7', 'Apress');
insert into book (category_id, book_title, publisher) values (4, 'Beginning Scala', 'Apress');

insert into Author (BOOK_ID, FIRST_NAME, LAST_NAME) values (1, 'Luke', 'VanderHart');
insert into Author (BOOK_ID, FIRST_NAME, LAST_NAME) values (2, 'Vishal', 'Layka');
insert into Author (BOOK_ID, FIRST_NAME, LAST_NAME) values (3, 'Jeff', 'Brown');
insert into Author (BOOK_ID, FIRST_NAME, LAST_NAME) values (4, 'Bashar', 'Jawad');
insert into Author (BOOK_ID, FIRST_NAME, LAST_NAME) values (5, 'Vishal', 'Layka');
insert into Author (BOOK_ID, FIRST_NAME, LAST_NAME) values (6, 'Josh', 'Juneau');
insert into Author (BOOK_ID, FIRST_NAME, LAST_NAME) values (7, 'Josh', 'Juneau');
insert into Author (BOOK_ID, FIRST_NAME, LAST_NAME) values (8, 'Jeff', 'Friesen');
insert into Author (BOOK_ID, FIRST_NAME, LAST_NAME) values (9, 'Anghel', 'Leonard');
insert into Author (BOOK_ID, FIRST_NAME, LAST_NAME) values (10, 'Jay', 'Bryant');
insert into Author (BOOK_ID, FIRST_NAME, LAST_NAME) values (11, 'B V', 'Kumar');
insert into Author (BOOK_ID, FIRST_NAME, LAST_NAME) values (12, 'David', 'Pollak');
