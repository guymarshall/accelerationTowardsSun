#![forbid(unsafe_code)]

use crate::{G, MASS_OF_SUN};

pub(crate) struct Planet {
    pub(crate) mass_kg: f64,
    pub(crate) distance_from_sun_m: f64,
    pub(crate) velocity: f64,
    pub(crate) gravitational_force_towards_sun: f64,
    pub(crate) acceleration: f64,
}

impl Planet {
    pub(crate) const fn new(mass_kg: f64, distance_from_sun_m: f64) -> Planet {
        Planet {
            mass_kg,
            distance_from_sun_m,
            velocity: 0.0,
            gravitational_force_towards_sun: 0.0,
            acceleration: 0.0,
        }
    }

    pub(crate) fn print_planets() {
        println!("(1) - Mercury, (2) - Venus, (3) - Earth, (4) - Mars, (5) - Jupiter, (6) - Saturn, (7) - Uranus, (8) - Neptune, (9) - Pluto");
    }

    pub(crate) fn calculate_new_gravitational_force_towards_sun(&mut self) {
        self.gravitational_force_towards_sun = G
            * ((MASS_OF_SUN * self.mass_kg)
                / (self.distance_from_sun_m * self.distance_from_sun_m));
    }

    pub(crate) fn calculate_new_acceleration(&mut self) {
        self.acceleration = self.gravitational_force_towards_sun / self.mass_kg;
    }

    pub(crate) fn calculate_new_velocity(&mut self) {
        self.velocity += self.acceleration;
    }

    pub(crate) fn calculate_new_distance(&mut self) {
        self.distance_from_sun_m -= self.velocity + (0.5 * self.acceleration);
        // TODO: also calculate Sun's movement towards the planet
    }
}
