package chapter19.practice5;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.experimental.theories.DataPoints;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.runner.RunWith;

@RunWith(Theories.class)
public class ConsumptionTaxTest {
    @DataPoints
    public static Fixture[] FIXTURES = new Fixture[] {
        new Fixture(5, 100, 105),
        new Fixture(5, 3000, 3150),
        new Fixture(10, 50, 55),
        new Fixture(5, 50, 52),
        new Fixture(3, 50, 51)
    };
    
    @Theory
    public void testApply_消費税が加算された価格を取得できる(Fixture fixture) throws Exception {
        // SetUp
        ConsumptionTax sut = new ConsumptionTax(fixture.taxRate);
        String description = "when rate=" + fixture.taxRate + ", price=" + fixture.price;
        // Exercise
        // Verify
        assertThat(description, sut.apply(fixture.price), is(fixture.expected));
    }
}

class Fixture {
    final int taxRate;
    final int price;
    final int expected;

    public Fixture(int taxRate, int price, int expected) {
        this.taxRate = taxRate;
        this.price = price;
        this.expected = expected;
    }
}