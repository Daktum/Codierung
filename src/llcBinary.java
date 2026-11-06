public class llcBinary {


    public static void main(String[] args) {

        System.out.println(encode("sssrrff"));

    }


    private static String encode(String str) {
        char[] chars = str.toCharArray();
        StringBuffer sb = new StringBuffer();

        char[] arr = str.toCharArray();
        String output = "";
        char first = arr[0];
        int counter = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == first && counter <= 8) {
                counter++;
            }else {
                sb.append(counter).append(arr[i - 1]);
                counter = 1;
                first = arr[i];
            }
        }
        sb.append(counter).append(arr[arr.length - 1]);

        return  sb.toString();
    }

}
