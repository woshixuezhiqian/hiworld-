package tk.wkkany.dao;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import tk.wkkany.domain.user;
import tk.wkkany.util.JDBCutils;

public class userdao {
    private JdbcTemplate template=new JdbcTemplate(JDBCutils.getdatasourse());
    public user login(user loginuser){
        String sql="select *from user where username=? and password=?";
        user user = template.queryForObject(sql,
                new BeanPropertyRowMapper<user>(user.class),
                loginuser.getName(), loginuser.getPassword()
        );
        return user;
    }


}
