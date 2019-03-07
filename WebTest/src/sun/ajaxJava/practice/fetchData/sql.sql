CREATE TABLE `country` (
  `recNo` bigint(21) NOT NULL AUTO_INCREMENT,
  `code` varchar(3) NOT NULL,
  `name` varchar(45) NOT NULL,
  `continent` varchar(45) NOT NULL,
  `region` varchar(45) NOT NULL,
  `population` bigint(21) NOT NULL,
  `capital` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`recNo`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
SELECT * FROM test.country;

insert into country (recNo, code, name, continent, region, population, capital) values(1,"IN","India","Asia","South Asia", 2102102010, "Delhi");