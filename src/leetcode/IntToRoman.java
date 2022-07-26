package leetcode;

/**
 * @Description:
 *
 * 罗马数字包含以下七种字符： I， V， X， L，C，D 和 M。
 *
 * 字符          数值
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 * 例如， 罗马数字 2 写做 II ，即为两个并列的 1。12 写做 XII ，即为 X + II 。 27 写做 XXVII, 即为 XX + V + II 。
 *
 * 通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4 不写做 IIII，而是 IV。数字 1 在数字 5 的左边，所表示的数等于大数 5 减小数 1 得到的数值 4 。同样地，数字 9 表示为 IX。这个特殊的规则只适用于以下六种情况：
 *
 * I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。
 * X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。
 * C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。
 * 给你一个整数，将其转为罗马数字。
 *
 * 示例 1:
 *
 * 输入: num = 3
 * 输出: "III"
 * 示例 2:
 *
 * 输入: num = 4
 * 输出: "IV"
 * 示例 3:
 *
 * 输入: num = 9
 * 输出: "IX"
 * 示例 4:
 *
 * 输入: num = 58
 * 输出: "LVIII"
 * 解释: L = 50, V = 5, III = 3.
 * 示例 5:
 *
 * 输入: num = 1994
 * 输出: "MCMXCIV"
 * 解释: M = 1000, CM = 900, XC = 90, IV = 4.
 * 提示：
 *
 * 1 <= num <= 3999
 * Related Topics
 * 哈希表
 * 数学
 * 字符串
 *
 * 👍 922
 * 👎 0
 *
 * @Author: yangqb
 * @Date: 2022/7/26
 */
public class IntToRoman {

    /**
     * 1994
     * 1994 - 1000 = 994 : M
     * 994 - 900 = 94 : CM
     * 94 - 90 = 4 : XC
     * 4 : IV
     * MCMXCIV
     *
     * 6:
     * 6-5=1: V
     * 1 I
     * VI
     *
     * 4：
     * 5-1：IV
     *
     * 3:
     * 3-1:I
     * 2-1:I
     * 1-1:I
     * III
     *
     * 88:
     * 50+38
     *
     * @param num
     * @return
     */
    public String intToRoman(int num) {
        int fn = num;  //1994
        String rst = "";
        while (fn != 1) {
            String s1 = getStrValue(fn);  //
            if (!"".equals(s1)) {
                return s1;
            } else {
                int range = range(fn); //range:1000 , 900, 90
                fn = fn - range; //fn:994, 94 , 4
                if (!"".equals(getStrValue(fn))) {
                    return rst+ getStrValue(range)+getStrValue(fn);
                } else  {
                    rst = rst+getStrValue(range);  //M CM
                }
            }
        }
        return rst+getStrValue(fn);
    }

    private int range(int num) {
        if (num > 1000) {
            return 1000;
        }
        if (num < 1000 && num > 900) {
            return 900;
        }
        if (num < 900 && num > 500) {
            return 500;
        }
        if (num < 500 && num > 400) {
            return 400;
        }
        if (num < 400 && num > 100) {
            return 100;
        }
        if (num < 100 && num > 90) {
            return 90;
        }
        if (num < 90 && num > 50) {
            return 50;
        }
        if (num < 50 && num > 40) {
            return 40;
        }
        if (num < 40 && num > 10) {
            return 10;
        }
        if (num < 10 && num > 5) {
            return 5;
        }
        return 1;
    }

    private String getStrValue(int num) {
        switch (num) {
            case 1 : return "I";
            case 4 : return "IV";
            case 5 : return "V";
            case 9 : return "IX";
            case 10 : return "X";
            case 40 : return "XL";
            case 50 : return "L";
            case 90 : return "XC";
            case 100 : return "C";
            case 400 : return "CD";
            case 500 : return "D";
            case 900 : return "CM";
            case 1000 : return "M";
            default:return "";
        }
    }

    public static void main(String[] args) {
        System.out.println(new IntToRoman().intToRoman(1994));
        System.out.println(new IntToRoman().intToRoman(88));
    }
}
