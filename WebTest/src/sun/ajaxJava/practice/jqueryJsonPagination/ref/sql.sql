CREATE TABLE `data` (
  `recNo` bigint(22) NOT NULL AUTO_INCREMENT,
  `name` varchar(90) NOT NULL,
  PRIMARY KEY (`recNo`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;


insert into data(recNo, name) values(1,"ABC");
insert into data(name) values("XYZ");
insert into data(name) values("CBN");
insert into data(name) values("SJG");
insert into data(name) values("OIS");
insert into data(name) values("POI");
insert into data(name) values("KJD");