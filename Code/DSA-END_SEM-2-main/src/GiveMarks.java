import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
class GiveMarks {
	LoginPage tr = new LoginPage();
	boolean tf = false;
	boolean tf1 = false;
	static int var2;
	static int var;
	void givemarks() throws IOException {
		Scanner sw = new Scanner(System.in);
		System.out.println("                        ^^^^  Enter The Rollno  ^^^^");
		String rollnum = sw.nextLine();
		System.out.println("                        ^^^^  Enter The Subject Name  ^^^^");
		String subject = sw.nextLine();
		FileInputStream  n = new FileInputStream("Book1.xlsx");
		XSSFWorkbook t = new XSSFWorkbook(n);
		XSSFSheet sheet = t.getSheetAt(0);
		int rows = sheet.getLastRowNum();
		int cols = sheet.getRow(0).getLastCellNum();
		XSSFRow bg = sheet.getRow(0);
		for(int r=1;r<=rows;r++) {
			XSSFRow bgg = sheet.getRow(r);
			XSSFCell hjr = bgg.getCell(0);
			DataFormatter dfFormatter = new DataFormatter();
			Object vvalueObject = dfFormatter.formatCellValue(hjr);
			if(vvalueObject.equals(rollnum)) {
			var2 = r;
			tf1=false;
			break;
		
			}
			else {
				tf1 = true;
			}
		}
		if(tf1) {
			System.out.println("                                        !!! Please Enter Correct Rollno !!!");
		}
		
		for(int c =0;c<cols;c++) {
			XSSFCell hj = bg.getCell(c);
			DataFormatter dFormatter = new DataFormatter();
			Object valueObject = dFormatter.formatCellValue(hj);
			if(valueObject.equals(subject)) {
				var = c;
				tf=false;
				break;
			}
			
			else {
				tf = true;
			}
			
			
		}
		n.close();
		if(tf) {
			System.out.println("                                        !!! Please Enter Correct Subject name !!!");
		}
		else {

			
           XSSFCell hjr19 = sheet.getRow(var2).createCell(var);
			System.out.println("   Enter the marks You want to enter");
			String mark = sw.nextLine();
			

			hjr19.setCellValue(mark);
				FileOutputStream er = new FileOutputStream("Book1.xlsx");
				t.write(er);
				er.close();
		}
			
	}

}
