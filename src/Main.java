import java.util.Scanner;

public class Main {
    public static final double MASS_OF_SUN = 1.989E30;
    public static final double G = 6.67430E-11;

    public static void main(String[] args) {
        System.out.println("Choose a planet:");
        Planet.printPlanets();

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter planet:");
        int user_input = scanner.nextInt();

        Planet planet = new Planet(user_input);

        int time = 0;
        while (planet.distanceFromSunMetres > 0.0) {
            if (time % 1_000_000 == 0) {
                System.out.printf("Time: %ds,\tVelocity: %.0fms^-1,\tDistance from Sun: %.0fm%n", time, planet.velocity, planet.distanceFromSunMetres);
            }
            time++;
            planet.calculate_new_gravitational_force_towards_sun();
            planet.calculate_new_acceleration();
            planet.calculate_new_velocity();
            planet.calculate_new_distance();
        }

        System.out.printf("%s took %ds to collide with the Sun, at %.0fms^-1.%n", planet.name, time, planet.velocity);
    }
}