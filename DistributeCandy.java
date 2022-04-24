public class Solution {
    public int candy(int[] A) {
        int[] res = new int[A.length];
        for(int i=0;i<A.length;i++){
            if(i==0){
                if(A[i]>A[i+1]){
                    res[i] = 2;
                }
                else
                    res[i] = 1;
            }
            else{
                if(A[i] > A[i-1])
                    res[i] = 2;
                else
                    res[i] = 1;
            }
        }

        System.out.println("res1= :");new Solution().print(res);

        for(int i=A.length-2;i>=0;i--){
            if(A[i] > A[i+1]){
                int newCalc = res[i+1] +1;
                res[i] = newCalc > res[i] ? newCalc : res[i]; 
            }
        }

        System.out.println("res2= :");
        new Solution().print(res);
        return new Solution().sum(res);
    }

    private void print(int[] arr){
        for(int i=0;i<arr.length;i++) System.out.print(arr[i]);
    }

    private int sum(int[] arr){
        int sum=0;
        for(int i=0;i<arr.length;i++) sum= sum+arr[i];
        return sum;
    }
}