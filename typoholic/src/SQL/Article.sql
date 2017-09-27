-- 테이블 삭제
drop table article
CASCADE;

--테이블 생성
CREATE TABLE article(
	boardSeq INT(10) UNSIGNED NOT NULL,
	articleGroupNo INT(10) UNSIGNED NOT NULL,
	articleShape VARCHAR(10) DEFAULT '' NOT NULL,
	articleSeq INT(10) UNSIGNED NOT NULL AUTO_INCREMENT,
	status VARCHAR(255) DEFAULT 'published' NOT NULL,
	userId VARCHAR(255) NOT NULL,
	title VARCHAR(255) NOT NULL,
	content VARCHAR(255) NOT NULL,
	readCount INT(10) UNSIGNED NOT NULL,
	createAt TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
	updatedAt TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
	PRIMARY KEY (articleSeq),
	FOREIGN KEY(boardSeq) REFERENCES board(boardSeq) ON UPDATE CASCADE ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--더미데이터 넣기
INSERT INTO article(boardSeq,articleGroupNo,userId,title,content)
values(
		1,
		(select ifnull(max(articleSeq), 0)+1 from article),
		'asdf',
		'asdf',
		'asdf'
);

--시퀀스 생성
call create_sequence('articleSeq');

