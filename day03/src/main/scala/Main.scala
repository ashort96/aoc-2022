import scala.io.Source

object Main extends App {
  val filename = "input.txt"
  
  val lines: List[String] = Source.fromResource(filename)
    .getLines()
    .toList

  val part1 = lines
    .map { line =>
      val (left, right) = line.splitAt(line.length()/2)
      val intersection = left.toSet.intersect(right.toSet)
      intersection
        .map { char =>
          if ('a' <= char && char <= 'z') {
            char - 96
          }
          else {
            char - 38
          }
        }.head
    }.sum

    println(s"Part 1: $part1")

    val part2 = lines.grouped(3)
      .toList
      .map { groupOfLines =>
        groupOfLines match {
          case List(line1, line2, line3) => {
            line1.toSet
              .intersect(line2.toSet)
              .intersect(line3.toSet)
              .map { char => 
                if ('a' <= char && char <= 'z') {
                  char - 96
                }
                else {
                  char - 38
                }
              }.head
            }
          }
        }.sum

    println(s"Part2: $part2")
}