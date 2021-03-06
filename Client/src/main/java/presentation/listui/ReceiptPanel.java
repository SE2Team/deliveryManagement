/*
 * 营业厅业务员记录收款界面
 */
package presentation.listui;

import businesslogic.listbl.ListController;
import businesslogicservice.ListblService;
import presentation.commonui.DateChooser;
import presentation.commonui.Empty;
import presentation.commonui.isAllEntered;
import util.ExistException;
import vo.ReceiptVO;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.rmi.RemoteException;

public class ReceiptPanel extends JPanel {
	protected int x = 100, y = 70, width = 200, height = 30, addx = 160,
			addy = 80;

	// 定义快递员收款单，收款日期，收款金额，收款快递员，订单号的label
	protected JLabel CourierReceipt, receiptDate, receiptMoney, receiptCourier,
			orderNum;
	// 定义收款日期、金额、快递员的文本框
	protected JTextField jtf_date, jtf_money, jtf_courier;
	// 定义快递单号的文本域
	protected JTextArea jta_ordernum;
	// 定义确定，取消按钮
	protected JButton sure, cancel;
	// 定义字体
	protected Font font = new Font("宋体", Font.PLAIN, 20);
	protected Font font2 = new Font("宋体", Font.PLAIN, 18);
	// 定义日期选择器
	protected DateChooser datechooser;
	// 定义文本框的数组
	protected JTextField[] receiptJtf;

	public ReceiptPanel() {
		this.setLayout(null);

		CourierReceipt = new JLabel("快递员收款单", JLabel.CENTER);
		CourierReceipt.setFont(new Font("楷体", Font.PLAIN, 30));
		CourierReceipt.setBounds(220, 20, 200, 30);

		receiptDate = new JLabel("收款日期", JLabel.CENTER);
		receiptDate.setFont(font);
		receiptDate.setBounds(x, y, width, height);

		jtf_date = new JTextField();
		jtf_date.setFont(font2);
		jtf_date.setEditable(false);
		jtf_date.setBounds(x + addx, y, width - 30, height);

		datechooser = new DateChooser("yyyy-MM-dd", jtf_date);
		datechooser.setBounds(x + addx + width - 30, y, 30, height);
		jtf_date.setText(datechooser.commit());
		datechooser.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent me) {
				datechooser.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
		});

		receiptMoney = new JLabel("收款金额", JLabel.CENTER);
		receiptMoney.setFont(font);
		receiptMoney.setBounds(x, y + addy, width, height);

		jtf_money = new JTextField();
		jtf_money.setFont(font2);
		jtf_money.setBounds(x + addx, y + addy, width, height);

		receiptCourier = new JLabel("收款快递员", JLabel.CENTER);
		receiptCourier.setFont(font);
		receiptCourier.setBounds(x, y + 2 * addy, width, height);

		jtf_courier = new JTextField();
		jtf_courier.setFont(font2);
		jtf_courier.setBounds(x + addx, y + 2 * addy, width, height);

		orderNum = new JLabel("订单号", JLabel.CENTER);
		orderNum.setFont(font);
		orderNum.setBounds(x, y + 3 * addy, width, height);

		jta_ordernum = new JTextArea();
		jta_ordernum.setFont(font2);
		JScrollPane jsp = new JScrollPane(jta_ordernum);
		jsp.setBounds(x + addx, y + 3 * addy - 30, width, 4 * height);

		sure = new JButton("确定");
		sure.setFont(font);
		sure.setBounds(x + 80, 430, 80, height);
		sure.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				performSure();
			}

		});

		receiptJtf = new JTextField[] { jtf_money, jtf_courier };

		cancel = new JButton("取消");
		cancel.setFont(font);
		cancel.setBounds(x + addx + 80, 430, 80, height);
		cancel.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				Empty emptyLoading = new Empty(receiptJtf);
				jta_ordernum.setText("");
			}
		});

		this.add(CourierReceipt);
		this.add(receiptDate);
		this.add(jtf_date);
		this.add(datechooser);
		this.add(receiptMoney);
		this.add(jtf_money);
		this.add(receiptCourier);
		this.add(jtf_courier);
		this.add(orderNum);
		this.add(jsp);
		this.add(sure);
		this.add(cancel);
	}

	protected void performSure(){
		if(isAllEntered.isEntered(receiptJtf)){
			ReceiptVO receipt_vo = new ReceiptVO(jtf_date.getText(),
					jtf_money.getText(), jtf_courier.getText(),
					jta_ordernum.getText(), false);
			try {
				ListblService bl = new ListController();
				try {
					bl.save(receipt_vo);
				} catch (ExistException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				JLabel tip = new JLabel("提示：网络异常");
				tip.setFont(font2);
				JOptionPane.showMessageDialog(null, tip);
			}

			JLabel tip = new JLabel("提示：保存成功");
			tip.setFont(font2);
			JOptionPane.showMessageDialog(null, tip);
		}else{
			JLabel tip = new JLabel("提示：仍有信息未输入");
			tip.setFont(font2);
			JOptionPane.showMessageDialog(null, tip);
		}
		
	}

}
