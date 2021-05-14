package Ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTable;
import javax.swing.JTextField;

public class Dashboard {
	OccupationUi occupationUi = new OccupationUi();
	ExpenseUi		 expenseUi	  = new ExpenseUi();
	
	private JFrame windowDashboard 		= new JFrame();
	private JFrame windowOccupation 	= new JFrame();
	private JMenuBar menuBar 			= new JMenuBar();
	private JMenu menuManager 			= new JMenu("Manager");
	private JMenuItem miOccupation 		= new JMenuItem("Occupation");
	private JMenuItem miCompany 		= new JMenuItem("Company");
	private JMenuItem miExpense 		= new JMenuItem("Expense Manager");

	private JTextField jtfOccupationId	= new JTextField();
	private JTextField jtfOccupationTxt	= new JTextField();
	
	private JButton btnInsert			= new JButton("Add");
	private JButton btnDelete			= new JButton("Delete");
	private JButton btnUpdate			= new JButton("Update");
	
	private JTable occupationPane 		= new JTable(1,2);
	
	public Dashboard() {

		dashboard();
		listeners();
		}
	
	
	public void dashboard() {
		windowDashboard.setTitle("Etereo - beta");
		windowDashboard.setVisible(true);
		windowDashboard.setSize(800,600);
		windowDashboard.setLayout(null);
		windowDashboard.setResizable(false);
		windowDashboard.setLocationRelativeTo(null);
		windowDashboard.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		windowDashboard.add(menuBar);
		windowDashboard.add(menuManager);
		
		menuBar.setBounds(0,0,800,20);
		menuBar.add(menuManager);
		menuManager.add(miOccupation);
		menuManager.add(miExpense);
		}

	
	
	private void listeners() {
		miOccupation.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				occupationUi.windowUi();
				
			}});

		miExpense.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				expenseUi.windowUi();
				
			}});
	}

	}
	

