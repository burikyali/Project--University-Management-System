import org.apache.commons.logging.Log;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.FileInputStream;
import java.io.IOException;

public class TeacherProfile {
    private  LoginPage object = new LoginPage();
    private static int variable;

    public  void teacherprofile() throws IOException {
        FileInputStream teacherDetails_filereader = new FileInputStream("TeacherDetails.xlsx"); //reading excel file
        XSSFWorkbook workbook = new XSSFWorkbook(teacherDetails_filereader); // taking workbook from that excel file
        XSSFSheet sheet = workbook.getSheetAt(0); // taking sheet from that excel file workbook that is sheet1
        int rows = sheet.getLastRowNum();  // storing number of rows in rows variable by using getRowLastnum method
        int cols = sheet.getRow(0).getLastCellNum(); // storing number of (coloumns) in cols variable by using getLastcell method at Row 0
        DataFormatter object_dataFormatter = new DataFormatter(); //Formats data
        for(int r=1;r<=rows;r++){  //reading excel rows from 1 as row zero contains headings
            XSSFCell cell = sheet.getRow(r).getCell(0);  //gets the coloumn 0 by increasing row by row where get Row willgives that row, r will increase row by row
            Object value = object_dataFormatter.formatCellValue(cell); //formats the value in taht cell to object
            String string =  value.toString(); //explicit casting  converting object to string
            if(string.equals(object.Rollno)){   // if this string contains rollnumber then store the row number in variable if not run thr loop
                variable = r;    // storing rollnumbers row number in variable string
                break; //stops the loop
            }

        }
        System.out.println(ConsoleColors.PURPLE_BOLD+"                                                                         PROFILE "+"\u001B[0m");
        System.out.println(ConsoleColors.GREEN_BOLD+"++++++++++++++++++++++++++++++++++++++++++++++++++++++ |"+"\u001B[0m");

        for(int c=0;c<cols;c++){  // reading from coloumn to zero to cols variable number
            if(c==1){  // here we are reading cell1 which contains password we dont want to print password it is private
                continue; // we are saying if  c = 1 then skip this cell goto next cell
            }
            else{  // if c not equal to 1 then run this else part
                XSSFCell cell2 = sheet.getRow(variable).getCell(c);
                // getting cell value at variable  number row and cell c ,as c increases from 0 to cols increasing coloumn
                Object value2 = object_dataFormatter.formatCellValue(cell2); // casting cell value to object
                String string2 =  value2.toString();  // explicit casting from object to string
                XSSFCell cell3 = sheet.getRow(0).getCell(c);
                // getting cell value at row 0 and cell c ,as c increases from 0 to cols increasing coloumn
                Object value3 = object_dataFormatter.formatCellValue(cell3); // casting cell value to object
                String string3 =  value3.toString(); // explicit casting from object to string
                if(string2.equals("")) { // if that cell value is null doesnt contain anything then print as null
                    System.out.println(string3 + "     -- " + "Null");
                }
                else {  // if cell value contains value then run else part
                    System.out.println(string3 + "     -- " + string2);  //  printing that coloumn heading plus cell value
                }


}

        }
        System.out.println(ConsoleColors.GREEN_BOLD+"++++++++++++++++++++++++++++++++++++++++++++++++++++++ |"+"\u001B[0m");
        System.out.println("                                                                                                 ");



    }
}
