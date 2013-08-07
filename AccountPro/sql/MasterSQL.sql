CREATE TABLE Users
(
Id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
LastName VARCHAR(255) ,
FirstName VARCHAR(255),
userid VARCHAR(20) NOT NULL,
PASSWORD VARCHAR(20) NOT NULL,
ENABLED tinyint(1) NOT NULL
);

/*sets up user account*/
INSERT INTO accountpro.`Users` (LastName,FirstName,userid,PASSWORD) VALUES ('SHUKLA','VISHAL','vishal','password','TRUE');

CREATE TABLE user_roles (
  USER_ROLE_ID INT(10) NOT NULL PRIMARY KEY,
  Id INT(10) NOT NULL,
  AUTHORITY VARCHAR(45) NOT NULL,
  FOREIGN KEY (Id) REFERENCES users (Id)
) ;

/*map user.id to user_roles */
INSERT INTO accountpro.user_roles 
(USER_ROLE_ID,Id,AUTHORITY) VALUES (1,1,'ROLE_USER');



CREATE TABLE Customer
(
P_Id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
LastName VARCHAR(255) NOT NULL,
FirstName VARCHAR(255),
Address VARCHAR(255),
City VARCHAR(255),
ZipCode VARCHAR(10)
);

Create Table PolicyStatus
(
 ID INT NOT NULL PRIMARY KEY,
 Status VARCHAR(50) NOT NULL,
 Description VARCHAR(100)
);
/*Master data creation for PolicyStatus*/
INSERT INTO accountpro.`PolicyStatus` (ID,Status,Description) VALUES (0,'Created','Policy is created');
INSERT INTO accountpro.`PolicyStatus` (ID,Status,Description) VALUES (1,'Started','Policy is started');
INSERT INTO accountpro.`PolicyStatus` (ID,Status,Description) VALUES (2,'Stopped','Policy is stopped');

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


/*Payment Table Creation*/
CREATE TABLE Payment
(
Payment_Id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
PolicyID INT NOT NULL,
PolicyNumber INT NULL,
PaymentAmount DOUBLE NOT NULL,
PaymentDate DATE,
IsPaymentProcessed BIT,
FOREIGN KEY (PolicyID) REFERENCES Policy(Policy_Id)
);

CREATE TABLE Balance
(
CustomerId INT NOT NULL ,
PolicyID INT NOT NULL,
PaymentDue DOUBLE NULL,
LastUpdated DATE,
FOREIGN KEY (CustomerId) REFERENCES Customer(P_Id),
FOREIGN KEY (PolicyID) REFERENCES Policy(Policy_Id)
);

