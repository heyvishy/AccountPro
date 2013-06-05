CREATE TABLE Users
(
Id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
LastName VARCHAR(255) ,
FirstName VARCHAR(255),
userid VARCHAR(20) NOT NULL,
PASSWORD VARCHAR(20) NOT NULL
);

/*sets up user account*/
INSERT INTO accountpro.`Users` (LastName,FirstName,userid,PASSWORD) VALUES ('SHUKLA','VISHAL','vishal','password');

CREATE TABLE Customer
(
P_Id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
LastName VARCHAR(255) NOT NULL,
FirstName VARCHAR(255),
Address VARCHAR(255),
City VARCHAR(255),
ZipCode VARCHAR(10)
);

CREATE TABLE Policy
(
Policy_Id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
CustomerID INT NOT NULL,
PolicyType VARCHAR(20) NOT NULL,
CardNumber INT NOT NULL,
PolicyNumber INT NULL,
PolicyAmount DOUBLE NOT NULL,
StartDate DATE ,
EndDate DATE,
PolicyStatusID INT NOT NULL,
FOREIGN KEY (CustomerID) REFERENCES Customer(P_Id),
FOREIGN KEY (PolicyStatusID) REFERENCES PolicyStatus(ID)
);

Create Table PolicyStatus
(
 ID INT NOT NULL PRIMARY KEY,
 Status VARCHAR(50) NOT NULL,
 Description VARCHAR(100)
);

INSERT INTO accountpro.`PolicyStatus` (ID,Status,Description) VALUES (0,'Created','Policy is created');
INSERT INTO accountpro.`PolicyStatus` (ID,Status,Description) VALUES (1,'Started','Policy is started');
INSERT INTO accountpro.`PolicyStatus` (ID,Status,Description) VALUES (2,'Stopped','Policy is stopped');

