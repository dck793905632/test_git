package simple;

public class simple409 {
    public int longestPalindrome(String s) {
        int[] count = new int[26+26];
        for(char c :s.toCharArray()){
            if(c>='a' && c<='z'){
                count[c-'a']+=1;
            }
            if(c>='A' && c<='Z'){
                count[c-'A'+26]+=1;
            }
        }
        int res=0;
        int odd=0;
        for(int n :count){
            res+=n;
            if(n%2==1){
                odd++;
            }
        }
        return odd==0? res : res-odd+1;
    }
}
