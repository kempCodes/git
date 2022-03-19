
import java.lang.IndexOutOfBoundsException;
import java.util.ArrayList;
import java.util.Scanner;
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
 * History Log  3/18/2022, 3/19/2022
 * @version:    1.0
 * 
 * Partial credit to Niko Culevski, a very helpful and inspirational instructor
 * </pre>
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
public class WordMatcher
{
    // class level variable
    private static ArrayList<ObjectType> arrayListName = new ArrayList<>();
    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     *<pre>
     * Method       main()
     * Description  Take two String values from the user and compare them
     *              
     * @param       args    --  String[] are the command line strings
     * @author      <i>Kemper Lee</i>
     * @since       3/18/2022
     * History Log  3/18/2022, 3/19/2022
     *</pre>
    ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    public static void main(String[] args)
    {
        // create Scanner object
        Scanner input = new Scanner(System.in);

        // creating an Object with the input as a variable
        System.out.print("Enter a String: ");
        String sampleName = input.nextLine();
        ObjectType exampleObject = new ObjectType(sampleName);
        arrayListName.add(exampleObject);

        // creating a second String to test the search Method
        System.out.print("Enter a second String: ");
        String sampleTestName = input.nextLine();

        // looking through the ArrayList -- making sure it's there 
        try
        {
            ObjectType exampleType = searchObject(sampleTestName);
            // printing the entered name or stating that there is no match
            if(exampleType == null)
                System.out.println("No match");
            else
                System.out.println(exampleType.getName());

        // displaying that there was an error/there was no match
        }catch(IndexOutOfBoundsException indexException)
        {
            System.out.println("No match");
        }
        // close Scanner object 
        input.close();
    }

    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     *<pre>
     * Method       searchObject()
     * Description  finding Objects inside an ArrayList in Java
     *              (according to a Java 1 student, so grain of salt haha)
     * @param       object  --  String
     * @return      exampleType --  ObjectType
     * @author      <i>Kemper Lee</i>
     * @since       3/18/2022
     * History Log  3/18/2022
     *</pre>
    ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    private static ObjectType searchObject(String object)
    {
        // seeing if the object exists
        if((object != null) && (object.length() > 0))
        {
            // create default type to avoid unneeded re-declaration
            ObjectType exampleType = null;

            // scan the length of object till found
            for(int i = 0; i < object.length() - 1; i++)
            {
                exampleType = arrayListName.get(i);
                // test for the defining factor -- this example uses Names
                // Note: getName() was created -- is not a default method name
                if(exampleType.getName().length() != object.length())
                {
                    return null;
                // convert Strings to ALL lowercase letters
                }else if(exampleType.getName().toLowerCase().equals(
                        object.toLowerCase()))
                {
                    // returns the matching copy of the ObjectType
                    return exampleType;
                }
            }
        }
        // defaults to null if no object is found
        return null;
    }
}