public class Airplane {
    public String model;
    private String engineSerial;
    private Integer flightHours;

    public Airplane(String model, int year) {
        this.model = model;
        this.engineSerial = "ENG-"+year;
        this.flightHours = 0;
    }

    public Airplane(Airplane others) {
        this.model = others.model;
        this.engineSerial = others.engineSerial;
        this.flightHours = others.flightHours;
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

}
