public class Person{
    private String name;
    private String surname;
    private String email;

    //constructors

    public Person(String name , String surname, String email){
        this.name = name;
        this.surname = surname;
        this.email = email;
    }

    //getters and setters
    public String getName(){
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname(){
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail(){
        return email;
    }
    public void setEmail(String email){
        this.email = email;
    }

    //method to print info
    public void person_info(){
        System.out.println("Your name : " + name);
        System.out.println("Your surname :" + surname);
        System.out.println("Your email address : " + email);
    }
}



