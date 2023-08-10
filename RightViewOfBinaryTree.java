//right view of the binary tree
/*
    this is the tree 
 *          1
 *         / \
 *        2   3
 *       / \  / \
 *      4  5  6  7
 *      if we observe from the right
 * 
 *      output : 1 3 7
 */

import java.util.*;

//node class which is the blueprint of tree node    
class TreeNode
{
    int data;           //data
    TreeNode left;      //left child
    TreeNode right;     //right child
    
    TreeNode( int data)     //constructor
    {
        //value assign
        this.data=data;
        this.left=null;
        this.right=null;
    } 
}

//this class is the main solution of this program
class Solution
{
    public ArrayList<Integer> rightView( TreeNode root )
    {
        //this method is called from main method
        //after perfrom the operation we should return a list containing values of right view 
        ArrayList<Integer>result=new ArrayList<>();
        rightViewHelper( root, result, 0);     //helper method call
        return result;
    }

    //helper method to find the right view nodes 
    public void rightViewHelper( TreeNode curr, ArrayList<Integer>result, int level )
    {
        if( curr==null )
        {   
            //in any position node value is null then return 
            return ;
        }

        //where level value same of list size
        //means we need to take the initial value
        if( level==result.size() )
        {
            //the value is added to the list
            result.add( curr.data);
        }

        //pre order traversal(reverse) used and everytime increment the level
        rightViewHelper( curr.right, result, level+1 ); //right call    
        rightViewHelper( curr.left, result, level+1 );  //left call
    }
}
 
//main class of the program
public class RightViewOfBinaryTree 
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
                //null value denotes -1 in the array
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
        int nodes[]={1,2,4,-1,-1,5,-1,-1,3,6,-1,-1,7,-1,-1 };

        BinaryTree bt=new BinaryTree();     
        TreeNode root=bt.buildTree( nodes);     //call the build tree method
        Solution sl=new Solution();

        ArrayList<Integer>al=sl.rightView( root );
        for( int i : al )
        {
            //print the result
            System.out.print( i+" ");
        }
    }
}

