/* User for ARM (Asterisk Realtime Manager) service */

CREATE USER 'arm-tlcomunic'@'%' IDENTIFIED BY '4RM4n4g3Rtl';
GRANT 
	CREATE, ALTER, DROP, INSERT, UPDATE, DELETE, SELECT, 
    REFERENCES, INDEX, CREATE ROUTINE, EXECUTE, TRIGGER
ON asterisk_realtime.* TO 'arm-tlcomunic'@'%';

DROP USER 'arm-tlcomunic'@'%';