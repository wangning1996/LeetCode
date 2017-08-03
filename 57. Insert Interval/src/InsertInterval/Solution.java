package InsertInterval;

/**
 * Created by wangning on 2017/7/27.
 */
public class Solution {
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        List<Interval> list = new ArrayList<>();
        if(intervals.size()==0){
            list.add(newInterval);
            return list;
        }
        intervals.add(newInterval);
        Collections.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                if(o1.start>o2.start)
                    return 1;
                else if(o1.start==o2.start)
                    return 0;
                else
                    return -1;
            }
        });
        for(int i=0;i<intervals.size()-1;i++){
            //如果下个区间的start>当前的end，说明这个区间到此为止，不存在任何重叠可能
            Interval a =intervals.get(i);
            Interval b= intervals.get(i+1);
            if(a.end<b.start){
                list.add(a);
            }
            //有重叠时，将a的信息赋给b
            else if(a.end>=b.start){
                if(a.end>b.end){
                    b.end=a.end;
                }
                b.start=a.start;
            }

        }
        Interval a =intervals.get(intervals.size()-1);
        list.add(a);
        return list;
    }
}
