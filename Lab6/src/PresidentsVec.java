import java.util.Scanner;
import java.util.Vector;

/****************************************************************
 *                                                               *
 *                  Carmen Lavender                              *
 *                   Lab 6                                       *
 *                 PresidentsVec                                  *
 ****************************************************************/
public class PresidentsVec {
    Vector<String> presVec = new Vector<>();

    public PresidentsVec() {
        presVec.add("George Washington");
        presVec.add("John Adams");
        presVec.add("Thomas Jefferson");
        presVec.add("James Madison");
        presVec.add("John Quincy Adams");
        presVec.add("Andrew Jackson");
        presVec.add("Martin Van Buren");
        presVec.add("William Henry Harrison");
        presVec.add("John Tyler");
        presVec.add("James K Polk");
    }

    public static void main(String args[]) {
        PresidentsVec p2 = new PresidentsVec();


        System.out.print("which president do you want to see? " + "Enter a number 1-10");
        Scanner random = new Scanner(System.in);
        System.out.print(p2.presVec.get(random.nextInt() - 1));
    }

}
