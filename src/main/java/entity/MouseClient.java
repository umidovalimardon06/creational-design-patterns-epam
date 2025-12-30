package entity;

public class MouseClient {
    public static void main(String[] args) {
        Mouse mouse1 = Mouse.builder("METO",false)
                .dpi(400)
                .build();

        Mouse mouse2 = Mouse.builder("ASUS-PI",true)
                .height(2)
                .build();



    }
}
