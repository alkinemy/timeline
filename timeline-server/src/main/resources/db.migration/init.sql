CREATE DATABASE IF NOT EXISTS timeline DEFAULT CHARACTER SET utf8 ;

CREATE USER 'timeline'@'localhost' IDENTIFIED BY 'timeline!@#';

INSERT INTO db (HOST,Db,USER,Select_priv,Insert_priv,Update_priv,Delete_priv,Create_priv,Drop_priv,Index_priv, Alter_priv) VALUES('localhost','timeline','timeline','Y','Y','Y','Y','Y','Y','Y','Y');

FLUSH PRIVILEGES;