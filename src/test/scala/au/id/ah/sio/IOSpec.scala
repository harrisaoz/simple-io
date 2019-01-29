package au.id.ah.sio

import java.io.File
import java.nio.file.{Files, Paths}

import org.junit.runner.RunWith
import org.specs2.runner.JUnitRunner
import org.specs2.mutable.{After, Specification}

@RunWith(classOf[JUnitRunner])
class IOSpec extends Specification {
  val toAbsolute: String => String = relative => {
    Paths.get(relative).toAbsolutePath.toString
  }

  "IO" should {
    "silently ignore attempts to write null text" in {
      IO.writeStringToFile(toAbsolute("should-not-be-created"), null).should(not(throwA[NullPointerException]))
    }
    "not create a new file when instructed to accept null text" in {
      IO.writeStringToFile(toAbsolute("should-not-be-created"), null)
      new File("should-not-be-created").exists() should beFalse
    }
    "create a new file if given non-empty text input" in new TearDown {
      IO.writeStringToFile(toAbsolute("should-be-created"), "non-empty text")
      new File("should-be-created").exists() should beTrue
    }
  }
}

trait TearDown extends After {
  override def after: Any = {
    Files.deleteIfExists(Paths.get("should-be-created"))
  }
}
