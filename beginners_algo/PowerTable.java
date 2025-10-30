package beginners_algo;

public class PowerTable {
    public static void main(String[] args) {
        System.out.println("a\t a^2\t a^3\t a^4");

        for (int a = 1; a <= 4; a++) {
            System.out.printf("%d\t %d\t %d\t %d%n", a, (int) Math.pow(a, 2), (int) Math.pow(a, 3), (int) Math.pow(a, 4));
        }
    }
}
