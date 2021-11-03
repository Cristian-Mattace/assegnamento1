package assegnamento;

//import java.io.Serializable;

/**
 *
 * The class {@code User} provides an implementation of a
 * simplified model of an employee that satisfies JavaBean conventions.
 *
**/
public class User// implements Serializable
{
  //private static final long serialVersionUID = 1L;

  private int id;
  private String firstName;
  private String lastName;
  private String email;
  private String password;
  private boolean employee;

  /**
   * Class constructor.
   *
  **/
  public User()
  {
    this.id        = 0;
    this.firstName = "";
    this.lastName  = "";
    this.email     = "";
    this.password = "";
    this.employee = false;
  }

  /**
   * Class constructor.
   *
   * @param i    the user's id.
   * @param fName    the user'sfirst name.
   * @param lName    the user's last name.
   * @param e    the user's email address.
   * @param psw  the user's password.
   * @param empl   the user's type.
   *
  **/
  public User(final int i, final String fName, final String lName, final String e, final String psw, final boolean empl)
  {
    this.id        = i;
    this.firstName = fName;
    this.lastName  = lName;
    this.email     = e;
    this.password  = psw;
    this.employee  = empl;
  }

  /**
   * Gets the user's identifier.
   *
   * @return the identifier.
   *
  **/
  public int getId()
  {
    return this.id;
  }

  /**
   * Sets the user's identifier.
   *
   * @param i  the identifier.
   *
  **/
  public void setId(final int i)
  {
    this.id = i;
  }

  /**
   * Gets the user's first name.
   *
   * @return the salary.
   *
  **/
  public String getFirstName()
  {
    return this.firstName;
  }

  /**
   * Sets the user's first name.
   *
   * @param f  the first name.
   *
  **/
  public void setFirstName(final String f)
  {
    this.firstName = f;
  }

  /**
   * Gets  the user's last name.
   *
   * @return the last name.
   *
  **/
  public String getLastName()
  {
    return this.lastName;
  }

  /**
   * Sets the user's last name.
   *
   * @param l the last name.
   *
  **/
  public void setLastName(final String l)
  {
    this.lastName = l;
  }

  /**
   * Gets the user's email address.
   *
   * @return the address.
   *
  **/
  public String getEmail()
  {
    return this.email;
  }

  /**
   * Sets the user's email address.
   *
   * @param e  the address.
   *
  **/
  public void setEmail(final String e)
  {
    this.email = e;
  }

  /**
   * Gets the user's password.
   *
   * @return the password.
   *
   **/
  public String getPassword()
  {
    return this.password;
  }

  /**
   * Sets the user's email address.
   *
   * @param p  the address.
   *
   **/
  public void setPassword(final String p)
  {
    this.password = p;
  }


  public Boolean getEmployee()
  {
    return this.employee;
  }

  /**
   * Sets the user's email address.
   *
   * @param em  the address.
   *
   **/
  public void setEmployee(final boolean em)
  {
    this.employee = em;
  }
}
