DROP TABLE IF EXISTS users;

DROP TABLE IF EXISTS phones;

CREATE TABLE IF NOT EXISTS users (
  id VARCHAR(250) NOT NULL,
  name VARCHAR(250) NOT NULL,
  email VARCHAR(250) NOT NULL,
  created DATETIME NULL,
  modified DATETIME NULL,
  lastlogin DATETIME NULL,
  isactive TINYINT NULL,
  token VARCHAR(250) NOT NULL,
  password VARCHAR(20) NOT NULL,
  PRIMARY KEY (id));

CREATE TABLE IF NOT EXISTS phones (
  id INT AUTO_INCREMENT NOT NULL,
  number VARCHAR(15) NULL,
  citycode VARCHAR(5) NULL,
  countrycode VARCHAR(5) NULL,
  users_id VARCHAR(250) NOT NULL,
  PRIMARY KEY (id, users_id),
  CONSTRAINT fk_phones_users
    FOREIGN KEY (users_id)
    REFERENCES users (id)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);