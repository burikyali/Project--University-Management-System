import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFShape;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;

public class Marks {
    private static String subject;
    private static int var;
    Set q1 = new TreeSet(); //we use tree set because it is sorted by default and natural ordering

    private void leastmarks(){

        Iterator i1 = q1.iterator(); // using iterator which works as for loop  where q1 is set object
        while(i1.hasNext()){  // we are saying if i has next element null then stop until then run the loop
            System.out.println("Lowest Marks "+"-"+i1.next()); // printing next element one by one
            break; // stopping the loop
        }
    }
    private void Highestmarks(){
        Iterator i1 = q1.iterator(); // using iterator which works as for loop where q1 is set object
String lastelement =""; // initialising lastelement variable because treeset is sorted so last element confirmly is bigger element
        while(i1.hasNext()){
           lastelement = (String) i1.next(); // we are trying to get last element in treeset because when loop runs , everytime lastelement is biggerone
        }
        System.out.println("Highest Marks"+"-"+lastelement);
    }
    private void marks() throws IOException {
        Scanner scan = new Scanner(System.in);
        while(true){  // runs until you type exit
            System.out.println("1.MAT");  // displaying  subjects
            System.out.println("2.DSA");
            System.out.println("3.ENG");
            System.out.println("4.EXIT"); // exits loop
            String choice = scan.nextLine();
            if(choice.equals("1")){
                subject = "MAT";
            }
            else if(choice.equals("2")){
                subject = "DSA";
            }
            else if(choice.equals("3")){
                subject = "ENG";
            }
            else if(choice.equals("4")){ // types 4 it will stop the loop
break;
            }
            else{
                System.out.println(ConsoleColors.BANANA_YELLOW_BACKGROUND+ConsoleColors.GREEN_BOLD+"                                                                     Please Enter The Correct Option"+"\u001B[0m");
            }
        }
        FileInputStream file1 = new FileInputStream("Book1.xlsx");
        XSSFWorkbook workbook = new XSSFWorkbook(file1);
        XSSFSheet sheet = workbook.getSheetAt(0);
        int rows = sheet.getLastRowNum();
        int cols = sheet.getRow(0).getLastCellNum();
        for(int c=0;c<cols;c++){
            XSSFCell cell = sheet.getRow(0).getCell(c);
            if(cell.getStringCellValue().equals(subject)){
                var = c;
            }
        }
        for(int r=1;r<=rows;r++){
            XSSFCell cell2 = sheet.getRow(r).getCell(var);
            DataFormatter d1 = new DataFormatter();
            Object v = d1.formatCellValue(cell2);
            String s = (String) v;
if(s==""){
    continue;
}
else{
    q1.add(s);
}
        }
    }
   public void checkmarks() throws IOException {
        Scanner scan = new Scanner(System.in);

       marks();
       while(true){ // runs loop until you type exit because break statement is in exit option
           System.out.println("1.LeastMarks");
           System.out.println("2.HighestMarks");
           System.out.println("3.EXIT");
           System.out.println(ConsoleColors.BANANA_YELLOW_BACKGROUND+ConsoleColors.RED_BOLD_BRIGHT+"                                                ###  ENTER THE OPTION ###"+"\u001B[0m");
           String choice = scan.nextLine();
           if(choice.equals("1")){
               leastmarks();
           }
           else if(choice.equals("2")){
               Highestmarks();
           }
           else if(choice.equals("3")){
               break;
           }
           else{
               System.out.println(ConsoleColors.BANANA_YELLOW_BACKGROUND+ConsoleColors.BLUE_BOLD+"                             $$$  PLEASE ENTER THE CORRECT OPTION  $$$"+"\u001B[0m");
           }
       }
   }
}
