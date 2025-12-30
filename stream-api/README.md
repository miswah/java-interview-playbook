This Section will contain notes for stream api as well as practice questions.

### Table of Contents

| No  | Questions                                                                                                                                      | Dificulity |
| --- | ---------------------------------------------------------------------------------------------------------------------------------------------- | ---------- |
| 1   | [Square each number in the list and collect the result into a new list](#square-each-number-in-the-list-and-collectthe-result-into-a-new-list) | Easy       |
| 2   | [find the length of the longest name in the list](#find-the-length-of-the-longest-name-in-the-list)                                            | Easy       |
| 3   | [Concatenation of the first two words that have even length](#concatenation-of-the-first-two-words-that-have-even-length)                      | Easy       |
| 4   | [Sorting Strings Alphabetically](#sorting-strings-alphabetically)                                                                              | Easy       |
| 5   | [Counting Elements Matching a Condition](#counting-elements-matching-a-condition)                                                              | Easy       |
| 6   | [Truncating a Stream](#truncating-a-stream)                                                                                                    | Easy       |
| 7   | [Skipping Elements](#skipping-elements)                                                                                                        | Easy       |
| 8   | [Checking for a Match](#checking-for-a-match)                                                                                                  | Easy       |
| 9   | [Finding the First Element](#finding-the-first-element)                                                                                        | Easy       |
| 10  | [Summing Integers](#summing-integers)                                                                                                          | Easy       |
| 11  | [Flattening Nested Lists](#flattening-nested-lists)                                                                                            | Medium     |
| 12  | [Grouping by Length](#grouping-by-length)                                                                                                      | Medium     |
| 13  | [Finding the Second Highest Number](#finding-the-second-highest-number)                                                                        | Medium     |
| 14  | [Partitioning Numbers](#partitioning-numbers)                                                                                                  | Medium     |
| 15  | [Concatenating with a Delimiter](#concatenating-with-a-delimiter)                                                                              | Medium     |
| 16  | [Converting a List to a Map](#converting-a-list-to-a-map)                                                                                      | Medium     |
| 17  | [Calculating Average Length](#calculating-average-length)                                                                                      | Medium     |
| 18  | [Custom Sorting (Multiple Criteria)](#custom-sorting-multiple-criteria)                                                                        | Medium     |
| 19  | [Counting Character Frequency](#counting-character-frequency)                                                                                  | Medium     |
| 20  | [Finding the First Non-Repeated Character](#finding-the-first-non-repeated-character)                                                          | Medium     |
|     |                                                                                                                                                |            |

---

1. ## Square each number in the list and collect the result into a new list

```java
List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
 ```

**Expected Output**
`[1, 4, 9, 16, 25]`



**[⬆ Back to Top](#table-of-contents)**
---

2. ## Find the length of the longest name in the list

```java
List<String> names = Arrays.asList("Alice", "Bob", "Charlie", "David", "Eva");
   ```

**Expected Output** `7`


**[⬆ Back to Top](#table-of-contents)**

---

3. ## Concatenation of the first two words that have even length
```java
List<String> words = Arrays.asList("apple", "banana", "cherry", "date", "elderberry");
 ```

 **Expected Output**
 `ananacherry`


**[⬆ Back to Top](#table-of-contents)**
---

 4. ## Sorting Strings Alphabetically
```java
List<String> fruits = Arrays.asList("Zebra", "Apple", "Mango", "Banana");
```

**Expected Output**
`["Apple", "Banana", "Mango", "Zebra"]`

**[⬆ Back to Top](#table-of-contents)**
---

5. ## Counting Elements Matching a Condition

Given a list Arrays.asList("Alice", "Bob", "Charlie", "David"), count how many names have more than 4 characters.

```java
List<String> names = Arrays.asList("Alice", "Bob", "Charlie", "David");
```

**Expected Output**
`2`

**[⬆ Back to Top](#table-of-contents)**
---

6. ## Truncating a Stream
Given a list of numbers from 1 to 10, how do you retrieve only the first 3 elements?

```java
List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
```
**Expected Output** 
`[1, 2, 3]`

**[⬆ Back to Top](#table-of-contents)**
---


7. ## Skipping Elements
Write a stream to skip the first two elements and collect the remaining ones.
```java
List<Integer> numbers = Arrays.asList(10, 20, 30, 40, 50);
```
**Expected Output** `[30, 40, 50]`

**[⬆ Back to Top](#table-of-contents)**
---

8. ## Checking for a Match
Check if any number in the list is greater than 10.

```java
List<Integer> numbers = Arrays.asList(5, 8, 12, 15);
```
**Expected Output** `true`

**[⬆ Back to Top](#table-of-contents)**
---

9. ## Finding the First Element
Retrieve the first element of the stream.
```java
List<String> colors = Arrays.asList("Red", "Green", "Blue");
```
**Expected Output** `Optional[Red]`

**[⬆ Back to Top](#table-of-contents)**
---

10. ## Summing Integers
Calculate the total sum of the numbers.
```java
List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
```
**Expected Output** `15`

**[⬆ Back to Top](#table-of-contents)**
---

11. ## Flattening Nested Lists
Write a stream pipeline to flatten these into a single list of integers.

```java
List<List<Integer>> nestedList = Arrays.asList(
    Arrays.asList(1, 2), 
    Arrays.asList(3, 4), 
    Arrays.asList(5, 6)
);
```

**Expected Output** `[1, 2, 3, 4, 5, 6]`

**[⬆ Back to Top](#table-of-contents)**
---

12. ## Grouping by Length
Group these strings into a Map<Integer, List<String>> where the key is the length of the string and the value is the list of strings with that length.
```java
List<String> fruits = Arrays.asList("apple", "banana", "cherry", "date", "fig");
```

**Expected Output** `{3=[fig], 4=[date], 5=[apple], 6=[banana, cherry]}`

**[⬆ Back to Top](#table-of-contents)**
---

13. ## Finding the Second Highest Number
```java
List<Integer> numbers = Arrays.asList(5, 13, 4, 21, 8, 21, 15);
```

**Expected Output** `Optional[15]`

**[⬆ Back to Top](#table-of-contents)**
---

14. ## Partitioning Numbers
Create a Map<Boolean, List<Integer>> where true contains even numbers and false contains odd numbers.

```java
List<Integer> numbers = IntStream.rangeClosed(1, 10).boxed().collect(Collectors.toList());
```
**Expected Output** `{false=[1, 3, 5, 7, 9], true=[2, 4, 6, 8, 10]}`

**[⬆ Back to Top](#table-of-contents)**
---

15. ## Concatenating with a Delimiter
Join them into a single string separated by a hyphen - and wrapped in brackets []
```java
List<String> langs = Arrays.asList("Java", "Python", "C++", "Ruby");
```
**Expected Output** `[Java-Python-C++-Ruby]`

**[⬆ Back to Top](#table-of-contents)**
---

16. ## Converting a List to a Map
Given a list of Person objects (assume fields id and name), convert the list into a Map<Integer, String> where the key is the id and the value is the name.

```java
List<Person> people = Arrays.asList(new Person(1, "Alice"), new Person(2, "Bob"));
```
**Expected Output** `{1=Alice, 2=Bob}`

**[⬆ Back to Top](#table-of-contents)**
---

17. ## Calculating Average Length
Given a list of strings, find the average length of all strings that start with the letter 'A'.

```java
List<String> words = Arrays.asList("Apple", "Ant", "Banana", "Aardvark", "Cherry");
```

**Expected Output** `4.333... (Average of 5, 3, and 8)`

**[⬆ Back to Top](#table-of-contents)**
---

18. ## Custom Sorting (Multiple Criteria)
Given a list of strings, sort them first by their length (ascending) and then alphabetically for strings of the same length.

```java
List<String> words = Arrays.asList("banana", "apple", "cherry", "date", "egg");
```
**Expected Output** `[egg, date, apple, banana, cherry]`

**[⬆ Back to Top](#table-of-contents)**
---

19. ## Counting Character Frequency
Create a frequency map of its characters using a stream.

```java
String input = "streamapi";
```

**Expected Output** `{a=1, p=1, r=1, s=1, t=1, e=1, i=1, m=1}`

**[⬆ Back to Top](#table-of-contents)**
---

20. ## Finding the First Non-Repeated Character
Use the Stream API to find the first character that does not repeat.

```java
String input = "swiss";
```

**Expected Output** `'w'`

**[⬆ Back to Top](#table-of-contents)**
---