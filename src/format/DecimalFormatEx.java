package format;

import java.text.DecimalFormat;

public class DecimalFormatEx {
    public static void main(String[] args) {

        double number = 12345.67;
        String[] patterns = {
                "0",
                "#",
                "0.0",
                "#.#",
                "000000.0000",
                "######.####",
                "#.#-",
                "-#.#",
                "#,###.##",
                "####E0",
                "#.#E0"

        };

        for (int i = 0; i < patterns.length; i++) {
            DecimalFormat df = new DecimalFormat(patterns[i]);
            System.out.printf("%15s: %s\n", patterns[i], df.format(number));
        }
    }
}
