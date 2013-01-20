package matcher;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import org.hamcrest.BaseMatcher;
import org.hamcrest.Description;
import org.hamcrest.Matcher;

/**
 * 複数行文字列用のカスタムMatcher.
 */
public class MultiLineStringMatcher extends BaseMatcher<String> {

    private final String expected;
    private Object actual;
    private final List<String> expectedLines = new ArrayList<>();
    private final List<String> actualLines = new ArrayList<>();
    private final Pattern pattern;

    /**
     * ファクトリメソッド.
     * 
     * @param expected 期待値
     * @return 複数行文字列用のカスタムMatcher
     */
    public static Matcher<String> text(String expected) {
        return new MultiLineStringMatcher(expected, System.getProperty("line.separator"));
    }

    /**
     * コンストラクタ.
     * 
     * @param expected 期待値
     * @param lineSeparator 改行コード
     */
    public MultiLineStringMatcher(String expected, String lineSeparator) {
        this.expected = expected;

        this.pattern = compileLineSeparatorPattern(lineSeparator);

        if (expected != null) {
            java.util.regex.Matcher matcher = pattern.matcher(expected);
            while (matcher.find()) {
                expectedLines.add(expected.substring(matcher.start(), matcher.end()));
            }
        }
    }

    /**
     * 指定された改行コードで終了する1行に対応する正規表現を返す.
     * 
     * @param lineSeparator 改行コード
     * @return 指定された改行コードで終了する1行に対応する正規表現
     */
    private static Pattern compileLineSeparatorPattern(String lineSeparator) {
        switch (lineSeparator) {
        case "\r":
            return Pattern.compile(".+(\\r|$)");
        case "\n":
            return Pattern.compile(".+(\\n|$)");
        case "\r\n":
            return Pattern.compile(".+(\\r\\n|$)");
        default:
            throw new AssertionError("Unknown line separator: " + lineSeparator);
        }
    }

    @Override
    public boolean matches(Object actual) {
        this.actual = actual;
        
        // Nullの場合
        if (expected == null) {
            return (actual == null);
        }
        
        // クラスのチェック
        if (!(actual instanceof String)) {
            return false;
        }

        // 改行コードを含めて一致
        if(expected.equals(actual)) {
            return true;
        }
        
        String actualString = (String) actual;
        java.util.regex.Matcher matcher = pattern.matcher(actualString);
        while (matcher.find()) {
            actualLines.add(actualString.substring(matcher.start(), matcher.end()));
        }
        return expectedLines.equals(actualLines);
    }

    @Override
    public void describeTo(Description description) {
        if (expected == null || actual == null) {
            description.appendValue(expected);
        } else {
            int lineCounts = Math.min(expectedLines.size(), actualLines.size());
            for(int index = 0; index < lineCounts; index++) {
                String expectedLine = expectedLines.get(index);
                String actualLine = actualLines.get(index);
                if(!expectedLine.equals(actualLine)) {
                    description.appendValue(expectedLine);
                    description.appendText(", but actual is ");
                    description.appendValue(actualLine);
                    description.appendText(" at line " + (index + 1) + "\n");
                    description.appendValue(expected);
                    return;
                }
            }
            description.appendText("expected text is " + expectedLines.size() + " lines, ");
            description.appendText("but actual is " + actualLines.size() + "lines\n");
            description.appendValue(expected);
        }
    }
}
