class Solution {
    public int largestRectangleArea(int[] heights) {
			int n = heights.length;
			int stack[] = new int[n+1];
			int index=-1;
			int max = Integer.MIN_VALUE;
			for(int i=0;i<=n;i++){
				int element =(i==n)?0:heights[i];
				while(index!=-1 && heights[stack[index]]>element) {
					int h = heights[stack[index--]];
					int ps = (index==-1)?-1:stack[index];
					int w = i - ps -1;
					max = Math.max(max, h*w); 
				}
				stack[++index] = i;
			}
			return (max==Integer.MIN_VALUE)?0:max;
    }
}
