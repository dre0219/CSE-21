public class Student {
	private String name;
	private char gender;
	private Date birthdate;
	private Preference pref;
	private Boolean matched = false;
	
	public Student(String name, char gender, Date birthdate, Preference pref) {
		this.name = name;
		this.gender = gender;
		this.birthdate = birthdate;
		this.pref = pref;
	}
	
	public int compare(Student stu) {
		int pref = this.pref.compare(stu.pref);
		int ageDifference = this.birthdate.compare(stu.birthdate);
		if(this.gender != stu.getGender()) return 0;
		return 100 - pref - ageDifference;
	}
	public void setMatched(Boolean t) {
		this.matched = t;
	}
	
	public String getName() { 
		return name;
	}
	public char getGender() { 
		return gender;
	}
	public Date getDate() {
		return birthdate;
	}
	public Preference getPref() { 
		return pref;
	}
	public Boolean getMatched() { 
		return matched;
	}
	
}
