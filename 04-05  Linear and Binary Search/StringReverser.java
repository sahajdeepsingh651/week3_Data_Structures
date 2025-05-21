import java.util.Scanner;

public class StringReverser {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter word: ");
        String string = input.nextLine();

        StringBuilder sb = new StringBuilder(string);
        sb.reverse();
        String reversed = sb.toString();

        System.out.println("Reversed string: " + reversed);
        input.close();
    }
}
