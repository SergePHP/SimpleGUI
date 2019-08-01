package opTask1.swt;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.FontDialog;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Label;
import swing2swt.layout.FlowLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Text;
import org.omg.CORBA.FREE_MEM;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Group;
import swing2swt.layout.BorderLayout;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormAttachment;
import swing2swt.layout.BoxLayout;
import org.eclipse.swt.widgets.DateTime;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.TabFolder;
import org.eclipse.swt.widgets.TabItem;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.RowData;
import java.awt.Component;
import javax.swing.Box;
import java.awt.Frame;
import java.awt.GraphicsEnvironment;

import org.eclipse.swt.awt.SWT_AWT;
import java.awt.Panel;
import javax.swing.JRootPane;
import javax.swing.JButton;
import javax.swing.JTextPane;
import org.eclipse.swt.widgets.CoolBar;
import org.eclipse.swt.widgets.CoolItem;
import org.eclipse.swt.widgets.List;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.FontData;

public class task1GUI {

	protected Shell shell;
	private Text cols;
	private Text rows;
	private Text range;
	private Label lblNewLabel;
	private Label lblNewLabel_1;
	private Label lblNewLabel_2;
	private Button btnTableFill;
	private Group tFontGroup;
	private Label lblNewLabel_4;
	private Button btnFontSelect;
	private Table table;
	private Group group;
	private StyledText styledText;
	private Button btnNewButton;
	private Button btnNewButton_1;
	private Button btnNewButton_2;
	private Label label;

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
		shell.setSize(805, 587);
		shell.setText("ОП. Задание №1");
		shell.setLayout(new GridLayout(5, false));
		
		Group tSizeGroup = new Group(shell, SWT.NONE);
		tSizeGroup.setText("Размер таблицы");
		tSizeGroup.setLayout(new GridLayout(2, false));
		
		lblNewLabel = new Label(tSizeGroup, SWT.NONE);
		lblNewLabel.setText("Столбцов");
		
		cols = new Text(tSizeGroup, SWT.BORDER);
		cols.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		cols.setBounds(0, 0, 81, 29);
		
		lblNewLabel_1 = new Label(tSizeGroup, SWT.NONE);
		lblNewLabel_1.setText("Строк");
		
		rows = new Text(tSizeGroup, SWT.BORDER);
		rows.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		rows.setBounds(0, 0, 81, 29);
		new Label(tSizeGroup, SWT.NONE);
		
		Button btnTableSize = new Button(tSizeGroup, SWT.NONE);
		btnTableSize.setBounds(0, 0, 97, 29);
		btnTableSize.setText("Установить");
		
		Group tFillGroup = new Group(shell, SWT.NONE);
		tFillGroup.setText("Заполнение таблицы");
		tFillGroup.setLayout(new GridLayout(2, false));
		
		lblNewLabel_2 = new Label(tFillGroup, SWT.NONE);
		lblNewLabel_2.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblNewLabel_2.setText("Диапазон");
		
		range = new Text(tFillGroup, SWT.BORDER);
		range.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		range.setBounds(0, 0, 81, 29);
		new Label(tFillGroup, SWT.NONE);
		
		btnTableFill = new Button(tFillGroup, SWT.NONE);
		btnTableFill.setText("Заполнить");
		new Label(shell, SWT.NONE);
		
		tFontGroup = new Group(shell, SWT.NONE);
		tFontGroup.setText("Выбор шрифта");
		tFontGroup.setLayout(new GridLayout(2, false));
		
		Label lblNewLabel_3 = new Label(tFontGroup, SWT.NONE);
		lblNewLabel_3.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
		lblNewLabel_3.setBounds(0, 0, 71, 17);
		lblNewLabel_3.setText("Список шрифтов");
		
		lblNewLabel_4 = new Label(tFontGroup, SWT.NONE);
		lblNewLabel_4.setText("Стандартный диалог");
		
		Combo combo = new Combo(tFontGroup, SWT.NONE);
		combo.setBounds(0, 0, 199, 29);
		
		String fonts[] = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
		for (String string : fonts) {
			combo.add(string);
		}
		
		btnFontSelect = new Button(tFontGroup, SWT.NONE);
		btnFontSelect.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				Shell shell = new Shell();
				FontDialog dlg = new FontDialog(shell);
				
			    FontData fontData = dlg.open();
			    if (fontData != null) {
			      Font font = new Font(shell.getDisplay(), fontData);
		
			      font.dispose();
			    }
			}
		});
		btnFontSelect.setText("Выбрать шрифт");
		btnFontSelect.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
		new Label(shell, SWT.NONE);
		
		table = new Table(shell, SWT.BORDER | SWT.FULL_SELECTION);
		table.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 5, 1));
		table.setHeaderVisible(true);
		table.setLinesVisible(true);
		
		group = new Group(shell, SWT.NONE);
		group.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		group.setLayout(new GridLayout(1, false));
		
		btnNewButton = new Button(group, SWT.NONE);
		btnNewButton.setBounds(0, 0, 97, 29);
		btnNewButton.setText("New Button");
		
		btnNewButton_1 = new Button(group, SWT.NONE);
		btnNewButton_1.setBounds(0, 0, 97, 29);
		btnNewButton_1.setText("New Button");
		
		List list = new List(shell, SWT.BORDER | SWT.H_SCROLL | SWT.V_SCROLL);
		GridData gd_list = new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1);
		gd_list.heightHint = 151;
		list.setLayoutData(gd_list);

		for (String string : fonts) {
			list.add(string);
		}
		
		label = new Label(shell, SWT.SEPARATOR | SWT.VERTICAL);
		
		styledText = new StyledText(shell, SWT.BORDER);
		styledText.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		new Label(shell, SWT.NONE);
		new Label(shell, SWT.NONE);
		new Label(shell, SWT.NONE);
		new Label(shell, SWT.NONE);
		
		btnNewButton_2 = new Button(shell, SWT.NONE);
		btnNewButton_2.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
		btnNewButton_2.setText("New Button");
		new Label(shell, SWT.NONE);


	}
}
