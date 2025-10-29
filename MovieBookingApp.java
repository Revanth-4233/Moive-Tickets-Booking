import java.util.*;

class Movie {
    String title;
    String language;

    public Movie(String title, String language) {
        this.title = title;
        this.language = language;
    }
}

class Theater {
    String name;
    String location;
    List<Movie> movies;

    public Theater(String name, String location, List<Movie> movies) {
        this.name = name;
        this.location = location;
        this.movies = movies;
    }
}

class Seat {
    char row;
    int number;
    boolean booked;

    public Seat(char row, int number) {
        this.row = row;
        this.number = number;
        this.booked = false;
    }

    public String getSeatId() {
        return "" + row + number;
    }
}

public class MovieBookingApp {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        // Movies
        List<Movie> teluguMovies = new ArrayList<>();
        teluguMovies.add(new Movie("Devara: Part 1", "Telugu"));
        teluguMovies.add(new Movie("Pushpa 2: The Rule", "Telugu"));
        teluguMovies.add(new Movie("Game Changer", "Telugu"));
        teluguMovies.add(new Movie("Hari Hara Veera Mallu", "Telugu"));
        teluguMovies.add(new Movie("Lucky Bhaskar", "Telugu"));

        // Theaters by location
        Map<String, List<Theater>> cityTheaters = new HashMap<>();

        // Kandukur (Prakasam district, Andhra Pradesh)
        cityTheaters.put("Kandukur", Arrays.asList(
            new Theater("Sri Koteswara Theatre", "Kandukur", teluguMovies),
            new Theater("Yuvaraj Theatre", "Kandukur", teluguMovies),
            new Theater("Prasanthi Theatre", "Kandukur", teluguMovies)
        ));

        // Ongole (Prakasam district)
        cityTheaters.put("Ongole", Arrays.asList(
            new Theater("Gopi Theatre 4K Dolby", "Ongole", teluguMovies),
            new Theater("Krishna Theatre", "Ongole", teluguMovies),
            new Theater("Aruna A/C DTS", "Ongole", teluguMovies)
        ));

        // Guntur (Andhra Pradesh)
        cityTheaters.put("Guntur", Arrays.asList(
            new Theater("INOX – Guntur City Centre", "Guntur", teluguMovies),
            new Theater("Hollywood Multiplex", "Guntur", teluguMovies),
            new Theater("Venkat Cineplex", "Guntur", teluguMovies)
        ));

        // Nellore (Andhra Pradesh)
        cityTheaters.put("Nellore", Arrays.asList(
            new Theater("M1 Cinemas", "Nellore", teluguMovies),
            new Theater("Rama Krishna Picture Palace", "Nellore", teluguMovies),
            new Theater("S2 Cinemas", "Nellore", teluguMovies)
        ));

        System.out.println("Welcome to the Movie Ticket Booking System");
        System.out.println("------------------------------------------");

        while (true) {
            System.out.println("\nAvailable Cities:");
            int index = 1;
            List<String> cities = new ArrayList<>(cityTheaters.keySet());
            for (String city : cities) {
                System.out.println(index + ". " + city);
                index++;
            }
            System.out.println("0. Exit");
            System.out.print("Enter your choice (number): ");
            int cityChoice = sc.nextInt();
            sc.nextLine(); // consume newline

            if (cityChoice == 0) {
                System.out.println("Thank you for visiting!");
                break;
            }
            if (cityChoice < 1 || cityChoice > cities.size()) {
                System.out.println("Invalid choice! Try again.");
                continue;
            }

            String selectedCity = cities.get(cityChoice - 1);
            List<Theater> theaters = cityTheaters.get(selectedCity);

            System.out.println("\nTheaters in " + selectedCity + ":");
            for (int i = 0; i < theaters.size(); i++) {
                Theater t = theaters.get(i);
                System.out.println((i + 1) + ". " + t.name + " (" + t.location + ")");
            }
            System.out.print("Choose a theater (number): ");
            int thChoice = sc.nextInt();
            sc.nextLine();

            if (thChoice < 1 || thChoice > theaters.size()) {
                System.out.println("Invalid theater choice! Returning to city selection.");
                continue;
            }

            Theater selectedTheater = theaters.get(thChoice - 1);
            System.out.println("\nYou selected: " + selectedTheater.name + " located at " + selectedTheater.location);

            System.out.println("\nAvailable Movies:");
            for (int i = 0; i < selectedTheater.movies.size(); i++) {
                Movie m = selectedTheater.movies.get(i);
                System.out.println((i + 1) + ". " + m.title + " (" + m.language + ")");
            }
            System.out.print("Choose a movie (number): ");
            int movieChoice = sc.nextInt();
            sc.nextLine();

            if (movieChoice < 1 || movieChoice > selectedTheater.movies.size()) {
                System.out.println("Invalid movie choice! Returning to theater selection.");
                continue;
            }

            Movie selectedMovie = selectedTheater.movies.get(movieChoice - 1);
            System.out.println("\nYou chose: " + selectedMovie.title + " (" + selectedMovie.language + ")");

            // Seat layout
            Seat[][] seats = createSeats();
            System.out.println("\nAvailable Seats (O = Open, X = Booked):");
            displaySeats(seats);

            System.out.print("How many seats would you like to book? ");
            int numSeats = sc.nextInt();
            sc.nextLine();
            List<String> bookedSeats = new ArrayList<>();

            for (int i = 0; i < numSeats; i++) {
                System.out.print("Enter seat (e.g., A3): ");
                String seatId = sc.next().toUpperCase();
                if (bookSeat(seats, seatId)) {
                    bookedSeats.add(seatId);
                } else {
                    System.out.println("Seat not available or invalid. Try again.");
                    i--;
                }
            }

            System.out.println("\nBooking Confirmed!");
            System.out.println("City       : " + selectedCity);
            System.out.println("Theater    : " + selectedTheater.name);
            System.out.println("Movie      : " + selectedMovie.title);
            System.out.println("Seats      : " + bookedSeats);
            System.out.println("Total Cost : ₹" + (numSeats * 150));
            System.out.println("Enjoy your movie!\n");
        }

        sc.close();
    }

    public static Seat[][] createSeats() {
        Seat[][] seats = new Seat[5][5];
        for (int i = 0; i < seats.length; i++) {
            char row = (char) ('A' + i);
            for (int j = 0; j < seats[i].length; j++) {
                seats[i][j] = new Seat(row, j + 1);
            }
        }
        return seats;
    }

    public static void displaySeats(Seat[][] seats) {
        for (Seat[] row : seats) {
            for (Seat s : row) {
                System.out.print((s.booked ? "X " : "O "));
            }
            System.out.println();
        }
        System.out.println("Rows: A–E | Columns: 1–5");
    }

    public static boolean bookSeat(Seat[][] seats, String seatId) {
        for (Seat[] row : seats) {
            for (Seat s : row) {
                if (s.getSeatId().equals(seatId)) {
                    if (!s.booked) {
                        s.booked = true;
                        return true;
                    } else {
                        return false;
                    }
                }
            }
        }
        return false;
    }
}
