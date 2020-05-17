package solutions.backtrace;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个不包含重复数字的序列，返回所有不重复的全排列。
 *
 * @author chujunjie
 * @date Create in 9:57 下午 2020/5/17
 * @modified by
 */
public class Solution46 {
    private static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> track = new ArrayList<>();
        backtrack(res, track, nums);
        return res;
    }

    private static void backtrack(List<List<Integer>> res, List<Integer> track, int[] nums) {
        if (track.size() == nums.length) {
            res.add(new ArrayList<>(track));
            return;
        }

        for (int num : nums) {
            if (track.contains(num)) {
                continue;
            }
            track.add(num);
            backtrack(res, track, nums);
            track.remove(track.size() - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(permute(new int[]{1, 2, 3}));
    }
}
