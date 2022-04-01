/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * <pre>
 * Class        Player
 * File         Player.java
 * Description  A player class to track player details
 * @author      <i>Kemper Lee</i>
 * @since       3/24/2022
 * History Log  3/24/2022
 * @version:    1.2
 * </pre>
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
public class Player 
{
    // class level declaration
    private String name;
    public int coins;
    public int guesses;
    public int games;
    // maybe  private int best, total, coins; ?

    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     *<pre>
     * Constructor  Player()
     * Description  Default constructor. Fills object with empty String only
     * @author      <i>Kemper Lee</i>
     * @since       3/24/2022
     * History Log  3/24/2022
     *</pre>
    ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    public Player()
    {
        this(new String());
    }
    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     *<pre>
     * Constructor  Player()
     * Description  Overloaded constructor. Fills object with a String -- name
     * @author      <i>Kemper Lee</i>
     * @since       3/18/2022
     * History Log  3/18/2022
     *</pre>
    ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    public Player(String name)
    {
        this.name = name;
    }
    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     *<pre>
     * Constructor  Player()
     * Description  Overloaded constructor. Fills object with 3 int values
     * @author      <i>Kemper Lee</i>
     * @since       3/24/2022
     * History Log  3/24/2022
     *</pre>
    ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    public Player(int coins, int guesses, int games)
    {
        this.coins = coins;
        this.guesses = guesses;
        this.games = games;
    }
    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     *<pre>
     * Constructor  Player()
     * Description  Overloaded constructor. Loads all class level variables
     * @author      <i>Kemper Lee</i>
     * @since       3/24/2022
     * History Log  3/24/2022
     *</pre>
    ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    public Player(String name, int coins, int guesses, int games)
    {
        this.name = name;
        this.coins = coins;
        this.guesses = guesses;
        this.games = games;
    }
    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     *<pre>
     * Method       getName()
     * Description  Getter method to return name String
     * @return      name    --  String
     * @author      <i>Kemper Lee</i>
     * @since       3/24/2022
     * History Log  3/24/2022
     *</pre>
    ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    public String getName()
    {
        return name;
    }
    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     *<pre>
     * Method       setName()
     * Description  Setter method to retrieve name String
     * @return      name    --  String
     * @author      <i>Kemper Lee</i>
     * @since       3/24/2022
     * History Log  3/24/2022
     *</pre>
    ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    public void setName(String name) {
        this.name = name;
    }
    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     *<pre>
     * Method       toString()
     * Description  Overriden toString() for debugging purposes
     * 
     * @author      <i>Kemper Lee</i>
     * @since       3/24/2022
     * History Log  3/24/2022
     *</pre>
    ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    @Override
    public String toString() {
        return "Player [coins=" + coins + ", games=" + games + ", guesses="
         + guesses + ", name=" + name + "]";
    }
}


