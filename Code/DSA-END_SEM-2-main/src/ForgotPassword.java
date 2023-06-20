import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.xmlbeans.soap.SOAPArrayType;


class ForgotPassword {

	private boolean Registered_Or_not_boolean = false;
	private LoginPage l2 = new LoginPage();
	 String gg = l2.File_path;
	 public void forgotpassword() throws IOException {
		Scanner s67 = new Scanner(System.in);
		FileReader Recoveryfile_reader = new FileReader("Recoveryfile");
		BufferedReader  Recoveryfile_bufferedreader = new BufferedReader(Recoveryfile_reader);
		FileInputStream file = new FileInputStream(gg);
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheetAt(0);
		int rows = sheet.getLastRowNum();
		String line;
		while((line = Recoveryfile_bufferedreader.readLine())!=null) {
		String[]  array =  line.split(",",3);
			if(array[0].equals(l2.Rollno)) {
				System.out.println(ConsoleColors.BANANA_YELLOW_BACKGROUND+ConsoleColors.RED_BOLD_BRIGHT+"                                                          <<<< Please Answer The Questions For Password Recovery >>>>"+"\u001B[0m");
				System.out.println(ConsoleColors.BLUE_BOLD+"                                             1.WHO IS YOUR ROLE MODEL?"+"\u001B[0m");
				String que1 = s67.nextLine();
				if(que1.equals(array[1])) {
					System.out.println(ConsoleColors.BLUE_BOLD+"                                         2.WHAT IS YOU PET NAME?"+"\u001B[0m");
					String que2 = s67.nextLine();
					if(que2.equals(array[2])) {
						System.out.println(ConsoleColors.BANANA_YELLOW_BACKGROUND+ConsoleColors.CYAN_BOLD+"                                %%%  YOUR PASSWORD RECOVERED SUCCESSFULLY  %%%"+"\u001B[0m");
						 Registered_Or_not_boolean = true;
						for(int r = 0;r<=rows;r++) {
							 XSSFRow row = sheet.getRow(r);
							 XSSFCell cell_at_0 =  row.getCell(0);
							 XSSFCell cell_at_1 =  row.getCell(1);
							 if(cell_at_0.getStringCellValue().equals(l2.Rollno)) {
								 System.out.println("-----------------------------------------------------------");
								 System.out.println(ConsoleColors.PURPLE_BOLD+"         PASSWORD - "+cell_at_1.getStringCellValue()+"\u001B[0m");
								 System.out.println("------------------------------------------------------------");
								 l2.login();
								 break;
							 }
							 
						}
					}
					else {
						System.out.println(ConsoleColors.BANANA_YELLOW_BACKGROUND+ConsoleColors.PURPLE_BOLD+"                                                      ----  WRONG ANSWER  (TRY AGAIN)----" +"\u001B[0m");
						Registered_Or_not_boolean = true;
					
					}
				}
				else {
					System.out.println(ConsoleColors.BANANA_YELLOW_BACKGROUND+ConsoleColors.PURPLE_BOLD+"                               ---- WRONG ANSWER  (TRY AGAIN) ----"+"\u001B[0m" );
					Registered_Or_not_boolean =true;
				}	
			}	
		}
		if(!Registered_Or_not_boolean) {
			System.out.println(ConsoleColors.BANANA_YELLOW_BACKGROUND+ConsoleColors.GREEN_BOLD+"                                       ###  YOU ARE NOT  REGISTERED--- PLEASE REGISTER FIRST  ###"+"\u001B[0m");
		}
		Recoveryfile_bufferedreader.close();
		file.close();
		s67.close();	
	}
}
