package Com.SERVELET;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet; 
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/add_user")
public class RegisterServlet extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	try {
		String name = req.getParameter("name");
        String qua= req.getParameter("qua");
        string email req.getParameter("email");
        string ps = req.getParameter("ps");
       
        UserDAO dao = new UserDAO (DBConnect.getConn());
		
        User u= new User(name, email, ps,qua);
		boolean f= dao.register(u);
		HttpSession session = req.getSession();
		if (f) { 
			session.setAttribute("succMsg", "Registration Sucessfully"); 
			resp.sendRedirect("register.jsp");
		} else {
		session.setAttribute("succMsg", "Something wrong on server"); 
		resp.sendRedirect("register.jsp");
	}

}catch (exception e) {
	e.printStackTrace();
}
