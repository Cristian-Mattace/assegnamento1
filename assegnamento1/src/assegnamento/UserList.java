package assegnamento;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
/**
 *
 * The class {@code UserList} provides an implementation of a
 * model of a user's list
 *
 **/
public class UserList {

    private List<User> users;
    /**
     * Class constructor.
     */
    public UserList(){

        this.users = new ArrayList<User>();
    }

    /**
     * @return the user's list
     */
    public List<User> getUsers(){
        return this.users;
    }

    /**
     * @param u the user that will be added to the list
     * @return true, if the add was succesfull
     *          false, if the add was wrong
     */
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

    /**
     * @param u the user that will be removed from the list
     */
    public void removeUser(User u){
        this.users.remove(u);
    }

    /**
     * @param mail the user's mail
     * @param psw the user's password
     * @return  the id of users with the same mail and password
     */
    public int accessSystem(String mail, String psw){

        for(User u : this.users){
            if(Objects.equals(u.getEmail(), mail) && Objects.equals(u.getPassword(), psw)){
                System.out.println("Benvenuto, "+ u.getFirstName());
                return u.getId();
            }
        }
        System.out.println("Access denied");
        return 0;

    }

    /**
     * print all info of all user in the list
     */
    public void stamp(){
        for(User u:this.users){
            System.out.println(u.getId()+" "+u.getEmail()+" "+u.getPassword());
        }
    }

    /**
     * @return the number of user in the list
     */
    public int listSize(){
        return this.users.size();
    }


    /**
     * @param id the user's id
     * @return the user with the same id
     */
    public User getUserById(int id){
        for (User usr : this.users) {
            if (Objects.equals(usr.getId(), id)) {
                return usr;
            }
        }
        System.out.println("An user with id "+id+"doesn't exist");
        return null;
    }

}
