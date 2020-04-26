/*
		Script Name: SP_GetZombieByID.sql
		Date: 2019-01-15
		Coder: Clayton Greene

		Purpose: Get a zombie by its primary key
		
		Date			Vers			Coder							Comment
		2017-01-15		1.0				Clayton Greene					Initial
		2020-01-17		1.1				Clayton Greene					Split out the date parts.
		2020-01-25		1.2				Clayton Greene					The ID variable now calls ContactLocationID instead of LocationID
*/
 
        --  exec SP_GetZombieByID 1
     
USE DB_ProjectZ
IF EXISTS (SELECT * FROM dbo.sysobjects WHERE id = object_id(N'[dbo].[SP_GetZombieByID]') 
AND OBJECTPROPERTY(id, N'IsProcedure') = 1)
DROP PROCEDURE [dbo].[SP_GetZombieByID]
GO  
CREATE PROCEDURE [dbo].[SP_GetZombieByID]  

--sp_help tbl_Location
@ZombieID INT
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
LEFT JOIN tbl_Location L ON L.LocationID = CL.LocationFK
LEFT JOIN tbl_ContactType CT ON CT.ContactTypeID = CL.ContactTypeFK
WHERE CL.ContactLocationID = @ZombieID

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

