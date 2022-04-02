package format;

import java.text.MessageFormat;

public class MessageFormatEx {
    public static void main(String[] args) {

        String msg = "Name: {0} \nTel: {1} \nAge: {2} \nBirthday: {3}";
        Object[] arguments = {
                "Toby", "00-000-0000", "10", "05-08"
        };

        String result = MessageFormat.format(msg, arguments);
        System.out.println(result);
    }
}
