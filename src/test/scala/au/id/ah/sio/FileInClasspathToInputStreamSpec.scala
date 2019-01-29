package au.id.ah.sio

import java.io.{FileNotFoundException, IOException, InputStream}

import org.junit.runner.RunWith
import org.specs2.runner.JUnitRunner


/**
 * Specification of FileInClasspathToInputStream.
 *
 * TODO: fully specify behaviour when the named file found in the classpath is unreadable.
 */
@RunWith(classOf[JUnitRunner])
class FileInClasspathToInputStreamSpec extends org.specs2.mutable.Specification {
  val fileToStream = new FileInClasspathToInputStream

  "Application of FileInClasspathToInputStream" should {
    "throw java.io.FileNotFoundException when the named file doesn't exist" in {
      fileToStream("not-a-file") should throwAn[FileNotFoundException]
    }
    "not throw java.io.FileNotFoundException when the named file exists" in {
      fileToStream("readable-file").must(not(throwAn[FileNotFoundException]))
    }
    "throw java.io.IOException when the named file exists but can not be opened" in {
      fileToStream("unreadable-file") must throwAn[IOException]
    }
    "return an InputStream when the named file exists and can be read" in {
      fileToStream("readable-file") should beAnInstanceOf[InputStream]
    }
  }
}
