import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import util.Info;
import util.Util;

@WebServlet("/SimpleInsertHB")
public class CharacterInput extends HttpServlet implements Info {
   private static final long serialVersionUID = 1L;

   public CharacterInput() {
      super();
   }

   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      String name = request.getParameter("name").trim();
      String level = request.getParameter("level").trim();
      String job = request.getParameter("job"); //
      Util.createCharacter(name, level, job);

      response.setContentType("text/html");
      PrintWriter out = response.getWriter();
      String title = "Character list";
      String docType = "<!doctype html public \"-//w3c//dtd html 4.0 transitional//en\">\n"; //
      out.println(docType + //
            "<html>\n" + //
            "<head><title>" + title + "</title></head>\n" + //
            "<body bgcolor=\"#f0f0f0\">\n" + //
            "<h1 align=\"center\">" + title + "</h1>\n");
      out.println("<ul>");
      out.println("<li> Name: " + name);
      out.println("<li> Level: " + level);
      out.println("<li> Class: " + job);
      out.println("</ul>");
      
      out.println(
    		  "<nav>\n"
      		+ "<a href=\"/techwebproject/createCharacter.html\">Add another character</a> <br>\n"
      		+ "</nav>");
      out.println(
    		  "<nav>\n"
      		+ "<a href=\"/techwebproject/MyServlet\">View all characters</a> <br>\n"
      		+ "</nav>");
      out.println("</body></html>");
   }

   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      doGet(request, response);
   }
}
