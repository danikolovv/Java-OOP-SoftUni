package Encapsulation.Exercise.P01ClassBoxDataValidation;

public class Box {
    private double length;
    private double width;
    private double height;

    public Box(double length, double width, double height) {
        this.setLength(length);
        this.setWidth(width);
        this.setHeight(height);
    }

    private void setLength(double length) {
        if (length <= 0) {
            validation("Length");
        }
        this.length = length;
    }

    private void setWidth(double width) {
        if (width <= 0) {
            validation("Width");
        }
        this.width = width;
    }

    private void setHeight(double height) {
        if (height <= 0) {
            validation("Height");
        }
        this.height = height;
    }

    private static void validation(String prefix) {
        throw new IllegalStateException(String.format("%s cannot be zero or negative.", prefix));
    }

    public double getLength() {
        return length;
    }

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }

    public double calculateSurfaceArea() {
        // 2lw + 2lh + 2wh
        return 2 * getLength() * getWidth() + 2 * getLength() * getHeight() + 2 * getWidth() * getHeight();
    }

    public double calculateLateralSurfaceArea() {
        // 2lh + 2wh
        return 2 * getLength() * getHeight() + 2 * getWidth() * getHeight();
    }

    public double calculateVolume() {
        // lwh
        return getLength() * getWidth() * getHeight();
    }
}
