public class ParkingLot {
    private int TW,FW;
    private final int TCap=10,FCap=5;
    private static long revenue=0;
    void park(String type)
    {
        if(TW<TCap ){
            if(type.equals("Two Wheeler"))
            {
                if(TW<TCap)
                {
                    TW++;
                    revenue+=20;
                }
                else
                {
                    System.out.println("Full");
                   // return;
                }
            }
            else if(type.equals("Four Wheeler"))
            {
                if(FW<FCap)
                {
                    FW++;
                    revenue+=40;
                }
                else
                {
                    System.out.println("Full");
                   // return;
                }
            }
            else
            {
                System.out.println("Full");
                //return;
            }
        }
    }
    void leave(String type){
        if(type.equals("Two Wheeler") && TW>0)
        {
            TW--;
        }
        else if(type.equals("Four Wheeler") && FW>0)
        {
            FW--;
        }
        else
        {
            return;
        }
    }
    void print()
    {
        System.out.println("Two Wheeler: "+TW+" Four Wheeler: "+FW+" Revenue: "+revenue);
        System.out.println("Total Capacity: Two Wheeler: "+TCap+" Four Wheeler: "+FCap);
    }
    public static void main(String[] args)
    {
        ParkingLot lot = new ParkingLot();
        lot.park("Two Wheeler");
        lot.park("Four Wheeler");
        lot.print();
        lot.leave("Two Wheeler");
        lot.print();
        lot.park("Four Wheeler");
        lot.print();
       
    }
}
