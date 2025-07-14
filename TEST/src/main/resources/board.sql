
create sequence seq_board;

drop sequence seq_board;

create table tbl_board(
	bno number(10,0), 					
	title varchar2(200) not null,		
	content varchar2(2000) not null,	
	writer varchar2(50)	not null,		
	regdate date default sysdate,		
	updatedate date default sysdate		
) 

alter table tbl_board add constraint pk_board primary key (bno);


insert into tbl_board (bno, title, content, writer)
values (seq_board.nextval, '테스트 제목1', '테스트 내용1', 'user00');

insert into tbl_board (bno, title, content, writer)
values (seq_board.nextval, '테스트 제목2', '테스트 내용2', 'user00');

insert into tbl_board (bno, title, content, writer)
values (seq_board.nextval, '테스트 제목3', '테스트 내용3', 'user00');

insert into tbl_board (bno, title, content, writer)
values (seq_board.nextval, '테스트 제목4', '테스트 내용4', 'user00');

insert into tbl_board (bno, title, content, writer)
values (seq_board.nextval, '테스트 제목5', '테스트 내용5', 'user00');

insert into tbl_board (bno, title, content, writer)
values (seq_board.nextval, '테스트 제목6', '테스트 내용6', 'user00');

select * from tbl_board