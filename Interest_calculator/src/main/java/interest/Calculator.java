package interest;

public class Calculator {
  Data_Setting data;
	public void DateCalculation(String ldate, String edate)
	{
		//this method will be calculate years,months and days based given date's
		String date1[]=ldate.split("-");//String converting array's string
		String date2[]=edate.split("-");
		int year1,year2,month1,month2,day1,day2;
		year1=Integer.parseInt(date1[0]);
		month1=Integer.parseInt(date1[1]);
		day1=Integer.parseInt(date1[2]);
		year2=Integer.parseInt(date2[0]);
		month2=Integer.parseInt(date2[1]);
		day2=Integer.parseInt(date2[2]);
		data=new Data_Setting();
		if(year2>=year1)
		{
			if(day2>=day1)
			{
				data.setDays(day2-day1);
			}
			else
			{
				month2--;
				day2+=30;
				data.setDays(day2-day1);
			}
			if(month2>=month1)
			{
				data.setMonths(month2-month1);
			}
			else
			{
				year2--;
			    month2+=12;
			    data.setMonths(month2-month1);
			}
			data.setYear(year2-year1);
		}
		
	}
	public Data_Setting simpleInterest(double amount,String rate_mode,double in_rate)
	{
		// calculate simple interest 
	   double temp=0;
		double si=0;
		if(rate_mode.equals("%"))
		{
			//if SI based on %
			temp=(double)(amount*in_rate)/100;//this is PRT/100 format
			data.setYearly(temp);//Interest yearly
			data.setDays1((temp/12)/30);//interest day's
			 data.setMonthly(temp/12);//interest monthly
			if(data.getYear()!=0)
			{
			  si=temp*data.getYear();

			}
		  if(data.getMonths()!=0)
			  
			  si+=(temp/12)*data.getMonths();
		     
		  if(data.getDays()!=0)
			  si+=(((temp/12)/30)*data.getDays());
		     
		   
		}
		else
		{
			//SI based on rupee's
			temp=(double)(amount*in_rate)/100;
			data.setYearly(temp*12);
			data.setMonthly(temp);
			data.setDays1(temp/30);
			if(data.getYear()!=0)
			{ 
				
				si=temp*(data.getYear()*12);
				
			}
			if(data.getMonths()!=0)
				si+=temp*data.getMonths();		
			if(data.getDays()!=0)
			{
              si+=data.getDays1()*data.getDays();				
			}
		}
		data.setSi(si);
		data.setTotal_amount(amount+si);
		System.out.println(si+" "+data.getDays1()+" "+data.getMonthly());
	  return data;
	}
	public Data_Setting compound_calculator(double amount,String compound_type,double in_rate )
	{
		//calculate compound interest
		double interest=0;
		if(compound_type.equals("annum"))
		{
			interest =amount * (Math.pow((1 + in_rate/100), (data.getYear()))) - amount;
		 
		}
		else if(compound_type.equals("half"))
		{
			interest =amount * (Math.pow((1 + in_rate/200), (data.getYear()*2))) - amount;

		}
		else
		{
			interest =amount * (Math.pow((1 + in_rate/400), (data.getYear()*4))) - amount;

		}
		data.setYearly(interest/data.getYear());
		data.setMonthly(data.getYearly()/12);
		data.setDays1(data.getMonthly()/30);
		interest+=data.getMonthly()*data.getMonths();
		interest+=data.getDays()*data.getDays1();
		data.setSi(interest);
		data.setTotal_amount(amount+interest);
		System.out.println(interest+" "+data.getDays1()+" "+data.getMonthly());
	   return data;
	}
}

