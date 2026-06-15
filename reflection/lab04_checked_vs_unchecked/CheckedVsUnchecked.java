package reflection.lab04_checked_vs_unchecked;

import java.io.*;

public class CheckedVsUnchecked {
    

    // CHECKED: IOException family - file might not exist despite correct code
    // compiler demands throws declaration
    public static String readFileFirstLine(String path) throws IOException{

        FileReader fr = new FileReader(path); // FileNotFoundException - checked
        BufferedReader reader = new BufferedReader(fr);
        String firstLine = reader.readLine();  // IOException - checked
        reader.close();
        return firstLine;
    }

    // CHECKED: Class.forName - class might not be on classpath
    public static Class<?> loadClass(String name) throws ClassNotFoundException{
        return Class.forName(name);
    }

    // UNCHECKED: NullPointerException - programming mistake, not external failure
    // No throws declaration required - compiler doesn't even check
    public static int getLength(String s){
        return s.length(); // NullPointerException if s == null - no throws needed
    }

    // UNCHECKED: ArrayIndexOutOfBoundsException - programming mistake
    // No throws declaration
    public static int getElement(int[] arr, int index){
        return arr[index]; // AIOOBE if index out of range - no throws needed
    }

    // UNCHECKED - ClassCastException - programming mistake
    public static String badCast(Object obj){
        return (String) obj; // CCE if obj is not String - no throws needed
    }

    // UNCHECKED: NumberFormatException
    public static int parseNumber(String s){
        return Integer.parseInt(s); // NFE if s is not a number
    }

    public static void main(String[] args) throws Exception{
        System.out.println("=== Checked Exceptions ===");

        // This works - ArrayList always exists
        Class<?> c1 = loadClass("java.util.ArrayList");
        System.out.println("Loaded: " + c1.getName());

        // This fails - file doesn't exist

        try{
            readFileFirstLine("/nonexistent/path/file.txt");
        }
        catch(IOException e){
            System.out.println("Checked IOException caught: " + e.getMessage());
        }

        System.out.println("\n--- Triggering unchecked at runtime ---");

        try{
            getLength(null);
        }
        catch(NullPointerException e){
            System.out.println("NPE: " + e.getClass().getSimpleName());
        }
    }
}
