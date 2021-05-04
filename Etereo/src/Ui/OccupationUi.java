package Ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import model.DAO.OccupationDAO;
import model.bean.Occupation;
public class OccupationUi {
	public static OccupationDAO occupationDAO = new OccupationDAO();
	
	private JFrame windowOccupation 	= new JFrame();

	private JTextField jtfOccupationId	= new JTextField();
	private JTextField jtfOccupationTxt	= new JTextField();
	
	private JButton btnInsert			= new JButton("Add");
	private JButton btnDelete			= new JButton("Delete");
	private JButton btnUpdate			= new JButton("Update");
	
	private static JTable occupationTable		= new JTable(1,1);
	
	public OccupationUi() {
		readTable();
		listeners();
		//windowUi();
	}
	
	public void windowUi() {
		windowOccupation.setTitle("Occupation Manager");
		windowOccupation.setVisible(true);
		
		windowOccupation.setResizable(false);
		windowOccupation.setLocationRelativeTo(null);
		windowOccupation.setSize(600,400);
		windowOccupation.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		windowOccupation.setLayout(null);
		
		windowOccupation.add(occupationTable);
		windowOccupation.add(jtfOccupationId);
		windowOccupation.add(jtfOccupationTxt);
		windowOccupation.add(btnInsert);
		windowOccupation.add(btnDelete);
		windowOccupation.add(btnUpdate);
		
		occupationTable.setBounds(0,113,600,250);
		occupationTable.setRowHeight(20);
		jtfOccupationId.setBounds(10,50,60,20);
		jtfOccupationTxt.setBounds(80,50,120,20);
		btnInsert.setBounds(230,50,70,20);
		btnDelete.setBounds(310,50,70,20);
		btnUpdate.setBounds(390,50,70,20);
		
		
		
	}
	
	public static void readTable() {
		DefaultTableModel tableModel = (DefaultTableModel)occupationTable.getModel();
		
		
		tableModel.setNumRows(0);
		
		for(Occupation occupationTable: occupationDAO.select()) {
			
			tableModel.addRow(new Object[] {
					occupationTable.getCargo()
			});

		}
	}
	

	public void listeners() {
		occupationTable.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				
			}

			@Override
			public void mousePressed(MouseEvent e) {
				int valueSelectedId = occupationTable.rowAtPoint(e.getPoint());
				String valueSelectedtxt= occupationTable.getValueAt(occupationTable.getSelectedRow(), occupationTable.getSelectedColumn()).toString();
				jtfOccupationId.setText(String.valueOf( valueSelectedId));
				jtfOccupationTxt.setText(valueSelectedtxt);
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
				
				occupationDAO.statusChanger(0, 0);
				
			}});

	}
	
	
	
}
