public class rangeSumQuery {

    static int[] prefixArray;

    private static int[] prefixArray(int[] arr){
        prefixArray = new int[arr.length];
        prefixArray[0] = arr[0];
        for(int i=1; i<prefixArray.length; i++){
            prefixArray[i] = arr[i] + prefixArray[i-1];
        }
        return prefixArray;
    }
    
    public static int rangeSum(int left, int right){
        if(left == 0) return prefixArray[right];
        return prefixArray[right] - prefixArray[left-1];
    }

    public static void main(String[] args) {
        prefixArray(new int[]{4,3,8,1,7,5});
        System.out.println(rangeSum(2, 4)); // Output: 16
        System.out.println(rangeSum(0, 3)); // Output: 16
        System.out.println(rangeSum(4, 5)); // Output: 12
    }
}
