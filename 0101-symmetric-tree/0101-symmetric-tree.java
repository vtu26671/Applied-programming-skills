class Solution {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return isMirror(root.left, root.right);
    }

    private boolean isMirror(TreeNode t1, TreeNode t2) {
        // If both are null, they are symmetric
        if (t1 == null && t2 == null) return true;
        // If only one is null or values differ, not symmetric
        if (t1 == null || t2 == null || t1.val != t2.val) return false;
        
        // Compare outer children and inner children
        return isMirror(t1.left, t2.right) && isMirror(t1.right, t2.left);
    }
}