import java.util.*;

class Uppercase {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String s = sc.nextLine();

        System.out.println("Uppercase = " + s.toUpperCase());
    }
}