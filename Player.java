
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
/**This class needs to be thread safe */


public class Player extends Thread{

    int playernumber;
    List<Integer> hands = new LinkedList<>();
    boolean winner = false;
    List<Integer> deck = new LinkedList<>();


    static Player[] makeplayers(int n){
    Player[] allplayers = new Player[n];
    for (int i=0 ; i<n ; i++){
        allplayers[i] = new Player();}

    System.out.println(Arrays.toString(allplayers));
    return allplayers;

}
    public void setplayernumber(int playernumber) {
        this.playernumber = playernumber;
        
    }
    //draw and discard will be called here
    //all minor methods will be called
    //checks if the player is holding a winnng hand

    public void run(){}
    /**
     * This method is the overall combination of draw and discard
     * Also checks if the player has a winning hand
     * @param leftdeck
     * @param rightdeck
     */
    public boolean playerturn(List<Integer> leftdeck, List<Integer> rightdeck){
        boolean win = false;//status of player's hand
        List<Integer> hands = this.hands;
        this.draw(leftdeck);
        this.discard(rightdeck);
        win = this.checkstatus(hands);//checking if player has winning hand


    return win;}


    boolean checkstatus(List<Integer> hands){
        //checks if the player is a winner
        boolean winner = false;//initial value 
        List<Integer> hand = this.hands;//checks the hands if this player
        int occurences = Collections.frequency(hand,playernumber);//checks frequency of the preferred denomination
        if (occurences == 4){
            winner = true;
        } else{
            winner =false;
        }
        return winner;//returns the 
    }

    boolean initialhandscheck(List<Integer> hand){
        //this checks the hand of the player during the start of the game,
        //this declares if they are a winner after disparch, if they have been 
        //distributed 4 cards with the same value even if it is not their preferred
        //denomiation.
        // the range of the random numbers is 1-20
        boolean initialwinner = false;
        List<Integer> randomlist = new LinkedList<>();
        for (int i = 1; i<20 ; i++ ){
            randomlist.add(i);
        }//list that shows 1-20
        for (int j = 0 ; j < randomlist.size(); j++){
            int num = randomlist.get(j);
            int occurences = Collections.frequency(hand, num);
            if (occurences == 4){
                initialwinner = true;

            }else{
                initialwinner = false;
            }
        } return initialwinner;
    }
    //for testing purposes
     void showplayernumber (Player[] allplayers){
         System.out.println(this.playernumber);

     }
       //deckname - name of the deck where the player draws
     String draw (List<Integer> deckname){
        //this method should only take the last element of the drawing deck
        //then adds the this element to the player's deck
        //also removes the card from the deck list
        //enter the deck name of the deck where the test player draws from
        //-----------------------------------------------------------------//

        int newcard = deckname.get(deckname.size()-1);//last element
        this.hands.add(newcard); //added the card to the player's hand
        deckname.remove(deckname.size()-1);
        String info = "Player " + this.playernumber + " has drawn " + newcard;
        return info;}
        //------------------------------------------------------------------//
        //STATUS: WORKS
   

    public String discard(List<Integer> rightdeck){
        String info = "";//declaring the string
        boolean isDenomination = false;
        while(isDenomination == false){
        Random random = new Random();
        int x = this.hands.get(random.nextInt(this.hands.size()));
        if (x != this.playernumber){
            int indexnum =this.hands.indexOf(x);
            this.hands.remove(indexnum);
            rightdeck.add(0,x);
             info = "Player "  + this.playernumber  + "discarded " + x ;
            break;}
            else {
                continue;
            }} return info;}

    public void combined (Deck [] alldecks){
        //each player has access to all the decks
        int nextnum = playernumber +1;
        //accessing deck for discardng - right deck
        List<Integer> rightdeck = alldecks[nextnum].cards;
        
        
    }
    
public static void main(String[] args) {
    //make allhands. alldeck and allplayer
    int n = 5;
    List<Integer> pack = ReadTxtIntoList.Extracting();//making list of integers 
    System.out.println(pack);
    //n is inside this scope
    //make the players, decks and hands
    Hands[] allhands = Hands.makehands(n);//making hands
    Deck[] alldecks = Deck.makedecks(n);//making decks
    Player[] allplayers = Player.makeplayers(n);//making players
    Hands.assignhandtoplayer(allhands, allplayers);
    Deck.assigndecktoplayer(alldecks, allplayers);
    //distribute to decks and players
    Dealer.dispatchloop(allhands, alldecks, pack);//works
    boolean initialwinner = Dealer.checkwinner(allhands);//checking for lucky winner
    System.out.println(initialwinner);
    //no winner - GAME PROGRESSION


       
       
}}

       
