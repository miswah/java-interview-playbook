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