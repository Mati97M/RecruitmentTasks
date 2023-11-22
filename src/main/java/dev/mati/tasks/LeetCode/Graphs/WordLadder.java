package dev.mati.tasks.LeetCode.Graphs;

import java.util.*;

public class WordLadder {   //to do: write more optimal (faster) solution this, does not pass the time limit
    private HashSet<String> unUsed = new HashSet<>();
    private HashMap<Integer,HashSet<Character>> posChrs= new HashMap<>();

    public static void main(String[] args) {
        String beginWord = "hit";
        String endWord = "cog";
        List<String> wordList = List.of("hot","dot","dog","lot","log","cog");

        System.out.println(new WordLadder().ladderLength(beginWord, endWord, new ArrayList<>(wordList)));

        beginWord = "hot";
        endWord = "dog";
        wordList = List.of("hot","dog");
        System.out.println(new WordLadder().ladderLength(beginWord, endWord, new ArrayList<>(wordList)));
    }
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if(!wordList.contains(endWord))
            return 0;

        wordList.add(beginWord);
        var it = wordList.iterator();
        while(it.hasNext()) {
            String word = it.next();
            for(int i = 0; i < word.length(); i++) {
                if(!posChrs.containsKey(i))
                    posChrs.put(i, new HashSet<>());
                posChrs.get(i).add(word.charAt(i));
            }
            unUsed.add(word);
        }

        LinkedList<String> q = new LinkedList<>();
        q.offer(beginWord);
        unUsed.remove(beginWord);
        int seqLength = 1;

        while(!q.isEmpty()) {
            int size = q.size();
            for(int i = 0; i < size; i++) {
                String polled = q.poll();
                if(polled.equals(endWord))
                    return seqLength;
                for (String s: getPossibleNeighbs(polled)) {
                    q.offer(s);
                }
            }
            seqLength++;
        }
        return 0;
    }
    private ArrayList<String> getPossibleNeighbs(String word) {
        ArrayList<String> result = new ArrayList<>();
        StringBuilder currWord = new StringBuilder(word);
        unUsed.remove(word);
        for(int i = 0; i < word.length(); i++) {
            if(!posChrs.containsKey(i))
                break;
            for(char c: posChrs.get(i)) {
                currWord.replace(i, i + 1, String.valueOf(c));
                String cw = currWord.toString();
                if(unUsed.contains(cw) && !cw.equals(word))
                    result.add(currWord.toString());
                currWord.replace(i, i + 1, String.valueOf(word.charAt(i)));
            }
        }
        return result;
    }
}
