import java.util.Map;
import java.util.HashMap;

public class subArraySumK {
    
    private static int subArraysEqualK(int[] arr, int k){
        Map<Integer, Integer> diffMap = new HashMap<>();
        diffMap.put(0, 1);

        int subArrays = 0;
        int prefixSum = 0;

        for(int i=0; i<arr.length; i++){
            prefixSum += arr[i];

            int diff = prefixSum - k;
            if(diffMap.containsKey(diff)){
                subArrays += diffMap.get(diff);
            }

            diffMap.put(prefixSum, diffMap.getOrDefault(prefixSum, 0)+1);
        }

        return subArrays;
    }

    public static void main(String[] args) {
        System.out.println(subArraysEqualK(new int[]{1,2,3,2,4,5,1}, 6));
    }
}
