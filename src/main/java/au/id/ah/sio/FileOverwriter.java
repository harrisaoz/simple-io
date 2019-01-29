package au.id.ah.sio;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;

/**
 * Created by Anthony on 21/03/2016.
 */
public class FileOverwriter {
    final File file;
    private String encoding = "UTF-8";

    public static FileOverwriter apply(String filename) {
        final File f = new File(filename);
        final String parent = f.getParent();

        return apply(f, parent);
    }

    public static FileOverwriter apply(String folder, String filename) {
        return apply(new File(folder, filename), folder);
    }

    public static FileOverwriter apply(File file, String parent) {
        new File(parent).mkdirs();

        return new FileOverwriter(file);
    }

    public FileOverwriter(File file) {
        this.file = file;
    }

    public void writeBytes(byte[] data) throws Throwable {
        if (data != null) {
            file.createNewFile();

            try (OutputStream stream = new FileOutputStream(file)) {
                stream.write(data);
            }
        }
    }

    public void writeText(String text) throws Throwable {
        if (text != null) {
            writeBytes(text.getBytes(encoding));
        }
    }
}

