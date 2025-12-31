# Prototype Pattern Solution with Cloneable Interface

## Overview

This document demonstrates solving the object copying problem using Java's **Cloneable interface** and **clone() method**. This is the Prototype Pattern implementation in Java.

---

## The Solution

### Airplane.java
```java
public class Airplane implements Cloneable {
    public final String model;
    private final String engineSerial;
    private Integer flightHours;

    public Airplane(String model, int year) {
        this.model = model;
        this.engineSerial = "ENG-" + year;
        this.flightHours = 0;
    }

    public void fly(int hours) {
        this.flightHours = hours;
    }

    public String getInfo() {
        return "Airplane{" +
                "model='" + model + '\'' +
                ", engineSerial='" + engineSerial + '\'' +
                ", flightHours=" + flightHours +
                '}';
    }

    @Override
    public Airplane clone() {
        try {
            return (Airplane) super.clone();
        } catch (CloneNotSupportedException ex) {
            throw new AssertionError();
        }
    }
}
```

### AirplaneClient.java
```java
public class AirplaneClient {
    public static void main(String[] args) {
        Airplane original = new Airplane("Cessna 172", 2020);
        original.fly(150);

        System.out.println("Original: " + original.getInfo());
        
        Airplane copy = original.clone();
        
        System.out.println("Copy: " + copy.getInfo());
    }
}
```

---

## Output
```
Original: Airplane{model='Cessna 172', engineSerial='ENG-2020', flightHours=150}
Copy: Airplane{model='Cessna 172', engineSerial='ENG-2020', flightHours=150}
```

✅ **Perfect copy! All fields including private ones are copied correctly.**

---

## How It Works

### Step 1: Implement Cloneable Interface
```java
public class Airplane implements Cloneable {
    // This marker interface tells JVM that cloning is allowed
}
```

### Step 2: Override clone() Method
```java
@Override
public Airplane clone() {
    try {
        // super.clone() creates a shallow copy of ALL fields
        return (Airplane) super.clone();
    } catch (CloneNotSupportedException ex) {
        throw new AssertionError();
    }
}
```

### Step 3: Use clone() to Create Copies
```java
Airplane copy = original.clone();  // ✅ Perfect copy!
```

---

## Key Components

### 1. Cloneable Interface
- **Marker interface** (has no methods)
- Signals to JVM that cloning is permitted
- Without it, `clone()` throws `CloneNotSupportedException`

### 2. super.clone()
- Calls `Object.clone()` (native method)
- Has special JVM privileges to access **all fields** (even private)
- Creates a **shallow copy** by default

### 3. Exception Handling
- `Object.clone()` throws checked exception
- Since we implement `Cloneable`, exception should never occur
- Convert to `AssertionError` (unchecked exception)

### 4. Public Override
- `Object.clone()` is `protected`
- We override as `public` to make it accessible

---

## Why This Solves the Problem

| Approach | Can Copy Private Fields? | Result |
|----------|-------------------------|--------|
| External copying | ❌ No | Incomplete copy (flightHours = 0) |
| **Cloneable + clone()** | ✅ **Yes** | **Perfect copy (flightHours = 150)** |

The `clone()` method works because `Object.clone()` is a **native method** with special JVM-level access to all object fields, bypassing Java's normal access control.

---

## Advantages

✅ **Polymorphic copying** - works through base class references  
✅ **Standard Java approach** - recognized convention  
✅ **Minimal code** - just implement interface and override method  
✅ **Works with final fields** - unlike some manual approaches  
✅ **Performance** - native method is optimized

---

## Disadvantages

❌ **Checked exception** - must handle `CloneNotSupportedException`  
❌ **Controversial** - criticized in *Effective Java*  
❌ **Shallow copy** - mutable objects need extra work  
❌ **Marker interface** - confusing pattern

---

## When to Use

### ✅ Use Cloneable When:
- You need polymorphic copying
- Working with inheritance hierarchies
- Existing APIs expect `Cloneable`

### ❌ Don't Use Cloneable When:
- Simple class with no inheritance
- Copy constructor would be simpler
- Following *Effective Java* best practices

---

## Running the Code
```bash
# Compile
javac Airplane.java AirplaneClient.java

# Run
java AirplaneClient
```

---

## Key Takeaway

The **Prototype Pattern with Cloneable** solves the external copying problem by using `Object.clone()`, a native method with special access to copy all fields (including private ones) at the JVM level.

**Trade-off:** More complex than copy constructor, but supports polymorphic copying.