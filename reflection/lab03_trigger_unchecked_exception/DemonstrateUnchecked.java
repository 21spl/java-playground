package reflection.lab03_trigger_unchecked_exception;

public class DemonstrateUnchecked {
    public static void demonstrateUncheckedException(){
        // No throws needed - NullPointerException is unchecked
        // But this will throw at runtime if called with null
        String s = null;
        System.out.println(s.length()); // NullPointerException is unchecked, no throws needed
    }

    public static void main(String[] args){
        demonstrateUncheckedException();
    }
}

/* output: 

See, there is no compile time error. The program compiled successfully

It terminated at runtime because NullPointerException is a Runtime Exception (unchecked)

wrik@wrik-dell:~/Code/java-labs$ javac -d bin reflection/lab03_trigger_unchecked_exception/*.java
wrik@wrik-dell:~/Code/java-labs$ java -cp bin reflection.lab03_trigger_unchecked_exception.DemonstrateUnchecked 
Exception in thread "main" java.lang.NullPointerException: Cannot invoke "String.length()" because "<local0>" is null
        at reflection.lab03_trigger_unchecked_exception.DemonstrateUnchecked.demonstrateUncheckedException(DemonstrateUnchecked.java:8)
        at reflection.lab03_trigger_unchecked_exception.DemonstrateUnchecked.main(DemonstrateUnchecked.java:12)

*/
