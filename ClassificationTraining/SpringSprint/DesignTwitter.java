package ClassificationTraining.SpringSprint;

import java.util.*;

/**
 * @Classname DesignTwitter
 * @Description TODO
 * @Date 2021/2/13 10:35
 * @Created by Administrator
 * 设计一个简化版的推特(Twitter)，可以让用户实现发送推文，关注/取消关注其他用户，
 * 能够看见关注人（包括自己）的最近十条推文。你的设计需要支持以下的几个功能：
 * postTweet(userId, tweetId): 创建一条新的推文
 * getNewsFeed(userId): 检索最近的十条推文。每个推文都必须是由此用户关注的人或者是用户自己发出的。
 * 推文必须按照时间顺序由最近的开始排序。
 * follow(followerId, followeeId): 关注一个用户
 * unfollow(followerId, followeeId): 取消关注一个用户
 */
public class DesignTwitter {
    Map<Integer, List<Integer>> followMap;
    Map<Integer, List<Integer>> userIdNewsMap;

    public DesignTwitter() {
        followMap = new HashMap<>();
        userIdNewsMap = new HashMap<>();
    }

    /**
     * Compose a new tweet.
     */
    public void postTweet(int userId, int tweetId) {
        if (!userIdNewsMap.containsKey(userId)) {
            userIdNewsMap.put(userId, new ArrayList<>());
        }
        userIdNewsMap.get(userId).add(tweetId);
    }

    /**
     * Retrieve the 10 most recent tweet ids in the user's news feed.
     * Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent.
     */
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> res = new ArrayList<>();
        for (Map.Entry<Integer, List<Integer>> entry : userIdNewsMap.entrySet()) {
            if (entry.getKey() == userId) {
                res=entry.getValue();
            }
        }
        if(followMap.containsKey(userId)){
            List<Integer> followeeList=followMap.get(userId);
            if(!followeeList.isEmpty()){
                for(int id:followeeList){
                    for (Map.Entry<Integer, List<Integer>> entry : userIdNewsMap.entrySet()) {
                        if (entry.getKey() == id) {
                            if(!entry.getValue().isEmpty()){
                                res.addAll(entry.getValue());
                            }
                        }
                    }
                }
            }
        }
        Collections.reverse(res);

        return res;
    }

    /**
     * Follower follows a followee. If the operation is invalid, it should be a no-op.
     */
    public void follow(int followerId, int followeeId) {
        if(!followMap.containsKey(followerId)){
            followMap.put(followerId,new ArrayList<>());
        }
        followMap.get(followerId).add(followeeId);
    }

    /**
     * Follower unfollows a followee. If the operation is invalid, it should be a no-op.
     */
    public void unfollow(int followerId, int followeeId) {
        if(followMap.containsKey(followerId)){
            List<Integer> res=followMap.get(followerId);
            List<Integer> followeeTwitterList=new ArrayList<>();
            if(res.contains(followeeId)){
                res.remove(res.indexOf(followeeId));
                followMap.put(followerId,res);
                for (Map.Entry<Integer, List<Integer>> entry : userIdNewsMap.entrySet()) {
                    if (entry.getKey() == followeeId) {
                        followeeTwitterList=entry.getValue();
                        for(int id:followeeTwitterList){
                            entry.getValue().remove(followeeTwitterList.indexOf(id));
                        }
                    }
                }
            }

        }
    }

    public static void main(String[] args) {
        DesignTwitter twitter = new DesignTwitter();
        // 用户1发送了一条新推文 (用户id = 1, 推文id = 5).
        twitter.postTweet(1, 5);
        // 用户1的获取推文应当返回一个列表，其中包含一个id为5的推文.
        System.out.println(twitter.getNewsFeed(1));
        // 用户1关注了用户2.
        twitter.follow(1, 2);
        // 用户2发送了一个新推文 (推文id = 6).
        twitter.postTweet(2, 6);
        // 用户1的获取推文应当返回一个列表，其中包含两个推文，id分别为 -> [6, 5].
        // 推文id6应当在推文id5之前，因为它是在5之后发送的.
        System.out.println(twitter.getNewsFeed(1));;
        // 用户1取消关注了用户2.
        twitter.unfollow(1, 2);
        // 用户1的获取推文应当返回一个列表，其中包含一个id为5的推文.
        // 因为用户1已经不再关注用户2.
        System.out.println(twitter.getNewsFeed(1));


    }
}
