package opTask1.swt;

import org.eclipse.swt.widgets.*;
import org.eclipse.swt.SWT;
import org.eclipse.swt.awt.SWT_AWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import java.awt.GraphicsEnvironment;
import java.io.File;
import java.io.FileReader;
import java.util.Arrays;

import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Color;
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
	private Label colorStatus;
	private Group tCellValue;
	private Text cellValue;
	private Text col;
	private Text row;
	private Label lblNewLabel_6;
	private Label lblNewLabel_7;
	private Label lblNewLabel_8;
	private Button btnCellValue;
	
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
		shell.setSize(1230, 920);
		shell.setText("ОП. Задание №1");
		GridLayout gl_shell = new GridLayout(3, false);
		shell.setLayout(gl_shell);
		/*
		 * Создаю таблицу, панели для расположения элементов управления 
		 * и элементы управления для взаимодействия с таблицей 
		 */
		Group tSizeGroup = new Group(shell, SWT.NONE);
		tSizeGroup.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		tSizeGroup.setText("Размер таблицы");
		tSizeGroup.setLayout(new GridLayout(2, false));
		
		lblNewLabel = new Label(tSizeGroup, SWT.NONE);
		lblNewLabel.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblNewLabel.setText("Столбцов");
		/*
		 * Поле для указания количества столбцов
		 */
		cols = new Text(tSizeGroup, SWT.BORDER);
		cols.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		cols.setText("10"); // значение по умолчанию
		
		lblNewLabel_1 = new Label(tSizeGroup, SWT.NONE);
		lblNewLabel_1.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblNewLabel_1.setText("Строк");
		/*
		 * Поле для указания количества строк
		 */
		rows = new Text(tSizeGroup, SWT.BORDER);
		rows.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		rows.setText("10"); // значение по умолчанию
		new Label(tSizeGroup, SWT.NONE);
		
		/*
		 * Кнопка, реализующая задание:
		 * - установить указанное количество строк и столбцов в таблице;
		 */
		Button btnTableSize = new Button(tSizeGroup, SWT.NONE);
		btnTableSize.setText("Установить");
		/*
		 * Назначаю обработчик событий нажатия на кнопку;
		 * Создаю анонимный класс реализующий интерфейс SelectionListener;
		 * Перегружаю метод обработчика и вызываю свой метод для обработки события
		 */
		btnTableSize.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				tableSizeAction(e);
			}
		});

		tFontGroup = new Group(shell, SWT.NONE);
		tFontGroup.setLayoutData(new GridData(SWT.LEFT, SWT.FILL, false, false, 1, 1));
		tFontGroup.setText("Выбор шрифта");
		tFontGroup.setLayout(new GridLayout(2, false));
		
		Label lblNewLabel_3 = new Label(tFontGroup, SWT.NONE);
		lblNewLabel_3.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
		lblNewLabel_3.setText("Список шрифтов");
		
		lblNewLabel_4 = new Label(tFontGroup, SWT.NONE);
		lblNewLabel_4.setText("Стандартный диалог");
		/*
		 * Список, реализующий задание:
		 * - отформатировать текст в таблице шрифтом, выбрав его из заданного списка;
		 */
		combo = new Combo(tFontGroup, SWT.NONE);
		
		// Получаю массив шрифтов и добавляю их в список
		
		String fonts[] = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
		for (String string : fonts) {
			combo.add(string);
		}
		/*
		 * Назначаю обработчик событий выбора пункта в выпадающем списке;
		 * Создаю анонимный класс реализующий интерфейс SelectionListener;
		 * Перегружаю метод обработчика и обрабатываю событие
		 */
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
		/*
		 * Кнопка, реализующая задание:
		 * - отформатировать текст в таблице шрифтом, выбрав его из стандартного диалога выбора шрифта;
		 */
		btnFontSelect = new Button(tFontGroup, SWT.NONE);
		btnFontSelect.setText("Выбрать шрифт");
		btnFontSelect.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
		/*
		 * Назначаю обработчик событий нажатия на кнопку;
		 * Создаю анонимный класс реализующий интерфейс SelectionListener;
		 * Перегружаю метод обработчика и обрабатываю событие
		 */
		btnFontSelect.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				/*
				 * Создаю экземпляр класса FontDialog,
				 * который позволяет пользователю выбрать шрифт
				 * использую стандартный диалог выбора шрифта
				 */
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

		new Label(shell, SWT.NONE);
		
		tCellValue = new Group(shell, SWT.NONE);
		tCellValue.setText("Значение ячейки");
		tCellValue.setLayout(new GridLayout(3, false));
		tCellValue.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		
		lblNewLabel_8 = new Label(tCellValue, SWT.NONE);
		lblNewLabel_8.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblNewLabel_8.setText("Значение");

		/*
		 * Текстовое поле для ввода значения,
		 * которое будет введено в указанную ячейку таблицы
		 */
		
		cellValue = new Text(tCellValue, SWT.BORDER);
		cellValue.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		cellValue.setText("42"); // значение по умолчанию
		/*
		 * Кнопка, реализующая задание:
		 * - ввести заданное в поле ввода значение в указанную ячейку таблицы;
		 */
		btnCellValue = new Button(tCellValue, SWT.NONE);
		btnCellValue.setLayoutData(new GridData(SWT.CENTER, SWT.FILL, false, false, 1, 3));
		btnCellValue.setText("Записать");
		/*
		 * Назначаю обработчик событий нажатия на кнопку;
		 * Создаю анонимный класс реализующий интерфейс SelectionListener;
		 * Перегружаю метод обработчика и вызываю свой метод для обработки события
		 */
		btnCellValue.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				cellValueAction(e);
			}
		});

		lblNewLabel_6 = new Label(tCellValue, SWT.NONE);
		lblNewLabel_6.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblNewLabel_6.setText("Столбец");
		
		// Текстовое поле для ввода номера столбца

		col = new Text(tCellValue, SWT.BORDER);
		col.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		col.setText("5"); // значение по умолчанию
		
		lblNewLabel_7 = new Label(tCellValue, SWT.NONE);
		lblNewLabel_7.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblNewLabel_7.setText("Строка");
		
		// Текстовое поле для ввода номера строки
		
		row = new Text(tCellValue, SWT.BORDER);
		row.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		row.setText("5"); // значение по умолчанию
		/*
		 *  Создаю пустую таблицу
		 */
		table = new Table(shell, SWT.BORDER | SWT.FULL_SELECTION | SWT.V_SCROLL | SWT.H_SCROLL);
		GridData gd_table = new GridData(SWT.FILL, SWT.FILL, true, false, 2, 2);
		gd_table.heightHint = 300;
		table.setLayoutData(gd_table);
		table.setHeaderVisible(true);
		table.setLinesVisible(true);
		
		Group tPopulateGroup = new Group(shell, SWT.NONE);
		GridData gd_tPopulateGroup = new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1);
		tPopulateGroup.setLayoutData(gd_tPopulateGroup);
		tPopulateGroup.setText("Данные таблицы");
		tPopulateGroup.setLayout(new GridLayout(2, false));
		
		lblNewLabel_2 = new Label(tPopulateGroup, SWT.NONE);
		lblNewLabel_2.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblNewLabel_2.setText("Диапазон");
		/*
		 * Поле для указания диапазона
		 */
		range = new Text(tPopulateGroup, SWT.BORDER);
		range.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		range.setText("1-100"); // значение по умолчанию
		new Label(tPopulateGroup, SWT.NONE);
		/*
		 * Кнопка, реализующая задание:
		 * - заполнить таблицу производными значениями в указанном диапазоне;
		 */
		btnTablePopulate = new Button(tPopulateGroup, SWT.NONE);
		btnTablePopulate.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, true, false, 1, 1));
		btnTablePopulate.setText("Заполнить");
		/*
		 * Назначаю обработчик событий нажатия на кнопку;
		 * Создаю анонимный класс реализующий интерфейс SelectionListener;
		 * Перегружаю метод обработчика и вызываю свой метод для обработки события
		 */
		btnTablePopulate.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				tablePopulateAction(e);
			}
		});
		
		listGroup = new Group(shell, SWT.NONE);
		listGroup.setText("Поведение списка");
		listGroup.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
		listGroup.setLayout(new GridLayout(2, false));
		
		Label lblNewLabel_5 = new Label(listGroup, SWT.NONE);
		lblNewLabel_5.setText("Индекс в списке");
		lblNewLabel_5.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		
		indexesString = new Text(listGroup, SWT.BORDER);
		/*
		 * Назначаю обработчик событий нажатия клавиши ENTER в поле ввода;
		 * Создаю анонимный класс реализующий интерфейс KeyListener;
		 * Перегружаю метод обработчика и обрабатываю событие
		 */
		indexesString.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.keyCode == SWT.CR) {
					int[] indexes = getIndexes();
					if(indexes != null && color != null) {
						/*
						 * Назначаю пользовальский отрисовщик компонента JList;
						 */
						list.setCellRenderer(new ListCellRenderer(indexes, color));
					}
				}
			}
		});
		indexesString.setText("1,4,7");
		indexesString.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		colorStatus = new Label(listGroup, SWT.NONE);
		colorStatus.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		colorStatus.setText("Цвет не выбран");
		
		btnSelectColor = new Button(listGroup, SWT.NONE);
		/*
		 * Назначаю обработчик событий нажатия на кнопку;
		 * Создаю анонимный класс реализующий интерфейс SelectionListener;
		 * Перегружаю метод обработчика и вызываю свой метод для обработки события
		 */
		btnSelectColor.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				setColorAction(e);
			}
		});
		btnSelectColor.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		btnSelectColor.setText("Установить цвет");
		new Label(listGroup, SWT.NONE);
		/*
		 * Кнопка, реализующая задание
		 * - установить высоту каждого элемента списка на 5 пунктов больше, чем предыдущего;
		 */
		btnIncSize = new Button(listGroup, SWT.NONE);
		/*
		 * Назначаю обработчик событий нажатия на кнопку;
		 * Создаю анонимный класс реализующий интерфейс SelectionListener;
		 * Перегружаю метод обработчика и обрабатываю событие
		 */
		btnIncSize.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				java.awt.Font font = list.getFont();
				list.setFont(font.deriveFont((float)font.getSize() + 5));
			}
		});
		GridData gd_btnIncSize = new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1);
		gd_btnIncSize.heightHint = 29;
		btnIncSize.setLayoutData(gd_btnIncSize);
		btnIncSize.setText("Увеличить шрифт");
		
		composite = new Composite(shell, SWT.EMBEDDED | SWT.NO_BACKGROUND);
		composite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, true, 1, 1));
		
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
		list.setVisibleRowCount(20);
		
		for (String string : fontsForList) {
			listModel.addElement(string);
		}

		scrollPane.setViewportView(list);
		
		styledText = new StyledText(shell, SWT.BORDER | SWT.V_SCROLL | SWT.H_SCROLL );
		styledText.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		new Label(shell, SWT.NONE);
		new Label(shell, SWT.NONE);

		/*
		 * Кнопка, реализующая задание
		 * - загрузить файл, выбранный с применением стандартного
		 * диалога Открыть файл в многострочное текстовое поле.
		 */
		btnOpenFile = new Button(shell, SWT.NONE);
		/*
		 * Назначаю обработчик событий нажатия на кнопку;
		 * Создаю анонимный класс реализующий интерфейс SelectionListener;
		 * Перегружаю метод обработчика и обрабатываю событие
		 */
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
				colorStatus.setText("Выбран цвет");
				colorStatus.setBackground(new Color(shell.getDisplay(), rgb));

				color = new java.awt.Color(rgb.red, rgb.green, rgb.blue);
				list.setCellRenderer(new ListCellRenderer(indexes, color));
			}
		}
	}
	private void cellValueAction(SelectionEvent e) {
		int x = 0;
		int y = 0;
		try {
			x = Integer.valueOf(col.getText());
			y = Integer.valueOf(row.getText());
		} catch (NumberFormatException e1) {
			showMessage("Предупреждение", SWT.ICON_WARNING,
					"Неверно указано значение колонки/столбца\nДопустимы только целочисленные значения");
	        return;
		}
		if(table.getColumnCount() < x || table.getItemCount() < y 
				|| x == 0 || y == 0) {
			showMessage("Предупреждение", SWT.ICON_WARNING,
					"Указанная ячейка находится за пределами таблицы");
	        return;
		}
		table.setRedraw(false);
		
		TableItem item = table.getItem(y - 1);
		item.setText(x, cellValue.getText());
		
		for (TableColumn column: table.getColumns()) {
			column.pack();
		}
	
		table.setRedraw(true);
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
				showMessage("Ошибка", SWT.ICON_ERROR, 
						"Ошибка работы с файлом\n" + e1.getMessage());
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
			showMessage("Предупреждение", SWT.ICON_WARNING,
					"Неверно указано значение колонок/столбцов\nДопустимы только целочисленные значения");
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
			TableColumn firstColumn = new TableColumn(table, SWT.NULL);
			firstColumn.setText("     ");

			for (int i = 1; i <= x; i++) {
				TableColumn column = new TableColumn(table, SWT.NULL);
				column.setText("Col " + i);	
			}
		}
		/*
		 * Удаляю все элементы таблицы
		 * и указываю новое количество строк
		 */
		table.removeAll();
		table.setItemCount(y);
		
		for (int i = 0; i < y; i++) {
			TableItem item = table.getItem(i);
			item.setText("Row " + (i + 1));
		}

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
			showMessage("Warning", SWT.ICON_WARNING, 
					"Incorrect range value format.\nUse the following format range, for example, 1-125");
	        return;
		}
		table.setRedraw(false);
		
		int totalRows = table.getItemCount();
		table.removeAll();
		table.setItemCount(totalRows);

	    for (int i = 0; i < totalRows && x <= y; i++) {
	    	TableItem item = table.getItem(i);
	    	for (int j = 1; j < table.getColumnCount() && x <= y; j++) {
	    			item.setText("Row " + (i + 1));
					item.setText(j, Integer.toString(x));
					x++;
	    	}
	    }
		for (TableColumn column: table.getColumns()) {
			column.pack();
		}
		table.setRedraw(true);
	}
	private int[] getIndexes() {
		
		String[] temp = indexesString.getText().replaceAll("\\s", "").split(",");
		int[] listIndexes = new int[temp.length];
		
		try {
			for (int i = 0; i < temp.length; i++) {
				listIndexes[i] = Integer.valueOf(temp[i]);
			}
		} catch (Exception e2) {
				showMessage("Предупреждение", SWT.ICON_WARNING, 
						"Invalid index sequence value format.\nUse the following index sequence format, for example, 1,35,42");
		        return null;
		}
		return listIndexes;
	}
	private void showMessage(String header, int style, String message) {
		
		MessageBox messageBox = new MessageBox(shell, style | SWT.OK);
        messageBox.setText(header);
        messageBox.setMessage(message);
        messageBox.open();
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

