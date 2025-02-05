import java.util.*;

public class w2053771_PlaneManagement {
    public static final int rows = 4;
    public static final int[] seats_per_row = {14,12,14,12};
    public static final char[] labels = {'A', 'B', 'C', 'D'};
    public static final boolean[][] seats = new boolean[rows][];
    public static ticketTest[] tickets = new ticketTest[rows * seats_per_row[0]];
    public static int num_of_tickets_sold;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        //printing the welcome message
        System.out.println("Welcome to the Plane Management Application ");
        System.out.println("\n");
        initializing_seats();
        int option;

        do{
            menu();
            //prompting the user to enter an option
            System.out.println("Please enter a number from 0-6");
            option = input.nextInt();

            switch (option) {

                case 1:
                    buy_seats();
                    break;
                case 2:
                    cancel_seat();
                    break;
                case 3:
                    first_available();
                    break;
                case 4:
                    seating_plan();
                    break;
                case 5:
                    ticketTest.print_ticket_info();
                    break;
                case 6:
                    search_ticket();
                    break;
                case 0:
                    System.out.println("Quiting the program");
                    return;
                default:
                    System.out.println("Invalid Option");
            }
            System.out.println("\n");
        }while (option!=0);
    }
    private static void initializing_seats(){
        for (int i=0 ; i<rows; i++){
            seats[i] = new boolean[seats_per_row[i]];
        }
    }

    private static void menu(){
        System.out.println("********************************************");
        System.out.println("*              Menu Options                *");
        System.out.println("********************************************");
        System.out.println("  1) Buy  a seat ");
        System.out.println("  2) Cancel a seat");
        System.out.println("  3) Find first available seat");
        System.out.println("  4) Show seating plan");
        System.out.println("  5) Print ticket information and total sales");
        System.out.println("  6) Search Ticket");
        System.out.println("  0) Quit");
    }

    private static void seating_plan(){
        for (int i=0 ; i<rows ; i++){
            System.out.print(labels[i] + " ");
            for (int j=0 ; j<seats_per_row[i]; j++ ){
                if (!seats[i][j]){
                    System.out.print("O");
                }
                else{
                    System.out.print("X");
                }
            }
            System.out.println();
        }
    }

    private static void buy_seats() {
        Scanner input = new Scanner(System.in);


        //getting the personal details from the user

        System.out.println("Your name : ");
        String name = input.next();

        System.out.println("Your surname :" );
        String surname = input.next();

        System.out.println("Your email address : ");
        String email = input.next();

        System.out.println("\n");

        //person object
        Person info = new Person(name, surname, email);
        System.out.println("\n");

        System.out.println("Enter a row letter A,B,C or D");
        String seat_row = input.next().toUpperCase();

        if(!seat_row.matches("[A-D]")){
            System.out.println("Invalid row letter");
            return;
        }

        System.out.println("Enter the seat number");
        int seat_index = input.nextInt() - 1;

        if (seat_index < 0 || seat_index > seats_per_row[seat_row.charAt(0)-'A']) {
            System.out.println("Invalid seat selection");
            return;
        }
        if (!seats[seat_row.charAt(0)- 'A'][seat_index]) {
            seats[seat_row.charAt(0) - 'A'][seat_index] = true;
            System.out.println("Seat reserved");
            //NEWWWW
            System.out.println("Information of the person is as follows: ");
            Person.person_info();
            int price=0;

            //adding a new ticket
            add_a_new_ticket(seat_row,seat_index,price);
            System.out.println("\n");

            ticketTest tick = new ticketTest(seat_row, seat_index, price, name,surname,email);
            ticketTest.ticket_info();

            System.out.println("Ticket booked successfully!!!");
            ticketTest.save();

            num_of_tickets_sold++;

        } else {
            System.out.println("Seat is already reserved and the ticket is already sold out");
        }
    }

    public static void add_a_new_ticket(String seat_row, int seat_index, int price){
        for (int i = 0; i< ticketTest.ticket.length; i++){
            if (ticketTest.ticket[i] == null){
                ticketTest.ticket[i] = new ticketTest(seat_row, seat_index , price, ticketTest.getName(),ticketTest.getSurname(),ticketTest.getEmail() );
                break;
            }
        }
    }


    private static void cancel_seat(){
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the letter of the row that you want to cancel");
        String cancel_row = input.next().toUpperCase();

        if(!cancel_row.matches("[A-D]")){
            System.out.println("Invalid row letter");
            return;
        }

        System.out.println("Enter the seat number that you want to cancel");
        int cancel_seat = input.nextInt()-1;

        if(cancel_seat < 0 || cancel_seat>seats_per_row[cancel_row.charAt(0)-'A'] ){
            System.out.println("Invalid seat");

        }

        if(!seats[cancel_row.charAt(0)- 'A'][cancel_seat]){
            System.out.println("Seat" + " " + cancel_row +  (cancel_seat+1) + " " + "is not reserved");
        }else{
            seats[cancel_row.charAt(0) - 'A'][cancel_seat] = false;
            System.out.println("Ticket is cancelled successfully!!!");
            num_of_tickets_sold--;
        }
    }

    private static void first_available(){
        boolean seat_available = false;
        for (int i=0; i<rows; i++) {
            for (int j = 0; j < seats_per_row[i]; j++) {
                if (!seats[i][j]) {
                    System.out.println("The first available seat is" + " " + "row" + labels[i] + " " + "seat" + (j + 1));
                    seat_available = true;
                    break;
                }
            }

            if (seat_available) {
                break;
            }
        }
        if (!seat_available){
            System.out.println("No available seats");
        }
    }

    private static void search_ticket(){
        Scanner input = new Scanner(System.in);
        System.out.println("Input a row letter (A-D) :");
        String search_row = input.next().toUpperCase();

        if(!search_row.matches("[A-D]")){
            System.out.println("Invalid row letter");
        }

        System.out.println("Enter the seat number:");
        int search_seat = input.nextInt();

        if(search_seat< 0 || search_seat> seats_per_row[search_row.charAt(0)-'A']){
            System.out.println("Invalid seat selection");
        }
        if (seats[search_row.charAt(0)-'A'][search_seat]){
            System.out.println("Seat has not been booked and is already available");
        }
        else{
            System.out.println("Ticket has already been purchased.");
            System.out.println("Details of the person who purchased the ticket is as follows:");
            System.out.println("Name is: " + " " + ticketTest.getName() + " " + ticketTest.getSurname());
            System.out.println("Email is: " + " " + ticketTest.getEmail());
            System.out.println("\n");
            System.out.println("Ticket information is as follows:");
            ticketTest.ticket_info();

        }



    }


}

