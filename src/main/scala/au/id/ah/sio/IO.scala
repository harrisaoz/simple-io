package au.id.ah.sio

object IO {
  def writeStringToFile(filename: FileName, text: String): Unit =
    FileOverwriter.apply(filename).writeText(text)
}
