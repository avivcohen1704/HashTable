# Hash Table Java Project

## Project Description
### The main purpose of this project is to provide an in-depth understanding of the operation of hash tables using open addressing for conflict resolution. Through this exercise, we'll delve into various methods of open addressing, as taught in class, specifically:

- **Linear Probing**
- **Quadratic Probing**
- **Double Hashing**
  
## Implementation Details
### 1. Base Implementation
Our main entity is a hash table in Java. Every entry in the hash table is of type **HashTableElement** containing both a key and a value.

The primary interface to be implemented by the hash table is IHashTable which contains the following methods:

- **Insert**(HashTableElement h): Inserts the item h if there's free space in the search sequence of the h key and if there isn't any existing item with the same key. If a similar key is already present, it throws a KeyAlreadyExistsException. If no space is available in the search sequence, a TableFullException is thrown.
- **Find**(key): Returns the HashTableElement with the specified key if it exists, or null otherwise.
- **Delete**(key): Deletes the item with the specified key if it exists; otherwise, it throws a KeyDoesntExistException.

The abstract class *the **OAHashTable** should be implemented, which will in turn implement **IHashTable**. The sole abstract method in this class is **hash(key, index)**, which calculates the hash for a given key and index.

### 2. Probing Schemes
For this project, you will implement several concrete classes inheriting from **OAHashTable** each using different probing schemes:

ModHash:
Represents a hash function from a family of linear functions. It should have the following methods:

- **hash(key)**: Evaluates the function for a given key.
- **GenFunc(m, p)**: A static method that returns a ModHash object representing a randomly selected function from the family.
Specific Hash Table Implementations:
- **LPHashTable**: Implements linear probing using the hash functions from **ModHash**.
- **QPHashTable**: Implements quadratic probing. 
- **AQPHashTable**: Implements alternating quadratic probing.
- **DoubleHashTable**: Implements double hashing. 
 
## Conclusion
This project provides a deep dive into open addressing methods for hash table implementations. By implementing and experimenting with these methods, we gained a better understanding of their pros and cons, as well as their performance under different conditions. 
