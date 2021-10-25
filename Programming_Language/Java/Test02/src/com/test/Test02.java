package com.test;

public class Test02 {

	public static void main(String[] args) {
		int month = 1;
        String monthString;
        switch (month) { // 변수(int(4byte) + String 값만 가능) , case다음에 변수값을 준다.
            case 1:  monthString = "January"; //case다음엔 단일 데이터값만 가능, ex) case 1,2,3 (x)
                     break;
            case 2:  monthString = "February";
                     break;
            case 3:  monthString = "March";
                     break;
            case 4:  monthString = "April";
                     break;
            case 5:  monthString = "May";
                     break;
            case 6:  monthString = "June";
                     break;
            case 7:  monthString = "July";
                     break;
            case 8:  monthString = "August";
                     break;
            case 9:  monthString = "September";
                     break;
            case 10: monthString = "October";
                     break;
            case 11: monthString = "November";
                     break;
            case 12: monthString = "December";
                     break;
            default: monthString = "Invalid month";
                     break;
        }
        System.out.println(monthString);
    }
		
	
}
