/*
 * 营业厅业务员管理司机信息界面
 */
package presentation.manageui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.rmi.RemoteException;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import businesslogic.managebl.Manage;
import businesslogic.managebl.ManageController;
import businesslogicservice.ManageblService;

public class DriverPanel extends JPanel {

	int x = 60, y = 60, width = 70, height = 30, addx = 100, addy = 70;

	// 定义司机信息的label
	JLabel DriverInfo;
	// 定义添加，删除，修改，查询按钮
	JButton add, delete, modify, search;

	JScrollPane jsp;
	// 定义表格
	JTable driverTable = null;
	// 定义表格模型对象
	DefaultTableModel tableModel;
	// 定义输入司机编号文本框
	JTextField inputInfo;
	// 定义字体
	Font font1 = new Font("楷体", Font.PLAIN, 25);
	Font font2 = new Font("宋体", Font.PLAIN, 15);
	// 定义表格各列的对象
	Object c0, c1, c2, c3,c4, c5, c6, c7;
	//被选中的要修改的行号
	int modRowNum;

	public DriverPanel() {

		this.setLayout(null);

		DriverInfo = new JLabel("司机信息", JLabel.CENTER);
		DriverInfo.setFont(font1);
		DriverInfo.setBounds(220, 10, 200, height);

		add = new JButton("添加");
		add.setFont(font2);
		add.setBounds(x, y, width, height);
		add.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {

				new addDriverDialog(DriverPanel.this).setVisible(true);

			}
		});

		delete = new JButton("删除");
		delete.setFont(font2);
		delete.setBounds(x + addx, y, width, height);
		delete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int rowNum = driverTable.getSelectedRow();
				if(rowNum!=-1){
					tableModel.removeRow(rowNum);
				}				
			}
		});

		modify = new JButton("修改");
		modify.setFont(font2);
		modify.setBounds(x + 2 * addx, y, width, height);
		final modifyDriverDialog modDriver = new modifyDriverDialog(DriverPanel.this);
		modify.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				modRowNum = driverTable.getSelectedRow();
				if(modRowNum!=-1){
					modDriver.setVisible(true);
				}				
			}
		});

		inputInfo = new JTextField();
		inputInfo.setFont(font2);
		inputInfo.setText("请输入司机编号");
		inputInfo.setForeground(Color.GRAY);
		inputInfo.addFocusListener(new TextFocus());
		inputInfo.setBounds(x + 3 * addx + 20, y, 120, height);

		search = new JButton("查询");
		search.setFont(font2);
		search.setBounds(x + 4 * addx + 50, y, width, height);
		
		try {
			ManageblService bl = new ManageController();
		} catch (RemoteException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		

		String[] column = { "司机编号", "姓名", "性别", "出生日期", "身份证号", "手机", "车辆单位",
				"行驶证期限" };
		String[] s1 = { "025000000", "张三", "男", "1988-8-8",
				"320682198808082631", "18322913658", "", "2" };
		String row[][] = { s1 };
		tableModel = new DefaultTableModel(row, column);
		driverTable = new JTable(tableModel);
		driverTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);// 单选
		driverTable.addMouseListener(new MouseAdapter() {// 鼠标事件
					public void mouseClicked(MouseEvent e) {
						int selectedRow = driverTable.getSelectedRow(); // 获得选中行索引
						c0 = tableModel.getValueAt(selectedRow, 0);
						c1 = tableModel.getValueAt(selectedRow, 1);
						c2 = tableModel.getValueAt(selectedRow, 2)!=null?tableModel.getValueAt(selectedRow, 2):"";
						c3 = tableModel.getValueAt(selectedRow, 3);
						c4 = tableModel.getValueAt(selectedRow, 4);
						c5 = tableModel.getValueAt(selectedRow, 5);
						c6 = tableModel.getValueAt(selectedRow, 6);
						c7 = tableModel.getValueAt(selectedRow, 7);
						try {
							modDriver.getDriverNum().setText(c0.toString());
							modDriver.getDriverName().setText(c1.toString());
							if(c2.toString().equals("男")){
								modDriver.getMale().setSelected(true);
							}else{
								modDriver.getFemale().setSelected(true);
							}
							modDriver.getBirthDate().setText(c3.toString());
							modDriver.getIdNum().setText(c4.toString());
							modDriver.getPhone().setText(c5.toString());
							modDriver.getInstitution().setText(c6.toString());
							modDriver.getLicenseTime().setText(c7.toString());
						} catch (NullPointerException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
				});
		driverTable.setFont(font2);
		driverTable.setRowHeight(20);
		jsp = new JScrollPane(driverTable);
		jsp.setBounds(0, y + addy, 650, 400);

		this.add(DriverInfo);
		this.add(add);
		this.add(delete);
		this.add(modify);
		this.add(inputInfo);
		this.add(search);
		this.add(jsp);
	}

	/**
	 * 添加用户输入的司机信息
	 * @param row
	 */
	public void addAfterConfirm(String[] row) {
		tableModel.addRow(row);
	}

	/**
	 * 修改司机信息
	 * @param row
	 */
	public void updateAfterConfirm(String[] row) {
		tableModel.setValueAt(row[0], modRowNum, 0);
		tableModel.setValueAt(row[1], modRowNum, 1);
		tableModel.setValueAt(row[2], modRowNum, 2);
		tableModel.setValueAt(row[3], modRowNum, 3);
		tableModel.setValueAt(row[4], modRowNum, 4);
		tableModel.setValueAt(row[5], modRowNum, 5);
		tableModel.setValueAt(row[6], modRowNum, 6);
		tableModel.setValueAt(row[7], modRowNum, 7);
	}
	
	/**
	 * 焦点监听
	 * @author Administrator
	 *
	 */
	class TextFocus implements FocusListener {

		public void focusGained(FocusEvent arg0) {
			if ("请输入司机编号".equalsIgnoreCase(inputInfo.getText())) {
				inputInfo.setText("");
				inputInfo.setForeground(Color.BLACK);
			}
		}

		public void focusLost(FocusEvent arg0) {
			if ("".equalsIgnoreCase(inputInfo.getText().trim())) {
				inputInfo.setForeground(Color.GRAY);
				inputInfo.setText("请输入司机编号");
			}
		}

	}
}
