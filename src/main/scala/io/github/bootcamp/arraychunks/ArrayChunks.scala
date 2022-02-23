package io.github.bootcamp.arraychunks

import scala.annotation.tailrec


object ArrayChunks {

  def arrayChunks(elements: List[Int], chunkSize: Int): List[List[Int]] = {
    @tailrec
    def chunkRecursively(remaining: List[Int], chunks: List[List[Int]]): List[List[Int]] = {
      if (remaining.isEmpty) chunks.reverse
      else {
        val (currentChunk, newRemaining) = remaining.splitAt(chunkSize)
        chunkRecursively(newRemaining, currentChunk :: chunks)
      }
    }
    chunkRecursively(elements, List.empty)
  }
}
