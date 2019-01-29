package au.id.ah

package object sio {
  type FolderName = String
  type FileName = String
  type WritableData[T] = T => Array[Byte]
  type ByteWriterFactory = (FolderName, FileName) => Array[Byte] => Unit
}
