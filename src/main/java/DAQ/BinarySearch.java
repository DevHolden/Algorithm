package DAQ;
// 이진탐색 ; 정렬된 배열 속에서 원하는 값의 index를 반환하는 알고리즘
public class BinarySearch {
    private static int[] inputArr = {10, 20, 35, 49, 56, 64, 71, 83, 98};

    public static void main(String[] args) {

        int left = 0;
        int right = inputArr.length-1;
        System.out.println("결과 ::: " + binarySearch(inputArr, left, right, 35));
    }
    private static int binarySearch(int[] arr, int left, int right, int N) {
        int mid = (left + right)/2;

        if(arr[mid] == N) {
            return mid;
        }
        if(N < arr[mid]) {
            return binarySearch(arr, left, mid-1, N);
        }
        else {
            return binarySearch(arr, mid+1, right, N);
        }
    }
}
