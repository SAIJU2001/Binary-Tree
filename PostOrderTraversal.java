//post order traversal 
// left subtree => right subtree => root 
/*
 *      input: nodes[]={1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1}
 *      output: 4 5 2 6 3 1
 */

import java.util.*;

public class PostOrderTraversal 
{
    static class Node
    {
        //implement node which has a data and two pointer fror left and right child
        int data;
        Node left;
        Node right;

        Node( int data) //constructor
        {
            this.data=data;
            this.left=null;
            this.right=null;
        }
    }

    static class BinaryTree
    {
        int index=-1;           //index pointer

        //build tree from a preorder array
        Node buildTree( int nodes[] )
        {
            index++;
            if( nodes[index]==-1)
            {
                //if elemnet is -1 then there is not any node exists
                return null;
            }

            Node newNode=new Node( nodes[index]);   //new node create
            newNode.left=buildTree( nodes );        //call for left child
            newNode.right=buildTree( nodes );       //call for right child

            return newNode;     //return root
        }
    }

    //post order traversal method
    static void postOrder( Node root )
    {
        if( root==null )
        {
            return;
        }

        postOrder( root.left );     //first left subtree
        postOrder( root.right );       //then right sub tree
        System.out.print( root.data+" " );      //then root
    }

    public static void main( String args[])
    {
        Scanner Sc=new Scanner(System.in);
        int nodes[]={1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
        BinaryTree bt=new BinaryTree();     //call tree class
        Node root=bt.buildTree( nodes );  
        postOrder( root );  //postorder method call
    }
}
    
