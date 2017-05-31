package main.algo.objects;

public class Tree {

    public static void inOrderTreeWalk(TreeNode x) {
        if(x != null) {
            inOrderTreeWalk(x.left);
            System.out.println(x);
            inOrderTreeWalk(x.right);
        }
    }
}
