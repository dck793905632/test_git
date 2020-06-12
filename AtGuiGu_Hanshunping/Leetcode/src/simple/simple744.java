package simple;

import org.junit.Test;

public class simple744 {
    @Test
    public void test(){
        char[] letters = {'c', 'f', 'j'};
        char target='j';
        System.out.println(nextGreatestLetter(letters,target));
    }
    public char nextGreatestLetter(char[] letters, char target) {
        int left=0;
        int right=letters.length-1;
        while (left<=right){
            int mid = (left+right)/2;
            if (letters[mid]<=target){
                left=mid+1;
            }else {
                right=mid-1;
            }
        }
        return letters[left%letters.length];
    }
}
