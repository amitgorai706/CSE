public class Q3 {
    public static void main(String[] args) {
        int[] array = {1, 2, 4, 6, 3, 7, 8};
        int missingNumber = findMissingNumber(array);
        System.out.println("The missing number is: " + missingNumber);
    }
    private static int findMissingNumber(int[] array) {
        int n = array.length + 1; 
        int totalSum = (n * (n + 1)) / 2; 
        int arraySum = 0;
        for (int num : array) {
            arraySum += num;
        }
        return totalSum - arraySum;
    }
}
