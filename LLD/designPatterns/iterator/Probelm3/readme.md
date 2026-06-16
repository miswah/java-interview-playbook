# Employee Department Iterator

```java
public record Employee(
        int id,
        String name,
        String department
) {}
```

```java
  Company comp = new Company();

        comp.add(new Employee(1, "Jhon", "HR"));
        comp.add(new Employee(2, "Alice", "IT"));
        comp.add(new Employee(3, "Bob", "HR"));
        comp.add(new Employee(4, "Charlie", "Sales"));
        comp.add(new Employee(5, "David", "IT"));
```

## Create these 3 iterators

```java
comp.hrIterator()

comp.itIterator()

comp.salesIterator()
```

Each returns an iterator exposing only that department.