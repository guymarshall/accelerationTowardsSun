public class Planet {
    public final String name;
    public final double massKg;
    public double distanceFromSunMetres;
    public double velocity;
    public double gravitationalForceTowardsSun;
    public double acceleration;

    public Planet(int userInput) {
        this.name = switch (userInput) {
            case 1 -> "Mercury";
            case 2 -> "Venus";
            case 3 -> "Earth";
            case 4 -> "Mars";
            case 5 -> "Jupiter";
            case 6 -> "Saturn";
            case 7 -> "Uranus";
            case 8 -> "Neptune";
            case 9 -> "Pluto";
            default -> throw new IllegalArgumentException("Unknown planet index: " + userInput);
        };
        this.massKg = switch (userInput) {
            case 1 -> 0.33e24;     // Mercury
            case 2 -> 4.87e24;    // Venus
            case 3 -> 5.97e24;    // Earth
            case 4 -> 0.642e24;   // Mars
            case 5 -> 1.898e24;   // Jupiter
            case 6 -> 568.0e24;  // Saturn
            case 7 -> 86.8e24;   // Uranus
            case 8 -> 102.0e24;  // Neptune
            case 9 -> 0.013e24;  // Pluto
            default -> throw new IllegalArgumentException("Unknown planet index: " + userInput);
        };
        this.distanceFromSunMetres = switch (userInput) {
            case 1 -> 57.0e9;     // Mercury
            case 2 -> 108.2e9;    // Venus
            case 3 -> 149.6e9;    // Earth
            case 4 -> 228.0e9;   // Mars
            case 5 -> 778.5e9;   // Jupiter
            case 6 -> 1432.0e9;  // Saturn
            case 7 -> 2867.0e9;   // Uranus
            case 8 -> 4515.0e9;  // Neptune
            case 9 -> 5906.4e9;  // Pluto
            default -> throw new IllegalArgumentException("Unknown planet index: " + userInput);
        };

        this.velocity = 0.0;
        this.gravitationalForceTowardsSun = 0.0;
        this.acceleration = 0.0;
    }

    public static void printPlanets() {
        System.out.println("(1) - Mercury, (2) - Venus, (3) - Earth, (4) - Mars, (5) - Jupiter, (6) - Saturn, (7) - Uranus, (8) - Neptune, (9) - Pluto");
    }

    public void calculate_new_gravitational_force_towards_sun() {
        this.gravitationalForceTowardsSun = Main.G * ((Main.MASS_OF_SUN * this.massKg) / (this.distanceFromSunMetres * this.distanceFromSunMetres));
    }

    public void calculate_new_acceleration() {
        this.acceleration = this.gravitationalForceTowardsSun / this.massKg;
    }

    public void calculate_new_velocity() {
        this.velocity += this.acceleration;
    }

    public void calculate_new_distance() {
        this.distanceFromSunMetres -= this.velocity + (0.5 * this.acceleration);
        // TODO: also calculate Sun's movement towards the planet
    }
}
