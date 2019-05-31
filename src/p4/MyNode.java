package p4;

public class MyNode {
	private String values;
	private String id;
	public MyNode(String values,String id) {
		this.values = values;
		this.id = id;
	}
	public String toString() {
		return this.values;
	}
	public String getId() {
		return this.id;
	}

}
