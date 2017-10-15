-- 테이블 삭제
drop table files
CASCADE;

--테이블 생성
CREATE TABLE files(
	seq INT(10) UNSIGNED NOT NULL,
	originalFileName VARCHAR(255) NOT NULL,
	storedFileName VARCHAR(100) NOT NULL,
	fileSize BIGINT(20) UNSIGNED NOT NULL,
	contentType VARCHAR(100) NOT NULL,
	downCount INT(10) UNSIGNED NOT NULL DEFAULT 0,
	createAt TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
	PRIMARY KEY (seq)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--시퀀스 생성
call create_sequence('fileSeq');

--파일 삽입

--테이블 조회
SELECT * FROM files