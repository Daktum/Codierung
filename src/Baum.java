import java.util.LinkedList;
import java.util.Queue;

public class Baum {

    public static void main(String[] args) {
        System.out.println("Baum");
        /*
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

        */
        BinTree b0 = new BinTree(50);   // Wurzel
        BinTree b1 = new BinTree(30);
        BinTree b2 = new BinTree(70);
        BinTree b3 = new BinTree(20);
        BinTree b4 = new BinTree(40);
        BinTree b5 = new BinTree(60);
        BinTree b6 = new BinTree(80);
        BinTree b7 = new BinTree(45);

        b0.setLeft(b1);    // 50 → links  30
        b0.setRight(b2);   // 50 → rechts 70
        b1.setLeft(b3);    // 30 → links  20
        b1.setRight(b4);   // 30 → rechts 40
        b2.setLeft(b5);    // 70 → links  60
        b2.setRight(b6);   // 70 → rechts 80
        b4.setRight(b7);   // 40 → rechts 45


        BinTree p = b0;
        /*
        preorder(p);
        System.out.println();
        inorder(p);
        System.out.println();
        postorder(p);
        System.out.println();
        String out = levelorder(p);
        System.out.println(out);
        structure(p);
        System.out.println("Abst");
        ausgebenAbst(p);
        System.out.println("Contains");
        System.out.println(contains(p, 45));
        System.out.println(sum(p));

         */
        System.out.println(numberLeaves(p));

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

    public static void ausgebenAbst(BinTree p) {
        if (p.isEmpty()) return;
        ausgebenAbst(p.getRight());
        System.out.println(p.getItem());
        ausgebenAbst(p.getLeft());
    }

    public static boolean contains(BinTree p, Integer item) {
        if (p.isEmpty()) return false;
        if (p.getItem() == item) return true;
        if (item > (int) p.getItem()){
            return contains(p.getRight(), item);
        }
        if (item < (int) p.getItem()){
            return contains(p.getLeft(), item);
        }
        System.out.println(false);
        return false;
    }

    public static int sum(BinTree p) {
        if (p.isEmpty()) return 0;
        return sum(p.getLeft()) + sum(p.getRight()) + (int) p.getItem();
    }

    public static int numberLeaves(BinTree p) {
        System.out.println("now");
        if (p.isEmpty()) return 0;
        if (p.isLeaf()) return 1;
        int l = numberLeaves(p.getLeft());
        int r = numberLeaves(p.getRight());
        return l + r;
    }

    static void structure(BinTree p) {
        int height = height(p);
        int width = (int) Math.pow(2, height + 1);

        String[][] lines = new String[height * 2 - 1][width];

        for (int i = 0; i < lines.length; i++) {
            for (int j = 0; j < width; j++) {
                lines[i][j] = " ";
            }
        }

        drawTree(p, lines, 0, 0, width - 1);

        for (String[] line : lines) {
            StringBuilder output = new StringBuilder();

            for (String s : line) {
                output.append(s);
            }

            System.out.println(output.toString().stripTrailing());
        }
    }

    static int height(BinTree p) {
        if (p == null || p.isEmpty()) return 0;

        return 1 + Math.max(
                height(p.getLeft()),
                height(p.getRight())
        );
    }

    static void drawTree(BinTree p, String[][] lines,
                         int level, int left, int right) {

        if (p == null || p.isEmpty()) return;

        int middle = (left + right) / 2;

        lines[level * 2][middle] = p.getItem().toString();

        if (p.getLeft() != null && !p.getLeft().isEmpty()) {
            lines[level * 2 + 1][(left + middle) / 2] = "/";
            drawTree(p.getLeft(), lines, level + 1, left, middle);
        }

        if (p.getRight() != null && !p.getRight().isEmpty()) {
            lines[level * 2 + 1][(middle + right) / 2] = "\\";
            drawTree(p.getRight(), lines, level + 1, middle, right);
        }
    }


}
