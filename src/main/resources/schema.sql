create table contacts (
  id identity,
  firstName varchar(30) not null,
  lastName varchar(50) not null,
  phoneNumber varchar(13),
  emailAddress varchar(30)
);

create table users (
    id identity,
    userName varchar(30) not null,
    password varchar(30) not null
);