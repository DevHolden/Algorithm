// 병합정렬
package Sort;

public class MergeSort {
    private static int[] inputArr = {7, 2, 5, 9, 6, 4, 1, 3, 8};

    public static void main(String[] args) {
        int left = 0;
        int right = inputArr.length - 1;

        mergeSort(inputArr, left, right);
        printArr(inputArr);
    }

    private static void mergeSort(int[] arr, int left, int right) {
        if (left == right) { // 원소가 1개 남으면 ret
            return;
        }

        int mid = (left + right) / 2;
        mergeSort(arr, left, mid);
        mergeSort(arr, mid + 1, right);

        merge(arr, left, right);
    }

    private static void merge(int[] arr, int left, int right) {
        int mid = (left + right) / 2;
        int L = left;
        int R = mid + 1;
        int[] tmp = new int[arr.length];
        int tmpIdx = left;

        while (L <= mid && R <= right) {
            tmp[tmpIdx++] = arr[L] < arr[R] ? arr[L++] : arr[R++];
        }
        if (L > mid) { // L 리스트가 먼저 다 들어갔을 때
            while (R <= right) {
                tmp[tmpIdx++] = arr[R++];
            }
        } else if (R > right) {
            while (L <= mid) {
                tmp[tmpIdx++] = arr[L++];
            }
        }


        for (int i = left; i < right+1; i++) {
            arr[i] = tmp[i];
        }
    }

    private static void printArr(int[] arr) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < arr.length; i++)
            sb.append(arr[i]);
        System.out.print("정렬 후 ::: ");
        System.out.println(sb);
    }

}
