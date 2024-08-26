import java.util.HashMap;
import java.util.Map;

public class twoSum {

    public static int[] findPairs(int[] nums, int k) {

        Map<Integer, Integer> compliment = new HashMap<>();

        for(int i=0; i<nums.length; i++){
            int complimentNum = k - nums[i];
            if(compliment.containsKey(complimentNum)){
                return new int[]{compliment.get(complimentNum), i};
            }
            compliment.put(nums[i], i);
        }

        return new int[]{};
    }

    public static void main(String[] args) {
        for (int num : findPairs(new int[]{2,7,11,15}, 9)) {
            System.out.println(num);
        }
    }
}
