public class DatabaseConnectionClient {
    public static void main(String[] args) {

        for (int i = 0; i < 11; i++) {
            DatabaseConnection databaseConnection = new DatabaseConnection("host", 4324);
            System.out.println(DatabaseConnection.COUNT);
        }

    }
}
