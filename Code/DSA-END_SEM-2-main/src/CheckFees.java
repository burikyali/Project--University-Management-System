import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

class CheckFees {
	// making private so that other class cannot access this class variables or objects to avoid unnecessary issues
	private LoginPage Loginpage_object = new LoginPage();
	private static int var222;
	private static int var32;
	private static int var322;

	void checkFees() throws IOException {	
		FileInputStream  FileReader = new FileInputStream("Book1.xlsx");
		XSSFWorkbook Workbook = new XSSFWorkbook(FileReader); // taking workbook from that excel file
		XSSFSheet sheet = Workbook.getSheetAt(0); // taking sheet1 from that workbook
		int rows = sheet.getLastRowNum();   // storing number of rows in rows variable by using getRowLastnum method
		int cols = sheet.getRow(0).getLastCellNum();  // storing number of coloumns in cols variable by using getLastcellnum method from just one row that is row 0
		XSSFRow Row_at_zero = sheet.getRow(0); // from sheet getting row zero
		for(int r=1;r<=rows;r++) {
			XSSFRow row = sheet.getRow(r);   // from sheet getting row by row
			XSSFCell cell_at_zero = row.getCell(0);  // getting coloumn zero from above row class
			DataFormatter dfFormatter = new DataFormatter();  // formats data from one type to another
			Object vvalueObject = dfFormatter.formatCellValue(cell_at_zero);  // formats data from string or int or boolean to object
			if(vvalueObject.equals(Loginpage_object.Rollno)) {
				//if file contains rollnum storing row number in var222
			var222 = r;
			break; //stopping the loop
			}
		}
		for(int c =0;c<cols;c++) {
			XSSFCell cell = Row_at_zero.getCell(c);  // now checking coloumns one by one in row zero
			DataFormatter dFormatter = new DataFormatter();  // formats data from one type to another
			Object valueObject = dFormatter.formatCellValue(cell); // formats data from string or int or boolean to object
			
			if(valueObject.equals("FEES")) {
				// if that cell value is equal to fees then store that coloumn number in var32
				var32 = c;
			}
			else if(valueObject.equals("DUE")) {
				// if that cell value is equal to due then store that coloumn number in var322
				var322 = c;
			}
		}
		XSSFRow Specificrow1 = sheet.getRow(var222);  //getting row at row number var222
		XSSFCell specificcell1 = Specificrow1.getCell(var32); //getting cell at row number var222 and coloumn number var32
		XSSFCell specificcell2 = Specificrow1.getCell(var322); //getting cell at row number var222 and coloumn number var322
		DataFormatter dFormatter1 = new DataFormatter();
		Object fees= dFormatter1.formatCellValue(specificcell1);  // different objects for specificcell1 and specificcell2
		Object due= dFormatter1.formatCellValue(specificcell2);
		
			if(fees=="") { //if fees(object) cell contains nothing then print not updated
				System.out.println(ConsoleColors.GREEN_BOLD+"++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++"+"\u001B[0m");
				System.out.println(ConsoleColors.BLUE_BOLD+"            TOTAL FEES"+ConsoleColors.RED_BOLD+" == "+ConsoleColors.BLACK_BOLD+"NOT UPDATED"+"\u001B[0m");
				System.out.println(" ");
			}
			else {//if fees(object) cell contains then print fees(object)
				System.out.println(ConsoleColors.GREEN_BOLD+"++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++"+"\u001B[0m");
				System.out.println(ConsoleColors.BLUE_BOLD+"            TOTAL FEES"+ConsoleColors.RED_BOLD+" == "+ConsoleColors.BLACK_BOLD+fees+"\u001B[0m");
				System.out.println(" ");
			}
			if(due=="") {  //if due(object) cell contains nothing then print not updated

				System.out.println(ConsoleColors.BLUE_BOLD+"            DUE"+ConsoleColors.RED_BOLD+"        == "+ConsoleColors.BLACK_BOLD+"NOT UPDATED"+"\u001B[0m");
				System.out.println(ConsoleColors.GREEN_BOLD+"++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++"+"\u001B[0m");
				System.out.println(" ");
			}
			else {  //if due(object) cell contains  then print due

				System.out.println(ConsoleColors.BLUE_BOLD+"            DUE"+ConsoleColors.RED_BOLD+"        == "+ConsoleColors.BLACK_BOLD+due+"\u001B[0m");
				System.out.println(ConsoleColors.GREEN_BOLD+"++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++"+"\u001B[0m");
				System.out.println(" ");
			}

		FileReader.close(); // closing the file  studentdetails
	}

}

