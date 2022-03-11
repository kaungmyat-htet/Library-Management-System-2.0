import com.model.Account;
import com.model.Librarian;
import com.model.Member;
import com.model.User;

public class Main {
    public static void main(String args[]) {
        User newUser = new Member("Johnny", "Kate", new Account("johnnyk", "password"));
        System.out.println(newUser);
        newUser.issueBook();

        User librarian = new Librarian("County", "Susan", new Account("County", "password"));
        System.out.println(librarian);
        librarian.issueBook();
        librarian.login("County", "password");
    }
}
