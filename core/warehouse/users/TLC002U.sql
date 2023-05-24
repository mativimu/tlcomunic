/* User for AUT service */

CREATE USER 'aut-tlcomunic'@'%' IDENTIFIED BY '4UtTlC0MUn*C';
GRANT 
	CREATE, ALTER, DROP, INSERT, UPDATE, DELETE, SELECT, 
    REFERENCES, INDEX, CREATE ROUTINE, EXECUTE, TRIGGER
ON aut.* TO 'aut-tlcomunic'@'%';

DROP USER 'aut-tlcomunic'@'%';