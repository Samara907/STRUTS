create table sboard(
	no number primary key,
	subject varchar2(100),
	name varchar2(100),
	password varchar2(100),
	content varchar2(4000),
	file_orgname varchar2(100),
	file_savname varchar(100),
	readhit number default 0,
	regdate date default sysdate
);