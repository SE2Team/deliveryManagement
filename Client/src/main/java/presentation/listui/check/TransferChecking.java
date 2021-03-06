package presentation.listui.check;

import businesslogic.listbl.ListController;
import businesslogicservice.ListblService;
import presentation.listui.TransferPanel;
import vo.TransferVO;

import javax.swing.*;
import java.rmi.RemoteException;

/**
 * Created by MYK on 2015/12/9 0009.
 */
public class TransferChecking extends TransferPanel{
    private TransferChecking() {
        super();
    }

    public TransferChecking(TransferVO vo){
        this();
        sure.setText("通过");
        cancel.setText("否决");
        jcb_way.setSelectedItem(vo.getLoadingWay());
        jtf_loadingDate.setText(vo.getLoadingDate());
        jtf_transferNum.setText(vo.getTransportNum());
        jtf_vehicleNum.setText(vo.getVehicleNum());
        jtf_start.setText(vo.getStart());
        jtf_end.setText(vo.getEnd());
        jtf_containerNum.setText(vo.getContainerNum());
        jtf_monitor.setText(vo.getMonitor());
        jtf_supercargo.setText(vo.getSupercargo());
        jta_orderNums.setText(vo.getOrderNum());
        jtf_money.setText(vo.getMoney());

    }

    @Override
    protected void performSure() {
        TransferVO transfervo = new TransferVO(jcb_way
                .getSelectedItem().toString(), jtf_loadingDate
                .getText(), jtf_transferNum.getText(), jtf_vehicleNum
                .getText(), jtf_start.getText(), jtf_end.getText(),
                jtf_containerNum.getText(), jtf_monitor.getText(),
                jtf_supercargo.getText(), jta_orderNums.getText(),
                jtf_money.getText(),false);
        ListblService bl;
        try {
            bl = new ListController();
            bl.transInfo(transfervo);
        } catch (RemoteException e1) {
            // TODO Auto-generated catch block
            JLabel tip = new JLabel("提示：网络异常");
            tip.setFont(font2);
            JOptionPane.showMessageDialog(null, tip);
        }

        JLabel tip = new JLabel("提示：保存成功");
        tip.setFont(font);
        JOptionPane.showMessageDialog(null, tip);
    }
}
