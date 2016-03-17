package Parser;

public class Tag implements Comparable<Tag>{
	public String k;
	public String v;
	
	public Tag(String k, String v) {
		this.k = k;
		this.v = v;
	}

	@Override
	public int compareTo(Tag t) {
		if(this.k == t.k)
			return 1;
		return 0;
	}
	
	
}
