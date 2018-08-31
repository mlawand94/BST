//Program by: Nadine Sarraj, Mazen Lawand, Jonathan-Fils Aime, and Maisam Arif

package BinarySearchTree;

public abstract class AbTree <E> implements Tree <E> 
{
    @Override
    public boolean empty()
    {
        if (getSize()== 0)
            return true; //no tree nodes (empty).  
        else
            return false;
    }
    @Override 
    public void inOrder()//Traversing through the tree via inorder traversal
    {
    }
    @Override 
    public void preOrder()//Traversing through the tree via preorder traversal
    {
    } 
    @Override
    public void postOrder()//Traversing through the tree via postorder traversal
    {
    }
    
}
