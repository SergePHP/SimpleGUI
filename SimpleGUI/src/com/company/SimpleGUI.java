package com.company;

import java.awt.*;
import java.awt.event.*;
import java.util.*;

import javax.swing.*;
import javax.swing.border.*;
import javax.swing.table.*;

public class SimpleGUI extends JFrame{

	// Создаю панели для размещения элементов управления
	
	private JPanel panelTop;
	private JPanel panelSize;
	private JPanel panelFill;
	private JPanel panelFont;
	private JPanel panelMiddle;
	private JPanel panelListOp;
	private JPanel panelButtom;
	
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
	private JButton btnFill = new JButton("Fill");
	
	private Box verticalBox_2 = Box.createVerticalBox();
	private JLabel labelFontList = new JLabel("Font List");
	private JComboBox comboBoxFontList = new JComboBox();
	
	private Box verticalBox_3 = Box.createVerticalBox();
	private JLabel labelFontDialog = new JLabel("Font dialog");
	private JButton btnFontDlg = new JButton("Choice font");

	private JButton btnSetColor = new JButton("Set color");
	private JButton btnIncSize = new JButton("Increase size");
	
	private Box horizontalBox = Box.createHorizontalBox();
	private JButton btnOpen = new JButton("Open");

	private Component horizontalStrut = Box.createHorizontalStrut(20);
	private Component horizontalStrut_1 = Box.createHorizontalStrut(20);
	private Component horizontalStrut_2 = Box.createHorizontalStrut(20);
	
	

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
		panelSize.add(verticalBox);
		verticalBox.add(labelRows);
		verticalBox.add(rows);
		verticalBox.add(labelCols);
		verticalBox.add(cols);
		rows.setColumns(5);
		cols.setColumns(5);
		verticalBox.add(btnSet);
		btnSet.addActionListener(new TableSizeButtonListener());
		
		panelTop.add(horizontalStrut);
		
		panelFill.setBorder(BorderFactory.createTitledBorder("Filling the table"));
		panelTop.add(panelFill);
		panelFill.add(verticalBox_1);
		verticalBox_1.add(labelRange);
		verticalBox_1.add(range);
		range.setColumns(10);
		verticalBox_1.add(btnFill);
		
		panelTop.add(horizontalStrut_1);
		
		panelFont.setBorder(BorderFactory.createTitledBorder("Font operations"));
		panelTop.add(panelFont);
		panelFont.add(verticalBox_2);
		verticalBox_2.add(labelFontList);
		verticalBox_2.add(comboBoxFontList);
		
		panelFont.add(horizontalStrut_2);
		panelFont.add(verticalBox_3);
		verticalBox_3.add(labelFontDialog);
		verticalBox_3.add(btnFontDlg);
		
		// создаю вторую строку в основном окне
		
		frame.add(scrollPaneTable);
		scrollPaneTable.setViewportView(table);
		
		// создаю третью строку в основном окне
		
		panelMiddle = new JPanel();
		panelListOp = new JPanel();
		frame.add(panelMiddle);
		panelMiddle.add(panelListOp);
		panelListOp.setLayout(new GridLayout(0, 1, 0, 0));
		panelListOp.add(btnSetColor);
		panelListOp.add(btnIncSize);
		panelMiddle.add(scrollPaneList);
		
		// создаю список и заполняю значениями 
		
		list = new JList();
		list.setModel(new AbstractListModel() {
			String[] values = new String[] {"one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		
		scrollPaneList.setViewportView(list);
		list.setPreferredSize(new Dimension(200, 180));
		
		// создаю четвертую строку в основном окне
		
		panelButtom = new JPanel();
		frame.add(panelButtom);
		panelButtom.setLayout(new GridLayout(0, 1, 0, 0));
		panelButtom.add(scrollPaneTextArea);
		scrollPaneTextArea.setViewportView(textArea);
		scrollPaneTextArea.setRowHeaderView(horizontalBox);
		horizontalBox.add(btnOpen);

	}
class TableSizeButtonListener implements ActionListener{

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
