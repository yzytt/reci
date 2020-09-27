package type;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringHandle {

	
	//����һ�������ַ��������ַ������ε��ַ���
	public String StringAdd(String info,String left,String right)
	{
		return left+info+right;
	}
	
	//�����ַ��������ַ��������ַ�������
	public List<String> StringListAdd(List<String> infoList,String left,String right)
	{
		int num=infoList.size();
		List<String> ls=new ArrayList<String>();
		for(int i=0;i<num;i++)
		{
			ls.add(left+infoList.get(i)+right);
		}
		return ls;
	}
	
	//将字符串容器组合成一个字符串,并且字符串和字符串之间添加decorate
	public String StringListIntoString(List<String> infoList,String decorate)
	{
		String result=new String();
		int num=infoList.size();
		for(int i=1;i<num;i++)
		{
			result+=decorate+infoList.get(i);
		}
		if(num>0)
			result=infoList.get(0)+result;
		return result;
	}
	
	//������������ϳ�һ���ַ���,�������ͺ��ַ���֮�����decorate
	public String IntegerListIntoString(List<Integer> infoList,String decorate)
	{
		String result=new String();
		int num=infoList.size();
		for(int i=1;i<num;i++)
		{
			result+=decorate+infoList.get(i);
		}
		if(num>0)
			result=infoList.get(0)+result;
		return result;
	}
	
	//�ж��ַ����ĳ����Ƿ���n��m������
	public boolean StringIsSuitLength(String it,int n,int m)
	{
		if(it.length()>=n&&it.length()<=m)
			return true;
		return false;
	}
	
	//�ж��ַ����Ƿ����������ʽ��ȫƥ��)
	public boolean StringIsSuitExep(String str,String exp)
	{

		boolean isMatch = Pattern.matches(exp, str);
		return isMatch;
	}
	
	//�ж��ַ����Ƿ����������ʽ��ƥ�����ַ���)
	public boolean StringIsSuitSubExep(String str,String exp)
	{
		// ����������ʽ
	    Pattern pattern = Pattern.compile(exp);
	    // ���Դ�Сд��д��
	    // Pattern pat = Pattern.compile(regEx, Pattern.CASE_INSENSITIVE);
	    Matcher matcher = pattern.matcher(str);
	    // �����ַ������Ƿ���ƥ��������ʽ���ַ�/�ַ���
	    boolean rs = matcher.find();
	    return rs;
	}
	//��Object����ת��ΪString����
	public List<String> ObjectListToStringList(List<Object> objList)
	{
		List<String> strList=new ArrayList<String>();
		for(int i=0;i<objList.size();i++)
		{
			strList.add((String)objList.get(i));
		}
		return strList;
	}
	//��Object����ת��ΪString����
	public String[] ObjectListToStringNlist(Object []object)
	{
		List<Object> listTemp = java.util.Arrays.asList(object);
		List<String> list=ObjectListToStringList(listTemp);
		String[] strings = new String[list.size()];
		list.toArray(strings);
		return strings;
	}
	//��String����ת��ΪString����
	public String[] StringListToStringNlist(List<String> list)
	{
		return list.toArray(new String[list.size()]);
	}
	
	//��String����ת��ΪString����
	public List<String> StringNlistToStringList(String []strlist)
	{
		List<String> list = java.util.Arrays.asList(strlist);
		return list;
	}
	
	//�ж�һϵ�е��Կո�ֿ����ַ��������е��ض�λ���Ƿ������Ӧ����Ϣ(ȫһ�³�������),�еĻ����ض�Ӧ����������û�еĻ�����null
	public List<Integer> judgeStringListContainPerfect(List<List<String>> info,int count,String contain)
	{
		List<Integer> numList=new ArrayList<Integer>();
		int g_size=info.size();
		for(int i=0;i<g_size;i++)
		{
			int g_initsize=info.get(i).size();
			if(g_initsize>count)
			{
				return null;
			}
			else
			{
				if(!info.get(i).get(count-1).equals(contain))
				{
					continue;
				}
				else
				{
					numList.add(i);
				}
				
			}
		}
		if(numList.size()==0)
			return null;
		else return numList;
	}
	
	
	//�ж�һϵ�е��Կո�ֿ����ַ��������е��ض�λ���Ƿ������Ӧ����Ϣ(��ȫһ�³�������),�еĻ����ض�Ӧ����������û�еĻ�����null
	public List<Integer> judgeStringListContain(List<List<String>> info,int count,String contain)
	{
		List<Integer> numList=new ArrayList<Integer>();
		int g_size=info.size();
		for(int i=0;i<g_size;i++)
		{
			int g_initsize=info.get(i).size();
			if(g_initsize>count)
			{
				continue;
			}
			else
			{
				if(!info.get(i).get(count-1).equals(contain))
				{
					continue;
				}
				else
				{
					numList.add(i);
				}
				
			}
		}
		if(numList.size()==0)
			return null;
		else return numList;
	}
	
	//以对应正则表达式分隔字符并且将分隔后的字符串储存进字符串容器中
	public List<List<String>> StringSplitByExpToStringList(List<String> strlist,String exp)
	{
		List<List<String>> strresult=new ArrayList<List<String>>();
		int g_size=strlist.size();
		for(int i=0;i<g_size;i++)
		{
			String list=strlist.get(i);
			if(list==null||list.equals(""))
				continue;
			String []strnlist=list.split(exp);
			strresult.add(StringNlistToStringList(strnlist));
		}
		return strresult;
	}
	
	//�Զ�Ӧ������ʽ�ָ��ַ����ҽ��ָ�����ַ����������������
	public <T> List<T> StringSplitByExpToTList(List<String> strlist,String exp,String []namelist,Class<T> clazz)
	{
		List<T> tresult=new ArrayList<T>();
		int g_size=strlist.size();
		for(int i=0;i<g_size;i++)
		{
			String list=strlist.get(i);
			if(list==null||list.equals(""))
				continue;
			String []nlist=list.split(exp);
			if(nlist.length<namelist.length)
			{
				throw new IllegalArgumentException("The Length of namelist is longer than nlist");
			}
			T bean;
			try {
				bean = clazz.newInstance();
				int num=namelist.length;
				for(int j=0;j<num;j++)
				{
					Field fs=getDeclaredField(bean, namelist[j]);
					if(fs==null){
						throw new IllegalArgumentException("Could not find field["+ 
								namelist[j]+"] on target ["+bean+"]");
					}
					makeAccessiable(fs);
				    try{
				        fs.set(bean, (Object)nlist[j]);
				    }
				    catch(IllegalAccessException e){
				        System.out.println("�������׳����쳣");
				    }
					
				}
				tresult.add(bean);
			} catch (InstantiationException | IllegalAccessException e1) {
				// TODO �Զ����ɵ� catch ��
				e1.printStackTrace();
			}
			
		}
		return tresult;
	}
	
	//�Զ�Ӧ������ʽ�ָ��ַ����ҽ��ָ�����ַ����������������(�Զ���)
	public <T> List<T> StringSplitByExpToTList(List<String> strlist,String exp,Class<T> clazz)
	{
		List<T> tresult=new ArrayList<T>();
		int g_size=strlist.size();
		for(int i=0;i<g_size;i++)
		{
			String list=strlist.get(i);
			if(list==null||list.equals(""))
				continue;
			String []nlist=list.split(exp);

			Field[ ] fields = clazz.getDeclaredFields( );

			T bean;
			try {
				bean = clazz.newInstance();
				// ѭ�������ֶΣ���ȡ�ֶ���Ӧ������ֵ
				int j=0;
				for ( Field field : fields )
				{
					// ���費Ϊ�ա����ÿɼ��ԣ�Ȼ�󷵻�
					field.setAccessible( true );
					try
					{
						Field fs=getDeclaredField(bean, field.getName( ));
						if(fs==null){
							throw new IllegalArgumentException("Could not find field["+ 
									field.getName( )+"] on target ["+bean+"]");
						}
						makeAccessiable(fs);
						try{
							fs.set(bean, (Object)nlist[j]);
						}
						catch(IllegalAccessException e){
							System.out.println("�������׳����쳣");
						}
						// �����ֶοɼ����Ϳ�����get������ȡ����ֵ��
						//result += field.get( o ) +" ";
						++j;
					}
					catch ( Exception e )
					{
						// System.out.println("error--------"+methodName+".Reason is:"+e.getMessage());
					}
				}



				tresult.add(bean);
			} catch (InstantiationException | IllegalAccessException e1) {
				// TODO �Զ����ɵ� catch ��
				e1.printStackTrace();
			}

		}
		return tresult;
	}
	
	//���ַ���������������ϳ�һ���ַ�������,�����ַ������ַ���֮�����decorate
	public List<String> StringListListIntoStringList(List<List<String>> infoList,String decorate)
	{
		List<String> result=new ArrayList<String>();
		int num=infoList.size();
		for(int i=0;i<num;i++)
		{
			int initnum=infoList.get(i).size();
			String resultTemp=new String();
			for(int j=1;j<initnum;j++)
			{
				resultTemp+=decorate+infoList.get(i).get(j);
			}
			if(initnum>0)
				resultTemp=infoList.get(i).get(0)+resultTemp;
			result.add(resultTemp);
		}
		return result;
	}
	//ɾ��string�����з���������ʽ��Ԫ��
	public List<String> deleteStringListIsSuitExp(List<String> strlist,String exp)
	{
		Iterator<String> it = strlist.iterator();
		while(it.hasNext()){
			String x = it.next();
			if(StringIsSuitExep(x, exp)){
				it.remove();
			}
		}
		return strlist;
	}
	//ɾ��string�����������з���������ʽ��Ԫ��
	public List<List<String>> deleteStringListListIsSuitExp(List<List<String>> strlist,String exp)
	{
		int g_size=strlist.size();
		for(int i=0;i<g_size;i++)
		{
			List<String> itTemp=new ArrayList<String>(strlist.get(i));
			Iterator<String> it = itTemp.iterator();
			while(it.hasNext()){
				if(StringIsSuitExep(it.next(), exp)){
					it.remove();
				}
			}
			strlist.set(i, itTemp);
		}
		return strlist;
	}
	
	//���ַ�������������ƴ�ӳ��ַ�������
	public List<String> StringListListAddToStringList(List<List<String>> strllist)
	{
		List<String> strResult=new ArrayList<String>();
		Integer g_size=strllist.size();
		for(int i=0;i<g_size;i++)
		{
			strResult.addAll(strllist.get(i));
		}
		return strResult;
	}
	
	//���ַ���������ֵͳ�Ʋ���¼��Map��
	public Map<String,Integer> StringListToMapValue(List<String> strlist)
	{
		Map<String,Integer> maplist=new HashMap<String,Integer>();
		Integer g_size=strlist.size();
		for(int i=0;i<g_size;i++) {

			Integer g_map=maplist.get(strlist.get(i));
			if(g_map==null)
			{
				maplist.put(strlist.get(i),1);
			}
			else
			{
				maplist.put(strlist.get(i), g_map+1);
			}
		}
		return maplist;
	}
	
	//�������ַ���������Ӧ���ӳ�Map
	public Map<String,String> StringListToMap(List<String> list1,List<String> list2)
	{
		Map<String,String> map=new HashMap<String,String>();
		int g_size=list1.size();
		if(list1.size()!=list2.size())
			return map;
		else
		{
			for(int i=0;i<g_size;i++)
			{
				map.put(list1.get(i), list2.get(i));
			}
		}
		return map;
	}
	
	//���ַ�������������������Ӧ���ӳ�Map
	public Map<String,Integer> StringListAndIntegerListToMap(List<String> list1,List<Integer> list2)
	{
		Map<String,Integer> map=new HashMap<String,Integer>();
		int g_size=list1.size();
		if(list1.size()!=list2.size())
			return map;
		else
		{
			for(int i=0;i<g_size;i++)
			{
				map.put(list1.get(i), list2.get(i));
			}
		}
		return map;
	}
	
	
	
	
	//��ȡ�ַ������������е�ĳһ�г���(perfect��)
	public List<String> StringListListInitSingleList(List<List<String>> strlist,Integer index)
	{
		List<String> strlistTemp=new ArrayList<String>();
		int g_size=strlist.size();
		if(g_size==0)
			return strlistTemp;
		if(index>=strlist.get(0).size())
			return strlistTemp;
		for(int i=0;i<g_size;i++)
		{
			strlistTemp.add(strlist.get(i).get(index));
		}
		return strlistTemp;
	}
	
	
	
	//�ַ����б�ȷ����ĳ���ַ���
	public boolean StringListIsExContainString(List<String> strlist,String it)
	{
		int num=strlist.size();
		for(int i=0;i<num;i++)
		{
			if(strlist.get(i).equals(it))
				return true;
		}
		return false;
	}
	
	//�ַ����������ַ��������н����������Ԫ��ȡ��
	public List<String> StringListSameOutStringList(List<String> strlist1,List<String> strlist2)
	{
		List<String> result=new ArrayList<String>();
		int g_size=strlist1.size();
		int g_size2=strlist2.size();
		if(g_size==0||g_size2==0)
			return result;
		for(int i=0;i<g_size;i++)
		{
			String itTemp=strlist1.get(i);
			if(StringListIsExContainString(strlist2,itTemp))
			{
				result.add(itTemp);
			}
		}
		return result;
	}
	
	//将字符串中重复的元素移除
	public List<String> StringListRemoveRepeat(List<String> infos)
	{
		List<String> result = new ArrayList<String>();
		int g_size=infos.size();
		for(int i=0;i<g_size;i++)
		{
			String temp=infos.get(i);
			if(!StringListContainString(result,temp))
			{
				result.add(temp);
			}
		}
		return result;
	}
	
	//���ַ������ظ���Ԫ���Ƴ�
	public List<String> StringListReplaceAll(List<String> infos,String exp)
	{
		List<String> result=new ArrayList<String>();
		int g_size=infos.size();
		for(int i=0;i<g_size;i++)
		{
			String temp=infos.get(i).replaceAll(exp, "");
			result.add(temp);
		}
		return result;
	}
	
	//�ж��ַ������Ƿ���
	public boolean StringListContainString(List<String> info,String txt)
	{
		int g_size=info.size();
		for(int i=0;i<g_size;i++)
		{
			String txtt=info.get(i);
			if(txtt==txt||txtt!=null&&txtt.equals(txt))
			{
				return true;
			}
		}
		return false;
	}
	
	
	//���ض�Ӧ���ַ��������ж�Ӧ�ַ����е�λ�õ�����
	public List<Integer> StringListInStringListIndexof(List<String> allinfo,List<String> sublist)
	{
		List<Integer> numlist=new ArrayList<Integer>();
		int g_size=allinfo.size();
		int g_size2=sublist.size();
		if(g_size==0||g_size2==0)
			return numlist;
		for(int i=0;i<g_size2;i++)
		{
			numlist.add(allinfo.indexOf(sublist.get(i)));
		}
		return numlist;
	}
	
	//���ַ�������������ת��ΪT����
	public <T> List<T> StringListListToTlist(List<List<String>> strlist,Class<?> clazz)
	{
		List<T> tresult=new ArrayList<T>();
		int g_size=strlist.size();
		Field[ ] fields = clazz.getDeclaredFields( );
		for(int i=0;i<g_size;i++)
		{
			List<String> list=strlist.get(i);
			if(list==null)
				continue;
			String []nlist=StringListToStringNlist(list);

			T bean;
			try {
				bean = (T) clazz.newInstance();
				// ѭ�������ֶΣ���ȡ�ֶ���Ӧ������ֵ
				int j=0;
				for ( Field field : fields )
				{
					// ���費Ϊ�ա����ÿɼ��ԣ�Ȼ�󷵻�
					field.setAccessible( true );
					try
					{
						Field fs=getDeclaredField(bean, field.getName( ));
						if(fs==null){
							throw new IllegalArgumentException("Could not find field["+ 
									field.getName( )+"] on target ["+bean+"]");
						}
						makeAccessiable(fs);
						try{
							fs.set(bean, (Object)nlist[j]);
						}
						catch(IllegalAccessException e){
							System.out.println("�������׳����쳣");
						}
						// �����ֶοɼ����Ϳ�����get������ȡ����ֵ��
						//result += field.get( o ) +" ";
						++j;
					}
					catch ( Exception e )
					{
						// System.out.println("error--------"+methodName+".Reason is:"+e.getMessage());
					}
				}



				tresult.add(bean);
			} catch (InstantiationException | IllegalAccessException e1) {
				// TODO �Զ����ɵ� catch ��
				e1.printStackTrace();
			}

		}
		return tresult;
	}
	
	//���ַ���������������ȡ����Ӧ����������Ӧλ�õ��ַ���������������
	public List<List<String>> StringListListInitIndexOfIntegerList(List<List<String>> ls,List<Integer> indexof)
	{
		int g_size=ls.size();
		int g_numsize=indexof.size();
		List<List<String>> result=new ArrayList<List<String>>();
		for(int i=0;i<g_size;i++)
		{
			List<String> temp=new ArrayList<String>();
			for(int j=0;j<g_numsize;j++)
			{
				temp.add(ls.get(i).get(indexof.get(j)));
			}
			result.add(temp);
		}
		return result;
	}
	
	
	//���ַ������������������϶�Ӧ�ַ�������������
	public List<List<String>> StringListListAddToByStringListList(List<List<String>> strlistlist,List<List<String>> strlist)
	{
		int g_size=strlistlist.size();
		List<List<String>> result=new ArrayList<List<String>>();
		for(int i=0;i<g_size;i++)
		{
			List<String> strTemp=new ArrayList<String>(strlistlist.get(i));
			strTemp.addAll(strlist.get(i));
			result.add(strTemp);
		}
		return result;
	}
	
	
	//����Ӧ��T����ת��Ϊ�ַ���������������
	public <T> List<List<String>> TListToStringListList(List<T> tlist)
	{
		List<List<String>> result=new ArrayList<List<String>>();
		int g_size=tlist.size();
		if(g_size==0)
			return result;
		EntityToString ets=new EntityToString();
		for(int i=0;i<g_size;i++)
		{
			result.add(StringNlistToStringList(ets.getString(tlist.get(i), tlist.get(i).getClass()).split(" ")));
		}
		return result;
	
	}
	
	//�����ַ��������з���������ַ�������
	public List<String> StringListGetSuitExpStringList(List<String> strlist,String exp)
	{
		List<String> temp=new ArrayList<String>();
		int g_size=strlist.size();
		for(int i=0;i<g_size;i++)
		{
			String subtemp=strlist.get(i);
			if(StringIsSuitExep(subtemp,exp))
				temp.add(subtemp);
		}
		return temp;
	}
	
	//返回字符串容器中字符包含符合正则的字符串容器
	public List<String> StringListGetSuitSubExpStringList(List<String> strlist,String subexp)
	{
		List<String> temp=new ArrayList<String>();
		int g_size=strlist.size();
		for(int i=0;i<g_size;i++)
		{
			String subtemp=strlist.get(i);
			if(StringIsSuitSubExep(subtemp,subexp))
				temp.add(subtemp);
		}
		return temp;
	}
	
	
	
	//��ö�Ӧ�������е��ַ�������
	public <T> List<String> getTSingleList(List<T> tlist,String name)
	{
		StringHandle sh=new StringHandle();
		EntityToString ets=new EntityToString();
		return sh.StringListListInitSingleList(sh.TListToStringListList(tlist), ets.getNameIndexof(tlist.get(0).getClass(), name));
	}
	
	//��Tת��Ϊ�ַ�������
	public <T> List<String> TToStringList(T it)
	{
		List<String> result = new ArrayList<String>();
		Class<?> c=it.getClass();
		// ��ȡ���е�ȫ�������ֶ�
		Field[ ] fields = c.getDeclaredFields( );
		// ѭ�������ֶΣ���ȡ�ֶ���Ӧ������ֵ
		for ( Field field : fields )
		{
			// ���費Ϊ�ա����ÿɼ��ԣ�Ȼ�󷵻�
			field.setAccessible( true );
			try
			{
				// �����ֶοɼ����Ϳ�����get������ȡ����ֵ��
				result.add((String)field.get( it ));
			}
			catch ( Exception e )
			{
				// System.out.println("error--------"+methodName+".Reason is:"+e.getMessage());
			}
		}
		return result;
	}
	//���ַ������������������϶�Ӧ�ַ�������
	public List<List<String>> StringListListAddToStringListList(List<List<String>> strlistlist,List<String> strlist)
	{
		int g_size=strlistlist.size();
		List<List<String>> result=new ArrayList<List<String>>();
		for(int i=0;i<g_size;i++)
		{
			List<String> strTemp=new ArrayList<String>(strlistlist.get(i));
			strTemp.add(strlist.get(i));
			result.add(strTemp);
		}
		return result;
	}
	
	//���ַ���������ֵת��ΪT
	public <T> T StringListToT(List<String> it,Class<T> clazz)
	{

		Field[ ] fields = clazz.getDeclaredFields( );
		T bean=null;
		try {
			bean=(T) clazz.newInstance();
			// ѭ�������ֶΣ���ȡ�ֶ���Ӧ������ֵ
			int j=0;
			for ( Field field : fields )
			{
				// ���費Ϊ�ա����ÿɼ��ԣ�Ȼ�󷵻�
				field.setAccessible( true );
				try
				{
					Field fs=getDeclaredField(bean, field.getName( ));
					if(fs==null){
						throw new IllegalArgumentException("Could not find field["+ 
								field.getName( )+"] on target ["+bean+"]");
					}
					makeAccessiable(fs);
					try{
						fs.set(bean, (Object)it.get(j));
					}
					catch(IllegalAccessException e){
						System.out.println("�������׳����쳣");
					}
					// �����ֶοɼ����Ϳ�����get������ȡ����ֵ��
					//result += field.get( o ) +" ";
					++j;
				}
				catch ( Exception e )
				{
					// System.out.println("error--------"+methodName+".Reason is:"+e.getMessage());
				}
			}
		} catch (InstantiationException | IllegalAccessException e1) {
			// TODO �Զ����ɵ� catch ��
			e1.printStackTrace();
		}
		return bean;
	}
	//���ַ���ת����T��
	public <T> T StringToT(String str,Class<T> it)
	{
		return StringListToT(StringNlistToStringList(str.split(" ")),it);
	}

	//��ȡfield���ԣ������п����ڸ����м̳� 
	public Field getDeclaredField(Object obj,String fieldName){
		for (Class<?> clazz=obj.getClass(); clazz!=Object.class; clazz=clazz.getSuperclass()){
			try{
				return clazz.getDeclaredField(fieldName);
			}
			catch(Exception e){
			}
		}
		return null;
	}
	


	//�ж�field�����η��Ƿ���public,���ݴ˸ı�field�ķ���Ȩ�� 
	public void makeAccessiable(Field field){
		if(!Modifier.isPublic(field.getModifiers())){
			field.setAccessible(true);
		}
	}
	
	
}
