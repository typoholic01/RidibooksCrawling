CREATE TABLE ridibooks(
	category VARCHAR(255) NOT NULL,
	rank INT(10) UNSIGNED NOT NULL,
	cover VARCHAR(255) NOT NULL,
	title VARCHAR(255) NOT NULL,
	author VARCHAR(255) NOT NULL,
	star DOUBLE(4,2),
	starredPerson INT(10) UNSIGNED,
	link VARCHAR(255) NOT NULL,
	PRIMARY KEY (rank)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

drop table ridibooks;

--조회용
SELECT * FROM ridibooks 

SELECT * FROM ridibooks 
where starredPerson > 9 order by star desc;

delete from ridibooks;