public class AirplaneClient {
    public static void main(String[] args) {
        Airplane original = new Airplane("Cessna 172",2020);
        original.fly(150);

        System.out.println("Original: "+original.getInfo());
        Airplane copy = new Airplane(original);

        System.out.println("Copy: "+copy.getInfo());

    }
}
