import java.util.*;

class RemoveSpaces {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String s = sc.nextLine();

        String result = s.replaceAll("\\s", "");

        System.out.println("After removing spaces: " + result);
    }
}