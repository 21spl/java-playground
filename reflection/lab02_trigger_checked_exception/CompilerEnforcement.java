package reflection.lab02_trigger_checked_exception;

public class CompilerEnforcement {
    
    // step 1: following method does not compile
    // because Class.forName() declares throws ClassNotFoundException
    // but in the caller method (loadBroken) we have no throws declaration
    /* 
    public static void loadBroken(String className){
        Class<?> c1 = Class.forName(className);

        System.out.println("Loaded: " + c1.getName());
    }
    */

    // step 2: following method is correct, 
     // because Class.forName() declares throws ClassNotFoundException
    // and in the the caller method (loadFixed) we have also added throws declaration

    public static void loadFixed(String className) throws ClassNotFoundException{
        Class<?> c1 = Class.forName(className);
        System.out.println("Loaded: " + c1.getName());
    }

    // Step 3: ReflectiveOperationException is the parent of ClassNotFoundException
    // Declaring the parent covers all reflection-related checked exceptions
    public static void loadWithParent(String className) throws ReflectiveOperationException{
        Class<?> c1 = Class.forName(className);
        System.out.println("Loaded: " + c1.getName());
    }

    // Step 4: throws Exception covers ALL checked exceptions - broad by lazy
    // acceptable for quick programs but not for production code
    public static void loadWithException(String className) throws Exception{
        Class<?> c1 = Class.forName(className);
        System.out.println("Loaded: " + c1.getName());
    }

    // see main method is calling loadFixed method which may throw exception
    // so in the main method declaration too, we add throws declaration
    public static void main(String[] args) throws Exception{
        
        loadWithParent("randomClass");
        loadWithParent("java.util.ArrayList");
    }
}


/*output:

WHEN WE TRIED TO COMPILE WITH UNCOMMENTED LOADBROKEN - COMPILE TIME ERROR

wrik@wrik-dell:~/Code/java-labs$ javac -d bin reflection/lab02_trigger_checked_exception/*.java
reflection/lab02_trigger_checked_exception/CompilerEnforcement.java:9: error: unreported exception ClassNotFoundException; must be caught or declared to be thrown
        Class<?> c1 = Class.forName(className);
                                   ^
1 error


SO LET COMMENT LOADBROKEN AND THEN COMPILE


*/
