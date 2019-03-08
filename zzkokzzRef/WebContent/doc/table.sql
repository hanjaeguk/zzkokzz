drop table member_detail;

drop table member;

create table member
(
	id varchar2(16),
	name varchar2(20),
	pass varchar2(16),
	email1 varchar2(16),
	email2 varchar2(30),
	joindate date default sysdate,
	constraint member_id_pk primary key (id)
);

create table member_detail
(
	id varchar2(16),
	tel1 varchar2(3),
	tel2 varchar2(4),
	tel3 varchar2(4),
	zip1 varchar2(3),
	zip2 varchar2(3),
	address varchar2(100),
	address_detail varchar2(100),
	constraint member_detail_id_fk foreign key (id)
	references member (id) 
);

create table zipcode
(
 	zipcode varchar2(7),
 	sido varchar2(30),
 	gugun varchar2(30),
 	dong varchar2(30),
 	bunji varchar2(100),
 	seq number,
 	constraint zipcode_seq_pk primary key (seq)
);

















