DROP TABLE contact;

CREATE TABLE contacts (
    telephoneNumber int,
    lastName varchar(255),
    firstName varchar(255),
    address varchar(255),
    city varchar(255),
    postcode varchar(255),
    PRIMARY KEY(TelephoneNumber)
);

INSERT INTO contactsDB.contact (telephoneNumber,lastName,firstName,address,city,postcode)
VALUES (078412872488,"Poole","John","140 Lisburn Road","Glenavy","BT294NZ");

COMMIT;


CREATE TABLE `contactsDB`.`contact` (
  `telephoneNumber` VARCHAR(45) NOT NULL,
  `lastName` VARCHAR(45) NULL,
  `firstName` VARCHAR(45) NULL,
  `address` VARCHAR(45) NULL,
  `city` VARCHAR(45) NULL,
  `postcode` VARCHAR(45) NULL,
  PRIMARY KEY (`telephoneNumber`));
