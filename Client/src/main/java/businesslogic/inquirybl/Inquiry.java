package businesslogic.inquirybl;

import businesslogic.utilitybl.Helper;
import dataservice.DataFactory;
import dataservice.datafactoryservice.DataFactoryService;
import dataservice.inquirydataservice.InquiryDataService;
import po.LogisticsPO;
import po.OperationLogPO;
import vo.LogisticsVO;
import vo.OperationLogVO;

import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 * Created by Administrator on 2015/11/7 0007.
 *
 * @author myk
 */
public class Inquiry {
    /**
     * The Inquiry.
     */
    private InquiryDataService inquiry;

    /**
     * Instantiates a new Inquiry.
     *
     * @throws RemoteException the remote exception
     */
    public Inquiry() throws RemoteException {
        DataFactoryService dataFactory = DataFactory.getInstance();
        inquiry = dataFactory.getInquiryData();
    }

    /**
     * Check operation log array list.
     *
     * @return the array list
     * @throws RemoteException the remote exception
     */
    public ArrayList<OperationLogVO> checkOperationLog() throws RemoteException {
        ArrayList<OperationLogPO> po = inquiry.checkOperationLog();
        ArrayList<OperationLogVO> vo = new ArrayList<OperationLogVO>();
        for (OperationLogPO temp : po) {
            vo.add(new OperationLogVO(temp.getTime(), temp.getHuman(), temp.getType()));
        }
        return vo;
    }

    /**
     * Check form string.
     *
     * @param type the type
     * @return the string
     * @throws RemoteException the remote exception
     */
    public String checkForm(String type) throws RemoteException {

        inquiry.saveOperationLog(new
                OperationLogPO(Helper.getTime(),Helper.getUserType().toString(),"查看报表"));
        return inquiry.checkForm(type);
    }

    /**
     * Check logistics logistics vo.
     *
     * @param num the num
     * @return the logistics vo
     * @throws RemoteException     the remote exception
     */
    public LogisticsVO checkLogistics(String num) throws RemoteException {
        LogisticsPO po = inquiry.checkLogistics(num);

        return new LogisticsVO(po.getDeliveryNum(), po.getTransportState());
    }
}
