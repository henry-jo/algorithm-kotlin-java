package mst

/**
 * MST(최소 비용 신장 트리)
 * 1) 최소 비용의 간선으로 구성됨
 * 2) 사이클을 포함하지 않음
 */
class BOJ_1197 {

    private var parent = intArrayOf()

    fun solve() {
        val (v, e) = readLine()!!.split(" ").map { it.toInt() }

        val edges = mutableListOf<Edge>()
        repeat(e) {
            val (x, y, cost) = readLine()!!.split(" ").map { it.toInt() }
            edges.add(Edge(x, y, cost))
        }

        // 우선 가중치 적은 순서대로 정렬
        edges.sortBy { it.cost }

        parent = IntArray(v + 1)
        // 부모노드 초기화 (자기 자신을 가르킴)
        for (i in 1..v) {
            parent[i] = i
        }

        var result = 0
        // 사이클을 피하기위해 find-union 알고리즘 사용
        edges.forEach { edge ->
            val rootX = findRoot(edge.x)
            val rootY = findRoot(edge.y)

            if (rootX != rootY) {
                parent[rootX] = rootY // 해당 집합(rootY)에 속하게 함
                result += edge.cost
            }
        }

        println(result)
    }

    // 자신이 속한 부모노드(집합번호)를 찾는다.
    private fun findRoot(x: Int): Int {
        if (x == parent[x]) {
            return x
        }

        return findRoot(parent[x])
    }
}

private data class Edge(
    val x: Int,
    val y: Int,
    val cost: Int
)

fun main(args: Array<String>) {
    BOJ_1197().solve()
}