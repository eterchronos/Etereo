package Ui;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;



public class EmployeeUi {

	private JTable table 						= new JTable(1,4);
	private JTextField jftEmployeeName			= new JTextField();
	private JTextField jtfEmployeeValue			= new JTextField();
	private JTextField jtfEmployeeYear			= new JTextField();
	private JScrollPane scrollPane 				= new JScrollPane(table);
	private JDialog windowEmployee 				= new JDialog();
	private JComboBox<String> comboCargo		= new JComboBox<>();
	private JButton btnInsert					= new JButton("Add");
	private JButton btnDelete					= new JButton("Del");
	private JButton btnUpdate					= new JButton("Upd");
	private JLabel lblEmployee					= new JLabel("Name");
	private JLabel lblPrice						= new JLabel("Year");
	private JLabel lblSalary					= new JLabel("Salary");
	private int idItemList;
	
	
	public EmployeeUi() {
	windowUi();
	}

	public void windowUi() {

	windowEmployee.setTitle("Expense Manager");
	windowEmployee.setVisible(true);
	windowEmployee.setSize(500,330);
	windowEmployee.setLocationRelativeTo(null);
	windowEmployee.getContentPane().setLayout(null);
	windowEmployee.setDefaultCloseOperation(JDialog.HIDE_ON_CLOSE);
	windowEmployee.setAlwaysOnTop(true);
	windowEmployee.setResizable(false);
	
	windowEmployee.add(jftEmployeeName);
	windowEmployee.add(jtfEmployeeValue);
	windowEmployee.add(lblEmployee);
	windowEmployee.add(lblPrice);
	windowEmployee.add(comboCargo);
	windowEmployee.add(jtfEmployeeYear);
	windowEmployee.add(lblSalary);
	windowEmployee.add(btnDelete);
	windowEmployee.add(btnInsert);
	windowEmployee.add(btnUpdate);
	windowEmployee.add(scrollPane);

	
	
	jftEmployeeName.setBounds(24, 30, 160, 19);
	jtfEmployeeValue.setBounds(200, 60, 80, 19);
	btnInsert.setBounds(340,15,100,20);
	btnUpdate.setBounds(340,35,100,20);
	btnDelete.setBounds(340,55,100,20);
	scrollPane.setBounds(0, 90, 500, 200);
	lblEmployee.setBounds(24,11,100,20);
	lblPrice.setBounds(200,11,100,20);
	comboCargo.setBounds(24, 60, 160, 19);
	jtfEmployeeYear.setBounds(200, 30, 80, 19);
	lblSalary.setBounds(200,45,100,20);
	
	jtfEmployeeValue.setColumns(10);
	
	jftEmployeeName.setColumns(10);

	
	scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
	table.setRowHeight(15);
	

}
}
