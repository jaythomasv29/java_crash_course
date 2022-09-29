package unit_testing;

public class Movie {
    private String name;
    private String format;
    private double rating;
    private double sellingPrice;
    private double rentalPrice;
    private boolean isAvailable;

    public Movie(String name, String format, double rating) {
        setName(name);
        setFormat(format);
        setRating(rating);
        setSellingPrice();
        setRentalPrice();
        this.isAvailable = true;


    }

    public void setName(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("name cannot be blank");
        }
        this.name = name;
    }

    public void setFormat(String format) {
        if (!(format.equals("DVD") || format.equals("Blue-Ray"))) {
            throw new IllegalArgumentException("format must be DVD or Blue-Ray");
        }
        this.format = format;
    }

    public void setRating(double rating) {
        if (rating < 0 || rating > 10) {
            throw new IllegalArgumentException("invalid rating");
        }
        this.rating = rating;
    }

    public double setSellingPrice() {
        return (this.format.equals("BlueRay")) ? 4.25 : 2.25;
    }

    public double setRentalPrice() {
        return (this.format.equals("BlueRay")) ? 2.99 : 0.25;
    }

    public boolean setIsAvailable() {
        return !isAvailable;
    }

    public String getName() {
        return name;
    }

    public String getFormat() {
        return format;
    }

    public double getRating() {
        return rating;
    }

    public double getSellingPrice() {
        return sellingPrice;
    }

    public double getRentalPrice() {
        return rentalPrice;
    }

    public boolean isAvailable() {
        return isAvailable;
    }
}
