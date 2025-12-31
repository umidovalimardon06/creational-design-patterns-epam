public class Airplane implements Cloneable{
    public final String model;
    private final String engineSerial;
    private Integer flightHours;

    public Airplane(String model, int year) {
        this.model = model;
        this.engineSerial = "ENG-"+year;
        this.flightHours = 0;
    }

    public void fly(int hours) {
        this.flightHours = hours;
    }


    public String getInfo() {
        return "Airplane{" +
                "model='" + model + '\'' +
                ", engineSerial='" + engineSerial + '\'' +
                ", flightHours=" + flightHours +
                '}';
    }

    @Override
    public Airplane clone() {

        try {
            return (Airplane) super.clone();
        } catch (CloneNotSupportedException ex) {
            throw new AssertionError();
        }

    }
}
