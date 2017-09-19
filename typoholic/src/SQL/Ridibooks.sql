CREATE TABLE ridibooks(
	category VARCHAR(255) NOT NULL,
	link VARCHAR(255) NOT NULL,
	cover VARCHAR(255) NOT NULL,
	title VARCHAR(255) NOT NULL,
	author VARCHAR(255) NOT NULL,
	star DOUBLE(4,2),
	starredPerson INT(10) UNSIGNED,
	PRIMARY KEY (link)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--테이블 제거용
drop table ridibooks
CASCADE;

--조회용
SELECT * FROM ridibooks 

SELECT * FROM ridibooks 
where starredPerson > 9 order by star desc;

delete from ridibooks;

--문자열 확인
SHOW VARIABLES LIKE 'c%'