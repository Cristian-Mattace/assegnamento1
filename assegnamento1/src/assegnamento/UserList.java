package assegnamento;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class UserList {

    private List<User> users;

    public UserList(){

        this.users = new ArrayList<User>();
    }

    public List<User> getUsers(){
        return this.users;
    }

    public boolean addUser(User u){

        if(this.users.size() > 0) {
            for (User us : this.users) {
                if (Objects.equals(us.getEmail(), u.getEmail())) {
                    System.out.println("Already exist account with the mail: " + u.getEmail());
                    return false;
                }
            }
            this.users.add(u);
            return true;
        }
        else {
            this.users.add(u);
            return true;
        }
    }

    public void removeUser(User u){
        this.users.remove(u);
    }

    public int accessSystem(String mail, String psw){

        for(User u : this.users){
            if(Objects.equals(u.getEmail(), mail) && Objects.equals(u.getPassword(), psw)){
                System.out.println("Benvenuto, "+ u.getFirstName());
                return u.getId();
            }
        }
        System.out.println("Login non riuscito");
        return 0;

    }

    public void stamp(){
        for(User u:this.users){
            System.out.println(u.getId()+" "+u.getEmail()+" "+u.getPassword());
        }
    }

    public int listSize(){
        return this.users.size();
    }

}
