
package BinarySearchTree;

public class Node <I extends Comparable <I>> {
    protected I element; 
    protected Node <I> left;
    protected Node <I> right; 
    public Node(I ev){
        element = ev;
    }
}
