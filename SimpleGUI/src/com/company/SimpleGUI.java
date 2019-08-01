package com.company;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.ColorModel;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.table.*;

//import org.eclipse.swt.graphics.Font;
//import org.eclipse.swt.graphics.FontData;
//import org.eclipse.swt.widgets.FontDialog;
//import org.eclipse.swt.widgets.Shell;

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
	
	private JFileChooser fileChooser = new JFileChooser();
	private JColorChooser colorChooser = new JColorChooser();
	
	private Color color = new Color(184,207,229);
	
	private Container frame;
	
	// массив для заполнения списка
	
	private final String[] listData = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
	

	public SimpleGUI() {
		super("ОП. Задание №1");
		this.setSize(new Dimension(900, 650));
		
		frame = this.getContentPane();
		
		// Для расположения элементов в основном окне 
		// использую Менеджер элементов GridLayout
		// окно будет состоять из одного столбца и четырех строк
		
		frame.setLayout(new GridLayout(0, 1, 0, 0));
		
		//
		// создаю первую строку в основном окне
		//
		
		panelTop = new JPanel();
		panelSize = new JPanel();
		panelFill = new JPanel();
		panelFont = new JPanel();
		
		// формирую элементы для изменения размера таблицы
	
		frame.add(panelTop);
		panelTop.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		panelSize.setBorder(BorderFactory.createTitledBorder("Размер таблицы"));
		panelTop.add(panelSize);
		
		verticalBox = Box.createVerticalBox();
		panelSize.add(verticalBox);
		
		labelRows = new JLabel("Строк: ");
		verticalBox.add(labelRows);
		
		rows = new JTextField();
		verticalBox.add(rows);
		
		labelCols = new JLabel("Столбцов: ");
		verticalBox.add(labelCols);
		
		cols = new JTextField();
		verticalBox.add(cols);
		
		rows.setColumns(5);
		cols.setColumns(5);
		
		btnSet = new JButton("Установить");

		// создаю обработчик событий при нажатии кнопки 
		
		btnSet.addActionListener(new TableSizeButtonListener());
		verticalBox.add(btnSet);
		
		horizontalStrut = Box.createHorizontalStrut(20);
		panelTop.add(horizontalStrut);
		
		// формирую элементы для заполения таблицы, формат диспазона: 1-100
		
		panelFill.setBorder(BorderFactory.createTitledBorder("Заполнить таблицу"));
		panelTop.add(panelFill);
		
		verticalBox_1 = Box.createVerticalBox();
		panelFill.add(verticalBox_1);
		
		labelRange = new JLabel("Диапазон:");
		verticalBox_1.add(labelRange);
		
		range = new JTextField("1-100");
		verticalBox_1.add(range);
		range.setColumns(10);
		
		btnFill = new JButton("Заполнить");
		
		// создаю обработчик событий при нажатии кнопки 
		
		btnFill.addActionListener(new TableFillButtonListener());
		verticalBox_1.add(btnFill);
		
		horizontalStrut_1 = Box.createHorizontalStrut(20);
		panelTop.add(horizontalStrut_1);
		
		// создаю элементы для форматирования текста в таблице заданным шрифтом
		
		panelFont.setBorder(BorderFactory.createTitledBorder("Выбор шрифта"));
		panelTop.add(panelFont);
		verticalBox_2 = Box.createVerticalBox();
		panelFont.add(verticalBox_2);
		
		labelFontList = new JLabel("Список шрифтов");
		verticalBox_2.add(labelFontList);
		
		// получаю список всех шрифтов
		
		String fonts[] = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
		final DefaultComboBoxModel comboModel = new DefaultComboBoxModel(fonts);
		
		comboBoxFontList = new JComboBox(comboModel);
		
		comboBoxFontList.addActionListener(new conboBoxActionListener());
		
		verticalBox_2.add(comboBoxFontList);
		
		
		horizontalStrut_2 = Box.createHorizontalStrut(20);
		panelFont.add(horizontalStrut_2);
		verticalBox_3 = Box.createVerticalBox();
		panelFont.add(verticalBox_3);
		
		labelFontDialog = new JLabel("Стандартный диалог");
		verticalBox_3.add(labelFontDialog);
		
		btnFontDlg = new JButton("Выбрать шрифт");
		btnFontDlg.addActionListener(new FontDialogActionListener());
		verticalBox_3.add(btnFontDlg);
		
		//
		// создаю вторую строку в основном окне
		//

		table  = new JTable(10, 10);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		scrollPaneTable = new JScrollPane(table, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		frame.add(scrollPaneTable);

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
		btnSetColor.addActionListener(new colorButtonListener());
		btnIncSize = new JButton("Increase size");
		btnIncSize.addActionListener(new incrButtonListener());
		panelListOp.add(btnSetColor);
		panelListOp.add(btnIncSize);
		
		scrollPaneList = new JScrollPane();	
		panelMiddle.add(scrollPaneList);
		
		list = new JList<String>(listData); // создаю список и заполняю значениями
		list.setCellRenderer(new listCellRenderer()); // назначаю пользовательский 
													  // визуализатор строк списка
		
		scrollPaneList.setViewportView(list);
		
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
		btnOpen.addActionListener(new openButtonListener());
		horizontalBox.add(btnOpen);

	}
class colorButtonListener implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {

		color = JColorChooser.showDialog(SimpleGUI.this, "Выбор цвета", Color.WHITE);
		list.updateUI();
	}
	
}
class listCellRenderer extends DefaultListCellRenderer{
	@Override
    public Component getListCellRendererComponent(JList list, Object value, int index, 
              boolean isSelected, boolean cellHasFocus) {
		
		Component c = super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
        if (isSelected) {
            c.setBackground(color);
       }
		return c;
	}
}
class incrButtonListener implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {

		/*
		 *  AWT dialog test
		 * 
		 * 
		 */
//		Shell shell = new Shell();
//		FontDialog dlg = new FontDialog(shell);
//		
//	    FontData fontData = dlg.open();
//	    if (fontData != null) {
//	      Font font = new Font(shell.getDisplay(), fontData);
//
//	      font.dispose();
//	    }
		
	}
	
}
	
class openButtonListener implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		if(JFileChooser.APPROVE_OPTION == fileChooser.showOpenDialog(SimpleGUI.this)) {
			File file = new File(fileChooser.getSelectedFile().getPath());
			int size = (int)file.length();
			int c = 0;
			FileReader in;
			try {
				in = new FileReader(file);
				char[] data = new char[size];
				while (in.ready()) {
					c += in.read(data, c, size-c);
				}
				in.close();
				textArea.setText(new String(data, 0, c));
			} catch (Exception e1) {
				JOptionPane.showMessageDialog(null, "Ошибка работы с файлом.", 
						"Ошибка", JOptionPane.ERROR_MESSAGE);
			}
		}
		
	}
	
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
			JOptionPane.showMessageDialog(null, "Incorrect row/column value format.\nOnly integer values are allowed", 
					"Warning", JOptionPane.WARNING_MESSAGE);
		}
		
			DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
			
			tableModel.setRowCount(x);
			tableModel.setColumnCount(y);
		}
	
	}
class TableFillButtonListener implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		
		String[] bounds = range.getText().split("-");
		int x = 0;
		int y = 0;
		
		try {
			x = Integer.valueOf(bounds[0]);
			y = Integer.valueOf(bounds[1]);
		} catch (Exception e1) {
			JOptionPane.showMessageDialog(null, "Incorrect range value format.\nUse the following format range, for example, 1-125", 
					"Warning", JOptionPane.WARNING_MESSAGE);
			return;
		}
		DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
		
		int currentRows = tableModel.getRowCount();
		tableModel.setRowCount(0);

		for (int i = 0; i < currentRows; i++) {
			Vector<String> row = new Vector<String>();
			for (int j = 0; j < table.getColumnCount(); j++) {
				if(x <= y) {
					row.add(Integer.toString(x));
					x++;
				} else {
					row.add("");
				}
			}
			tableModel.addRow(row);
		}

		}

	}
class conboBoxActionListener implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		
		String selectedFont = String.valueOf(comboBoxFontList.getSelectedItem());
		Font font = new Font(selectedFont, table.getFont().getStyle(), table.getFont().getSize());
		table.setFont(font);
		}

	}
class FontDialogActionListener implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		
		String fonts[] = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
		String selectedFont = fonts[0];
		Font font = new Font(selectedFont, table.getFont().getStyle(), table.getFont().getSize());
		
		FontChooser fc = new FontChooser(SimpleGUI.this, true, font);
		fc.setVisible(true);

	}
	
}
}
