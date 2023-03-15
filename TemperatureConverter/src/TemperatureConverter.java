import java.util.Scanner;

interface Temperature {
    double toCelsius(double temperature);
    double toFahrenheit(double temperature);
}

class Celsius implements Temperature {
    public double toCelsius(double temperature) {
        return temperature;
    }

    public double toFahrenheit(double temperature) {
        return (temperature * 1.8) + 32;
    }
}

class Fahrenheit implements Temperature {
    public double toCelsius(double temperature) {
        return (temperature - 32) / 1.8;
    }

    public double toFahrenheit(double temperature) {
        return temperature;
    }
}

class Kelvin implements Temperature {
    public double toCelsius(double temperature) {
        return temperature - 273.15;
    }

    public double toFahrenheit(double temperature) {
        return (temperature * 1.8) - 459.67;
    }
}

class Rankine implements Temperature {
    public double toCelsius(double temperature) {
        return (temperature - 491.67) / 1.8;
    }

    public double toFahrenheit(double temperature) {
        return temperature - 459.67;
    }
}

class Reaumur implements Temperature {
    public double toCelsius(double temperature) {
        return temperature / 0.8;
    }

    public double toFahrenheit(double temperature) {
        return (temperature * 2.25) + 32;
    }
}

class Delisle implements Temperature {
    public double toCelsius(double temperature) {
        return 100 - (temperature / 1.5);
    }

    public double toFahrenheit(double temperature) {
        return (212 - (temperature * 1.2));
    }
}

interface UserInput {
    double getInput();
}

class ConsoleInput implements UserInput {
    public double getInput() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a temperature: ");
        double temperature = scanner.nextDouble();
        return temperature;
    }
}

public class TemperatureConverter {
    public static void main(String[] args) {
        UserInput userInput = new ConsoleInput();
        double temperature = userInput.getInput();

        Temperature celsiusConverter = new Celsius();
        Temperature fahrenheitConverter = new Fahrenheit();
        Temperature kelvinConverter = new Kelvin();
        Temperature rankineConverter = new Rankine();
        Temperature reaumurConverter = new Reaumur();
        Temperature delisleConverter = new Delisle();

        System.out.println("Temperature Conversion Menu:");
        System.out.println("1. Celsius to Fahrenheit");
        System.out.println("2. Fahrenheit to Celsius");
        System.out.println("3. Celsius to Kelvin");
        System.out.println("4. Kelvin to Celsius");
        System.out.println("5. Fahrenheit to Kelvin");
        System.out.println("6. Kelvin to Fahrenheit");
        System.out.println("7. Celsius to Rankine");
        System.out.println("8. Rankine to Celsius");
        System.out.println("9. Celsius to Reaumur");
        System.out.println("10. Reaumur to Celsius");
        System.out.println("11. Celsius to Delisle");
        System.out.println("12. Delisle to Celsius");

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();

        double celsius = 0, fahrenheit = 0, kelvin = 0, rankine = 0, reaumur = 0, delisle = 0;
        switch (choice) {
            case 1:
                fahrenheit = fahrenheitConverter.toFahrenheit(temperature);
                System.out.printf("%.2f Celsius = %.2f Fahrenheit\n", temperature, fahrenheit);
                break;
            case 2:
                celsius = celsiusConverter.toCelsius(temperature);
                System.out.printf("%.2f Fahrenheit = %.2f Celsius\n", temperature, celsius);
                break;
            case 3:
                kelvin = kelvinConverter.toCelsius(temperature);
                System.out.printf("%.2f Celsius = %.2f Kelvin\n", temperature, kelvin);
                break;
            case 4:
                celsius = kelvinConverter.toCelsius(temperature);
                System.out.printf("%.2f Kelvin = %.2f Celsius\n", temperature, celsius);
                break;
            case 5:
                kelvin = fahrenheitConverter.toCelsius(temperature);
                System.out.printf("%.2f Fahrenheit = %.2f Kelvin\n", temperature, kelvin);
                break;
            case 6:
                fahrenheit = kelvinConverter.toFahrenheit(temperature);
                System.out.printf("%.2f Kelvin = %.2f Fahrenheit\n", temperature, fahrenheit);
                break;
            case 7:
                rankine = rankineConverter.toFahrenheit(temperature);
                System.out.printf("%.2f Celsius = %.2f Rankine\n", temperature, rankine);
                break;
            case 8:
                celsius = rankineConverter.toCelsius(temperature);
                System.out.printf("%.2f Rankine = %.2f Celsius\n", temperature, celsius);
                break;
            case 9:
                reaumur = reaumurConverter.toCelsius(temperature);
                System.out.printf("%.2f Celsius = %.2f Reaumur\n", temperature, reaumur);
                break;
            case 10:
                celsius = reaumurConverter.toCelsius(temperature);
                System.out.printf("%.2f Reaumur = %.2f Celsius\n", temperature, celsius);
                break;
            case 11:
                delisle = delisleConverter.toCelsius(temperature);
                System.out.printf("%.2f Celsius = %.2f Delisle\n", temperature, delisle);
                break;
            case 12:
                celsius = delisleConverter.toCelsius(temperature);
                System.out.printf("%.2f Delisle = %.2f Celsius\n", temperature, celsius);
                break;
            default:
                System.out.println("Invalid choice.");
        }
    }
}
