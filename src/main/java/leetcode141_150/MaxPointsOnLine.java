package leetcode141_150;

import java.util.HashMap;
import java.util.Map;
import java.util.function.IntBinaryOperator;

/**Given n points on a 2D plane, find the maximum number of points
 that lie on the same straight line.
 * Created by eugene on 16/3/8.
 */
public class MaxPointsOnLine {

    class Point {
        int x;
        int y;
        Point() { x = 0; y = 0; }
        Point(int a, int b) { x = a; y = b; }
    }

    /**TODO 注意一个极其容易出错的基础知识
     * http://www.programcreek.com/2014/04/leetcode-max-points-on-a-line-java/
     * 为每个点计算其与其他点的斜率,斜率相同则在同一直线上.注意额外处理重复点和垂直线的情况.
     * @param points
     * @return
     */
    public int maxPoints(Point[] points) {
        if(points.length<=2) return points.length;
        Map<Double, Integer> kCount = new HashMap<>();
        int max = 0;
        for (int i=0; i<points.length; i++){
            Point p1 = points[i];
            int dup = 1, vertical = 0;
            for (int j=i+1; j<points.length; j++){
                Point p2 = points[j];
                if (p1.x==p2.x) {
                    if (p1.y==p2.y) dup++;
                    else vertical++;
                } else { //TODO 错误:double k = (1.0*(p1.y-p2.y))/(p1.x-p2.x);
                    double k = (p1.y-p2.y)==0? 0.0 : (1.0*(p1.y-p2.y))/(p1.x-p2.x);
                    kCount.put(k, kCount.containsKey(k)? kCount.get(k)+1 : 1);
                }
            }
            for (Integer n: kCount.values()) if (n+dup>max) max = n+dup;
            max = Math.max(vertical+dup, max);
            kCount.clear();
        }
        return max;
    }

}
