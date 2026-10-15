# Day 8 – Java Multithreading, Exceptions & File Handling

UPS Fullstack Training — Java practice repository.

## Topics
- Thread, Runnable, start() and run()
- sleep(), join(), synchronization
- ATM example, wait() and notify()
- Exception handling: try, catch, throw, throws
- IOException and IllegalArgumentException
- File writing, reading, and file properties
- StringBuilder
- Student File Management System (4 classes)

## Run
For folders with one `Main.java`:
```bash
javac Main.java
java Main
```
For `17_StudentManagement`:
```bash
javac *.java
java Main
```

## Notes
- Thread output order can vary.
- `wait()` must be called while owning the object's monitor.
- `notify()` wakes a waiting thread, which continues after reacquiring the lock.
- The wait/notify example uses a short delay for demonstration only.
- `16_FileOperations` deletes `data.txt` after reading it.
- `StudentDAO.delete()` clears all records; it does not delete the file.
