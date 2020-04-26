/*
ScriptName: ProjectZ_DML_ZombieDataInsert
Coder: Clay
Date: 2020-01-15

vers     Date                    Coder       Issue
1.0      2020-01-08              Clay        Initial
*/

USE DB_ProjectZ
GO
BEGIN TRANSACTION
BEGIN TRY



SET NOCOUNT ON  
SET ANSI_WARNINGS OFF  

DECLARE @ZombieCheck INT = 0;

SET @ZombieCheck = (SELECT COUNT(ContactTypeID) FROM tbl_ContactType)
IF @ZombieCheck <> 0 
BEGIN
RAISERROR('Zombies types already loaded.', 16,1);
END

INSERT INTO tbl_ContactType ([Name])
VALUES
('Slow'),
('Medium'),
('Fast')

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


