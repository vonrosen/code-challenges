package org.hunter;

public class MergeSortAgain {

    public static void main(String [] args) {
        MergeSortAgain mergeSortAgain = new MergeSortAgain();
        int [] arr = new int[]{44,55,2,1};
        int [] result = mergeSortAgain.sort(0, arr.length - 1, arr);
        for(int i = 0; i < result.length; ++i) {
            System.out.print(result[i] + " ");
        }
    }

    int [] sort(int start, int end, int [] arr) {
        if(start == end) {
            return new int[]{arr[start]};
        }
        int mid = start + (end - start) / 2;
        int [] left = sort(start, mid, arr);
        int [] right = sort(mid + 1, end, arr);
        return merge(left, right);
    }

    int [] merge(int [] left, int [] right) {
        int leftl = left.length;
        int rightl = right.length;
        int [] newarr = new int[leftl + rightl];
        int index = 0;
        int lefti = 0;
        int righti = 0;
        while(lefti < leftl && righti < rightl) {
            if(left[lefti] < right[righti]) {
                newarr[index] = left[lefti];
                ++lefti;
            }else {
                newarr[index] = right[righti];
                ++righti;
            }
            ++index;
        }
        for(int i = lefti; i < leftl; ++i) {
            newarr[index] = left[i];
            ++index;
        }
        for(int i = righti; i < rightl; ++i) {
            newarr[index] = right[i];
            ++index;
        }
        return newarr;
    }

}
