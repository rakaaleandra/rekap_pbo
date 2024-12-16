
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;


public class FileInputStreamExample {
    public static void main(String[] args) throws IOException {
        try {
            FileInputStream fis = new FileInputStream("/home/rakaaleandra/Kuliah/semester_3/rekap_pbo/assets/WindahBasudara.png");
            int data = fis.read();
            while(data != -1){
                System.out.print(data);
                data = fis.read();
            }
            fis.close();
        } catch (FileNotFoundException ex) {

        }
    }
}
