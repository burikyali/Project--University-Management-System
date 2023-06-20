import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.util.Stack;

public class announcements {

public void GiveAnnouncements() throws IOException {
    Scanner scan = new Scanner(System.in);
    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");   // gives date time year
    LocalDateTime now = LocalDateTime.now();  //gives current date time year
    FileWriter announcements_filewriter = new FileWriter("announcements",true);
    BufferedWriter BufferedWriter = new BufferedWriter(announcements_filewriter);
    PrintWriter announcements_fileprintwriter = new PrintWriter(BufferedWriter);
    // Writing in announcements file by using printwriter
    System.out.println(ConsoleColors.BLACK_BOLD+"----------------------------------------------------------------------------"+"\u001B[0m");
    System.out.println("               "+ConsoleColors.GREEN_BOLD+"###   WRITE THE NOTICE   ###"+"\u001B[0m");
    System.out.println(ConsoleColors.BLACK_BOLD+"----------------------------------------------------------------------------"+"\u001B[0m");
    String line = scan.nextLine(); // taking the input from user (information)  storing it in  line;
    announcements_fileprintwriter.println(line+"  -- "+now);   // printing line by line in fileusing printwriter pls time when it is written
    System.out.println(ConsoleColors.BLACK_BOLD+"                  --------------------------"+"\u001B[0m");
    System.out.println(ConsoleColors.BLUE_BOLD+"                   |  Updated Successfully |"+"\u001B[0m");
    System.out.println(ConsoleColors.BLACK_BOLD+"                  --------------------------"+"\u001B[0m");
    announcements_fileprintwriter.close(); // closing the writer file
    }
    public void Announcements() throws IOException {
FileReader announcementsFile = new FileReader("announcements");
BufferedReader announcementsfile_reader = new BufferedReader(announcementsFile);
// Reading the announcements file by using file reader and bufferedreader
String line;   // reading line by line and storing it in line

Stack stack = new Stack();   // pre defined stack class
while((line=announcementsfile_reader.readLine())!=null){
    stack.add(line);  //now adding line in stack one by one
}
        System.out.println(ConsoleColors.GREEN_BOLD+"#################################################################################################################################"+"\u001B[0m");
while(!stack.isEmpty()){  // if stack is empty stop the loop until then run the loop
    System.out.println(ConsoleColors.RED_BOLD+">>>"+" "+ConsoleColors.BLACK_BOLD+stack.pop()+"\u001B[0m");  //removing element one by one from stack by using methos pop and printing it
}
        System.out.println(ConsoleColors.GREEN_BOLD+"#################################################################################################################################"+"\u001B[0m");
        System.out.println("                             ");
            announcementsfile_reader.close();
    }
}
