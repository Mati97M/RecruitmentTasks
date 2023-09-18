package dev.mati.tasks.LeetCode;

import java.util.Collections;
import java.util.Map;
import java.util.Stack;
import java.util.TreeMap;

public class CarFleet {
    public static void main(String[] args) {
        int target = 12;
        int[] position = {10,8,0,5,3};
        int[] speed = {2,4,1,1,3};
        carFleet(target,position,speed);
    }
    public static int carFleet(int target, int[] position, int[] speed) {
        Map<Integer,Integer> PosSpeedDesc = new TreeMap<>(Collections.reverseOrder());
        Stack<Double> fleetsTimes = new Stack<>();
        for (int i = 0; i < position.length; i++) {
            PosSpeedDesc.put(position[i], speed[i]);
        }
        for(var car: PosSpeedDesc.entrySet()) {
            double carTime = (target - car.getKey()) / (double) car.getValue();
            if(fleetsTimes.isEmpty()) {
                fleetsTimes.push(carTime);
                continue;
            }
            if(carTime > fleetsTimes.peek()) {
                fleetsTimes.push(carTime);
            }
        }
        return fleetsTimes.size();
    }
}
