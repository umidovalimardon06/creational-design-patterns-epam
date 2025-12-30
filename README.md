# Problems Without the Builder Design Pattern

Using a class with many optional parameters without the Builder pattern can lead to several issues:

## 1. Telescoping Constructors
- When a class has many optional fields, you end up writing multiple constructors with increasing numbers of parameters.
- This is hard to read, error-prone, and difficult to maintain.

## 2. Setters Everywhere
- Optional fields are often set using setters after object creation.
- This makes the object mutable and can lead to inconsistent or invalid states.