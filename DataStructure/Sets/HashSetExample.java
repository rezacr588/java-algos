import java.util.HashSet;
import java.util.Set;

public class HashSetExample {
    public static void main(String[] args) {
        // Creating a HashSet
        Set<String> hashSet = new HashSet<>();

        // Adding elements to the HashSet
        hashSet.add("Apple");
        hashSet.add("Banana");
        hashSet.add("Cherry");
        hashSet.add("Apple"); // Duplicate element

        // Displaying the HashSet
        System.out.println("HashSet: " + hashSet);

        // Checking if an element is in the set
        boolean containsApple = hashSet.contains("Apple");
        System.out.println("Contains 'Apple'? " + containsApple);

        // Removing an element
        hashSet.remove("Banana");
        System.out.println("HashSet after removing 'Banana': " + hashSet);
    }
}
