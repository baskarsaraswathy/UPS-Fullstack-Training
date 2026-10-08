# Day 2 - Java Fundamentals

## Topics Covered
- Introduction to Java
- JDK -> JRE -> JVM
- Core Concepts
- Java Installation and Setup
- Version Checking
- Variables
- Primitive Data Types
- Operators
  - Arithmetic
  - Assignment
  - Relational / Comparison
  - Logical
  - Unary
  - Ternary
- Basic Git Commands

## Tasks
1. Print Bio-Data using Java through Command Prompt
## Program
```
public class BioData {
    public static void main(String[] args) {
        System.out.println("BIO-DATA");
        System.out.println("Name : Baskar");
        System.out.println("Age  : 20");
        System.out.println("Course : B.E CSE");
    }
}
```
### Output
<img width="513" height="195" alt="image" src="https://github.com/user-attachments/assets/26f4f2e9-94b8-4c01-9611-3e1295b441ce" />

2. Print Positive or Negative using Ternary Operator
## Program
```
Negative

public class BioData {
    public static void main(String[] args) {
        int n = -5;
        String result = (n >= 0) ? "Positive" : "Negative";
        System.out.println(result);
    }
}

Positive

public class BioData {
    public static void main(String[] args) {
        int n = 5;
        String result = (n >= 0) ? "Positive" : "Negative";
        System.out.println(result);
    }
}
```
### Output
Negative:
<img width="492" height="112" alt="image" src="https://github.com/user-attachments/assets/002cbffa-421d-44e3-bddd-d444bc9e7a60" />

Positive:
<img width="491" height="110" alt="image" src="https://github.com/user-attachments/assets/9681ec55-a515-454a-bd67-ba92cd18881f" />

3. Print Odd or Even using Ternary Operator
## Program
```
Odd

public class BioData {
    public static void main(String[] args) {
       int n = 7;
       String result = (n % 2 == 0) ? "Even" : "Odd";
       System.out.println(result);
    }
}

Even

public class BioData {
    public static void main(String[] args) {
       int n = 6;
       String result = (n % 2 == 0) ? "Even" : "Odd";
       System.out.println(result);
    }
}

```

### Output
Odd:
<img width="491" height="105" alt="image" src="https://github.com/user-attachments/assets/2712bcea-18fa-4947-9678-e096a5432383" />

Even:
<img width="515" height="118" alt="image" src="https://github.com/user-attachments/assets/5f1b276e-eee2-4aef-856e-dfd0a1ed0c9e" />
