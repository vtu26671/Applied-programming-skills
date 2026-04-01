import java.util.*;

class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        // List to store nodes as (column, row, value)
        List<NodeInfo> nodeList = new ArrayList<>();
        
        // Use DFS to traverse the tree and record coordinates
        dfs(root, 0, 0, nodeList);
        
        // Sort based on the rules:
        // 1. Smaller column index first
        // 2. If columns are same, smaller row index first
        // 3. If both column and row are same, smaller value first
        Collections.sort(nodeList, (a, b) -> {
            if (a.col != b.col) return Integer.compare(a.col, b.col);
            if (a.row != b.row) return Integer.compare(a.row, b.row);
            return Integer.compare(a.val, b.val);
        });
        
        // Group sorted nodes into the result list
        List<List<Integer>> result = new ArrayList<>();
        if (nodeList.isEmpty()) return result;
        
        int currentCol = nodeList.get(0).col;
        List<Integer> currentGroup = new ArrayList<>();
        
        for (NodeInfo node : nodeList) {
            if (node.col == currentCol) {
                currentGroup.add(node.val);
            } else {
                result.add(currentGroup);
                currentCol = node.col;
                currentGroup = new ArrayList<>();
                currentGroup.add(node.val);
            }
        }
        result.add(currentGroup);
        
        return result;
    }
    
    private void dfs(TreeNode node, int row, int col, List<NodeInfo> nodeList) {
        if (node == null) return;
        nodeList.add(new NodeInfo(row, col, node.val));
        dfs(node.left, row + 1, col - 1, nodeList);
        dfs(node.right, row + 1, col + 1, nodeList);
    }
    
    // Helper class to hold node metadata
    class NodeInfo {
        int row, col, val;
        NodeInfo(int row, int col, int val) {
            this.row = row;
            this.col = col;
            this.val = val;
        }
    }
}