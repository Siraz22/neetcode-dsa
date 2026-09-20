/*
"Slowly learnin' that life is okay"
- Take on me, AHA
*/

class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) return false;
        
        HashMap<Character, Integer> map = new HashMap<>();
        for(Character sChar : s.toCharArray()){
            if(map.containsKey(sChar)){
                map.put(sChar, map.get(sChar)+1);
            }
            else{
                map.put(sChar,1);
            }
        }

        for(Character tChar : t.toCharArray()){
            if(map.containsKey(tChar)){
                int count = map.get(tChar);
                if(count == 1)
                    map.remove(tChar);
                else if(count > 1)
                    map.put(tChar, count - 1);
            }
            else{
                return false;
            }
        }

        return map.size() == 0;
    }
}
