public class Solution {
    // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
    public int canCompleteCircuit(final int[] A, final int[] B) {
        Deque<Integer> queue = new LinkedList<>();
        int availableFuel=0;
        int count=0;
        while(count==0 || (queue.size()>0 && count<3)){
            count++;
            for(int i=0;i<A.length;i++){
                
            int fuelFilled = A[i];
            availableFuel=fuelFilled+availableFuel;
            if(B[i] <= availableFuel){
                queue.add(i);
                availableFuel=availableFuel-B[i];
            }
            else{
                queue.clear();
                availableFuel = availableFuel -fuelFilled;
            }
        }
        }
        
      //  System.out.println("first: "+queue.getFirst());
       // System.out.println("last: "+queue.getLast());

        return queue.size() > 0 ? queue.getFirst() : -1;
    }
}
