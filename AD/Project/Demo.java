public class Demo {
    public static int findMin(int[] arr) {
        int min = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < min) {
                min = arr[i];
            }
        }
        return min;
    }
    public static void main(String[] args) {
        int[] arr = {8, 6, 4, 2, 3, 5, 7, 9};
        System.out.println(findMin(arr));
    }
}
