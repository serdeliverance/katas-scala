package io.github.ctci

// key: String, value: String
class HashTable {

  val capacity = 8

  val elements: Array[List[String]] = ???

  def hash(key: String): Long = ???

  def get(key: String): Option[String] = {
    val position = hash(key) % capacity

    val elementsOnPosition = elements(position.toInt)

    elementsOnPosition match {
      case Nil  => None
      case list => list.find(elem => elem == key)
    }
  }

}
