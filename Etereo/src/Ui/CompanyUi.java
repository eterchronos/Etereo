package Ui;

import java.awt.ScrollPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;

import model.DAO.CompanyDAO;
import model.bean.Company;

public class CompanyUi {
	private static CompanyDAO companyDAO = new CompanyDAO();
	
	
	private JFrame windowCompany 				= new JFrame();
	private JTextField jtfCompanyCity			= new JTextField();
	private JTextField jtfCompanyName			= new JTextField();
	private JTextField jtfCompanyUf				= new JTextField();
	private JButton btnInsert					= new JButton("Add");
	private JButton btnDelete					= new JButton("Del");
	private JButton btnUpdate					= new JButton("Upd");
	private static JTable companyTable			= new JTable(1,4);
	private JScrollPane scrollPane				= new JScrollPane(companyTable);
	private JLabel lblCompany					= new JLabel("Add your company here:");
	private JLabel lblCompanyName				= new JLabel("Name:");
	private JLabel lblCompanyCity				= new JLabel("City:");
	private JLabel lblCompanyUf					= new JLabel("Uf:");
	private int idItemList;
	
	public CompanyUi() {
		
		readTable();
		listeners();
		
	}
	public void companyUi() {
		windowUi();
		readTable();
		listeners();	
	}
	

	
	private void windowUi() {
		windowCompany.setTitle("Company Manager");
		windowCompany.setVisible(true);
		
		windowCompany.setResizable(false);
		windowCompany.setLocationRelativeTo(null);
		windowCompany.setSize(450,400);
		windowCompany.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		windowCompany.setLayout(null);
		windowCompany.setAlwaysOnTop(true);
		
		windowCompany.add(scrollPane);
		windowCompany.add(jtfCompanyCity);
		windowCompany.add(jtfCompanyName);
		windowCompany.add(jtfCompanyUf);
		windowCompany.add(btnInsert);
		windowCompany.add(btnDelete);
		windowCompany.add(btnUpdate);
		windowCompany.add(lblCompany);
		windowCompany.add(lblCompanyName);
		windowCompany.add(lblCompanyCity);
		windowCompany.add(lblCompanyUf);
		
		scrollPane.setBounds(0,113,450,250);
		lblCompany.setBounds(140,2,220,20);
		btnInsert.setBounds(30,80,70,20);
		btnDelete.setBounds(110,80,70,20);
		btnUpdate.setBounds(190,80,70,20);
		jtfCompanyName.setBounds(35,45,150,20);
		jtfCompanyCity.setBounds(200,45,100,20);
		jtfCompanyUf.setBounds(315,45,100,20);
		lblCompanyName.setBounds(35,25,150,20);
		lblCompanyCity.setBounds(200,25,100,20);
		lblCompanyUf.setBounds(315,25,100,20);
		
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
	
		companyTable.setRowHeight(25);
		
		
		companyTable.getColumnModel().getColumn(3).setMaxWidth(JTable.AUTO_RESIZE_ALL_COLUMNS);
		
	}
	
	private static void readTable() {
		DefaultTableModel tableModel = (DefaultTableModel) companyTable.getModel();
		tableModel.setNumRows(0);
		
		for(Company companyTable: companyDAO.select()) {
			tableModel.addRow(new Object[] {
					
					companyTable.getRazaoSocial(),
					companyTable.getCidade(),
					companyTable.getUf(),
					companyTable.getId()
					
			});
				}	
	
	}
	
	public void listeners() {
		
		companyTable.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				int valueSelectedIndex = companyTable.getSelectedRow();
				jtfCompanyName.setText(companyTable.getValueAt(valueSelectedIndex, 0).toString());
				jtfCompanyCity.setText(companyTable.getValueAt(valueSelectedIndex, 1).toString());
				jtfCompanyUf.setText(companyTable.getValueAt(valueSelectedIndex, 2).toString());
				idItemList = (int) companyTable.getValueAt(valueSelectedIndex, 3);
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
				if(jtfCompanyName.getText().isEmpty() || jtfCompanyCity.getText().isEmpty() || jtfCompanyUf.getText().isEmpty()) {
					warning();
				}else {
				String cName = jtfCompanyName.getText();
				String city  = jtfCompanyCity.getText();
				String uf	 = jtfCompanyUf.getText();
				companyDAO.insert(cName, city, uf);
				readTable();
				clearTextFields();
			}
			}});
		
		btnDelete.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(jtfCompanyName.getText().isEmpty() || jtfCompanyCity.getText().isEmpty() || jtfCompanyUf.getText().isEmpty()) {
					warning();
				}
				else {
				companyDAO.statusChanger(idItemList, 0);
				readTable();
				clearTextFields();
				}
			}});
		
		btnUpdate.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(jtfCompanyName.getText().isEmpty() || jtfCompanyCity.getText().isEmpty() || jtfCompanyUf.getText().isEmpty()) {
					warning();
				}else {
				Company company = new Company();
				company.setRazaoSocial(jtfCompanyName.getText());
				company.setCidade(jtfCompanyCity.getText());
				company.setUf(jtfCompanyUf.getText());
				company.setId(idItemList);
				companyDAO.update(company);
				readTable();
				}
			}});
		

	}
	
	private void warning() {	
		JOptionPane.showMessageDialog(windowCompany, "Os campos não estão preenchidos.");

	}
	
	private void clearTextFields() {
		jtfCompanyName.setText("");
		jtfCompanyCity.setText("");
		jtfCompanyUf.setText("");
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
