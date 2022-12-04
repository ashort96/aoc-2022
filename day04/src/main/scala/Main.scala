import scala.io.Source

object Main extends App {
  val filename = "input.txt"

  def findOverlap(lines: List[List[List[Int]]], callback: (Set[Int], Set[Int]) => Int) = {
    lines.map { line =>
      line match {
        case List(List(a, b), List(c, d)) =>
          val left = a.to(b).toSet
          val right = c.to(d).toSet
          callback(left, right)
        case List(_) | Nil => throw new RuntimeException("Unexpected case")
      }
    }.sum
  }
  
  val lines: List[List[List[Int]]] = Source.fromResource(filename)
    .getLines()
    .toList
    .map{ line => 
      line
      .split(',')
      .toList
      .map { element => 
        element
        .split('-')
        .map(_.toInt)
        .toList
      }
    }
  
  val part1 = findOverlap(lines, (left: Set[Int], right: Set[Int]) => {
    if (left.subsetOf(right) || right.subsetOf(left)) 1 else 0
  })

  println(s"Part 1: $part1")

  val part2 = findOverlap(lines, (left: Set[Int], right: Set[Int]) => {
    if (left.intersect(right).size > 0) 1 else 0
  })

  println(s"Part 2: $part2")
}