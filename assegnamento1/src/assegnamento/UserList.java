package assegnamento;
import java.util.ArrayList;
import java.util.List;

public class UserList {

    private List<User> users;

    public UserList(){

        users = new ArrayList<User>();
    }

    public List<User> getUsers(){
        return users;
    }

    public void addUser(User u){

        if(users.size() > 0) {
            for (User us : users) {
                if (us.getEmail() == u.getEmail()) {
                    System.out.print("Already exist account with the mail: " + u.getEmail());
                } else {
                    users.add(u);
                    break;
                }
            }
        }
        else users.add(u);
    }

    public void removeUser(User u){
        users.remove(u);
    }

    public int accessSystem(String mail, String psw){

        for(User u : users){
            if(u.getEmail()==mail  && u.getPassword()==psw){
                return u.getId();
            }
        }
        return 0;

    }

    public void stamp(){
        for(User u : users){
            System.out.println(u.getFirstName());
        }
    }

}
