class optimalpartitionofstring {
    public int partitionString(String s) {
        int ans = 1;
        Set<Character> set = new HashSet<>();
        for(int right = 0; right < s.length(); ++right){
            char c = s.charAt(right);
            if(set.contains(c)){
                set.clear();
                ans++;
            }
            set.add(c);
        }
        return ans;
    }
}
