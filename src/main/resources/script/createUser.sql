CREATE USER 'album'@'localhost' IDENTIFIED BY '123456789a';
GRANT ALL PRIVILEGES ON * . * TO 'album'@'localhost';
FLUSH PRIVILEGES;