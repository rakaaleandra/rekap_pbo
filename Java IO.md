# Java Input Output (I/O)

## Apa itu I/O

I/O adalah singkatan dari Input/Output, yang merupakan komunikasi antara aplikasi dengan dunia luar (misalnya, membaca dari atau menulis ke file, input pengguna, dan sebagainya).

## `FileReader` dan `FileWriter`

### FileReader

`FileReader` digunakan untuk membaca file berbasis teks secara langsung, karakter demi karakter.

```java
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
```

Code diatas melakukan pembacaan pada file `data_filereader.txt` sampai akhir.

### FileWriter

`FileWriter` digunakan untuk menulis karakter langsung ke file tanpa melalui buffer.

```java
import java.io.FileWriter;
import java.io.IOException;

public class FileWriterExample {
    public static void main(String[] args) {
        try {
            FileWriter writer = new FileWriter("/home/rakaaleandra/Kuliah/semester_3/rekap_pbo/contoh Java IO/data_filewriter.txt");
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
```

Code diatas akan menulis ulang file `data_filewriter.txt` dengan isi `Hello World!`. Jadi kalau program dijalankan beberapa kali, isi dari file tersebut tidak menumpuk tetapi membuat ulang

Kalau mau meneruskan isi file atau bisa disebut dengan `append` yaitu dengan cara inisialisasinya ditambahkan `true`, seperti

```java
FileWriter writer = new FileWriter("/home/rakaaleandra/Kuliah/semester_3/rekap_pbo/contoh Java IO/data_filewriter.txt", true);
```

Dengan penambahan seperti itu maka program akan meneruskan isi dari file tersebut

## BufferReader dan BufferWriter

Perbedaan utama antara **buffered I/O** dan **non-buffered I/O** (atau "biasa") adalah cara data diproses dan ditransfer selama operasi input/output. **Buffered I/O** menggunakan penyangga (buffer) untuk menyimpan data sementara, sementara **non-buffered I/O** langsung berinteraksi dengan perangkat sumber atau tujuan.

Karena menyimpan data sementara maka akan mengurangi jumlah operasi langsung ke perangkat penyimpanan (seperti hard disk atau SSD). Ini membuat penulisan data dalam jumlah besar atau berulang kali lebih cepat dan lebih efisien dibandingkan dengan FileWriter yang tidak menggunakan buffer.

| **Aspek**              | **Non-Buffered I/O**                  | **Buffered I/O**                      |
|------------------------|---------------------------------------|---------------------------------------|
| **Cara Kerja**         | Data langsung dikirim/diterima dari perangkat. | Data disimpan sementara di buffer sebelum diproses. |
| **Efisiensi**          | Kurang efisien untuk operasi besar/frekuen. | Lebih efisien untuk operasi besar/frekuen. |
| **Kecepatan**          | Lebih lambat karena setiap operasi memicu I/O langsung. | Lebih cepat karena meminimalkan operasi I/O langsung. |
| **Jumlah Operasi I/O** | Operasi dilakukan setiap kali ada permintaan I/O. | Operasi dilakukan dalam blok besar, mengurangi jumlah panggilan. |
| **Fitur Tambahan**     | Tidak ada fitur tambahan.             | Mendukung fitur seperti `readLine()` dan `newLine()`. |

### BufferReader

**BufferedReader** adalah pembungkus (wrapper) yang memberikan buffer di atas stream pembaca lainnya (seperti **FileReader**). Ini digunakan untuk membaca data dalam blok besar (bukan karakter satu per satu).

```java
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class BufferReaderExample {
    public static void main(String[] args) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("/home/rakaaleandra/Kuliah/semester_3/rekap_pbo/contoh Java IO/data_bufferreader.txt"));
            String line = reader.readLine();
            while (line != null) {
                System.out.println(line);
                line = reader.readLine();
            }
            reader.close();
        } catch (IOException e) {
            System.out.println("File tidak ditemukan.");
        }
    }
}
```

Output dari code diatas sama seperti pada `FileReader` tetapi yang membedakan dari sini adalah file dibaca perbaris tidak per-karakter, jadinya cocok jika dipakai dengan file yang isinya banyak

### BufferWriter

`BufferedWriter` adalah pembungkus (wrapper) untuk Writer (seperti FileWriter) yang menambahkan mekanisme buffering untuk meningkatkan efisiensi saat menulis data.

```java
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
```

Cara kerja sama persis seperti `FileWriter`, jika mau melakukan `append` maka dalam construksi `FileWriter` tambahkan `true`

## FileInputStream dan FileOutputStream

### FileInputStream

class `FileInputStream` berguna untuk membaca data dari file dalam bentuk urutan byte. `FileInputStream` ditujukan untuk membaca aliran byte mentah seperti data gambar. Untuk membaca aliran karakter, pertimbangkan untuk menggunakan `FileReader`.

```java

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
```