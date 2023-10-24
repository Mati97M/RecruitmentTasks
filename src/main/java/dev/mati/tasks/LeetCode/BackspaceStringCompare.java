package dev.mati.tasks.LeetCode;

public class BackspaceStringCompare {
    public static void main(String[] args) {
        String s = "ab##";
        String t = "c#d#";
        System.out.println(backspaceCompare(s,t));
    }
    public static boolean backspaceCompare(String s, String t) {    //time: O(n+m) mem: O(n + m)
        StringBuilder builderS = new StringBuilder();
        for(int i = 0; i < s.length(); i++) {
            if(Character.compare(s.charAt(i),'#') != 0)
                builderS.append(s.charAt(i));
            else {
                if(builderS.length() > 0)
                    builderS.deleteCharAt(builderS.length() - 1);

            }
        }
        StringBuilder builderT = new StringBuilder();
        for(int i = 0; i < t.length(); i++) {
            if(Character.compare(t.charAt(i),'#') != 0)
                builderT.append(t.charAt(i));
            else {
                if(builderT.length() > 0)
                    builderT.deleteCharAt(builderT.length() - 1);

            }
        }
        if(builderT.length() != builderS.length())
            return false;
        for(int i = 0; i < builderT.length(); i++) {
            if(Character.compare(builderT.charAt(i),builderS.charAt(i)) != 0)
                return false;
        }
        return true;
    }

    public static boolean backspaceCompare2(String s, String t) { //to be fixed
        int bcspS = 0;
        int bcspT = 0;
        int sI = s.length() - 1;
        int tI = t.length() - 1;

        while(sI >= 0 && tI >= 0) {
            while(sI >= 0 && Character.compare(s.charAt(sI),'#') == 0) {
                bcspS++;
                sI--;
            }
            while(tI >= 0 && Character.compare(t.charAt(tI),'#') == 0) {
                bcspT++;
                tI--;
            }
            while(sI >= 0 && bcspS > 0) {
                if(Character.compare(s.charAt(sI),'#') == 0)
                    bcspS++;
                bcspS--;
                sI--;
            }
            while(tI >= 0 && bcspT > 0) {
                if(Character.compare(t.charAt(tI),'#') == 0)
                    bcspT++;
                bcspT--;
                tI--;
            }
            if(sI < 0 || tI < 0)
                break;
            if(Character.compare(s.charAt(sI),t.charAt(tI)) != 0)
                return false;
            sI--;
            tI--;
        }
        int i = 0;
        String u = null;
        int bcspI = 0;
        if(sI < 0) {
            i = tI;
            u = t;
        } else {
            i = sI;
            u = s;
        }

        while(i >= 0) {
            while(i >= 0 && Character.compare(u.charAt(i),'#') == 0) {
                bcspI++;
                i--;
            }
            while(i >= 0 && bcspI > 0) {
                bcspI--;
                i--;
            }
            if(i >= 0 && Character.compare(u.charAt(i),'#') != 0)
                return false;
            i--;
        }

        return true;
    }
}
