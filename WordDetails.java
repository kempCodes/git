import java.util.Arrays;

/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * <pre>
 * Class        WordDetails
 * File         WordDetails.java
 * Description  Similar to an entry in a dictionary stored in a 1-dimensional 
 *              String array. Indexed accordingly;
 *                      0 - the word itself
 *                      1 - the word's Type   (noun, verb, adjective)
 *                      2 - a short definition/description
 * @author      <i>Kemper Lee</i>
 * @since       3/18/2022
 * History Log  3/18/2022, 3/19/2022, 3/28/2022
 * @version:    1.2
 * </pre>
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
public class WordDetails
{
    // class level variable declaration
    private String[] wordDetails = new String[3];
    
    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     *<pre>
     * Constructor  WordDetails()
     * Description  Default constructor. Fills object with an empty String
     * @author      <i>Kemper Lee</i>
     * @since       3/18/2022
     * History Log  3/18/2022, 3/28/2022
     *</pre>
    ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    public WordDetails()
    {
        this(new String[3]);
    }

    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     *<pre>
     * Constructor  WordDetails()
     * Description  Overloaded constructor. Fills object with a String array
     * @param       wordDerails --  String[]
     * @author      <i>Kemper Lee</i>
     * @since       3/18/2022
     * History Log  3/18/2022, 3/28/2022
     *</pre>
    ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    public WordDetails(String[] wordDetails)
    {
        this.wordDetails = wordDetails;
    }

    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     *<pre>
     * Constructor  WordDetails()
     * Description  Overloaded constructor. Fills object with only Word string
     * @param       word    --  String
     * @author      <i>Kemper Lee</i>
     * @since       3/28/2022
     * History Log  3/28/2022
     *</pre>
    ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    public WordDetails(String word)
    {
        this.wordDetails[0] = word;
    }
    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     *<pre>
     * Method       getWord()
     * Description  Getter method to return stringName String
     * @return      name    --  String
     * @author      <i>Kemper Lee</i>
     * @since       3/18/2022
     * History Log  3/18/2022
     *</pre>
    ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    public String setWord()
    {

        return wordDetails[0];
    }
    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     *<pre>
     * Method       getWord()
     * Description  Getter method to return stringName String
     * @return      name    --  String
     * @author      <i>Kemper Lee</i>
     * @since       3/18/2022
     * History Log  3/18/2022
     *</pre>
    ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    public String getWord()
    {
        return wordDetails[0];
    }
    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     *<pre>
     * Method       toString()
     * Description  Override toString for debugging
     * @return      String  --  All class level variables
     * @author      <i>Kemper Lee</i>
     * @since       3/18/2022
     * History Log  3/18/2022, 3/28/2022
     *</pre>
    ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    // override toString for debugging
    @Override
    public String toString() {
        return "WordDetails [wordDetails=" + Arrays.toString(wordDetails) + "]";
    }

    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     *<pre>
     * Method       hashCode()
     * Description  Returns the code in hash form
     * @return      int --  hashCode
     * @since       3/19/2022
     * History Log  3/19/2022, 3/28/2022
     *</pre>
    ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    @Override
    public int hashCode() 
    {
        final int prime = 31;
        int result = 1;
        result = prime * result + 
            ((wordDetails == null) ? 0 : wordDetails.hashCode());
        return result;
    }

    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     *<pre>
     * Method       equals()
     * Description  Verifies equality/uniformity with variables
     * @return      int --  hashCode
     * @since       3/19/2022
     * History Log  3/19/2022, 3/28/2022
     *</pre>
    ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        WordDetails other = (WordDetails) obj;
        if (wordDetails == null) {
            if (other.wordDetails != null)
                return false;
        } else if (!wordDetails.equals(other.wordDetails))
            return false;
        return true;
    }
    
}
