package presentation.financeui;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import presentation.manageui.addInstituInfoDialog;

public class FinanceInitialPanel extends JPanel {
	int x = 5, y = 10, width = 70, height = 30;
	private JTabbedPane tab;
	private JPanel panel1;// 期初建账
	private JTabbedPane tab1;
	private JPanel panel2;// 当前期初信息
	private JTabbedPane tab2;
	private JPanel panel3;// 历史期初信息
	private JTabbedPane tab3;
	// 期初建账
	private JLabel t1Label;
	private JPanel a1;// 机构
	private JPanel a2;// 人员
	private JPanel a3;// 车辆
	private JPanel a4;// 库存
	private JPanel a5;// 账户

	// 当前期初信息
	private JLabel t2Label;
	private JPanel b1;// 机构
	private JPanel b2;// 人员
	private JPanel b3;// 车辆
	private JPanel b4;// 库存
	private JPanel b5;// 账户

	// 历史期初信息
	// history1(),history2();

	// 所有按钮所需界面--设置为公用界面
	JPanel iPanel = new JPanel();

	Font font1 = new Font("楷体", Font.PLAIN, 20);
	Font font2 = new Font("宋体", Font.PLAIN, 15);

	/**
	 * 
	 */
	public FinanceInitialPanel() {
		// 初始化各组件
		this.setSize(650, 530);
		this.setLayout(null);

		tab = new JTabbedPane(JTabbedPane.TOP);
		// 期初建账
		// 顶部

		panel1 = new JPanel(null);

		tab1 = new JTabbedPane(JTabbedPane.TOP);
		a1 = a1();
		a2 = a2();
		a3 = a3();
		a4 = a4();
		a5 = a5();
		tab1.add(a1, "机构");
		tab1.add(a2, "人员");
		tab1.add(a3, "车辆");
		tab1.add(a4, "库存");
		tab1.add(a5, "账户");
		tab1.setBounds(0, 0, 650, 525);
		panel1.add(tab1);

		// 底部
		// ………………调用示例如下…………
		/*
		 * a1()是对应于按钮a1（机构）的返回值为panel的方法 a2()是对应于按钮a2（人员）的返回值为panel的方法
		 * a3()是对应于按钮a3（车辆）的返回值为panel的方法 a4()是对应于按钮a4（库存）的返回值为panel的方法
		 * a5()是对应于按钮a5（账户）的返回值为panel的方法
		 */

		// 当前期初
		panel2 = new JPanel(null);

		tab2 = new JTabbedPane(JTabbedPane.TOP);
		b1 = b1();
		b2 = b2();
		b3 = b3();
		b4 = b4();
		b5 = b5();
		tab2.add(b1, "机构");
		tab2.add(b2, "人员");
		tab2.add(b3, "车辆");
		tab2.add(b4, "库存");
		tab2.add(b5, "账户");
		tab2.setBounds(0, 0, 650, 525);
		panel2.add(tab2);
		// 底部
		// ………………调用示例如下…………
		/*
		 * b1()是对应于按钮b1（机构）的返回值为panel的方法 b2()是对应于按钮b2（人员）的返回值为panel的方法
		 * b3()是对应于按钮b3（车辆）的返回值为panel的方法 b4()是对应于按钮b4（库存）的返回值为panel的方法
		 * b5()是对应于按钮b5（账户）的返回值为panel的方法
		 */

		// 历史期初
		panel3 = new JPanel();
		panel3.setLayout(null);
		// 开始的界面：输入年份
		// ………………调用示例如下…………
		/*
		 * history1()是实现输入年份界面的返回值为panel的方法
		 */

		// 输入年份后的界面：
		// ………………调用示例如下…………
		/*
		 * history2()是实现输入年份后界面（即有对应年份的机构人员等的界面）的返回值为panel的方法
		 */

		JPanel p1 = new JPanel();
		p1 = history1();
		p1.setBounds(0, 0, 650, 440);
		panel3.add(p1);

		// 历史期初的界面都在方法里面，故要到方法里面实现监听等行为
		// 历史期初的按钮（机构、人员等）在 history2()方法里面，所以对其的监听需要到652行的 history2()方法里实现

		// 界面
		tab.add(panel1, "期初建账");
		tab.add(panel2, "当前帐的期初信息");
		tab.add(panel3, "历史期初信息");

		tab.setBounds(0, 0, 650, 530);
		add(tab);
	}

	/**
	 * 期初建账
	 * 
	 * @return
	 */
	// 期初建账机构界面
	public JPanel a1() {
		int x = 10, y = 5;
		JLabel subLabel;
		JButton addButton;
		JButton deleteButton;
		JButton yesButton;
		JButton noButton;

		JScrollPane jsp;
		JTable Table;

		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setSize(650, 440);

		subLabel = new JLabel("机构信息列表");
		subLabel.setFont(font1);
		subLabel.setBounds(x, y, 150, 40);

		addButton = new JButton("添加");
		addButton.setFont(font2);
		addButton.setBounds(x + 390, y, width, height);
		addButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.out.println("a");
				new addInstituInfoDialog(FinanceInitialPanel.this)
						.setVisible(true);
			}
		});

		deleteButton = new JButton("删除");
		deleteButton.setFont(font2);
		deleteButton.setBounds(x + 490, y, width, height);

		yesButton = new JButton("提交");
		yesButton.setFont(font2);
		yesButton.setBounds(x + 90, y + 350, width, height);

		noButton = new JButton("取消");
		noButton.setFont(font2);
		noButton.setBounds(x + 440, y + 350, width, height);

		panel.add(subLabel);
		panel.add(addButton);
		panel.add(deleteButton);
		panel.add(yesButton);
		panel.add(noButton);

		String[] column1 = { "序号", "机构名称", "机构编号" };
		String[] s1 = { "", "", "" };
		String row1[][] = { s1 };
		Table = new JTable(row1, column1);
		Table.setFont(font2);
		Table.setRowHeight(20);
		jsp = new JScrollPane(Table);
		jsp.setBounds(x - 10, y + 50, 650, 280);
		panel.add(jsp);

		return panel;
	}

	// 期初建账人员界面
	public JPanel a2() {
		int x = 10, y = 0;
		JLabel subLabel;
		JButton addButton;
		JButton deleteButton;
		JButton yesButton;
		JButton noButton;

		JScrollPane jsp;
		JTable Table;

		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setSize(650, 440);

		subLabel = new JLabel("人员信息列表");
		subLabel.setFont(font1);
		subLabel.setBounds(x, y, 150, 40);

		addButton = new JButton("添加");
		addButton.setFont(font2);
		addButton.setBounds(x + 390, y, width, height);

		deleteButton = new JButton("删除");
		deleteButton.setFont(font2);
		deleteButton.setBounds(x + 490, y, width, height);

		yesButton = new JButton("提交");
		yesButton.setFont(font2);
		yesButton.setBounds(x + 90, y + 350, width, height);

		noButton = new JButton("取消");
		noButton.setFont(font2);
		noButton.setBounds(x + 440, y + 350, width, height);

		panel.add(subLabel);
		panel.add(addButton);
		panel.add(deleteButton);
		panel.add(yesButton);
		panel.add(noButton);

		String[] column1 = { "序号", "姓名", "年龄", "职位", "账号" };
		String[] s1 = { "", "", "", "", "" };
		String row1[][] = { s1 };
		Table = new JTable(row1, column1);
		Table.setFont(font2);
		Table.setRowHeight(20);
		jsp = new JScrollPane(Table);
		jsp.setBounds(x - 10, y + 50, 650, 280);
		panel.add(jsp);

		return panel;
	}

	// 期初建账车辆界面
	public JPanel a3() {
		int x = 10, y = 0;
		JLabel subLabel;
		JButton addButton;
		JButton deleteButton;
		JButton yesButton;
		JButton noButton;

		JScrollPane jsp;
		JTable Table;

		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setSize(650, 440);

		subLabel = new JLabel("车辆信息列表");
		subLabel.setFont(font1);
		subLabel.setBounds(x, y, 150, 40);

		addButton = new JButton("添加");
		addButton.setFont(font2);
		addButton.setBounds(x + 390, y, width, height);

		deleteButton = new JButton("删除");
		deleteButton.setFont(font2);
		deleteButton.setBounds(x + 490, y, width, height);

		yesButton = new JButton("提交");
		yesButton.setFont(font2);
		yesButton.setBounds(x + 90, y + 350, width, height);

		noButton = new JButton("取消");
		noButton.setFont(font2);
		noButton.setBounds(x + 440, y + 350, width, height);

		panel.add(subLabel);
		panel.add(addButton);
		panel.add(deleteButton);
		panel.add(yesButton);
		panel.add(noButton);

		String[] column1 = { "序号", "车辆代号", "车牌号", "服役时间（年）" };
		String[] s1 = { "", "", "", "" };
		String row1[][] = { s1 };
		Table = new JTable(row1, column1);
		Table.setFont(font2);
		Table.setRowHeight(20);
		jsp = new JScrollPane(Table);
		jsp.setBounds(x - 10, y + 50, 650, 280);
		panel.add(jsp);

		return panel;
	}

	// 期初建账库存界面
	public JPanel a4() {
		int x = 10, y = 0;
		JLabel subLabel;
		JButton addButton;
		JButton deleteButton;
		JButton yesButton;
		JButton noButton;

		JScrollPane jsp;
		JTable Table;

		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setSize(650, 440);

		subLabel = new JLabel("库存信息列表");
		subLabel.setFont(font1);
		subLabel.setBounds(x, y, 150, 40);

		addButton = new JButton("添加");
		addButton.setFont(font2);
		addButton.setBounds(x + 390, y, width, height);

		deleteButton = new JButton("删除");
		deleteButton.setFont(font2);
		deleteButton.setBounds(x + 490, y, width, height);

		yesButton = new JButton("提交");
		yesButton.setFont(font2);
		yesButton.setBounds(x + 90, y + 350, width, height);

		noButton = new JButton("取消");
		noButton.setFont(font2);
		noButton.setBounds(x + 440, y + 350, width, height);

		panel.add(subLabel);
		panel.add(addButton);
		panel.add(deleteButton);
		panel.add(yesButton);
		panel.add(noButton);

		String[] column1 = { "入库数量", "出库数量", "金额", "存储位置", "合计库存" };
		String[] s1 = { "", "", "", "", "" };
		String row1[][] = { s1 };
		Table = new JTable(row1, column1);
		Table.setFont(font2);
		Table.setRowHeight(20);
		jsp = new JScrollPane(Table);
		jsp.setBounds(x - 10, y + 50, 650, 280);
		panel.add(jsp);

		return panel;
	}

	// 期初建账账户界面
	public JPanel a5() {
		int x = 10, y = 0;
		JLabel subLabel;
		JButton addButton;
		JButton deleteButton;
		JButton yesButton;
		JButton noButton;

		JScrollPane jsp;
		JTable Table;

		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setSize(650, 440);

		subLabel = new JLabel("账户信息列表");
		subLabel.setFont(font1);
		subLabel.setBounds(x, y, 150, 40);

		addButton = new JButton("添加");
		addButton.setFont(font2);
		addButton.setBounds(x + 390, y, width, height);

		deleteButton = new JButton("删除");
		deleteButton.setFont(font2);
		deleteButton.setBounds(x + 490, y, width, height);

		yesButton = new JButton("提交");
		yesButton.setFont(font2);
		yesButton.setBounds(x + 90, y + 350, width, height);

		noButton = new JButton("取消");
		noButton.setFont(font2);
		noButton.setBounds(x + 440, y + 350, width, height);

		panel.add(subLabel);
		panel.add(addButton);
		panel.add(deleteButton);
		panel.add(yesButton);
		panel.add(noButton);

		String[] column1 = { "序号", "账户名称", "余额" };
		String[] s1 = { "", "", "" };
		String row1[][] = { s1 };
		Table = new JTable(row1, column1);
		Table.setFont(font2);
		Table.setRowHeight(20);
		jsp = new JScrollPane(Table);
		jsp.setBounds(x - 10, y + 50, 650, 280);
		panel.add(jsp);

		return panel;
	}

	/**
	 * 当前期初信息
	 * 
	 * @return
	 */
	// 当前期初机构界面
	public JPanel b1() {
		int x = 10, y = 0;
		JLabel subLabel;

		JScrollPane jsp;
		JTable Table;

		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setSize(650, 440);

		subLabel = new JLabel("机构信息列表");
		subLabel.setFont(font1);
		subLabel.setBounds(x, y, 150, 40);

		panel.add(subLabel);

		String[] column1 = { "序号", "机构名称", "机构编号" };
		String[] s1 = { "", "", "" };
		String row1[][] = { s1 };
		Table = new JTable(row1, column1);
		Table.setFont(font2);
		Table.setRowHeight(20);
		jsp = new JScrollPane(Table);
		jsp.setBounds(x - 10, y + 50, 650, 280);
		panel.add(jsp);

		return panel;
	}

	// 当前期初人员界面
	public JPanel b2() {
		int x = 10, y = 0;
		JLabel subLabel;

		JScrollPane jsp;
		JTable Table;

		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setSize(650, 440);

		subLabel = new JLabel("人员信息列表");
		subLabel.setFont(font1);
		subLabel.setBounds(x, y, 150, 40);

		panel.add(subLabel);

		String[] column1 = { "序号", "姓名", "年龄", "职位", "账号" };
		String[] s1 = { "", "", "", "", "" };
		String row1[][] = { s1 };
		Table = new JTable(row1, column1);
		Table.setFont(font2);
		Table.setRowHeight(20);
		jsp = new JScrollPane(Table);
		jsp.setBounds(x - 10, y + 50, 650, 280);
		panel.add(jsp);

		return panel;
	}

	// 当前期初车辆界面
	public JPanel b3() {
		int x = 10, y = 0;
		JLabel subLabel;

		JScrollPane jsp;
		JTable Table;

		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setSize(650, 440);

		subLabel = new JLabel("车辆信息列表");
		subLabel.setFont(font1);
		subLabel.setBounds(x, y, 150, 40);

		panel.add(subLabel);

		String[] column1 = { "序号", "车辆代号", "车牌号", "服役时间（年）" };
		String[] s1 = { "", "", "", "" };
		String row1[][] = { s1 };
		Table = new JTable(row1, column1);
		Table.setFont(font2);
		Table.setRowHeight(20);
		jsp = new JScrollPane(Table);
		jsp.setBounds(x - 10, y + 50, 650, 280);
		panel.add(jsp);

		return panel;
	}

	// 当前期初库存界面
	public JPanel b4() {
		int x = 10, y = 0;
		JLabel subLabel;

		JScrollPane jsp;
		JTable Table;

		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setSize(650, 440);

		subLabel = new JLabel("库存信息列表");
		subLabel.setFont(font1);
		subLabel.setBounds(x, y, 150, 40);

		panel.add(subLabel);

		String[] column1 = { "入库数量", "出库数量", "金额", "存储位置", "合计库存" };
		String[] s1 = { "", "", "", "", "" };
		String row1[][] = { s1 };
		Table = new JTable(row1, column1);
		Table.setFont(font2);
		Table.setRowHeight(20);
		jsp = new JScrollPane(Table);
		jsp.setBounds(x - 10, y + 50, 650, 280);
		panel.add(jsp);

		return panel;
	}

	// 当前期初账户界面
	public JPanel b5() {
		int x = 10, y = 0;
		JLabel subLabel;

		JScrollPane jsp;
		JTable Table;

		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setSize(650, 440);

		subLabel = new JLabel("账户信息列表");
		subLabel.setFont(font1);
		subLabel.setBounds(x, y, 150, 40);

		panel.add(subLabel);

		String[] column1 = { "序号", "账户名称", "余额" };
		String[] s1 = { "", "", "" };
		String row1[][] = { s1 };
		Table = new JTable(row1, column1);
		Table.setFont(font2);
		Table.setRowHeight(20);
		jsp = new JScrollPane(Table);
		jsp.setBounds(x - 10, y + 50, 650, 280);
		panel.add(jsp);

		return panel;
	}

	/**
	 * 历史期初
	 * 
	 * @return
	 */
	// 历史期初第一个界面：请输入历史年份的界面
	public JPanel history1() {
		int x = 120, y = 150;
		JPanel panel = new JPanel();
		panel.setSize(650, 530);
		panel.setLayout(null);

		JLabel yearLabel = new JLabel("请输入您想查看的年份：");
		yearLabel.setFont(font1);
		yearLabel.setBounds(x, y, 250, 40);

		JTextField yearField = new JTextField();
		yearField.setBounds(x + 220, y, 150, height);

		JButton yesButton = new JButton("确定");
		yesButton.setFont(font2);
		yesButton.setBounds(x + 80, y + 100, width, height);

		JButton noButton = new JButton("取消");
		noButton.setFont(font2);
		noButton.setBounds(x + 380, y + 100, width, height);

		panel.add(yearLabel);
		panel.add(yearField);
		panel.add(yesButton);
		panel.add(noButton);

		yesButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				JPanel p1 = new JPanel();
				p1 = history2();
				p1.setBounds(0, 0, 650, 440);
				panel3.removeAll();
				panel3.add(p1);
				panel3.repaint();
			}
		});

		return panel;
	}

	// 历史期初第二个界面：输入历史年份后的界面
	public JPanel history2() {
		int x = 10, y = 15;
		JPanel panel = new JPanel();
		panel.setSize(650, 530);
		panel.setLayout(null);
		// 顶部
		JLabel t3Label;
		JPanel c1;// 机构
		JPanel c2;// 人员
		JPanel c3;// 车辆
		JPanel c4;// 库存
		JPanel c5;// 账户

		panel = new JPanel(null);

		tab3 = new JTabbedPane(JTabbedPane.TOP);
		c1 = c1();
		c2 = c2();
		c3 = c3();
		c4 = c4();
		c5 = c5();
		tab3.add(a1, "机构");
		tab3.add(a2, "人员");
		tab3.add(a3, "车辆");
		tab3.add(a4, "库存");
		tab3.add(a5, "账户");
		tab3.setBounds(0, 0, 650, 525);
		panel.add(tab3);

		// 底部
		// ………………调用示例如下…………
		/*
		 * c1()是对应于按钮c1（机构）的返回值为panel的方法 c2()是对应于按钮c2（人员）的返回值为panel的方法
		 * c3()是对应于按钮c3（车辆）的返回值为panel的方法 c4()是对应于按钮c4（库存）的返回值为panel的方法
		 * c5()是对应于按钮c5（账户）的返回值为panel的方法
		 */
		return panel;
	}

	// 历史期初机构界面
	public JPanel c1() {
		int x = 10, y = 0;
		JLabel subLabel;

		JScrollPane jsp;
		JTable Table;

		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setSize(650, 440);

		subLabel = new JLabel("机构信息列表");
		subLabel.setFont(font1);
		subLabel.setBounds(x, y, 150, 40);

		panel.add(subLabel);

		String[] column1 = { "序号", "机构名称", "机构编号" };
		String[] s1 = { "", "", "" };
		String row1[][] = { s1 };
		Table = new JTable(row1, column1);
		Table.setFont(font2);
		Table.setRowHeight(20);
		jsp = new JScrollPane(Table);
		jsp.setBounds(x - 10, y + 50, 650, 280);
		panel.add(jsp);

		return panel;
	}

	// 历史期初人员界面
	public JPanel c2() {
		int x = 10, y = 0;
		JLabel subLabel;

		JScrollPane jsp;
		JTable Table;

		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setSize(650, 440);

		subLabel = new JLabel("人员信息列表");
		subLabel.setFont(font1);
		subLabel.setBounds(x, y, 150, 40);

		panel.add(subLabel);

		String[] column1 = { "序号", "姓名", "年龄", "职位", "账号" };
		String[] s1 = { "", "", "", "", "" };
		String row1[][] = { s1 };
		Table = new JTable(row1, column1);
		Table.setFont(font2);
		Table.setRowHeight(20);
		jsp = new JScrollPane(Table);
		jsp.setBounds(x - 10, y + 50, 650, 280);
		panel.add(jsp);

		return panel;
	}

	// 历史期初车辆界面
	public JPanel c3() {
		int x = 10, y = 0;
		JLabel subLabel;

		JScrollPane jsp;
		JTable Table;

		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setSize(650, 440);

		subLabel = new JLabel("车辆信息列表");
		subLabel.setFont(font1);
		subLabel.setBounds(x, y, 150, 40);

		panel.add(subLabel);

		String[] column1 = { "序号", "车辆代号", "车牌号", "服役时间（年）" };
		String[] s1 = { "", "", "", "" };
		String row1[][] = { s1 };
		Table = new JTable(row1, column1);
		Table.setFont(font2);
		Table.setRowHeight(20);
		jsp = new JScrollPane(Table);
		jsp.setBounds(x - 10, y + 50, 650, 280);
		panel.add(jsp);

		return panel;
	}

	// 历史期初库存界面
	public JPanel c4() {
		int x = 10, y = 0;
		JLabel subLabel;

		JScrollPane jsp;
		JTable Table;

		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setSize(650, 440);

		subLabel = new JLabel("库存信息列表");
		subLabel.setFont(font1);
		subLabel.setBounds(x, y, 150, 40);

		panel.add(subLabel);

		String[] column1 = { "入库数量", "出库数量", "金额", "存储位置", "合计库存" };
		String[] s1 = { "", "", "", "", "" };
		String row1[][] = { s1 };
		Table = new JTable(row1, column1);
		Table.setFont(font2);
		Table.setRowHeight(20);
		jsp = new JScrollPane(Table);
		jsp.setBounds(x - 10, y + 50, 650, 280);
		panel.add(jsp);

		return panel;
	}

	// 历史期初账户界面
	public JPanel c5() {
		int x = 10, y = 0;
		JLabel subLabel;

		JScrollPane jsp;
		JTable Table;

		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setSize(650, 440);

		subLabel = new JLabel("账户信息列表");
		subLabel.setFont(font1);
		subLabel.setBounds(x, y, 150, 40);

		panel.add(subLabel);

		String[] column1 = { "序号", "账户名称", "余额" };
		String[] s1 = { "", "", "" };
		String row1[][] = { s1 };
		Table = new JTable(row1, column1);
		Table.setFont(font2);
		Table.setRowHeight(20);
		jsp = new JScrollPane(Table);
		jsp.setBounds(x - 10, y + 50, 650, 280);
		panel.add(jsp);

		return panel;
	}

}
