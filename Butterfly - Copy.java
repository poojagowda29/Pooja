public class Butterfly {
    public static void main(String[] args) {

        int n = 5;
        int i, j;

        // Upper half
        for(i =1; i <= n; i++) {

            for(j = 1; j <= i; j++) {
                System.out.print("*");
            }

            for(j = 1; j <= 2 * (n-i); j++) {
                System.out.print(" ");
            }

            for(j = 1; j <= i; j++) {
                System.out.print("*");
            }

            System.out.println();
        }

        // Lower half
        for(i = n-1; i >= 1; i--) {

            for(j = 1; j <= i; j++) {
                System.out.print("*");
            }

            for(j = 1; j <= 2 * (n-i); j++) {
                System.out.print(" ");
            }

            for(j = 1; j <= i; j++) {
                System.out.print("*");
            }

            System.out.println();
        }
    }
}