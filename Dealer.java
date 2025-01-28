import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
/*** The Dealer class contains a method that distributes the pack in a round robin fashion
 * to each player's hand then to each deck.
*/

public class Dealer {


        public static void dispatchloop(Hands[] allhands, Deck [] alldecks ,List<Integer> pack) {
            //for all the objects in the array
            //round robin fashion dispatch
            //STATUS: THIS WORKS
        
        
        
        for (int k = 0 ; k <4 ; k++){
            //dispatching to all hands
            for (int i = 0 ; i < allhands.length ; i++){
                //access each hand of each object
                int newcard = pack.get(pack.size() -1);
                allhands[i].hands.add(newcard);
                pack.remove(pack.size()-1);
            }
        }
        //dispatching to all decks
        for(int d = 0 ; d<4 ; d++ ){
            //disparching to all decks
            for (int j = 0 ; j<alldecks.length ; j++){
                int card = pack.get(pack.size() -1);
                alldecks[j].cards.add(card);//adds the card value to the deck
                pack.remove(pack.size() - 1);//removes the card that was added to the deck
            }
        
        }

        }
//this method checks any of the hands has been given 4 cards of the same denomination
//which instanly declares the player the winner at the start of the game
//takes in the argument of the array that contains all hand objects

public static boolean checkwinner(Hands[] allhands){
    boolean winner = false;
    //for every hand list in the hand object.
    for (int i = 0 ; i<allhands.length; i++){
        //check everyhand - this hand represent each hand
        List<Integer> thishand = allhands[i].hands;
        for (int j= 1; j<20 ; j++){
        int occurences = Collections.frequency(thishand, j);
        if (occurences == 4){
            System.out.println("We have a winner");
            int playernum = i+1;
            System.out.println("The winner is, player number " + playernum );
            winner = true;

        }
        else{

        }
    }}
    return winner;

}


public static void main(String[] args){
    //taking in value of n from the user
    System.out.println("Enter number of players");
    Scanner userask = new Scanner(System.in);
    int n = userask.nextInt();
    // making the arrays
    Hands[] allhands = Hands.makehands(n);//making hands
    Deck[] alldecks = Deck.makedecks(n);//making decks
    Player[] allplayers = Player.makeplayers(n);//making players
    userask.close();
    List<Integer> pack = new LinkedList<Integer>();//making example pack
        //adding integers to the sample pack
        for (int i = 0; i <n*8 ;i++){
            pack.add(i +1 );
        }


    Dealer.dispatchloop(allhands,alldecks,pack);
    //displaying all hands
    System.out.println("Displaying all hands.");
    for (int i = 0; i <allhands.length; i++){
        int playernum = i+1;
        System.out.println("These are player " + playernum +"'s current hand");
        System.out.println(allhands[i].hands);
    }
    //displaying all decks
    System.out.println("Displaying all decks");
    for (int i = 0; i <alldecks.length; i++){
        int decknum = i+1;
        System.out.println("Displaying deck number: "+ decknum);
        System.out.println(alldecks[i].cards);
    }

    Hands.assignhandtoplayer(allhands, allplayers);
    System.out.println("Displaying all hands");
    for (int i = 0 ; i<allplayers.length; i++){
        System.out.println(allplayers[i].hands);//displaying all hands
    }

    //setting the player numbers for the player's
    System.out.println("These are the players and their preferred denomination:");
    for (int i = 0 ; i<allplayers.length ; i++){
        
        allplayers[i].playernumber = i + 1;
        int denomination = i +1;
        System.out.println ("Player Number: " + denomination + " Preferred denomination: " + denomination);

    }


}}