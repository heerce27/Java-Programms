abstract class Shape{
    abstract double area();
}
class Circle extends Shape{
    double radius;
    Circle(double r){
        this.radius=r;   
    }
    @Override 
    double area(){
        return 3.14*radius*radius;
    }
}
class Rect extends Shape{
    double l,b;
    Rect(double l,double b){
        this.l=l;
        this.b=b;
    }
    @Override 
    double area(){
        return l*b;
    }
}

class Triangle extends Shape{
    double b,h;
    Triangle(double b,double h){
        this.b=b;
        this.h=h;
    }
    @Override 
    double area(){
        return 0.5*b*h;    
    }
}
public class ShapeA{
    public static void main(String[] args){
        Shape[] shapes=new Shape[]{
            new Circle(8.9),
            new Rect(4,5),
            new Triangle(10,7)
        };
        double total=0;
        double max=0;
        for(Shape s:shapes){
            double a=s.area();
            total=total+a;
            System.out.printf("Area of "+s.getClass().getSimpleName()+" is %.2f%n",a);
            System.out.printf("Running total area: %.2f%n",total);
            if(a>max){
                max=a;
            }
        }
        System.out.printf("Maximum area: %.2f%n",max);
    }
}