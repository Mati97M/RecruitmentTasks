package dev.mati.tasks.LeetCode.HeapPriorityQueue;

import java.util.*;

public class Twitter {
    public static void main(String[] args) {
        Twitter obj = new Twitter();
        obj.postTweet(1,5);
        obj.postTweet(1,3);
        System.out.println(obj.getNewsFeed(1));
    }
    private HashMap<Integer, HashSet<Integer>> userFollowed = new HashMap<>();
    private HashMap<Integer, HashSet<Integer>> userTweets = new HashMap<>();
    private int postID = 0;
    private HashMap<Integer, Integer> postIDTweetID = new HashMap<>();
    public Twitter() {

    }

    public void postTweet(int userId, int tweetId) {
        if(!userTweets.containsKey(userId))
            userTweets.put(userId, new HashSet<>());
        userTweets.get(userId).add(postID);
        postIDTweetID.put(postID, tweetId);
        postID++;
    }

    public List<Integer> getNewsFeed(int userId) {
        PriorityQueue<Integer> postsID = new PriorityQueue(Collections.reverseOrder());
        HashSet<Integer> followed = userFollowed.get(userId);
        if(followed == null)
            followed = new HashSet<>();
        followed.add(userId);
        for(int user: followed) {
            HashSet<Integer> currPostsID = userTweets.get(user);
            if(currPostsID == null)
                continue;
            for(int ID: currPostsID)
                postsID.offer(ID);
        }
        ArrayList<Integer> res = new ArrayList<>(10);
        while(!postsID.isEmpty()) {
            if(res.size() == 10)
                break;
            res.add(
                    postIDTweetID.get(postsID.poll()));
        }
        return res;
    }

    public void follow(int followerId, int followeeId) {
        if(!userFollowed.containsKey(followerId))
            userFollowed.put(followerId, new HashSet<>());
        if(!userFollowed.containsKey(followeeId))
            userFollowed.put(followeeId, new HashSet<>());

        userFollowed.get(followerId).add(followeeId);
    }

    public void unfollow(int followerId, int followeeId) {
        HashSet<Integer> followed = userFollowed.get(followerId);
        if(followed != null)
            followed.remove(followeeId);
    }
}
