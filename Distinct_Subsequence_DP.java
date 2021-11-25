/*
    ""  b a b g b a g
""  1   1 1 1 1 1 1 1
b   0   
a   0
g   0

if char matches then 2 option either consider the match then i-1 j-1 or not consider the match i j-1
if char doesn't match then i j-1
*/
public class Solution {
    public int numDistinct(String A, String B) {
            int m = B.length();
            int n  = A.length();

            if (m>n){
                return 0;
            }
            int [][] mn = new int[m+1][n+1];
            for(int i=1;i<=m;i++){
                mn[i][0]=0;
            }
            
            for(int i=0;i<=n;i++){
                mn[0][i]=1;
            }
            
            for(int i=1;i<=m;i++){
                for(int j=1;j<=n;j++){

                    if(B.charAt(i-1) == A.charAt(j-1))
                    {
                        mn[i][j]=mn[i-1][j-1]+mn[i][j-1];
                    }
                    else {
                        mn[i][j]=mn[i][j-1];
                    }
                }
            }
            return mn[m][n];
    }
}
