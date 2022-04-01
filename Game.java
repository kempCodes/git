import java.util.Arrays;
import java.util.Scanner;
/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * <pre>
 * Class        Game
 * File         Game.java
 * Description  Where the actual logic is performed for this WordMatcher game
 * @author      <i>Kemper Lee</i>
 * @since       3/30/2022
 * History Log  3/30/2022, 3/31/2022
 * @version:    1.1
 * </pre>
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
public class Game
{
    // class level variables
    private static Player player;
    private static String[] wordDetails;
    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     *<pre>
     * Constructor  Game()
     * Description  Default constructor. 
     *              Creates new default Player and String array.
     * @author      <i>Kemper Lee</i>
     * @since       3/30/2022
     * History Log  3/30/2022, 3/31/2022
     *</pre>
    ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    public Game()
    {
        this(new Player(), new String[3]);
    }
    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     *<pre>
     * Constructor  Game()
     * Description  Overloaded constructor. 
     *              Fills Player object and String array with passed values.
     *              Defaults values to 0
     * @author      <i>Kemper Lee</i>
     * @since       3/30/2022
     * History Log  3/30/2022, 3/31/2022
     *</pre>
    ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    public Game(Player player, String[] word)
    {
        Game.player = player;
        Game.wordDetails = word;
    }
    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     *<pre>
     * Method       getPlayer()
     * Description  Getter method to retrieve player information
     * @return      player  --  Player Object
     * @author      <i>Kemper Lee</i>
     * @since       3/31/2022
     * History Log  3/31/2022
     *</pre>
    ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    public Player getPlayer() 
    {
        return player;
    }
    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     *<pre>
     * Method       toString()
     * Description  Setter method to replace player information
     * @param       player  --  Player Object
     * @author      <i>Kemper Lee</i>
     * @since       3/31/2022
     * History Log  3/31/2022
     *</pre>
    ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    public void setPlayer(Player player) 
    {
        Game.player = player;
    }
    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     *<pre>
     * Method       isMatch()
     * Description  Finding word/confirming speling -- bonus points assigned
     *              for the full word accurately spelled. 5 guess max
     * @param       testWord    --  String
     * @return      boolean     --  true = matches
     * @author      <i>Kemper Lee</i>
     * @since       3/18/2022
     * History Log  3/18/2022, 3/29/2022, 3/30/2022, 3/31/2022
     *</pre>
    ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    public static void guessing(Scanner user)
    {
        System.out.print("What word is it? ");
        boolean match = false;
        int guesses = 4;
        do
        {
            player.guesses++;
            match = isMatch(user.next(), guesses);
        }while(!match && guesses-- > 0);
        player.games++;
    }
    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     *<pre>
     * Method       isMatch()
     * Description  Finding word/confirming speling -- bonus points assigned
     *              for the full word accurately spelled
     * @param       testWord    --  String
     * @return      boolean     --  true = matches
     * @author      <i>Kemper Lee</i>
     * @since       3/18/2022
     * History Log  3/18/2022, 3/29/2022, 3/30/2022, 3/31/2022
     *</pre>
    ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    public static boolean isMatch(String testWord, int guesses)
    {
        final int CAP = 4;  // the limit of guesses
        if(wordDetails[0].toLowerCase().contains(testWord.toLowerCase()))
        { // bonus for exact spelling + first guess
            if(wordDetails[0].equalsIgnoreCase(testWord) && guesses == CAP)
            {
                player.coins++;
            }
            return true;
        }
        // there is no match
        return false;
    }
    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     *<pre>
     * Method       toString()
     * Description  Overriden toString() for debugging purposes
     * @author      <i>Kemper Lee</i>
     * @since       3/30/2022
     * History Log  3/30/2022, 3/31/2022
     *</pre>
    ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    @Override
    public String toString() {
        return "Game [player=" + player + 
        ", word=" + Arrays.toString(wordDetails) + "]";
    }
    
}