package stubs.data1;

import dataservice.userdataservice.UserDataService;
import po.UserPO;

public class UserDataService_Stub implements UserDataService {

    public UserDataService_Stub() {

    }

    public UserPO login(String loginInfo) {
        System.out.println("Success");
        UserPO po = new UserPO();
        return po;
    }

    public void addUser(UserPO po) {
        System.out.println("Success");
    }

    public void deleteUser(UserPO po) {
        System.out.println("Success");
    }

    public void editUser(UserPO po) {
        System.out.println("Success");
    }

    public UserPO find(String userinfo) {
        System.out.println("Success");
        UserPO po = new UserPO();
        return po;
    }
}
