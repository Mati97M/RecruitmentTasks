package dev.mati.tasks;

public class BinaryGap {
    public static void main(String[] args) {
        System.out.println(solution(561892));
        System.out.println(solution2(561892));
        System.out.println();

        System.out.println(solution2(1041));
        System.out.println(solution2(15));
        System.out.println(solution2(32));
        System.out.println(solution2(561892));
        System.out.println(solution2(6291457));
        System.out.println(solution2(328));
        System.out.println(solution2(805306373));

    }

   static public int solution(int N) {
        int binGapLength = 0;
        int binGapStart = 0;
        int binGapEnd = 0;
        String sBinaryNum = Integer.toBinaryString(N);
        for (int c = binGapStart + 1; c < sBinaryNum.length(); c++) {
            if (sBinaryNum.charAt(c) == '1') {
                if (sBinaryNum.charAt(c - 1) == '0') {
                    binGapEnd = c;
                    int tempBinGapLength = binGapEnd - binGapStart - 1;
                    if (tempBinGapLength > binGapLength) {
                        binGapLength = tempBinGapLength;
                    }
                    binGapStart = binGapEnd;
                } else {
                    binGapStart = c;
                    binGapEnd = binGapEnd;
                }

            }
        }
        return binGapLength;
    }
    static public int solution2(int N) {//best
        int maxLength = 0;
        int counter =0;
        String sBinaryNum = Integer.toBinaryString(N);

        for (int c = 1; c < sBinaryNum.length(); c++) {
            if(sBinaryNum.charAt(c) == '0') {
                counter++;
            }
            else {//1
                if(counter > maxLength) {
                    maxLength = counter;
                }
                counter = 0;
            }
        }
        return maxLength;
    }
}
