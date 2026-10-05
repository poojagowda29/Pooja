import java.util.Scanner;
class GCD {
    static int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return Math.abs(a);
    }
    public static void main(String[] args) {
        Scanner in =new Scanner(System.in);
        int x,y;
        System.out.println("Enter the X Variable");
        x=in.nextInt();
        System.out.println("Enter the Y Variable");
        y=in.nextInt();
        System.out.println(gcd(x,y));  
         
    }
}