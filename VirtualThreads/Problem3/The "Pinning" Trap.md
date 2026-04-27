Triggering and Profiling Thread PinningYou are going to intentionally sabotage your Carrier Threads and learn how to diagnose it in a production-like environment.

    The Task: Create a program that spawns 100 Virtual Threads. Inside the task run by these threads, place a Thread.sleep(2000) inside a synchronized (this) block.

    Phase 1: Run the program and observe how long it takes. (Hint: If you have 8 cores, 100 threads sleeping for 2 seconds should take a long time because of pinning, whereas normal Virtual Threads would finish in ~2 seconds total).

    Phase 2 (The Challenge): Prove that pinning is happening using JVM diagnostics. Run your application with the JVM argument -Djdk.tracePinnedThreads=full. Alternatively, create a JDK Flight Recorder (JFR) recording and open it in Java Mission Control (JMC) to find the pinned thread events.

    Phase 3: Fix the code. Replace the synchronized block with a java.util.concurrent.locks.ReentrantLock. Rerun your diagnostics to prove the pinning is gone and watch the execution time plummet.
