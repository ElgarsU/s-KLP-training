use klp;

DROP TABLE IF EXISTS fish;

CREATE TABLE fish (
  id bigint(20) NOT NULL AUTO_INCREMENT,
  name varchar(45) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  restricted bit,
  PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;