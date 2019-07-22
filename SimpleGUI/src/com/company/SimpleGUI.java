package com.company;

import java.awt.*;
import java.awt.event.*;
import java.util.*;

import javax.swing.*;
import javax.swing.border.*;
import javax.swing.table.*;

public class SimpleGUI extends JFrame{

	// Создаю панели для размещения элементов управления
	
	private JPanel panelTop = new JPanel();
	private JPanel panelTSize = new JPanel();
	private JPanel panelTFill = new JPanel();
	private JPanel panelTFont = new JPanel();
	private JPanel panelMiddle = new JPanel();
	private JPanel panelListOp = new JPanel();
	private JPanel panelButtom = new JPanel();
	
	// создаю все основные элементы
	
	private JTable table = new JTable(50, 6);
	private JList list =  new JList();
	private JTextArea textArea = new JTextArea();
	
	// создаю все вспомогательные элементы
	
	private JScrollPane scrollPaneTable = new JScrollPane();
	private JScrollPane scrollPaneList = new JScrollPane();
	private JScrollPane scrollPaneTextArea = new JScrollPane();
	
	private Box verticalBox = Box.createVerticalBox();
	private JLabel labelRows = new JLabel("Rows: ");
	private JTextField rows = new JTextField();
	private JLabel labelCols = new JLabel("Cols: ");
	private JTextField cols = new JTextField();
	private JButton btnSet = new JButton("Set");
	
	private Box verticalBox_1 = Box.createVerticalBox();
	private JLabel labelRange = new JLabel("Range: ");
	private JTextField range  = new JTextField();
	private JButton btnFill;
	
	private Box verticalBox_2 = Box.createVerticalBox();
	private JLabel lblNewLabel;
	private JComboBox comboBox;
	private Component horizontalStrut_2;
	private Box verticalBox_3;
	private JLabel lblNewLabel_1;
	private JButton btnNewButton;
	private String[] listList;
	

	private JButton btnNewButton_1;
	private JButton btnNewButton_2;
	private Box horizontalBox;
	private JButton btnNewButton_3;

	private Component horizontalStrut;
	private Component horizontalStrut_1;

	public SimpleGUI() {
		super("��. ������� �1");
		this.setBounds(100, 100, 690, 690);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container frame = this.getContentPane(); 
		frame.setLayout(new GridLayout(0, 1, 0, 0));
		


	}
class FillTableButtonListener implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		
		DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
		tableModel.setRowCount(0);
		
		Vector<String> row = new Vector<>();
		
		for (int i = 0; i < 10; i++) {
			row.add("");
			}
		tableModel.setColumnIdentifiers(row);
		for (int i = 0; i < 10; i++) {
			tableModel.addRow(row);
		}

		}
	
	}
}
