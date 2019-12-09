package au.id.ah.sio.wrapper

object IO {
  import au.id.ah.sio.FileOverwriter

  def writeStringToFile(filename: FileName, text: String): Unit =
    FileOverwriter.apply(filename).writeText(text)
}
