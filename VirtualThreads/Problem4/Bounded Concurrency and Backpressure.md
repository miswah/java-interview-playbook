Bulk Email Sender

You need to send emails to a large list of users.

Each email send:

Is a blocking operation (simulated via Thread.sleep)
Takes ~200–500ms
May randomly fail


```java
public record EmailRequest(int id, String to, String body) {}

public record EmailResult(int id, String status, String error) {}
```


### Email Service

```java
public class EmailService {

    public static void sendEmail(EmailRequest req) {
        try {
            Thread.sleep(ThreadLocalRandom.current().nextInt(200, 500));
        } catch (InterruptedException e) {
            throw new RuntimeException("Interrupted");
        }

        if (ThreadLocalRandom.current().nextInt(5) == 0) {
            throw new RuntimeException("SMTP failure");
        }
    }
}
```

## Input

```java
List<EmailRequest> emails = IntStream.rangeClosed(1, 50)
    .mapToObj(i -> new EmailRequest(i, "user" + i + "@test.com", "Hello " + i))
    .toList();
```

## Your Task
Implement this method

```java
List<EmailResult> sendBulkEmails(List<EmailRequest> emails)
```


## MUST USE:
Executors.newVirtualThreadPerTaskExecutor()  


## Constraints (Important)
1. Bounded Concurrency (CRITICAL)

 Even with virtual threads, you must: Allow max 10 emails in-flight at a time

### Use:

Semaphore OR another mechanism

1. Each Task Should: Acquire permit Send email (blocking )Release permit
   
2. ❌ Failure Handling If sending fails:
`status = "FAILED"
error = exception message`

1. Success
`status = "SENT"
error = null`
1. Thread Safety
No shared mutable unsafe structures
Avoid:
parallelStream
Ignoring concurrency limit
Unbounded submissions without control