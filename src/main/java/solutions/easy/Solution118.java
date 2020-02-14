package solutions.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Description: 给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。
 * <p>
 * 在杨辉三角中，每个数是它左上方和右上方的数的和。
 * @Author: chujunjie
 * @Date: Create in 18:16 2020/2/3
 * @Modified By
 */
public class Solution118 {

    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> lists = new ArrayList<>();
        List<Integer> list;

        if (numRows <= 0) {
            return lists;
        }

        for (int i = 0; i < numRows; i++) {
            list = Arrays.asList(new Integer[i + 1]);
            list.set(0, 1);
            list.set(i, 1);
            for (int j = 1; j < i; j++) {
                List<Integer> prevList = lists.get(i - 1);
                list.set(j, prevList.get(j - 1) + prevList.get(j));
            }
            lists.add(list);
        }

        return lists;
    }

    public static void main(String[] args) {
        System.out.println(generate(5));
    }
}
