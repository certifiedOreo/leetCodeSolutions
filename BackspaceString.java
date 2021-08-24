class Solution {
    
    
    public boolean backspaceCompare(String s, String t) {
        
        Stack<Character> s1 = new Stack<>();
                Stack<Character> s2 = new Stack<>();
        
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i)=='#' && !s1.empty()){
                s1.pop();
                
            }
            if(s.charAt(i)!='#'){
                s1.push(s.charAt(i));
            }
        }
        
                for(int i=0; i<t.length(); i++){
            if(t.charAt(i)=='#' && !s2.empty()){
                s2.pop();
                
            }
            if(t.charAt(i)!='#'){
                s2.push(t.charAt(i));
            }
        }
        
        
        String str1 = "";
        String str2 = "";
        
         while(!s1.empty()){
            str1+=s1.pop();
        }
        
        while(!s2.empty()){
            str2+=s2.pop();
        }
        
        
        if(str1.equals(str2)){
            return true;
        }
        return false;

        
        
    }
}
