//213. House Robber II

class Solution {
    
    private int helper(int[] nums, int idx, int n, Map<Integer,Integer> dpRob, Map<Integer,Integer> dpDontRob){
        int rob=0;
        int dontRob = 0;
        if(idx >= n) retaurn 0; 

        if(dpRob.get(idx)==null){
            rob = nums[idx] + helper(nums, idx+2, n, dpRob,dpDontRob);
            dpRob.put(idx,rob);
        }
        else{
            rob = dpRob.get(idx);
        }

        if(dpDontRob.get(idx)==null){
            dontRob = helper(nums, idx+1, n, dpRob,dpDontRob);
            dpDontRob.put(idx,dontRob);
        }
        else{
            dontRob = dpDontRob.get(idx);
        }
        System.out.println("ROB: "+dpRob);
        System.out.println("DONT ROB: "+dpDontRob);
        return Math.max(rob, dontRob);       

    }

    public int rob(int[] nums) {
        Map<Integer,Integer> dpRob = new HashMap<>();
        Map<Integer,Integer> dpDontRob = new HashMap<>();

        if(nums.length==1) return nums[0];
        return Math.max(helper(nums, 0, nums.length-1, dpRob, dpDontRob), helper(nums, 1, nums.length, dpRob, dpDontRob));
    }
}
