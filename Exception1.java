class MyException extends Exception
{
    MyException(String msg){
        super(msg);
    }
}
class MainD{
    public static void main(String[] args) {
       int age=19;
       try{
        if(age>18)
        throw new MyException("Eligible");
        else
        throw new MyException("Not eligible");
       } 
       catch(MyException e){
        System.out.println(e.getMessage());
       }
    }
}
