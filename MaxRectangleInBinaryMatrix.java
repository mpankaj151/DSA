/*
Given a 2D binary matrix filled with 0’s and 1’s, find the largest rectangle containing all ones and return its area.

Bonus if you can solve it in O(n^2) or less.

Example :

A : [  1 1 1
       0 1 1
       1 0 0 
    ]

Output : 4 

As the max area rectangle is created by the 2x2 rectangle created by (0,1), (0,2), (1,1) and (1,2)
*/
public class Solution {
    public int maximalRectangle(ArrayList<ArrayList<Integer>> A) {
        int [] a = new int[A.get(0).size()];
        int currMax=0;
        for(int i =0; i<a.length;i++){
            a[i]=0;
        }
        for(int i = 0 ; i<A.size(); i++){
            for(int j = 0; j<A.get(0).size();j++){
                if(A.get(i).get(j)!=0){
                    a[j]+=1;
//                    System.out.println(j + "a[j]" + a[j]);
                }
                else {
                    a[j]=0;
                }
            }
            
            int currAns = maxHisto(a);
  //          System.out.println("test" + currAns);
            currMax = Math.max(currMax,currAns);
        }
        return currMax;
    }
    public int maxHisto(int b[]){
        int maxAns = 0;
        int ps[] = prevSmaller(b);
        int ns[] = nextSmaller(b);

        for(int i = 0 ; i<b.length;i++){
  //          System.out.println("ns[i]" + ns[i] + "ps[i]" + ps[i] + "b[i]" + b[i]);
            int cur =(ns[i]-ps[i]-1)*b[i];
            maxAns = Math.max(maxAns,cur);
        }
        return maxAns;
    }

    public int[] prevSmaller(int b[] ){
        int ps[] = new int[b.length];
        Stack s = new Stack<Integer>();
        for(int i = 0; i<b.length; i++){
            while(!s.isEmpty() && b[((Integer) s.peek()).intValue()]>=b[i]){
                s.pop();
            }
            if(s.isEmpty()){
                ps[i]=-1;
            }
            else{
                ps[i]=((Integer) s.peek()).intValue();
            }
            s.push(i);
        }
    /*    for(int k=0;k<ps.length-1;k++){
            System.out.println("prev" + ps[k]);
        }
*/        return ps;
    }

    public int[] nextSmaller(int b[] ){
        int ns[] =new int[b.length];
        Stack s1 = new Stack<Integer>();
        for(int i = b.length-1; i>=0; i--){
            while(!s1.isEmpty() && b[((Integer)s1.peek()).intValue()]>=b[i]){
                s1.pop();
            }
            if(s1.isEmpty()){
                ns[i]=b.length;
            }
            else{
                ns[i]=((Integer) s1.peek()).intValue();
            }
            s1.push(i);
        }
    /*    for(int k=0;k<ns.length-1;k++){
            System.out.println("next" + ns[k]);
        }
*/
        return ns;
    }
}
