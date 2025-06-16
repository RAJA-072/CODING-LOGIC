
import java.util.*;
class Main {
    public static boolean isVowel(char ch){
        boolean res=false;
         if(ch=='a' || ch=='e'||ch=='i'||ch=='o'||ch=='u'){
             res=true;
         }
         return res;
    }
    public static void main(String[] args) {
        String input;
        Scanner sc=new Scanner(System.in);
        input=sc.nextLine();
        int l=sc.nextInt();
        int k=sc.nextInt();
        int vowelcount=0;
        int count=0;
        for(int ctr=0;ctr<l;ctr++){
           if(isVowel(input.charAt(ctr))){
                vowelcount++;
                }
           }
       if(k==vowelcount){
           count++;
       }
       for(int num=l;num<input.length();num++){
       if(isVowel(input.charAt(num-l))){
           vowelcount--;
       }
       if(isVowel(input.charAt(num))){
           vowelcount++;
       }
       if(k==vowelcount){
           count++;
       }
           
       }
       System.out.print(count);
       
    }
}
