class Solution {
    public int maxArea(int[] heights) {
        int maximumWater=0;
        int start=0,end=heights.length-1;
        while(start<=end){
            maximumWater = Math.max(maximumWater,(end-start)*(Math.min(heights[start],heights[end])));
            if(heights[start]<heights[end]){
                start++;
            }else {
                end--;
            }
        }
        return maximumWater;
    }
}
