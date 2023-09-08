package interest;

import java.io.Serializable;

public class Data_Setting implements Serializable {
	private int year,months,days;
	private double monthly,yearly,days1,si,total_amount;

	public int getYear() {
		return year;
	}

	public int getMonths() {
		return months;
	}

	public int getDays() {
		return days;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public void setMonths(int months) {
		//if(months!=0)
		this.months = months;
		//else
			//this.months=1;
	}

	public void setDays(int days) {
		this.days = days;
	}

	public double getMonthly() {
		return monthly;
	}

	public double getYearly() {
		return yearly;
	}

	public double getDays1() {
		return days1;
	}

	public void setMonthly(double monthly) {
		this.monthly = monthly;
	}

	public void setYearly(double yearly) {
		this.yearly = yearly;
	}

	public void setDays1(double days1) {
		this.days1 = days1;
	}

	public double getSi() {
		return si;
	}

	public double getTotal_amount() {
		return total_amount;
	}

	public void setSi(double si) {
		this.si = si;
	}

	public void setTotal_amount(double total_amount) {
		this.total_amount = total_amount;
	}
	

}
