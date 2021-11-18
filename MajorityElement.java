public class Solution {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
  // A  List of numbers and The majority element is the element that appears more than floor(n/2) times.
    public int majorityElement(final List<Integer> A) {
        int maxElem = A.get(0);
        int maxElemCount= 1;
        Map<Integer,Integer> hmap = new HashMap<Integer,Integer>();
        for(int i = 0 ; i< A.size();i++){
            if(hmap.containsKey(A.get(i))){
                hmap.put(A.get(i),hmap.get(A.get(i)) +1);
                if(maxElemCount<(hmap.get(A.get(i))+1)){
                   maxElemCount= hmap.get(A.get(i))+1;
                   maxElem= A.get(i);
                }
            }
            else {
                hmap.put(A.get(i),1);
            }
        }
        return maxElem;
    }
}
