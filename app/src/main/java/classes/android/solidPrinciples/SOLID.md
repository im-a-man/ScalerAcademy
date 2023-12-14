1=>Single Responsibility Principle (SRP):
Problem:> A class with multiple responsibilities is harder to understand, maintain, and modify.
Changes to one responsibility may inadvertently affect another.

Solution:> SRP helps in breaking down classes into smaller, focused units,
each responsible for a single aspect of functionality. This makes code more
modular and changes less likely to impact other parts of the system.

2=>Open/Closed Principle (OCP):
Problem:> In traditional systems, adding new functionality often requires modifying existing code,
which can introduce bugs and unintended side effects.

Solution:> OCP encourages the use of abstractions and interfaces. By programming to interfaces
and relying on abstraction, new features can be added through extension rather than modification,
reducing the risk of introducing errors in existing code.

3=>Liskov Substitution Principle (LSP):
Problem:> If a subclass cannot be substituted for its base class without affecting the correctness
of the program, it can lead to unexpected behavior.

Solution:> LSP ensures that inheritance hierarchies are designed in a way that subclasses can be
used interchangeably with their base classes. This promotes polymorphism and helps prevent
unexpected
issues when using derived classes.

4=>Interface Segregation Principle (ISP):
Problem:> Large, monolithic interfaces force classes to implement methods they don't need, leading
to unnecessary dependencies and potential code bloat.

Solution:> ISP suggests breaking down large interfaces into smaller, more specific ones. This
allows classes to implement only the methods they need, reducing coupling and promoting a cleaner
design.

5=>Dependency Inversion Principle (DIP):
Problem:> High-level modules depending on low-level modules create rigid and inflexible designs.
Changes in low-level modules can have a cascading effect on higher-level modules.

Solution:> DIP addresses this issue by advocating for the inversion of dependencies.
Instead of high-level modules depending directly on low-level modules, both should depend on
abstractions (interfaces or abstract classes). This makes the system more modular, flexible,
and easier to adapt to changes.

In summary, each SOLID principle addresses specific challenges in software design:

# SRP focuses on maintaining code clarity and manageability by advocating for single responsibility.
Each class should have only one responsibility, or one reason to change.

# OCP emphasizes extensibility without modifying existing code, promoting the use of abstractions and interfaces.

# LSP ensures that inheritance hierarchies maintain substitutability, preventing unexpected behavior.
chile must be a substitute of parent, or should comptable with system or parent contract

# ISP encourages the creation of small, specific interfaces, reducing unnecessary dependencies and promoting a cleaner design.

# DIP promotes the inversion of dependencies, making systems more modular, flexible, and adaptable to change.
