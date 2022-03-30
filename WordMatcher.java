
import java.io.File;
import java.io.FileNotFoundException;
import java.lang.IndexOutOfBoundsException;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.StringTokenizer;
/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * <pre>
 * Class        WordMatcher
 * File         WordMatcher.java
 * Description  One method of searching a list of String type variables using 
 *              a class level ArrayList
 * @see         IndexOutOfBoundsException
 * @see         java.util.ArrayList
 * @see         java.util.Scanner
 * @author      <i>Kemper Lee</i>
 * @since       3/18/2022
 * History Log  3/18/2022, 3/19/2022, 3/29/2022
 * @version:    1.2
 * 
 * </pre>
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
public class WordMatcher
{
    // class level variables
    private static ArrayList<Player> players = new ArrayList<>();
    private static ArrayList<WordDetails> words = new ArrayList<>();
    private static String files = "files\\";
    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     *<pre>
     * Method       main()
     * Description  Take two String values from the user and compare them
     *              
     * @param       args    --  String[] are the command line strings
     * @author      <i>Kemper Lee</i>
     * @since       3/18/2022
     * History Log  3/18/2022, 3/19/2022, 3/29/2022
     *</pre>
    ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    public static void main(String[] args)
    {
        // create temporary Scanner object
        try(Scanner input = new Scanner(System.in))
        {
            // filling list of player details
            fillList(players, "players.txt");

            // filling list of word details
            fillList(words, "word_list.txt");
        } // looking through the ArrayList -- making sure it's there 
        try
        {
            /**
             * This is where the searching goes
             */
            
        // displaying that there was an error/there was no match
        }catch(IndexOutOfBoundsException indexException)
        {
            System.out.println("No match");
        }catch(Exception exc)
        {
            System.out.println("Scanner issue or something?");
        }
    }
    
    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     *<pre>
     * Method       fillList()
     * Description  Loads a *type-dynamic* ArrayList with the desired File 
     *              contents
     *      
     * @param       emptyList   --  ArrayList<Type>
     * @param       file        --  String
     * @see         java.io.FileNotFoundException
     * @see         java.util.ArrayList
     * @see         java.util.Scanner
     * @author      <i>Kemper Lee</i>
     * @since       3/28/2022
     * History Log  3/28/2022, 3/29/2022
     *</pre>
    ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    @SuppressWarnings("unchecked")
    public static <Type> void fillList(ArrayList<Type> list, String file)
    {
        // reads file elements token by token while there are more lines/tokens
        try(Scanner fileScanner = new Scanner(new File(files + file)))
        {
            StringTokenizer token;
            while(fileScanner.hasNext())
            { // String type to read multiple tokens per ArrayList index
                ArrayList<String> arrayIndecies = new ArrayList<>();
                token = new StringTokenizer(fileScanner.nextLine(), ",");
                // break on commas -- to the end of line
                while(token.hasMoreTokens())
                {
                    arrayIndecies.add(token.nextToken());
                }
                list.add((Type)arrayIndecies);
            }
        } // Not found/doesn't exist
        catch(FileNotFoundException fileNotFound)
        {
            System.out.println("FileNotFoundException");
        }catch(NoSuchElementException noSuchElement)
        {
            System.out.println("NoSuchElementException");
        }finally
        {
            System.out.println(list);
        }
    }

    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     *<pre>
     * Method       searchWord()
     * Description  Finding word/confiming spelling inside an ArrayList of
     *              WordDetail objects
     * @param       word    --  String
     * @return      testWord    --  WordDetails
     * @author      <i>Kemper Lee</i>
     * @since       3/18/2022
     * History Log  3/18/2022, 3/29/2022
     *</pre>
    ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    public static WordDetails searchWord(String word)
    {
        // seeing if the word exists
        if((word != null) && (word.length() > 0))
        {
            WordDetails testWord = null;

            // scan the length of WordDetails till found
            for(int i = 0; i < words.size(); i++)
            {
                testWord = words.get(i);
                // test for a defining factor -- length/spelling
                if(testWord.getWord().length() != word.length())
                {
                    return null;
                } // convert Strings to ALL lowercase letters
                else if(testWord.getWord().toLowerCase().equals(
                        word.toLowerCase()))
                {
                    // returns the matching copy of the ObjectType
                    return testWord;
                }
            } // end for
        } // end if
        // defaults to null if no object is found
        return null;
    }
}