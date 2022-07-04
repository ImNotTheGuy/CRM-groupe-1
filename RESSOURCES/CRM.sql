
CREATE SEQUENCE Client_id_seq;

CREATE TABLE Client (
	id integer NOT NULL DEFAULT nextval('Client_id_seq'),
	companyName varchar(100) NOT NULL,
	firstName varchar(100) NOT NULL,
	lastName varchar(100) NOT NULL,
	email varchar(100) NOT NULL,
	phone varchar(15) NOT NULL,
	address text NOT NULL,
	zipCode varchar(15) NOT NULL,
	city varchar(15) NOT NULL,
	country varchar(15) NOT NULL,
	state int DEFAULT 0,
	PRIMARY KEY ( id )
);

ALTER SEQUENCE Client_id_seq
OWNED BY Client.id;



CREATE SEQUENCE Orders_id_seq;

CREATE TABLE Orders (
	id         integer NOT NULL DEFAULT nextval('Orders_id_seq'),
	clientId  int,
	typePresta varchar(100) NOT NULL,
	designation varchar(100) NOT NULL,
	nbDays int NOT NULL,
	unitPrice float NOT NULL,
	state int NOT NULL,
	totalExcludeTaxe float GENERATED ALWAYS AS (nbDays * unitPrice) STORED,
	totalWithTaxe float GENERATED ALWAYS AS (nbDays * unitPrice * 1.2) STORED,
	PRIMARY KEY ( id ) ,
	CONSTRAINT fk_clientId    
		FOREIGN KEY (clientId)  
		REFERENCES Client(id)  
		ON DELETE SET NULL    
);

ALTER SEQUENCE Orders_id_seq
OWNED BY Orders.id;


INSERT INTO Client (id, companyName, firstName, lastName, email, phone, address, zipCode, city, country, state) VALUES
(1, 'Capgemini', 'Fabrice', 'Martin', 'martin@mail.com\r\n', '0656858433', 'Head Office - Capgemini Service - Place de Étoile - 11 rue de Tilsitt - 75017 Paris', '75017', 'Paris', 'France', 1),
(2, 'M2I Formation', 'Julien', 'Lamard\r\n', 'lamard@mail.com', '0611223344', '17 r Chaillot, 75116 Paris\r\n', '75116', 'Paris', 'France', 0),
(3, 'Atos', 'Jean-Paul', 'Pomodoro', 'jean.paul@mail.com\r\n', '0656853233', 'Laboratoire digital.security 50 avenue Daumesnil Immeuble B 75012 Paris', '76017', 'Paris', 'France', 1),
(4, 'Sopra Steria', 'Alain', 'Lampard', 'alain@sopra.com', '0611298344', 'Paris Presbourg - Kléber. 6 avenue Kleber, 79016, Paris', '79016', 'Paris', 'France', 0);


INSERT INTO Orders (id, clientId, typePresta, designation, nbDays, unitPrice, state) VALUES
(1, 2, 'Formation', 'Angular Initiation', 3, 1200, 0),
(2, 2, 'Formation', 'React.js avancé', 3, 1000, 2),
(3, 1, 'Coaching', 'React Techlead', 20, 900, 2),
(4, 1, 'Coaching', 'Nest.js Techlead', 50, 800, 1),
(5, 3, 'Coaching', 'React Techlead', 30, 1100, 2),
(6, 3, 'Coaching', 'Jakarta EE', 57, 1200, 2),
(7, 4, 'Coaching', 'Angular Techlead', 25, 1000, 1);