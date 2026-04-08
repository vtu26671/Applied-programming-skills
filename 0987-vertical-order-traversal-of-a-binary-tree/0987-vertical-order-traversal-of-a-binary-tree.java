import java.util.*;

class Solution {
    // Helper class to store node information
    class NodeInfo {
        int row;
        int col;
        int val;

        NodeInfo(int row, int col, int val) {
            this.row = row;
            this.col = col;
            this.val = val;
        }
    }

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<NodeInfo> nodes = new ArrayList<>();
        // 1. Traverse the tree and collect coordinates
        dfs(root, 0, 0, nodes);

        // 2. Sort nodes based on the requirements:
        // Priority 1: Column (left to right)
        // Priority 2: Row (top to bottom)
        // Priority 3: Value (ascending)
        Collections.sort(nodes, (a, b) -> {
            if (a.col != b.col) return a.col - b.col;
            if (a.row != b.row) return a.row - b.row;
            return a.val - b.val;
        });

        // 3. Group the sorted nodes into columns
        List<List<Integer>> result = new ArrayList<>();
        if (nodes.isEmpty()) return result;

        int lastCol = nodes.get(0).col;
        List<Integer> currentColumn = new ArrayList<>();
        
        for (NodeInfo node : nodes) {
            if (node.col != lastCol) {
                result.add(currentColumn);
                currentColumn = new ArrayList<>();
                lastCol = node.col;
            }
            currentColumn.add(node.val);
        }
        result.add(currentColumn); // Add the last column

        return result;
    }

    private void dfs(TreeNode root, int row, int col, List<NodeInfo> nodes) {
        if (root == null) return;
        nodes.add(new NodeInfo(row, col, root.val));
        dfs(root.left, row + 1, col - 1, nodes);
        dfs(root.right, row + 1, col + 1, nodes);
    }
}