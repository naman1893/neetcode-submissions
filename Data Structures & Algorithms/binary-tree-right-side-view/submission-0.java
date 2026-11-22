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
    public List<Integer> rightSideView(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        List<Integer>ans = new ArrayList<>();
        if(root==null) return ans;
        q.add(root);
        while(q.size()>0){
            int k = q.size();
            while(k-->0){
                TreeNode front = q.peek();
                q.remove();
                if(k==0){
                    ans.add(front.val);
                }
                if(front.left!=null) q.add(front.left);
                if(front.right!=null) q.add(front.right);
            }
        } 
        return ans;
        
    }
}
