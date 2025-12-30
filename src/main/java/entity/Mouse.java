package entity;

public class Mouse {
    private String brand;
    private boolean isWired;
    private Integer dpi;
    private Integer weight;
    private Integer height;

    private Mouse(MouseBuilder mouseBuilder) {
        this.brand = mouseBuilder.brand;
        this.isWired = mouseBuilder.isWired;
        this.dpi = mouseBuilder.dpi;
        this.weight = mouseBuilder.weight;
        this.height = mouseBuilder.height;
    }

    public static MouseBuilder builder(String brand, boolean isWired) {
        return new MouseBuilder(brand, isWired);
    }

    public static class MouseBuilder {
        private final String brand;
        private final boolean isWired;

        private Integer dpi;
        private Integer weight;
        private Integer height;


        private MouseBuilder(String brand, boolean isWired) {
            this.brand = brand;
            this.isWired = isWired;
        }


        public MouseBuilder dpi(Integer dpi) {
            this.dpi = dpi;
            return this;
        }

        public MouseBuilder height(Integer height) {
            this.height = height;
            return this;
        }

        public MouseBuilder weight(Integer weight) {
            this.weight = weight;
            return this;
        }

        public Mouse build() {
            return new Mouse(this);
        }
    }
}
