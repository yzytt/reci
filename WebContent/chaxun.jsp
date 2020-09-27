<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="type.StringHandle"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="type.ClassService"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>关键字搜索</title>
    <link rel="stylesheet" href="http://apps.bdimg.com/libs/jqueryui/1.10.4/css/jquery-ui.min.css">
    <script src="http://apps.bdimg.com/libs/jquery/1.10.2/jquery.min.js"></script>
    <script src="http://apps.bdimg.com/libs/jqueryui/1.10.4/jquery-ui.min.js"></script>
</head>
<style>
	.container{
			width: 500px;
			height: 50px;
			margin: 7% auto;

		}
		.parent {
			width: 100%;
			height: 42px;
			top: 4px;
			position: relative;
		}
			
		.parent>input:first-of-type {
			/*输入框高度设置为40px, border占据2px，总高度为42px*/
			width: 380px;
			height: 40px; 
			border: 1px solid #ccc;
			font-size: 16px;
			outline: none;
		}
			
		.parent>input:first-of-type:focus {
			border: 1px solid lightblue;
			padding-left: 10px;
		}
			
		.parent>input:last-of-type {
			/*button按钮border并不占据外围大小，设置高度42px*/
			width: 100px;
			height: 44px; 
			position: absolute;
			background:lightblue;
			border: 1px solid lightblue;
			color: #fff;
			font-size: 16px;
			outline: none;

		}
</style>
<body>
	<!--   <a href="graph1.jsp">图形界面展示</a>   -->
	<div style="text-align:center;margin-top:7%;">
		<span style="font-size:30px;color:lightblue;font-weight:bold;" >关键字搜素</span>
	</div>
	
	<div class="container">
	    <form action="searchResult.jsp" method="post" class="parent">
	        <input type="text" id="infoall" name="searchinfo">
	        <input type="submit" value="搜索">
	    </form>
	</div>
	<%
	ClassService service = new ClassService();
	List<String> list = service.getTableColumn("reci2");//得到表中中所有的字段名
	
	List<String> singleinfo = new ArrayList<String>();
	int num = 0;
	num = list.size();
	StringHandle sh=new StringHandle();
	
	singleinfo.addAll(service.getInfoAllList("reci2", list.get(1)));//单列表信息获取
	
	singleinfo = sh.StringListRemoveRepeat(singleinfo);//将字符串中重复的元素移除
	String singleresult=("\""+sh.StringListIntoString(singleinfo, "\",\"")+"\"");
	//将字符串容器组合成一个字符串,并且字符串和字符串之间添加decorate
	%>
	
	<script type="text/javascript">
    $(function() {
    	
        var availableTags = [<%=singleresult.replaceAll("\\s", "") %>];//遍历数据库，将数据库所有内容放入容器，以提供搜索提示
        $("#infoall" ).autocomplete({
            source:
                    function(request, response) {
                        var results = $.ui.autocomplete.filter(availableTags, request.term);
                        response(results.slice(0, 100));//只显示自动提示的前十条数据
                    },
            messages: {
                noResults: '',
                results: function() {}
            },
        });
 
    });
</script>
</body>

</html>