# Object Copying Problem: The Private Field Challenge

## Overview

This project demonstrates a fundamental problem in object-oriented programming: **why you cannot reliably copy an object "from the outside"** when it contains private fields.

## The Problem

When attempting to create a copy of an object by manually copying its fields from external code, you encounter the **private field encapsulation barrier**. Private fields are intentionally hidden and inaccessible from outside the class, making complete object duplication impossible without proper mechanisms.

## Code Demonstration

### The Airplane Class
```java
public class Airplane {
    public String model;              // ✅ Accessible from outside
    private String engineSerial;      // ❌ NOT accessible from outside
    private Integer flightHours;      // ❌ NOT accessible from outside
    
    // Constructor and methods...
}
```

### The Problem in Action
```java
Airplane original = new Airplane("Cessna 172", 2020);
original.fly(150);

System.out.println("Original: " + original.getInfo());
// Output: Original: Airplane{model='Cessna 172', engineSerial='ENG-2020', flightHours=150}

// Attempt to copy from outside
Airplane copy = new Airplane("Cessna 172", 2020);
copy.model = original.model;  // ✅ Works - public field

// These would cause COMPILE ERRORS:
// copy.engineSerial = original.engineSerial;  // ❌ Private!
// copy.flightHours = original.flightHours;    // ❌ Private!

System.out.println("Copy: " + copy.getInfo());
// Output: Copy: Airplane{model='Cessna 172', engineSerial='ENG-2020', flightHours=0}
```

## Expected Output
```
Original: Airplane{model='Cessna 172', engineSerial='ENG-2020', flightHours=150}
Copy: Airplane{model='Cessna 172', engineSerial='ENG-2020', flightHours=0}
```

## Why the Copy is Incomplete

| Field | Original Value | Copy Value | Status |
|-------|---------------|------------|--------|
| `model` | Cessna 172 | Cessna 172 | ✅ Copied successfully |
| `engineSerial` | ENG-2020 | ENG-2020 | ⚠️ Set by constructor, not copied |
| `flightHours` | 150 | 0 | ❌ **LOST!** Cannot access from outside |

The copy appears to have the correct model and engine serial, but the `flightHours` field is reset to 0 because:
1. We cannot access `original.flightHours` from outside the class (it's private)
2. The constructor initializes `flightHours` to 0
3. The actual flight history (150 hours) is permanently lost in the copy

## The Solution: Copy Constructor

To properly copy an object with private fields, implement a **copy constructor** that operates from *inside* the class where private fields are accessible:
```java
public class Airplane {
    public String model;
    private String engineSerial;
    private Integer flightHours;
    
    // Regular constructor
    public Airplane(String model, int year) {
        this.model = model;
        this.engineSerial = "ENG-" + year;
        this.flightHours = 0;
    }
    
    // Copy constructor - has access to private fields!
    public Airplane(Airplane other) {
        this.model = other.model;
        this.engineSerial = other.engineSerial;      // ✅ Accessible here
        this.flightHours = other.flightHours;        // ✅ Accessible here
    }
    
    // ... rest of the methods
}
```

### Usage with Copy Constructor
```java
Airplane original = new Airplane("Cessna 172", 2020);
original.fly(150);

Airplane copy = new Airplane(original);  // Perfect copy!

System.out.println("Original: " + original.getInfo());
System.out.println("Copy: " + copy.getInfo());
// Both now show: flightHours=150
```

## Key Takeaways

1. **Encapsulation prevents external copying**: Private fields are hidden by design and cannot be accessed from outside the class
2. **Incomplete copies are dangerous**: Missing private field values can lead to incorrect program behavior
3. **Objects must copy themselves**: Proper copying requires mechanisms that work from *inside* the class
4. **Common solutions**:
    - Copy constructors
    - `clone()` method (implements `Cloneable`)
    - Factory methods
    - Builder pattern with copy functionality

## Running the Code
```bash
javac Airplane.java AirplaneClient.java
java AirplaneClient
```

## Lesson

**"Copying an object from the outside isn't always possible."**

When designing classes that need to be copied, always provide a proper copying mechanism that has access to all internal state, including private fields.

---

*This example illustrates why object-oriented design patterns like the Prototype pattern and language features like copy constructors exist—they solve the fundamental problem of creating true copies of encapsulated objects.*