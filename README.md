# Singleton Design Pattern - Database Connection Example

## Overview
This project demonstrates the **problem** that the Singleton Design Pattern solves by showing what happens when multiple instances of a resource-intensive class (like a database connection) are created unnecessarily.

## The Problem

### Current Implementation (WITHOUT Singleton)

```java
public class DatabaseConnection {
    private final String host;
    private final Integer port;
    public static Integer COUNT = 0;
    
    public DatabaseConnection(String host, Integer port) {
        this.host = host;
        this.port = port;
        System.out.println("Connection - " + COUNT);
        COUNT++;
    }
}
```

### What Happens?

When running the client code:

```java
public class DatabaseConnectionClient {
    public static void main(String[] args) {
        for (int i = 0; i < 11; i++) {
            DatabaseConnection databaseConnection = new DatabaseConnection("host", 4324);
            System.out.println(DatabaseConnection.COUNT);
        }
    }
}
```

### Output:
```
Connection - 0
1
Connection - 1
2
Connection - 2
3
Connection - 3
4
Connection - 4
5
Connection - 5
6
Connection - 6
7
Connection - 7
8
Connection - 8
9
Connection - 9
10
Connection - 10
11
```

## Problems Demonstrated

### 1. **Multiple Instances Created**
- **11 separate database connection objects** are created
- Each connection consumes memory and system resources
- All connections are to the **same host and port** - completely unnecessary!

### 2. **Resource Waste**
- Real database connections are expensive:
    - Network socket allocation
    - Memory overhead
    - Connection pool exhaustion
    - Database server connection limits
- Creating 11 connections when you only need 1 is wasteful

### 3. **No Control**
- Anyone can create a new `DatabaseConnection` instance anytime
- No way to enforce "only one connection should exist"
- Public constructor allows unlimited instantiation

### 4. **Scalability Issues**
- Databases have connection limits (e.g., PostgreSQL default: 100)
- If every module creates its own connection, you'll quickly exhaust the limit
- In production with many users, this becomes catastrophic

## Real-World Impact

Imagine a web application with 1000 concurrent users:
- **WITHOUT Singleton**: Could create 1000+ database connections → Server crash
- **WITH Singleton**: Uses 1 connection (or a controlled connection pool) → Stable performance

## The Solution: Singleton Pattern

The Singleton pattern ensures:
- ✅ Only **ONE instance** of DatabaseConnection exists
- ✅ Global access point to that single instance
- ✅ Controlled resource usage
- ✅ Prevents accidental multiple instantiation

### How to Fix This Code

Make the constructor **private** and provide a static method to get the single instance:

```java
public class DatabaseConnection {
    private static DatabaseConnection instance;
    private final String host;
    private final Integer port;
    
    // Private constructor - prevents external instantiation
    private DatabaseConnection(String host, Integer port) {
        this.host = host;
        this.port = port;
        System.out.println("Creating THE ONLY connection");
    }
    
    // Global access point - creates instance only once
    public static DatabaseConnection getInstance(String host, Integer port) {
        if (instance == null) {
            instance = new DatabaseConnection(host, port);
        }
        return instance;
    }
}
```

Then the client code becomes:
```java
for (int i = 0; i < 11; i++) {
    DatabaseConnection connection = DatabaseConnection.getInstance("host", 4324);
    // All 11 iterations get the SAME instance!
}
```

## When to Use Singleton Pattern

Use Singleton when you need **exactly one instance** of a class:

- **Database connections / connection pools**
- **Configuration managers**
- **Logger classes**
- **Cache managers**
- **Thread pools**
- **Device drivers**
- **File system managers**

## Key Takeaways

| Without Singleton | With Singleton |
|-------------------|----------------|
| 11 objects created | 1 object created |
| High memory usage | Minimal memory usage |
| Resource waste | Resource efficient |
| No control | Controlled access |
| Scalability issues | Scales well |

## Learning Objectives

This demonstration teaches:
1. The problem of uncontrolled object creation
2. Why resource-intensive objects need special handling
3. How the Singleton pattern provides a solution
4. Real-world implications of poor resource management

## Running the Code

```bash
javac DatabaseConnection.java DatabaseConnectionClient.java
java DatabaseConnectionClient
```

Observe how 11 separate connections are created - this is the problem Singleton solves!

---

**Note**: This code intentionally demonstrates the **problem**. The next step is to refactor it using the Singleton pattern to solve these issues.