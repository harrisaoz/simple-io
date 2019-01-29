package au.id.ah.sio

import java.io.File

import org.junit.runner.RunWith
import org.specs2.runner.JUnitRunner
import org.specs2.mutable.Specification

/**
 * Created by Anthony on 04/06/2015.
 */
@RunWith(classOf[JUnitRunner])
class FileOverwriterSpec extends Specification {
  val targetDir = "./target"

  "FileOverwriterSpec" should {
    "silently ignore attempts to write null data" in {
      FileOverwriter.apply(targetDir, "should-not-be-created").writeBytes(null).should(not(throwA[NullPointerException]))
    }
    "not create a new file when instructed to accept null data" in {
      FileOverwriter.apply(targetDir, "should-not-be-created").writeBytes(null)
      new File("""D:\Test""", "should-not-be-created").exists() should beFalse
    }
    "silently ignore attempts to write null text" in {
      FileOverwriter.apply(targetDir, "should-not-be-created").writeText(null).should(not(throwA[NullPointerException]))
    }
    "not create a new file when instructed to accept null text" in {
      FileOverwriter.apply(targetDir, "should-not-be-created").writeText(null)
      new File("""D:\Test""", "should-not-be-created").exists() should beFalse
    }
  }
}
