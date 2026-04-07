Requirements

    The Pattern: Create a ConfigurationManager class using the Singleton pattern.

    The State: It must hold an instance of ServerConfig. Initialize it with default values ("127.0.0.1", 8080, 100, true) when the manager is first created.

    The API:

        Provide a method public ServerConfig getConfig() to retrieve the current configuration.

        Provide a method public void updateConfig(ServerConfig newConfig) to update the configuration.

Constraints

    High Concurrency: The application is highly concurrent. Your Singleton creation must be strictly thread-safe and optimized for performance (lazy initialization is required).

    Lock-Free State: Your updateConfig and getConfig methods must handle concurrent access safely, ensuring no thread reads a partially updated or stale state, without introducing synchronization bottlenecks.

    Tamper-Proof: Protect your Singleton against common Java-specific instantiation loopholes (like Reflection attacks).