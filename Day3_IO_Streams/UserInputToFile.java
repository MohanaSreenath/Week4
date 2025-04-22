import java.io.*;

public class UserInputToFile {

    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        try {
            System.out.print("Enter your name: ");
            String name = reader.readLine();

            System.out.print("Enter your age: ");
            int age = Integer.parseInt(reader.readLine());

            System.out.print("Enter your favorite programming language: ");
            String language = reader.readLine();

            try (FileWriter writer = new FileWriter("user_data.txt")) {
                writer.write("Name: " + name + "\nAge: " + age + "\nFavorite Language: " + language);
                System.out.println("Data saved successfully in user_data.txt.");
            }
        } catch (IOException e) {
            System.out.println("Error reading input or writing file.");
        }
    }
}