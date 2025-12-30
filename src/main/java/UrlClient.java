public class UrlClient {
    public static void main(String[] args) {
        Url url1 = Url.builder("https://", "mywebsite")
                .port(8080)
                .pathParam("/company")
                .build();

        Url url2 = Url.builder("https://", "binance")
                .port(8080)
                .pathParam("/wallet")
                .build();

        System.out.println(url1.toString());
        System.out.println(url2.toString());

    }
}
