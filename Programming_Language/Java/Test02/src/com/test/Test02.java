package com.test;

public class Test02 {

	public static void main(String[] args) {
		int month = 1;
        String monthString;
        switch (month) { // ����(int(4byte) + String ���� ����) , case������ �������� �ش�.
            case 1:  monthString = "January"; //case������ ���� �����Ͱ��� ����, ex) case 1,2,3 (x)
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
