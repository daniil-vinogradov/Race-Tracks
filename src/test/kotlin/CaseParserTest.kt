import kotlin.test.Test
import kotlin.test.assertEquals

internal class CaseParserTest {

    private val caseParser = CaseParser()

    @Test
    fun testParse() {
        val parsed = caseParser.parse(object {}.javaClass.getResourceAsStream("test-input.txt")!!)
        assertEquals(
            expected = listOf(
                Case(
                    gridWidth = 0,
                    gridHeight = 0,
                    start = Point(0, 0),
                    end = Point(0, 0),
                    obstacles = emptyList()
                ),
                Case(
                    gridWidth = 10,
                    gridHeight = 10,
                    start = Point(1, 0),
                    end = Point(1, 0),
                    obstacles = listOf(Obstacle(1, 0, 1, 0))
                ),
                Case(
                    gridWidth = 20,
                    gridHeight = 20,
                    start = Point(2, 0),
                    end = Point(2, 0),
                    obstacles = listOf(
                        Obstacle(1, 0, 1, 0),
                        Obstacle(2, 0, 2, 0)
                    )
                ),
                Case(
                    gridWidth = 30,
                    gridHeight = 30,
                    start = Point(3, 0),
                    end = Point(3, 0),
                    obstacles = listOf(
                        Obstacle(1, 0, 1, 0),
                        Obstacle(2, 0, 2, 0),
                        Obstacle(3, 0, 3, 0)
                    )
                ),
                Case(
                    gridWidth = 40,
                    gridHeight = 40,
                    start = Point(4, 0),
                    end = Point(4, 0),
                    obstacles = listOf(
                        Obstacle(1, 0, 1, 0),
                        Obstacle(2, 0, 2, 0),
                        Obstacle(3, 0, 3, 0),
                        Obstacle(4, 0, 4, 0)
                    )
                ),
                Case(
                    gridWidth = 50,
                    gridHeight = 50,
                    start = Point(5, 0),
                    end = Point(5, 0),
                    obstacles = listOf(
                        Obstacle(1, 0, 1, 0),
                        Obstacle(2, 0, 2, 0),
                        Obstacle(3, 0, 3, 0),
                        Obstacle(4, 0, 4, 0),
                        Obstacle(5, 0, 5, 0)
                    )
                )
            ),
            actual = parsed
        )
    }
}