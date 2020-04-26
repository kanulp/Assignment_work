/*
		Script Name: SP_UpdateZombieByID.sql
		Date: 2019-01-15
		Coder: Clayton Greene

		Purpose: Updates a zombie by its primary key
		
		Date			Vers			Coder							Comment
		2017-01-15		1.0				Clayton Greene					Initial
		2020-01-18		1.1				Clayton Greene					Fixed return type to be the primary key of the Update.
		2020-01-26		1.2				Clayton Greene					MAde the changes for the primary key in tbl_ContactLocation
*/

       	
		--exec SP_UpdateZombieByID 100, 45,45,'2020-12-31','Slow', 1, 'Dave'
     
USE DB_ProjectZ
IF EXISTS (SELECT * FROM dbo.sysobjects WHERE id = object_id(N'[dbo].[SP_UpdateZombieByID]') 
AND OBJECTPROPERTY(id, N'IsProcedure') = 1)
DROP PROCEDURE [dbo].[SP_UpdateZombieByID]
GO  
CREATE PROCEDURE [dbo].[SP_UpdateZombieByID]  



@Elevation INT,
@Latitude DECIMAL(10,8),
@Longitude DECIMAL(11,8),
@DATE DATETIME,
@ContactType VARCHAR(MAX),
@ZombieID INT,
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

UPDATE L SET			Elevation = @Elevation,
						Latitude = @Latitude,
						Longitude = @Longitude,
						OccurenceDate = @DATE
FROM tbl_Location L 
JOIN tbl_ContactLocation CL ON CL.LocationFK = L.LocationID
WHERE CL.ContactLocationID =  @ZombieID

UPDATE tbl_ContactLocation SET ContactTypeFK = @ContactTypeID,
							   ContactName = @ContactName
WHERE tbl_ContactLocation.ContactLocationID = @ZombieID

DECLARE @S INT = (SELECT LocationID FROM tbl_Location WHERE LocationID = @ZombieID)
SELECT ISNULL(@S,0)

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

