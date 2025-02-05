public class Person{
    public static String name;
    public static String surname;
    public static String email;

    //constructors

    public Person(String name , String surname, String email){
        Person.name = name;
        Person.surname = surname;
        Person.email = email;
    }

    //getters and setters
    public static String getName(){
        return name;
    }

    public void setName(String name){
        Person.name = name;
    }
    public static String getSurname(){
        return surname;
    }

    public void setSurname(String surname){
        Person.surname = surname;
    }
    public static String getEmail(){
        return email;
    }

    public void setEmail(String email){
        Person.email = email;
    }

    //method to print info
    public static void person_info(){
        System.out.println("Your name : " + name);
        System.out.println("Your surname :" + surname);
        System.out.println("Your email address : " + email);
    }
}



