/*********************************************************************
 *                                                                    *
 *              Carmen Lavender                                       *
 *               Lab #5                                               *
 *              Revers3 Class                                    *
 *********************************************************************/
public class Reverse3 {
    public static void main(String[] args) {
        char name[] = {'S','t','e','v','e'};
        for(char c: name)
        System.out.println(c+" ");
        reverse3(name);
                //reverse3(name);  //will print out chars backwards
    }
    public static void reverse3(char[] arr){
        for( int i= arr.length-1; i >=0; i--)
            System.out.print(arr[i]);

    }

}
