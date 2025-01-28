import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class CardGame {
    static int winnerplayernumber;

    public static void main(String args[]) throws IOException {
        System.out.print("Enter number of players: ");  
        
        while (true) {
            Scanner sc= new Scanner(System.in);    
            int n = sc.nextInt();
            if (n >= 2) {
                
                // The target file
                File file = new File("NumberGenerator.txt");
                file.createNewFile(); 
                System.out.println("File is created");
                int generateN = 8*n;
                int line;
                
            
                // Try block: Most stream operations may throw IO exception
                try {
                    // Create file writer object
                    FileWriter writer = new FileWriter(file);
                    Random random = new Random();
                    while (generateN > 0) {
                        // Randomize an integer and write it to the output file
                        // Generating a random number from 0 to 20
                        line = random.nextInt(20);
                        writer.write(String.valueOf(line));
                        writer.write("\n");
                        generateN--;
                    }
                    // Close the stream
                    writer.flush();
                    writer.close();
                    System.out.println("Data is entered into file");
                } catch (IOException e) {
                    e.printStackTrace();
                    System.exit(0);
                }

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
        boolean winner = false; // no winner at the start of game progression
        while (winner == false){
            //each player thread will do the discard and draw move until there is winner
            //for all player is the Player array
            int x = allplayers.length;//length of player
            int lastposition = allplayers.length - 1;//index of last player
            int i = 0;//temporary variable

            for(i = 0; i<x ; i++){
                //loop is for all the players except the last one
                if (i != lastposition){
                    int nextnum = i+1;
                    List<Integer> rightdeck = alldecks[nextnum].cards;
                    List<Integer> leftdeck = allplayers[i].deck;
                    winner = allplayers[i].playerturn(leftdeck, rightdeck);//check status
                    

                }else if (i == lastposition) {

                //for last player - last player discards to deck 
                     int nextnum = 0;//last player discards to deck number 1, index 0
                     List<Integer> leftdeck = allplayers[i].deck;
                     List<Integer> rightdeck = alldecks[nextnum].cards;
                     winner = allplayers[i].playerturn(leftdeck, rightdeck);//check status
                     

                }}
                if (winner == false){
                    System.out.println("No winner");//display for if there is no winner
                    continue;

                }else{
                    //if someone is holding a winning hands
                    System.out.println("We have a winner");//display if ther is winner
                    CardGame.winnerplayernumber = i;

                

                    
                    break;
                }
                
            } System.out.println("Invalid input. Must be at least 2 players");
            sc.close();
        } 
      

    
        

    }}}
