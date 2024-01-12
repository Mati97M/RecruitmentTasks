package dev.mati.tasks.LeetCode.Intervals;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Scanner;

public class DataLoader {
    static int[] getQueries(String path) throws IOException{
        int[] res = null;
        try(Scanner scn = new Scanner(new BufferedReader(new FileReader(path)))) {
            scn.useDelimiter("\\[|,|\\]");
            LinkedList<String> queriesList = new LinkedList<>();
            while(scn.hasNext()) {
                String s = scn.next();
                if(!s.isEmpty()) {
                    queriesList.add(s);
                }
            }
            res = new int[queriesList.size()];
            int r = 0;
            for(String q: queriesList) {
                res[r] = Integer.parseInt(q);
                r++;
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return res;
    }
    static int[][] getIntervals(String path) throws IOException{
        int[][] res = null;
        try(Scanner scn = new Scanner(new BufferedReader(new FileReader(path)))) {
            scn.useDelimiter("\\[\\[|\\],\\[|\\]\\]");
            LinkedList<String> intervalsList = new LinkedList<>();
            while(scn.hasNext()) {
                String s = scn.next();
                if(!s.isEmpty()) {
                    intervalsList.add(s);
                }
            }
            res = new int[intervalsList.size()][];
            int r = 0;
            for(String itv: intervalsList) {
                int[] tmp = new int[2];
                int delimPos = itv.indexOf(",");
                tmp[0] = Integer.parseInt(itv.substring(0, delimPos));
                tmp[1] = Integer.parseInt(itv.substring(delimPos + 1));
                res[r] = tmp;
                r++;
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return res;
    }
}
