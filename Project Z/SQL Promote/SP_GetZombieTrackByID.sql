/*
		Script Name: SP_GetZombieTrackByID.sql
		Date: 2019-01-23
		Coder: Clayton Greene

		Purpose: Get a zombie by its primary key
		
		Date			Vers			Coder							Comment
		2017-01-23		1.0				Clayton Greene					Initial
		

*/
 
        --  exec SP_GetZombieTrackByID 1
     
USE DB_ProjectZ
IF EXISTS (SELECT * FROM dbo.sysobjects WHERE id = object_id(N'[dbo].[SP_GetZombieTrackByID]') 
AND OBJECTPROPERTY(id, N'IsProcedure') = 1)
DROP PROCEDURE [dbo].[SP_GetZombieTrackByID]
GO  
CREATE PROCEDURE [dbo].[SP_GetZombieTrackByID]  

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
   

SELECT L.LocationID, L.Elevation, L.Latitude, L.Longitude, DATEPART(YEAR,L.OccurenceDate), DATEPART(MONTH,L.OccurenceDate), DATEPART(DAY, L.OccurenceDate), CT.[Name], CL.ContactName,HIS.OrdinalNumber FROM tbl_ContactLocationHistory HIS
JOIN tbl_Location L ON L.LocationID = HIS.LocationFK 
JOIN tbl_ContactLocation CL ON CL.ContactLocationID = HIS.ContactLocationFK
JOIN tbl_ContactType CT ON CT.ContactTypeID = CL.ContactTypeFK
WHERE CL.ContactLocationID = @ZombieID
ORDER BY HIS.OrdinalNumber



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

