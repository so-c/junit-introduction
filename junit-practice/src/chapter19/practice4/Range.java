package chapter19.practice4;

public class Range {
    public final double min;
    public final double max;

    public Range(double min, double max) {
        this.min = min;
        this.max = max;
    }

    /**
     * 指定された値dが、範囲内{@literal (min <= d <= max)}の時に限りtrueを返す.
     * 
     * @param d 範囲内か判定する値
     * @return 範囲内ならtrue, そうでなければfalse
     */
    public boolean contains(double d) {
        return (d >= min) && (d <= max);
    }
}
