/*
		Script Name: sp_GetAllZombiesByDateRange.sql
		Date: 2020-02-06
		Coder: Clayton Greene

		Purpose: Get all the Zombies from the database by date range
		
		Date			Vers			Coder							Comment
		2020-02-06		1.0				Clayton Greene					Initial
		

*/

        --  exec sp_GetAllZombiesByDateRange '2019-01-08', '2019-01-09'
     
USE DB_ProjectZ
IF EXISTS (SELECT * FROM dbo.sysobjects WHERE id = object_id(N'[dbo].[sp_GetAllZombiesByDateRange]') 
AND OBJECTPROPERTY(id, N'IsProcedure') = 1)
DROP PROCEDURE [dbo].[sp_GetAllZombiesByDateRange]
GO  
CREATE PROCEDURE [dbo].[sp_GetAllZombiesByDateRange]  

@STARTDATE DATETIME,
@ENDDATE DATETIME


 AS  

BEGIN TRANSACTION
BEGIN TRY

--Write some SQL here.

SET NOCOUNT ON  
SET ANSI_WARNINGS OFF  
   

SELECT CL.ContactLocationID, L.Elevation, L.Latitude, L.Longitude, DATEPART(YEAR,L.OccurenceDate), DATEPART(MONTH,L.OccurenceDate), DATEPART(DAY, L.OccurenceDate), CT.[Name], CL.ContactName FROM tbl_ContactLocation CL
JOIN tbl_Location L ON L.LocationID = CL.LocationFK
JOIN tbl_ContactType CT ON CT.ContactTypeID = CL.ContactTypeFK 
WHERE L.OccurenceDate BETWEEN @STARTDATE AND @ENDDATE
ORDER BY L.OccurenceDate

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

