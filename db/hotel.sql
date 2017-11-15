


CREATE TABLE Tarif (
	idTarif smallint(6) NOT NULL AUTO_INCREMENT,
	prix smallint(6) NOT NULL,
	capacite tinyint(1) NOT NULL,
	type varchar(30) NOT NULL,
	PRIMARY KEY (idTarif)
)ENGINE=innoDB DEFAULT charset=latin1;

CREATE TABLE Client (
	idClient smallint(6) NOT NULL AUTO_INCREMENT,
	nom varchar(20) NOT NULL,
	prenom varchar(20) default NULL,
	telephone varchar(20) default NULL,
	PRIMARY KEY (idClient)
)ENGINE=innoDB DEFAULT charset=latin1;

CREATE TABLE Chambre (
	idChambre smallint(6) NOT NULL AUTO_INCREMENT,
	etage tinyint(3) default NULL,
	numero tinyint(3) default NULL,
	nomChambre varchar(30) default NULL,
	tarif smallint(6) default NULL,
	vignette varchar(200) NOT NULL DEFAULT 'path',
	PRIMARY KEY (idChambre)
)ENGINE=innoDB DEFAULT charset=latin1;

CREATE TABLE Reservation (
	idChambre smallint(6) NOT NULL,
	idClient smallint(6) NOT NULL,
	checkInDate date DEFAULT NULL,
	checkOutDate date,
	paye boolean NOT NULL default 0
)ENGINE=innoDB DEFAULT charset=latin1;

/*Ajout des clefs*/

ALTER TABLE  Chambre
ADD CONSTRAINT fk_tarif FOREIGN KEY (tarif) REFERENCES Tarif(idTarif);

ALTER TABLE Reservation
ADD CONSTRAINT fk_Chambre FOREIGN KEY (idChambre) REFERENCES Chambre(idChambre);

ALTER TABLE Reservation
ADD CONSTRAINT fk_Client FOREIGN KEY (idClient) REFERENCES Client(idClient);



/*peuplement des tables*/

INSERT INTO Client (prenom,nom,telephone) VALUES ("Ahmed","Jarvis","0916332844"),("Knox","Navarro","0628932590"),("Chester","Harrison","0667941487"),("Buckminster","Parrish","0843884109"),("Logan","Park","0377396555"),("Vivian","Gibson","0919643810"),("Quamar","Bush","0407143050"),("Victoria","Patton","0887721922"),("Quinn","Bentley","0961734617"),("Anastasia","Quinn","0800944944");
INSERT INTO Client (prenom,nom,telephone) VALUES ("Keaton","Gordon","0905792365"),("Amal","Wells","0867818100"),("Adrienne","Allison","0553363028"),("Sarah","Holman","0642451690"),("Maggie","Goff","0210524066"),("Jason","Ware","0276771242"),("Julian","Mitchell","0375667062"),("Anthony","Woods","0793905105"),("Chandler","Hardin","0905242756"),("Bradley","Roman","0436977450");
INSERT INTO Client (prenom,nom,telephone) VALUES ("Tanner","Mcfarland","0106510859"),("Jamalia","Bradford","0365774945"),("Jakeem","Robbins","0205954049"),("Harriet","Bonner","0531010357"),("Clementine","Rodriquez","0259968557"),("Jason","Sweeney","0486484056"),("Kyra","Holmes","0692775974"),("Nissim","Garrison","0504121830"),("Meghan","Singleton","0918246938"),("Abigail","Gonzalez","0793109159");
INSERT INTO Client (prenom,nom,telephone) VALUES ("Aurelia","Donaldson","0525557383"),("Chase","Goodman","0222837520"),("Hu","Little","0989021944"),("Anne","Mckenzie","0910386823"),("Gray","Jones","0618396130"),("Carlos","Goff","0185061436"),("Raya","Quinn","0981076705"),("Stacey","Quinn","0380079973"),("Eaton","Velasquez","0255327125"),("Jacob","Sellers","0168527053");
INSERT INTO Client (prenom,nom,telephone) VALUES ("Wallace","Bailey","0592714202"),("Eve","Cleveland","0593018156"),("Hedley","Noble","0142956898"),("MacKensie","Contreras","0411929092"),("Vielka","Hardin","0322685381"),("Molly","Bennett","0129464098"),("Jonas","Guerra","0134223707"),("Chaney","Travis","0146456948"),("Drake","Jefferson","0235762569"),("Maxwell","Rice","0397844653");
INSERT INTO Client (prenom,nom,telephone) VALUES ("Dillon","Sykes","0562049212"),("Raja","Dudley","0925364098"),("Oliver","Holman","0442065182"),("Judah","Cochran","0731738537"),("Berk","Tyson","0730036888"),("Jaquelyn","Hatfield","0530162132"),("Eagan","Rogers","0509921578"),("Kelly","Valencia","0290757799"),("Michael","King","0763372680"),("Barclay","Kaufman","0280638678");
INSERT INTO Client (prenom,nom,telephone) VALUES ("Melodie","Mcgee","0174928487"),("Thaddeus","Burks","0801314047"),("Liberty","Wiggins","0840021854"),("Ramona","Osborne","0179100597"),("Kiayada","Benson","0117275342"),("Carl","Guzman","0763746261"),("Cheyenne","Sutton","0773680089"),("Aidan","Gamble","0576792851"),("Denise","Perez","0137155838"),("Joel","Jensen","0870151284");
INSERT INTO Client (prenom,nom,telephone) VALUES ("Alan","Wheeler","0822552704"),("Amena","Ferguson","0509708970"),("Erica","Lee","0778882305"),("Anthony","Moody","0490219024"),("Emi","Garcia","0960677759"),("Mohammad","Hodge","0389705742"),("Risa","Ruiz","0414897793"),("Jamalia","Vega","0659363280"),("Cullen","Wilkins","0210725958"),("Ferris","Hale","0383789892");
INSERT INTO Client (prenom,nom,telephone) VALUES ("Geraldine","Mckinney","0478542921"),("Lars","Rhodes","0115159532"),("Darryl","Cochran","0812794912"),("Melodie","Ramsey","0910117561"),("Barrett","Duffy","0835022821"),("Carol","Delgado","0759260911"),("Valentine","Bradford","0703657128"),("Adrian","Joyce","0780419089"),("Rhonda","Hendrix","0510169197"),("Oliver","Mcclain","0439665747");
INSERT INTO Client (prenom,nom,telephone) VALUES ("Jemima","Sparks","0717792615"),("Wynne","Atkinson","0169895019"),("Lars","Boyle","0579166128"),("Roth","Caldwell","0795015452"),("Sonia","Gilmore","0327861455"),("Jason","Woodward","0540713605"),("Mary","Perez","0360402963"),("Quincy","Pickett","0692723264"),("Hammett","Estrada","0991164991"),("Kenyon","Velazquez","0840520140");

INSERT INTO Tarif (tarif, prix, capacite) VALUES
("Standard", 30,1),
("Deluxe", 50,1),
("Suprême", 70,1),
("Divin", 100,1),

("Standard", 45,2),
("Deluxe", 75,2),
("Suprême",140,2),
("Divin", 175,2),

("Standard", 70,4),
("Deluxe", 150,4),
("Suprême", 280,4),
("Divin", 359,4);

INSERT INTO Chambre (etage,numero,nomChambre,type) VALUES (7,3,"Innsbruck",1),(6,3,"Juneau",9),(4,4,"Mesoraca",8),(9,2,"Lansing",2),(6,5,"Greymouth",1),(4,8,"Villafranca d'Asti",10),(8,7,"Moga",9),(4,10,"Hekelgem",6),(6,3,"Shaftesbury",12),(7,4,"Fogliano Redipuglia",6);
INSERT INTO Chambre (etage,numero,nomChambre,type) VALUES (9,8,"Laken",8),(3,1,"Nimy",3),(8,2,"Castelvetere in Val Fortore",10),(8,10,"Opglabbeek",3),(5,4,"Varena",2),(1,10,"Santa Cruz de Tenerife",3),(2,3,"Zamora",9),(1,2,"Lennik",4),(2,4,"Firozabad",7),(4,5,"Angoulême",11);
INSERT INTO Chambre (etage,numero,nomChambre,type) VALUES (3,1,"Grand-Reng",7),(1,3,"Neu-Isenburg",12),(8,4,"Georgia",8),(9,8,"Avellino",2),(4,7,"Helmond",2),(6,10,"Marystown",2),(3,2,"Sundrie",11),(2,5,"Penticton",3),(6,6,"Estación Central",4),(7,8,"Cercepiccola",7);
INSERT INTO Chambre (etage,numero,nomChambre,type) VALUES (0,1,"Pastena",1),(1,5,"Cape Breton Island",7),(9,10,"Taber",6),(6,5,"Rzeszów",6),(0,3,"Santipur",9),(8,9,"Township of Minden Hills",1),(7,2,"Cropalati",5),(1,7,"Guardia Sanframondi",2),(7,5,"Husum",6),(4,7,"Laramie",11);
INSERT INTO Chambre (etage,numero,nomChambre,type) VALUES (8,8,"Montebello",3),(9,2,"Soye",6),(1,5,"East Kilbride",12),(6,4,"McCallum",7),(7,3,"Tarnów",4),(7,7,"Grand Island",7),(2,8,"Whitehorse",12),(5,6,"Agartala",10),(1,1,"Shaftesbury",11),(9,2,"Kalisz",8);
INSERT INTO Chambre (etage,numero,nomChambre,type) VALUES (2,7,"Pune",1),(8,10,"Tuscaloosa",1),(8,7,"Colorado Springs",7),(6,8,"Vosselaar",3),(2,5,"Maunath Bhanjan",9),(3,5,"Sonipat",5),(1,4,"Navadwip",6),(1,4,"Cheyenne",7),(6,3,"Portobuffolè",6),(2,8,"Ophain-Bois-Seigneur-Isaac",6);
INSERT INTO Chambre (etage,numero,nomChambre,type) VALUES (9,2,"Grand-Reng",4),(9,3,"Feldkirchen in Kärnten",1),(9,5,"Oostakker",12),(9,1,"Kamoke",2),(3,8,"Notre-Dame-du-Nord",5),(8,1,"Bowden",1),(9,3,"Khammam",8),(5,3,"Timkur",11),(1,10,"Monte San Pietrangeli",2),(3,4,"Lloydminster",7);
INSERT INTO Chambre (etage,numero,nomChambre,type) VALUES (2,5,"Reading",2),(3,9,"Rimouski",2),(2,10,"Owensboro",7),(5,1,"Colorno",4),(8,6,"Calvi Risorta",12),(2,9,"Upper Hutt",7),(8,1,"Nanaimo",4),(5,1,"Quillón",9),(1,5,"Nashville",6),(1,4,"Boorsem",1);
INSERT INTO Chambre (etage,numero,nomChambre,type) VALUES (7,2,"Cork",1),(2,1,"Muzaffarpur",12),(0,2,"Candidoni",5),(1,5,"Priero",11),(6,10,"La Cruz",4),(9,2,"Savona",9),(8,2,"Oostakker",11),(4,3,"Schweinfurt",12),(4,1,"Hubli",3),(8,8,"Winchester",1);
INSERT INTO Chambre (etage,numero,nomChambre,type) VALUES (2,2,"Fredericton",3),(6,6,"Nueva Imperial",5),(3,1,"New Sarepta",9),(1,9,"Virginia Beach",6),(2,9,"Borgomasino",8),(9,7,"Castelbuono",6),(0,2,"Boise",7),(7,9,"La Estrella",2),(7,5,"Rochester",3),(0,4,"Ruoti",3);

INSERT IGNORE INTO Reservation (idChambre,idClient,checkInDate,checkOutDate) VALUES (4,47,"2017-11-14","2017-11-16"),(20,73,"2017-11-14","2017-11-17"),(96,28,"2017-11-14","2017-11-27"),(50,13,"2017-11-15","2017-11-26"),(70,26,"2017-11-13","2017-11-17"),(21,100,"2017-11-15","2017-11-19"),(20,4,"2017-11-13","2017-11-22"),(78,38,"2017-11-15","2017-11-27"),(15,12,"2017-11-13","2017-11-27"),(36,20,"2017-11-14","2017-11-16");
INSERT IGNORE INTO Reservation (idChambre,idClient,checkInDate,checkOutDate) VALUES (27,91,"2017-11-13","2017-11-29"),(25,17,"2017-11-15","2017-11-20"),(80,30,"2017-11-14","2017-11-26"),(8,93,"2017-11-15","2017-11-17"),(44,75,"2017-11-15","2017-11-18"),(47,52,"2017-11-14","2017-11-29"),(14,32,"2017-11-15","2017-11-24"),(57,24,"2017-11-14","2017-11-19"),(93,27,"2017-11-15","2017-11-17"),(81,31,"2017-11-14","2017-11-25");
INSERT IGNORE INTO Reservation (idChambre,idClient,checkInDate,checkOutDate) VALUES (50,68,"2017-11-14","2017-11-19"),(19,82,"2017-11-13","2017-11-26"),(10,52,"2017-11-14","2017-11-20"),(7,25,"2017-11-15","2017-11-24"),(8,57,"2017-11-13","2017-11-16"),(95,95,"2017-11-14","2017-11-27"),(99,41,"2017-11-14","2017-11-27"),(10,47,"2017-11-13","2017-11-20"),(34,58,"2017-11-14","2017-11-22"),(40,29,"2017-11-14","2017-11-21");
INSERT IGNORE INTO Reservation (idChambre,idClient,checkInDate,checkOutDate) VALUES (93,6,"2017-11-14","2017-11-20"),(94,90,"2017-11-14","2017-11-29"),(33,42,"2017-11-15","2017-11-26"),(1,25,"2017-11-14","2017-11-24"),(66,49,"2017-11-15","2017-11-24"),(63,67,"2017-11-14","2017-11-24"),(62,84,"2017-11-14","2017-11-20"),(46,84,"2017-11-15","2017-11-29"),(22,9,"2017-11-15","2017-11-28"),(91,73,"2017-11-13","2017-11-26");
INSERT IGNORE INTO Reservation (idChambre,idClient,checkInDate,checkOutDate) VALUES (79,26,"2017-11-15","2017-11-23"),(59,6,"2017-11-15","2017-11-21"),(49,60,"2017-11-13","2017-11-27"),(77,74,"2017-11-15","2017-11-25"),(29,92,"2017-11-15","2017-11-17"),(40,57,"2017-11-15","2017-11-27"),(18,91,"2017-11-13","2017-11-16"),(58,44,"2017-11-13","2017-11-22"),(10,99,"2017-11-13","2017-11-20"),(50,33,"2017-11-15","2017-11-20");
INSERT IGNORE INTO Reservation (idChambre,idClient,checkInDate,checkOutDate) VALUES (8,85,"2017-11-15","2017-11-26"),(54,70,"2017-11-14","2017-11-19"),(47,39,"2017-11-15","2017-11-28"),(84,48,"2017-11-13","2017-11-22"),(52,85,"2017-11-13","2017-11-17"),(16,35,"2017-11-15","2017-11-24"),(6,52,"2017-11-15","2017-11-23"),(88,17,"2017-11-15","2017-11-27"),(9,2,"2017-11-13","2017-11-28"),(53,9,"2017-11-13","2017-11-23");
INSERT IGNORE INTO Reservation (idChambre,idClient,checkInDate,checkOutDate) VALUES (81,62,"2017-11-15","2017-11-20"),(42,8,"2017-11-13","2017-11-23"),(24,43,"2017-11-13","2017-11-17"),(25,96,"2017-11-13","2017-11-22"),(73,39,"2017-11-15","2017-11-19"),(86,39,"2017-11-14","2017-11-25"),(37,93,"2017-11-15","2017-11-26"),(100,29,"2017-11-13","2017-11-18"),(65,41,"2017-11-13","2017-11-19"),(17,25,"2017-11-15","2017-11-28");
INSERT IGNORE INTO Reservation (idChambre,idClient,checkInDate,checkOutDate) VALUES (74,79,"2017-11-13","2017-11-18"),(94,21,"2017-11-13","2017-11-29"),(47,98,"2017-11-13","2017-11-28"),(72,9,"2017-11-15","2017-11-16"),(96,16,"2017-11-15","2017-11-23"),(88,46,"2017-11-13","2017-11-16"),(23,2,"2017-11-15","2017-11-18"),(90,63,"2017-11-13","2017-11-23"),(93,96,"2017-11-15","2017-11-25"),(52,68,"2017-11-15","2017-11-25");
INSERT IGNORE INTO Reservation (idChambre,idClient,checkInDate,checkOutDate) VALUES (77,92,"2017-11-13","2017-11-28"),(74,30,"2017-11-14","2017-11-28"),(70,11,"2017-11-15","2017-11-22"),(62,100,"2017-11-13","2017-11-29"),(99,97,"2017-11-13","2017-11-24"),(64,14,"2017-11-13","2017-11-21"),(87,28,"2017-11-14","2017-11-20"),(68,39,"2017-11-14","2017-11-17"),(59,10,"2017-11-13","2017-11-18"),(91,58,"2017-11-15","2017-11-16");
INSERT IGNORE INTO Reservation (idChambre,idClient,checkInDate,checkOutDate) VALUES (39,42,"2017-11-13","2017-11-20"),(67,63,"2017-11-15","2017-11-19"),(85,83,"2017-11-14","2017-11-28"),(96,85,"2017-11-14","2017-11-21"),(24,30,"2017-11-15","2017-11-20"),(49,70,"2017-11-14","2017-11-21"),(45,64,"2017-11-14","2017-11-21"),(64,57,"2017-11-14","2017-11-26"),(76,91,"2017-11-13","2017-11-16"),(83,58,"2017-11-13","2017-11-26");





