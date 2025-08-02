# Data Structures Implementation in Java

A comprehensive collection of fundamental data structure implementations in Java, designed for educational purposes and practical use.

## 📋 Table of Contents

- [Overview](#overview)
- [Data Structures Implemented](#data-structures-implemented)
- [Project Structure](#project-structure)
- [Getting Started](#getting-started)
- [Usage Examples](#usage-examples)
- [Building and Testing](#building-and-testing)
- [Contributing](#contributing)

## 🎯 Overview

This repository contains clean, well-documented implementations of essential data structures in Java. Each implementation includes:

- Generic type support where applicable
- Comprehensive method implementations
- Example usage in main methods
- Clear documentation and comments

## 📊 Data Structures Implemented

### Linear Data Structures
- **Dynamic Array** (`src/Array/DynamicArray.java`) - Resizable array implementation
- **Stack** (`src/Stack/Stack.java`) - LIFO data structure using LinkedList
- **Queue** (`src/Queue/Queue.java`) - FIFO data structure with iterator support
- **Doubly Linked List** (`src/List/DoublyLinkedList.java`) - Bidirectional linked list

### Hash-based Data Structures
- **Hash Table with Separate Chaining** (`src/HashTable/HashTableSeparateChaining.java`)
- **Hash Table with Open Addressing** (`src/HashTable/HashTableOpenAddressing.java`)

### Tree Data Structures
- **Binary Search Tree** (`src/Tree/BinarySearchTree.java`) - Self-balancing BST with full CRUD operations
- **Binary Tree** (`src/Tree/BinaryTree.java`) - Basic binary tree implementation
- **Fenwick Tree** (`src/Tree/FenWickTree.java`) - Binary Indexed Tree for range queries
- **Tree Node** (`src/Tree/Node.java`) - Generic tree node implementation

### Heap Data Structures
- **Binary Heap** (`src/Heap/BinaryHeap.java`) - Abstract heap implementation
- **Binary Min Heap** (`src/Heap/BinaryMinHeap.java`) - Min-heap implementation
- **Binary Max Heap** (`src/Heap/BinaryMaxHeap.java`) - Max-heap implementation

### Advanced Data Structures
- **Union Find** (`src/Other/UnionFind.java`) - Disjoint Set Union with path compression

## 📁 Project Structure

```
Data-Structures/
├── src/
│   ├── Array/
│   │   └── DynamicArray.java
│   ├── HashTable/
│   │   ├── HashTableSeparateChaining.java
│   │   └── HashTableOpenAddressing.java
│   ├── Heap/
│   │   ├── BinaryHeap.java
│   │   ├── BinaryMinHeap.java
│   │   └── BinaryMaxHeap.java
│   ├── List/
│   │   └── DoublyLinkedList.java
│   ├── Other/
│   │   └── UnionFind.java
│   ├── Queue/
│   │   └── Queue.java
│   ├── Stack/
│   │   └── Stack.java
│   └── Tree/
│       ├── BinarySearchTree.java
│       ├── BinaryTree.java
│       ├── FenWickTree.java
│       ├── IBinarySearchTree.java
│       └── Node.java
├── pom.xml
├── .gitignore
└── README.md
```

## 🚀 Getting Started

### Prerequisites
- Java 11 or higher
- Maven 3.6 or higher (for building)

### Installation

1. Clone the repository:
```bash
git clone https://github.com/yourusername/Data-Structures-1.git
cd Data-Structures-1
```

2. Compile the project:
```bash
mvn compile
```

3. Run tests (if available):
```bash
mvn test
```

## 💡 Usage Examples

### Dynamic Array
```java
DynamicArray<Integer> arr = new DynamicArray<>(5);
arr.append(10);
arr.append(20);
arr.setValue(30, 0);
System.out.println(arr.getValue(0)); // Output: 30
```

### Stack
```java
Stack<String> stack = new Stack<>();
stack.push("Hello");
stack.push("World");
System.out.println(stack.top()); // Output: World
stack.pop();
```

### Binary Search Tree
```java
BinarySearchTree<Integer> bst = new BinarySearchTree<>(10);
bst.insertNode(5);
bst.insertNode(15);
bst.insertNode(3);
bst.levelOrderTraverseIterative(); // Prints tree level by level
```

### Hash Table
```java
HashTableSeparateChaining<String, Integer> hashTable = new HashTableSeparateChaining<>(10);
hashTable.put("apple", 5);
hashTable.put("banana", 3);
System.out.println(hashTable.get("apple")); // Output: 5
```

## 🔨 Building and Testing

### Using Maven

Build the project:
```bash
mvn clean compile
```

Package into JAR:
```bash
mvn package
```

### Manual Compilation

Compile all Java files:
```bash
javac -d out src/**/*.java
```

Run a specific class:
```bash
java -cp out Tree.BinarySearchTree
```

## 🤝 Contributing

1. Fork the repository
2. Create a feature branch (`git checkout -b feature/amazing-feature`)
3. Commit your changes (`git commit -m 'Add some amazing feature'`)
4. Push to the branch (`git push origin feature/amazing-feature`)
5. Open a Pull Request

## 📝 License

This project is open source and available under the [MIT License](LICENSE).
