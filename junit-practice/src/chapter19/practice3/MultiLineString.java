package chapter19.practice3;

public class MultiLineString {
    public static String join(String... strings) {
        if (strings == null) {
            return "";
        }

        StringBuilder resultBuilder = new StringBuilder();
        for (int i = 0; i < strings.length; i++) {
            if (i == strings.length - 1) {
                resultBuilder.append(strings[i]);
                break;
            }
            resultBuilder.append(strings[i] != null ? strings[i] : "");
            resultBuilder.append(System.getProperty("line.separator"));
        }

        return resultBuilder.toString();
    }
}
