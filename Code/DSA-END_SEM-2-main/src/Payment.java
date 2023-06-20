import java.awt.*;
import java.io.IOException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Payment extends JFrame {
	static String Amount;
	private static LoginPage l = new LoginPage();
	static int amount;
	static String s1;
	static String s2;
	static int value1;
	static int value2;
	static int var2;
	static int var32;
	static int var322;
	static String amount12;

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		FileInputStream n = new FileInputStream("Book1.xlsx");
		// reading the excel file as file path changes as user changes if user is student pathis book1.xlsx if teacher then teacherdetails.xlsx
		//thats y we put File_path as paths are mentioned in studentlogin and teacherlogin methods
		XSSFWorkbook workbook = new XSSFWorkbook(n);  // taking workbook from that excel file
		XSSFSheet sheet = workbook.getSheetAt(0);  // taking sheet from that excel file workbook that is sheet1
		int rows = sheet.getLastRowNum();   // storing number of rows in rows variable by using getRowLastnum method
		int cols = sheet.getRow(0).getLastCellNum(); // storing number of cloumns in cols variable by using getLastCellnum method  at row zero
		XSSFRow row_at_zero = sheet.getRow(0);  // first row in excel sheet it is zero row
		for (int r = 1; r <= rows; r++) { // reading sheet row by row from row = 1 not zero because row zero contains headings like name,passowrd
			XSSFRow row = sheet.getRow(r);  //taking row after row by increasing r value
			XSSFCell cell_at_zero = row.getCell(0);  //taking coloumn zero ,  every row increases
			DataFormatter dfFormatter = new DataFormatter(); // formats data from one to another type
			Object vvalueObject = dfFormatter.formatCellValue(cell_at_zero); //formats the value in that cell to object
			if (vvalueObject.equals(l.Rollno)) { // if value is equal to rollnum then run if part
				var2 = r; // storing rollnumbers row number in var2  variable string
				break; //breaks the loop
			}
		}
		for(int c =0;c<cols;c++) {
			XSSFCell cell = row_at_zero.getCell(c);  // now checking coloumns one by one in row zero
			DataFormatter dFormatter = new DataFormatter();  // formats data from one type to another
			Object valueObject = dFormatter.formatCellValue(cell); // formats data from string or int or boolean to object

			if(valueObject.equals("FEES")) {
				// if that cell value is equal to fees then store that coloumn number in var32
				var32 = c;
			}
			else if(valueObject.equals("DUE")) {
				// if that cell value is equal to due then store that coloumn number in var322
				var322 = c;
			}
		}
		XSSFCell c1_due = sheet.getRow(var2).getCell(var322);
		XSSFCell c1_fees = sheet.getRow(var2).getCell(var32);
		DataFormatter dFormatter = new DataFormatter();  // formats data from one type to another
		Object valueObject = dFormatter.formatCellValue(c1_fees); // formats data from string or int or boolean to object
		Object valueObject1 = dFormatter.formatCellValue(c1_due); // formats data from string or int or boolean to object
		s1 = valueObject.toString();
		s2 = valueObject1.toString();
		if(s1.equals("") || s2.equals("")) {
			JOptionPane.showMessageDialog(null,"          Fee Not Updated    ","ERROR", JOptionPane.ERROR_MESSAGE);

			if(l.student_registration_boolean){
				l.StudentOptions();
			}
			else{
				l.TeacherOptions();
			}
			System.exit(0);



		}
		else {
			value1 = Integer.valueOf(s1);
			value2 = Integer.valueOf(s2);
		}
		n.close();




//		XSSFRow row = sheet.getRow(var2); //Creating a row at var2(var 2 is row number of rollnumber)
//
//		XSSFCell cell1 = row.createCell(var322); // creating a cell at var2 row and var number coloumn
//
//		cell1.setCellValue("AFterdue");// setting the cell value (writing in that cell)
//
//
//		FileOutputStream er = new FileOutputStream("Book1.xlsx"); // writing in excel file appending type
//		workbook.write(er);
//		er.close();



		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Payment frame = new Payment();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Payment() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 944, 629);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Fees");
		lblNewLabel.setBounds(73, 149, 90, 14);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Due");
		lblNewLabel_1.setBounds(73, 232, 46, 14);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel(s1);
		lblNewLabel_2.setBounds(237, 149, 46, 14);
		contentPane.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel(s2);
		lblNewLabel_3.setBounds(237, 232, 46, 14);
		contentPane.add(lblNewLabel_3);

		textField = new JTextField();
		textField.setBounds(223, 335, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);

		JLabel lblNewLabel_4 = new JLabel("Amount");
		lblNewLabel_4.setBounds(73, 338, 62, 14);
		contentPane.add(lblNewLabel_4);








		JButton btnNewButton = new JButton("Pay");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {

					String Amount =textField.getText();
					amount12 = Amount.toString();
					amount = Integer.valueOf(amount12);
					if(amount12.equals("")) {

						JOptionPane.showMessageDialog(null,"          Please Enter The Amount To Continue    ","ERROR", JOptionPane.ERROR_MESSAGE);
						dispose();
						try {
							Payment.main(null);

						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
					else if(amount>value2) {
						JOptionPane.showMessageDialog(null,"         Entered amount is more than Due    ","ERROR", JOptionPane.ERROR_MESSAGE);
						dispose();
						try {
							Payment.main(null);
						} catch (IOException e2) {
							// TODO Auto-generated catch block
							e2.printStackTrace();
						}

					}
					else if(amount<0) {

						JOptionPane.showMessageDialog(null,"         Entered amount is wrong    ","ERROR", JOptionPane.ERROR_MESSAGE);
						dispose();
						try {
							Payment.main(null);
						} catch (IOException e2) {
							// TODO Auto-generated catch block
							e2.printStackTrace();
						}


					}
					else {
						int finalamount = value2 - amount;
						FileInputStream n = new FileInputStream("Book1.xlsx");
						// reading the excel file as file path changes as user changes if user is student pathis book1.xlsx if teacher then teacherdetails.xlsx
						//thats y we put File_path as paths are mentioned in studentlogin and teacherlogin methods
						XSSFWorkbook workbook = new XSSFWorkbook(n);  // taking workbook from that excel file
						XSSFSheet sheet = workbook.getSheetAt(0);  // taking sheet from that excel file workbook that is sheet1

						XSSFRow row = sheet.getRow(var2); //Creating a row at var2(var 2 is row number of rollnumber)


						XSSFCell cell2 = row.createCell(var322);// creating a cell at var2 row and var1 number coloumn

						cell2.setCellValue(finalamount);// setting the cell value (writing in that cell)

						FileOutputStream er = new FileOutputStream("Book1.xlsx"); // writing in excel file appending type
						workbook.write(er);
						er.close();
						dispose();
//					Payment.main(null);
						JOptionPane.showMessageDialog(null,"      PAYMENT SUCCESSFUL YOUR REMAINING DUE IS: "+s2,"PAYMENT SUCCESSFUL", JOptionPane.INFORMATION_MESSAGE);



					}

				}catch(Exception e1){

					JOptionPane.showMessageDialog(null,"          Please Enter The Correct Format of Amount To Continue    ","ERROR", JOptionPane.ERROR_MESSAGE);
					dispose();
					try {
						Payment.main(null);
					} catch (IOException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					}

				}

			}
		});
		btnNewButton.setBounds(161, 413, 89, 23);
		contentPane.add(btnNewButton);
	}

	private boolean isNumeric(int amount2) {
		// TODO Auto-generated method stub
		return false;
	}
}