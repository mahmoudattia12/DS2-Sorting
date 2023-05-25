import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class SortArray <T extends Comparable<T>> {
    private T[] array;

    public SortArray(String filePath) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filePath));
            String line = reader.readLine();
            String[] elements = line.split(",");
            array = (T[]) new Comparable[elements.length];
            for (int i = 0; i < elements.length; i++) {
                array[i] = (T) elements[i].trim();  //remove leading and trailing white spaces from a string
            }
            reader.close();
        } catch (IOException e) {
            System.out.println("file path or its contents is not correct");
        }
    }

}
