create user book_ex identified by book_ex
default tablespace users temporary tablespace temp 
--계정 및 암호 생성 기본 테이블과 임시 테이블 전달

grant connect, dba to book_ex 
--접근권한과 dba권한 부여

select dbms_xdb.gethttpport() from dual; --오라클 포트 확인
exec dbms_xdb.sethttopport(9999); --cmd용