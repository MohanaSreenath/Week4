class TemperatureConverter {
    public double celsiusToFahrenheit(double celsius) { return (celsius * 9/5) + 32; }
    public double fahrenheitToCelsius(double fahrenheit) { return (fahrenheit - 32) * 5/9; }
}

public class TemperatureConverterTest {
    public static void main(String[] args) {
        TemperatureConverter converter = new TemperatureConverter();

        System.out.println("Celsius to Fahrenheit: " + converter.celsiusToFahrenheit(25));
        System.out.println("Fahrenheit to Celsius: " + converter.fahrenheitToCelsius(77));
    }
}