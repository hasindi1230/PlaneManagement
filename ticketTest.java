
import java.io.FileWriter;
import java.io.IOException;

public class ticketTest {
    private static String seat_row;
    private static int seat_index;
    private static int price;
    public static ticketTest[] ticket = new ticketTest[100];
    private static String name;
    private static String surname;
    private static String email;
    public static Person person;

    public ticketTest(String seat_row, int seat_index, int price, String name, String surname, String email){
        ticketTest.seat_row = seat_row;
        ticketTest.seat_index = seat_index;
        ticketTest.price = price;
        ticketTest.name = name;
        ticketTest.surname = surname;
        ticketTest.email = email;
        ticketTest.person = new Person(name,surname,email);
    }
    public String getSeat_row(){
        return seat_row;
    }

    public void setSeat_row(String seat_row){
        ticketTest.seat_row = seat_row;
    }

    public int getSeat_index(){
        return (seat_index+1);
    }

    public void setSeat_index(int seat_index){
        ticketTest.seat_index = seat_index;
    }

    public static int getPrice(){
        int price=0;
        if (seat_row.matches("[A-D]")){
            if(seat_index>=1 && seat_index<=5){
                price = 200;
            }
            else if (seat_index>=6 && seat_index<=9){
                price = 150;
            }
            else{
                price = 180;
            }
        }
        return price;
    }

    public void setPrice(int price){
        ticketTest.price = price;
    }

    public static String getName(){
        return name;
    }
    public static String getSurname(){
        return surname;
    }
    public static String getEmail(){
        return email;
    }
    public  Person getPerson(){
        return person;
    }



    public static void  print_ticket_info(){
        System.out.println("\n");
        System.out.println("Information of the tickets sold:");
        int total_sales=0;
        for (int i =0; i<ticket.length; i++) {
            if (ticket[i] != null) {
                ticketTest tickets = ticket[i];
                System.out.println("\n");
                //creating a person object for each ticket
                Person person = new Person(Person.getName(), Person.getSurname(), Person.getEmail());
                System.out.println("Name of the person is: " + " " + Person.getName() + " " + Person.getSurname());
                System.out.println("Email is " + " " + Person.getEmail());

                System.out.println("Ticket" + (i + 1) + ":");
                System.out.print("Row:" + tickets.getSeat_row() + " ");
                System.out.println("Seat:" + tickets.getSeat_index());
                System.out.println("Price:" + getPrice() + "£");
                System.out.println("\n");
                total_sales = total_sales + getPrice();
                System.out.println("Total sales is: " + " " + total_sales);
            }
        }
    }



    public static void ticket_info(){
        System.out.println("Information of the ticket is as follows: ");
        System.out.println("The row you booked is : " + seat_row);
        System.out.println("The seat is: " + (seat_index+1));
        System.out.println("The price is" + " " + getPrice() + "£");

    }

    public static void save(){
        String file_name = seat_row + seat_index + ".txt";
        try{
            FileWriter my_file = new FileWriter(file_name);
            my_file.write("Person Information:");
            my_file.write("\n");
            my_file.write("Name is:" + Person.getName() + " " + Person.getSurname());
            my_file.write("\n");
            my_file.write("Email is: " + Person.getEmail());
            my_file.write("\n");
            my_file.write("\n");
            my_file.write("Ticket Information");
            my_file.write("\n");
            my_file.write("Seat row :" + seat_row + " ");
            my_file.write("Seat Index: " + (seat_index));
            my_file.write("\n");
            my_file.write("Price of the ticket is: " + getPrice());

            my_file.close();
        }catch (IOException e){
            System.out.println("Error");
        }
    }

}

