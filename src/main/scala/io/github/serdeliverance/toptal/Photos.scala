package io.github.serdeliverance.toptal

import java.text.SimpleDateFormat
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

object Photos {

  case class Photo(name: String, city: String, createdAt: LocalDateTime)

  def organizePhotos(photoStrList: List[String]) = {
    val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")

    photoStrList
      .map(row => row.split(",").map(_.trim))
      .map(pieces => Photo(pieces(0), pieces(1), LocalDateTime.parse(s"${pieces(2)}", formatter)))
      .groupBy(_.city)
      .toList
      .map(entry => organizeByCity(entry._1, entry._2))
  }

  def organizeByCity(city: String, photos: List[Photo]): List[String] = {
    val size   = photos.size
    val digits = size.toString.length

    photos
      .sortBy(_.createdAt)
      .zipWithIndex
      .map {
        case (photo: Photo, index: Int) => s"$city${fillWithZeros(index + 1, digits)}-${photo.name}"
      }
  }

  def fillWithZeros(number: Int, zeros: Int): String = {
    val numberAsString = number.toString
    val currentDigits  = number.toString.length
    if (currentDigits == zeros) numberAsString
    else {
      val fillDigits = zeros - currentDigits
      (1 to fillDigits).map(_ => '0').mkString.concat(numberAsString)
    }
  }

  // TODO remove after adding tests
  def main(args: Array[String]): Unit = {

    // TODO add full data set for statement
    val photoList = List(
      "photo.jpg, Warsaw, 2013-09-05 14:08:15",
      "john.png, London, 2015-06-20 15:13:22"
    )

    val organizedPhotos = organizePhotos(photoList)

    println(organizedPhotos)
  }
}
