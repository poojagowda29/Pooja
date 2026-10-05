import java.util.*;
public class Add
{
    void pow()
    {
        Scanner sc=new Scanner(System.in);
        int a=sc.nextInt(),b=sc.nextInt();
        int pro=1;
        for(int i=1;i<=b;i++)
        {
            pro*=a;
            
        }
        System.out.println("The power of b=" +b);
    }
    public static void main(String []args)
    {
    }
    }
