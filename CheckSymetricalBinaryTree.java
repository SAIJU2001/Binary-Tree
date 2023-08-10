/*
 *       input:
 *          1
 *         / \
 *        2   3
 *       / \  / \
 *      4  5  6  7
 *   
 *      output : false
 * 
 *      input:
 *          1
 *         / \
 *        2   2
 *       / \  / \
 *      4  5  5  4
 *   
 *      output : true
 *      
 */

import java.util.*;

//node class which is the blueprint of tree node    
class TreeNode
{
    int data;       //data
    TreeNode left;  //left child
    TreeNode right; //right child
    int hd;         //horizontal distance
    
    TreeNode( int data) //constructor
    {
        //assign the values
        this.data=data;
        this.left=null;
        this.right=null;
    }
}

class Solution
{
    //check symetric tree
    public boolean isSymetric( TreeNode root)
    {
        //if both case are false then return false
        return root==null || isSymetricHelper( root.left, root.right );
    }

    //helper method 
    private boolean isSymetricHelper( TreeNode left, TreeNode right )
    {
        if( left==null || right==null )
        {
            //if any node or both node null return the compre value
            return left==right;
        }

        if( left.data!=right.data )
        {
            //if the values are not same return false
            return false;
        }

        //symetric means root.left=root.right
        //if this two method returns true then only true otherwise false
        return isSymetricHelper( left.left, right.right ) && isSymetricHelper( left.right, right.left );
    }
}

//main class
public class CheckSymetricalBinaryTree 
{
    //this class makes the binary tree
    static class BinaryTree
    {
        int index=-1;   //index intialize 
        public TreeNode buildTree( int nodes[] )
        {
            index++;
            if( nodes[index]==-1 )
            {
                //null value denotes - in the array
                return null;
            }
            TreeNode newNode=new TreeNode(nodes[index]);    //tree node creation
            newNode.left=buildTree( nodes );    //left call
            newNode.right=buildTree( nodes );   //right call
            return newNode; 
        }
    }
    public static void main(String args[])
    {
        //nodes array is the preorder fromat of the tree
        int nodes[]={1,2,4,-1,-1,5,-1,-1,3,6,-1,-1,7,-1,-1 };   //not symetric
        //int nodes[]={1,2,4,-1,-1,5,-1,-1,2,5,-1,-1,4,-1,-1 };   // symetric

        BinaryTree bt=new BinaryTree();     
        TreeNode root=bt.buildTree( nodes);     //call the build tree method
        Solution sl=new Solution();

        boolean check=sl.isSymetric( root );
        System.out.print( check);
    }    
}
