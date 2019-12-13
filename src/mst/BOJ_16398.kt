package mst

class BOJ_16398 {
    fun solve() {
        val n = readLine()!!.toInt()
        val edges = mutableListOf<Edge>()

        for (i in 0 until n) {
            val inputCost = readLine()!!.split(" ").map { it.toInt() }

            for (j in (i + 1) until n) {
                edges.add(Edge(i, j, inputCost[j]))
            }
        }

        edges.sortBy { it.cost }

        val parent = IntArray(n) { 0 }
        val setSize = IntArray(n) { 0 }
        for (i in 0 until parent.size) {
            parent[i] = i
            setSize[i] = 0
        }

        var ans = 0L
        edges.forEach { edge ->
            val rootX = findRoot(parent, edge.x)
            val rootY = findRoot(parent, edge.y)

            if (rootX != rootY) {

                if (setSize[rootX] > setSize[rootY]) {

                }
                ans += edge.cost
                parent[rootX] = rootY
            }
        }

        println(ans)
    }

    private data class Edge(
        val x: Int,
        val y: Int,
        val cost: Int
    )

    private fun findRoot(parent: IntArray, x: Int): Int {
        if (x == parent[x]) {
            return x
        }

        return findRoot(parent, parent[x])
    }
}

fun main(args: Array<String>) {
    BOJ_16398().solve()
}