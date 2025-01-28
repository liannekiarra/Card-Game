import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Deck extends Thread{

    List<Integer> cards = new LinkedList<>();
    int decknumber;

static Deck[]  makedecks(int n){
    Deck[] alldecks= new Deck[n];
    for (int i=0 ; i<n ; i++){
        alldecks[i] = new Deck();}
    System.out.println(Arrays.toString(alldecks));
return alldecks;}

//example method making one deck for a test player

 

void setdecknumber(){

}
//assigning the decks to it's players
static void assigndecktoplayer (Deck[] alldecks, Player[] allplayers){
    for (int i =0 ; i <allplayers.length ; i++){
        allplayers[i].deck = alldecks[i].cards;

    }
}

}