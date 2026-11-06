import com.sun.source.tree.BinaryTree;

import java.util.ArrayList;

public class Huffman {

    public static void main(String[] args) {
        BinTree b0 = new BinTree();
        BinTree b1 = new BinTree('A');
        BinTree b2 = new BinTree();
        BinTree b3 = new BinTree();
        BinTree b4 = new BinTree();
        BinTree b5 = new BinTree('K');
        BinTree b6 = new BinTree();
        BinTree b7 = new BinTree('B');
        BinTree b8 = new BinTree('R');
        BinTree b9 = new BinTree('D');
        BinTree b10 = new BinTree('?');


        b0.setLeft(b1);
        b0.setRight(b2);
        b2.setLeft(b3);
        b2.setRight(b4);
        b3.setLeft(b5);
        b3.setRight(b6);
        b4.setLeft(b7);
        b4.setRight(b8);
        b6.setLeft(b9);
        b6.setRight(b10);

        String b = "0110111010001010011011101011";
        BinTree tree = b0;

        System.out.println(decode(b, tree));


    }

    private static boolean istPraefixfrei(ArrayList<String> list){

        for(int i=0;i<list.size();i++){
            String s = list.get(i);
            for (String string : list) {
                if (s.startsWith(string) && !s.equals(string)) {
                    return false;
                }
            }
        }

        return true;
    }

    private static String decode(String s,  BinTree tree) {
        StringBuffer sb = new StringBuffer();
        BinTree temp = tree;
        int i = 0;

        while(i < s.length()){
            tree = temp;
            while (!tree.isLeaf()) {
                if(s.charAt(i)=='0'){
                    tree = tree.getLeft();
                }else if(s.charAt(i)=='1') {
                    tree = tree.getRight();
                }
                i++;
            }

            if (tree.getItem() != null) {
                sb.append(tree.getItem());
            }
        }
        return sb.toString();
    }

}

// 0110111010001010011011101011