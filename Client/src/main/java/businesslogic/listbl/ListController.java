package businesslogic.listbl;

import businesslogicservice.ListblService;
import util.ExistException;
import vo.*;

import java.rmi.RemoteException;
import java.util.Iterator;

/**
 * Created by Administrator on 2015/10/30 0030.
 *
 * @author myk
 */
public class ListController implements ListblService {
    private List list;

    public ListController() throws RemoteException {
        list = new List();
    }


    public boolean order(OrderVO orderVO) throws RemoteException {
        if(!orderVO.getIsCheck())
            return false;
        return new Order().save(orderVO);
    }

    public boolean addresseeInfomation(AddresseeInformationVO addresseeInformationVO) throws RemoteException {
        if(!addresseeInformationVO.getIsCheck())
            return false;
        return new AddresseeInfomation().save(addresseeInformationVO);
    }

    public boolean loadingInfo(LoadingVO loadingVO) throws RemoteException {
        if(!loadingVO.getIsCheck())
            return false;
        return new LoadingInfo().save(loadingVO);
    }

    public boolean receiveInfo(ReceiveVO receiveVO) throws RemoteException {
        if(!receiveVO.getIsCheck())
            return false;
        return new ReceiveInfo().save(receiveVO);
    }

    public boolean distributeInfo(DistributeVO distributeVO) throws RemoteException {
        if(!distributeVO.getIsCheck())
            return false;
        return new DistributeInfo().save(distributeVO);
    }

    public boolean receipt(ReceiptVO receiptVO) throws RemoteException{
        if(!receiptVO.getIsCheck())
            return false;
        return new Receipt().save(receiptVO);
    }

    public boolean transInfo(TransferVO transferVO) throws RemoteException {
        if(!transferVO.getIsCheck())
            return false;
        return new TransInfo().save(transferVO);
    }

    public boolean transArrive(TransferReceiveVO transferReceiveVO) throws RemoteException {
        if(!transferReceiveVO.getIsCheck())
            return false;
        return new TransArrive().save(transferReceiveVO);
    }

    public boolean stockOut(StockOutVO stockOutVO) throws RemoteException {
        if(!stockOutVO.getIsCheck())
            return false;
        return new StockOut().save(stockOutVO);
    }

    public boolean stockIn(StockInVO stockInVO) throws RemoteException {
        if(!stockInVO.getIsCheck())
            return false;
        return new StockIn().save(stockInVO);
    }

    public boolean gathering(GatheringVO gatheringVO) throws  RemoteException {
        if(!gatheringVO.getIsCheck())
            return false;
        return new Gathering().save(gatheringVO);
    }

    public boolean payment(PaymentVO paymentVO) throws RemoteException{
        if(!paymentVO.getIsCheck())
            return false;
        return new Payment().save(paymentVO);
    }


    public Iterator<ListVO> push() throws RemoteException {

        return new List().push();
    }

    /**
     * 审批一份订单后，通过ischeck来决定是否保存
     * @param vo 要保存的单据
     * @return
     * @throws ExistException
     * @throws RemoteException
     */
    public boolean save(ListVO vo) throws ExistException, RemoteException {
        list.save(vo);
        return true;
    }

    public Iterator<ListVO> getRecent(String date) throws RemoteException {
        return list.getRecent(date);
    }
}
