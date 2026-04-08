class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            result.add(node.val); // Process Root
            
            // Push right first so left is processed next (LIFO)
            if (node.right != null) {
                stack.push(node.right);
            }
            
            // Push left last so it is on top of the stack
            if (node.left != null) {
                stack.push(node.left);
            }
        }
        
        return result;
    }
}