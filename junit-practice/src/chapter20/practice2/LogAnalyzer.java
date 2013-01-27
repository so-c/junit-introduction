package chapter20.practice2;

import java.io.IOException;
import java.util.Map;

public class LogAnalyzer {
    LogLoader logLoader = new LogLoader();

    public Object analyze(String file) throws AnalyzeException {
        try {
            Map<String, String> rawData = logLoader.load(file);
            return doAnalyze(rawData);
        } catch (IOException e) {
            throw new AnalyzeException(e);
        }
    }

    private Object doAnalyze(Map<String, String> rawData) {
        // 仮実装
        return new Object();
    }

    @SuppressWarnings("serial")
    static class AnalyzeException extends RuntimeException {
        public AnalyzeException(Throwable cause) {
            super(cause);
        }
    }
}
