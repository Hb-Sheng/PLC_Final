import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

class main {
    public static void main(String[] args) {

        BufferedReader br = null;
        String line;

        StringBuilder sb = new StringBuilder();
        try {
        	System.out.println("Please type a fine name/directory in: "); //C:/123/test.txt
            Scanner ui = new Scanner(System.in);
            String fileName = ui.next();
            br = new BufferedReader(new FileReader(fileName));
            while ((line = br.readLine()) != null) {
                sb.append(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        String string = sb.toString();
        main analyzer = new main();
        String res = analyzer.check(string);
        System.out.print(res);
    }
    public String check_int(String string) {
    	 int cnt = 1;
    	 int exp_cnt = 0;
    	 int exp_idx = 0;
    	 int com_cnt = 0;
    	 int com_idx = 0;
    	 for (int i = 1; i < string.length(); i++) {
    		 char c = string.charAt(i);
    		 if (c > 47 && c < 58) cnt++;
    	     if (c == 'e') {
    	         exp_idx = i;
    	         exp_cnt++;
    	     }
    	     if (c == '.') {
    	         com_idx = i;
    	         com_cnt++;
    	     }
    	        }
    	 if (cnt == string.length()) {
    		 return "int";
    		 }
    	 if (cnt == string.length() - 1 && exp_cnt == 1 && exp_idx != string.length() - 1) return "int"; 
    	 if (cnt == string.length() - 1 && com_cnt == 1 && com_idx != string.length() - 1) return "float";
    	 if (cnt < string.length() - 1 && com_idx < exp_idx && exp_idx != string.length() - 1) return "float";
    	 return "error";
    	    }
    public String check_str(String string) {
    	     char c = string.charAt(string.length() - 1);
    	 if (c == '"') return "string";
    	 else return "error";
    	    }
    	    public String check_name(String string) {
    	        int cnt = 1;
    	     for (int i = 1; i < string.length(); i++) {
    	         char c = string.charAt(i);   
    	            if ((c == '_') || (c == '$') || (c > 64 && c < 91) || (c > 96 && c < 123)) cnt++;
    	            if (cnt == string.length()) return "true";
    	        }
    	 return "error";
    	 }
    	    public String check(String string) {
    	    	char c = string.charAt(0);
    	    	if (c > 47 && c < 58) return check_int(string);
    	    	if (c == '"') return check_str(string);
    	    	if ((c == '_') || (c == '$') || ((c > 64 && c < 91) || (c > 96 && c < 123))) return check_name(string);  
    	    	return "error";
    	    	}
}
