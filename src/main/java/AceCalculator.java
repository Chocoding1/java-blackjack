import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class AceCalculator {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 3; i++) {
            int totalScore = Integer.parseInt(br.readLine());

//            if (totalScore + 11 <= 21) {
//                System.out.println("Ace score : " + 11);
//                continue;
//            }
//
//            System.out.println("Ace score : " + 1);

            System.out.println("Ace score : " + calculateAce(totalScore));
        }
    }

    public static int calculateAce(int totalScore) {
        if (totalScore + 11 <= 21) {
            return 11;
        }

        return 1;
    }
}
