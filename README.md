# Plane Ticket Management System

## Overview
This project is a **Plane Ticket Management System** that allows users to book, search, and manage flight tickets. It ensures seat availability, assigns ticket prices dynamically, and maintains passenger details for each booked ticket.

## Features
- Book a ticket with personal details (Name, Surname, Email)
- System assigns ticket prices based on seat location
- Search for a booked ticket using seat row and index
- Display passenger and ticket details
- Prevent duplicate bookings
- Save and retrieve ticket information

## Technologies Used
- **Java** for backend logic
- **Scanner** for user input handling
- **Array-based storage** for ticket management

## Installation
1. Clone the repository:
   ```sh
   git clone https://github.com/yourusername/your-repository.git
   ```
2. Navigate to the project folder:
   ```sh
   cd PlaneTicketManagement
   ```
3. Compile the Java files:
   ```sh
   javac Main.java
   ```
4. Run the program:
   ```sh
   java Main
   ```

## Usage
1. **Booking a Ticket:**
   - Enter your personal details.
   - Choose a seat row (A-D) and a seat number.
   - The system will assign a price and store the ticket.
   
2. **Searching for a Ticket:**
   - Input the seat row and seat number.
   - The system retrieves and displays ticket details if found.
   
3. **Ticket Price Calculation:**
   - Seats **1-5**: $200
   - Seats **6-9**: $150
   - Other seats: $180

## Debugging
If you face issues with ticket searching:
- Ensure that tickets are stored properly after booking.
- Use print statements to verify the ticket list.
- Confirm that seat row and index comparisons match correctly.

## Future Enhancements
- Implement a database for ticket storage.
- Add a graphical user interface (GUI).
- Integrate online payment functionality.

## License
This project is licensed under the MIT License.

