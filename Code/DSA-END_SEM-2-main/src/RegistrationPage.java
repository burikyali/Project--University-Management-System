import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

class RegistrationPage {
	static boolean ForgotPassword_option = true;
	private LoginPage login_object1 = new LoginPage();

	private boolean state67;

	private boolean state76;
	static int var;
	 static int var1;
	 static int var2;
	public  void Registration() throws IOException {
		Scanner scan2 = new Scanner(System.in);
		List recoveryFile_list = new ArrayList(); // creating list to store rollnumbers from recovery txt file
		FileReader recoveryfile = new FileReader("Recoveryfile");
		BufferedReader buffered_recoveryfile = new BufferedReader(recoveryfile);  //Bufferedreader  reads recovery file line by line
		String line; // creating a line variable
		while((line=buffered_recoveryfile.readLine())!=null) {  //initialising line in text file to line named string variable, it will run the loop until txt file is null
			String[] array = line.split(",",2);
			// splitting the line by "," this symbol it will divide line by 2 parts as mentioned in split(",",2) stores in array 0 and 1
			recoveryFile_list.add(array[0]); // as array[0] is rollnumber . storing it in list
		}
		if(login_object1.state) {
			// we are taking state variable from loginpage thats y we created object for login class
			// state is a boolean variable in loginpage class if that state is true then run this if loop
			//if in loginpage he types wrong password or wrong rollnumber we dont want to ask age and phone number in registrationpage
			//so in loginpage for login successfull only we put state = true then we will ask below questions
			if (recoveryFile_list.contains(login_object1.Rollno)) {
				// above we stored rollnumbers in list. so if our rollnumber contains in that then you already registered
				System.out.println(ConsoleColors.BANANA_YELLOW_BACKGROUND + ConsoleColors.PURPLE_BOLD + "                  ***  YOU ALREADY REGISTERED  ***" + "\u001B[0m");

				if(state76){
					login_object1.studentregistration_boolean_for_options = true;
				}
				else{
					login_object1.teacherregistration_boolean_for_options = true;
				}
				// then goto loginpage
				login_object1.login();
			} else {  // if recovery file doesnt contains rollnumber then you should register goto this else part
				FileWriter Recoveryfile_writer = new FileWriter("Recoveryfile", true); // here true means appending in file not over wrtiting
				BufferedWriter Recoveryfilewriter_byBufferedwriter = new BufferedWriter(Recoveryfile_writer);
				PrintWriter recoveryfile_printwriter = new PrintWriter(Recoveryfilewriter_byBufferedwriter);  // prints the file line by line using println method
				if (state76) {
					//we are using this class for student and teacher so in this we dont want to ask questions about age and phonenumber to teacher
					//so create a state76 boolean variable and put state76 = true in student registration method
					// and state76 = false for teacher registration method if user is teacher while registering then state76 = false
					// then teacher cannot goto this if part.

					System.err.println(ConsoleColors.GREEN_BOLD + "                          ---- ENTER THE AGE ----" + "\u001B[0m");
					String age = scan2.nextLine();  // storing age in age string variable
					System.err.println(ConsoleColors.GREEN_BOLD + "                          ---- ENTER THE PHONE NUMBER ----" + "\u001B[0m");
					String Pno = scan2.nextLine(); // storing phonenumber in pno string variable
					FileInputStream n = new FileInputStream(login_object1.File_path);
					// reading the excel file as file path changes as user changes if user is student pathis book1.xlsx if teacher then teacherdetails.xlsx
					//thats y we put File_path as paths are mentioned in studentlogin and teacherlogin methods
					XSSFWorkbook workbook = new XSSFWorkbook(n);  // taking workbook from that excel file
					XSSFSheet sheet = workbook.getSheetAt(0);  // taking sheet from that excel file workbook that is sheet1
					int rows = sheet.getLastRowNum();   // storing number of rows in rows variable by using getRowLastnum method
					int cols = sheet.getRow(0).getLastCellNum(); // storing number of cloumns in cols variable by using getLastCellnum method  at row zero
					XSSFRow row_at_zero = sheet.getRow(0);  // first row in excel sheet it is zero row
					for (int r = 1; r <= rows; r++) { // reading sheet row by row from row = 1 not zero because row zero contains headings like name,passowrd
						XSSFRow row = sheet.getRow(r);  //taking row after row by increasing r value
						XSSFCell cell_at_zero = row.getCell(0);  //taking coloumn zero ,  every row increases
						DataFormatter dfFormatter = new DataFormatter(); // formats data from one to another type
						Object vvalueObject = dfFormatter.formatCellValue(cell_at_zero); //formats the value in that cell to object
						if (vvalueObject.equals(login_object1.Rollno)) { // if value is equal to rollnum then run if part
							var2 = r; // storing rollnumbers row number in var2  variable string
							break; //breaks the loop
						}
					}
					for (int c = 0; c < cols; c++) { //reads the coloumn by coloumn from c=0 to c=cols
						XSSFCell cell = row_at_zero.getCell(c);
						// cell value at row zero(0th row) as coloumn get increased
						DataFormatter dFormatter = new DataFormatter();  // formats data from one to another type
						Object valueObject = dFormatter.formatCellValue(cell);  //formats the value in that cell to object
						if (valueObject.equals("AGE")) {
							//it is in for loop so it will check every coloumn at row zero
							// if coloumn cell at row zero is equal to AGE then run this if part
							var = c; //storing coloumn number in var string variable
						}
						if (valueObject.equals("PHONENO")) {
							//it is in for loop so it will check every coloumn at row zero
							// if coloumn cell at row zero is equal to PHONENUMBER then run this if part
							 //storing coloumn number in var1 string variable
							var1 = c;
						}
					}

					XSSFRow row = sheet.getRow(var2); //Creating a row at var2(var 2 is row number of rollnumber)

					XSSFCell cell1 = row.createCell(var); // creating a cell at var2 row and var number coloumn
					XSSFCell cell2 = row.createCell(var1);// creating a cell at var2 row and var1 number coloumn
					cell1.setCellValue(age);// setting the cell value (writing in that cell)
					cell2.setCellValue(Pno);// setting the cell value (writing in that cell)

					FileOutputStream er = new FileOutputStream(login_object1.File_path); // writing in excel file appending type
					workbook.write(er);
					er.close();

				}
				if (login_object1.state || state67) {
					// as said state is a boolean variable in loginpage
					// we are taking state variable from loginpage thats y we created object for login class
					// state is a boolean variable in loginpage class if that state is true then run this if loop
					//if in loginpage he types wrong password or wrong rollnumber we dont want to ask age and phone number in registrationpage
					//so in loginpage for login successfull only we put state = true then we will ask below questions
					//state67 is for teacher for registration to ask password recovery questions not age,phonenumber
					//In teacherregistration state67 = true; as we want to access it
					System.out.println(ConsoleColors.BANANA_YELLOW_BACKGROUND + ConsoleColors.RED_BOLD + "                                   <<<< PLEASE ANSWER THE FOLLOWING QUESTIONS FOR PASSWORD RECOVERY >>>>" + "\u001B[0m");
					System.out.println(ConsoleColors.BLUE_BOLD + "1.WHO IS YOUR ROLE MODEL?");
					String answer1 = scan2.nextLine();  //storing name in answer1
					System.out.println(ConsoleColors.BLUE_BOLD + "2.WHAT IS YOUR PET NAME?");

					String answer2 = scan2.nextLine(); //storing pet name in answer2

					recoveryfile_printwriter.println(login_object1.Rollno + "," + answer1 + "," + answer2);
					System.out.println(ConsoleColors.BANANA_YELLOW_BACKGROUND + ConsoleColors.GREEN_BOLD + "                                          $$$$ REGISTRATION SUCCESSFUL $$$$" + "\u001B[0m");

					if (!state76) { //state76 is true for student and false for teacher as
						// state76is used for age and phonenumber which neede for student that's y true for student and false for teacher
						// if true  goto teacherlogin

						ForgotPassword_option = true;  // we are giving forgotoption as true (boolean variable)
						//because while registering we dont want to accesss forgotpassword that time put it as false
						// now registration completed so we can change forgot options boolean variable to true;
						// now we can access forgot option
						login_object1.teacherregistration_boolean_for_options = true;
						//while registering we dont want to access students main page options like marks,attendence
						//so we will keep as false in teacherregistration methos false
						// now registration completed we can access now as boolean changed to true
						login_object1.TeacherLogin();
					} else {  //if false goto studentlogin
						ForgotPassword_option = true;// we are giving forgotoption as true (boolean variable)
						//because while registering we dont want to accesss forgotpassword that time put it as false
						// now registration completed so we can change forgot options boolean variable to true;
						// now we can access forgot option
						login_object1.studentregistration_boolean_for_options = true;
						//while registering we dont want to access students main page options like marks,attendence
						//so we will keep as false in studentregistration methos false
						// now registration completed we can access now as boolean changed to true
						login_object1.StudentLogin();

					}
				}
				recoveryfile_printwriter.close();

			}
		}}
	public void StudentRegistration() throws IOException {
		login_object1.Rollnum_txtfile_notcontains = true;
		//assuming rollnumber existed in textfile for first registering
ForgotPassword_option = false; // while registering we are saying forgotoption as false so we dont want to access it while registration
		login_object1.studentregistration_boolean_for_options = false;
		//while registering you dont want to access main page options thats y stdentoptions like marks,attendence they are kept as false
		login_object1.StudentLogin();
		state76 = true;  // boolean saying can access the age phonenumber part
		Registration();
	}
	public void TeacherRegistration() throws IOException {

		login_object1.Rollnum_txtfile_notcontains = true;
		//assuming rollnumber existed in textfile for first registering
		ForgotPassword_option = false; // while registering we are saying forgotoption as false so we dont want to access it while registration
		login_object1.student_registration_boolean = false;
		login_object1.teacherregistration_boolean_for_options = false;
		//while registering you dont want to access main page options thats y stdentoptions like marks,attendence they are kept as false

		state76=false;  // boolean saying cannot access the age phonenumber part
		state67 = true; //can access rolemodel,petname part
		login_object1.TeacherLogin();
		Registration();

	}
}
