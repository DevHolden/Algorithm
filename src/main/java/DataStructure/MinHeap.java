package DataStructure;

// 1차원 배열을 활용한 최소힙 구현
public class MinHeap {

    public static void main(String[] args) {
        int arr[] = {10, 35, 19, 3, 23, 47, 80, 44, 60};

        maxHeap(arr);
        printArr(arr);
    }

    private static void maxHeap(int[] arr) {
        // arr.length까지 설정하면 인덱스 범위를 벗어나는 예외 초래
        int size = arr.length-1;

        if(size < 2) {
            return;
        }
        // 가장 마지막 노드의 서브트리부터 정렬한다
        int parentIdx = getParent(size);

        for(int i = parentIdx; i >= 0; i--) {
            heapify(arr, i, size);
        }
    }

    private static int getParent(int child) {
        return (child-1) / 2;
    }

    private static void swap(int[] arr, int n1, int n2) {
        if(n1 == n2) {
            return;
        }

        int tmp = 0;

        tmp = arr[n1];
        arr[n1] = arr[n2];
        arr[n2] = tmp;
    }

    /**
     * 최소 힙으로 정렬하는 알고리즘
     * @param arr : 배열
     * @param parentIdx : 부모 노드의 인덱스
     * @param lastIdx : 배열 범위 초과를 방지하기 위한 끝 인덱스
     */
    private static void heapify(int[] arr, int parentIdx, int lastIdx) {
        int leftChildIdx = 2 * parentIdx + 1;
        int rightChildIdx = 2 * parentIdx + 2;

        int smallestIdx = parentIdx;
        int largeChildIdx = 0;

        if(leftChildIdx <= lastIdx && rightChildIdx <= lastIdx) {
            largeChildIdx = (arr[leftChildIdx] < arr[rightChildIdx]) ? leftChildIdx : rightChildIdx;
            smallestIdx = (arr[smallestIdx] < arr[largeChildIdx]) ? smallestIdx : largeChildIdx;
        }

        if(smallestIdx != parentIdx) {
            swap(arr, smallestIdx, parentIdx);
            heapify(arr, smallestIdx, lastIdx);
        }
    }

    private static void printArr(int[] arr) {
        StringBuilder sb = new StringBuilder();

        sb.append(" arr ::: ");
        for(int i = 0; i < arr.length; i++) {
            sb.append(arr[i] + " ");
        }
        System.out.println(sb);
    }
}
