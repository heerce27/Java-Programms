import calc.Addition;
import calc.Substraction;
import calc.Division;
import calc.Multiplication;
public class MainCalc{
	public static void main(String args[]){
	int a = 20;
        int b = 5;

        Addition obj1 = new Addition();
        Substraction obj2 = new Substraction();
        Multiplication obj3 = new Multiplication();
        Division obj4 = new Division();

        System.out.println("Addition = " + obj1.add(a, b));
        System.out.println("Subtraction = " + obj2.sub(a, b));
        System.out.println("Multiplication = " + obj3.mult(a, b));
        System.out.println("Division = " + obj4.divide(a, b));	
	}
}