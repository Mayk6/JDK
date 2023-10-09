package Lesson1.Seminar.Chat;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Log {
    private String log;
    Chat chat;
    File file;


    Log(Chat c) {
        file = new File("log.txt");
        chat = c;
    }
    public void read() {
        if (file.canRead()) {
            try (FileReader reader = new FileReader(file)) {
                char[] chars = new char[(int) file.length()];
                reader.read(chars);
                log = new String(chars);
                chat.setChatHistory(log);
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }

    public void write() {
        try(FileWriter writer = new FileWriter(file, false)) {
            log = chat.getChatHistory();
            writer.write(log);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

    }
}
