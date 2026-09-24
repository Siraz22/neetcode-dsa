/*
"And when the seasons change
Will you stand by me?
'Cause I'm a young man built to fall"
- Mind over Matter, Young The Giant
*/

class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length() > s2.length()) return false;
        HashMap<Character, Integer> s1Map = new HashMap<>();
        for(char ch : s1.toCharArray()){
            s1Map.put(ch, s1Map.getOrDefault(ch, 0)+1);
        }

        HashMap<Character, Integer> s2Map = new HashMap<>();
        for(int i=0;i<s1.length();++i){
            char ch = s2.charAt(i);
            s2Map.put(ch, s2Map.getOrDefault(ch, 0)+1);
        }
        if(s1Map.equals(s2Map)) 
            return true;

        for(int i=s1.length(); i<s2.length();++i){
            char toAdd = s2.charAt(i);
            char toRemove = s2.charAt(i-s1.length());

            s2Map.put(toAdd, s2Map.getOrDefault(toAdd, 0)+1);
            if(s2Map.get(toRemove)==1)
                s2Map.remove(toRemove);
            else
                s2Map.put(toRemove, s2Map.get(toRemove)-1);

            if(s1Map.equals(s2Map)) return true;
        }
        
        return false;
    }
}