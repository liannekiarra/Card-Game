import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
/**This class instantiates Hand objects, which represents each hand of the player
 * It has the attrubute hands which is a list that is used to store the cards of each
 * player.
 */

public class Hands extends Thread{
    
	List<Integer> hands = new LinkedList<>();//hands of each Hand object 
    String playernumber;//playernumber who owns the hands


//this method will take in parameter n
   static Hands[] makehands(int n){ 
    Hands[] allhands = new Hands[n];
    for (int i=0 ; i<n ; i++){
        allhands[i] = new Hands();}
    System.out.println(Arrays.toString(allhands));
    return allhands;
}

//this method assigns each hand to one player 
//takes in parameter allhands and allplayers
    static void assignhandtoplayer(Hands[] allhands, Player[] allplayers) {

        for (int i = 0; i<allhands.length; i++){
            List<Integer> hands = allhands[i].hands;
            allplayers[i].hands = hands;//assign each hand to each player
            String playernumberconvert = Integer.toString(i + 1);
            String playernumber = "Player Number: " + playernumberconvert;
            allhands[i].playernumber= playernumber;//assigns each hand to playernumber
            


    }}
    //this method displays the hands and the player who own it.
    static void displayhands (Hands[] allhands){

        for (int i=0; i< allhands.length ; i++){
            List<Integer> cards = allhands[i].hands;
            String fullinfo = allhands[i].playernumber + "  Hands: " + cards ;
            System.out.println(fullinfo);
        }
    }}