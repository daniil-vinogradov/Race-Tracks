import java.util.*
import kotlin.math.absoluteValue

class Bfs(private val data: Case) {

    private val visitedPoints = HashSet<PointWithSpeed>()
    private val stepsToCompute = LinkedList<BfsStep>().apply {
        add(BfsStep(PointWithSpeed(point = data.start, speed = Point(x = 0, y = 0)), hopsCount = 0))
    }

    fun find(): Result<Int> {
        while (stepsToCompute.isNotEmpty()) {
            val step = stepsToCompute.removeFirst()
            if (step.point == data.end) return Result.success(step.hopsCount)
            stepsToCompute.addAll(step.calculateNextSteps())
        }
        return Result.failure(NoSolution())
    }

    private fun BfsStep.calculateNextSteps(): List<BfsStep> {
        val steps = mutableListOf<BfsStep>()
        for (i in -1..1) {
            for (j in -1..1) {
                val nextSpeed = Point(x = speed.x + i, y = speed.y + j)
                val nextPoint = Point(x = point.x + nextSpeed.x, y = point.y + nextSpeed.y)
                val nextPointWithSpeed = PointWithSpeed(nextPoint, nextSpeed)
                if (nextSpeed.x.absoluteValue > MAX_SPEED || nextSpeed.y.absoluteValue > MAX_SPEED
                    || nextPoint.isObstacle() || nextPoint.isOutOfGrid()
                    || visitedPoints.contains(nextPointWithSpeed)
                ) continue
                visitedPoints.add(nextPointWithSpeed)
                steps.add(BfsStep(nextPointWithSpeed, hopsCount = hopsCount + 1))
            }
        }
        return steps
    }

    private fun Point.isObstacle() = data.obstacles.any { obstacle ->
        x >= obstacle.x1 && x <= obstacle.x2 && y >= obstacle.y1 && y <= obstacle.y2
    }

    private fun Point.isOutOfGrid() = x < 0 || x >= data.gridWidth || y < 0 || y >= data.gridHeight

    companion object {
        private const val MAX_SPEED = 3
    }
}