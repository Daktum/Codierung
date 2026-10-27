//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class llc {
    public static void main(String[] args) {
        String input = "rrrrrrrrrrrssssgrr";

        System.out.println(input);

        String output = encode(input);

        System.out.println(output);

        double ratio = (double)output.length() / input.length();

        double percent = (1-ratio) * 100;

        System.out.println("Verhältnis: " + percent + "%");

        System.out.println(output.length() - input.length());
    }

    public static String encode(String input) {
        char[] arr = input.toCharArray();
        String output = "";
        char first = arr[0];
        int counter = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == first && counter <= 8) {
                counter++;
            }else {
                output += counter + "" + arr[i-1];
                counter = 1;
                first = arr[i];
            }
        }
        output += counter + "" + arr[arr.length-1];

        return output;
    }

    public static String decode(String input) {
        char[] arr = input.toCharArray();
        String output = "";

        for(int i = 0; i < arr.length; i+=2) {
            for(int j = 0; j <= Integer.parseInt(arr[i]+""); j++){
                output += arr[i+1];
            }
        }

        return output;
    }

}