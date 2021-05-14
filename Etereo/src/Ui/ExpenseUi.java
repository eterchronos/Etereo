package Ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import model.DAO.ExpenseDAO;
import model.bean.Expense;

public class ExpenseUi {
	private ExpenseDAO expenseDAO = new ExpenseDAO();
	
	
	private JTable table 						= new JTable(1,4);
	private JTextField jftExpenseName			= new JTextField();
	private JTextField jtfExpenseValue			= new JTextField();
	private JScrollPane scrollPane 				= new JScrollPane(table);
	private JDialog windowExpense 				= new JDialog();
	private JButton btnInsert					= new JButton("Add");
	private JButton btnDelete					= new JButton("Paid");
	private JButton btnUpdate					= new JButton("Upd");
	private JLabel lblExpense					= new JLabel("Expense");
	private JLabel lblPrice						= new JLabel("Price");
	private int idItemList;
	
	public ExpenseUi() {
		readTable();
		listeners();
		windowUi();
	}
	
	
	
	public void windowUi() {

		windowExpense.setTitle("Expense Manager");
		windowExpense.setVisible(true);
		windowExpense.setSize(500,330);
		windowExpense.setLocationRelativeTo(null);
		windowExpense.getContentPane().setLayout(null);
		windowExpense.setDefaultCloseOperation(JDialog.HIDE_ON_CLOSE);
		windowExpense.setAlwaysOnTop(true);
		windowExpense.add(jftExpenseName);
		windowExpense.add(jtfExpenseValue);
		windowExpense.add(lblExpense);
		windowExpense.add(lblPrice);
		windowExpense.setResizable(false);
		
		windowExpense.add(btnDelete);
		windowExpense.add(btnInsert);
		windowExpense.add(btnUpdate);
		windowExpense.add(scrollPane);
		windowExpense.setModal(false);
		
		
		jftExpenseName.setBounds(24, 30, 160, 19);
		jtfExpenseValue.setBounds(200, 30, 80, 19);
		btnInsert.setBounds(340,15,100,20);
		btnUpdate.setBounds(340,35,100,20);
		btnDelete.setBounds(340,55,100,20);
		scrollPane.setBounds(0, 90, 500, 200);
		lblExpense.setBounds(24,11,100,20);
		lblPrice.setBounds(200,11,100,20);
		
		jtfExpenseValue.setColumns(10);
		
		jftExpenseName.setColumns(10);

		
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		table.setRowHeight(15);

		

	}
	
		
	private void readTable() {
		DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
		tableModel.setNumRows(0);
		for(Expense expenseTable : expenseDAO.select()){
			tableModel.addRow(new Object[] {
					expenseTable.getExpenseName(),
					expenseTable.getValue(),
					expenseTable.getDataOfCreation(),
					expenseTable.getId()
					
			});
		}
	
	}
	
	public void listeners() {
		
		table.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				jftExpenseName.setText(table.getValueAt(table.getSelectedRow(), 0).toString());
				jtfExpenseValue.setText(table.getValueAt(table.getSelectedRow(), 1).toString());	
				idItemList =(int) table.getValueAt(table.getSelectedRow(), 3);
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}});
		
		
		btnInsert.addActionListener(new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			if(jftExpenseName.getText().isEmpty() || jtfExpenseValue.getText().isEmpty()) {
				warning();
			}else {
			String expense = jftExpenseName.getText();
			double value =Double.valueOf(jtfExpenseValue.getText());
			expenseDAO.insert(expense, value);
			readTable();
			clearTextFields();	
			}
		}});
		
		btnDelete.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(jftExpenseName.getText().isEmpty() || jtfExpenseValue.getText().isEmpty()) {
					warning();
				}else {
			expenseDAO.statusChanger(idItemList, 0);
			readTable();
			clearTextFields();
				}
			}});
		btnUpdate.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(jftExpenseName.getText().isEmpty() || jtfExpenseValue.getText().isEmpty()) {
					warning();
				}else {
			Expense expense = new Expense();
			expense.setExpenseName(jftExpenseName.getText());
			expense.setValue(Double.valueOf(jtfExpenseValue.getText()));
			expense.setId(idItemList);
			expenseDAO.update(expense);
			readTable();
			clearTextFields();
				}
			}});
}
	private void warning() {	
		JOptionPane.showMessageDialog(windowExpense, "Os campos não estão preenchidos.");

	}
	
	public void clearTextFields() {
		jftExpenseName.setText("");
		jtfExpenseValue.setText("");
	}
	
	
	
}

