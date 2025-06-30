
HexaShop Final Setup - By Mayank Aylani

1. Copy this entire folder to: C:/Program Files/Apache Software Foundation/Tomcat 9.0/webapps/HexaShop

2. Make sure you have MySQL installed. Create database using 'hexashop.sql' file.
   - You can use MySQL Workbench to run the script.

3. Copy mysql-connector-java-X.X.X.jar into: Tomcat 9.0/lib

4. Compile the servlets using Command Prompt:
   cd to WEB-INF/classes
   javac -cp "C:/Program Files/Apache Software Foundation/Tomcat 9.0/lib/servlet-api.jar" *.java

5. Restart Tomcat using Tomcat9w.exe

6. Access website:
   http://localhost:8080/HexaShop/index.html

7. Test login and registration from:
   - login.html
   - register.html

Ensure MySQL is running in background.

Enjoy your working project!
