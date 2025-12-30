This section will contain Stream api interview questions 




---

1. ## What will the following code print?
```java
Stream.of("d2", "a2", "b1", "b3", "c")
      .filter(s -> {
          System.out.println("filter: " + s);
          return true;
      });
```


<details>
  <summary>Show Answer</summary>
    It prints nothing, because there is no terminal operation (like .collect() or .forEach()
</details>

**[⬆ Back to Top](#table-of-contents)**
---

2. ## Stream Pipeline Efficiency (Order of Operations)

<details>
    <summary>Show Answer</summary>
    Efficiency in Streams is often about the order of your operators.

    Bad: map -> filter (You transform everything, then throw most away).

    Good: filter -> map (You throw away what you don't need first, then transform only the remains).
</details>

**[⬆ Back to Top](#table-of-contents)**
---

3. ## Parallel Streams & Threading
<details>
    <summary>Show Answer</summary>
   Since you are a full-time software engineer, you might be asked about performance.

    When to use: Large datasets and independent operations.

    The Trap: Parallel streams use the shared ForkJoinPool.commonPool(). If one stream blocks (e.g., an I/O call), it can slow down all other parallel streams in your entire application.
</details>

**[⬆ Back to Top](#table-of-contents)**
---

4. ## Difference between Stream<Integer> and IntStream
<details>
    <summary>Show Answer</summary>
  Stream<Integer> involves Boxing (converting int to Integer objects), which is memory-intensive.  
  
---  

IntStream, LongStream, and DoubleStream are primitive-specialized and much faster for math.
</details>