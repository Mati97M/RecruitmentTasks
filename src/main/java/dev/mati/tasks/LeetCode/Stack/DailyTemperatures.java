package dev.mati.tasks.LeetCode.Stack;

import java.util.Arrays;
import java.util.Stack;

public class DailyTemperatures {
    public static void main(String[] args) {
        int[] temperatures = {73,74,75,71,69,72,76,73};
        System.out.println(Arrays.toString(dailyTemperatures(temperatures)));
    }
    public static int[] dailyTemperatures(int[] temperatures) {
        int[] answer = new int[temperatures.length];
        Stack<Integer> hotterDaysIndx = new Stack<Integer>();
        for(int i = temperatures.length - 1; i >= 0; i--) {
            while(!hotterDaysIndx.isEmpty() &&
                    temperatures[i] >= temperatures[hotterDaysIndx.peek()]) {
                hotterDaysIndx.pop();
            }
            if(!hotterDaysIndx.isEmpty())
                answer[i] = hotterDaysIndx.peek() - i;
            hotterDaysIndx.push(i);
        }
        return answer;
    }
    public static int[] dailyTemperaturesBF(int[] temperatures) {
        int[] answer = new int[temperatures.length];
        for(int currDay = 0; currDay < temperatures.length - 1; currDay++) {
            for (int nAfter = currDay + 1; nAfter < temperatures.length; nAfter++) {
                if(temperatures[nAfter] > temperatures[currDay]) {
                    answer[currDay] = nAfter - currDay;
                    break;
                }
            }
        }
        return answer;
    }
}
