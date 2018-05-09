create table TALK
(
	ID INT NOT NULL,
	USERID INT,
	DISCUSSID INT,
	TIME VARCHAR(30),
	ARTICLE VARCHAR(30),
	PRIMARY KEY(ID),
	FOREIGN KEY(USERID) REFERENCES MANAGER(ID),
	FOREIGN KEY(DISCUSSID) REFERENCES DISCUSS(ID)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;