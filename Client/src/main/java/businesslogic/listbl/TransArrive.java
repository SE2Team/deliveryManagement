package businesslogic.listbl;

import businesslogic.utilitybl.Helper;
import po.OperationLogPO;
import po.PO2VO;
import po.TransferReceivePO;
import vo.ListVO;
import vo.TransferReceiveVO;
import vo.VO2PO;

import java.rmi.RemoteException;

/**
 * Created by Administrator on 2015/11/16 0016.
 *
 * @author myk
 */
public class TransArrive extends List {
    /**
     * Instantiates a new Trans arrive.
     *
     * @throws RemoteException the remote exception
     */
    public TransArrive() throws RemoteException {
    }

    public boolean save2File(ListVO listVO) throws RemoteException {
        TransferReceiveVO vo = (TransferReceiveVO) listVO;
        TransferReceivePO po = VO2PO.convert(vo);
        inquiryDataService.saveOperationLog(new OperationLogPO(Helper.getTime(),Helper.getUserType().toString(),
                "保存中转到达单"));
        return listDataService.save(po);
    }

    public boolean save(TransferReceiveVO vo) throws RemoteException {
        TransferReceivePO po = null;
        po = VO2PO.convert(vo);
        inquiryDataService.saveOperationLog(new OperationLogPO(Helper.getTime(), Helper.getUserType().toString(),
                "新建中转到达单"));
        return listDataService.saveAsList(po);//保存为待审批
    }

    public boolean afterCheck(TransferReceiveVO vo) throws RemoteException {
        return listDataService.deleteList(VO2PO.convert(vo));
    }

    public TransferReceiveVO getTransferArrive(String num) throws RemoteException {
        return PO2VO.convert(listDataService.geTransferReceive(num));
    }
}
