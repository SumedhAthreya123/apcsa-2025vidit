package warmup;

public class Main {

    public static void main(String[] args) {
        int number = 20;
        boolean found = false;


        while(!found) {
            found = true;

            for (int i = 1; i <= 20; i++) {
                if(number % i != 0) {
                    found = false;
                    break;
                }
            }
            if (!found) {
                number+=20;
            }
        }
        System.out.println("Answer: " + number);
    }
}
