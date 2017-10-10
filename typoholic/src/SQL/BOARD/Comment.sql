-- 테이블 삭제
drop table comments
CASCADE;

--테이블 생성
CREATE TABLE comments(
	postSeq INT(10) UNSIGNED NOT NULL,
	groupNo INT(10) UNSIGNED NOT NULL,
	depth VARCHAR(10) DEFAULT '0' NOT NULL,
	commentSeq INT(10) UNSIGNED NOT NULL AUTO_INCREMENT,
	status VARCHAR(255) DEFAULT 'published' NOT NULL,
	userId VARCHAR(255) NOT NULL,
	content VARCHAR(255) NOT NULL,
	createAt TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
	updatedAt TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
	PRIMARY KEY (commentSeq),
	FOREIGN KEY(postSeq) REFERENCES posts(seq) ON UPDATE CASCADE ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--시퀀스 생성
call create_sequence('commentSeq');

--시퀀스 호출
--nextval('commentSeq'), currval('commentSeq')