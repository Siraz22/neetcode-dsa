/*
"Science is elegant"
- Xeno, Dr. Stone
*/

class Solution {
    public class Process{
        int freq;
        int timeToResume;

        public Process(int freq, int timeToResume){
            this.timeToResume = timeToResume;
            this.freq = freq;
        }

        public String toString(){
            return this.freq+","+this.timeToResume;
        }
    }

    public int leastInterval(char[] tasks, int n) {
        Queue<Integer> pq = new PriorityQueue<Integer>((a,b) -> b-a);
        Map<Character, Integer> map = new HashMap<>();
        for(char ch : tasks){
            map.put(ch, map.getOrDefault(ch,0)+1);
        }

        for(Map.Entry<Character, Integer> entry : map.entrySet()){
            pq.offer(entry.getValue());
        }

        Queue<Process> scheduler = new LinkedList<Process>();

        int currTime = 0;
        while(!pq.isEmpty() || !scheduler.isEmpty()){
            Integer freq = !pq.isEmpty()? pq.remove() : null;
            
            //reduce freq and set release time
            if(freq!=null && freq-1>0) scheduler.add(new Process(freq-1, currTime + n));

            while(!scheduler.isEmpty() && scheduler.peek().timeToResume == currTime){
                Process p = scheduler.remove();
                pq.offer(p.freq);
            }
            currTime++;
        }
        return currTime;
    }
}