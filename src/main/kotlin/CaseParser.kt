import java.io.InputStream

class CaseParser {
    fun parse(inputStream: InputStream): List<Case> {
        val lines = inputStream.bufferedReader().readLines()
        val casesSize = lines.first().toInt()
        var caseOffset = 1
        return (0 until casesSize).map {
            val gridSizes = lines[caseOffset].split(" ")
            val startAndEndPoints = lines[caseOffset + 1].split(" ")
            val obstaclesSize = lines[caseOffset + 2].toInt()
            Case(gridWidth = gridSizes[0].toInt(),
                gridHeight = gridSizes[1].toInt(),
                start = Point(startAndEndPoints[0].toInt(), startAndEndPoints[1].toInt()),
                end = Point(startAndEndPoints[2].toInt(), startAndEndPoints[3].toInt()),
                obstacles = if (obstaclesSize == 0) {
                    emptyList()
                } else {
                    (0 until obstaclesSize).map {
                        val obstacle = lines[caseOffset + 3 + it].split(" ")
                        Obstacle(
                            x1 = obstacle[0].toInt(),
                            x2 = obstacle[1].toInt(),
                            y1 = obstacle[2].toInt(),
                            y2 = obstacle[3].toInt(),
                        )
                    }
                }
            ).also { caseOffset += 3 + obstaclesSize }
        }
    }
}