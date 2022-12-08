CREATE TABLE tulos(
id MEDIUMINT not null AUTO_INCREMENT,
paiva date,
rata varchar(20) not null,
tuuli varchar(10) not null,
tulos integer not null,
PRIMARY KEY(id)
);

-- Lisätään testi data

INSERT INTO tulos
(paiva, rata, tuuli, tulos)
VALUES
('2022-09-29', 'Siltamäki', '6 m/s', 5),
('2022-09-19', 'Malminniitty', '5 m/s', -1);