/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * <pre>
 * Class        ObjectType
 * File         ObjectType.java
 * Description  A basic object to demonstrate retrival and return of a String
 * @author      <i>Kemper Lee</i>
 * @since       3/18/2022
 * History Log  3/18/2022, 3/19/2022
 * @version:    1.0
 * </pre>
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
public class ObjectType 
{
    // class level variable declaration
    private String stringName;

    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     *<pre>
     * Constructor  ObjectType()
     * Description  Default constructor. Fills object with an empty String
     * @author      <i>Kemper Lee</i>
     * @since       3/18/2022
     * History Log  3/18/2022
     *</pre>
    ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    public ObjectType()
    {
        this(new String());
    }

    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     *<pre>
     * Constructor  ObjectType()
     * Description  Overloaded constructor. Fills object with an String
     * @author      <i>Kemper Lee</i>
     * @since       3/18/2022
     * History Log  3/18/2022
     *</pre>
    ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    public ObjectType(String stringName)
    {
        this.stringName = stringName;
    }

    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     *<pre>
     * Method       getStringName()
     * Description  Getter method to return stringName String
     * @return      name    --  String
     * @author      <i>Kemper Lee</i>
     * @since       3/18/2022
     * History Log  3/18/2022
     *</pre>
    ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    public String getName()
    {
        return stringName;
    }

    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     *<pre>
     * Method       toString()
     * Description  Override toString for debugging
     * @return      String  --  All class level variables
     * @author      <i>Kemper Lee</i>
     * @since       3/18/2022
     * History Log  3/18/2022
     *</pre>
    ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    // override toString for debugging
    @Override
    public String toString()
    {
        return ("{String Name=" + stringName + '}');
    }

    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     *<pre>
     * Method       hashCode()
     * Description  Returns the code in hash form
     * @return      int --  hashCode
     * @since       3/19/2022
     * History Log  3/19/2022
     *</pre>
    ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    @Override
    public int hashCode() 
    {
        final int prime = 31;
        int result = 1;
        result = prime * result + 
            ((stringName == null) ? 0 : stringName.hashCode());
        return result;
    }

    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     *<pre>
     * Method       equals()
     * Description  Verifies equality/uniformity with variables
     * @return      int --  hashCode
     * @since       3/19/2022
     * History Log  3/19/2022
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
        ObjectType other = (ObjectType) obj;
        if (stringName == null) {
            if (other.stringName != null)
                return false;
        } else if (!stringName.equals(other.stringName))
            return false;
        return true;
    }
    
}
