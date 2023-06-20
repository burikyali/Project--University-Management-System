import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;
/** teacher want to seaarch student details so we can use profile class directly from here as teacher types
    rollnum of that student. except password everything will be printed**/
 class SearchStudentDetails {
    static boolean state45;
    static String rollnum1;
    public void searchstudentdetails() throws IOException {
        Scanner scan2 = new Scanner(System.in);
        profile p = new profile();   // creating object for profile class
        System.out.println("                                                                     "+ConsoleColors.PURPLE_BOLD+"*** ENTER THE ROLLNUM *** "+"\u001B[0m");
        rollnum1 = scan2.nextLine(); // storing the rollnum in rollnum1 variable
        FileInputStream FileReader = new FileInputStream("Book1.xlsx"); // reading the excel file student details
        XSSFWorkbook workbook = new XSSFWorkbook(FileReader); // taking workbook from that excel file
        XSSFSheet sheet = workbook.getSheetAt(0); // taking sheet from that excel file workbook that is sheet1
        int rows = sheet.getLastRowNum(); // storing number of rows in rows variable by using getRowLastnum method
        for(int r = 1;r<=rows;r++) { ////reading excel rows from 1 as row zero contains headings
            XSSFCell cell7 = sheet.getRow(r).getCell(0); //gets the coloumn 0 by increasing row by row where get Row willgives that row, r will increase row by row
            DataFormatter d = new DataFormatter(); //formats the value from one typr to another
            Object value = d.formatCellValue(cell7); //formats the value in that cell to object
            if(value.equals(rollnum1)){ // if value is equal to rollnum then run if part
                p.state89 = false;  // state89 is a boolean variable which is used in profile class
                p.profile();  // taking you to profile class
            }
            else{
                state45 = true;  // excel sheet doent contain entered rollnum then say enter correct rollnum
                // if you put this in loop it will print always wrong entry so iwill keep boolean here
                //after end of loop i mean outside loop i will keep if part and i say if state45 is true then print this.
            }
        }
        if(state45){
            System.out.println("                                                                     "+ConsoleColors.BANANA_YELLOW_BACKGROUND+ConsoleColors.CYAN_BOLD+"^^^ PLEASE ENTER THE CORRECT ROLLNUMBER ^^^"+"\u001B[0m");

        }

    }
}
