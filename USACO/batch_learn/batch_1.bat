REM @echo off 
REM choice /C dme /M "defrag,mem,end"
REM if errorlevel 3 goto end
REM if errorlevel 2 goto mem 
REM if errotlevel 1 goto defrag 

REM :defrag 
REM c:/dos/defrag 
REM goto end 

REM :mem 
REM mem 
REM goto end 

REM :end 
REM echo good bye 
REM @echo off 
REM IF EXIST /AUTOEXEC.BAT TYPE /AUTOEXEC.BAT 
REM IF NOT EXIST /AUTOEXEC.BAT ECHO /AUTOEXEC.BAT does not exist 
@echo off
IF "%1" == "L" ECHO LIU 
IF "%2" == "Y" ECHO YU 
IF "%3" == "N" ECHO NONG 