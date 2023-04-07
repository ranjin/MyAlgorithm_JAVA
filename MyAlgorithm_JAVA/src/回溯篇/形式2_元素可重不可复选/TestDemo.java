
import java.util.LinkedList;


// 数组candidates中和为target的子集
public class Solution {
    LinkedList<List<Integer>> res = new LinkedList<>();

    LinkedList<Integer> track = new LinkedList<>();

    // 记录路径和
    int trackSum = 0;
    //ji
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        backtrack(candidates, 0, target);
        return res;
    }


    public void backtrack(int[] nums, int start, int target) {

        if (trackSum == target) {
            res.add(new LinkedList<>(track));
            return;
        }

        if (trackSum > target) {
            return;
        }

        for (int i = start; i < nums.length; i++) {

            // 减枝
            if (i > start && nums[i] == nums[i - 1]) {
                continue;
            }
            // 做选择
            trackSum += nums[i];
            track.addLast(nums[i]);

            //
            backtrack(nums, i + 1, target);

            trackSum -= nums[i];
            track.removeLast();
        }

    }
}
