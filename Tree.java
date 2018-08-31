//Program by: Mazen Lawand
//CS 2336.006 
//Need to create a tree class for printing out the following:
//preorder, inorder, and postorder traversals

package BinarySearchTree;

//header file for the functions in BST.java (Already calling functions)
public interface Tree <I> extends Iterable <I> {  
    public int getSize();
    public void preOrder();
    public void inOrder();
    public void postOrder();
    public boolean empty();
    public boolean look(I ev); //ev = element value 
    public boolean insert(I ev);
    public boolean delete (I ev);
}
