CREATE TABLE DISCUSS
(
	ID INT NOT NULL,
	USERID  INT,
	STARTTIME  VARCHAR(30),
	ENDTIME    VARCHAR(30),
	TITLE TEXT,
	ARTICLE TEXT,
	PRIMARY KEY(ID),
	FOREIGN KEY(USERID) REFERENCES MANAGER(ID)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;
