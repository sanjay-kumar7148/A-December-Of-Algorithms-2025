import java.util.*;
class TreeNode {
    int val;
    TreeNode left, right;
    TreeNode(int x) { val = x; }
}
public class Day30_BurnTree {
    static Map<Integer, List<Integer>> adj = new HashMap<>();
    public static void buildGraph(TreeNode node, TreeNode parent) {
        if (node == null) return;
        adj.putIfAbsent(node.val, new ArrayList<>());     
        if (parent != null) {
            adj.get(node.val).add(parent.val);
            adj.putIfAbsent(parent.val, new ArrayList<>());
            adj.get(parent.val).add(node.val);
        }
        buildGraph(node.left, node);
        buildGraph(node.right, node);
    }
    public static TreeNode buildTreeFromInput() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter tree nodes in level order (use -1 for null):");
        String input = sc.nextLine();
        String[] values = input.split("\\s+");
        if (values.length == 0 || values[0].equals("-1")) return null;
        TreeNode root = new TreeNode(Integer.parseInt(values[0]));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int i = 1;
        while (!queue.isEmpty() && i < values.length) {
            TreeNode curr = queue.poll();
            if (!values[i].equals("-1")) {
                curr.left = new TreeNode(Integer.parseInt(values[i]));
                queue.add(curr.left);
            }
            i++;
            if (i < values.length && !values[i].equals("-1")) {
                curr.right = new TreeNode(Integer.parseInt(values[i]));
                queue.add(curr.right);
            }
            i++;
        }
        return root;
    }
    public static void main(String[] args) {
        TreeNode root = buildTreeFromInput();      
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter target node value: ");
        int target = sc.nextInt();
        buildGraph(root, null);
        if (!adj.containsKey(target)) {
            System.out.println("Target node not found in tree.");
            return;
        }
        Queue<Integer> q = new LinkedList<>();
        q.offer(target);
        Set<Integer> visited = new HashSet<>();
        visited.add(target);
        System.out.println("\n--- Burning Process ---");
        System.out.println(target);
        while(!q.isEmpty()) {
            int size = q.size();
            List<Integer> level = new ArrayList<>();
            for(int i = 0; i < size; i++) {
                int u = q.poll();
                for(int v : adj.getOrDefault(u, new ArrayList<>())) {
                    if(!visited.contains(v)) {
                        visited.add(v);
                        level.add(v);
                        q.offer(v);
                    }
                }
            }
            if (!level.isEmpty()) {
                for (int i = 0; i < level.size(); i++) {
                    System.out.print(level.get(i) + (i < level.size() - 1 ? ", " : ""));
                }
                System.out.println();
            }
        }
    }
}