package Inheritance.Lab.P03RandomArrayList;

public class Main {
    public static void main(String[] args) {
        RandomArrayList<Integer> randomArrayList = new RandomArrayList<>();

        randomArrayList.add(10);
        randomArrayList.add(20);
        randomArrayList.add(30);
        randomArrayList.add(40);
        randomArrayList.add(50);

        System.out.println(randomArrayList.getRandomElement());
        System.out.println(randomArrayList.getRandomElement());
    }
}
