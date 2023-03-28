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
jar -cfv framework.jar *

copy D:\repertoireTravail\Framework\build\framework.jar D:\repertoireTravail\dossierTemp\WEB-INF\lib\framework.jar
del framework.jar
copy D:\repertoireTravail\Test\src\*.java D:\repertoireTravail\dossierTemp\WEB-INF\files\
copy D:\repertoireTravail\Test\web\*.jsp D:\repertoireTravail\dossierTemp\

mkdir D:\log\Tomcat_9\webapps\webFrontServlet
xcopy D:\repertoireTravail\dossierTemp D:\log\Tomcat_9\webapps\webFrontServlet /e
copy D:\repertoireTravail\Test\web.xml D:\log\Tomcat_9\webapps\webFrontServlet\WEB-INF\

javac -d D:\log\Tomcat_9\webapps\webFrontServlet\WEB-INF\classes\ -cp D:\log\Tomcat_9\webapps\webFrontServlet\WEB-INF\lib\framework.jar D:\log\Tomcat_9\webapps\webFrontServlet\WEB-INF\files\*.java

cd ../../
rmdir /s dossierTemp