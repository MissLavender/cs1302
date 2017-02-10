import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/****************************************************************
 *                                                               *
 *                  Carmen Lavender                              *
 *                   Lab 6                                       *
 *                 PresidentsAA                                  *
 ****************************************************************/
public class PresidentsAA {

        ArrayList<String> presList = new ArrayList<>();
    public PresidentsAA(){

        presList.add("George Washington");
        presList.add("John Adams");
        presList.add("Thomas Jefferson");
        presList.add("James Madison");
        presList.add("John Quincy Adams");
        presList.add("Andrew Jackson");
        presList.add("Martin Van Buren");
        presList.add("William Henry Harrison");
        presList.add("John Tyler");
        presList.add("James K Polk");
    }

    public static void main(String args[]){
        PresidentsAA p1 = new PresidentsAA();


        System.out.print("which president do you want to see? " + "Enter a number 1-10");
        Scanner random= new Scanner(System.in);
        System.out.print(p1.presList.get(random.nextInt() - 1));

    }
}
