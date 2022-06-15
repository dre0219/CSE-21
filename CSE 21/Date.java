public class Date {
	private int year;
	private int month;
	private int day;
	
	public Date(int year, int month, int day) {
		if(year > 1899 && year < 3001) this.year = year;
		else System.out.println("Invalid Year");
		
		if(month > 0 && month < 13) this.month = month;
		else System.out.println("Invalid Month");
		
		if(day > 0 && day < 32) this.day = day;
		else System.out.println("Invalid Day");
	}
	
	public int compare(Date dt) {
		int yearsDifferenceInDays = 365 * Math.abs(dt.getYear() - year);
		int daysDifference = Math.abs(dt.dayOfYear() - this.dayOfYear());
		int totalDifference = Math.abs(yearsDifferenceInDays - daysDifference);
		int monthsDifference = (int) (totalDifference / 30);
		
		if(monthsDifference < 61) return monthsDifference;
		else return 60;
	}
	
	public int dayOfYear() { 
		int totalDays = 0;  
		switch (month) {
			case 12: totalDays += 30;
			case 11: totalDays += 31;
			case 10: totalDays += 30;
			case 9 : totalDays += 31;
			case 8 : totalDays += 31;
			case 7 : totalDays += 30;
			case 6 : totalDays += 31;
			case 5 : totalDays += 30;
			case 4 : totalDays += 31;
			case 3 : totalDays += 28;
			case 2 : totalDays += 31;
		}  
		totalDays += day;  
		return totalDays; 
	}
	
	public int getYear() { 
		return year;
	}
	public int getMonth() { 
		return month;
	}
	public int getDay() { 
		return day;
	}
}
