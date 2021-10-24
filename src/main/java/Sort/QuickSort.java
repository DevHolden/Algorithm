// 퀵정렬
package Sort;

public class QuickSort {
    private static int[] inputArr = {7, 2, 5, 9, 6, 4, 1, 3, 8};

    public static void main(String[] args) {
        int left = 0;
        int right = inputArr.length-1;

        quickSort(inputArr, left, right);
        printArr(inputArr);
    }

    private static void quickSort(int[] arr, int left, int right) {
        if(left >= right) {
            return;
        }

        int pivot = arr[left];

        int L = left+1;
        int R = right;

        while(L < R) {
            while(arr[L] < pivot && L < right) {
                L++;
            }

            while(arr[R] >= pivot && R > left) {
                R--;
            }

            if(L < R) {
                exchange(arr, L, R);
            }

        }
        if(L >= R) { // 교차되었을 때
            exchange(arr, left, R);
        }
        quickSort(arr, left, R-1);
        quickSort(arr, R+1, right);
    }

    private static void printArr(int[] arr) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < arr.length; i++)
            sb.append(arr[i]);
        System.out.print("정렬 후 ::: ");
        System.out.println(sb);
    }

    private static void exchange(int[] arr, int v1, int v2) {
        int tmp = arr[v1];
        arr[v1] = arr[v2];
        arr[v2] = tmp;
    }

}
