package test;
//疫情信息中变量定义
public class Card implements Comparable<Card> {
	private String name;
	private String id;
	private String a, b, c, d, e, f, g;
	private String time;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getA() {
		return a;
	}

	public void setA(String a) {
		this.a = a;
	}

	public String getB() {
		return b;
	}

	public void setB(String b) {
		this.b = b;
	}

	public String getC() {
		return c;
	}

	public void setC(String c) {
		this.c = c;
	}

	public String getD() {
		return d;
	}

	public void setD(String d) {
		this.d = d;
	}

	public String getE() {
		return e;
	}

	public void setE(String e) {
		this.e = e;
	}

	public String getF() {
		return f;
	}

	public void setF(String f) {
		this.f = f;
	}

	public String getG() {
		return g;
	}

	public void setG(String g) {
		this.g = g;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String toString() {
		return name + "\t" + id + "\t" + a + "\t" + b + "\t" + c + "\t" + d + "\t" + e + "\t" + f + "\t" + g + "\t"
				+ time + "\n";
	}

	@Override
	public int compareTo(Card c) {
		// TODO 自动生成的方法存根
		return this.name.compareTo(c.getName());
	}
}
