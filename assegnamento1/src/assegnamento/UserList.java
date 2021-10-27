package assegnamento;
import java.util.ArrayList;
import java.util.List;

public class UserList {

    private List<User> users;

    public UserList(){

        this.users = new ArrayList<User>();
    }

    public List<User> getUsers(){
        return this.users;
    }

    public void addUser(User u){

        if(this.users.size() > 0) {
            for (User us : this.users) {
                if (us.getEmail() == u.getEmail()) {
                    System.out.print("Already exist account with the mail: " + u.getEmail());
                } else {
                    this.users.add(u);
                    break;
                }
            }
        }
        else this.users.add(u);
    }

    public void removeUser(User u){
        this.users.remove(u);
    }

    public int accessSystem(String mail, String psw){

        for(User u : this.users){
            if(u.getEmail()==mail  && u.getPassword()==psw){
                return u.getId();
            }
        }
        return 0;

    }

    public void stamp(){
        for(User u : this.users){
            System.out.println(u.getFirstName());
        }
    }

}
