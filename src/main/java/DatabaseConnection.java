import javax.xml.crypto.Data;

public class DatabaseConnection {
    private static DatabaseConnection INSTANCE;
    private final String host;
    private final Integer port;

    public static Integer COUNT = 0;

    private DatabaseConnection(String host, Integer port) {
        this.host = host;
        this.port = port;

        System.out.println("Connection - " + COUNT);
        COUNT++;
    }

    public static DatabaseConnection getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new DatabaseConnection("host",1111);
        }
        return INSTANCE;
    }

}
