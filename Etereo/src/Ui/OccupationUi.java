package Ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import model.DAO.OccupationDAO;
import model.bean.Occupation;
public class OccupationUi {
	private static OccupationDAO occupationDAO = new OccupationDAO();

	
	private JFrame windowOccupation 			= new JFrame();
	private JTextField jtfOccupationId			= new JTextField();
	private JTextField jtfOccupationTxt			= new JTextField();
	private JButton btnInsert					= new JButton("Add");
	private JButton btnDelete					= new JButton("Del");
	private JButton btnUpdate					= new JButton("Upd");
	private static JTable occupationTable		= new JTable(1,2);
	private 	   JScrollPane scrollPane		= new JScrollPane(occupationTable);
	private JLabel lblOccupation				= new JLabel("Add an occupation here:");
	
	public OccupationUi() {
		
		readTable();
		listeners();
		
	}
	
	
	public void windowUi() {
		windowOccupation.setTitle("Occupation Manager");
		windowOccupation.setVisible(true);
		
		windowOccupation.setResizable(false);
		windowOccupation.setLocationRelativeTo(null);
		windowOccupation.setSize(300,400);
		windowOccupation.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		windowOccupation.setLayout(null);
		windowOccupation.setAlwaysOnTop(true);
			
		windowOccupation.add(jtfOccupationId);
		windowOccupation.add(jtfOccupationTxt);
		windowOccupation.add(btnInsert);
		windowOccupation.add(btnDelete);
		windowOccupation.add(btnUpdate);
		windowOccupation.add(lblOccupation);
		windowOccupation.add(scrollPane);
		
		occupationTable.setRowHeight(25);
		jtfOccupationId.setBounds(10,0,60,20);
		lblOccupation.setBounds(35,20,220,20);
		jtfOccupationTxt.setBounds(35,40,220,20);
		btnInsert.setBounds(30,80,70,20);
		btnDelete.setBounds(110,80,70,20);
		btnUpdate.setBounds(190,80,70,20);
		scrollPane.setBounds(0,113,300,250);
		
		jtfOccupationId.setVisible(false);
		occupationTable.getColumnModel().getColumn(0).setMaxWidth(JTable.AUTO_RESIZE_ALL_COLUMNS);
		
	}
	
	private static void readTable() {
		DefaultTableModel tableModel = (DefaultTableModel)occupationTable.getModel();
		
		tableModel.setNumRows(0);
		
		for(Occupation occupationTable: occupationDAO.select()) {
			tableModel.addRow(new Object[] {
					occupationTable.getId(),
					occupationTable.getCargo()
					
			});

		}
	}
	

	private void listeners() {
		occupationTable.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				int valueSelectedIndex=occupationTable.getSelectedRow();
				
				jtfOccupationId.setText(occupationTable.getValueAt(valueSelectedIndex, 0).toString());
				jtfOccupationTxt.setText(occupationTable.getValueAt(valueSelectedIndex, 1).toString());
			}

			@Override
			public void mousePressed(MouseEvent e) {
				
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
		
		btnDelete.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(jtfOccupationTxt.getText().isEmpty()) {
					warning();
				}else {
				int intId = Integer.valueOf(jtfOccupationId.getText());

				occupationDAO.statusChanger(intId,0);		
				readTable();
				clearTextFields();
				}
			}});
		
		btnInsert.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(jtfOccupationTxt.getText().isEmpty()) {
					warning();
				}else {
				String insertString = jtfOccupationTxt.getText();

				occupationDAO.insert(insertString);		
				readTable();
				clearTextFields();
				}
			}});
		
		btnUpdate.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(jtfOccupationTxt.getText().isEmpty()) {
					warning();
				}else {
				Occupation occupationObj = new Occupation();
				occupationObj.setCargo(jtfOccupationTxt.getText());
				occupationObj.setId(Integer.valueOf(jtfOccupationId.getText()));
				
				occupationDAO.update(occupationObj);
				readTable();
				clearTextFields();
				}
			}});

	}
	private void warning() {	
		JOptionPane.showMessageDialog(windowOccupation, "Os campos não estão preenchidos.");

	}
	
	private void clearTextFields() {
		jtfOccupationId.setText("");
		jtfOccupationTxt.setText("");
		
	}
}
