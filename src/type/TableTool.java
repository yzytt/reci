package type;

import java.util.ArrayList;
import java.util.List;


public class TableTool {
	
	public <T> String createTableTr(Class<?> info,List<T> tlist,boolean isCenter)
	{
		StringHandle sh=new StringHandle();
		List<List<String>> result=sh.TListToStringListList(tlist);
		int g_size=result.size();
		List<List<String>> another=new ArrayList<List<String>>();
		for(int i=0;i<g_size;i++)
		{
			List<String> de=sh.StringListAdd(result.get(i), "<td>", "</td>");
			if(isCenter)
				de.add(0, "<tr align=\"center\">");
			else de.add(0, "<tr>");
			de.add("</tr>");
			another.add(de);
		}
		return sh.StringListIntoString(sh.StringListListIntoStringList(another, "\r\n"),"\r\n");
	}
	public <T> String createTableTr(List<String> operate,List<T> tlist,Class<?> info,boolean isCenter)
	{
		StringHandle sh=new StringHandle();
		List<List<String>> result=sh.StringListListAddToStringListList(sh.TListToStringListList(tlist),operate);
		int g_size=result.size();
		List<List<String>> another=new ArrayList<List<String>>();
		for(int i=0;i<g_size;i++)
		{
			List<String> de=sh.StringListAdd(result.get(i), "<td>", "</td>");
			if(isCenter)
				de.add(0, "<tr align=\"center\">");
			else de.add(0, "<tr>");
			de.add("</tr>");
			another.add(de);
		}
		return sh.StringListIntoString(sh.StringListListIntoStringList(another, "\r\n"),"\r\n");
	}
	
	public List<String> createUpdataAndDelete(List<String> point,String classname,String updateweb,String deletejumpweb)
	{
		List<String> ls=new ArrayList<String>();
		for(int i=0;i<point.size();i++)
		{
			String temp=new String("<a href=\"ClassServlet?method=updateinfo&xh="+point.get(i)+"&Class="+classname+"&ym="+updateweb+"\">�޸�</a> &nbsp<a href=\"ClassServlet?method=deleteinfo&xh="+point.get(i)+"&Class="+classname+"&ym="+deletejumpweb+"\">ɾ��</a>");
			ls.add(temp);
		}
		return ls;
		
	}
	
}
