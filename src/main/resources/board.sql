--시퀀스 객체 생성
create sequence seq_board;
--시퀀스 삭제 (추후 활용)
drop sequence seq_board;

create table tbl_board(
	bno number(10,0), 					--게시물번호
	title varchar2(200) not null,		--게시물제목
	content varchar2(2000) not null,	--게시물내용
	writer varchar2(50)	not null,		--작성자 (차후 member와 연동)
	regdate date default sysdate,		--작성일 (자동으로 db날짜 입력)
	updatedate date default sysdate		--수정일 (자동으로 db날짜 입력)
) -- board 테이블 생성

alter table tbl_board add constraint pk_board primary key (bno);
 -- tbl_board 구조변경(수정) 기본키를 bno로 지정함.

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