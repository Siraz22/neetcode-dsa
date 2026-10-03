/*
"Abe deshpremi, zaraa gaur se suniyo
Tere desh mein to pyaar gunaah hai"
- Wahin ka Wahin, लिफाफा
*/

class Solution {

    private int timeTaken(int[] piles, int speed){
        int timeTaken = 0;
        for (int pile : piles) {
            timeTaken += Math.ceil((double) pile / speed);
        }
        return timeTaken;
    }

    public int minEatingSpeed(int[] piles, int h) {
        int left = 1;
        int right = Integer.MAX_VALUE;
        int answerSpeed = -1;

        while(left <= right){
            int speed = left + (right-left)/2;
            int timeTaken = timeTaken(piles, speed);

            System.out.println(speed + " -> "+timeTaken);

            if(timeTaken <= h){
                //see if lesser speed is preferable
                right = speed-1;
                answerSpeed = speed; //assign incase we don't find answer in next iteration
            }
            else{
                //too slow
                left = speed+1;
            }
        }

        return answerSpeed;
    }
}