--테이블 삭제
drop table postfiles
CASCADE;

--테이블 생성
CREATE TABLE postfiles(
	postSeq INT(10) UNSIGNED NOT NULL,
	fileSeq INT(10) UNSIGNED NOT NULL,
	PRIMARY KEY (postSeq, fileSeq),
	FOREIGN KEY (postSeq) REFERENCES Posts(seq) ON UPDATE CASCADE ON DELETE CASCADE,
	FOREIGN KEY (fileSeq) REFERENCES files(seq) ON UPDATE CASCADE ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--테이블 조회
SELECT * FROM postfiles