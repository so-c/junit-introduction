package chapter20.practice3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class NetworkResources {
    NetworkLoader loader = new NetworkLoader();

    public String load() throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(loader.getInput()))) {
            StringBuilder stringBuilder = new StringBuilder();
            char[] buffer = new char[512];
            int len;
            while ((len = reader.read(buffer)) != -1) {
                stringBuilder.append(new String(buffer, 0, len));
            }
            return stringBuilder.toString();
        }
    }
}
