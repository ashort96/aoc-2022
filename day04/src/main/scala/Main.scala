import scala.io.Source

object Main extends App {
  val filename = "input.txt"

  def findOverlap(lines: List[List[List[String]]], callback: (Set[Int], Set[Int]) => Int) = {
    lines.map { line =>
      line match {
        case List(List(a, b), List(c, d)) =>
          val left = a.toInt.to(b.toInt).toSet
          val right = c.toInt.to(d.toInt).toSet
          callback(left, right)
      }
    }.sum
  }
  
  val lines = Source.fromResource(filename)
    .getLines()
    .toList
    .map(line => line.split(',').toList.map(element => element.split('-').toList))
  
  val part1 = findOverlap(lines, (left: Set[Int], right: Set[Int]) => {
    if (left.subsetOf(right) || right.subsetOf(left)) 1 else 0
  })

  println(s"Part 1: $part1")

  val part2 = findOverlap(lines, (left: Set[Int], right: Set[Int]) => {
    if (left.intersect(right).size > 0) 1 else 0
  })

  println(s"Part 1: $part2")
}