class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        // both are null
        if (p == null && q == null) {
            return true;
        }

        // one is null or values differ
        if (p == null || q == null || p.val != q.val) {
            return false;
        }

        // check left and right
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}