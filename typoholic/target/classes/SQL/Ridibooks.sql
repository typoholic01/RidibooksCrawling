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


SELECT category, link, cover, title, author, 
	star * starredPerson "clap"
FROM RIDIBOOKS
ORDER BY clap DESC;

SELECT category, link, cover, title, author, 
	star * starredPerson "clap"
FROM RIDIBOOKS
ORDER BY clap asc;

delete from ridibooks;

--문자열 확인
SHOW VARIABLES LIKE 'c%'

SELECT category, link, cover, title, author, star * starredPerson "clap"
FROM RIDIBOOKS
ORDER BY clap DESC
LIMIT 0, 10;

--업데이트용
		UPDATE ridibooks
		SET category = 'fantasy'
		WHERE category = '판타지'