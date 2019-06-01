package tk.wkkany.test;

import tk.wkkany.dao.userdao;
import tk.wkkany.domain.user;

public class userdaotest {
    public static void main(String[] args) {
            user u=new user();
            u.setName("kobe");
            u.setPassword("123");
            userdao dao=new userdao();
            user u1=dao.login(u);
        System.out.println(u1);
    }
}
