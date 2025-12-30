package entity;

public class Mouse {
    private final String brand;
    private final boolean isWired;
    private Integer dpi;
    private Integer weight;
    private Integer height;


    /* Telescoping constructors */
    public Mouse(String brand, boolean isWired) {
        this.brand = brand;
        this.isWired = isWired;
    }

    public Mouse(String brand, boolean isWired, Integer dpi) {
        this(brand, isWired);
        this.dpi = dpi;
    }

    public Mouse(String brand, boolean isWired, Integer dpi, Integer weight) {
        this(brand, isWired, dpi);
        this.weight = weight;
    }

    public Mouse(String brand, boolean isWired, Integer dpi, Integer weight, Integer height) {
        this(brand, isWired, dpi, weight);
        this.height = height;
    }


    /* Getters */
    public String getBrand() {
        return brand;
    }

    public boolean isWired() {
        return isWired;
    }

    public Integer getDpi() {
        return dpi;
    }

    public Integer getHeight() {
        return height;
    }

    public Integer getWeight() {
        return weight;
    }

    /* Setters */
    public void setDpi(Integer dpi) {
        this.dpi = dpi;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }


}
