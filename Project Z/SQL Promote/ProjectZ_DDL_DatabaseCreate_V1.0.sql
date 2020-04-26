/*
ScriptName: ProjectZ_DDL_DatabaseCreate
Coder: Clay
Date: 2020-01-08

vers     Date                    Coder       Issue
1.0      2020-01-08              Clay        Initial
1.1		 2020-01-17				 Clay		 Converted the DateTime data type to Date. In order to
											 get the Noda Time Object on the C# side to work.
1.2		 2020-01-18				 Clay		 Added the name property to the Zombie in the ContactLocation Table.
											 Naming the zombies is going to be fun. Maybe a picture of eachin a pop up?
1.3		 2020-01-23				 Clay		 Implement Zombie movements and tracking.
*/

USE master
GO
IF EXISTS(SELECT * FROM sys.databases WHERE name='DB_ProjectZ')
DROP DATABASE DB_ProjectZ

CREATE DATABASE DB_ProjectZ
GO
USE DB_ProjectZ

CREATE TABLE tbl_Location
(
LocationID INT IDENTITY(1,1),
Elevation INT NOT NULL,
Latitude DECIMAL(10,8) NOT NULL,
Longitude DECIMAL(11,8) NOT NULL,
OccurenceDate DATE
)

ALTER TABLE tbl_Location ADD PRIMARY KEY (LocationID)

CREATE TABLE tbl_ContactType
(
ContactTypeID INT IDENTITY(1,1),
[Name] VARCHAR(MAX) NOT NULL
)

ALTER TABLE tbl_ContactType ADD PRIMARY KEY (ContactTypeID)

CREATE TABLE tbl_ContactLocation
(
ContactLocationID INT IDENTITY(1,1),
ContactTypeFK INT,
LocationFK INT,
ContactName NVARCHAR(MAX)
)

ALTER TABLE tbl_ContactLocation ADD PRIMARY KEY (ContactLocationID)


ALTER TABLE tbl_ContactLocation
ADD FOREIGN KEY (ContactTypeFK) REFERENCES tbl_ContactType(ContactTypeID);

ALTER TABLE tbl_ContactLocation
ADD FOREIGN KEY (LocationFK) REFERENCES tbl_Location(LocationID);

ALTER TABLE tbl_Location
ADD CHECK (Latitude >=-90);

ALTER TABLE tbl_Location
ADD CHECK (Latitude <= 90);

ALTER TABLE tbl_Location
ADD CHECK (Longitude >=-180);

ALTER TABLE tbl_Location
ADD CHECK (Longitude <= 180);


CREATE TABLE tbl_ContactLocationHistory
(
ContactLocationHistoryID INT IDENTITY(1,1),
ContactLocationFK INT,
LocationFK INT,
OrdinalNumber INT
)
ALTER TABLE tbl_ContactLocationHistory ADD PRIMARY KEY (ContactLocationHistoryID)

ALTER TABLE tbl_ContactLocationHistory
ADD FOREIGN KEY (LocationFK) REFERENCES tbl_Location(LocationID);

ALTER TABLE tbl_ContactLocationHistory
ADD FOREIGN KEY (ContactLocationFK) REFERENCES tbl_ContactLocation(ContactLocationID);

