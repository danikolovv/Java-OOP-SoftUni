package InterfacesAndAbstraction.Exercise.P05Тelephony;

import java.util.List;

public class Smartphone implements Callable, Browsable{

    private List<String> numbers;
    private List<String> urls;

    public Smartphone (List<String> numbers, List<String> urls) {
        this.numbers = numbers;
        this.urls = urls;
    }

    @Override
    public String call() {
        StringBuilder result = new StringBuilder();
        for (String number : numbers) {
            if (isValidNumber(number)) {
                result.append("Calling... ").append(number).append(System.lineSeparator());
            } else {
                result.append("Invalid number!").append(System.lineSeparator());
            }
        }
        return result.toString();
    }

    @Override
    public String browse() {
        StringBuilder result = new StringBuilder();
        for (String url : urls) {
            if (isValidURL(url)) {
                result.append("Browsing: ").append(url).append("!").append(System.lineSeparator());
            } else {
                result.append("Invalid URL!").append(System.lineSeparator());
            }
        }
        return result.toString();
    }

    private boolean isValidNumber(String number) {
        return number.matches("\\d+");
    }

    private boolean isValidURL(String url) {
        return url.matches("[a-zA-Z:/\\.]+");
    }
}
