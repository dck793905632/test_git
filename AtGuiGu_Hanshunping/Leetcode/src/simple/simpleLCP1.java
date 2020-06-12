package simple;

public class simpleLCP1 {
    public static void main(String[] args) {

    }
    public static int game(int[] guess, int[] answer) {
        int count=0;
        int i=0;
        while (i<guess.length){
            if (guess[i]==answer[i]){
                count++;
            }
            i++;
        }
        return count;
    }
}
