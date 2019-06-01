package tk.wkkany.web.servlet;

import tk.wkkany.domain.user;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet( "/successServlet")
public class successServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取request中共享数据
        user user = (user) request.getAttribute("user");
        if (user!=null){
            //设置编码
            response.setContentType("text/html;charset=utf-8");
            //输出
            response.getWriter().write("成功登陆！"+user.getName()+"欢迎您");
        }




    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
