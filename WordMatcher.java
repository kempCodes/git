import java.io.File;
import java.io.FileNotFoundException;
import java.lang.IndexOutOfBoundsException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.util.StringTokenizer;

import javax.swing.JOptionPane;
/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * <pre>
 * Class        WordMatcher
 * File         WordMatcher.java
 * Description  One method of searching a list of String type variables using 
 *              a class level ArrayList
 * @see         java.lang.IndexOutOfBoundsException    
 * @see         java.util.ArrayList
 * @see         java.util.Scanner
 * @author      <i>Kemper Lee</i>
 * @since       3/18/2022
 * History Log  3/18/2022, 3/19/2022, 3/29/2022, 3/31/2022
 * @version:    1.4
 * 
 * </pre>
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
public class WordMatcher
{
    // class level variables
    private static ArrayList<String[]> players = new ArrayList<>();
    private static ArrayList<String[]> words = new ArrayList<>();
    private static Player thisPlayer = new Player();
    private static String folder = "files\\";
    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     *<pre>
     * Method       main()
     * Description  This program is a word matching/guessing/spelling  game in 
     *              which the user is given a short definition or description
     *              of a word and must enter it in the console.
     *       
     * @param       args    --  String[] are the command line strings
     * @see         java.io.FileNotFoundException
     * @see         java.lang.Exception
     * @see         java.lang.IndexOutOfBoundsException
     * @see         java.util.Scanner
     * @author      <i>Kemper Lee</i>
     * @since       3/18/2022
     * History Log  3/18/2022, 3/19/2022, 3/29/2022
     *</pre>
    ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    public static void main(String[] args)
    {
        // create method level Scanner
        Scanner user = new Scanner(System.in);
        try
        {   // list name, location, elements
            fillList(players, "players.txt", 4);
            fillList(words, "word_list.txt", 4);
        }
        catch(IndexOutOfBoundsException | FileNotFoundException indexOrFile)
        {
            System.out.println("An error occured while file reading");
            System.exit(0);
        }
        catch(NullPointerException nullPointer)
        {
            System.out.println("You must enter a name. Even gibberish works.");
            System.exit(0);
        }
        // prompt user for their name
        String playerName = JOptionPane.showInputDialog("Who are you?");

        //There needs to be something here to check this
        thisPlayer = new Player(playerName);

        gameplay(user);
        user.close();   // closes Scanner -- System.in   
    }
    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     *<pre>
     * Method       fillList()
     * Description  Loads a String ArrayList with file contents
     *      
     * @param       list    --  ArrayList<String[]>
     * @param       file    --  String
     * @throws      FileNotFoundException
     * @see         java.io.FileNotFoundException
     * @see         java.util.ArrayList
     * @see         java.util.Scanner
     * @author      <i>Kemper Lee</i>
     * @since       3/28/2022
     * History Log  3/28/2022, 3/29/2022, 3/30/2022
     *</pre>
    ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    public static void fillList(ArrayList<String[]> list, 
        String file, int elements) throws FileNotFoundException
    {
        // reads file elements token by token while there are more lines/tokens
        try(Scanner fileScanner = new Scanner(new File(folder + file)))
        {
            StringTokenizer token;
            while(fileScanner.hasNext())
            { // reset index and create new person array
                int index = 0;
                String[] personInfo = new String[elements];
                token = new StringTokenizer(fileScanner.nextLine(), ",");
                // break on commas -- to the end of line
                while(token.hasMoreTokens() && index < elements)
                {
                    personInfo[index++] = (token.nextToken());
                }
                list.add(personInfo);
            }
        }
    }
    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     *<pre>
     * Method       gameplay()
     * Description  Selects a random word from the list given. Creates a new
     *              Game object with the Player and Word information. Has
     *              Player guess until the word is entered. Display results.
     *       
     * @param       user    --  Scanner
     * @see         java.lang.Exception
     * @see         java.util.ArrayList
     * @see         java.util.Random
     * @see         java.util.Scanner
     * @author      <i>Kemper Lee</i>
     * @since       3/31/2022
     * History Log  3/31/2022
     *</pre>
    ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    public static void gameplay(Scanner user)
    {
        try
        { // generate a *random word from the list given
            String[] nextWord = words.get(new Random().nextInt(words.size()));
            new Game(thisPlayer, nextWord);

            // display the definition
            System.out.println(nextWord[2]);
            Game.guessing(user);
        } // displaying that there was an error
        catch(Exception exc)
        {
            System.out.println("IDK WHAT HAPPENED SO...");
        }
        finally
        { // asks if they want to play again
            results(user);
        }
    }
    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     *<pre>
     * Method       results()
     * Description  Displays scores from one round and prompts for another
     *              Not playing more == ending the program
     * @param       user    --  Scanner
     * @param       args    --  String[]
     * @author      <i>Kemper Lee</i>
     * @since       3/31/2022
     * History Log  3/31/2022
     *</pre>
    ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    public static void results(Scanner user)
    {
        System.out.println("Alright " + thisPlayer.getName() + ", let's see...");
        System.out.println("Coins earned: " + thisPlayer.coins);
        System.out.println("Total games: " + thisPlayer.games);
        System.out.println("Total guesses: " + thisPlayer.guesses);
        System.out.print("Want to go again? (Y or N) ");
        
        if(user.next().toLowerCase().charAt(0) == 'y')
            gameplay(user);
        else
        {
            System.out.println("The end");
            System.exit(0);
        }
    }
}