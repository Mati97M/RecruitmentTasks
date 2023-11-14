package dev.mati.tasks;

import java.util.ArrayList;
import java.util.HashMap;

public class RobotDrawingRectangle {
    public static void main(String[] args) {
        System.out.println(solution2("<vvv>>^^^<"));
        System.out.println(solution2("<vv>^>^^<v"));
    }

    //    public static boolean solution1(String moves) {
//        HashSet<Character> dirs = new HashSet<>();
//        for (int i = 0; i < moves.length(); i++) {
//            char curDir = moves.charAt(i);
//            dirs.add(curDir);
//            if(i != 0) {
//                char prevDir = moves.charAt(i - 1);
//                if(prevDir != curDir) {
//
//                }
//            }
//        }
//        return dirs.size() == 4 &&
//    }
    public static boolean solution2(String moves) {
        int maxDirChanges = 4;
        int dirChanges = 0;
        HashMap<Character, Integer> sideLengths = new HashMap<>(4);
        for (int i = 0; i < moves.length(); i++) {
            char curDir = moves.charAt(i);
            sideLengths.put(curDir, sideLengths.getOrDefault(curDir, 0) + 1);
            if (i != 0) {
                char prevDir = moves.charAt(i - 1);
                if (prevDir != curDir) {
                    dirChanges++;
                    if (dirChanges > maxDirChanges)
                        return false;
                }
            }
        }
        ArrayList<Character> dirs = new ArrayList<>(4);
        dirs.add('<');
        dirs.add('>');
        dirs.add('^');
        dirs.add('v');
        if (!sideLengths.keySet().containsAll(dirs))
            return false;
        if (!sideLengths.get('<').equals(sideLengths.get('>'))
                || !sideLengths.get('^').equals(sideLengths.get('v')))
            return false;

        int[] curPos = {0, 0};
        for (int i = 0; i < moves.length(); i++) {
            char c = moves.charAt(i);
            switch (c) {
                case '<':
                    curPos[0] -= 1;
                    break;
                case '>':
                    curPos[0] += 1;
                    break;
                case 'v':
                    curPos[1] -= 1;
                    break;
                case '^':
                    curPos[1] += 1;
            }
        }
        return curPos[0] == 0 && curPos[1] == 0;
    }
}
