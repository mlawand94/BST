//Program by: Nadine Sarraj, Mazen Lawand, Jonathan-Fils Aime, and Maisam Arif
//CS 2336.006
//This reads in the string from the file, and creates a BST.

package BinarySearchTree;
import java.util.*;

public class BinarySearchTree <I extends Comparable <I>> extends AbTree <I>  
{
    protected Node <I> root; //make the root of the tree
    protected int size= 0; 

        //default constructor        
    public BinarySearchTree(){
    }
    
    //Create a function for an array of objects
    public BinarySearchTree(I[] element)
    {
        for(int x = 0; x < element.length; x++)
        {
            insert(element[x]); //insert the objects into the array 
        }
    }
    
        protected Node<I> ConstructNode(I i)
    {
        return new Node<>(i);
    }
    
    
    protected void inOrder(Node<I> root)
    {
        if(root == null)
            return;
        inOrder(root.left);
        System.out.print(root.element + " ");
        inOrder(root.right);
    }

    
    protected void postOrder(Node<I> root)
    {
        if(root == null)
            return;
        System.out.println(root.element + " ");
        preOrder(root.left);
        preOrder(root.right);
    }
    
    protected void preOrder(Node<I> root)
    {
        if(root == null)
            return;
        postOrder(root.left);
        postOrder(root.right);
        System.out.println(root.element + " ");
    }
    
    @Override
    public void inOrder()
    {
        inOrder(root);
    }
    
    @Override
    public void preOrder()
    {
        preOrder(root);
    }
    
    @Override
    public void postOrder()
    {
        postOrder(root);
    }
    
    
    
    public static class BranchNode<I extends Comparable<I>>
    {
        protected I element;
        protected BranchNode<I> left;
        protected BranchNode<I> right;
        
        public BranchNode(I ev)
        {
            element  = ev;
        }
    }
    
    @Override
    public int getSize()  //Getting the size of the tree
    {
        return size;
    }
    
    public Node<I> getRoot() //Getting the root of the tree
    {
        return root;
    }
    
    public java.util.ArrayList<Node<I>> path(I ev)      //returns a path from top of tree to specified element
    {
        java.util.ArrayList<Node<I>> list = new java.util.ArrayList<>();
        Node<I> current = root;
        
        while(current!=null)
        {
            list.add(current);                  
            if(ev.compareTo(current.element)<0)
            {
                current = current.left;
            }
            else if(ev.compareTo(current.element)>0)
            {
                current = current.right;
            }
            else
                break;
        }
        return list;
    }
    
        public boolean look(I ev) { //Looks for a specified element in the data structure
        Node<I> current = root; //Starting the traversal from the root of the tree
        while (current != null) //checking to see if it's empty
        {
            if (ev.compareTo(current.element)<0) 
                current = current.left; //pass it to the left branch
            else if (ev.compareTo(current.element)>0)
                current = current.right; 
            else 
                return true; //element if found 
        }
        return false; //if it's empty, return false.

       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
        public boolean insert(I ev) {
        if (root == null)
        {
            root = ConstructNode(ev); //checking if there is no node, then create a new node.
        }
            else
        {
            Node<I> parent = null;  //Getting to the parent node.
            Node<I> current = root; 
            while(current != null){
                if(ev.compareTo(current.element) < 0) //if element is less than the node
                {
                    parent = current;
                    current=current.left;       //put it on the left side
                }
                else if(ev.compareTo(current.element) > 0){ //if element is greater than the node
                    parent = current;   
                    current = current.right;    //put it on the right side
                }
                else
                    return false; //so there is no duplicate
             //when current is null (when there is no BST), you create it
            if (ev.compareTo(parent.element)< 0)
                parent.left = ConstructNode(ev);    //put new node on left side of parent 
            else
                parent.right = ConstructNode(ev);    //put new node on right side of parent 
            }
        } //end of BST class
        size ++; 
        return true;//throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    @Override
    public boolean delete(I ev){ //GO TO FUNCTION
        Node <I> parent = null;       //going to locate the node that will be deleted 
        Node <I> current = root;
         while(current != null){
                if(ev.compareTo(current.element) < 0) //if element is less than the node
                {
                    parent = current;
                    current=current.left;       //put it on the left side
                }
                else if(ev.compareTo(current.element) > 0){ //if element is greater than the node
                    parent = current;   
                    current = current.right;    //put it on the right side
                }
                else
                    break;  //
            }
         if (current == null)
             return false; //element doesn't exist
         if (current.left == null)
         {
             if (parent == null){
                 root = current.right; 
             }
             else if (ev.compareTo (parent.element) <0)
             {
                 parent.left = current.right;
             }
             else{
                 parent.right = current.right;
             }
         }
         else{
             Node <I> RightParent = current; 
             Node <I> rightMost = current.left; 
             while (rightMost.right!= null)
             {
                RightParent = rightMost; 
                rightMost = rightMost.right;
             }
             current.element = rightMost.element; //replace element in current by element in rightMost
             if(RightParent.right == rightMost)
                 RightParent.right = rightMost.left; 
             else
                 RightParent.left = rightMost.left; 
         }
//if element is 
         size --;
         return true;   //element deleted
    }
    
    @Override 
    public java.util.Iterator<I> iterator()
    {
        return new IterateInorder();
    }
    
    private class IterateInorder implements java.util.Iterator<I>
    {
        private java.util.ArrayList<I> list = new java.util.ArrayList<>();
        private int current = 0;
        
        private void inOrder()
        {
            inOrder(root);
        }
       
        public IterateInorder()
        {
            inOrder();
        }
       
        
        private void inOrder(Node<I> root)
        {
            if(root==null)
                return;
            inOrder(root.left);
            list.add(root.element);
            inOrder(root.right);
        }
        
        @Override
        public boolean hasNext()
        {
            if(current < list.size())
                return true;
            
            return false;
        }
        @Override
        public I next()
        {
            return list.get(current++);
        }
        @Override
        public void remove()
        {
            delete(list.get(current));
            list.clear();
            inOrder();
        }
    }
    
    public void clear()
    {
        root = null;
        size = 0;
    }
}