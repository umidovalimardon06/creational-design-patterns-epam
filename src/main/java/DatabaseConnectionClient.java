public class DatabaseConnectionClient {
    public static void main(String[] args) {

        for (int i = 0; i < 11; i++) {
            DatabaseConnection databaseConnection = DatabaseConnection.getInstance();
            System.out.println(DatabaseConnection.COUNT);
        }

    }
}
