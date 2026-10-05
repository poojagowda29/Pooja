public class Animal
{
    void sound()
    {
        System.out.println("The Animal Makes Sound:");
        
    }
}
    class Dog extends Animal 
    {
        Dog() 
        {
            System.out.println("This is the constructor"); }
            void eat() {
                System.out.println("The dog can Eat Also:");}
            }
            class main2 
            {
                public static void main(String [] args)
                {
                    Animal a1=new Dog();
                    a1.sound();
                    Dog d1=(Dog)a1;
                    d1.eat();
                    ((Dog) a1).eat();
                }
            }
        
    