package reflection.lab02_trigger_checked_exception;

public class RuntimeBehaviour {
    

    public static void level3(String className) throws ClassNotFoundException{
        System.out.println("level3: attempting to load " + className);
        Class<?> c1 = Class.forName(className); // this is where it throws
    }

    public static void level2(String className) throws ClassNotFoundException{
        System.out.println("level2: calling level 3");
        level3(className);
        System.out.println("level 2: this line never runs if level3 throws");
    }

    public static void level1(String className) throws ClassNotFoundException{
        System.out.println("level1: calling level 1");
        level2(className);
        System.out.println("level 1: this line never runs if level2 throws");
    }

    public static void main(String[] args) throws ClassNotFoundException{
        System.out.println("main: calling level1 with a bad class name");
        level1("com.example.ClassThatDoesNotExist");
        System.out.println("main: this line never runs if level1 throws");
    }


    
}
