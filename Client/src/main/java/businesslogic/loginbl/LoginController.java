package businesslogic.loginbl;

import businesslogicservice.LoginblService;
import po.UserPO;
import vo.UserVO;

import java.rmi.RemoteException;

/**
 * Created by Administrator on 2015/11/1 0001.
 */
public class LoginController implements LoginblService {

    private Login login;

    public UserPO login(UserVO userVO) throws RemoteException {
        login = new Login();
        return login.login(userVO);
    }
}
