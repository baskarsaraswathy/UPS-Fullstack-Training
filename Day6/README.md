# 🚀 Day 6 – Java Interfaces & Memory Management

> Learn daily. Code consistently. Build intelligently.

## 📚 Topics Covered
- Java Interface syntax
- `interface` and `implements`
- Implementing interface methods
- Interface references and objects
- Why an interface cannot be instantiated directly
- Non-primitive data types
- Stack memory and heap memory
- Class metadata and method area (conceptual JVM memory model)

## 💻 Practice Programs

| Program | Description |
|---|---|
| `InterfaceExample.java` | Creates an RBI interface and implements it in SBI |
| `MultipleImplementations.java` | Demonstrates SBI and IB implementing the same interface |
| `StudentMemoryExample.java` | Demonstrates an object reference and an object |
| `InterfaceSyntax.java` | A small example of interface syntax |

## 🧠 Key Notes

- An interface defines a contract that implementing classes must follow.
- Use `implements` when a class implements an interface.
- Interface methods declared without a body are implicitly `public abstract`.
- Implemented methods must be `public`.
- You cannot instantiate an interface directly, but an interface reference can point to an implementing-class object.
- Objects and instance data are generally stored on the heap.
- Local variables and method-call frames are associated with the stack.
- Class metadata and method information are managed by the JVM; exact memory implementation details can vary.

## ▶️ Run a Program

Open CMD in the folder containing the Java file and run:

```bash
javac InterfaceExample.java
java InterfaceExample
```

Use the matching file and public class name for other programs.

## 🎯 Learning Outcome

Practised Java interfaces, implementation, interface references, and the basic JVM memory model.

---

**Day 6 completed!** ✅

*Small steps. Consistent practice. Better coding.*
