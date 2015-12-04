package dataservice.userdataservice;

import po.UserPO;
import util.ResultMessage;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface UserDataService extends Remote{
    public UserPO login(String id,String password) throws RemoteException;

    public ResultMessage addUser(UserPO po) throws RemoteException;

    public ResultMessage deleteUser(UserPO po) throws RemoteException;

    public ResultMessage editUser(UserPO oldPO,UserPO newPO) throws RemoteException;

    public UserPO find(String id,String password) throws RemoteException;
}
