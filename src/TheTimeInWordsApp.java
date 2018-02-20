// My solution to the HackerRank.com problem "The Time In Words.""
//

import java.util.Scanner;

public class TheTimeInWordsApp {
	
	  private static final String[] numNames = {
			    "",
			    "one",
			    "two",
			    "three",
			    "four",
			    "five",
			    "six",
			    "seven",
			    "eight",
			    "nine",
			    "ten",
			    "eleven",
			    "twelve",
			    "thirteen",
			    "fourteen",
			    "quarter",
			    "sixteen",
			    "seventeen",
			    "eighteen",
			    "nineteen"
			  };
    static String timeInWords(int h, int m) {
  
    	String timeInWords = "";
       	String minWord = "";
    	int hourNum = m<=30? h : (h+1)%12;
    	int min = 0;
    	String hourWord = numNames[hourNum];
    	
    	if(m == 0) {
    		timeInWords = numNames[h]+" o'clock";
    	}	
    	else if(m == 1) {
    		timeInWords = "one minute past " + hourWord;
    	} 
    	else if(m == 15) {
    		timeInWords = "quarter past "+ hourWord;
    	}
    	else if(m>0 && m<=20 && m!=15) {
    		timeInWords = minWord+ " minutes past " + hourWord;
    	}
    	else if(m>20 && m<30) {
    		min = m%10;
    		timeInWords = "twenty "+numNames[min]+ " minutes past " + hourWord;   		
    	}
    	else if(m == 30)  {
    		timeInWords = "half past " + hourWord;
    	}	
    	else if(m>30 && m<=40) {
    		min = (60 - m)%10;
    		timeInWords = "twenty " + numNames[min] + " minutes to " + hourWord;
    	}
    	else if(m==45) {
    		timeInWords = "quarter to "+hourWord;
    	}
    	else if(m>45) {
    		min = 60 - m;
    		timeInWords = numNames[min] + " minutes to " + hourWord; 		
    	}
    	
    	return timeInWords;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter the hour value for the time (integer 1-12): "); 
        int h = in.nextInt();
        System.out.print("Enter the minute value for the time (integer 0-60): "); 
        int m = in.nextInt();
        String result = timeInWords(h, m);
        System.out.println(result);
        in.close();
    }
}
