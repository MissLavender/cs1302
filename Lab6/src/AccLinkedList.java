import java.util.LinkedList;

/*********************************************************************
 *                                                                    *
 *              Carmen Lavender                                       *
 *               Lab #6                                               *
 *              AccLinkedList                                        *
 *********************************************************************/
public class AccLinkedList {

    public LinkedList<Account> linkedList = new LinkedList<>();

    public void add(Account a) {
        if(linkedList.isEmpty())
            linkedList.add(a);
        else {
            int insertIndex = 0;
            while(insertIndex < linkedList.size() && a.getBalance() < linkedList.get(insertIndex).getBalance())
                insertIndex++;
            linkedList.add(insertIndex, a);
        }
    }

    public void display() {
        for(Account a : linkedList)
            a.display();
    }

    public static void main(String[] args) {
        Account a1 = new Account(1, "Test", 1);
        Account a2 = new Account(2, "Test", 2);
        Account a3 = new Account(3, "Test", 3);
        Account a4 = new Account(4, "Test", 4);
        Account a5 = new Account(5, "Test", 5);

        AccLinkedList Acl= new AccLinkedList();
        Acl.add(a3);
        Acl.add(a5);
        Acl.add(a1);
        Acl.add(a2);
        Acl.add(a4);
        Acl.display();
    }
}
