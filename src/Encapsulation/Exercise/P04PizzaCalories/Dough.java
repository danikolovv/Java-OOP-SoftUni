package Encapsulation.Exercise.P04PizzaCalories;

public class Dough {

    private static final double BASE_CALORIES_PER_GRAM = 2.0;
    private static final double WHITE_DOUGH_MODIFIER = 1.5;
    private static final double WHOLEGRAIN_DOUGH_MODIFIER = 1.0;
    private static final double CRISPY_DOUGH_MODIFIER = 0.9;
    private static final double CHEWY_DOUGH_MODIFIER = 1.1;
    private static final double HOMEMADE_DOUGH_MODIFIER = 1.0;

    private String flourType;
    private String bakingTechnique;
    private double weight;

    public Dough(String flourType, String bakingTechnique, double weight) {
        this.setFlourType(flourType);
        this.setBakingTechnique(bakingTechnique);
        this.setWeight(weight);
    }

    public void setFlourType(String flourType) {
        if (!flourType.equals("White") && !flourType.equals("Wholegrain")) {
            throw new IllegalArgumentException("Invalid type of dough.");
        }
        this.flourType = flourType;
    }

    public void setBakingTechnique(String bakingTechnique) {
        if (!bakingTechnique.equals("Crispy") && !bakingTechnique.equals("Chewy") && !bakingTechnique.equals("Homemade")) {
            throw new IllegalArgumentException("Invalid type of dough.");
        }
        this.bakingTechnique = bakingTechnique;
    }

    public void setWeight(double weight) {
        if (weight < 1 || weight > 200) {
            throw new IllegalArgumentException("Dough weight should be in the range [1..200].");
        }
        this.weight = weight;
    }

    public double calculateCalories() {
        double modifier = 0;
        if (flourType.equals("White")) {
            modifier = WHITE_DOUGH_MODIFIER;
        } else if (flourType.equals("Wholegrain")) {
            modifier = WHOLEGRAIN_DOUGH_MODIFIER;
        }

        if (bakingTechnique.equals("Crispy")) {
            modifier *= CRISPY_DOUGH_MODIFIER;
        } else if (bakingTechnique.equals("Chewy")) {
            modifier *= CHEWY_DOUGH_MODIFIER;
        } else if (bakingTechnique.equals("Homemade")) {
            modifier *= HOMEMADE_DOUGH_MODIFIER;
        }

        return BASE_CALORIES_PER_GRAM * weight * modifier;
    }
}
