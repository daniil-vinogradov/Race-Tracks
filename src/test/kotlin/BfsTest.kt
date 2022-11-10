import kotlin.test.Test
import kotlin.test.assertEquals

internal class BfsTest {

    @Test
    fun `test common case`() {
        val bfs = Bfs(
            Case(
                gridWidth = 5,
                gridHeight = 5,
                start = Point(0, 0),
                end = Point(4, 4),
                obstacles = emptyList()
            )
        )
        val result = bfs.find()
        assertEquals(expected = 3, actual = result.getOrThrow())
    }

    @Test
    fun `test case with grid size 1`() {
        val bfs = Bfs(
            Case(
                gridWidth = 1,
                gridHeight = 1,
                start = Point(0, 0),
                end = Point(0, 0),
                obstacles = emptyList()
            )
        )
        val result = bfs.find()
        assertEquals(expected = 0, actual = result.getOrThrow())
    }

    @Test
    fun `test case with grid size 2`() {
        val bfs = Bfs(
            Case(
                gridWidth = 2,
                gridHeight = 2,
                start = Point(0, 0),
                end = Point(1, 1),
                obstacles = emptyList()
            )
        )
        val result = bfs.find()
        assertEquals(expected = 1, actual = result.getOrThrow())
    }

    @Test
    fun `test case with obstacles`() {
        val bfs = Bfs(
            Case(
                gridWidth = 5,
                gridHeight = 5,
                start = Point(4, 0),
                end = Point(4, 4),
                obstacles = listOf(Obstacle(1, 4, 2, 3))
            )
        )
        val result = bfs.find()
        assertEquals(expected = 7, actual = result.getOrThrow())
    }

    @Test
    fun `test case with no solution`() {
        val bfs = Bfs(
            Case(
                gridWidth = 3,
                gridHeight = 3,
                start = Point(0, 0),
                end = Point(2, 2),
                obstacles = listOf(Obstacle(1, 1, 0, 2), Obstacle(0, 2, 1, 1))
            )
        )
        val result = bfs.find()
        assertEquals(expected = true, actual = result.isFailure)
    }
}