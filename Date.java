public class Date  {
    private int day;
    private int month;
    private int year;




    public Date(int day, int month, int year) {

        // need to make sure these are within the bounds

        if(day > 0 && day <= 31)
        {
            this.day = day;
        }
        else {
            throw new IllegalArgumentException("The days you entered do not make sense. outside of 1 - 31");
        }

        if(month > 0 && month <= 12)
        {
            this.month = month;
        }
        else {
            throw new IllegalArgumentException("The months you entered do not make sense. outside of 1 - 12");
        }


        if(year >= 2024 && year < 2200) // wouldnt make much sense to create a todo list for the past lol
        {
            this.year = year;
        }
        else {
            throw new IllegalArgumentException("The years you entered do not make sense. bound is 2024 - 2200");
        }
    }






    //getters and setters

    public int getDay() {
        return day;
    }
    public void setDay(int day) {
        if(day > 0 && day <= 31)
        {
            this.day = day;
        }
        else {
            throw new IllegalArgumentException("The days you entered do not make sense. outside of 1 - 31");
        }
    }


    public int getMonth() {
        return month;
    }
    public void setMonth(int month) {
        if(month > 0 && month <= 12)
        {
            this.month = month;
        }
        else {
            throw new IllegalArgumentException("The months you entered do not make sense. outside of 1 - 12");
        }
    }


    public int getYear() {
        return year;
    }
    public void setYear(int year) {
        if(year >= 2024 && year < 2200) // wouldnt make much sense to create a todo list for the past lol
        {
            this.year = year;
        }
        else {
            throw new IllegalArgumentException("The years you entered do not make sense. bound is 2024 - 2200");
        }
    }


    //new
    public int increaseYear()
    {
        setYear(this.year + 5);
        return year;
    }


}