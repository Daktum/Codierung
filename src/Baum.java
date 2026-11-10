import java.util.LinkedList;
import java.util.Queue;

public class Baum {

    public static void main(String[] args) {
        System.out.println("Baum");

        BinTree b0 = new BinTree(5);   // Wurzel
        BinTree b1 = new BinTree(3);
        BinTree b2 = new BinTree(9);
        BinTree b3 = new BinTree(6);
        BinTree b4 = new BinTree(11);
        BinTree b5 = new BinTree(7);
        BinTree b6 = new BinTree(10);

        b0.setLeft(b1);    //  5 → links 3
        b0.setRight(b2);   //  5 → rechts 9
        b2.setLeft(b3);    //  9 → links 6
        b2.setRight(b4);   //  9 → rechts 11
        b3.setRight(b5);   //  6 → rechts 7 (links leer)
        b4.setLeft(b6);    // 11 → links 10 (rechts leer)

        BinTree p = b0;
        preorder(p);
        System.out.println();
        inorder(p);
        System.out.println();
        postorder(p);
        System.out.println();
        String out = levelorder(p);
        System.out.println(out);
    }

    static void preorder(BinTree p) {
        if (p.isEmpty()) return;
        System.out.println(p.getItem());
        preorder(p.getLeft());
        preorder(p.getRight());
    }

    static void inorder(BinTree p) {
        if (p.isEmpty()) return;
        inorder(p.getLeft());
        System.out.println(p.getItem());
        inorder(p.getRight());
    }

    static void postorder(BinTree p) {
        if (p.isEmpty()) return;
        postorder(p.getLeft());
        postorder(p.getRight());
        System.out.println(p.getItem());
    }

    static String levelorder(BinTree p) {
        String output = "";
        Queue<BinTree> q = new LinkedList<BinTree>();
        q.add(p);
        while (!q.isEmpty()) {
            BinTree t = q.poll();
            if(t.isEmpty()) continue;
            output += t.getItem();
            output+="\n";
            if (t.getLeft() != null) {
                q.add(t.getLeft());
            }
            if (t.getRight() != null) {
                q.add(t.getRight());
            }
        }
        return output;
    }

}
