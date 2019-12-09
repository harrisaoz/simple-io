package au.id.ah.sio

package object wrapper {
  type FolderName = String
  type FileName = String
  type WritableData[T] = T => Array[Byte]
  type ByteWriterFactory = (FolderName, FileName) => Array[Byte] => Unit
}
