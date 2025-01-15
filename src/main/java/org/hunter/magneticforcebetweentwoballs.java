package org.hunter;

class magneticforcebetweentwoballs {
    public int maxDistance(int[] position, int m) {
        Arrays.sort(position);

        int min = 1;
        int max = Math.abs(position[0] - position[position.length - 1]);        

        while(min <= max){            
            int mid = min + (max - min) / 2;                        
            if(exists(position, m, mid)){
                min = mid + 1;
            }else{
                max = mid - 1;
            }
        }
        return min - 1;
    }

    boolean exists(int [] position, int m, int min){
        int value = position[0] + min;
        int i = 0;
        int count = 0;
        while(i < position.length){            
            if(position[i] >= value){
                value = position[i] + min;
                ++count;
            }
            if(count == m - 1){
                return true;
            }
            ++i;
        }
        return false;
    }

}
