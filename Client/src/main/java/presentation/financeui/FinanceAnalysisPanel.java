package presentation.financeui;

import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import presentation.commonui.DateChooser;

/**
 * 财务人员查看统计分析界面
 * @author WANXING
 *完成2
 */
public class FinanceAnalysisPanel extends JPanel{
	int width=70,height=30;
	private JTabbedPane tab;
	private JPanel bussingPanel;//经营情况
	private JPanel costPanel;//成本收益
	//经营情况表
	private JLabel t1Label;
	private JLabel startLabel;
	private JLabel endLabel;
	private JTextField startField;
	private JTextField endField;
	private JScrollPane jsp1;
	private JTable bussingTable;
	private JButton gotButton;
	//成本收益表
	private JLabel t2Label;
	private JButton getButton;
	private JScrollPane jsp2;
	private JTable costTable;
	//定义日期选择器
	private DateChooser datechooser1,datechooser2;
	
	Font font1=new Font("楷体", Font.PLAIN, 25);
	Font font2 = new Font("宋体", Font.PLAIN, 15);
	
	public FinanceAnalysisPanel(){
		//初始化各组件
		this.setSize(650, 530);
		this.setLayout(null);
		
		tab=new JTabbedPane(JTabbedPane.TOP);
		//经营情况表
		bussingPanel=new JPanel();
		bussingPanel.setLayout(null);
		t1Label=new JLabel("经营情况表");
		startLabel=new JLabel("起始日期");
		endLabel=new JLabel("结束日期");
		startField=new JTextField();
		endField=new JTextField();
		gotButton=new JButton("导出");
		
		t1Label.setFont(font1);
		t1Label.setBounds(5, 0, 150, 40);
		
		startLabel.setFont(font2);
		startLabel.setBounds(60, 45, width, height);
		
		startField.setBounds(130, 45, 120, height);
		startField.setEditable(false);
		
		datechooser1 = new DateChooser("yyyy-MM-dd",startField);
		datechooser1.setBounds(250, 45, 30, height);
		startField.setText(datechooser1.commit());
		datechooser1.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent me){
				datechooser1.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
		});
		
		endLabel.setFont(font2);
		endLabel.setBounds(310, 45, width, height);
		
		endField.setBounds(380, 45, 120, height);
		endField.setEditable(false);
		
		datechooser2 = new DateChooser("yyyy-MM-dd",endField);
		datechooser2.setBounds(500, 45, 30, height);
		startField.setText(datechooser2.commit());
		datechooser2.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent me){
				datechooser2.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
		});
		
		gotButton.setFont(font2);
		gotButton.setBounds(550, 45, width, height);
		
		bussingPanel.add(t1Label);
		bussingPanel.add(startLabel);
		bussingPanel.add(startField);
		bussingPanel.add(datechooser1);
		bussingPanel.add(endLabel);
		bussingPanel.add(endField);
		bussingPanel.add(datechooser2);
		bussingPanel.add(gotButton);
		
		
		String[] column1 = { "序号","单据类型","详细信息"};
		String[] s1 = {"1","收款单","" };
		String row1[][] = { s1 };
		bussingTable = new JTable(row1, column1);
		bussingTable.setFont(font2);
		bussingTable.setRowHeight(20);
		jsp1 = new JScrollPane(bussingTable);
		jsp1.setBounds(0, 110, 650, 355);
		bussingPanel.add(jsp1);
		
		//成本收益表
		costPanel=new JPanel();
		costPanel.setLayout(null);
		t2Label=new JLabel("截至当前的成本收益表");
		getButton=new JButton("导出");
		
		t2Label.setFont(font1);
		t2Label.setBounds(5, 0, 250, 40);
		
		getButton.setFont(font2);
		getButton.setBounds(500, 0, width, height);
		
		costPanel.add(t2Label);
		costPanel.add(getButton);
		
		String[] column2 = { "总收入","总支出","总利润"};
		String[] t1 = {"10000","1000","9000" };
		String row2[][] = { t1 };
		costTable = new JTable(row2, column2);
		costTable.setFont(font2);
		costTable.setRowHeight(20);
		jsp2 = new JScrollPane(costTable);
		jsp2.setBounds(0, 50, 650, 400);
		costPanel.add(jsp2);
		
		tab.add(bussingPanel,"经营情况表");
		tab.add(costPanel,"成本收益表");
		
		tab.setBounds(0, 0, 650, 530);
		add(tab);
	}
}
