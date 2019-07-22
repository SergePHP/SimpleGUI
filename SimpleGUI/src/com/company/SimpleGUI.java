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
	private JPanel panelLOp = new JPanel();
	private JPanel panelButtom = new JPanel();
	// Создаю все основные элементы
	private JTable table = new JTable(50, 6);
	private JList list =  new JList();
	private JTextArea textArea = new JTextArea();
	
	
	private JScrollPane scrollPane;
	private JScrollPane scrollPane_1;
	private JLabel lblRows;
	private JTextField textField;
	private JLabel lblCols;
	private JTextField textField_1;
	private JButton btnSet;
	private JTextField textField_2;
	private JLabel label;
	private JButton btnFill;
	private Box verticalBox;
	private Box verticalBox_1;
	private Component horizontalStrut;
	private Component horizontalStrut_1;
	private Box verticalBox_2;
	private JLabel lblNewLabel;
	private JComboBox comboBox;
	private Component horizontalStrut_2;
	private Box verticalBox_3;
	private JLabel lblNewLabel_1;
	private JButton btnNewButton;
	private String[] listList;
	
	private JScrollPane scrollPane_2;
	private JButton btnNewButton_1;
	private JButton btnNewButton_2;
	private Box horizontalBox;
	private JButton btnNewButton_3;

	

	public SimpleGUI() {
		super("ОП. Задание №1");
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
