public class Driver {
    public static void main(String args[]){
        Point[] points = { new Point(1,2) ,  
                           new Point(3,4),
                           new Point(1,2),
                           new Point(5,6 ),
                           new Point(3, 4)
         };
         int distinct = 0;
         for(int i=0; i<points.length;i++){
            boolean SeenBefore=false;
            for(int j=0;j<i;j++){
                if(points[i].equals(points[j])){
                    SeenBefore=true;
                    break;
                }
                
            } if(!SeenBefore){
                   distinct++;
                }
            } 
            System.out.println("Points : ");
            for(Point p: points){
                System.out.println(" " +p);
            }
            System.out.println(" distinct "+distinct);
    }
}
