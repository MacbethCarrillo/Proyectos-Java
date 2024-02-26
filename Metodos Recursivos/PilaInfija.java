package ok;

import java.util.Stack;
import java.util.Scanner;

public class PilaInfija {

	public static void main(String[] args) {
		
			Scanner scan = new Scanner(System.in);
			
			String input=scan.next();
			String output="";
			
			Stack <Character> pila=new <Character> Stack();

			
			for (int i=0;i<input.length();i++){

				if (input.charAt (i)>='0' & input.charAt (i) <='9')
					output = output+input.charAt (i);

				if (input.charAt(i) >='*' & input.charAt(i) <='/')
					pila.push (input.charAt (i));

				if (input.charAt (i)==')')
					output = output + pila.pop(); 
		}
		while(!pila.isEmpty())
			output = output+pila.pop();
		System.out.println(output);

	}

}
