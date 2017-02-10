/*********************************************************************
 *                                                                    *
 *              Carmen Lavender                                       *
 *               Lab #5                                               *
 *              Recur Class                                           *
 *********************************************************************/
public class Recur {

    public void methRecur(int count) {
        if (count > 100)
            return;
        System.out.println(count);
        methRecur(count + 1);
    }

}
