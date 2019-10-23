package mst

class BOJ_1922 {

    private var parent = intArrayOf()

    fun solve() {
        val n = readLine()!!.toInt()
        val m = readLine()!!.toInt()

        val edges = mutableListOf<Edge>()

        repeat(m) {
            val (x, y, cost) = readLine()!!.split(" ").map { it.toInt() }
            edges.add(Edge(x, y, cost))
        }

        parent = IntArray(n + 1)
        // 부모노드 초기화 (자기 자신을 가르킴)
        for (i in 1..n) {
            parent[i] = i
        }

        edges.sortBy { it.cost }

        var result = 0
        edges.forEach { edge ->
            val x = findRoot(edge.x)
            val y = findRoot(edge.y)

            if (x != y) {
                parent[x] = y
                result += edge.cost
            }
        }

        println(result)
    }

    private fun findRoot(x: Int): Int {
        if(parent[x] == x) {
            return x
        }

        return findRoot(parent[x])
    }

    private data class Edge(
        val x: Int,
        val y: Int,
        val cost: Int
    )
}

fun main(args: Array<String>) {
    BOJ_1922().solve()
}