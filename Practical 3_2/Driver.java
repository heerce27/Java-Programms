public class Driver {
    public static void main(String[] args) {
        Card[] table = new Card[5]; 
        int count=0;
        Card[] inc= {
            new Card("Ace","Hearts"),
            new Card("king","Black"),
            new Card("Queen","Black"),
            new Card("Ace","Hearts"),
            new Card("king","Black")
        }; 
        for(int i=0; i<inc.length;i++){
            boolean SeenBefore=false;
            for(int j=0;j<i;j++){
                if(inc[i].equals(table[j])){
                    SeenBefore=true;
                    break;
                }
            } 
            if(!SeenBefore){
                table[count] = inc[i];
                count++;
                }
        }
        System.out.println("Cards : ");
            for(Card co: inc){
                System.out.println(" " +co);
            }
            System.out.println(" distinct "+count);
}    
}

