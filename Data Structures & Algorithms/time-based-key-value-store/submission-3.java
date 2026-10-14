/*
"We make our choices, but in the end our choices make us."
- Andrew Ryan, Bioshock
*/

class TimeMap {

    HashMap<String, ArrayList<Pair>> map;

    class Pair{
        int timestamp;
        String value;

        Pair(int timestamp, String value){
            this.timestamp = timestamp;
            this.value = value;
        }
    }

    public TimeMap() {
        map = new HashMap<String, ArrayList<Pair>>();
    }
    
    public void set(String key, String value, int timestamp) {
        if(map.containsKey(key)){
            map.get(key).add(new Pair(timestamp, value));
        }
        else{
            map.put(key, new ArrayList<Pair>());
            map.get(key).add(new Pair(timestamp, value));
        }
    }
    
    public String get(String key, int timestamp) {
        if(!map.containsKey(key)){
            return "";
        }

        ArrayList<Pair> list = map.get(key);
        int left = 0;
        int right = list.size()-1;
        String answer = "";

        while(left <= right){
            int mid = left + (right - left)/2;

            if(list.get(mid).timestamp <= timestamp){
                answer = list.get(mid).value;
                //a lower timestamp exists, see if a better one does
                left = mid+1;
            }
            else
                right = mid-1;
        }
        return answer;
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */