class Trie{
    String word;
    Trie[] chars=new Trie[26];
}

//Trie structure implemented
class Solution {
    public List<String> result=new ArrayList<>();
    
    int dir[][]=new int[][]{{0,1},{0,-1},{1,0},{-1,0}};

    private static void BuildTrie(String word, Trie prev,int idx){
            int chIdx=word.charAt(idx)-'a';
            Trie curr=prev.chars[chIdx];
            if(curr==null){
                prev.chars[chIdx]=curr=new Trie();
            }
            if(idx==word.length()-1){
                  curr.word=word;
                  return;
            }
            BuildTrie(word,curr,idx+1);
    }
    
    public void dfs(int R, int C,int row,int col,char board[][],Trie prev,List<String> result){
 
        char ch=board[row][col];
        int chIdx=ch-'a';
        Trie curr=prev.chars[chIdx];
        if(curr==null){
            return;
        }

         board[row][col]='*';
         if(curr.word!=null){
            result.add(curr.word);
            curr.word=null;
         }

        for(int i=0;i<4;i++){
            int adjR=row+dir[i][0];
            int adjC=col+dir[i][1];
            if(adjR>=0 && adjR<R && adjC>=0 && adjC<C  && board[adjR][adjC]!='*'){
                     
                     dfs(R,C,adjR,adjC,board,curr,result);
                    
            }
                
        }
        board[row][col]=ch;
        

    }
    public List<String> findWords(char[][] board, String[] words) {
            Trie root=new Trie();
            for(String word:words){
                BuildTrie(word,root,0);
            }     
            
            int R=board.length;
            int C=board[0].length;
           
            for(int row=0;row<R;row++){
                for(int col=0;col<C;col++){
                    dfs(R,C,row,col,board,root,result);
                }
            }
            Collections.sort(result);
            return result;
    }
}
