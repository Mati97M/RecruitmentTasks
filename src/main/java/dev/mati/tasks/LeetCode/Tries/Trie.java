package dev.mati.tasks.LeetCode.Tries;

import java.util.HashMap;

public class Trie {
    private class TrieNode {
        boolean word = false;
        HashMap<Character,TrieNode> children = new HashMap<>();
    }

    private TrieNode root;
    public Trie() {
        this.root = new TrieNode();
    }
    public boolean beginsWith(char c) {
        return root.children.get(c) != null;
    }
    public void insert(String word) {
        TrieNode curr = this.root;
        for(char c: word.toCharArray()) {
            if(!curr.children.containsKey(c))
                curr.children.put(c, new TrieNode());
            curr = curr.children.get(c);
        }
        curr.word = true;
    }

    public boolean search(String word) {
        TrieNode curr = this.root;
        for(char c: word.toCharArray()) {
            if(!curr.children.containsKey(c))
                return false;
            curr = curr.children.get(c);
        }
        return curr.word;
    }
    public boolean searchSequence(String seq) {
        TrieNode curr = this.root;
        for(char c: seq.toCharArray()) {
            if(!curr.children.containsKey(c))
                return false;
            curr = curr.children.get(c);
        }
        return true;
    }

    public boolean startsWith(String prefix) {
        TrieNode curr = this.root;
        for(char c: prefix.toCharArray()) {
            if(!curr.children.containsKey(c))
                return false;
            curr = curr.children.get(c);
        }
        return true;
    }
}