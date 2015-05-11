/*
Binary Tree Inorder Traversal
Given a binary tree, return the inorder traversal of its nodes' values.
For example:
Given binary tree {1,#,2,3},
   1
    \
     2
    /
   3
return [1,3,2].
Note: Recursive solution is trivial, could you do it iteratively?
*/
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
   // recursion 
    public List<Integer> inorderTraversal1(TreeNode root) {
        List<Integer> rst = new ArrayList<Integer>();
        rec(root, rst);
        return rst;
    }
    
    public void rec(TreeNode root, List<Integer> rst) {
        if (root == null) {
            return;
        }
        
        rec(root.left, rst);
        rst.add(root.val);
        rec(root.right, rst);
    }
}  
   // iteration
   
