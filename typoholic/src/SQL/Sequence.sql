--데이터 삭제
delete from sequences

--테이블 생성
CREATE TABLE sequences ( 
name varchar(32), 
currval BIGINT UNSIGNED 
) ENGINE=InnoDB;

--테이블 조회
select * from sequences

--시퀀스 생성 프로시저
DELIMITER $$
 CREATE PROCEDURE `create_sequence`(IN the_name text)
 MODIFIES SQL DATA
 DETERMINISTIC
 BEGIN
     DELETE FROM sequences WHERE name=the_name;
     INSERT INTO sequences VALUES (the_name, 0);
 END
 
--시퀀스 현재값 프로시저
DELIMITER $$
 CREATE FUNCTION `currval`(the_name varchar(32))
 RETURNS BIGINT UNSIGNED
 MODIFIES SQL DATA
 DETERMINISTIC
 BEGIN
     DECLARE ret BIGINT UNSIGNED;
     SELECT currval INTO ret FROM sequences WHERE name=the_name limit 1;
     RETURN ret;
 END
 
--시퀀스 다음값 프로시저
DELIMITER $$
 CREATE FUNCTION `nextval`(the_name varchar(32))
 RETURNS BIGINT UNSIGNED
 MODIFIES SQL DATA
 DETERMINISTIC
 BEGIN
     DECLARE ret BIGINT UNSIGNED;
     UPDATE sequences SET currval=currval+1 WHERE name=the_name;
     SELECT currval INTO ret FROM sequences WHERE name=the_name limit 1;
     RETURN ret;
 END

 
--프로시저 실행권한 주기
GRANT SELECT, INSERT, UPDATE, DELETE ON mysql.proc to userid IDENTIFIED BY ‘password‘;

--시퀀스 생성 실행
call create_sequence('postSeq');

--시퀀스 현재값 실행
select currval('postSeq') from dual;

--시퀀스 다음값 실행
select nextval('articleSeq') from dual;