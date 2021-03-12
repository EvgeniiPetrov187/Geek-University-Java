package client;

import java.io.*;
import java.util.LinkedList;
import java.util.List;

public class SaveChat {

    /**
     * Метод возвращает файл, который создаёт или находит уже имеющийся
     * @param login Логин клиента
     * @return файл клиента
     * @throws IOException Ошибка ввода-вывода
     */
    public File findFile(String login) throws IOException {
        File file = new File("client/history_" + login + ".txt");
        if (!file.exists()) {
            file.createNewFile();
        }
        return file;
    }

    /**
     * Метод записывает историю чата в файл
     * @param file Файл клиента
     * @param history Сообщения клиента
     */
    public void addHistory(File file, String history) {
        byte[] outData = history.getBytes();
        try (FileOutputStream reader = new FileOutputStream(file, true)) {
            reader.write(outData);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Метод выводит заданное количество строк из истории сообщений
     * @param file Файл клиента
     * @param countOfLines Заданное количество строк
     * @return История сообщений
     * @throws IOException Ошибка ввода-вывода
     */
    public String publicHistory(File file, int countOfLines) throws IOException {
        List<String> lines = new LinkedList<>();
        FileReader fr = new FileReader(file);
        BufferedReader reader = new BufferedReader(fr);
        StringBuilder sb = new StringBuilder();
        String line = reader.readLine();
        while (line != null) {
            lines.add(line);
            line = reader.readLine();
        }
        for (int i = 0; i < lines.size(); i++) {
            if(i >= lines.size() - countOfLines)
                sb.append(lines.get(i)+"\n");
        }
        fr.close();
        reader.close();
        return sb.toString();
    }
}
