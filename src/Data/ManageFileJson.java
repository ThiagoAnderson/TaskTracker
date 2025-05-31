package Data;


import Entities.Task;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

public class ManageFileJson {
    // 1.1 Criar arquivo .json vazio
    public static void createPath() {
        Path pasta = Paths.get("Tasks");
        Path arquivo = pasta.resolve("tasks.json");
        try {
            if (Files.notExists(pasta)) {
                Files.createDirectories(pasta);
            }
            if (Files.notExists(arquivo)) {
                Files.writeString(arquivo, "[]", StandardOpenOption.CREATE_NEW);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // 2 criar nova tarefa dentro desse array, recebendo um objeto task
    public static void populateJson(Task tsk) {
        createPath();
        Path archive = Paths.get("Tasks", "tasks.json");

        try {
            List<String> tasksJson = new ArrayList<>();

            if (Files.exists(archive)) {
                String content = Files.readString(archive).trim();

                if (content.length() > 2) {
                    String internal = content.substring(1, content.length() - 1).trim();

                    String[] objects = internal.split("\\},\\s*");
                    for (int i = 0; i < objects.length; i++) {
                        String obj = objects[i];
                        if (!obj.endsWith("}")) {
                            obj += "}";
                        }
                        tasksJson.add(obj);
                    }
                }
            }

            tasksJson.add(tsk.toString());

            StringBuilder jsonBuilder = new StringBuilder();
            jsonBuilder.append("[\n");

            for (int i = 0; i < tasksJson.size(); i++) {
                jsonBuilder.append("    ");  // indentação 4 espaços
                jsonBuilder.append(tasksJson.get(i));

                if (i < tasksJson.size() - 1) {
                    jsonBuilder.append(",");
                }
                jsonBuilder.append("\n");
            }

            jsonBuilder.append("]");

            Files.writeString(archive, jsonBuilder.toString());
            System.out.println("Tarefa adicionada com sucesso");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
