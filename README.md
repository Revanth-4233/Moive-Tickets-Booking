 Movie Ticket Booking System (Java Console App)
-> Overview

This is a console-based movie ticket booking application built using Java.
It allows users to:

Select a location

Choose a theater

Pick a movie

Book available seats

The program uses Object-Oriented Programming (OOP) principles and Java Collections Framework for efficient data handling.
It simulates a simplified version of an online movie ticket booking system like BookMyShow.

 Features

 Select Location (Kandukur, Ongole, Guntur, Nellore)
-> View Available Theaters in Each Location
-> Choose a Movie from the List of Telugu Movies
-> Interactive Seat Booking (5×5 Grid)
-> Prevents Double Booking
->Displays Confirmed Booking Details

** Locations & Theaters
Location	Theaters
Kandukur	Sri Koteswara Theatre, Yuvaraj Theatre
Ongole	Gopi Theatre 4K Dolby, Krishna Theatre
Guntur	Venkateswara Cineplex, Navabharath Theatre
Nellore	Rama Cinemas, S2 Cinemas
 Telugu Movies Included

Game Changer

Devara: Part 1

Pushpa 2: The Rule

Hari Hara Veera Mallu

Lucky Bhaskar

**Concepts Used
Concept Type	Description
OOP Concepts	Classes, Objects, Constructors, Encapsulation, Composition
Collections	ArrayList, HashMap, List, Arrays.asList()
Control Flow	if-else, for, while, break, continue
Input/Output	Scanner for user input
2D Arrays	Seat layout (5 rows × 5 columns)
Methods	Reusable functions (createSeats(), bookSeat(), displaySeats())

**How to Run the Program
* Prerequisites

Make sure you have:

Java JDK 8+ installed

A terminal or command prompt

 Steps:-

Open the terminal in your project directory

Compile the Java file:

javac MovieBookingApp.java


Run the program:

java MovieBookingApp

** Sample Output
Welcome to the Movie Ticket Booking System
------------------------------------------

Select Location:
1. Kandukur
2. Ongole
3. Guntur
4. Nellore
Enter your choice (0 to exit): 1

You selected: Kandukur
Available Theaters:
1. Sri Koteswara Theatre
2. Yuvaraj Theatre

Available Movies:
1. Devara: Part 1
2. Pushpa 2: The Rule
3. Game Changer
Choose a movie: 2

Available Seats (O = Open, X = Booked)
O O O O O
O O O O O
O O O O O
O O O O O
O O O O O
Rows: A–E | Columns: 1–5

How many seats do you want to book? 2
Enter seat (e.g., A3): A1
Enter seat (e.g., A3): A2

Booking Confirmed!
Movie: Pushpa 2: The Rule
Theater: Sri Koteswara Theatre (Kandukur)
Seats: [A1, A2]
Enjoy your movie!

** Project Structure
* MovieTicketBookingSystem
│
├── -> MovieBookingApp.java      # Main Program
├── -> README.md                 # Documentation (this file)
└── -> Seat, Movie, Theater Classes

 Future Enhancements

Add multiple showtimes

Include ticket pricing and total amount

Save bookings to a file or database

Add cancellation feature

GUI version using JavaFX or Swing

** Author

Mukesh Revanth
 Email: mukeshrevanth94@gmail.com
 GitHub: Revanth-4233
