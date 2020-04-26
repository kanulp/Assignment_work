/*
		Script Name: SP_DeleteZombieByID.sql
		Date: 2019-01-15
		Coder: Clayton Greene

		Purpose: Get a zombie by its primary key
		
		Date			Vers			Coder							Comment
		2020-01-15		1.0				Clayton Greene					Initial
		2020-01-26		1.1				Clayton Greene					Changed the LocationID for the ContactLocationID 
																		as the input paramater.

*/

        --  exec SP_DeleteZombieByID 1
     
USE DB_ProjectZ
IF EXISTS (SELECT * FROM dbo.sysobjects WHERE id = object_id(N'[dbo].[SP_DeleteZombieByID]') 
AND OBJECTPROPERTY(id, N'IsProcedure') = 1)
DROP PROCEDURE [dbo].[SP_DeleteZombieByID]
GO  
CREATE PROCEDURE [dbo].[SP_DeleteZombieByID]  

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
  
DECLARE @LocationID INT = (SELECT LocationID FROM tbl_Location L
						   JOIN tbl_ContactLocation CL ON CL.LocationFK = L.LocationID 
						   WHERE ContactLocationID = @ZombieID)  
   
DELETE FROM tbl_ContactLocation WHERE ContactLocationID = @ZombieID
DELETE FROM tbl_Location WHERE LocationID = @LocationID
DECLARE @S INT = (SELECT LocationID FROM tbl_Location WHERE LocationID = @ZombieID)
--Selecting 0 is good.
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

