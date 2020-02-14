package solutions.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description: 给定一个非负索引 k，其中 k ≤ 33，返回杨辉三角的第 k 行。
 * <p>
 * 在杨辉三角中，每个数是它左上方和右上方的数的和。
 * @Author: chujunjie
 * @Date: Create in 18:44 2020/2/3
 * @Modified By
 */
public class Solution119 {

    public static List<Integer> getRow(int k) {
        List<Integer> res = new ArrayList<>(k);
        long index = 1;
        for (int i = 0; i < k; i++) {
            res.add((int) index);
            // 杨辉三角同一行，第 ( i + 1) 项是第 i 项的 ( k - 1 - i ) / ( i + 1 ) 倍
            index = index * (k - 1 - i) / (i + 1);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(getRow(30));
    }
}
