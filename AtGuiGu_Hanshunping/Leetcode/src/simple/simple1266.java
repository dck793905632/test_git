package simple;

public class simple1266 {
    public static void main(String[] args) {

    }
    public int minTimeToVisitAllPoints(int[][] points) {

        int max=0;
        for (int i = 0; i < points.length-1; i++) {
            max += Math.max(Math.abs(points[i][0] - points[i + 1][0]), Math.abs(points[i][1] - points[i + 1][1]));
        }
        return max;
    }
}
