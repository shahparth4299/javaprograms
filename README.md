# javaprogram to Identify Network Class
import java.io.*;
import java.util.*;
class Identify{
	static int stack[] = new int[20];
	static int top=-1;
	static void push(int a){
		top++;
		stack[top] = a;
	}
	static int pop(){
		int b = stack[top];
		top--;
		return b;
	}
	static char check(int ip){
		if(ip >= 0 && ip <= 127)
			return 'A';
		else if(ip >= 128 && ip <= 191)
			return 'B';
		else if(ip >= 192 && ip <= 223)
			return 'C';
		else if(ip >= 224 && ip <= 239)
			return 'D';
		else
			return 'E';
	}
	public static void main(String ar[]){
		int total=0,j;
		String ipaddress;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the IpAddress");
		ipaddress = sc.nextLine();
		System.out.println(ipaddress);
		int i=0;
		char a;
		char id[] = new char[4];
		while(ipaddress.charAt(i) != '.'){
			id[i] = ipaddress.charAt(i); 
			i++;
		}
		i--;
		int k=1;
		int b;
	    for(j=i;j>=0;j--){
			b = Character.getNumericValue(id[j]);
			total = total + (b*k);
			k = k * 10;
		}
		if(total >= 0 && total <=255){
		char classes;
		System.out.println("NETWORK ID : "+total);
		classes = check(total);
		System.out.println("Class "+classes);
		while(total > 0){
			b = total % 2;
			push(b);
			total = total / 2;
		}
		j=7;
		int ipa[] = new int[8];
        for(i=0;i<8;i++){
            ipa[i] = 0;
        }
        int f=top;
		for(i=top;i>=0;i--){
			ipa[j-f] = pop();
            j++;
		}
		for(i=0;i<=7;i++){
			System.out.print(ipa[i]);
		}
		System.out.println("\n"+j);
		if(ipa[0] == 0)
			classes = 'A';
		else{
			if(ipa[1] == 0)
				classes = 'B';
			else{
				if(ipa[2] == 0)
					classes = 'C';
				else{
					if(ipa[3] == 0)
						classes = 'D';
					else
						classes = 'E';
				}
			}
		}
		System.out.println("Class is : "+classes);
	}else
	{
		System.out.println("WRONG INPUT");
	}
	}
	
}
