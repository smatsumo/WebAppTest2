package edu.umd.fcmd.analysis.data;

public class Option implements Comparable<Option> {
	private String name = null;
	private String value = null;
	/**
	 * Creates an Option with specified name and value.
	 * 
	 * @param name		name of the option
	 * @param value		value of the option
	 */
	public Option(String name, String value) {
		this.name = name;
		this.value = value;
	}

	/**
	 * Getter and setter for this Option's name
	 */
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Getter and setter for this Option's value
	 */
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	
	/**
	 * Options are ordered lexicographically by name, then by value.
	 * 
	 * @return		the value 0 if Option's name and value are both the same
	 * 				the value less than 0 if the argument is an Option lexicographically greater than this Option
	 * 				the value greater than 0 if the argument is an Option lexicographically less than this Option
	 */
	public int compareTo(Option o) {
		if (name.equals(o.name)) {
			return value.compareTo(o.value);
		}
		
		return name.compareTo(o.name);
	}
	
	@Override public boolean equals(Object obj) {
		/** TODO
		 * implement equals() method
		 *  
		 */
		// Check object is same or not
		if (this==obj) return true;
		if (obj==null&&this!=null) return false;
		if (!(obj instanceof Option)) return false;
		int x = compareTo((Option) obj);
		if(x==0) return true;
		return false;
	}
	
	@Override public int hashCode() {
		/** TODO
		 * implement hashCode() method
		 */
		int result = 17;
		result = 31*result+(name==null ? 0:name.hashCode());
		result = 31*result+(value==null ? 0:value.hashCode());
		return result;
	}
	
	/**
	 * @return		string representation of this Option
	 */
	public String toString() {
		return name + "=" + value;
	}
}