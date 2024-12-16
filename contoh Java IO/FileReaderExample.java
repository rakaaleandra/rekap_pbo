
import java.io.FileReader;
import java.io.IOException;

public class FileReaderExample {
    public static void main(String[] args) {
        try {
            FileReader reader = new FileReader("/home/rakaaleandra/Kuliah/semester_3/rekap_pbo/contoh Java IO/data_filereader.txt");
            int data = reader.read();
            while(data != -1){
                System.out.print((char)data);
                data = reader.read();
            }
            reader.close();
        } catch (IOException e) {
            System.out.println("File tidak ditemukan.");
        } finally{
        }
    }
}