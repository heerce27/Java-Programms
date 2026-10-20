import java.util.ArrayList;
class Student{
    int roll;
    String name;
    Student(int r,String n)
    {
        roll=r;
        name=n;
    }
    void show(){
        System.out.println("Roll no: "+roll+"\nName: "+name+"\n");
    }
}
public class Main{
    public static void main(String[] args){
        ArrayList<Student> a=new ArrayList<>();
        Student s=new Student(1, "hi");
        Student s1=new Student(2,"me");
        a.add(s);
        a.add(s1);
        for (Student student : a) {
            student.show();
        }
    }
}