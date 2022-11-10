fun main() {
    val parser = CaseParser()
    val cases = parser.parse(object {}.javaClass.getResourceAsStream("input.txt")!!)
    val results = cases.asSequence()
        .map { Bfs(it).find() }
        .map {
            if (it.isSuccess) "Optimal solution takes ${it.getOrThrow()} hops." else "No solution."
        }
    println(results.joinToString("\n"))
}