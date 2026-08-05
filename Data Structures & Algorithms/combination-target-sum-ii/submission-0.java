class Solution {
    
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(0, target, candidates, new ArrayList<>(), result);
        return result;
    }

    public void backtrack(int start, int currentTarget, int[] candidates, List<Integer> path, List<List<Integer>> result) {
        if(currentTarget == 0) {
            result.add(new ArrayList<>(path));
            return;
        }
        for(int i=start;i<candidates.length;i++) {
            if(i>start && candidates[i] == candidates[i-1]) {
                continue;
            }
            if(candidates[i]>currentTarget) {
                break;
            }
            path.add(candidates[i]);
            backtrack(i+1, currentTarget-candidates[i], candidates, path, result);
            path.remove(path.size()-1);
        }
    }
}
