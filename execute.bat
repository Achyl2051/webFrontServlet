set temporaire=D:\repertoireTravail\dossierTemp
set test=D:\repertoireTravail\Test
set framework=D:\repertoireTravail\Framework
set nomDossier=webFrontServlet
set tomcat=D:\log\Tomcat_9\webapps
set jar=framework.jar

mkdir dossierTemp
cd dossierTemp
mkdir WEB-INF
cd WEB-INF
mkdir classes
mkdir lib
mkdir files
cd ../../

cd Framework/src
javac -d ../build/ *.java
cd ../build
jar -cfv %jar% *

copy %framework%\build\%jar% %temporaire%\WEB-INF\lib\%jar%
del %jar%
copy %test%\src\*.java %temporaire%\WEB-INF\files\
copy %test%\web\*.jsp %temporaire%\

mkdir %tomcat%\%nomDossier%
xcopy %temporaire% %tomcat%\%nomDossier% /e
copy %test%\web.xml %tomcat%\%nomDossier%\WEB-INF\

javac -d %tomcat%\%nomDossier%\WEB-INF\classes\ -cp %tomcat%\%nomDossier%\WEB-INF\lib\%jar% %tomcat%\%nomDossier%\WEB-INF\files\*.java

cd ../../
rmdir /s dossierTemp