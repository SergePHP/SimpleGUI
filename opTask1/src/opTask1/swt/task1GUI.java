package opTask1.swt;

import org.eclipse.swt.widgets.*;
import org.eclipse.swt.SWT;
import org.eclipse.swt.awt.SWT_AWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import java.awt.GraphicsEnvironment;
import java.awt.Rectangle;
import java.io.File;
import java.io.FileReader;
import java.util.Arrays;

import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.FontData;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;

public class task1GUI {

	protected Shell shell;
	private Text cols;
	private Text rows;
	private Text range;
	private Label lblNewLabel;
	private Label lblNewLabel_1;
	private Label lblNewLabel_2;
	private Button btnTablePopulate;
	private Group tFontGroup;
	private Label lblNewLabel_4;
	private Button btnFontSelect;
	private Table table;
	private Group listGroup;
	private StyledText styledText;
	private Button btnSelectColor;
	private Button btnIncSize;
	private Button btnOpenFile;
	private Combo combo;
	private Composite composite;
	private Text indexesString;
	private java.awt.Frame frame;
	private java.awt.Panel panel;
	private java.awt.Color color;
	private javax.swing.JList list;
	private javax.swing.DefaultListModel listModel;
	private javax.swing.JScrollPane scrollPane;
	
	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			task1GUI window = new task1GUI();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		createContents();
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shell = new Shell();
		shell.setSize(1120, 865);
		shell.setText("ОП. Задание №1");
		shell.setLayout(new GridLayout(4, false));
		new Label(shell, SWT.NONE);
		
		tFontGroup = new Group(shell, SWT.NONE);
		tFontGroup.setLayoutData(new GridData(SWT.LEFT, SWT.FILL, false, false, 1, 1));
		tFontGroup.setText("Выбор шрифта");
		tFontGroup.setLayout(new GridLayout(2, false));
		
		Label lblNewLabel_3 = new Label(tFontGroup, SWT.NONE);
		lblNewLabel_3.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
		lblNewLabel_3.setBounds(0, 0, 71, 17);
		lblNewLabel_3.setText("Список шрифтов");
		
		lblNewLabel_4 = new Label(tFontGroup, SWT.NONE);
		lblNewLabel_4.setText("Стандартный диалог");
		
		combo = new Combo(tFontGroup, SWT.NONE);
		combo.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				table.setRedraw(false);
				String selectedFont = String.valueOf(combo.getText());
				FontData fontData = table.getFont().getFontData()[0];
				fontData.setName(selectedFont);
				
				Font font = new Font(shell.getDisplay(), fontData);
				table.setFont(font);
				for (TableColumn column: table.getColumns()) {
					column.pack();
				}
			    table.setRedraw(true);
			}
		});
		combo.setBounds(0, 0, 199, 29);
		
		btnFontSelect = new Button(tFontGroup, SWT.NONE);
		btnFontSelect.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {

				FontDialog fontDialog = new FontDialog(shell);
			    FontData fontData = fontDialog.open();
			    if (fontData != null) {
			    	
			    	table.setRedraw(false);
			    	Font font = new Font(shell.getDisplay(), fontData);
			    	table.setFont(font);
					for (TableColumn column: table.getColumns()) {
						column.pack();
					}
				    table.setRedraw(true);
			    }
			}
		});
		btnFontSelect.setText("Выбрать шрифт");
		btnFontSelect.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
		new Label(shell, SWT.NONE);
		
		String fonts[] = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
		for (String string : fonts) {
			combo.add(string);
		}
		new Label(shell, SWT.NONE);
		
		Group tSizeGroup = new Group(shell, SWT.NONE);
		GridData gd_tSizeGroup = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_tSizeGroup.widthHint = 183;
		tSizeGroup.setLayoutData(gd_tSizeGroup);
		tSizeGroup.setText("Размер таблицы");
		tSizeGroup.setLayout(new GridLayout(2, false));
		
		lblNewLabel = new Label(tSizeGroup, SWT.NONE);
		lblNewLabel.setText("Столбцов");
		
		cols = new Text(tSizeGroup, SWT.BORDER);
		cols.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		cols.setBounds(0, 0, 81, 29);
		cols.setText("10");
		
		lblNewLabel_1 = new Label(tSizeGroup, SWT.NONE);
		lblNewLabel_1.setText("Строк");
		
		rows = new Text(tSizeGroup, SWT.BORDER);
		rows.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		rows.setBounds(0, 0, 81, 29);
		rows.setText("10");
		new Label(tSizeGroup, SWT.NONE);
		Button btnTableSize = new Button(tSizeGroup, SWT.NONE);
		btnTableSize.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				tableSizeAction(e);
			}
		});
		btnTableSize.setBounds(0, 0, 97, 29);
		btnTableSize.setText("Установить");
		
		table = new Table(shell, SWT.BORDER | SWT.FULL_SELECTION | SWT.V_SCROLL | SWT.H_SCROLL);
		table.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 3, 2));
		table.setHeaderVisible(true);
		table.setLinesVisible(true);
		
		
		Group tPopulateGroup = new Group(shell, SWT.NONE);
		tPopulateGroup.setText("Данные таблицы");
		tPopulateGroup.setLayout(new GridLayout(2, false));
		
		lblNewLabel_2 = new Label(tPopulateGroup, SWT.NONE);
		lblNewLabel_2.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblNewLabel_2.setText("Диапазон");
		
		range = new Text(tPopulateGroup, SWT.BORDER);
		range.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		range.setBounds(0, 0, 81, 29);
		range.setText("1-100");
		new Label(tPopulateGroup, SWT.NONE);
		btnTablePopulate = new Button(tPopulateGroup, SWT.NONE);
		btnTablePopulate.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				tablePopulateAction(e);
			}
		});
		btnTablePopulate.setText("Заполнить");
		
		listGroup = new Group(shell, SWT.NONE);
		listGroup.setText("Поведение списка");
		listGroup.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
		listGroup.setLayout(new GridLayout(2, false));
		
		Label lblNewLabel_5 = new Label(listGroup, SWT.NONE);
		lblNewLabel_5.setText("Индекс в списке");
		lblNewLabel_5.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		
		indexesString = new Text(listGroup, SWT.BORDER);
		indexesString.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.keyCode == SWT.CR) {
					int[] indexes = getIndexes();
					if(indexes != null && color != null) {
						list.setCellRenderer(new ListCellRenderer(indexes, color));
					}
				}
			}
		});
		indexesString.setText("1,4,7");
		indexesString.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));

		new Label(listGroup, SWT.NONE);
		
		btnSelectColor = new Button(listGroup, SWT.NONE);
		btnSelectColor.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				setColorAction(e);
			}
		});
		btnSelectColor.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		btnSelectColor.setBounds(0, 0, 97, 29);
		btnSelectColor.setText("Установить цвет");
		new Label(listGroup, SWT.NONE);
		
		btnIncSize = new Button(listGroup, SWT.NONE);
		btnIncSize.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				java.awt.Font font = list.getFont();
				list.setFont(font.deriveFont((float)font.getSize() + 5));
			}
		});
		GridData gd_btnIncSize = new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1);
		gd_btnIncSize.heightHint = 45;
		btnIncSize.setLayoutData(gd_btnIncSize);
		btnIncSize.setBounds(0, 0, 97, 29);
		btnIncSize.setText("Увеличить шрифт\nна 5 пунктов");
		
		composite = new Composite(shell, SWT.EMBEDDED | SWT.NO_BACKGROUND);
		//composite = new Composite(shell, SWT.EMBEDDED);
		composite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, false, 1, 1));
		
		frame = SWT_AWT.new_Frame(composite);
		frame.setLayout(new java.awt.BorderLayout(0, 0));
		panel = new java.awt.Panel();
		frame.add(panel);
		panel.setLayout(new java.awt.FlowLayout());
		
		scrollPane = new javax.swing.JScrollPane();
		panel.add(scrollPane);
		
		String[] fontsForList = fonts.clone();

		for (int index = 0; index < fontsForList.length; index++) {
			fontsForList[index] = index + ": " + fontsForList[index];
		}
		listModel = new javax.swing.DefaultListModel();
		list = new javax.swing.JList(listModel);
		
		for (String string : fontsForList) {
			listModel.addElement(string);
		}

		scrollPane.setViewportView(list);
		new Label(shell, SWT.NONE);
		
		styledText = new StyledText(shell, SWT.BORDER | SWT.V_SCROLL | SWT.H_SCROLL );
		styledText.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		new Label(shell, SWT.NONE);
		new Label(shell, SWT.NONE);
		new Label(shell, SWT.NONE);

		btnOpenFile = new Button(shell, SWT.NONE);
				btnOpenFile.addSelectionListener(new SelectionAdapter() {
					@Override
					public void widgetSelected(SelectionEvent e) {
						openFileAction(e);
					}
				});
		btnOpenFile.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
		btnOpenFile.setText("Открыть файл");

	}
	private void setColorAction(SelectionEvent e) {

		int[] indexes = getIndexes();
		if(indexes != null) {
			ColorDialog colorDialog = new ColorDialog(shell);
			colorDialog.setText("Выбрать цвет");
			RGB rgb = colorDialog.open();

			if(rgb != null) {
				color = new java.awt.Color(rgb.red, rgb.green, rgb.blue);
				list.setCellRenderer(new ListCellRenderer(indexes, color));
			}
		}
	}
	private int[] getIndexes() {
		
		String[] temp = indexesString.getText().replaceAll("\\s", "").split(",");
		int[] listIndexes = new int[temp.length];
		
		try {
			for (int i = 0; i < temp.length; i++) {
				listIndexes[i] = Integer.valueOf(temp[i]);
			}
		} catch (Exception e2) {
				MessageBox messageBox = new MessageBox(shell, SWT.ICON_WARNING | SWT.OK);
		        messageBox.setText("Warning");
		        messageBox.setMessage("Invalid index sequence value format.\nUse the following index sequence format, for example, 1,35,42");
		        messageBox.open();
		        return null;
		}
		return listIndexes;
	}
	private void openFileAction(SelectionEvent e) {
		
        FileDialog fileDialog = new FileDialog(shell, SWT.OPEN);
        fileDialog.setText("Открыть");
        fileDialog.setFilterPath("/");
        String[] filterExt = {"*.txt", "*.*"};
        fileDialog.setFilterExtensions(filterExt);
        if (fileDialog.open() != null) {

        	File file = new File(fileDialog.getFilterPath(), fileDialog.getFileName());
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
				styledText.setText(new String(data, 0, c));
				
			} catch (Exception e1) {
				MessageBox messageBox = new MessageBox(shell, SWT.ICON_ERROR | SWT.OK);
		        messageBox.setText("Ошибка");
		        messageBox.setMessage("Ошибка работы с файлом\n" + e1.getMessage());
		        messageBox.open();
			}
		}
	}
	private void tableSizeAction(SelectionEvent e) {
		
		int x = 0;
		int y = 0;
		try {
			x = Integer.valueOf(cols.getText());
			y = Integer.valueOf(rows.getText());
		} catch (NumberFormatException e1) {
			MessageBox messageBox = new MessageBox(shell, SWT.ICON_WARNING | SWT.OK);
	        messageBox.setText("Warning");
	        messageBox.setMessage("Incorrect row/column value format.\nOnly integer values are allowed");
	        messageBox.open();
	        return;
		}
		
		table.setRedraw(false);

		if(table.getColumnCount() != x) {
			/*
			 * Удаляю заголовок таблицы
			 */
			while (table.getColumnCount() > 0) {
			    table.getColumns()[0].dispose();
			}
			/*
			 * Созданю новый заголовок таблицы
			 */
			for (int i = 0; i < x; i++) {
				TableColumn column = new TableColumn(table, SWT.NULL);
				column.setText("Col " + (i+1));	
			}
		}
		/*
		 * Удаляю все элементы таблицы
		 * и указываю новое количество строк
		 */
		table.removeAll();
		table.setItemCount(y);

		for (TableColumn column: table.getColumns()) {
			column.pack();
		}
	    table.setRedraw(true);
	}
	private void tablePopulateAction(SelectionEvent e) {
		
		String[] bounds = range.getText().split("-");
		int x = 0;
		int y = 0;
		
		try {
			x = Integer.valueOf(bounds[0]);
			y = Integer.valueOf(bounds[1]);
		} catch (Exception e1) {
			MessageBox messageBox = new MessageBox(shell, SWT.ICON_WARNING | SWT.OK);
	        
	        messageBox.setText("Warning");
	        messageBox.setMessage("Incorrect range value format.\nUse the following format range, for example, 1-125");
	        messageBox.open();
	        return;
		}
		table.setRedraw(false);
		
		int totalRows = table.getItemCount();
		table.removeAll();
		table.setItemCount(totalRows);

	    for (int i = 0; i < totalRows && x <= y; i++) {
	    	TableItem item = table.getItem(i);
	    	for (int j = 0; j < table.getColumnCount() && x <= y; j++) {
					item.setText(j, Integer.toString(x));
					x++;
	    	}
	    }
		for (TableColumn column: table.getColumns()) {
			column.pack();
		}
		table.setRedraw(true);
	}
	private class ListCellRenderer extends javax.swing.DefaultListCellRenderer {
		
		private int[] indexes;
		private java.awt.Color color;

		private ListCellRenderer(int[] i, java.awt.Color c) {
			this.indexes = i;
			this.color = c;
		}
		
		@Override
		public java.awt.Component getListCellRendererComponent(javax.swing.JList list, Object value,
                int index, boolean isSelected, boolean cellHasFocus) {

            java.awt.Component c = super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);

            if (color != null) {

            	if(Arrays.stream(indexes).anyMatch(x -> x == index)) {
            		c.setBackground(color);
            	}
            }
            return c;
        }
	}
}

