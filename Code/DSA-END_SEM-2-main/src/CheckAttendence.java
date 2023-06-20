import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

class CheckAttendence {
	// making private so that other class cannot access this class variables or objects to avoid unnecessary issues
	private LoginPage Loginpage_object = new LoginPage();
	private static int var22;
	private static int var12;
	void checkattendence() throws IOException {
		FileInputStream  FileReader = new FileInputStream("Book1.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(FileReader);  // taking workbook from that excel file
		XSSFSheet sheet = workbook.getSheetAt(0); // taking sheet1 from that workbook
		int rows = sheet.getLastRowNum();  // storing number of rows in rows variable by using getRowLastnum method
		int cols = sheet.getRow(0).getLastCellNum();   // storing number of coloumns in cols variable by using getLastcellnum method from just one row that is row 0
		XSSFRow row_at_zero = sheet.getRow(0);   // from sheet getting row zero
		for(int r=1;r<=rows;r++) {
			XSSFRow row = sheet.getRow(r);  // from sheet getting row by row
			XSSFCell cell_at_zero = row.getCell(0);  // getting coloumn zero from above row class
			DataFormatter dataformatter_object = new DataFormatter(); // formats data from one type to another
			Object value = dataformatter_object.formatCellValue(cell_at_zero); // formats data from string or int or boolean to object
			if(value.equals(Loginpage_object.Rollno)) {
				// if that row in coloumn zero contains value , that what we neede then i am storing row number in var22
				// coloumn zero is for rollnumbers in excel sheet
			var22 = r;
			break;  // And then stopping the loop
			}
		}
		for(int c =0;c<cols;c++) {
			XSSFCell cell = row_at_zero.getCell(c);      // now checking coloumns one by one in row zero
			DataFormatter dFormatter = new DataFormatter();
			Object valueObject = dFormatter.formatCellValue(cell);
			
			if(valueObject.equals("ATTENDENCE")) {  // if that coloumn cell contains value storing that coloumn number in var12
				var12 = c;
				break;  // And then stopping the loop
			}
		}
			XSSFRow specificrow = sheet.getRow(var22); // getting specific var22 row, var22 contains the row number from before loop
			
			
			XSSFCell Specificcell = specificrow.getCell(var12);   // getting specific var12 coloumn, var12 contains the coloumn number from before loop
			DataFormatter dFormatter1 = new DataFormatter();  // formats data from one type to another
			Object valueObject = dFormatter1.formatCellValue(Specificcell); // formats data from string or int or boolean to object
			if(valueObject=="") {  // if the cell at var22 row and var12 coloumn cell contains nothing then attendence is not updateed
				System.out.println(ConsoleColors.GREEN_BOLD+"+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++"+"\u001B[0m");
				System.out.println(ConsoleColors.RED_BOLD+"               | ATTENDENCE NOT UPDATED |"+"\u001B[0m");
				System.out.println(ConsoleColors.GREEN_BOLD+"+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++"+"\u001B[0m");
				System.out.println("                                       ");
			}
			else {
				System.out.println(ConsoleColors.GREEN_BOLD+"+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++"+"\u001B[0m");
				System.out.println(ConsoleColors.PURPLE_BOLD+"  ATTENDENCE PERCENTAGE    --  "+ConsoleColors.BLACK_BOLD+valueObject);
				System.out.println(ConsoleColors.GREEN_BOLD+"+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++"+"\u001B[0m");
				System.out.println("                                                              ");
			}
				FileReader.close();
	}

}
