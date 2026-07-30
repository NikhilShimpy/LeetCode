class Solution {
    public int secondsBetweenTimes(String startTime, String endTime) {
        return ToSec(endTime) - ToSec(startTime);
    }
    public int ToSec(String time){
        int h = Integer.parseInt(time.substring(0,2));
        int m = Integer.parseInt(time.substring(3,5));
        int s = Integer.parseInt(time.substring(6,8));

        return (h * 3600 + m * 60 + s);
    }
}