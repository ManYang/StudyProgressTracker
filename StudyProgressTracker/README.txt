In the eclipse project explorer, locate the mysql-connector-java-5.1.22-bin.jar file in [project root]/WebContent/WEB-INF/lib.
Right click the file, select Properties. In the Properties window, it shows the Location of the file on your computer. Go to that location.
Copy the file from its location and paste it to the apache-tomcat-7.0.35/lib folder on your computer. (For example, mine is located at "C:\Users\Antoine\Desktop\Eclipse\JEE\apache-tomcat-7.0.35\lib").
Restart the server, and logins should now work.

Username and password for test:

Faculty: name: yang, password: 123
	Go to Faculty Home Page
	1. Click "Student Profile"
    	Input Student ID: 1 / last name(gong) / first name(yan) or any radio button ; 
		Click "Search"
		
	Student Grade/view grade:
	1. Click search  student by ID(1) or by  name(yan) to view his/her grade
	2. Faculty can click the "radio" button to decide reject/accept student's grade(must select all buttons).
	3. Click "confirm" button to save the status of reject/accept to the "Grade" table. 
	4. Click "back" button, back to faculty home page.	
	
	Account setting
	1.Reset password.
	
	Logout
	1.Use for logout.
	
Student: name: yan, password:ygong

	view/add grade for students:
	1. Click "Add Grade" tab
	2. A pop up window can let you put one or multiable course number(comp) or department(comp), it can be partially spell
	3. Another pop up window show all results that matches. Then type course name and department in column and click "add".
	4. Click "View Grade" tab. 
	5. Click "Edit Grade", the grade become a dropdown menu.
	6. Click "save" button, student can save the grades which he/she just changed to the "Grade" table in the database;
	7. Click "back" button, student can back to student home page.
	
	Publish Paper
	1. Click "View All", it show all the papers and upload date.
	2. Click "Upload Paper", type the paper name and choose source file on your computer, then click submit.
	
	Account setting
	1.Reset password.
	
	Logout
	1.Use for logout.
	
Admin: name: temp, password:temp
	Go to Admin Home page
	1. Click "Add faculty"
		Input faculty name and password.
		If faculty name is empty, a warn message will show said cannot be empty.
		If faculty name already exist(1), a error message will said failed to upload.
		If faculty name is not empty and do not exist, it will show update successfully.
	2. Click Remove Faculty	
		If input is a string, a error message said not a number.
		If input is empty, a error message said cannot be empty.
		If invaild id is input, it said invaild id.
		If exist(shown in the table above) id is input, it said update successfully.
		
