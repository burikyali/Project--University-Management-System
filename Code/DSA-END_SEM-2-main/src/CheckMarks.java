import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
class CheckMarks {
	LoginPage tr = new LoginPage();
	private static String sub;
	static int var222;
	static int var32;

	void checkMarks() throws IOException {
		Scanner sw = new Scanner(System.in);

		while(true) {
			System.out.println("1.Mat");
			System.out.println("2.Dsa");
			System.out.println("3.Eng");
			System.out.println("4.Exit");
			System.out.println(ConsoleColors.BANANA_YELLOW_BACKGROUND+ConsoleColors.PURPLE_BOLD+"                                                 ^^^^  ENTER THE OPTION  ^^^^"+"\u001B[0m");
			String subject1 = sw.nextLine(); //asking option and storing it in subject1 string
			if(subject1.equals("1")) {
				sub = "MAT";
				marks();

			}
			else if(subject1.equals("2")) {
				sub = "DSA";
				marks();

			}
			else if(subject1.equals("3")) {
				sub = "ENG";
				marks();

			}
			else if(subject1.equals("4")) {

				break;
			}
			else {
				System.out.println(ConsoleColors.RED_BOLD+"                                                  $$$  PLEASE ENTER THE CORRECT OPTION $$$"+"\u001B[0m");

			}
		}


	}
	private void marks() throws IOException {
		FileInputStream  n = new FileInputStream("Book1.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(n); // taking workbook from that excel file
		XSSFSheet sheet = workbook.getSheetAt(0); // taking sheet from that excel file workbook that is sheet1
		int rows = sheet.getLastRowNum(); // storing number of rows in rows variable by using getRowLastnum method
		int cols = sheet.getRow(0).getLastCellNum(); // storing number of coloumns in cols variable by using getLastCellNum method
		XSSFRow row_at_zero = sheet.getRow(0);  //// first row in excel sheet it is zero row
		for(int r=1;r<=rows;r++) {  // reading sheet row by row from row = 1 not zero because row zero contains headings like name,passowrd
			XSSFRow bgg = sheet.getRow(r); //taking row after row by increasing r value
			XSSFCell hjr = bgg.getCell(0); //taking coloumn zero ,  every row increases
			DataFormatter dfFormatter = new DataFormatter(); // formats data from one to another type
			Object vvalueObject = dfFormatter.formatCellValue(hjr); //formats the value in that cell to object
			if(vvalueObject.equals(tr.Rollno)) { // if value is equal to rollnum then run if part
				var222 = r;// storing rollnumbers row number in var2  variable string
				break;//breaks the loop
			}
		}
		System.out.println(ConsoleColors.GREEN_BOLD+"+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++"+"\u001B[0m");
		for(int c =0;c<cols;c++) { //reads the coloumn by coloumn from c=0 to c=cols
			XSSFCell hj = row_at_zero.getCell(c);
			// cell value at row zero(0th row) as coloumn get increased
			DataFormatter dFormatter = new DataFormatter(); // formats data from one to another type
			Object valueObject = dFormatter.formatCellValue(hj); //formats the value in that cell to object

			if(valueObject.equals(sub)) { //if  value at row zero is equal to subject name then  store coloumn number at var32
				var32 = c;
				XSSFRow row1 = sheet.getRow(var222); // rollnumber row
				XSSFCell cell1 = row1.getCell(var32); // in that row specific var32 coloumn
				DataFormatter dFormatter1 = new DataFormatter(); //
				Object valueObject2 = dFormatter1.formatCellValue(cell1);
String marks = valueObject2.toString(); //explicit casting from object to string
if(marks.equals("")){ //if cell value is empty then print null
	System.out.println(ConsoleColors.CYAN_BOLD+"                             MARKS  --  "+"  "+sub+"-"+"NULL"+"\u001B[0m");
	break;
}
else{ //if not empty run else part
	System.out.println(ConsoleColors.CYAN_BOLD+"                             MARKS  --  "+"  "+sub+"-"+valueObject2+"\u001B[0m");
	break;
}

			}


		}
		System.out.println(ConsoleColors.GREEN_BOLD+"+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++"+"\u001B[0m");
		System.out.println("                                                                           ");
		n.close();
	}

}
