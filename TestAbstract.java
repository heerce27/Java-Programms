abstract class Game
    {
        abstract void Play();
    }
    class Cricket extends Game{
        void Play(){
            System.out.println("Cricket called");
        }
    }
    class Tennis extends Game{
        void Play(){
            System.out.println("Tennis called");
        }
    }
    public class TestAbstract{
    public static void main(String[] args)
    {
        Game g;
        g= new Cricket();
        g.Play();
        g=new Tennis();
        g.Play();
    }
}