package chapter19.practice4;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.experimental.runners.Enclosed;
import org.junit.experimental.theories.DataPoints;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.runner.RunWith;

@RunWith(Enclosed.class)
public class RangeTest {
    @RunWith(Enclosed.class)
    public static class Range0から10_5{
        @RunWith(Theories.class)
        public static class 範囲外の場合 {
            Range sut;

            @Before
            public void setUp() {
                sut = new Range(0d, 10.5);
            }

            @DataPoints
            public static double[] VALUES = { -0.1, 10.6 };

            @Theory
            public void containsがfalseを返す(double value) throws Exception {
                assertThat("value=" + value, sut.contains(value), is(false));
            }
        }

        @RunWith(Theories.class)
        public static class 範囲内の場合 {
            Range sut;

            @Before
            public void setUp() {
                sut = new Range(0d, 10.5);
            }

            @DataPoints
            public static double[] VALUES = { -0.0, 10.5 };

            @Theory
            public void containsがtrueを返す(double value) throws Exception {
                assertThat("value=" + value, sut.contains(value), is(true));
            }
        }
    }

    @RunWith(Enclosed.class)
    public static class Rangeがマイナス5_1から5_1 {
        @RunWith(Theories.class)
        public static class 範囲外の場合 {
            Range sut;

            @Before
            public void setUp() {
                sut = new Range(-5.1, .51);
            }

            @DataPoints
            public static double[] VALUES = { -5.2, 5.2 };

            @Theory
            public void containsがfalseを返す(double value) throws Exception {
                assertThat("value=" + value, sut.contains(value), is(false));
            }
        }

        @RunWith(Theories.class)
        public static class 範囲内の場合 {
            Range sut;

            @Before
            public void setUp() {
                sut = new Range(-5.1, 5.1);
            }

            @DataPoints
            public static double[] VALUES = { -5.1, 5.1 };

            @Theory
            public void containsがtrueを返す(double value) throws Exception {
                assertThat("value=" + value, sut.contains(value), is(true));
            }
        }
    }
}
