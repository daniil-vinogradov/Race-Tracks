data class Case(
    val gridWidth: Int,
    val gridHeight: Int,
    val start: Point,
    val end: Point,
    val obstacles: List<Obstacle>
)

data class Obstacle(
    val x1: Int,
    val x2: Int,
    val y1: Int,
    val y2: Int
)

data class Point(val x: Int, val y: Int)
data class PointWithSpeed(val point: Point, val speed: Point)

data class BfsStep(
    val pointWithSpeed: PointWithSpeed,
    val hopsCount: Int
) {
    val point = pointWithSpeed.point
    val speed = pointWithSpeed.speed
}

class NoSolution : RuntimeException()
