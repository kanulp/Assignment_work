/*
		Script Name: SP_GetAllZombies.sql
		Date: 2019-01-15
		Coder: Clayton Greene

		Purpose: Gets all the Zombies from the Database
		
		Date			Vers			Coder							Comment
		2020-01-15		1.0				Clayton Greene					Initial
		2020-01-17		1.1				CLayton Greene					Split out the date parts.

*/

        --  exec SP_GetAllZombies
     
USE DB_ProjectZ
IF EXISTS (SELECT * FROM dbo.sysobjects WHERE id = object_id(N'[dbo].[SP_GetAllZombies]') 
AND OBJECTPROPERTY(id, N'IsProcedure') = 1)
DROP PROCEDURE [dbo].[SP_GetAllZombies]
GO  
CREATE PROCEDURE [dbo].[SP_GetAllZombies]  

--sp_help tbl_Location

--@Elevation INT,
--@Latitude DECIMAL(10,8),
--@Longitude DECIMAL(11,8),
--@DATE DATETIME,
--@ContactType VARCHAR(MAX)


 AS  

BEGIN TRANSACTION
BEGIN TRY

--Write some SQL here.

SET NOCOUNT ON  
SET ANSI_WARNINGS OFF  
   

SELECT CL.ContactLocationID, L.Elevation, L.Latitude, L.Longitude, DATEPART(YEAR,L.OccurenceDate), DATEPART(MONTH,L.OccurenceDate), DATEPART(DAY, L.OccurenceDate), CT.[Name], CL.ContactName FROM tbl_ContactLocation CL
JOIN tbl_Location L ON L.LocationID = CL.LocationFK
JOIN tbl_ContactType CT ON CT.ContactTypeID = CL.ContactTypeFK 

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

