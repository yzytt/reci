package bean;

public class Reci {

	int id;
	String word;
	String jieshi;
	String dizhi;
	public Reci(int id, String word, String jieshi, String dizhi) {
		// TODO 自动生成的构造函数存根
		this.id = id;
		this.dizhi = dizhi;
		this.jieshi = jieshi;
		this.word = word;
	}
	public Reci(String jieshi,String dizhi) {
		this.dizhi=dizhi;
		this.jieshi=jieshi;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getWord() {
		return word;
	}
	public void setWord(String word) {
		this.word = word;
	}
	public String getJieshi() {
		return jieshi;
	}
	public void setJieshi(String jieshi) {
		this.jieshi = jieshi;
	}
	public String getDizhi() {
		return dizhi;
	}
	public void setDizhi(String dizhi) {
		this.dizhi = dizhi;
	}
	
}
