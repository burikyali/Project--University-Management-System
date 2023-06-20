import java.awt.color.ProfileDataException;
import java.io.IOException;
import java.util.Scanner;
import java.io.*;

public class MainPage {
	public static void main(String[] args) throws IOException {
		Scanner se = new Scanner(System.in);
		LoginPage l = new LoginPage();
		RegistrationPage q = new RegistrationPage();
		System.out.println(ConsoleColors.BANANA_YELLOW_BACKGROUND+"                                       "+ConsoleColors.RED_BOLD_BRIGHT+"                        AMRITA VISWA VIDHYAPEETAM");
		System.out.println("\u001B[0m"+"          ");
	while(true){
		System.out.println(ConsoleColors.BLACK_BOLD+"----------------------------------------------------------------"+"\u001B[0m");
	System.out.println("1.LOGIN");
	System.out.println("2.REGISTER");
		System.out.println(ConsoleColors.BLACK_BOLD+"----------------------------------------------------------------"+"\u001B[0m");
		System.out.println("                                             "+ConsoleColors.BANANA_YELLOW_BACKGROUND+ConsoleColors.CYAN_BOLD+"|||  ENTER THE OPTION |||"+"\u001B[0m");
	String w = se.nextLine();
if(w.equals("1")) {
	System.out.println(ConsoleColors.BLACK_BOLD+"----------------------------------------------------------------"+"\u001B[0m");
	System.out.println("1.STUDENTLOGIN");
	System.out.println("2.TEACHERLOGIN");
	System.out.println(ConsoleColors.BLACK_BOLD+"----------------------------------------------------------------"+"\u001B[0m");
	System.out.println(ConsoleColors.BANANA_YELLOW_BACKGROUND+ConsoleColors.CYAN_BOLD+"                                             |||  ENTER THE OPTION |||"+"\u001B[0m");
	String w1 = se.nextLine();
	if(w1.equals("1")) {
		l.StudentLogin();
		break;
	}
	else if(w1.equals("2")) {
		l.TeacherLogin();
		break;
	}
	else {
		System.out.println(ConsoleColors.BANANA_YELLOW_BACKGROUND+ConsoleColors.PURPLE_BOLD+"                                               %%% ENTER THE CORRECT OPTION %%%"+"\u001B[0m");

	}
	}
else if(w.equals("2")){
	System.out.println(ConsoleColors.BLACK_BOLD+"----------------------------------------------------------------"+"\u001B[0m");
	System.out.println("1.STUDENTREGISTRATION");
	System.out.println("2.TEACHERREGISTRATION");
	System.out.println(ConsoleColors.BLACK_BOLD+"-----------------------------------------------------------------"+"\u001B[0m");
	System.out.println(ConsoleColors.BANANA_YELLOW_BACKGROUND+ConsoleColors.CYAN_BOLD+"                                             |||  ENTER THE OPTION |||"+"\u001B[0m");
	String w1 = se.nextLine();

	if(w1.equals("1")) {
		q.StudentRegistration();
		break;
	}
	else if(w1.equals("2")) {
		q.TeacherRegistration();
		break;
	}

	else {
		System.out.println(ConsoleColors.BANANA_YELLOW_BACKGROUND+ConsoleColors.RED_BOLD_BRIGHT+"                                               %%%  ENTER THE CORRECT OPTION %%%"+"\u001B[0m");
	}
	}
else {
	System.out.println(ConsoleColors.BANANA_YELLOW_BACKGROUND+ConsoleColors.RED_BOLD_BRIGHT+"                                               %%%  ENTER THE CORRECT OPTION %%%"+"\u001B[0m");
}}

	}
}
