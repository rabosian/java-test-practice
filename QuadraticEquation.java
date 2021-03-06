// Implement the function findRoots to find the roots of the quadratic equation: ax2 + bx + c = 0. If the equation has only one solution, the function should return that solution as both elements of the Roots. The equation will always have at least one solution.

// The roots of the quadratic equation can be found with the following formula: A quadratic equation.

// For example, the roots of the equation 2x2 + 10x + 8 = 0 are -1 and -4.
import java.lang.Math;

public class QuadraticEquation {
    public static Roots findRoots(double a, double b, double c) {
        double x1 = (-b + Math.sqrt(b*b-4*a*c))/(2*a);
        double x2 = (-b - Math.sqrt(b*b-4*a*c))/(2*a);

        return new Roots(x1, x2);
    }
    
    public static void main(String[] args) {
        Roots roots = QuadraticEquation.findRoots(1, -2, 1);
        System.out.println("Roots: " + roots.x1 + ", " + roots.x2);
    }
}

class Roots {
    public final double x1, x2;
    public Roots(double x1, double x2) {
        this.x1 = x1;
        this.x2 = x2;
    }
}