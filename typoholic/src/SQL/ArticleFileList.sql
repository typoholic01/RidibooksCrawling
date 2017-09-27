-- 테이블 삭제
drop table articleFileList
CASCADE;

--테이블 생성
CREATE TABLE articleFileList(
	articleSeq INT(10) UNSIGNED NOT NULL,
	fileSeq INT(10) UNSIGNED NOT NULL,
	PRIMARY KEY (articleSeq,fileSeq),
	FOREIGN KEY(articleSeq) REFERENCES article(articleSeq) ON UPDATE CASCADE ON DELETE CASCADE,
	FOREIGN KEY(fileSeq) REFERENCES file(fileSeq) ON UPDATE CASCADE ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;