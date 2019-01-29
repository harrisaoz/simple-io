package au.id.ah.sio;

import au.id.ah.function.Function;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

/**
 * Created by Anthony on 14/05/2015.
 */
public class FileInClasspathToInputStream implements Function<String, InputStream> {
    public InputStream apply(String filename) throws IOException {
        URL fileResource = getClass().getClassLoader().getResource(filename);
        if (fileResource == null) {
            throw new FileNotFoundException(filename);
        }
        return fileResource.openStream();
    }
}
