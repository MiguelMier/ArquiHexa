package com.helloworld.examples.port.out.users.files;

import java.io.*;

public class FileCreator {

    private final static String filePath = "/userdata.txt";

    public FileCreator() throws IOException {
        createFileIfNotExists();
    }

    private void createFileIfNotExists() throws IOException {
        File file = new File(filePath);
        if (!file.exists()) {
            file.createNewFile();
        }
    }

    public void writeToFile(String content) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true))) {
            writer.write(content + System.lineSeparator());
        }
    }

    public void clearFile() throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            writer.write("");
        }
    }

    public void deleteLine(String userIdToDelete) throws IOException {
        File inputFile = new File(filePath);
        File tempFile = new File("temp.txt");

        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile));
             BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile))) {

            String currentLine;
            while ((currentLine = reader.readLine()) != null) {
                String userId = currentLine.split(":")[1].trim();

                if (!userId.equals(userIdToDelete)) {
                    writer.write(currentLine + System.getProperty("line.separator"));
                }
            }
        }

        inputFile.delete();
        tempFile.renameTo(inputFile);
    }

}
