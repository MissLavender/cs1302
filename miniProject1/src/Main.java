public class Main {

    public static void main(String[] args) {
        Patient p1 = new Patient();
        p1.select("A901");
        p1.display();
        Dentist d1 = new Dentist();
        d1.select("D201");
        d1.display();


    }
}
