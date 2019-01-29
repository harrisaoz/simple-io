package au.id.ah.sio

import java.io.File
import java.nio.file.{Files, Paths}

import scala.io.{Codec, Source}

object IO {
  def readFileToString(folderName: String, filename: String): String =
    Source.fromFile(new File(folderName, filename))(Codec.UTF8).mkString

  def readFileToString(filename: String): String =
    Source.fromFile(filename)(Codec.UTF8).mkString

  def readFileAsBytes(filename: FileName): Array[Byte] =
    Files.readAllBytes(Paths.get(filename))

  def writeStringToFile(filename: FileName, text: String): Unit =
    FileOverwriter.apply(filename).writeText(text)

  def delete(filename: FileName): Unit = {
    new File(filename).delete()
  }

  def textWriter: FileName => String => Unit = filename => text =>
    FileOverwriter.apply(filename).writeText(text)
}
