import java.util.*;
class Trie{
    String word;
    Trie[] chars=new Trie[26];
}

class Solution{

    private static void buildTrie(String word,Trie prev, int idx){
        int chIdx=word.charAt(idx)-'a';
        Trie curr=prev.chars[chIdx];
        if(curr==null){
            prev.chars[chIdx]=curr=new Trie();
        }

        if(idx==word.length()-1){
            curr.word=word;
            return;
        }
        buildTrie(word, curr, idx+1);
    }
//print the trie
    private static void printTrie(Trie t){
        
        if(t.word!=null){
            System.out.println(t.word);
        }
        for(int index=0;index<26;index++){
            if(t.chars[index]!=null){
                printTrie(t.chars[index]);
            }
        }
    }
    public static void main(String[] args){
     Scanner sc=new Scanner(System.in);
     int N=sc.nextInt();
     sc.nextLine();
    
     Trie root=new Trie();
     for(int ctr=1;ctr<=N;ctr++){
        String word=sc.nextLine();
        buildTrie(word,root,0);
     }
     System.out.println("\n***********************************\n");
     printTrie(root);
    }
}
