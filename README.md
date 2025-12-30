# Mouse Builder Pattern Example

This project demonstrates the **Builder Design Pattern** in Java using a real‑world example: a computer **Mouse**.

The goal is to show how Builder helps when:

* Some fields are **mandatory**
* Many fields are **optional**
* We want to avoid telescoping constructors and setters everywhere

---

## 📌 Problem

Without the Builder pattern, creating objects with optional parameters usually leads to:

1. **Telescoping constructors**
   Multiple overloaded constructors with different parameter combinations.

2. **Setters everywhere**
   Objects become mutable and can exist in an invalid or incomplete state.

The Builder pattern solves these problems by separating **object construction** from **object representation**.

---

## 🧱 Design Overview

### Mouse (Product)

* `brand` and `isWired` are **mandatory** fields
* `dpi`, `weight`, and `height` are **optional** fields
* The constructor is **private** and accepts a `MouseBuilder`

### MouseBuilder (Builder)

* Collects values step by step
* Enforces mandatory fields through its constructor
* Builds the `Mouse` object using the `build()` method

---

## 🧩 Mouse Class (Product)

```java
private Mouse(MouseBuilder mouseBuilder) {
    this.brand = mouseBuilder.brand;
    this.isWired = mouseBuilder.isWired;
    this.dpi = mouseBuilder.dpi;
    this.weight = mouseBuilder.weight;
    this.height = mouseBuilder.height;
}
```

* Prevents direct object creation
* Guarantees required fields are always set

---

## 🛠 MouseBuilder Class (Builder)

```java
public static MouseBuilder builder(String brand, boolean isWired) {
    return new MouseBuilder(brand, isWired);
}
```

* Mandatory fields are passed when creating the builder
* Optional fields are configured fluently

---

## ▶️ Usage Example

```java
Mouse mouse1 = Mouse.builder("METO", false)
        .dpi(400)
        .build();

Mouse mouse2 = Mouse.builder("ASUS-PI", true)
        .height(2)
        .build();
```

✔ Clear and readable
✔ No constructor explosion
✔ No setters in client code

---

## ✅ Benefits of This Approach

* Avoids telescoping constructors
* Avoids setters everywhere
* Enforces mandatory fields
* Supports optional fields cleanly
* Produces readable and maintainable code

---

## 🎯 When to Use Builder Pattern

Use Builder when:

* A class has **many optional parameters**
* You want **immutability or controlled mutability**
* Constructor overloads become hard to manage
* Object creation logic is complex

---

## 🧠 Summary

This example shows a clean and professional implementation of the Builder pattern using:

* A static inner builder
* Mandatory fields enforced at build time
* Fluent API for optional configuration

The Builder pattern provides a scalable and safe way to construct complex objects in Java.
