CREATE USER 'admin' IDENTIFIED BY 'secret';

CREATE DATABASE crawling;

GRANT ALTER, CREATE, INSERT, SELECT, DELETE, REFERENCES, UPDATE, DROP, EXECUTE, LOCK TABLES, INDEX
ON crawling.* TO 'admin';

FLUSH PRIVILEGES;

grant ALTER, CREATE, INSERT, SELECT, DELETE, REFERENCES, UPDATE, DROP, EXECUTE, LOCK TABLES, INDEX
ON test.* to 'username';