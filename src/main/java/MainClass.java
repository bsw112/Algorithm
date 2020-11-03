public class MainClass {

    public static void main(String[] args) {

        int[] arr = new int[]{1,2,3};
        test(arr);
        int i = 0;
    }

    static void test(int[] arr)
    {
        arr[0] = 33;
    }
}
