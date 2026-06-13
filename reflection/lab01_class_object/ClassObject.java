package reflection.lab01_class_object;

public class ClassObject{

    static class Employee{

        private String name;
        private double salary;

        Employee(String name, double salary){
            this.name = name;
            this.salary = salary;
        }

        public String getName() { return this.name; }
    }

    static class Manager extends Employee{

        Manager(String name, double salary){
            super(name, salary);
        }
    }

    public static void main(String[] args) throws Exception{

        // Three ways to get a Class object

        // way 1: getClass() on an existing object
        Employee emp = new Employee("Alice", 50000);
        Class<?> cl1 = emp.getClass();
        System.out.println("Way 1 - getClass(): " + cl1.getName());


        // way 2 - Class.forName() with a string - useful when class name is known at runtime
        Class<?> cl2 = Class.forName("java.util.Scanner");
        System.out.println("Way 2 - forName(): " + cl2.getName());

        // way 3 - T.class literal - this is a compile time constant, works for primitives too
        Class<?> cl3 = Employee.class;
        Class<?> cl4 = int.class;
        Class<?> cl5 = double[].class;
        System.out.println("Way 3 - T.class: " + cl3.getName());
        System.out.println("Way 3 - T.class: " + cl4.getName());
        System.out.println("Way 3 - T.class: " + cl5.getName());

        // Note: array names are cryptic - "[D" means double[]


        // Class objects are unique (created only once) per type
        // so comparison using == is valid, because only 1 memory reference
        System.out.println("\n=== Class object identity ===");
        Employee emp1 = new Employee("Alice", 50000);
        Employee emp2 = new Employee("Bob", 20000);
        System.out.println("emp1.getClass() == emp2.getClass():" + (emp1.getClass() == emp2.getClass()));

        // critical difference: getClass() == vs instanceof
        Manager mgr = new Manager("Carol", 90000);
        Employee eRef = new Manager("Daniel", 80000);

        System.out.println("\n========= getClass() == vs instance of ===========");
        System.out.println("mgr instanceof Employee:  " + (mgr instanceof Employee)); // true - mgr IS an Employee
        System.out.println("eRef instanceof Employee:  " + (eRef instanceof Employee)); // true - eRef IS an Employee
        System.out.println("mgr.getClass() == Employee.class:  " + (eRef.getClass() == Employee.class));
        System.out.println("eRef.getClass() == Employee.class:  " + (eRef.getClass() == Employee.class));
        System.out.println("eRef.getClass() == Manager.class:  " + (eRef.getClass() == Manager.class));

        // getClass() == tells you the exact runtime type
        // instanceof tells you type compatibility
    }
}