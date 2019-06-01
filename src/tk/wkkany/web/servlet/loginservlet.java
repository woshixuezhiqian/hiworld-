package tk.wkkany.web.servlet;

import org.apache.commons.beanutils.BeanUtils;
import tk.wkkany.dao.userdao;
import tk.wkkany.domain.user;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@WebServlet("/loginservlet")
public class loginservlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    //1:设置编码
      req.setCharacterEncoding("utf-8");
        //2:设置请求参数
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        //3:封装对象
        user u=new user();
        u.setName(username);
        u.setPassword(password);
      /*  Map<String, String[]> map = req.getParameterMap();
        user u=new user();
        try {
            BeanUtils.populate(u,map);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }*/
        userdao dao=new userdao();
        user user =dao.login(u);
        if (user==null){
            //失败
            req.getRequestDispatcher("/failServlet").forward(req,resp);
        }else {
            //成功
            //存储数据
            req.setAttribute("uesr",user);
            //转发
            req.getRequestDispatcher("/successServlet").forward(req,resp);

        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req,resp);
    }
}
