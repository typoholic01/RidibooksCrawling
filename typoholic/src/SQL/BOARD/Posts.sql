-- 테이블 삭제
drop table Posts
CASCADE;

--테이블 생성
CREATE TABLE Posts(
	boardUrl VARCHAR(10) NOT NULL,
	groupNo INT(10) UNSIGNED NOT NULL,
	depth VARCHAR(10) DEFAULT '0' NOT NULL,
	seq INT(10) UNSIGNED NOT NULL,
	status SMALLINT(3) UNSIGNED DEFAULT 1 NOT NULL,
	userId VARCHAR(255) NOT NULL,
	title VARCHAR(255) NOT NULL,
	content VARCHAR(255) NOT NULL,
	readCount INT(10) UNSIGNED DEFAULT 0 NOT NULL,
	createAt TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
	updateAt TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
	PRIMARY KEY (seq),
	FOREIGN KEY(boardUrl) REFERENCES boards(boardUrl) ON UPDATE CASCADE ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--더미데이터 넣기
INSERT INTO Posts(
			boardUrl,groupNo,seq,userId,title,content
		)
		VALUES(
			'free', nextval('postSeq'), currval('postSeq'), 'id', '제목', 	'내용'
		)
		
--데이터 조회
SELECT * FROM Posts;

SELECT 
	*
FROM Posts
WHERE boardUrl = 'free'
AND status = 1
ORDER BY groupNo DESC, depth ASC
LIMIT 0, 5

--데이터 삭제
delete from Posts;

--시퀀스 생성
call create_sequence('postSeq');

--갯수 세기
SELECT COUNT(seq)
		FROM Posts
		WHERE boardUrl = 'no'
		AND status = 1
