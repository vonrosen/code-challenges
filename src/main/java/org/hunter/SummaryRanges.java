package org.hunter;

import java.util.ArrayList;
import java.util.List;

class SummaryRanges {

    private List<List<Integer>> sequence;

    public SummaryRanges() {
        sequence = new ArrayList<>();
    }

    public void addNum(int value) {
        if(sequence.isEmpty()) {
            sequence.add(List.of(value, value));
            return;
        }
        int index = binSearch(value);
        int leftIndex = 0, rightIndex = 0, leftValue = 0, rightValue = 0;
        leftIndex = Math.max(0, index - 1);
        rightIndex = Math.min(sequence.size() - 1, index + 1);
        if(sequence.size() == 1) {
            leftValue = sequence.get(leftIndex).get(0);
            rightValue = sequence.get(rightIndex).get(1);
        }else{
            leftValue = sequence.get(leftIndex).get(1);
            rightValue = sequence.get(rightIndex).get(0);
        }
        if(leftValue == value - 1 && rightValue == value + 1) {
            List<Integer> newRange = new ArrayList<>();
            newRange.add(leftValue);
            newRange.add(rightValue);
            sequence.remove(leftIndex);
            if(!sequence.isEmpty()) {
                sequence.remove(rightIndex);
            }
            if(sequence.isEmpty()) {
                sequence.add(0, newRange);
            }else{
                sequence.add(index - 1, newRange);
            }
        }else if(leftValue == value - 1) {
            List<Integer> newRange = new ArrayList<>();
            newRange.add(sequence.get(leftIndex).get(0));
            newRange.add(value);
            sequence.remove(leftIndex);
            if(sequence.isEmpty()) {
                sequence.add(0, newRange);
            }else{
                sequence.add(index - 1, newRange);
            }
        }else if(rightValue == value + 1) {
            List<Integer> newRange = new ArrayList<>();
            newRange.add(value);
            newRange.add(sequence.get(rightIndex).get(1));
            sequence.remove(rightIndex);
            if(sequence.isEmpty()) {
                sequence.add(0, newRange);
            }else {
                sequence.add(index, newRange);
            }
        }else{
            List<Integer> newRange = List.of(value, value);
            if(value < sequence.get(index).get(0)) {
                sequence.add(index, newRange);
            }else if(value > sequence.get(index).get(1)) {
                sequence.add(sequence.size(), newRange);
            }
        }
    }

    public int[][] getIntervals() {
        int [][] ans = new int[sequence.size()][2];
        for(int i = 0; i < sequence.size(); ++i) {
            ans[i][0] = sequence.get(i).get(0);
            ans[i][1] = sequence.get(i).get(1);
        }
        return ans;
    }

    int binSearch(int value) {
        int left = 0;
        int right = sequence.size() - 1;
        while(left <= right) {
            int mid = left + (right - left ) / 2;
            if(sequence.get(mid).get(0) == value) {
                return mid;
            }else if(sequence.get(mid).get(0) < value) {
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }
        return left;
    }
}