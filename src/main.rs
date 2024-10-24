#![forbid(unsafe_code)]

use crate::planet::Planet;

mod planet;

use promptput::input;

const MASS_OF_SUN: f64 = 1.989E30;
const G: f64 = 6.67430E-11;

fn main() {
    println!("Choose a planet:");
    Planet::print_planets();
    let user_input: i32 = input("Enter planet:");

    let mut planet: Planet = match user_input {
        1 => Planet::new(0.33E24, 57.0E9),    // Mercury
        2 => Planet::new(4.87E24, 108.2E9),   // Venus
        3 => Planet::new(5.97E24, 149.6E9),   // Earth
        4 => Planet::new(0.642E24, 228.0E9),  // Mars
        5 => Planet::new(1.898E24, 778.5E9),  // Jupiter
        6 => Planet::new(568.0E24, 1432.0E9), // Saturn
        7 => Planet::new(86.8E24, 2867.0E9),  // Uranus
        8 => Planet::new(102.0E24, 4515.0E9), // Neptune
        9 => Planet::new(0.013E24, 5906.4E9), // Pluto
        _ => panic!("Unknown error. Please try again."),
    };

    let mut time: i32 = 0;
    while planet.distance_from_sun_m > 0.0 {
        println!(
            "Time: {}s,\tVelocity: {:.0}ms^-1,\tDistance from Sun: {:.0}m",
            time, planet.velocity, planet.distance_from_sun_m
        );
        time += 1;
        planet.calculate_new_gravitational_force_towards_sun();
        planet.calculate_new_acceleration();
        planet.calculate_new_velocity();
        planet.calculate_new_distance();
    }
}
