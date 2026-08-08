interface A {
    int a=20;
}
interface B extends A {
    float b=12.5f;
} 
interface  C extends A{
    double c=12.5;
}
class D implements C,B
{   long d=50l;
    double calc()
    {
        double ans=a*b*c*d;
        return ans;
    }
    void display()
    {
        System.out.println(" calc :"+ calc());
    }    
}
class Interfaceexample extends D{
    public static void main(String args[])
    {
        D h=new D();
        h.display();
    }
}
