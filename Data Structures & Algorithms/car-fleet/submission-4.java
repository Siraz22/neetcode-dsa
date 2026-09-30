/*
"Even after everything you’ve done, I would have saved you."
- Bruce Wayne, Batman : Arkham City
*/

class Solution {
    public class CarFleet{
        int distance;
        int speed;
        double timeTaken;

        public CarFleet(int speed, int distance, double timeTaken){
            this.distance = distance;
            this.speed = speed;
            this.timeTaken = timeTaken;
        }
    }

    public int carFleet(int target, int[] position, int[] speed) {
        List<CarFleet> list = new ArrayList<>();
        for(int i=0;i<position.length;++i){
            CarFleet cf = 
            new CarFleet(speed[i], target-position[i], (double) (target-position[i])/speed[i]);
            list.add(cf);
        }

        Collections.sort(list, (a, b) -> b.distance - a.distance);
        
        double timeTaken = -1;
        int fleet = 0;
        for(int i=list.size()-1; i>=0; --i){
            if(list.get(i).timeTaken > timeTaken){
                //found a slower feet, faster ones (less time taken) don't matter they'll merge with slower
                timeTaken = list.get(i).timeTaken;
                fleet++;
            }
        }

        return fleet;
    }
}
