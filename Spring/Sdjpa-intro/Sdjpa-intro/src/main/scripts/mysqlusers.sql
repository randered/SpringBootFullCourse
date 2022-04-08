DROP DATABASE IF EXISTS bookdb;
DROP USER IF EXISTS `bookadmin`@`%`;
DROP USER IF exists `bookuser`@`%`;
CREATE DATABASE IF NOT EXISTS bookdb;
CREATE USER IF NOT EXISTS `bookadmin`@`%` identified WITH mysql_native_password BY 'admin';
GRANT ALL PRIVILEGES ON `bookdb` .* TO `bookadmin`@`%`;
CREATE USER IF NOT EXISTS `bookuser`@`%` identified WITH mysql_native_password BY 'user';
GRANT SELECT,INSERT,UPDATE,DELETE,SHOW VIEW ON `bookdb` .* TO `bookuser`@`%`;
FLUSH PRIVILEGES;