/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> paths = new ArrayList<>();
        if (root != null) {
            dfs(root, "", paths);
        }
        return paths;
    }

    private void dfs(TreeNode node, String currentPath, List<String> paths) {
        // Append the current node's value to the path
        currentPath += node.val;

        // If it's a leaf node, add the completed path to our list
        if (node.left == null && node.right == null) {
            paths.add(currentPath);
            return;
        }

        // If not a leaf, continue exploring children with the "->" separator
        if (node.left != null) {
            dfs(node.left, currentPath + "->", paths);
        }
        if (node.right != null) {
            dfs(node.right, currentPath + "->", paths);
        }
    }
}