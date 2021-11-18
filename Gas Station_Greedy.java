public class Solution {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    // List A amount of gas at station i , List B Cost of gas to travel from station i to i+1
    public int canCompleteCircuit(final List<Integer> A, final List<Integer> B) {
        int start = 0;
        int totalGasUsed = 0;
        int totalGasAvailable = 0;
        int gasFoundBefore = 0;
        int gasRequiredBefore = 0;

        if(A.get(0)==0 && B.get(0)==0){
            return 0;
        }
        for(int i=0; i< A.size(); i++){
            totalGasAvailable += A.get(i);
            totalGasUsed += B.get(i);
            if(totalGasAvailable - totalGasUsed < 0){
                gasFoundBefore +=totalGasAvailable;
                gasRequiredBefore +=totalGasUsed;
                totalGasUsed=0;
                totalGasAvailable=0;
                start = i+1;
            }
        }

        if(((totalGasAvailable+gasFoundBefore)-(totalGasUsed + gasRequiredBefore)) >= 0 ){
            return start;
        }
        return -1;
    }
}
