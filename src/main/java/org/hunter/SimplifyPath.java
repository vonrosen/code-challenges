package org.hunter;

import java.util.Stack;
import java.util.StringTokenizer;

public class SimplifyPath {

    public static void main(String [] args) {
        SimplifyPath simplifyPath = new SimplifyPath();
        System.out.println(simplifyPath.simplifyPath("/home/"));
        System.out.println(simplifyPath.simplifyPath("/home//foo/"));
        System.out.println(simplifyPath.simplifyPath("/home/user/Documents/../Pictures"));
        System.out.println(simplifyPath.simplifyPath("/.../a/../b/c/../d/./"));
    }

    public String simplifyPath(String path) {
        Stack<String> paths = new Stack<>();
        StringTokenizer st = new StringTokenizer(path, "/");
        while(st.hasMoreTokens()) {
            String token = st.nextToken();
            if(token.equals("..")) {
                if(!paths.isEmpty()) {
                    paths.pop();
                }
            }else if(!token.equals(".")){
                paths.add(token);
            }
        }
        StringBuilder finalPath = new StringBuilder("/");
        for(int i = 0; i < paths.size(); ++i) {
            finalPath.append(paths.get(i));
            if(i < paths.size() - 1) {
                finalPath.append("/");
            }
        }
        return finalPath.toString();
    }

}
