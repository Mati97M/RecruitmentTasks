package dev.mati.tasks.LeetCode.Tries;

import java.util.HashMap;

public class WordDictionary {
    private class TrieNode {
        boolean word = false;
        HashMap<Character, TrieNode> children = new HashMap<>();
    }
    private TrieNode root;

    public static void main(String[] args) {
        WordDictionary wd = new WordDictionary();
        wd.addWord("a");
        wd.addWord("a");

        System.out.println(wd.search(".a"));
        System.out.println(wd.search("a."));
    }

    public WordDictionary() {
        this.root = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode curr = this.root;
        for(char c: word.toCharArray()) {
            if(!curr.children.containsKey(c))
                curr.children.put(c, new TrieNode());
            curr = curr.children.get(c);
        }
        curr.word = true;
    }

    public boolean search(String word) {
        return dfs(root, word, 0);
    }
    private static boolean dfs(TrieNode root, String word, int i) {
        TrieNode curr = root;
        for(int j = i; j < word.length(); j++) {
            char c = word.charAt(j);
            if(Character.compare(c, '.') == 0) {
                for(TrieNode child: curr.children.values()) {
                    if(dfs(child, word, j + 1))
                        return true;
                }
                return false;
            }
            else {
                if(!curr.children.containsKey(c))
                    return false;
                curr = curr.children.get(c);
            }
        }
        return curr.word;
    }
}
