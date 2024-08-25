import java.util.Map;
import java.util.HashMap;

public class contiguousArray {

    private static int findMaxLength(int[] boolArray){

        Map<Integer, Integer> seenAt = new HashMap<>();
        seenAt.put(0, -1);

        int maxLength = 0;
        int cumSum = 0; // Cumulative Sum

        for(int i=0; i<boolArray.length; i++){
            cumSum += (boolArray[i] == 1) ? 1 : -1;
            
            if(seenAt.containsKey(cumSum)){
                maxLength = Math.max(maxLength, i - seenAt.get(cumSum)); // Change Max Length if we find contiguous Array with equal 0's and 1's
            }else{
                seenAt.put(cumSum, i);
            }
        }

        return maxLength;
    }

    public static void main(String[] args) {
        System.out.println(findMaxLength(new int[]{1,0,1,0,0,1,1,1,0}));
    }
}