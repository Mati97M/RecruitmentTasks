package dev.mati.tasks.LeetCode.binarySearch;

import java.util.ArrayList;
import java.util.HashMap;

public class TimeBasedKeyValueStore {
    public static void main(String[] args) {
        String tmp;
        TimeMap timeMap = new TimeMap();
        timeMap.set("love","high",10);
        timeMap.set("love","low",20);
        tmp = timeMap.get("love",5);
        System.out.println(tmp);
        tmp = timeMap.get("love",10);
        System.out.println(tmp);
        tmp = timeMap.get("love",15);
        System.out.println(tmp);
        tmp = timeMap.get( "love",20);
        System.out.println(tmp);
        tmp = timeMap.get( "love",25);
        System.out.println(tmp);

    }
}

class TimeMap {
    private HashMap<String,ArrayList<Integer>> timestamps;
    private HashMap<Integer,String> values;
    public TimeMap() {
        this.timestamps = new HashMap<String,ArrayList<Integer>>();
        this.values = new HashMap<Integer,String>();
    }

    public void set(String key, String value, int timestamp) {
        if(!timestamps.containsKey(key)) {
            ArrayList<Integer> tmp = new ArrayList<>();
            tmp.add(timestamp);
            timestamps.put(key,tmp);
            values.put(timestamp,value);
            return;
        }
        timestamps.get(key).add(timestamp);
        values.put(timestamp,value);
    }

    public String get(String key, int timestamp) {
        if(!timestamps.containsKey(key))
            return "";
        int index = searchTimeStamp(key,timestamp);
        ArrayList<Integer> arr = timestamps.get(key);
        if(index == -1)
            return "";
        return values.get(arr.get(index));
    }
    public int searchTimeStamp(String key, int target) {
        ArrayList<Integer> arr = timestamps.get(key);
        if(target < arr.get(0))
            return -1;
        if(target > arr.get(arr.size() - 1)) {
            return arr.size() - 1;
        }

        int m = -1;
        int l = 0;
        int r = arr.size() - 1;
        while(l <= r) {
            m = (l + r) / 2;
            if(arr.get(m) == target)
                return m;
            if(arr.get(m) < target)
                l = m + 1;
            else
                r = m - 1;
        }
        if(arr.get(m) > target)
            m --;
        return m;
    }
}
