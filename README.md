# URL Builder Pattern Example

This project demonstrates the **Builder Design Pattern** in Java using a real-world example: constructing URLs.

The Builder pattern is used here to **create complex URL objects** in a readable and safe way, while handling **mandatory and optional fields**.

---

## 📌 Problem

Without a builder, creating URLs with optional components (port, path, query) can become messy:

* Multiple constructors for different combinations
* Setters leading to partially initialized or invalid objects
* Hard-to-read object creation

The Builder pattern solves these problems by separating **object construction** from **object representation**.

---

## 🧱 Design Overview

### Url (Product Class)

* `protocol` and `host` are **mandatory fields**
* `port`, `pathParam`, and `queryParam` are **optional fields**
* Constructor is **private** and accepts a `UrlBuilder`

### UrlBuilder (Builder Class)

* Collects values for optional fields step by step
* Enforces mandatory fields through its constructor
* Builds the `Url` object with the `build()` method

---

## 🛠 UrlBuilder API

```java
Url url = Url.builder("https", "example.com")
             .port(8080)
             .pathParam("/api")
             .queryParam("id=1")
             .build();
```

* `builder(String protocol, String host)` initializes mandatory fields
* `port()`, `pathParam()`, `queryParam()` are optional and chainable
* `build()` returns the final `Url` object

---

## ▶️ Example Usage

```java
Url url1 = Url.builder("https://", "mywebsite")
        .port(8080)
        .pathParam("/company")
        .build();

Url url2 = Url.builder("https://", "binance")
        .port(8080)
        .pathParam("/wallet")
        .build();

System.out.println(url1.toString()); // https://mywebsite:8080/company
System.out.println(url2.toString()); // https://binance:8080/wallet
```

---

## ✅ Benefits

* Avoids telescoping constructors
* Ensures mandatory fields are always set
* Supports optional fields in a **fluent and readable way**
* Produces a valid URL string automatically

---

## 🎯 When to Use Builder Pattern

Use Builder when:

* A class has **many optional fields**
* Object creation logic is **complex**
* You want **immutability or controlled mutability**
* Constructor overloads become difficult to maintain

---

## 🧠 Summary

This example demonstrates a clean and professional implementation of the Builder pattern:

* Static inner Builder class
* Mandatory fields enforced at builder creation
* Optional fields set fluently
* `toString()` generates a **valid URL** string

The pattern ensures **readability, maintainability, and correctness** in object creation.
