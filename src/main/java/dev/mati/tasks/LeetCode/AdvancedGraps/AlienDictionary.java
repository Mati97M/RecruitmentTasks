package dev.mati.tasks.LeetCode.AdvancedGraps;

import java.util.HashMap;
import java.util.HashSet;

public class AlienDictionary {// TO DO: how to sort lexicographically heads?
    private StringBuilder out = new StringBuilder();
    private HashSet<Character> visited = new HashSet<>();
    public static void main(String[] args) {
        String[] in =  {"wrt","wrf","er","ett","rftt"};
        System.out.println(new AlienDictionary().alienOrder(in));

        in = new String[] {"zy","zx"};
        System.out.println(new AlienDictionary().alienOrder(in));
    }
    public String alienOrder(String[] words) {
        HashMap<Character, HashSet<Character>> nodes = new HashMap<>();
        //prepare graph part I - letters order in array
        HashSet<Character> available = new HashSet<>();
        for(int i = words.length - 1; i >= 0; i--) {
            char curr = words[i].charAt(0);
            if(nodes.containsKey(curr)) {
                continue;
            }
            HashSet<Character> tmp = new HashSet<>();
            for(char c: available) {
                if(c != curr) {
                    tmp.add(c);
                }
            }
            nodes.put(curr, tmp);
            available.add(curr);
        }
        //prepare grapgh part II - comparing by pairs
        for(int i = 0; i < words.length - 1; i++) {
            String a = words[i];
            String b = words[i + 1];
            if(!generateOrder(a, b, nodes)) {
                return "";
            }
        }

        //traverse with postOrderDFS and then reverse -> topological sort
        for(char c: nodes.keySet()) {
            dfs(nodes, c);
        }
        return out.reverse().toString();
    }
    private boolean generateOrder(String a, String b, HashMap<Character, HashSet<Character>> nodes) {
        char currA = ' ';
        char currB = ' ';
        for(int i = 0; i < a.length(); i++) {
            if(i >= b.length()) {
                return false;
            }
            currA = a.charAt(i);
            currB = b.charAt(i);
            if(currA != currB) {
                break;
            }
        }
        if(!nodes.containsKey(currA)) {
            nodes.put(currA, new HashSet<>());
        }
        nodes.get(currA).add(currB);
        if(!nodes.containsKey(currB)) {
            nodes.put(currB, null);
        }
        return true;
    }
    private void dfs(HashMap<Character, HashSet<Character>> nodes, Character curr) {
        if(visited.contains(curr) || curr == null)
            return;
        if(nodes.get(curr) != null) {
            for(char c: nodes.get(curr)) {
                dfs(nodes, c);
            }
        }

        out.append(curr);
        visited.add(curr);
    }
}
