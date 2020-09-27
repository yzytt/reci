package type;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/ClassServlet")
public class ClassServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	ClassService service = new ClassService();
	
	/**
	 * 方法选择
	 */
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		String method = req.getParameter("method");
		
		if ("checkcode".equals(method)) {
			checkcode(req, resp);
		} else if("login".equals(method))
		{
			login(req,resp);
		} else if("checkname".equals(method))
		{
			checkname(req,resp);
		} else if("checkcoderight".equals(method))
		{
			checkcoderight(req,resp);
		}else if("checknameregister".equals(method))
		{
			checknameregister(req,resp);
		}else if("register".equals(method))
		{
			register(req,resp);
		}else if("addinfo".equals(method))
		{
			addinfo(req,resp);
		}else if("updateinfo".equals(method))
		{
			updateinfo(req,resp);
		}else if("deleteinfo".equals(method))
		{
			deleteinfo(req,resp);
		}else if("updatehandle".equals(method))
		{
			updatehandle(req,resp);
		}
	}

	private void checkcode(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		req.setCharacterEncoding("utf-8");
		//获取数据
		CheckCode cc=new CheckCode();
		Map<String,Object> yzm=cc.generateCodeAndPic();
		req.getSession().setAttribute("checkcode",((StringBuffer)yzm.get("code")).toString());
		ImageIO.write((BufferedImage)yzm.get("codePic"), "jpg", resp.getOutputStream());
		//System.out.println(service.getTableColumn("student"));
		
	}
	private void addinfo(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		req.setCharacterEncoding("utf-8");
		//获取数据
		EntityToString ets=new EntityToString();
		Class<?> clazz=null;
		try {
			clazz=Class.forName(req.getParameter("Class"));
		} catch (ClassNotFoundException e1) {
			// TODO 自动生成的 catch 块
			e1.printStackTrace();
		}
		String nameTemp=new String(clazz.getName());
		List<String> lsname=null;
		lsname = ets.getNameList(clazz);
		StringHandle sh=new StringHandle();
		List<String> spClassname=sh.StringNlistToStringList(nameTemp.split("\\."));
		String pointName=spClassname.get(spClassname.size()-1);
		List<String> info=new ArrayList<String>();
		List<String> infochar2=new ArrayList<String>();
		List<Integer> infoInt=new ArrayList<Integer>();
		
		String start=null;
		List<String> content=null;
		int i1=1;
		if(req.getParameter("xh")!=null)
		{
			start=lsname.remove(0);
			List<Integer> li=new ArrayList<Integer>();
			li.add(0);
			content=sh.StringListListIntoStringList(sh.StringListListInitIndexOfIntegerList(sh.TListToStringListList(service.list(pointName, clazz)),li), "");
			while(sh.StringListIsExContainString(content,(content.size()+i1)+""))
			{
				i1++;
			}
			
			
		}
		
		for(int i=0;i<lsname.size();i++)
		{
			info.add(req.getParameter(lsname.get(i)));
			infochar2.add("char");
			infoInt.add(64);
		}
		if(start!=null)
		{
			lsname.add(0,start);
			infochar2.add(0,"char");
			infoInt.add(0,64);
			info.add(0,(content.size()+i1)+"");
		}
				
		
		if(!service.isExistTable(pointName))
		{
			service.createTable(pointName, sh.StringListToStringNlist(lsname), sh.StringListToStringNlist(infochar2),infoInt.toArray(new Integer[infoInt.size()]) );
		}
		
		
		boolean g_thought=false;
		for(int j=0;j<info.size();j++)
		{
			if(!(info.get(j)==null||info.get(j).equals("")))
			{
				g_thought=true;
				break;
			}
		}
		if(!g_thought)
			info.set(0, "*");
		
		if(service.add(pointName, sh.StringListToStringNlist(lsname), sh.StringListToStringNlist(info)))
		{
			req.setAttribute("message", "添加成功");
		}
		else
		{
			req.setAttribute("message", "添加失败");
		}
		if(req.getParameter("ym")==null||req.getParameter("ym").equals(""))
		{
			List<String> url=sh.StringNlistToStringList(req.getHeader("referer").split("/"));
			//req.getRequestDispatcher(url.get(url.size()-1)).forward(req,resp);
			resp.sendRedirect(url.get(url.size()-1));
		}
		else
		{
			req.getRequestDispatcher(req.getParameter("ym")).forward(req,resp);
		}
		//resp.getWriter().print("<script type='text/javascript'>history.back()</script>");
		
		
	}
	private void updatehandle(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		req.setCharacterEncoding("utf-8");
		//获取数据
		EntityToString ets=new EntityToString();
		Class<?> clazz=null;
		try {
			clazz=Class.forName(req.getParameter("Class"));
		} catch (ClassNotFoundException e1) {
			// TODO 自动生成的 catch 块
			e1.printStackTrace();
		}
		String nameTemp=new String(clazz.getName());
		List<String> lsname=null;
		lsname = ets.getNameList(clazz);
		StringHandle sh=new StringHandle();
		List<String> spClassname=sh.StringNlistToStringList(nameTemp.split("\\."));
		String pointName=spClassname.get(spClassname.size()-1);
		List<String> info=new ArrayList<String>();
		List<String> infochar2=new ArrayList<String>();
		List<Integer> infoInt=new ArrayList<Integer>();
		
		String start=null;
		//List<String> content=null;
		String xh=null;
		if((xh=req.getParameter("xh"))!=null)
		{
			start=lsname.remove(0);
			List<Integer> li=new ArrayList<Integer>();
			li.add(0);
			//content=sh.StringListListIntoStringList(sh.StringListListInitIndexOfIntegerList(sh.TListToStringListList(service.list(pointName, clazz)),li), "");

		}
		
		for(int i=0;i<lsname.size();i++)
		{
			info.add(req.getParameter(lsname.get(i)));
			infochar2.add("char");
			infoInt.add(64);
		}
		if(start!=null)
		{
			lsname.add(0,start);
			infochar2.add(0,"char");
			infoInt.add(0,64);
			info.add(0,xh);
		}
				
		
		if(!service.isExistTable(pointName))
		{
			service.createTable(pointName, sh.StringListToStringNlist(lsname), sh.StringListToStringNlist(infochar2),infoInt.toArray(new Integer[infoInt.size()]) );
		}
		
		
		if(service.update(pointName, sh.StringListToStringNlist(lsname), sh.StringListToStringNlist(info),lsname.get(0),xh))
		{
			req.setAttribute("message", "修改成功");
		}
		else
		{
			req.setAttribute("message", "修改失败");
		}
		
		if(req.getParameter("ym")==null||req.getParameter("ym").equals(""))
		{
			List<String> url=sh.StringNlistToStringList(req.getHeader("referer").split("/"));
			//req.getRequestDispatcher(url.get(url.size()-1)).forward(req,resp);
			resp.sendRedirect(url.get(url.size()-1));
		}
		else
		{
			req.getRequestDispatcher(req.getParameter("ym")).forward(req,resp);
		}
		//resp.getWriter().print("<script type='text/javascript'>history.back()</script>");
		
		
	}
	
	
	private void deleteinfo(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		req.setCharacterEncoding("utf-8");
		//获取数据
		EntityToString ets=new EntityToString();
		Class<?> clazz=null;
		try {
			clazz=Class.forName(req.getParameter("Class"));
		} catch (ClassNotFoundException e1) {
			// TODO 自动生成的 catch 块
			e1.printStackTrace();
		}
		String nameTemp=new String(clazz.getName());
		List<String> lsname=null;
		lsname = ets.getNameList(clazz);
		StringHandle sh=new StringHandle();
		List<String> spClassname=sh.StringNlistToStringList(nameTemp.split("\\."));
		String pointName=spClassname.get(spClassname.size()-1);
		

		String xh=req.getParameter("xh");

		if(service.del(pointName, lsname.get(0), xh))
		{
			req.setAttribute("message", "删除成功");
		}
		else
		{
			req.setAttribute("message", "删除失败");
		}
		if(req.getParameter("ym")==null||req.getParameter("ym").equals(""))
		{
			List<String> url=sh.StringNlistToStringList(req.getHeader("referer").split("/"));
			//req.getRequestDispatcher(url.get(url.size()-1)).forward(req,resp);
			resp.sendRedirect(url.get(url.size()-1));
		}
		else
		{
			req.getRequestDispatcher(req.getParameter("ym")).forward(req,resp);
		}
		//resp.getWriter().print("<script type='text/javascript'>history.back()</script>");
	}
	
	
	private void updateinfo(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		req.setCharacterEncoding("utf-8");
		//获取数据
		EntityToString ets=new EntityToString();
		Class<?> clazz=null;
		try {
			clazz=Class.forName(req.getParameter("Class"));
		} catch (ClassNotFoundException e1) {
			// TODO 自动生成的 catch 块
			e1.printStackTrace();
		}
		String nameTemp=new String(clazz.getName());
		List<String> lsname=null;
		lsname = ets.getNameList(clazz);
		StringHandle sh=new StringHandle();
		List<String> spClassname=sh.StringNlistToStringList(nameTemp.split("\\."));
		String pointName=spClassname.get(spClassname.size()-1);
		

		String xh=req.getParameter("xh");
		
		req.getSession().setAttribute("updateinfo", service.searchBy(pointName, sh.StringListToStringNlist(lsname), new String[] {xh}, clazz).get(0));
		if(req.getParameter("ym")==null||req.getParameter("ym").equals(""))
		{
			List<String> url=sh.StringNlistToStringList(req.getHeader("referer").split("/"));
			//req.getRequestDispatcher(url.get(url.size()-1)).forward(req,resp);
			resp.sendRedirect(url.get(url.size()-1));
		}
		else
		{
			req.getRequestDispatcher(req.getParameter("ym")).forward(req,resp);
		}
		//resp.getWriter().print("<script type='text/javascript'>history.back()</script>");
	}
	
	
	
	
	
	private void login(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		req.setCharacterEncoding("utf-8");
		//获取数据
		List<User> userList=getUserList();
		User currentUser=null;
		String username=req.getParameter("username");
		String password=req.getParameter("password");
		
		String checkcode=req.getParameter("code");
		if(!checkcode.toLowerCase().equals(((String)req.getSession().getAttribute("checkcode")).toLowerCase()))
		{
			req.setAttribute("message", "验证码错误,请确认验证码是否正确");
			req.getRequestDispatcher("login.jsp").forward(req,resp);
			return;
		}
		
		req.setAttribute("handusername", username);
		//req.setAttribute("handpassword", password);
		for(int i=0;i<userList.size();i++)
		{
			if(userList.get(i).getUsername().equals(username))
			{
				if(password.equals(userList.get(i).getPassword()))
				{
					//权限模块
					@SuppressWarnings("unchecked")
					Map<String,Object> ma=(Map<String, Object>) service.getInfoMapList("userflag", "username", "flag", new String().getClass());
					req.getSession().setAttribute("flag", (Integer)ma.get(username));
					
					currentUser=userList.get(i);
					req.getSession().setAttribute("userinfo", currentUser);
					req.setAttribute("webpage", "main.jsp");
					req.setAttribute("message", "登录成功");
					
					//登录成功之后所要的操作
					req.getRequestDispatcher("menu.jsp").forward(req,resp);
					return;
				}
				
			}
			
		}
		
		req.setAttribute("message", "用户名密码错误,请确认密码是否正确");
		req.getRequestDispatcher("login.jsp").forward(req,resp);
	}
	private void checkname(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		req.setCharacterEncoding("utf-8");
		//获取数据
		List<String> nameList=getNameList();
		if(nameList.contains(req.getParameter("username")))
			resp.getWriter().write("false");
		else resp.getWriter().write("true");;
	}
	private void checkcoderight(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		req.setCharacterEncoding("utf-8");
		//获取数据
		String code=(String)req.getSession().getAttribute("checkcode");
		if(req.getParameter("code").toLowerCase().equals(code.toLowerCase()))
		{
			resp.getWriter().write("true");
		}
		else resp.getWriter().write("false");
		
	}
	
	private void checknameregister(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		req.setCharacterEncoding("utf-8");
		//获取数据
		List<String> nameList=getNameList();
		if(nameList.contains(req.getParameter("username")))
			resp.getWriter().write("true");
		else resp.getWriter().write("false");
		
	}
	
	private void register(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		req.setCharacterEncoding("utf-8");
		//获取数据
		String username=req.getParameter("username");
		String password=req.getParameter("password");
		String repassword=req.getParameter("repassword");
		StringHandle it=new StringHandle();
		if(!it.StringIsSuitLength(username, 6, 16))
		{
			req.setAttribute("message", "用户名长度不符合要求");
			req.getRequestDispatcher("register.jsp").forward(req,resp);
			return;
		}
		if(!it.StringIsSuitLength(password, 8, 16))
		{
			req.setAttribute("message", "密码长度不符合要求");
			req.getRequestDispatcher("register.jsp").forward(req,resp);
			return;
		}
		if(password.equals(repassword))
		{
			if(service.add("user", new String[]{"username", "password"},new String[]{username,password}))
			{
				service.add("userflag", new String[]{"username", "flag"},new String[]{username,0+""});
				req.setAttribute("message", "注册成功");
				req.getRequestDispatcher("login.jsp").forward(req,resp);
			}
			else
			{
				req.setAttribute("message", "注册失败，请检查输入的信息是否正确");
				req.getRequestDispatcher("register.jsp").forward(req,resp);
			}
			return;
		}
		else
		{
			req.setAttribute("message", "两次密码不一致，注册失败");
			req.getRequestDispatcher("register.jsp").forward(req,resp);
			return;
		}
		
	}
	//---------------获得名字列表
	private List<String> getNameList()
	{
		List<String> nameList=new ArrayList<String>();
		@SuppressWarnings("unchecked")
		List<User> userList = (List<User>)service.search("user", new String[]{"username"}, new String[]{""}, new User().getClass());
		for(int i=0;i<userList.size();i++)
		{
			nameList.add(userList.get(i).getUsername());
		}
		return nameList;
	}
	
	//获得用户信息列表
	private List<User> getUserList()
	{
		@SuppressWarnings("unchecked")
		List<User> userList = (List<User>)service.search("user", new String[]{"username","password"}, new String[]{"",""}, new User().getClass());
		return userList;
	}

}
