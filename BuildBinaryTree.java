import java.util.*;

public class BuildBinaryTree
{
    static class Node
    {
        //node class for creating the tree
        int data;   //tree node data
        Node left;  //left node 
        Node right; //right node

        Node( int data)     //constructor
        {
            this.data=data;
            this.left=null;
            this.right=null;
        }
    }

    static class BinaryTree
    {
        int index=-1;   //index pointer to traverse node array
        Node buildTree( int nodes[] )
        {
            index++;
            if( nodes[index]==-1)
            {
                //if node array element value is -1 it means null
                return null;
            }

            Node newNode=new Node( nodes[index]);   //new node creation
            newNode.left=buildTree( nodes );    //left call for build
            newNode.right=buildTree( nodes );   //right call for build

            return newNode;
        }
    }

    //tree travesal technique( pre order )
    static void preOrder( Node root )
    {
        if( root==null )
        {
            //if root is null means no existance of node so return
            return;
        }

        System.out.print( root.data+" " );  //print roots data
        preOrder( root.left );      //left call
        preOrder( root.right );     //right call
    }

    public static void main( String args[])
    {
        //here node in pre order
        int nodes[]={1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};     //node array
        BinaryTree bt=new BinaryTree();     //object create
        Node root=bt.buildTree( nodes );    //method call
        preOrder( root );                   //print the value
    }
}