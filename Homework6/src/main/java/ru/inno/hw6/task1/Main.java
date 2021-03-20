package ru.inno.hw6.task1;

public class Main {
    public static void main(String[] args) {
        String filepath = "readhere.txt";
        String newFile = "sorted.txt";
        CustomFileReader fileReader = new CustomFileReader(newFile, filepath);
        fileReader.readFile();
        fileReader.sort();
//        fileReader.getList().forEach(System.out::println);
        for (String word :
                fileReader.getList()) {
            System.out.println(word);
        }
        fileReader.writeToFile();
    }
}
