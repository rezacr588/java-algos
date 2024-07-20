import java.util.HashMap;

public class HashMapExample {
    public static void main(String[] args) {
        // Create a HashMap
        HashMap<String, Integer> map = new HashMap<>();

        // Adding key-value pairs
        map.put("Alice", 30);
        map.put("Bob", 25);
        map.put("Charlie", 35);

        // Retrieving a value by key
        int age = map.get("Alice");
        System.out.println("Alice's age: " + age);

        // Checking if a key exists
        if (map.containsKey("Bob")) {
            System.out.println("Bob is in the map.");
        }

        // Removing a key-value pair
        map.remove("Charlie");

        // Iterating over the keys
        for (String key : map.keySet()) {
            System.out.println("Key: " + key + ", Value: " + map.get(key));
        }

        // Iterating over the values
        for (int value : map.values()) {
            System.out.println("Value: " + value);
        }

        // Iterating over the entries
        for (HashMap.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue());
        }
    }
}
