# Book schema

# --- !Ups

create table book (
    id integer(20) NOT NULL AUTO_INCREMENT,
    title varchar(255),
    isbn13 varchar(20),
    isbn10 varchar(20),
    description varchar(1000),
    publisher varchar(255),
    pages integer NOT NULL,
    PRIMARY KEY (id)
);

# --- !Downs

drop table book;