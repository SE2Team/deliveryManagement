package stubs.bl1;


import businesslogicservice.FinanceblService;
import util.ResultMessage;
import vo.AccountVO;
import vo.GatheringVO;
import vo.PaymentVO;

public class FinanceblService_Stub implements FinanceblService {

    public FinanceblService_Stub() {

    }

    public ResultMessage gathering(GatheringVO gatheringVO) {
        // TODO Auto-generated method stub
        return ResultMessage.SUCCESS;
    }

    public ResultMessage payment(PaymentVO paymentVO) {
        // TODO Auto-generated method stub
        return ResultMessage.SUCCESS;
    }

    public ResultMessage generateForm() {
        // TODO Auto-generated method stub// TODO Auto-generated method stub
        return ResultMessage.SUCCESS;
    }

    public ResultMessage generateForm(String startDate, String endDate) {
        return ResultMessage.SUCCESS;
    }

    public ResultMessage initial(String institution) {
        // TODO Auto-generated method stub
        return ResultMessage.SUCCESS;
    }

    public ResultMessage addAccount(AccountVO accountVO) {
        // TODO Auto-generated method stub
        return ResultMessage.SUCCESS;
    }

    public ResultMessage searchAccount() {
        // TODO Auto-generated method stub
        return ResultMessage.SUCCESS;
    }

    public ResultMessage searchAccount(String name) {
        // TODO Auto-generated method stub
        return ResultMessage.SUCCESS;
    }

    public ResultMessage DelAccount(AccountVO accountVO) {
        // TODO Auto-generated method stub
        return ResultMessage.SUCCESS;
    }

    public ResultMessage EditAccount(AccountVO accountVOOld, AccountVO accountVONew) {
        // TODO Auto-generated method stub
        return ResultMessage.SUCCESS;
    }

}
