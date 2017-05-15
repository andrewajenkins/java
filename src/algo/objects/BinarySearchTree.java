package algo.objects;

public class BinarySearchTree {

    public static TreeNode iterativeTreeSearch(TreeNode x, int k) {
        while(x != null && k != x.key) {
            if(k < x.key) {
                x = x.left;
            } else {
                x = x.right;
            }
        }
        return x;
    }

    public static TreeNode treeSearch(TreeNode x, int k) {
        if(x == null || k == x.key) {
            return x;
        }
        if(k < x.key) {
            return treeSearch(x.left, k);
        } else {
            return treeSearch(x.right, k);
        }
    }

    public static TreeNode treeMinimum(TreeNode x) {
        while(x.left != null) {
            x = x.left;
        }
        return x;
    }

    public static TreeNode treeMaximum(TreeNode x) {
        while(x.right != null) {
            x = x.right;
        }
        return x;
    }

    public static TreeNode treeSuccessor(TreeNode x) {
        if(x.right != null) {
            return treeMinimum(x.right);
        }
        TreeNode y = x.p;
        while(y != null && x == y.right) {
            x = y;
            y = y.p;
        }
        return y;
    }
}
