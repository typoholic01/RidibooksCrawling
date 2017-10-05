-- 테이블 삭제
drop table Posts
CASCADE;

--테이블 생성
CREATE TABLE Posts(
	boardSeq INT(10) UNSIGNED NOT NULL,
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
	FOREIGN KEY(boardSeq) REFERENCES board(boardSeq) ON UPDATE CASCADE ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--더미데이터 넣기
INSERT INTO Posts(
			boardSeq,groupNo,seq,userId,title,content
		)
		VALUES(
			2, nextval('postSeq'), currval('postSeq'), 'id', '제목', 	'내용'
		)
		
--데이터 조회
SELECT * FROM Posts;

SELECT 
	depth,seq,status,userId,title,content,readCount,createAt
FROM Posts
ORDER BY groupNo DESC, depth ASC
WHERE boardSeq = 2
AND status = 1
LIMIT 1, 5

--데이터 삭제
delete from Posts;

--시퀀스 생성
call create_sequence('postSeq');

