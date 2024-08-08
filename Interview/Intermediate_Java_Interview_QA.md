
# Intermediate Java Interview Q&A

## Questions and Answers

### 1. What is the difference between abstract classes and interfaces in Java?
Abstract classes can have both abstract methods (without implementation) and concrete methods (with implementation). Interfaces can only have abstract methods until Java 8, after which they can also have default and static methods. A class can implement multiple interfaces but can extend only one abstract class.

### 2. Explain the concept of the Java Memory Model (JMM).
The Java Memory Model defines how threads interact through memory and what behaviors are allowed in a multithreaded environment. It specifies rules about visibility and ordering of variable accesses (reads and writes) to ensure consistent and predictable results in concurrent applications.

### 3. What are the different types of garbage collectors in Java?
Some common types of garbage collectors are:
- Serial Garbage Collector
- Parallel Garbage Collector
- Concurrent Mark-Sweep (CMS) Collector
- G1 Garbage Collector

### 4. What is the `volatile` keyword in Java and how is it used?
The `volatile` keyword is used to indicate that a variable's value will be modified by different threads. It ensures visibility of changes to variables across threads by preventing the caching of variables.
```java
private volatile boolean flag;
```

### 5. Explain the concept of the `synchronized` keyword in Java.
The `synchronized` keyword is used to control the access of multiple threads to a shared resource. It can be applied to methods or blocks to ensure that only one thread can execute the synchronized code at a time.
```java
public synchronized void increment() {
    count++;
}
```

### 6. What is the difference between `ArrayList` and `LinkedList`?
`ArrayList` uses a dynamic array to store elements, allowing fast random access and efficient traversal but slower insertions and deletions. `LinkedList` uses a doubly-linked list, providing faster insertions and deletions but slower access times.

### 7. How does the `HashMap` work internally in Java?
`HashMap` uses an array of buckets, each of which is a linked list (or a balanced tree in case of many collisions). The `hashCode` of the key determines the bucket index, and collisions are handled by adding the entry to the linked list (or tree) at that index.

### 8. What is the difference between `HashSet` and `TreeSet`?
`HashSet` is backed by a `HashMap` and does not maintain any order. `TreeSet` is backed by a `TreeMap` and maintains elements in ascending order (natural order or custom comparator).

### 9. What is the difference between `Callable` and `Runnable`?
`Callable` can return a result and throw a checked exception, while `Runnable` cannot return a result and cannot throw a checked exception.
```java
Callable<Integer> callable = () -> {
    return 42;
};
```

### 10. Explain the `ThreadLocal` class and its use cases.
`ThreadLocal` provides thread-local variables, ensuring that each thread accessing such a variable has its own, independently initialized copy. It is useful for maintaining per-thread context, such as user sessions.

### 11. What is a Java `Stream` and how is it different from a `Collection`?
A `Stream` is a sequence of elements supporting sequential and parallel aggregate operations. Unlike a `Collection`, it does not store elements but processes them on demand.

### 12. What is the purpose of the `Optional` class in Java 8?
`Optional` is a container object used to contain not-null values. It helps in avoiding `NullPointerException` and provides methods to handle values as either present or absent.

### 13. Explain the concept of functional interfaces in Java.
A functional interface is an interface that contains exactly one abstract method. It can be used as the assignment target for a lambda expression or method reference. Examples include `Runnable`, `Callable`, and `Comparator`.

### 14. What is the `Comparator` and `Comparable` interface? How do they differ?
`Comparable` is used to define the natural ordering of objects, with a `compareTo` method. `Comparator` is used to define an external ordering, with a `compare` method, and can be passed to sort methods to control the order.

### 15. What is the difference between `String`, `StringBuilder`, and `StringBuffer`?
`String` is immutable, meaning its value cannot be changed once created. `StringBuilder` is mutable and not synchronized, making it faster for single-threaded operations. `StringBuffer` is mutable and synchronized, making it thread-safe but slower.

### 16. How does Java achieve platform independence?
Java achieves platform independence through the use of the Java Virtual Machine (JVM). Java code is compiled into bytecode, which the JVM interprets and executes on any platform that has a compatible JVM.

### 17. What are annotations in Java and how are they used?
Annotations are metadata that provide information about the code but do not affect its execution. They can be used to give instructions to the compiler, runtime, or tools. Examples include `@Override`, `@Deprecated`, and custom annotations.
```java
@Override
public void run() {
    // implementation
}
```

### 18. Explain the concept of reflection in Java.
Reflection is the ability of a program to examine and modify its own structure and behavior at runtime. It allows inspection of classes, methods, fields, and invocation of methods, even if they are private.

### 19. What is the Java `NIO` package and what are its advantages over the `IO` package?
The `NIO` (New Input/Output) package provides features like non-blocking I/O operations, buffers for data handling, and channels for data transfer, which make it more efficient and scalable than the traditional `IO` package.

### 20. What is the `Fork/Join` framework in Java?
The `Fork/Join` framework is designed for parallel processing by breaking tasks into smaller sub-tasks and then combining their results. It is particularly useful for recursive algorithms and is part of the `java.util.concurrent` package.
```java
ForkJoinPool forkJoinPool = new ForkJoinPool();
forkJoinPool.invoke(new RecursiveTask<Integer>() {
    @Override
    protected Integer compute() {
        // implementation
    }
});
```
