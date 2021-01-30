import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        switch (input) {
            case "triangle":
                double x = scanner.nextDouble();
                double y = scanner.nextDouble();
                double z = scanner.nextDouble();
                double p = (x + y + z) * 0.5;
                System.out.println("" + Math.sqrt(p * (p - x) * (p - y) * (p - z)));
                break;
            case "rectangle":
                double a = scanner.nextDouble();
                double b = scanner.nextDouble();
                System.out.println("" + (a * b));
                break;
            case "circle":
                double r = scanner.nextDouble();
                System.out.println("" + (3.14 * r * r));
                break;
            default:
                break;
        }

    }
}
