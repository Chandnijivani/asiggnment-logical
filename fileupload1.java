/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 *
 * @author mtech
 */
@WebServlet(urlPatterns = {"/fileupload1"})
public class fileupload1 extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            
            //String path = "/home/mtech/Desktop/xlsfiles/";
         String excelFilePath= "/home/mtech/NetBeansProjects/WebApplication4/src/java/sheet3.xlsx";
          
             String from=request.getParameter("t1");
            String to=request.getParameter("t2");
            
           list reader = new list();
            List<city> listcity = reader.readcityFromExcelFile(excelFilePath);
            
            for(int i=0;i<listcity.size();i++)
            {
            if(listcity.get(i).getFrom().equalsIgnoreCase(from) && listcity.get(i).getTo().equalsIgnoreCase(to))
            
            {
                
                 out.println("company is:"+listcity.get(i).getCompany()+"<br>Fare is: "+listcity.get(i).getFare()+"<br>time is: "+listcity.get(i).getTime());  
                 break;
            }
                
            else
            
            {
        
                   for (int j = 0; j <listcity.size() ; j++)
                  {
                      
                      if(listcity.get(j).getTo().equalsIgnoreCase(listcity.get(j).getFrom()))
                      {
                         
                          if(listcity.get(j).getTo().equalsIgnoreCase(to))
                          {
                             // Double b = listcity.get(j).getFare();
                                    
                              out.println("from:" + listcity.get(j).getFrom() + "to:" + listcity.get(i).getTo() + "company is:" + listcity.get(j).getCompany() + "time is:" + listcity.get(j).getTime() + "fare is:" + listcity.get(j).getFare());
                              
//                                   Double c = listcity.get(j).getFare() ;
//                                   Double y = listcity.get(j).getTime();
//                                   Double z = listcity.get(j).getTime() + y;
//                                    
                              out.println("\nfrom:" + listcity.get(j).getFrom() + "to:" + listcity.get(j).getTo() + "company is:" + listcity.get(j).getCompany() + "time is:" + listcity.get(j).getTime() + "fare is:" + listcity.get(j).getFare() );
                          }
                          
                      }
                  
                  
            }    
            }      
        }
                    
            
            
                    
               
           
            
        }}
    
            
        
    


    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
