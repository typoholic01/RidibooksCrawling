-- 테이블 삭제
drop table boards
CASCADE;

-- 테이블 생성
CREATE TABLE boards(
	boardUrl VARCHAR(10) NOT NULL,
	createAt TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
	updatedAt TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
	PRIMARY KEY (boardUrl)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--테이블 조회
SELECT * FROM board;

--자동생성
INSERT INTO boards(boardUrl)
values('free');