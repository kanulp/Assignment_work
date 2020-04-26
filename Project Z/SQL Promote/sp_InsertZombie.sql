/*
		Script Name: SP_InsertZombie.sql
		Date: 2019-01-15
		Coder: Clayton Greene

		Purpose: Inserts a Zombie contact into database
		
		Date			Vers			Coder							Comment
		2020-01-15		1.0				Clayton Greene					Initial
		2020-01-18		1.1				Clayton Greene					Fixed return type to be the primary key of the insert.
		2020=01-25		1.2				Clayton Greene					CHanged thereturn primary key from the insert to be the
																		ContactLocationID
*/

       	
		--exec SP_InsertZombie 100, 45,45,'2020-12-31','Fast', 'Ralph'
     
USE DB_ProjectZ
IF EXISTS (SELECT * FROM dbo.sysobjects WHERE id = object_id(N'[dbo].[SP_InsertZombie]') 
AND OBJECTPROPERTY(id, N'IsProcedure') = 1)
DROP PROCEDURE [dbo].[SP_InsertZombie]
GO  
CREATE PROCEDURE [dbo].[SP_InsertZombie]  



@Elevation INT,
@Latitude DECIMAL(10,8),
@Longitude DECIMAL(11,8),
@DATE DATETIME,
@ContactType VARCHAR(MAX),
@ContactName NVARCHAR(MAX)


 AS  

BEGIN TRANSACTION
BEGIN TRY

--Write some SQL here.

SET NOCOUNT ON  
SET ANSI_WARNINGS OFF  
   
DECLARE @ContactTypeID INT = (SELECT ContactTypeID FROM tbl_ContactType WHERE [Name] LIKE @ContactType)
DECLARE @LocationID INT = 0
IF @ContactTypeID = 0
BEGIN
RAISERROR('Unknown contact type.', 16,1);
END

INSERT INTO tbl_Location(Elevation,Latitude,Longitude,OccurenceDate)
VALUES (@Elevation,@Latitude,@Longitude,@DATE)


--SELECT L.Elevation, L.Latitude, L.Longitude, L.OccurenceDate, CT.[Name] FROM tbl_ContactLocation CL
--JOIN tbl_Location L ON L.LocationID = CL.LocationFK
--JOIN tbl_ContactType CT ON CT.ContactTypeID = CL.ContactTypeFK
SET @LocationID = SCOPE_IDENTITY()

INSERT INTO tbl_ContactLocation(LocationFK,ContactTypeFK,ContactName)
VALUES (@LocationID, @ContactTypeID,@ContactName)

SET @LocationID = SCOPE_IDENTITY()
SELECT @LocationID

END TRY

BEGIN CATCH

DECLARE @ErMessage NVARCHAR(MAX),
        @ErSeverity INT,
		@ErState INT

SELECT @ErMessage = ERROR_MESSAGE(), @ErSeverity = ERROR_SEVERITY(), @ErState = ERROR_STATE()

IF @@TRANCOUNT > 0
BEGIN
ROLLBACK TRANSACTION
END
RAISERROR(@ErMessage,@ErSeverity,@ErState)
END CATCH

IF @@TRANCOUNT > 0
BEGIN
COMMIT TRANSACTION
END

