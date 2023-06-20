import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

class UpdateStudent {
    public void updatestudent() throws IOException {
        Scanner scan = new Scanner(System.in);
        List ROllnum_list = new ArrayList();  // storing all rollnumbers in list which are in excel
        List Password_list = new ArrayList();// storing all rpasswords in list which are in excel
        FileInputStream filereader = new FileInputStream("Book1.xlsx"); //reading excel file
        XSSFWorkbook workbook = new XSSFWorkbook(filereader); // taking workbook from that excel file
        XSSFSheet sheet = workbook.getSheetAt(0); // taking sheet from that excel file workbook that is sheet1
        int rows = sheet.getLastRowNum();   // storing number of rows in rows variable by using getRowLastnum method

        for(int r =1;r<=rows;r++) { //reading excel rows from 1 as row zero contains headings
            XSSFCell cell1 = sheet.getRow(r).getCell(0);  //gets the coloumn 0 by increasing row by row where get Row willgives that row, r will increase row by row
            XSSFCell cell2 = sheet.getRow(r).getCell(1); //gets the coloumn 1 by increasing row by row
            DataFormatter d = new DataFormatter();  // formats data oone type to another
            // (at row r at coloumn 0 you will get specific cell which contains value)
            Object value1 = d.formatCellValue(cell1); // changes the value in cell1 to object
            Object value2 = d.formatCellValue(cell2);// changes the value in cell2 to object
            String rollnum = value1.toString(); //casting Object to string (explicit casting)
            String password = value2.toString();//casting Object to string  (explicit casting)
            ROllnum_list.add(rollnum);  //adding rollnumbers to list which are in cell 0
            Password_list.add(password); //adding passwords to list which are in cell 1
        }
        System.out.println("");
        System.out.println(ConsoleColors.BLACK_BOLD+"------------------------------------------------------------------------"+"\u001B[0m");
        System.out.println(ConsoleColors.YELLOW_BOLD+"                         *** ENTER THE ROLLNUM YOU WANT TO UPDATE ***"+"\u001B[0m");
        String roll = scan.nextLine();
        if(ROllnum_list.contains(roll)){
            System.out.println("                                                         "+ConsoleColors.BANANA_YELLOW_BACKGROUND+ConsoleColors.PURPLE_BOLD+"^^^  TRY AGAIN ^^^"+"\u001B[0m");  // IF rollnum_list  contains rollnumbers then we say try again
        }
        else{  // if that list  doesnt contains rollnumbers  then generate a random 4-digit password
// generating a password for that student.
            String alphabetnumbers = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
                    + "0123456789"
                    + "abcdefghijklmnopqrstuvxyz";
            String password ="";               // alphabetnumbers variable contains small letters , numbers everything so that randomly we pick any four characters from it and generate password

            for(int i=0;i<4;i++){
                int index = (int) (alphabetnumbers.length()*Math.random()); //random is used to generate random index number until loop exists
                password = password + alphabetnumbers.charAt(index);  // when we get random index number we will use charAT method to get character at that index point and store it in password
            }

            if(Password_list.contains(password)){  // if that password already existed then try again it generates another password
                 password ="";
                for(int i=0;i<4;i++){
                    int index = (int) (alphabetnumbers.length()*Math.random());
                    password = password + alphabetnumbers.charAt(index);
                }

            }
            System.out.println(ConsoleColors.BLACK_BOLD+"-----------------------------------------------------"+"\u001B[0m");
            System.out.println(ConsoleColors.BLUE_BOLD+"        ENTER THE NAME OF THE STUDENT "+"\u001B[0m");
            System.out.println(ConsoleColors.BLACK_BOLD+"-----------------------------------------------------"+"\u001B[0m");
            String name = scan.nextLine();

XSSFCell cell1 = sheet.createRow(rows+1).createCell(0);
//From above sheet we are creating a new row just one time is enough to write create row method , after creating cell at 0 coloumn , row rows+1
            XSSFCell cell2 = sheet.getRow(rows+1).createCell(1);
            //as row is created from above method you dont want to say create row again just say get Row because your row is already created,create a cell at coloumn 1 row rows+1
            XSSFCell cell3 = sheet.getRow(rows+1).createCell(2);
            //as row is created from above method you dont want to say create row again just say get Row because your row is already created,create a cell at coloumn 2 row rows+1
            cell1.setCellValue(roll);  // writing the rollnumber in excel sheet at cell 0, row-rows+1;
            cell2.setCellValue(password);// writing the password in excel sheet at cell 1, row-rows+1;
            cell3.setCellValue(name);// writing the name in excel sheet at cell 2, row-rows+1;
            FileOutputStream writer = new FileOutputStream("Book1.xlsx");
            //Using fileoutput stream now we are taking all contents  from workbook
            workbook.write(writer);  // now writing in that workbook
            writer.close();
            System.out.println("                                                        "+ConsoleColors.BANANA_YELLOW_BACKGROUND+ConsoleColors.PURPLE_BOLD+"UPADATED SUCCESSFULLY"+"\u001B[0m");
        }
    }
}
