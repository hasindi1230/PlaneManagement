
import java.io.FileWriter;
import java.io.IOException;

public class ticketTest {
    private String seat_row;
    private int seat_index;
    private int price;
    public static ticketTest[] ticket = new ticketTest[100];
    private String name;
    private String surname;
    private String email;
    public Person person;

    public ticketTest(String seat_row, int seat_index, int price, String name, String surname, String email){
        this.seat_row = seat_row;
        this.seat_index = seat_index;
        this.price = price;
        this.person = new Person(name,surname,email);
    }
    public String getSeat_row(){
        return seat_row;
    }
    public int getSeat_index(){
        return (seat_index+1);
    }

    public int getPrice(){
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

    public String getName(){
        return name;
    }
    public String getSurname(){
        return surname;
    }
    public String getEmail(){
        return email;
    }
    public  Person getPerson(){
        return person;
    }
    public String getRow() {
        return seat_row;
    }
    public int getSeat() {
        return seat_index;
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
                System.out.println("Name of the person is: " + " " + tickets.person.getName() + " " + tickets.person.getSurname());
                System.out.println("Email is " + " " + tickets.person.getEmail());

                System.out.println("Ticket" + (i + 1) + ":");
                System.out.print("Row:" + tickets.getSeat_row() + " ");
                System.out.println("Seat:" + tickets.getSeat_index());
                System.out.println("Price:" + tickets.getPrice() + "£");
                System.out.println("\n");
                total_sales = total_sales + tickets.getPrice();
                System.out.println("Total sales is: " + " " + total_sales);
            }
        }
    }



    public void ticket_info(){
        System.out.println("Information of the ticket is as follows: ");
        System.out.println("The row you booked is : " + seat_row);
        System.out.println("The seat is: " + (seat_index+1));
        System.out.println("The price is" + " " + getPrice() + "£");

    }

    public void save(){
        String file_name = seat_row + seat_index + ".txt";
        try{
            FileWriter my_file = new FileWriter(file_name);
            my_file.write("Person Information:");
            my_file.write("\n");
            my_file.write("Name is:" + person.getName() + " " + person.getSurname());
            my_file.write("\n");
            my_file.write("Email is: " + person.getEmail());
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

