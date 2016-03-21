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
		if(this.equals(t))
			return 1;
		return 0;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj != null && obj instanceof Tag)
			return true;
		return false;
	}
	
	
}
