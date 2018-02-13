package p_6ku;

import java.util.Arrays;
import java.util.DoubleSummaryStatistics;
import java.util.stream.Stream;

public class Stats {
  public static double[][] getMinAvgMax(int discard, double[][] data) {
    int num=data.length;
    double[][] result=new double[num+1][3];
    double sum,totalSum=0;
    int count=0;
    result[num][0]=data[0][discard];
    result[num][2]=data[0][discard];
    for (int i = 0; i < num; i++) {
      sum=0;
      result[i][0]=data[i][discard];
      result[i][2]=data[i][discard];
      for (int j = discard; j <data[i].length-discard ; j++) {
        System.out.print(data[i][j]+"\t");
        sum+=data[i][j];
        if (result[i][0]>data[i][j]){
          result[i][0]=data[i][j];
        }
        if (result[i][2]<data[i][j]){
          result[i][2]=data[i][j];
        }
      }
      totalSum+=sum;
      count+=(data[i].length-2*discard);
      result[i][1]=sum/(data[i].length-2*discard);
      result[num][0]=Math.min(result[num][0],result[i][0]);
      result[num][2]=Math.max(result[num][2],result[i][2]);
    }
    result[num][1]=totalSum/count;
    return result;
  }

  public static double[][] getMinAvgMax1(int discard, double[][] data) {
    DoubleSummaryStatistics total = new DoubleSummaryStatistics();

    Stream<DoubleSummaryStatistics> stats =
      Arrays.stream(data)
        .map(a -> Arrays.stream(a).limit(a.length - discard).skip(discard).summaryStatistics())
        .peek(s -> total.combine(s));

    return
      Stream.concat(stats, Stream.of(total))
        .map(s -> new double[]{s.getMin(), s.getAverage(), s.getMax()})
        .toArray(double[][]::new);
  }
}
