package com.hefei.leetcode;

/**
 * Hello world!
 *
 */
public class MultiplyStrings
{


    public static String multiply(String num1, String num2) {
        int len1 = num1.length();
        int len2 = num2.length();
        int len = len1 + len2;
        int n = len -2;

        long[] values = new long[len];
        for(int i = 0; i< len; i++) {
            values[i] = 0;
        }

        for(int i = 0; i < len1; i++) {
            for(int j = 0; j < len2; j++) {
                values[n - i - j] += (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
            }
        }



        long carry = 0;
        for(int i = 0; i < len; i ++) {
            long s = (values[i] + carry);
            carry = s/10;
            values[i] = (byte)(s % 10);
        }
        int nonZeroIndex = -1;
        for(int i = len -1; i>= 0; i--) {
            if(values[i]==0) {
                continue;
            } else {
                nonZeroIndex = i;
                break;
            }
        }
        int length = nonZeroIndex + 1;
        byte[] r = new byte[length];
        if(nonZeroIndex == -1) {
            return new String("0");
        } else {
            for (int i = nonZeroIndex; i >= 0; i--) {
                r[nonZeroIndex - i] = (byte)(values[i] + '0');
            }
            return new String(r);
        }
    }

    public static void main( String[] args )
    {
        System.out.println(multiply("6964594125027226699998128707627435007621143975736747759751", "333791918659904899647584436187733004125181273682766434"));
    }
}
