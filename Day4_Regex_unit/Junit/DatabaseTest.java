class DatabaseConnection {
    void connect() { System.out.println("Connected"); }
    void disconnect() { System.out.println("Disconnected"); }
}

public class DatabaseTest {
    public static void main(String[] args) {
        DatabaseConnection db = new DatabaseConnection();

        db.connect();
        System.out.println("Performing test...");
        db.disconnect();
    }
}