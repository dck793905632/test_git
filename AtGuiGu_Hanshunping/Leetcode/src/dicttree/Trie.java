package dicttree;

public class Trie {
    private Trie[] children = new Trie[26];
    private boolean isEnd=false;

    public Trie(){

    }

    public void insert(String word){
        Trie tmp =this;
        for(char i :word.toCharArray()){
            if(tmp.children[i-'a']==null){
                tmp.children[i-'a']=new Trie();
            }
            tmp=tmp.children[i-'a'];
        }
        tmp.isEnd=true;
    }

    public boolean search(String word) {
        Trie tmp =this;
        for(char i :word.toCharArray()){
            if(tmp.children[i-'a']==null){
                return false;
            }
            tmp=tmp.children[i-'a'];
        }
        return tmp.isEnd==true? true:false;
    }

    public boolean startsWith(String prefix){
        Trie tmp = this;
        for(char i :prefix.toCharArray()){
            if(tmp.children[i-'a']==null){
                return false;
            }
            tmp=tmp.children[i-'a'];
        }
        return true;
    }


}
