import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // The user's side count decides which shape builder method should collect details.
        System.out.println("=== Shape Calculator ===");
        System.out.println("Enter the number of sides for your shape:");
        System.out.println("  0 = Circle");
        System.out.println("  3 = Triangle");
        System.out.println("  4 = Rectangle");
        System.out.println("  5 = Pentagon");
        System.out.println("  6+ = Generic Polygon (Hexagon, Heptagon, Octagon, etc.)");
        System.out.print("\nNumber of sides: ");

        int sides = scanner.nextInt();

        // Builds the correct Shape subclass while keeping the main method focused on program flow.
        Shape shape = switch (sides) {
            case 0 -> buildCircle(scanner);
            case 3 -> buildTriangle(scanner);
            case 4 -> buildRectangle(scanner);
            case 5 -> buildPentagon(scanner);
            default -> {
                if (sides >= 6) {
                    yield buildGenericPolygon(scanner, sides);
                } else {
                    System.out.println("Invalid input. A polygon needs at least 3 sides (or 0 for a circle).");
                    yield null;
                }
            }
        };

        if (shape != null) {
            System.out.println("\n--- Result ---");
            System.out.println(shape);

            // Launch the JavaFX visualizer window
            ShapeVisualizer.drawShape(shape);
        }

        scanner.close();
    }

    private static Circle buildCircle(Scanner scanner) {
        System.out.println("\nYou selected: Circle");
        System.out.print("Enter the radius: ");
        double radius = scanner.nextDouble();
        // Returns a Circle because circles use radius instead of polygon side counts.
        return new Circle(radius);
    }

    private static Triangle buildTriangle(Scanner scanner) {
        System.out.println("\nYou selected: Triangle");
        System.out.println("Enter the 3 side lengths:");
        System.out.print("  Side 1: ");
        double s1 = scanner.nextDouble();
        System.out.print("  Side 2: ");
        double s2 = scanner.nextDouble();
        System.out.print("  Side 3: ");
        double s3 = scanner.nextDouble();
        System.out.println("Enter the 3 angles (must sum to 180 degrees):");
        System.out.print("  Angle 1: ");
        double a1 = scanner.nextDouble();
        System.out.print("  Angle 2: ");
        double a2 = scanner.nextDouble();
        System.out.print("  Angle 3: ");
        double a3 = scanner.nextDouble();
        // Triangle receives both sides and angles so its constructor can validate the shape.
        return new Triangle(s1, s2, s3, a1, a2, a3);
    }

    private static Rectangle buildRectangle(Scanner scanner) {
        System.out.println("\nYou selected: Rectangle");
        System.out.print("Enter the length: ");
        double length = scanner.nextDouble();
        System.out.print("Enter the width: ");
        double width = scanner.nextDouble();
        return new Rectangle(length, width);
    }

    private static Pentagon buildPentagon(Scanner scanner) {
        System.out.println("\nYou selected: Pentagon");
        System.out.print("Enter the side length: ");
        double sideLength = scanner.nextDouble();
        System.out.print("Enter the apothem (center-to-midpoint-of-side distance): ");
        double apothem = scanner.nextDouble();
        // Regular pentagon area is based on side length and apothem.
        return new Pentagon(sideLength, apothem);
    }

    private static GenericPolygon buildGenericPolygon(Scanner scanner, int sides) {
        // Gives common polygon names to 6-8 sides, then falls back to a general label.
        String name = switch (sides) {
            case 6 -> "Hexagon";
            case 7 -> "Heptagon";
            case 8 -> "Octagon";
            default -> "Polygon with " + sides + " sides";
        };
        System.out.println("\nYou selected: " + name);
        System.out.print("Enter the side length: ");
        double sideLength = scanner.nextDouble();
        System.out.print("Enter the apothem (center-to-midpoint-of-side distance): ");
        double apothem = scanner.nextDouble();
        return new GenericPolygon(sides, sideLength, apothem);
    }
}
