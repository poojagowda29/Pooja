import java.util.*;

class Largest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] a = new int[n];

        for (int i = 0; i < n; i++)
            a[i] = sc.nextInt();

        int largest = a[0];

        for (int i = 1; i < n; i++) {
            if (a[i] > largest)
                largest = a[i];
        }

        System.out.println("Largest = " + largest);
    }
}