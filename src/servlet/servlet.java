package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.google.gson.Gson;



import bean.Reci;
import dao.Dao;

/**
 * Servlet implementation class servlet
 */
@WebServlet("/servlet")
public class servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       Dao dao=new Dao();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public servlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		req.setCharacterEncoding("utf-8");
		String method = req.getParameter("method");
		//String bl = req.getParameter("bl");
		 if("select".equals(method)) {
			select(req, resp);
		}}
    
    
		 private void select(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		        request.setCharacterEncoding("utf-8");
		        String value = request.getParameter("name2");
		        List<Reci> list2 = dao.select(value);
		        JSONArray total = new JSONArray();
		        if(list2!=null) {
		        	
		        	System.out.println(list2.size());
			        for(int i =0;i<list2.size();i++){
			        	JSONObject name1 = new JSONObject();
					
			    		name1.put("name", list2.get(i).getJieshi());
			    		
			    		name1.put("expl", list2.get(i).getDizhi());
			    		
			    		total.add(name1);
			    	
			        }
			        	
			    		
			    		System.out.println(total);
			    	
			    		System.out.println(total.toString());
			    		response.setContentType("application/json"); 
			    		response.setCharacterEncoding("utf-8");
			    		response.getWriter().write(total.toString());
				}
		        else {
		        	System.out.println(total.toString());
		    		response.setContentType("application/json"); 
		    		response.setCharacterEncoding("utf-8");
		    		response.getWriter().write(total.toString());
		        }
		        
		        }
		        
		    	
		    	
		    	
	    

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
