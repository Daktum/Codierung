public class BinTree<T> {
    private T item;            // Inhalt der Wurzel (null = leer)
    private BinTree<T> left;   // linker Teilbaum
    private BinTree<T> right;  // rechter Teilbaum
    // Leerer Baum: kein Inhalt, (noch) keine Teilbäume.
    public BinTree() {
        item = null;
        left = null;
        right = null;
    }
    // Baum mit Inhalt; linker und rechter Teilbaum sind leere Bäume.
    public BinTree(T inhalt) {
        item = inhalt;
        left = new BinTree<>();
        right = new BinTree<>();
    }
    // Leer = kein Inhalt. Ein leerer Baum darf trotzdem Teilbäume haben
    // (z. B. innere Knoten im Huffman-Baum).
    public boolean isEmpty() {
        return item == null;
    }
    public T getItem() {
        return item;
    }
    // Wurzel erhält den Inhalt; fehlende Teilbäume werden als leere Bäume gesetzt.
    public void setItem(T inhalt) {
        item = inhalt;
        if (left == null) left = new BinTree<>();
        if (right == null) right = new BinTree<>();
    }
    // Blatt: hat Inhalt, linker und rechter Teilbaum sind leer.
    public boolean isLeaf() {
        return !isEmpty() && istLeer(left) && istLeer(right);
    }
    private static boolean istLeer(BinTree<?> b) {
        return b == null || (b.isEmpty() && b.left == null && b.right == null);
    }
    public BinTree<T> getLeft() {
        return left;
    }
    public void setLeft(BinTree<T> b) {
        left = (b == null) ? new BinTree<>() : b;
    }
    public BinTree<T> getRight() {
        return right;
    }
    public void setRight(BinTree<T> b) {
        right = (b == null) ? new BinTree<>() : b;
    }
    // Baum wird leer: kein Inhalt, keine Teilbäume.
    public void setEmpty() {
        item = null;
        left = null;
        right = null;
    }
    public String toString() {
        String s = "";
        if (left != null && !istLeer(left)) s += "(" + left + ") ";
        s += (item == null ? "•" : item);
        if (right != null && !istLeer(right)) s += " (" + right + ")";
        return s;
    }
}