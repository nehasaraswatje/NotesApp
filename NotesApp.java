import java.io.*;
import java.util.Scanner;

public class NotesApp {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int choice;

        while (true) {
            System.out.println("\n--- Notes App ---");
            System.out.println("1. Add Note");
            System.out.println("2. View Notes");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            choice = input.nextInt();
            input.nextLine(); // to consume the leftover newline

            if (choice == 1) {
                addNote(input);
            } else if (choice == 2) {
                readNotes();
            } else if (choice == 3) {
                System.out.println("Thank you for using Notes App.");
                break;
            } else {
                System.out.println("Invalid choice. Try again.");
            }
        }

        input.close();
    }

    // Method to add note
    public static void addNote(Scanner input) {
        System.out.print("Write your note: ");
        String note = input.nextLine();

        try {
            FileWriter fw = new FileWriter("notes.txt", true); // true = append mode
            fw.write(note + "\n");
            fw.close();
            System.out.println("Note added successfully.");
        } catch (IOException e) {
            System.out.println("Something went wrong while writing the note.");
        }
    }

    // Method to read notes
    public static void readNotes() {
        System.out.println("\n--- All Notes ---");

        try {
            BufferedReader br = new BufferedReader(new FileReader("notes.txt"));
            String line;

            while ((line = br.readLine()) != null) {
                System.out.println("- " + line);
            }

            br.close();
        } catch (FileNotFoundException e) {
            System.out.println("No notes found yet. Try adding some notes first.");
        } catch (IOException e) {
            System.out.println("Something went wrong while reading the notes.");
        }
    }
}
