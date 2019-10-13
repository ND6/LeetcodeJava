import org.jetbrains.annotations.NotNull;

import java.lang.reflect.Array;
import java.util.*;

/**
 * @author yan dada
 * @date 2019/10/13-2:39
 **/

public class Answer0056
{
    public static void main(String[] args)
    {
        mergeTest();
    }


    private static void mergeTest()
    {
        //Integer
        int[][] intervals={{1,3},{2,6},{8,10},{15,18}};

        var ans=new Answer0056();
        var res=ans.merge(intervals);
        System.out.println("…………is there something wrong");
        System.out.println(ans);
    }

    public int[][] merge(int[][] intervals)
    {
        List<int[]> res = new ArrayList<>();
        if (intervals.length == 0 || intervals == null) return res.toArray(new int[0][]);

        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        int i = 0;
        while (i < intervals.length)
        {
            int left = intervals[i][0];
            int right = intervals[i][1];
            while (i < intervals.length - 1 && intervals[i + 1][0] <= right)
            {
                i++;
                right = Math.max(right, intervals[i][1]);
            }
            res.add(new int[]{left, right});
            i++;
        }
        return res.toArray(new int[0][]);
    }
}