import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.*;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
class GiveAttendence {
	LoginPage tr = new LoginPage();
	Scanner sw = new Scanner(System.in);


	boolean tf = false;

	static String roll;

	static int var35;
	boolean tf23 = true;

	static String g1;
	static String g2;
	private static int var2;
	private  int var;
	private int var11;


	Queue q1 = new ArrayDeque();


	private void AttendenceByRollNo() throws IOException {


		

		DataFormatter dfFormatter = new DataFormatter();
		FileInputStream  n = new FileInputStream("Book1.xlsx");
		XSSFWorkbook t = new XSSFWorkbook(n);
		XSSFSheet sheet = t.getSheetAt(0);
		int rows = sheet.getLastRowNum();
		int cols = sheet.getRow(0).getLastCellNum();

		for(int r=1;r<=rows;r++) {
			XSSFRow bgg = sheet.getRow(r);
			XSSFCell hjr = bgg.getCell(0);

			Object vvalueObject = dfFormatter.formatCellValue(hjr);
			if(vvalueObject.equals(roll)) {
			var2 = r;                                            //rollno stored in var2
			tf23 = false;
			break;
			}
		}

		if(tf23) {													//if tf23 is set to true it prints error
			System.out.println("                                        !!! Please Enter Correct Rollno !!!");
		}
		else {
			while(true) {
				System.out.println("1.Mat");					//prints all the subjects and depending on user selection
				System.out.println("2.Dsa");					// the "SubjectAttended" and "SubjectTotalClasess gets stored in g1 and g2
				System.out.println("3.Eng");					// and the attendnce method is called.
				System.out.println("4.Exit");
				System.out.println("                        ^^^^  Enter The Option  ^^^^");
				String subject1 = sw.nextLine();
				if(subject1.equals("1")) {
					g1 = "MatAttended";
					g2 = "MatTotalclasses";
					attendnce();
					System.out.println("                               -- Successfully Updated --");
				}
				else if(subject1.equals("2")) {
					g1 = "DsaAttended";
					g2 = "DsaTotalclasses";
					attendnce();
					System.out.println("                               -- Successfully Updated --");
				}
				else if(subject1.equals("3")) {
					g1 = "EngAttended";
					g2 = "EngTotalclasses";
					attendnce();
					System.out.println("                               -- Successfully Updated --");
}
				else if(subject1.equals("4")) {
					break;
				}
				else {
					System.out.println("                                                  $$$ Please Enter The Correct Option $$$");
				}
			}
			
				
			
		}
		
	}
	private void attendnce() throws IOException {
		FileInputStream  n1 = new FileInputStream("Book1.xlsx");
		XSSFWorkbook t = new XSSFWorkbook(n1);
		XSSFSheet sheet = t.getSheetAt(0);
		int rows = sheet.getLastRowNum();
		int cols = sheet.getRow(0).getLastCellNum();     ///doubt
		XSSFRow bg = sheet.getRow(0);
		for(int c =0;c<cols;c++) {
			XSSFCell hj = bg.getCell(c);
			DataFormatter dFormatter = new DataFormatter();
			Object valueObject = dFormatter.formatCellValue(hj);
			if(valueObject.equals(g1)) {
				var = c;                                            //column number of the "subject attended gets stored in var
			}
			if(valueObject.equals(g2)) {
				var11 = c;											//column number of the "subject total clasess gets stored in var11
			}	
		}
		
		
		XSSFRow bgg111 = sheet.getRow(var2);                               //getting row of roll no
		
		XSSFCell hjr11 = bgg111.getCell(var);                             //getting cell value of the row of the rollno (ie.the Subjectattended column)
		XSSFCell hjrr211 = bgg111.getCell(var11);						// getting cell value of the row of the rollno (ie. the Subjecttotalattened column)
		
		DataFormatter d = new DataFormatter();
		Object ob1 = d.formatCellValue(hjr11);							//uses dataformatter to convert the cell value to string by crreating sn object of dataformatter
		Object ob2 = d.formatCellValue(hjrr211);
	String v34 = ob1.toString();										//v34 is the string containing the value present in "subjectattended" and
																        //v342 is the string contaiing the value present in "subjecttotalattended"
	String v342 = ob2.toString();

		System.out.println(v34);
		System.out.println(v342);
		System.out.println("---------------------------------------------------");
		System.out.println("1.Present");
		System.out.println("2.Absent");
		System.out.println("---------------------------------------------------"); //depending on the option selected we check either present or absent for each roll
		System.out.println("                  !!! Enter The Option !!!");
		String att = sw.nextLine();

		XSSFCell hjr2= sheet.getRow(var2).createCell(var);                          //gets the exact cell of "SUbjectAttended" & "subjectTotalclasess" by var2,var&var11
		XSSFCell hjrr23 = sheet.getRow(var2).createCell(var11);						// and then removes the cell value by createcell and allows us to replace the value


		if(att.equals("1")) {

			// when present is selcted we go to this fucntion

			if(v34.equals("") && v342.equals("")) {
				hjr2.setCellValue(1);                     //when both cells have null values we set both values of cell as 1 (both hjr2 and hjrr23)
				hjrr23.setCellValue(1);
			}
			else if(v34.equals("")) {
				int i12 =(Integer.valueOf(v342))+1;			//when the attended cell has null value, we increment the value of v342 and
				hjr2.setCellValue(1);						// set cell value of attended to 1 and pastes the value in v342 after incrementing it
				hjrr23.setCellValue(i12);
			}
			else if(v342.equals("")) {
				int i1 = (Integer.valueOf(v34))+ 1;			//when the totalclasess has null value we increment the value in v34(attended) by 1
				hjr2.setCellValue(i1);						//and pastes the value after incrementing into both v34 and v342.
				hjrr23.setCellValue(i1);
			}
			else {
				int i12 =(Integer.valueOf(v342))+1;				//else we inrement the value of both attended and totalclasess and pastes it into both cells
				int i1 = (Integer.valueOf(v34))+ 1;


				hjr2.setCellValue(i1);
				hjrr23.setCellValue(i12);
			}
		}
		else if(att.equals("2")) {


			if(v34.equals("") && v342.equals("")) {						//when absent is selcted and both v34 and v342 are empty we set the value of
				hjr2.setCellValue(0);									//v34(attended) to 0 and v342(total clasess) to 1.
				hjrr23.setCellValue(1);
			}
			else if(v34.equals("")) {									//if v34 is null(ie.attended is null), we increment the value of v342 and paste it
				int i121 = (Integer.valueOf(v342))+1;					//into total clasess cell. after that we set the cell value of attended to 0
				hjr2.setCellValue(0);
				hjrr23.setCellValue(i121);
			}
			else if(v342.equals("")) {
				int i11 =(Integer.valueOf(v34));						//if total clasess attended is null, we get the value of clasessattended
				hjr2.setCellValue(i11);									// and sets it as cell value of totalclasess
				hjrr23.setCellValue(i11);
			}
			else{
				int i11 =(Integer.valueOf(v34));						//Else we increment jus the cell value of totalclasess and sets the value
				int i121 = (Integer.valueOf(v342))+1;					//of each

				hjr2.setCellValue(i11);
				hjrr23.setCellValue(i121);
			}

		}
		else {
			System.out.println("                          %%%  Enter The Correct Option  %%%");
		}

		FileOutputStream er = new FileOutputStream("Book1.xlsx");					//we need to use fileoutputstream to write to the excel files
		t.write(er);
		er.close();

	}
	public void ClassAttendence() throws IOException {
		FileInputStream  n1 = new FileInputStream("Book1.xlsx");
		XSSFWorkbook t = new XSSFWorkbook(n1);
		XSSFSheet sheet = t.getSheetAt(0);
		int rows = sheet.getLastRowNum();								//we read the excel file, get the sheet at index 0 and gets the rows
		System.out.println(rows);
		for(int r=1;r<=rows;r++){										//we iterate through all the rows in the excel file and gets the 0th cell value of
			XSSFCell bg = sheet.getRow(r).getCell(0);			// each cell (ie.rollno) and uses dataformatter to convert it into string
			DataFormatter d3 = new DataFormatter();						//and adds the string (ie. rollno.) to the queue.
			Object ob4 = d3.formatCellValue(bg);
			String w = (String) ob4;
			q1.add(w);
			System.out.println(q1);
		}
		n1.close();
		while(!q1.isEmpty()){
			String r1 = (String) q1.poll();								//if the queue is not empty,The poll() method of Queue Interface
			System.out.println(r1);										//returns and removes the element at the front of the queue (ie. 1,2,3...etc)
			System.out.println(q1);
			roll = r1 ;
			System.out.println("              "+roll);						// we print each roll no. and until the queue is empty we run the attendencebyroll function
			AttendenceByRollNo();											// and percentage attendance
			percentageAttendence();
		}

	}

	public void giveAttendenceByRollNo() throws IOException {
		System.out.println("                        ^^^^  Enter The Rollno  ^^^^");
		roll = sw.nextLine();
		AttendenceByRollNo();
		percentageAttendence();

	}
	private void percentageAttendence() throws IOException {
		FileInputStream  n12 = new FileInputStream("Book1.xlsx");
		XSSFWorkbook t2 = new XSSFWorkbook(n12);
		XSSFSheet sheet = t2.getSheetAt(0);
		int rows = sheet.getLastRowNum();												//we store all the subjectattended and subjecttotalclasess in a array
		int cols = sheet.getRow(0).getLastCellNum();							// and also intiialize two arraylists q2 and q25.
		String attendence = "ATTENDENCE";
		String[] array1 = new String[]{"MatTotalclasses","EngTotalclasses","DsaTotalclasses"};
		String[] array2 = new String[]{"MatAttended","EngAttended","DsaAttended"};
		List q2 = new ArrayList();
		List q25 = new ArrayList();

		for(int i =0;i<array1.length;i++){
		for(int c =0;c<cols;c++){

			XSSFCell c43 = sheet.getRow(0).getCell(c);
			DataFormatter d3 = new DataFormatter();
			Object ob45 = d3.formatCellValue(c43);						//here we check through all the columns in the excel sheet and checks whether any of the
			String answer = (String) ob45;								// columns in row 0 match the entries in the array. If it encounters any element in the array1
																		// we add the column number to the q2 arraylist and the column number  of any element
			if(answer.equals(array1[i]))								// encountered in array2 is added to q25 arraylist.
			{
			q2.add(c);
			}
			else if(answer.equals(array2[i]))							// if it encounters attendence string it adds the column number to var35
			{
				q25.add(c);
			}
			if(answer.equals(attendence)){
				var35 = c;												//var35 has the column number of attendence
			}
		}}
		 int i3 =0;
		 int i34 =0;
		for(int i =0;i<array1.length;i++){
			XSSFCell bg = sheet.getRow(var2).getCell((int)q2.get(i));
			DataFormatter d3 = new DataFormatter();
			Object ob4 = d3.formatCellValue(bg);								// we set i3 and i34 as zero. for each element in the array we iterate through the
			String answer3 = (String) ob4;										// excel file. we use sheet.getrow(var2) to get the row of the rollno and uses the column
			XSSFCell bg1 = sheet.getRow(var2).getCell((int) q25.get(i));		// number stored in q2 arraylist to get the value of the total clasess for that subject.
			Object ob41 = d3.formatCellValue(bg1);								// we store that value in answer3
			String answer31 = (String) ob41;

																					//similiarly, for attendance we get the row of the rollno stored in var and uses
			i3 = i3+Integer.valueOf(answer3);										// the column number in the q25 arraylist to get the value of totalattended clasess
			i34=i34+Integer.valueOf(answer31);										//and stores it in answer31

		}																			// we then add the values to i3 and i34. and for each element in the array it iterates
																					// four times and we get the total attendance in i34 and totalclasess in i3
		double percentage = (Double.valueOf(i34)/Double.valueOf(i3))*100;

		XSSFCell cell7 = sheet.getRow(var2).createCell(var35);						//we calculate the percentage of the attendance by 134 divided by i3 mult by 100

		cell7.setCellValue(percentage);												//we get the row and column for the attendance% cell by var2 and var35
																					//where we stored the values and we set the cell value to 'percentage'
		FileOutputStream file5 = new FileOutputStream("Book1.xlsx");
		t2.write(file5);															//we use fileoutputstream and t2.write to write the changes to the excel sheet
		file5.close();
	}
}
