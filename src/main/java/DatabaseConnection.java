public class DatabaseConnection {
    private final String host;
    private final Integer port;

    public static Integer COUNT = 0;

    public DatabaseConnection(String host, Integer port) {
        this.host = host;
        this.port = port;

        System.out.println("Connection - " + COUNT);
        COUNT++;
    }

}
