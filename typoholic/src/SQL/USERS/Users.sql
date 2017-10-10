-- 테이블 삭제
drop table Users
CASCADE;

--테이블 생성
CREATE TABLE Users(
	email VARCHAR(50) NOT NULL,
	nickname VARCHAR(10) NOT NULL,
	password VARCHAR(64) NOT NULL,
	auth SMALLINT(3) UNSIGNED DEFAULT 1 NOT NULL,
	status SMALLINT(3) UNSIGNED DEFAULT 1 NOT NULL,
	PRIMARY KEY (email)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--데이터 조회
SELECT * FROM USERS;

--데이터 입력
INSERT INTO Users(
			email, nickname, password, auth
		)
		VALUES(
			'bouncewind0105@gmail.com', '운영자', SHA2('m4988305', 256), 3
		)