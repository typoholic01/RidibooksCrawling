-- 테이블 삭제
drop table board
CASCADE;

-- 테이블 생성
CREATE TABLE board(
	boardSeq INT(20) UNSIGNED NOT NULL AUTO_INCREMENT,
	boardName VARCHAR(255) DEFAULT 'board' NOT NULL,
	createAt TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
	updatedAt TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
	PRIMARY KEY (boardSeq)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--테이블 조회
SELECT * FROM board;

--자동생성
INSERT INTO board(boardName)
values('자유 게시판');