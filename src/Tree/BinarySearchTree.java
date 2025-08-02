package Tree;

import java.util.LinkedList;

public class BinarySearchTree<T extends Comparable<T>> implements IBinarySearchTree<T> {

    private BinaryTree<T> binaryTreeRoot;
    
    public BinarySearchTree(T data){
        binaryTreeRoot = new BinaryTree<T>(data);
    }

    public void insert(T data){
        if(containsKey(data)) throw new IllegalArgumentException("Element already exists in the Tree. No Duplicates allowed.");
        Node<T> traverseNode = binaryTreeRoot.getRoot();

        while((traverseNode.getLeft() != null) || (traverseNode.getRight() != null)){
            if(lessThan(data,traverseNode.getNodeData())){
                if(traverseNode.getLeft() == null) break; // If only right subtree exists then the this node is first in left subtree
                traverseNode = traverseNode.getLeft();
            }
            else{
                if(traverseNode.getRight() == null) break; // If only left subtree exists then the this node is first in right subtree
                traverseNode = traverseNode.getRight();
            }
        }
        // Data Insertion
        if(lessThan(data,traverseNode.getNodeData())) {
            traverseNode.setLeft(new Node<T>(data));
        }
        else{
            traverseNode.setRight(new Node<T>(data));
        }
    }

    void removeLeaf(T data){
        Node<T> traverseNode = binaryTreeRoot.getRoot();
        Node<T> traverseNodeParent = binaryTreeRoot.getRoot(); // To make the links to nodes null
        while (!traverseNode.getNodeData().equals(data)){
            traverseNodeParent = traverseNode;
            if(lessThan(data,traverseNode.getNodeData())) traverseNode = traverseNode.getLeft();
            else traverseNode = traverseNode.getRight();
        }
        if(traverseNode == traverseNodeParent.getLeft()) traverseNodeParent.setLeft(null);
        else traverseNodeParent.setRight(null);
        traverseNode = null;
    }
    void removeHalfSubtree(T data){
        Node<T> subTreeTraverseNode = binaryTreeRoot.getRoot();
        Node<T> traverseNodeParent = binaryTreeRoot.getRoot(); // To make the links to nodes null
        while (!subTreeTraverseNode.getNodeData().equals(data)){
            traverseNodeParent = subTreeTraverseNode;
            if(lessThan(data,subTreeTraverseNode.getNodeData())) subTreeTraverseNode = subTreeTraverseNode.getLeft();
            else {
                subTreeTraverseNode = subTreeTraverseNode.getRight();
            }
        }
        traverseNodeParent.setLeft(subTreeTraverseNode.getLeft());
        traverseNodeParent.setRight(subTreeTraverseNode.getRight());
        subTreeTraverseNode = null;
    }
    void removeFullSubtree(Node<T> startNode){
        // Chooses smallest from Right subtree i.e Smallest element from the right subtree
        Node<T> subTreeTraverseNode = startNode;
        Node<T> leftMostNode = getLeftMostNode(subTreeTraverseNode);
        T tempData = leftMostNode.getNodeData();
        removeLeaf(tempData);
        subTreeTraverseNode.setNodeData(tempData);
    }
    void removeNode(T data){
        Node<T> traverseNode = binaryTreeRoot.getRoot();
        if(!containsKey(data)) throw new IllegalArgumentException("No such node in the tree");
        while (!traverseNode.getNodeData().equals(data)){
            if(lessThan(data,traverseNode.getNodeData())) traverseNode= traverseNode.getLeft();
            else traverseNode = traverseNode.getRight();
        }

        // 1. If Tree.Node is a left
        if(traverseNode.getLeft() == null && traverseNode.getRight() == null) removeLeaf(data);
            // 2. If only one of the subtrees is null
        else if (traverseNode.getLeft() == null || traverseNode.getRight() == null) removeHalfSubtree(data);
            // 3. If the Tree.Node has both the subtrees
        else removeFullSubtree(traverseNode.getRight());
    }

    private Node<T> getLeftMostNode(Node<T> startNode){
        while(startNode.getLeft() != null) startNode = startNode.getLeft();
        return startNode;
    }

    private Node<T> getRightMostNode(Node<T> startNode){
        while(startNode.getRight() != null) startNode = startNode.getRight();
        return startNode;
    }

    // Traversals

    void inOrderTraverseRecursive(Node<T> traverseNode){
        if(traverseNode == null){
            return;
        }
        this.inOrderTraverseRecursive(traverseNode.getLeft());
        System.out.print(traverseNode.getNodeData() + " ");
        this.inOrderTraverseRecursive(traverseNode.getRight());
    }

    void preOrderTraverseRecursive(Node<T> traverseNode){
        if(traverseNode == null){
            return;
        }
        System.out.print(traverseNode.getNodeData() + " ");
        this.preOrderTraverseRecursive(traverseNode.getLeft());
        this.preOrderTraverseRecursive(traverseNode.getRight());
    }

    void postOrderTraverseRecursive(Node<T> traverseNode){
        if(traverseNode == null){
            return;
        }
        this.postOrderTraverseRecursive(traverseNode.getLeft());
        this.postOrderTraverseRecursive(traverseNode.getRight());
        System.out.print(traverseNode.getNodeData() + " ");
    }

    void levelOrderTraverseIterative(){
        if(binaryTreeRoot.getRoot() == null) throw new NullPointerException("Root Tree.Node is Null! Tree empty.");

        LinkedList<Node<T>> levelQueue = new LinkedList<>();
        levelQueue.addLast(binaryTreeRoot.getRoot());

        while (!(levelQueue.isEmpty())){
            Node<T> currentNode = levelQueue.getFirst();
            if(currentNode.getLeft() != null){
                levelQueue.addLast(currentNode.getLeft());
            }
            if(currentNode.getRight() != null){
                levelQueue.addLast(currentNode.getRight());
            }
            System.out.print(currentNode.getNodeData()+ " ");
            levelQueue.removeFirst();
        }
    }

    // Helpers

    public boolean lessThan(T aValue, T bValue){
        // Duplicate insertions not supported
        return aValue.compareTo(bValue) < 0;
    }

    public boolean containsKey(T data){
        Node<T> traverseNode = binaryTreeRoot.getRoot(); // Start finding from root
        while (traverseNode != null){
            T nodeData = traverseNode.getNodeData();
            if (nodeData.equals(data)) return true;

            if( lessThan(data,nodeData)){
                traverseNode = traverseNode.getLeft();
            }
            else{
                traverseNode = traverseNode.getRight();
            }
        }
        /* O(logn) Always case if checked during every insertion. 
        * */
        return false;
    }

    public static void main(String[] args) {
        BinarySearchTree<Integer> testBST = new BinarySearchTree<Integer>(10);
        // Insert
        testBST.insert(5);
        testBST.insert(20);
        testBST.insert(9);
        testBST.insert(8);
        testBST.insert(2);
        testBST.insert(18);
        testBST.insert(21);
        testBST.insert(22);
        // Remove leaves
        testBST.removeNode(2);
        testBST.removeNode(8);
        testBST.removeNode(22);
        // Remove half subtree
        testBST.removeNode(9);
        // Removing Full subtree
        testBST.removeNode(20);
        testBST.levelOrderTraverseIterative();
    }

    @Override
    public void remove(T data) {
        this.removeNode(data);
    }

    @Override
    public int height() {
        return 0;
    }

    @Override
    public void printPreorder() {
        preOrderTraverseRecursive(binaryTreeRoot.getRoot());
    }

    @Override
    public void printInorder() {
        inOrderTraverseRecursive(binaryTreeRoot.getRoot());
    }

    @Override
    public void printPostOrder() {
        postOrderTraverseRecursive(binaryTreeRoot.getRoot());
    }

    @Override
    public void printLevelOrder() {
        levelOrderTraverseIterative();
    }
}
