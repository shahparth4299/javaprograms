import java.util.*;
import java.io.*;
class StringManipulation{
    static void findFrequencyCount(String s,char c){
        int count =0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i) == c){
                count++;
            }
        }
        System.out.println("Frequency Count : "+count);
    }
    static void replaceCharacter(StringBuffer s){
            char c;
            String str;
            c = s.charAt(0);
            c = Character.toUpperCase(c);
            str = String.valueOf(c);
            s = s.replace(0,1,str);
            for(int i=0;i < s.length();i++){
                if(s.charAt(i)==' '){
                    c = s.charAt(i+1);
                    c = Character.toUpperCase(c);
                    str = String.valueOf(c);
                    s = s.replace(i+1,i+2,str);
                }
            }
            System.out.print("Replaced String : "+s);
    }
    public static void main(String a[]){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the String");
        String str = sc.nextLine();
        System.out.println("Enter the character");
        char ch = sc.next().charAt(0);
        findFrequencyCount(str,ch);
        StringBuffer sb = new StringBuffer();
        sb.append(str);
        replaceCharacter(sb);
    }
}