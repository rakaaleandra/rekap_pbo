import java.io.FileWriter;
import java.io.IOException;

public class FileWriterExample {
    public static void main(String[] args) {
        try {
            FileWriter writer = new FileWriter("/home/rakaaleandra/Kuliah/semester_3/rekap_pbo/contoh Java IO/data_filereader.txt", true);
            writer.write("Hello World!");
            writer.write("\n");
            writer.close();
        } catch (IOException e) {
            System.out.println("File tidak ditemukan.");
        } finally{
            System.out.println("Berhasil menulis file.");
        }
    }
}
