# MessageApp – Factory Pattern Solution Documentation

## 1. Objective

The goal of this solution is to refactor the original `MessageApp` implementation to:

* Eliminate tight coupling
* Follow **SOLID principles**
* Improve scalability and maintainability

This is achieved by introducing the **Factory Design Pattern** and a common abstraction for message services.

---

## 2. High-Level Design Overview

The refactored design separates responsibilities across multiple layers:

* **Message (Interface):** Defines a common contract for all message types
* **Concrete Message Classes:** Implement the `Message` interface (`EmailMessage`, `SmsMessage`, etc.)
* **MessageFactory:** Encapsulates object creation logic
* **MessageApp:** Acts as the client and uses the factory without knowing concrete implementations

---

## 3. Package Structure

```
java
 ├── factory
 │    └── MessageFactory
 │
 ├── message
 │    ├── Message        (interface)
 │    ├── EmailMessage   (implementation)
 │    ├── SmsMessage     (implementation)
 │
 └── MessageApp
```

This structure ensures clear separation of concerns and improves code organization.

---

## 4. Component Responsibilities

### 4.1 Message Interface

**Responsibility:**

* Defines a common contract for all message types

**Benefit:**

* Enables polymorphism
* Allows the application to work with abstractions instead of concrete classes

---

### 4.2 Concrete Message Implementations

Examples:

* `EmailMessage`
* `SmsMessage`

**Responsibility:**

* Implement the `send()` behavior specific to each message type

**Benefit:**

* Each class has a single responsibility
* Easy to add or modify message behavior independently

---

### 4.3 MessageFactory

```java
public class MessageFactory {
    public static Message createMessage(String type) {
        if (type.equals("EMAIL")) {
            return new EmailMessage();
        } else if (type.equals("SMS")) {
            return new SmsMessage();
        }
        return null;
    }
}
```

**Responsibility:**

* Centralizes object creation logic
* Decides which concrete `Message` implementation to instantiate

**Benefit:**

* Removes object creation logic from `MessageApp`
* Improves maintainability and readability

---

### 4.4 MessageApp (Client)

```java
Message email = MessageFactory.createMessage("EMAIL");
email.send();
```

**Responsibility:**

* Uses the factory to obtain a `Message`
* Executes behavior without knowing implementation details

**Benefit:**

* Loosely coupled to concrete classes
* Easy to test and extend

---

## 5. SOLID Principles Applied

### 5.1 Single Responsibility Principle (SRP)

* `MessageApp` → Application flow only
* `MessageFactory` → Object creation only
* Message classes → Message sending logic only

✔ Each class has one clear responsibility

---

### 5.2 Open/Closed Principle (OCP)

* New message types (e.g., `TelegramMessage`) can be added
* Existing client code (`MessageApp`) remains unchanged

✔ System is open for extension, closed for modification (client side)

---

### 5.3 Dependency Inversion Principle (DIP)

* `MessageApp` depends on the `Message` abstraction, not concrete implementations

✔ High-level modules depend on abstractions

---

## 6. Improvements Over Original Design

| Aspect           | Before               | After                  |
| ---------------- | -------------------- | ---------------------- |
| Coupling         | Tight                | Loose                  |
| SOLID Compliance | Violated             | Followed               |
| Object Creation  | In client            | Centralized in factory |
| Scalability      | Poor                 | Improved               |
| Readability      | Complex conditionals | Clean and structured   |

---

## 7. Limitations & Future Enhancements

### Current Limitation

* `MessageFactory` still uses conditional logic (`if-else`)

### Possible Enhancements

* Replace conditionals with:

    * Enum-based factory
    * Map-based registry
    * Dependency Injection (Spring)

---

## 8. Conclusion

This refactored solution successfully addresses the design issues in the original implementation by:

* Applying the **Factory Design Pattern**
* Following **SOLID principles**
* Improving code maintainability and scalability

The system is now easier to extend, test, and maintain while keeping the client code clean and decoupled.

---

**Design Pattern Used:** Factory Pattern
