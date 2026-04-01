class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        // 1. Both are null: they match
        if (p == null && q == null) {
            return true;
        }
        
        // 2. One is null or values differ: they don't match
        if (p == null || q == null || p.val != q.val) {
            return false;
        }
        
        // 3. Check descendants recursively
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}