package com.company;

import java.awt.*;
import java.awt.event.*;
import java.util.*;

import javax.swing.*;
import javax.swing.border.*;
import javax.swing.table.*;

public class SimpleGUI extends JFrame{

	// панели для размещения элементов управления
	
	private JPanel panelTop;
	private JPanel panelSize;
	private JPanel panelFill;
	private JPanel panelFont;
	private JPanel panelMiddle;
	private JPanel panelListOp;
	private JPanel panelButtom;
	
	// все основные элементы
	
	private JTable table;
	private JList<String> list;
	private JTextArea textArea;
	
	// все вспомогательные элементы
	
	private JScrollPane scrollPaneTable;
	private JScrollPane scrollPaneList;
	private JScrollPane scrollPaneTextArea;
	
	private Box verticalBox;
	private JLabel labelRows;
	private JTextField rows;
	private JLabel labelCols;
	private JTextField cols;
	private JButton btnSet;
	
	private Box verticalBox_1;
	private JLabel labelRange;
	private JTextField range;
	private JButton btnFill;
	
	private Box verticalBox_2;
	private JLabel labelFontList;
	private JComboBox comboBoxFontList;
	
	private Box verticalBox_3;
	private JLabel labelFontDialog;
	private JButton btnFontDlg;

	private JButton btnSetColor;
	private JButton btnIncSize;
	
	private Box horizontalBox;
	private JButton btnOpen;

	private Component horizontalStrut;
	private Component horizontalStrut_1;
	private Component horizontalStrut_2;
	
	// массив для заполнения списка
	
	private final String[] listData = {"one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten"};
	

	public SimpleGUI() {
		super("ОП. Задание №1");
		this.setBounds(100, 100, 690, 690);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container frame = this.getContentPane();
		
		// Для расположения элементов в основном окне 
		// использую Менеджер элементов GridLayout
		// окно будет состоять из одного столбца и четырех строк
		
		frame.setLayout(new GridLayout(0, 1, 0, 0));
		
		// создаю первую строку в основном окне
		
		panelTop = new JPanel();
		panelSize = new JPanel();
		panelFill = new JPanel();
		panelFont = new JPanel();
		
		frame.add(panelTop);
		panelTop.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		panelSize.setBorder(BorderFactory.createTitledBorder("Table size"));
		panelTop.add(panelSize);
		
		verticalBox = Box.createVerticalBox();
		panelSize.add(verticalBox);
		
		labelRows = new JLabel("Rows: ");
		verticalBox.add(labelRows);
		
		rows = new JTextField();
		verticalBox.add(rows);
		
		labelCols = new JLabel("Cols: ");
		verticalBox.add(labelCols);
		
		cols = new JTextField();
		verticalBox.add(cols);
		
		rows.setColumns(5);
		cols.setColumns(5);
		
		btnSet = new JButton("Set");
		verticalBox.add(btnSet);
		btnSet.addActionListener(new TableSizeButtonListener());
		
		horizontalStrut = Box.createHorizontalStrut(20);
		panelTop.add(horizontalStrut);
		
		panelFill.setBorder(BorderFactory.createTitledBorder("Filling the table"));
		panelTop.add(panelFill);
		
		verticalBox_1 = Box.createVerticalBox();
		panelFill.add(verticalBox_1);
		
		labelRange = new JLabel("Range:");
		verticalBox_1.add(labelRange);
		
		range = new JTextField();
		verticalBox_1.add(range);
		range.setColumns(10);
		
		btnFill = new JButton("Fill");
		verticalBox_1.add(btnFill);
		
		horizontalStrut_1 = Box.createHorizontalStrut(20);
		panelTop.add(horizontalStrut_1);
		
		panelFont.setBorder(BorderFactory.createTitledBorder("Font operations"));
		panelTop.add(panelFont);
		verticalBox_2 = Box.createVerticalBox();
		panelFont.add(verticalBox_2);
		
		labelFontList = new JLabel("Font List");
		verticalBox_2.add(labelFontList);
		
		comboBoxFontList = new JComboBox();
		verticalBox_2.add(comboBoxFontList);
		
		horizontalStrut_2 = Box.createHorizontalStrut(20);
		panelFont.add(horizontalStrut_2);
		verticalBox_3 = Box.createVerticalBox();
		panelFont.add(verticalBox_3);
		
		labelFontDialog = new JLabel("Font dialog");
		verticalBox_3.add(labelFontDialog);
		
		btnFontDlg = new JButton("Choice font");
		verticalBox_3.add(btnFontDlg);
		
		//
		// создаю вторую строку в основном окне
		//
		
		scrollPaneTable = new JScrollPane();
		frame.add(scrollPaneTable);
		table  = new JTable(10, 6);
		scrollPaneTable.setViewportView(table);
		
		cols.setText(Integer.toString(table.getColumnCount()));
		rows.setText(Integer.toString(table.getRowCount()));
		
		//
		// создаю третью строку в основном окне
		//
		
		panelMiddle = new JPanel();
		panelListOp = new JPanel();
		frame.add(panelMiddle);
		panelMiddle.add(panelListOp);
		panelListOp.setLayout(new GridLayout(0, 1, 0, 0));
		
		btnSetColor = new JButton("Set color");
		btnIncSize = new JButton("Increase size");
		panelListOp.add(btnSetColor);
		panelListOp.add(btnIncSize);
		
		scrollPaneList = new JScrollPane();	
		panelMiddle.add(scrollPaneList);
		
		list = new JList<String>(listData); // создаю список и заполняю значениями 

		scrollPaneList.setViewportView(list);
		list.setPreferredSize(new Dimension(200, 180));
		
		//
		// создаю четвертую строку в основном окне
		//
		
		panelButtom = new JPanel();
		textArea = new JTextArea();
		frame.add(panelButtom);
		panelButtom.setLayout(new GridLayout(0, 1, 0, 0));
		scrollPaneTextArea = new JScrollPane();
		panelButtom.add(scrollPaneTextArea);
		scrollPaneTextArea.setViewportView(textArea);
		
		horizontalBox = Box.createHorizontalBox();
		scrollPaneTextArea.setRowHeaderView(horizontalBox);
		
		btnOpen = new JButton("Open");
		horizontalBox.add(btnOpen);

	}
class TableSizeButtonListener implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {

		int x = 0;
		int y = 0;
		try {
			x = Integer.valueOf(rows.getText());
			y = Integer.valueOf(cols.getText());
		} catch (NumberFormatException e1) {
			JOptionPane.showMessageDialog(null, "Wrong rows/cols values format.\nOnly integer values allowed");
		}
		
		if(x != 0 || y != 0) {
		
			DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
			
			tableModel.setRowCount(x);
			tableModel.setColumnCount(y);
		}
	}
	
	}
}
