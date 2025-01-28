pacakge org.hunter;

import java.util.*;

class pathsumiii {

    int ans = 0;

    public int pathSum(TreeNode root, int targetSum) {
        if(root == null){
            return ans;
        }
        Map<Long,Integer> map = new HashMap<>();
        dfs(root, root.val, map, targetSum);
        return ans;
    }

    void dfs(TreeNode node, long curSum, Map<Long,Integer> prefixMap, int targetSum){
        long diff = curSum - targetSum;
        if(curSum == targetSum){
            ++ans;
        }
        if(prefixMap.containsKey(diff)){
            ans += prefixMap.get(diff);            
        }
        if(prefixMap.containsKey(curSum)){
            prefixMap.put(curSum, prefixMap.get(curSum) + 1);
        }else{
            prefixMap.put(curSum, 1);
        }
        if(node.left != null){
            dfs(node.left, curSum + node.left.val, prefixMap, targetSum);            
        }
        if(node.right != null){
            dfs(node.right, curSum + node.right.val, prefixMap, targetSum);
        }        
        prefixMap.put(curSum, prefixMap.get(curSum) - 1);
    }

}
