class Solution {
    public int largestRectangleArea(int[] heights) {
        int N=heights.length;
        Stack<Integer> stack=new Stack<>();
        int max=0;

        for(int i=0;i<=N;i++){
             while(!stack.isEmpty() && (i==N || heights[stack.peek()]>heights[i])){
                int height=heights[stack.peek()];
                stack.pop();
                int width;
                if(stack.isEmpty()){
                    width=i;
                }
                else{
                    width=i-stack.peek()-1;
                }
                int area=height*width;
                max=Math.max(max,area);
             }
             stack.push(i);
        }
        return max;
    }
}
