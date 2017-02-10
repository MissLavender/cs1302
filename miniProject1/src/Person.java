/**
 * Created by Carmen on 10/12/2016.
 */
/****************************************************************
 *                                                               *
 *                  Carmen Lavender                              *
 *                   Mini Project 1                              *
 *                  Person   Class                               *
 ****************************************************************/
public class Person {

    /********************Properties*********************************/

    private String first_name;
    private String last_name;
    private String email;

    /*************************Constructors******************************/

    public Person()
    {   first_name= "";
        last_name="";
        email="";
    }

    public Person(String fn,String ln, String e)
    {    first_name=fn;
            last_name=ln;
        email=e;}

    /***********************Behaviors********************************/

    public void setFirst_name(String fn){ first_name=fn;}
    public String getFirst_name(){return first_name;}
    public void setLast_name(String ln){last_name=ln;}
    public String getLast_name(){return last_name;}
    public void setEmail(String e){email=e;}
    public String getEmail(){return email;}

    public void display()
    {
        System.out.println(" First Name "+ getFirst_name());
        System.out.println("Last Name "+ getLast_name());
        System.out.println(" Email "+ getEmail());
    }
}
