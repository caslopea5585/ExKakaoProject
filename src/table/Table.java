package table;


import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.event.TableModelEvent;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableModel;



public class Table extends JFrame implements ActionListener,TableCellRenderer{
	JPanel panel;
	JButton bt;
	JTable table;
	JScrollPane scroll;
	ArrayList<JPanel> array = new ArrayList<JPanel>();
	DefaultTableModel model;
	
	public Table() {
		
		bt= new JButton("추가하기");
		

		
		table = new JTable();
		scroll = new JScrollPane(table);
		add(scroll);
		add(bt);
		
		pack();
		
		setLayout(new FlowLayout());
		bt.addActionListener(this);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(500, 500);
	}

	public void actionPerformed(ActionEvent e) {
		System.out.println("클릭");
		bt = new JButton("sas");
		this.add(bt);
		
		panel = new JPanel();
		panel.add(bt);
		
		bt.setPreferredSize(new Dimension(300, 200));
		
		
		array.add(panel);
		System.out.println(array.size());
		
		
		
		model = new DefaultTableModel();
		model.setDataVector(
				new Object[][]{
					{array.get(0)}
				},
				new Object[]{"String"});
		
		table.setModel(model);
		table.getColumn("String").setCellRenderer(new JPanelRenderer());
		table.getColumn("String").setCellEditor(new JPanelEditor(new JCheckBox()));
	}
	
	
	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
			int row, int column) {
		
		if(value==null)return null;
		panel = (JPanel)value;

		
		return (Component)value;
	}
	
	class JPanelRenderer implements TableCellRenderer {
		public Component getTableCellRendererComponent(JTable table, Object value,
		boolean isSelected, boolean hasFocus, int row, int column) {
			if (value==null) return null;
			return (Component)value;
		}
	}
	
	class JPanelEditor extends DefaultCellEditor {
		private JPanel jpanel;
		
		public JPanelEditor(JCheckBox ch) {
			super(ch);
		}


			public Component getTableCellEditorComponent(JTable table, Object value,
					boolean isSelected, int row, int column) {
					if (value==null) return null;
					jpanel = (JPanel)value;
				
					return (Component)value;
				}
				
			public Object getCellEditorValue() {
				jpanel.remove(jpanel);
				return jpanel;
			}
			

		}
	
	
	
	
	
	
	
	
	public static void main(String[] args) {
		new Table();
	}
}
