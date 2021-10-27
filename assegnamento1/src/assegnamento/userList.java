package assegnamento;
import java.util.ArrayList;
import java.util.List;

public class userList {
    private List<User> users;

    public userList(){

        this.users = new ArrayList<User>();
    }

    public List<User> getUsers(){
        return this.users;
    }

    public void addUser(User usern){

        for(User u:this.users){
            if(u.getEmail()==usern.getEmail()){
                System.out.print("Already exist account with the mail: "+u.getEmail());
            }else
                this.users.add(usern);
        }



    }

    public void removeUser(User usern){
        this.users.remove(usern);
    }

    public int accessSystem(String mail, String psw){

        for(User u:this.users){
            if(u.getEmail()==mail  && u.getPassword()==psw){
                return u.getId();
            }
        }
        return 0;

    }

    public void stamp(){

        for(User u:this.users){
            System.out.println(u.getFirstName());
        }
    }

}
