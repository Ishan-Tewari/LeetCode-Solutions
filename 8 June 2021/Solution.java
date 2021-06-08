/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {

    int index;
    HashMap<Integer,Integer> map;
    public TreeNode buildTree(int[] preorder, int[] inorder) {

        // initialization
        index = 0;

        // for faster accessing
        map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++){
            map.put(inorder[i],i);
        }

        // calling helper function
        TreeNode root = helper(preorder, inorder, 0, preorder.length - 1);

        return root;
    }

    public TreeNode helper(int[] preorder, int[] inorder, int lowerBound, int upperBound){

        // base case
        if (lowerBound > upperBound) return null;

        // creating root node
        TreeNode root = new TreeNode(preorder[index]);
        index++;

        // if leaf node
        if (lowerBound == upperBound) return root;

        // finding middle point from inorder array in O(1)
        int mid = map.get(root.val);

        // finding middle point from inorder array in O(N)
        // int mid = 0;
        // for (int i = 0; i < inorder.length; i++){
        //     if (inorder[i] == root.val) mid = i;
        // }

        // setting left and right variables
        root.left = helper(preorder, inorder, lowerBound, mid - 1);
        root.right = helper(preorder, inorder, mid + 1, upperBound);

        return root;
    }
}
