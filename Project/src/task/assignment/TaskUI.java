package task.assignment;

import java.awt.*;
import javax.swing.*;
import net.miginfocom.swing.MigLayout;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.*;


public class TaskUI {

	private JFrame frame;
	private JTable table;
	private JTextArea textArea;
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
	private JPanel panel_1;
	private JPanel panel_2;
	private JComboBox comboBox;
	private Component horizontalStrut_2;
	private Box verticalBox_3;
	private JLabel lblNewLabel_1;
	private JButton btnNewButton;
	private JPanel panel_3;
	private JPanel panel_4;
	private String[] listList;
	private JList list;
	private JScrollPane scrollPane_2;
	private JButton btnNewButton_1;
	private JButton btnNewButton_2;
	private JPanel panel_5;
	private Box horizontalBox;
	private JButton btnNewButton_3;
	private JPanel panel_6;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TaskUI window = new TaskUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TaskUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 690, 690);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		panel_1 = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel_1.getLayout();
		flowLayout.setVgap(15);
		flowLayout.setHgap(15);
		Border border = BorderFactory.createTitledBorder("Table size");
		panel_1.setBorder(border);
		panel.add(panel_1);
		
		verticalBox = Box.createVerticalBox();
		panel_1.add(verticalBox);
		
		lblRows = new JLabel("Rows: ");
		lblRows.setAlignmentX(Component.CENTER_ALIGNMENT);
		verticalBox.add(lblRows);
		
		textField = new JTextField();
		verticalBox.add(textField);
		textField.setColumns(5);
		
		lblCols = new JLabel("Cols: ");
		lblCols.setAlignmentX(Component.CENTER_ALIGNMENT);
		verticalBox.add(lblCols);
		
		textField_1 = new JTextField();
		verticalBox.add(textField_1);
		textField_1.setColumns(5);
		
		btnSet = new JButton("Set");
		btnSet.setAlignmentX(Component.CENTER_ALIGNMENT);
		verticalBox.add(btnSet);
		
		horizontalStrut = Box.createHorizontalStrut(20);
		panel.add(horizontalStrut);
		
		panel_2 = new JPanel();
		FlowLayout flowLayout_1 = (FlowLayout) panel_2.getLayout();
		flowLayout_1.setVgap(15);
		flowLayout_1.setHgap(15);
		Border border_2 = BorderFactory.createTitledBorder("Filling the table");
		panel_2.setBorder(border_2);
		panel.add(panel_2);
		
		verticalBox_1 = Box.createVerticalBox();
		panel_2.add(verticalBox_1);
		
		label = new JLabel("Range: ");
		label.setAlignmentX(Component.CENTER_ALIGNMENT);
		verticalBox_1.add(label);
		
		textField_2 = new JTextField();
		verticalBox_1.add(textField_2);
		textField_2.setColumns(10);
		
		btnFill = new JButton("Fill");
		btnFill.setAlignmentX(Component.CENTER_ALIGNMENT);
		verticalBox_1.add(btnFill);
		
		horizontalStrut_1 = Box.createHorizontalStrut(20);
		panel.add(horizontalStrut_1);
		
		panel_6 = new JPanel();
		FlowLayout flowLayout_2 = (FlowLayout) panel_6.getLayout();
		flowLayout_2.setVgap(15);
		flowLayout_2.setHgap(15);
		panel_6.setBorder(new TitledBorder(null, "Font operations", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.add(panel_6);
		
		verticalBox_2 = Box.createVerticalBox();
		panel_6.add(verticalBox_2);
		
		lblNewLabel = new JLabel("Font List");
		lblNewLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		verticalBox_2.add(lblNewLabel);
		
		comboBox = new JComboBox();
		verticalBox_2.add(comboBox);
		
		horizontalStrut_2 = Box.createHorizontalStrut(20);
		panel_6.add(horizontalStrut_2);
		
		verticalBox_3 = Box.createVerticalBox();
		panel_6.add(verticalBox_3);
		
		lblNewLabel_1 = new JLabel("Font dialog");
		lblNewLabel_1.setAlignmentX(Component.CENTER_ALIGNMENT);
		verticalBox_3.add(lblNewLabel_1);
		
		btnNewButton = new JButton("Choice font");
		btnNewButton.setAlignmentX(Component.CENTER_ALIGNMENT);
		verticalBox_3.add(btnNewButton);
		
		scrollPane_1 = new JScrollPane();
		frame.getContentPane().add(scrollPane_1);
		
		table = new JTable(50, 6);
		scrollPane_1.setViewportView(table);
		//table.setBorder(new LineBorder(new Color(0, 0, 0)));
		
		panel_3 = new JPanel();
		frame.getContentPane().add(panel_3);
		
		panel_5 = new JPanel();
		panel_3.add(panel_5);
		panel_5.setLayout(new GridLayout(2, 0, 0, 0));
		
		btnNewButton_1 = new JButton("Set color");
		panel_5.add(btnNewButton_1);
		btnNewButton_1.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		btnNewButton_2 = new JButton("Increase size");
		panel_5.add(btnNewButton_2);
		btnNewButton_2.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		scrollPane_2 = new JScrollPane();
		panel_3.add(scrollPane_2);
		
		list = new JList();
		list.setFont(new Font("Tahoma", Font.PLAIN, 13));
		list.setModel(new AbstractListModel() {
			String[] values = new String[] {"one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		
				scrollPane_2.setViewportView(list);
				list.setPreferredSize(new Dimension(200, 180));
		
		panel_4 = new JPanel();
		frame.getContentPane().add(panel_4);
		panel_4.setLayout(new GridLayout(0, 1, 0, 0));
		
		scrollPane = new JScrollPane();
		panel_4.add(scrollPane);
		
		textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		
		horizontalBox = Box.createHorizontalBox();
		scrollPane.setRowHeaderView(horizontalBox);
		
		btnNewButton_3 = new JButton("Open");
		horizontalBox.add(btnNewButton_3);

	}
}
