import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import datamodel.Character;
import util.Util;

@WebServlet("/MyServlet")
public class MyServlet extends HttpServlet {
   private static final long serialVersionUID = 1L;

   public MyServlet() {
      super();
   }

   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      response.setContentType("text/html");

      // #1
    /*Util.createCharacter("Daniel", "1", "Paladin");
      Util.createCharacter("Gorlock", "3", "Barbarian");
      Util.createCharacter("Alucard", "10", "Fighter");
      Util.createCharacter("Bruce", "1", "Cleric");*/
      
      // #2
      retrieveDisplayData(response.getWriter());
   }

   void retrieveDisplayData(PrintWriter out) {
      String title = "Character List";
      String docType = "<!doctype html public \"-//w3c//dtd html 4.0 " + //
            "transitional//en\">\n"; //
      out.println(docType + //
            "<html>\n" + //
            "<head><title>" + title + "</title></head>\n" + //
            "<body bgcolor=\"#f0f0f0\">\n" + //
            "<h1 align=\"center\">" + title + "</h1>\n");
      out.println("<style>\n"
      		+ "table, th, td {\n"
      		+ "  border:1px solid black;\n"
      		+ "}\n"
      		+ "</style>\n"
      		+ "<body>\n"
      		+ "<table style=\"width:100%\">\n"
      		+ "  <tr>\n"
      		+ "    <th>Class</th>\n"
      		+ "    <th>Level</th>\n"
      		+ "    <th>Name</th>\n"
      		+ "  </tr>");
      List<Character> listCharacter = Util.listCharacter();
      for (Character character : listCharacter) {
         System.out.println("[DBG] " + character.getId() + ", " //
               + character.getName() + ", " //
               + character.getLevel()+", "
               + character.getJob());

        /* out.println("<li>" + character.getId() + "| Name: " //
               + character.getName() + " | Level: " //
               + character.getLevel()+" | Class: " 
               + character.getJob()+ "</li>");*/
         
         out.println(//TABLE CREATION
        		 "<tr>\n"
        		 + "    <td>"+character.getJob()+"</td>\n"
        		 + "    <td>"+character.getLevel()+"</td>\n"
        		 + "    <td>"+character.getName()+"</td>\n"
        		 + "  </tr>");    
         }
      out.println("</table>");
      out.println(
    		  "<nav>\n"
      		+ "<a href=\"/techwebproject/createCharacter.html\">Add Character</a> <br>\n"
      		+ "</nav>");
      out.println("</body></html>");
   }

   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      doGet(request, response);
   }
}
