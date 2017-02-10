/*********************************************************************
 *                                                                    *
 *              Carmen Lavender                                       *
 *               Lab #5                                               *
 *              Simple Array  Class                                   *
 *********************************************************************/
public class SimpleArray {


    public static void main(String[] args){
        int[] num= new int[100];
        for (int i=0;i<100;i++)
            num[i]=500+i;
        for (int i=0;i<100;i++)
            System.out.println(num[i]);


    }
}
