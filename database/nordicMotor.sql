DROP DATABASE IF EXISTS NordicMotorhomeRental;
CREATE DATABASE NordicMotorhomeRental;

USE NordicMotorhomeRental;

CREATE TABLE customer
(
    customer_id		            INT	 	    	PRIMARY KEY	 	AUTO_INCREMENT,
    customer_firstName			VARCHAR(45)		NOT NULL,
    customer_lastName			VARCHAR(45)		NOT NULL,
    customer_address			VARCHAR(45)		NOT NULL,
    customer_city				VARCHAR(45)		NOT NULL,
    customer_zip				INT				NOT NULL,
    customer_phoneNo			VARCHAR(45)		NOT NULL,
    customer_email				VARCHAR(45),
    customer_driver_licenseNo	VARCHAR(45)		NOT NULL
);

CREATE TABLE motorhome
(
    motorhome_id				INT				PRIMARY KEY		AUTO_INCREMENT,
    motorhome_type				VARCHAR(45)		NOT NULL,
    motorhome_brand  			VARCHAR(45)		NOT NULL,
    motorhome_model				VARCHAR(45)		NOT NULL,
    motorhome_beds				VARCHAR(45)		NOT NULL,
    motorhome_registration  	VARCHAR(45)		NOT NULL,
    motorhome_odometer			INT				NOT NULL,
    motorhome_availability		VARCHAR(45)		NOT NULL,
    motorhome_fuelType			VARCHAR(45)		NOT NULL,
    motorhome_fuelAmount		INT		 		NOT NULL,
    motorhome_price				INT				NOT NULL
);

CREATE TABLE extra
(
    extra_id		INT	 	        PRIMARY KEY		AUTO_INCREMENT,
    extra_name		VARCHAR(45)		NOT NULL,
    extra_price		INT				NOT NULL
);

CREATE TABLE rentalContract
(
    rentalContract_id			INT				PRIMARY KEY		AUTO_INCREMENT,
    rentalContract_startDate	VARCHAR(45)		NOT NULL,
    rentalContract_endDate		VARCHAR(45)		NOT NULL,
    customer_id					INT				NOT NULL,
    motorhome_id				INT 			NOT NULL,
    extra_id					INT 			NOT NULL,
    CONSTRAINT rentalContract_fk_customer
		FOREIGN KEY (customer_id)
		REFERENCES customer (customer_id)
        ON DELETE CASCADE,
    CONSTRAINT rentalContract_fk_motorhome
		FOREIGN KEY (motorhome_id)
		REFERENCES motorhome (motorhome_id)
        ON DELETE CASCADE,
    CONSTRAINT rentalContract_fk_extra
		FOREIGN KEY (extra_id)
		REFERENCES extra (extra_id)
        ON DELETE CASCADE
);

INSERT INTO customer (customer_firstName, customer_lastName, customer_address, customer_city,
						customer_zip, customer_phoneNo, customer_email, customer_driver_licenseNo)
VALUES
('David', 'Krtolica', 'Theklavej 36', 'Copenhagen', 2400, '12345678', 'davi161a@stud.kea.dk', '4536253499'),
('David', 'Haring', 'Theklavej 36', 'Copenhagen', 2400,  '12345679', 'davi162a@stud.kea.dk', '4536253498'),
('Pragya', 'Chudal', 'Bispevej 48', 'Copenhagen', 2100,  '12345677', null, '4536253497'),
('Nirendra', 'Singh Rawal', 'Thoravej 65', 'Copenhagen', 2200,  '12345676', 'nirendrasr@stud.kea.dk', '4536253496');

INSERT INTO motorhome (motorhome_type, motorhome_brand, motorhome_model, motorhome_beds,
						motorhome_registration, motorhome_odometer, motorhome_availability, motorhome_fueltype,
							motorhome_fuelAmount, motorhome_price)
VALUES
('Comfort', 'Winnebago', 'Boldt', 3, 'ZZ22S', 12333, 'available', 'diesel', 100, 0),
('Luxury', 'Winnebago', 'Travato', 4, 'TT33A', 9435, 'available', 'diesel', 100, 100),
('Comfort', 'Entegra', 'Anthem', 3, 'UH877I', 2067, 'available', 'diesel', 100, 50),
('Luxury', 'Entegra', 'Emble', 4, 'NB009J', 15003, 'available', 'diesel', 100, 150);

INSERT INTO extra (extra_name, extra_price) VALUES
('Bike rack', 10),
('Bed linen', 15),
('Child seat', 20),
('Picnic table', 10),
('Picnic chair', 5);

INSERT INTO rentalContract (rentalContract_startDate, rentalContract_endDate, customer_id, motorhome_id, extra_id) VALUES
('12/02/2020', '17/02/2020', 1, 2, 1),
('20/02/2020', '22/02/2020', 2, 1, 3),
('03/03/2020', '10/03/2020', 4, 3, 2),
('25/04/2020', '30/04/2020', 3, 4, 4);
