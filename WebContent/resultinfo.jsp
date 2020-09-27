<%@page import="type.StringHandle"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page language="java" import="java.util.*"%>
<%@ page language="java" import="type.ClassService"%>
<%@ page language="java" import="bean.Reci"%>
<%@ page language="java" import="dao.Dao"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>Document</title>
	<%
	
	
	     Object message = request.getAttribute("message");
	     if(message!=null && !"".equals(message)){
	 
	%>
	     <script type="text/javascript">
	          alert("<%=request.getAttribute("message")%>");
	     </script>
	<%} %>
</head>
<style type="text/css">
	td
	{
		height: 40px;
		border: 1px solid #E0E0E0;
	}
	table tr:nth-child(even)
	{
		background: #F0F0F0;
	}
	table td:nth-child(odd)
	{
		background: #F0F0F0;
		width:20%;

	}
	table td:nth-child(even)
	{
		width:30%;

	}
	 table{
	 	border: 1px solid #F0F0F0;
	 	width:80%;
	 } 
	 #tar
	 {
	 	height:40px;
	 	width:80%;
	 	background:lightblue;
	 	margin:0 auto;
	 }
</style>
<body>

	
	<br>
	<%
		request.setCharacterEncoding("utf-8");
			String searchtable="reci2";
			ClassService service=new ClassService();
			StringHandle sh=new StringHandle();
			//ls=sh.StringListAdd(ls, "</br>", "");
			String pageid=request.getParameter("pageid");
			/* List<List<String>> infos=service.list(searchtable);//ClassService.list:全部数据 */
			System.out.println("pageid is :"+pageid);
			int id = Integer.parseInt(pageid);
			Reci detail = Dao.getDetail(id);
 			
			%>
	<form method="post" action="index.jsp">
		<table border="1" cellspacing="0" align="center" >
			<tr >
				<td colspan="2" style="background:#D0D0D0">
					<span style="font-size:20px;font-weight:bold;">
					热词:<%= detail.getWord() %>
					
					</span>
					
				</td>
				<td style="background:#D0D0D0">
					<span>解释:<%= detail.getJieshi()  %>
				
					</span>
				</td>
				
				
			</tr>
			<tr >
				<td colspan="2" style="background:#D0D0D0">
					
					
				</td>
				<td style="background:#D0D0D0">
					<span>来源:<%= detail.getDizhi()  %>
				
					</span>
				</td>
				
				
			</tr>
			
			
			
		</table>
		
	</form> 
</body>
</html>