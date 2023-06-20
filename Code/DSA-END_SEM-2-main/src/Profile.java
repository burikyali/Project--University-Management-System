import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.ss.usermodel.Row.MissingCellPolicy;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

class profile{
	static boolean state89;
	String path;
	static String rollnum;
	private LoginPage loginpage_object = new LoginPage();
	public void profile() throws IOException {
		SearchStudentDetails s1 = new SearchStudentDetails();
		 Map list67 = new HashMap();
		 System.out.println(ConsoleColors.PURPLE_BOLD+"                                                                     !!!  PROFILE  !!!    ");

		 if(state89){
		path = loginpage_object.File_path;
		 }
		 else{
			 path = "Book1.xlsx";
		 }
		 FileInputStream FileREader = new FileInputStream(path);
		 XSSFWorkbook workbook = new XSSFWorkbook(FileREader);
		 XSSFSheet shhet = workbook.getSheetAt(0);
		 int rows = shhet.getLastRowNum();
			for(int r = 1;r<=rows;r++) {
				 XSSFRow row = shhet.getRow(r);
				 XSSFCell Cell_at_zero =  row.getCell(0);
				 switch(Cell_at_zero.getCellType()) {
				 case STRING: list67.put(Cell_at_zero.getStringCellValue(),r);break;
				 }
				 	}
			if(state89){
				rollnum = loginpage_object.Rollno;
			}
			else{
				rollnum = s1.rollnum1;
			}
			int cols = shhet.getRow(0).getLastCellNum();

		System.out.println(ConsoleColors.GREEN_BOLD+"++++++++++++++++++++++++++++++++++++++++++++++++++++++ |"+"\u001B[0m");

		for(int r = 0;r<=rows;r++) {
				XSSFRow rtRow = shhet.getRow(r);
			for(int c=0;c<cols;c++) {
				XSSFRow reRow = shhet.getRow(0);
				if((int)list67.get(rollnum)==r) {
					XSSFCell cell_at_row = rtRow.getCell(c);
					XSSFCell cell_at_rowZero = reRow.getCell(c);
					try{switch(cell_at_row.getCellType()){
					case STRING :
						if(cell_at_rowZero.getStringCellValue().equals("Password")){
							break;
						}
						else{
							System.out.println(cell_at_rowZero.getStringCellValue()+"  --  "+cell_at_row.getStringCellValue());
							break;

						}
					case NUMERIC :System.out.println(cell_at_rowZero.getStringCellValue().toString()+"--"+cell_at_row.getNumericCellValue());break;
					case BOOLEAN :System.out.println(cell_at_rowZero.getStringCellValue().toString()+"--"+cell_at_row.getBooleanCellValue());break;
					}
						System.out.println("----------------------------- |");
				}
				catch(NullPointerException e) {
					System.out.println(cell_at_rowZero.getStringCellValue().toString()+"--"+"null");
					System.out.println("----------------------------- |");

				}
			}}
	}
		System.out.println(ConsoleColors.GREEN_BOLD+"++++++++++++++++++++++++++++++++++++++++++++++++++++++ |"+"\u001B[0m");
		System.out.println("                                                                             ");

	}}

	

	

