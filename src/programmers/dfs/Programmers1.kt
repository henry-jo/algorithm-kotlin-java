package programmers.dfs

class Programmers1 {

    val dfsResult = mutableListOf<Int>()

    fun solution(numbers: IntArray, target: Int): Int {

        dfs(0, numbers[0], numbers)
        dfs(0, -numbers[0], numbers)

        return dfsResult.filter { it == target }.size
    }

    private fun dfs(index: Int, sum: Int, numbers: IntArray) {
        if (index + 1 == numbers.size) {
            dfsResult.add(sum)
            return
        }

        dfs(
            index = index + 1,
            sum = sum + numbers[index + 1],
            numbers = numbers
        )
        dfs(
            index = index + 1,
            sum = sum - numbers[index + 1],
            numbers = numbers
        )
    }
}

fun main(args: Array<String>) {
    println(
        Programmers1().solution(intArrayOf(1, 1, 1, 1, 1), 3)
    )
}