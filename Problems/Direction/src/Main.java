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
                System.out.println("" + (x * y / 2));
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
        }
    }
}