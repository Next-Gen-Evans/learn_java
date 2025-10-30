package beginners_algo;

public class PopulationProjection {
    public static void main(String[] args) {
        int CURRENT_POPULATION = 312_032_486;

        double birthRate = 7.0;
        double deathRate = 13.0;
        double immigrationRate = 45.0;

        // seconds every year
        int secondsInYear = 365 * 24 * 60 * 60;

        // calculating changes per year
        int birthsPerYear = (int) (secondsInYear / birthRate);
        int deathsPerYear = (int) (secondsInYear / deathRate);
        int immigrationPerYear = (int) (secondsInYear / immigrationRate);

        int populationChangePerYear = birthsPerYear - deathsPerYear + immigrationPerYear;

        System.out.println("Year\tPopulation");

        for (int year = 1; year <=5; year++) {
            CURRENT_POPULATION += populationChangePerYear;
            System.out.printf("%d\t%d%n", year, CURRENT_POPULATION);
        }
    }
}
