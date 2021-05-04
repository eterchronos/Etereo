package Ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JTable;
import javax.swing.JTextField;

import Ui.OccupationUi;
public class Dashboard {
	OccupationUi occupationUi = new OccupationUi();
	
	private JFrame windowDashboard 		= new JFrame();
	private JFrame windowOccupation 	= new JFrame();
	private JMenuBar menuBar 			= new JMenuBar();
	private JMenu menuManager 			= new JMenu("Manager");
	private JMenuItem miOccupation 		= new JMenuItem("Occupation");
	private JMenuItem miAbout 		= new JMenuItem("About");
	
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
		menuManager.add(miAbout);
		
		}

	/*public void occupation() {
		windowOccupation.setTitle("Occupation Manager");
		windowOccupation.setVisible(true);
		windowOccupation.setSize(600,400);
		windowOccupation.setResizable(false);
		windowOccupation.setLocationRelativeTo(windowDashboard);
		windowOccupation.setLayout(null);
		
		windowOccupation.add(occupationPane);
		windowOccupation.add(jtfOccupationId);
		windowOccupation.add(jtfOccupationTxt);
		windowOccupation.add(btnInsert);
		windowOccupation.add(btnDelete);
		windowOccupation.add(btnUpdate);
		
		occupationPane.setBounds(0,113,600,250);
		jtfOccupationId.setBounds(20,50,60,20);
		jtfOccupationTxt.setBounds(90,50,120,20);
		btnInsert.setBounds(230,50,70,20);
		btnDelete.setBounds(310,50,70,20);
		btnUpdate.setBounds(390,50,70,20);
		
	}*/
	
	
	public void listeners() {
		miOccupation.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				occupationUi.windowUi();
				//occupation();
			}});
	}
	
	}
	

