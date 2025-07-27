public class Planet {
    public final String name;
    public final double massKg;
    public double distanceFromSunMetres;
    public double velocity;
    public double gravitationalForceTowardsSun;
    public double acceleration;

    public Planet(int userInput) {
        switch (userInput) {
            case 1 -> {
                this.name = "Mercury";
                this.massKg = 0.33e24;
                this.distanceFromSunMetres = 57.0e9;
            }
            case 2 -> {
                this.name = "Venus";
                this.massKg = 4.87e24;
                this.distanceFromSunMetres = 108.2e9;
            }
            case 3 -> {
                this.name = "Earth";
                this.massKg = 5.97e24;
                this.distanceFromSunMetres = 149.6e9;
            }
            case 4 -> {
                this.name = "Mars";
                this.massKg = 0.642e24;
                this.distanceFromSunMetres = 228.0e9;
            }
            case 5 -> {
                this.name = "Jupiter";
                this.massKg = 1.898e24;
                this.distanceFromSunMetres = 778.5e9;
            }
            case 6 -> {
                this.name = "Saturn";
                this.massKg = 568.0e24;
                this.distanceFromSunMetres = 1432.0e9;
            }
            case 7 -> {
                this.name = "Uranus";
                this.massKg = 86.8e24;
                this.distanceFromSunMetres = 2867.0e9;
            }
            case 8 -> {
                this.name = "Neptune";
                this.massKg = 102.0e24;
                this.distanceFromSunMetres = 4515.0e9;
            }
            case 9 -> {
                this.name = "Pluto";
                this.massKg = 0.013e24;
                this.distanceFromSunMetres = 5906.4e9;
            }
            default -> throw new IllegalArgumentException("Unknown planet index: " + userInput);
        }

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
