/*********************************************************************
 *                                                                    *
 *              Carmen Lavender                                       *
 *               Lab #5                                               *
 *              Convert class                                         *
 *********************************************************************/
public class Convert {

   public static void main(String []args){


       double[] num= new double[21];
       double[] num2= new double[21];
       for ( int i=0; i<num.length; i++){
           double temp = i*25;
           num [i] = temp;
           num2 [i] = temp-32*(5.0/9.0);
       }

       for(int i=0; i<num.length; i++)
           System.out.printf("%10.0f %10f%n", num[i], num2[i]);
   }

}
