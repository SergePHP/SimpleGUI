package com.company;

import java.awt.*;
import java.awt.event.*;
import java.util.*;

import javax.swing.*;
import javax.swing.border.*;
import javax.swing.table.*;

public class SimpleGUI extends JFrame{
	private JButton fillTableButton = new JButton("Fill the Table");
	private JTextField xTableAxisDimField = new JTextField("", 5);
	private JTextField yTableAxisDimField = new JTextField("", 5);
	private JTextField rangeField = new JTextField("", 5);
	private JLabel xTableAxisLabel = new JLabel("X: ");
	private JLabel yTableAxisLabel = new JLabel("Y: ");

	private JPanel panel = new JPanel();
	private JTable table = new JTable(5, 2);


	public SimpleGUI() {
		super("ОП. Задание №1");
		this.setBounds(100, 100, 700, 500);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container frame = this.getContentPane(); 
		frame.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
		
	    TitledBorder border = new TitledBorder("Работа с таблицей");
	    border.setTitleJustification(TitledBorder.LEFT);
	    border.setTitlePosition(TitledBorder.TOP);
	    panel.setBorder(border);
		frame.add(panel);
		
		panel.setLayout(new GridLayout(0, 2, 0, 0));
		xTableAxisLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		yTableAxisLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		panel.add(xTableAxisLabel);
		panel.add(xTableAxisDimField);
		panel.add(yTableAxisLabel);
		panel.add(yTableAxisDimField);

		panel.add(rangeField);
		fillTableButton.addActionListener(new FillTableButtonListener ());
		panel.add(fillTableButton);
		table.setBorder(new LineBorder(new Color(0, 0, 0)));
		frame.add(table);

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
