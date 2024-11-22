import java.util.*;

class countunguardedcellsinthegrid {

    public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
        Set<String> guardSet = new HashSet<>();
        Set<String> wallSet = new HashSet<>();
        Set<String> unguarded = new HashSet<>();
        for(int i = 0; i < guards.length; ++i){
            String key = guards[i][0] + "-" + guards[i][1];
            guardSet.add(key);
        }
        for(int i = 0; i < walls.length; ++i){
            String key = walls[i][0] + "-" + walls[i][1];
            wallSet.add(key);
        }
        for(int row = 0; row < m; ++row){
            String lastOccupied = null;
            for(int col = 0; col < n; ++col){
                if(guardSet.contains(row + "-" + col)){
                    lastOccupied = "G";
                }else if(wallSet.contains(row + "-" + col)){
                    lastOccupied = "W";
                }else{
                    if("W".equals(lastOccupied) || lastOccupied == null){
                        unguarded.add(row + "-" + col);
                    }
                }
            }
        }
        for(int row = 0; row < m; ++row){
            String lastOccupied = null;
            for(int col = n - 1; col >= 0; --col){
                if(guardSet.contains(row + "-" + col)){
                    lastOccupied = "G";
                }else if(wallSet.contains(row + "-" + col)){
                    lastOccupied = "W";
                }else{
                    if("G".equals(lastOccupied) && unguarded.contains(row + "-" + col)){
                        unguarded.remove(row + "-" + col);
                    }
                }
            }
        }
        for(int col = 0; col < n; ++col){
            String lastOccupied = null;
            for(int row = 0; row < m; ++row){
                if(guardSet.contains(row + "-" + col)){
                    lastOccupied = "G";
                }else if(wallSet.contains(row + "-" + col)){
                    lastOccupied = "W";
                }else{
                    if("G".equals(lastOccupied) && unguarded.contains(row + "-" + col)){
                        unguarded.remove(row + "-" + col);
                    }
                }
            }
        }
        for(int col = 0; col < n; ++col){
            String lastOccupied = null;
            for(int row = m - 1; row >= 0; --row){
                if(guardSet.contains(row + "-" + col)){
                    lastOccupied = "G";
                }else if(wallSet.contains(row + "-" + col)){
                    lastOccupied = "W";
                }else{
                    if("G".equals(lastOccupied) && unguarded.contains(row + "-" + col)){
                        unguarded.remove(row + "-" + col);
                    }
                }
            }
        }
        System.out.println(unguarded);
        return unguarded.size();
    }

}
