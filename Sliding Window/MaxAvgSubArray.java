public class MaxAvgSubArray {
    
    public static double findMaxAverage(int[] nums, int k){
        double sum = 0;

        for(int i=0; i<k; i++){
            sum += nums[i];
        }

        double maxSum = 0;
        
        for(int i=k; i<nums.length; i++){
            maxSum = sum + nums[i] - nums[i-k];
            sum = Math.max(sum, maxSum);
        }

        return sum / (double) k;
    }

    public static void main(String[] args) {
        System.out.println(findMaxAverage(new int[]{1,12,-5,-6,50,3}, 4));
    }
}
