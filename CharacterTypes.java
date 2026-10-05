import java.util.*;

class CharacterTypes {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String s = sc.nextLine();

        int letters = 0;
        int digits = 0;
        int special = 0;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (Character.isLetter(ch))
                letters++;
            else if (Character.isDigit(ch))
                digits++;
            else
                special++;
        }

        System.out.println("Letters = " + letters);
        System.out.println("Digits = " + digits);
        System.out.println("Special characters = " + special);
    }
}