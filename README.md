# MessageApp – Design Problem Documentation

## 1. Overview

The `MessageApp` class is responsible for sending messages through multiple communication channels such as **Email**, **SMS**, **Telegram**, and **WhatsApp**.

In the current implementation, the message-sending logic is handled using a `switch` statement that directly creates instances of concrete service classes and invokes their `send()` methods.

Although the implementation works correctly from a functional perspective, it introduces several **design issues** that negatively impact scalability, maintainability, and adherence to object-oriented design principles.

---

## 2. Identified Design Problems

### 2.1 Tight Coupling

**Description:**
The `MessageApp` class is tightly coupled with concrete implementations such as `EmailService`, `SmsService`, `TelegramService`, and `WhatsAppService`.

**Why this is a problem:**

* Any change in a service class (constructor, behavior, dependencies) may require changes in `MessageApp`.
* Makes unit testing difficult because services cannot be easily mocked or replaced.

**Impact:**

* Reduced flexibility
* Poor testability

---

### 2.2 Violation of Single Responsibility Principle (SRP)

**Description:**
According to the Single Responsibility Principle, a class should have only one reason to change. However, `MessageApp`:

* Decides *which* message service to use
* Creates the service instance
* Executes the message sending

**Why this is a problem:**

* Business logic and object creation logic are mixed together
* Changes in message selection logic or service creation logic both affect the same class

**Impact:**

* Increased complexity
* Harder to maintain and extend

---

### 2.3 Violation of Open/Closed Principle (OCP)

**Description:**
The Open/Closed Principle states that software entities should be **open for extension but closed for modification**.

In the current design:

* Adding a new messaging service (e.g., `SlackService`) requires modifying the `switch` statement in `MessageApp`.

**Why this is a problem:**

* Existing code must be changed for every new feature
* Higher risk of introducing bugs into already working code

**Impact:**

* Poor scalability
* Frequent code modifications

---

### 2.4 Conditional Complexity

**Description:**
As more message types are added, the `switch` or `if-else` structure grows.

**Why this is a problem:**

* Code becomes harder to read and maintain
* Increased chance of logical errors

**Impact:**

* Reduced readability
* Increased maintenance cost

---

## 3. Summary of Issues

| Problem Area   | Description                                      |
| -------------- | ------------------------------------------------ |
| Tight Coupling | Direct dependency on concrete service classes    |
| SRP Violation  | Multiple responsibilities in `MessageApp`        |
| OCP Violation  | Modification required for every new message type |
| Scalability    | Conditional logic grows with new services        |

---

## 4. Conclusion

While the current implementation is simple and functional, it does not follow clean architecture or SOLID principles. As the system grows, this design will lead to:

* Increased maintenance effort
* Reduced flexibility
* Higher risk of defects

A refactoring using **abstraction (interfaces)** and **design patterns** (such as Factory or Strategy) would significantly improve the design and make the system more extensible and maintainable.

---

**Note:** This documentation focuses only on identifying and explaining the design problems. Proposed solutions and refactored designs should be documented separately.
