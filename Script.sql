CREATE TABLE Booking (
    ID_Booking int NOT NULL AUTO_INCREMENT,
    Full_name varchar(255) NOT NULL,
    Email varchar(255) NOT NULL,
    Phone varchar(255) NOT NULL,
    Timebooking varchar(255) NOT NULL,
    Datebooking varchar(255) NOT NULL,
    ID_Plane int NOT NULL,
    PRIMARY KEY (ID_Booking),
    FOREIGN KEY (ID_Plane) REFERENCES plane(ID_Plane)

);

CREATE TABLE Plane (
    ID_Plane int NOT NULL AUTO_INCREMENT,
    ID_Sale int NOT NULL,
    Planename varchar(255) NOT NULL,
    PRIMARY KEY (ID_Plane),
    FOREIGN KEY (ID_Sale) REFERENCES users(ID_Sale)

);


CREATE TABLE Users (
    ID_Sale int NOT NULL AUTO_INCREMENT,
    Full_Name varchar(255) NOT NULL,
    Username varchar(255) NOT NULL,
    Password varchar(255) NOT NULL,
    AccountType tinyint(4) DEFAULT '1',
    PRIMARY KEY (ID_Sale)
);

CREATE TABLE Scheduler (
    ID_Scheduler int NOT NULL AUTO_INCREMENT,
    ID_Sale int NOT NULL,
    ID_Plane int NOT NULL,
    DateCreated varchar(255) NOT NULL,
    Starts varchar(255) NOT NULL,
    Ends varchar(255) NOT NULL,
    PRIMARY KEY (ID_Booking),
    FOREIGN KEY (ID_Sale) REFERENCES users(ID_Sale),
    FOREIGN KEY (ID_Plane) REFERENCES plane(ID_Plane)
);
