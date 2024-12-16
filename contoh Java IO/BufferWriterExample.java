import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class BufferWriterExample {
    public static void main(String[] args) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("/home/rakaaleandra/Kuliah/semester_3/rekap_pbo/contoh Java IO/data_bufferwriter.txt"));
            writer.write("Hello World!");
            writer.newLine();
            writer.close();
        } catch (IOException e) {
            System.out.println("File tidak ditemukan.");
        } finally{
            System.out.println("Berhasil menulis file.");
        }
    }
}
