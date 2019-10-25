package dp

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

class BOJ_11053 {
    fun solve() {
        val br = BufferedReader(InputStreamReader(System.`in`))
        val N = Integer.parseInt(br.readLine())

        val list = IntArray(N + 1)
        val dp = IntArray(N + 1)

        val st = StringTokenizer(br.readLine(), " ")
        for (i in 1..N) {
            list[i] = Integer.parseInt(st.nextToken())
        }

        // 배열 탐색
        for (i in 1..N) {

            var prevLen = 0
            // i인덱스의 값보다 작은 값을 탐색
            for (j in 1 until i) {
                if (list[i] > list[j]) {
                    // 현재 i인덱스보다 작은 값들을 탐색하고 그 중에서 가장 긴 배열의 길이를 가지고 있는
                    // 배열의 길이를 저장한다.
                    prevLen = Math.max(prevLen, dp[j])
                }
            }

            // i인덱스 값이 가장 긴 배열에 포함되므로 + 1
            dp[i] = prevLen + 1
        }
        // 배열의 길이가 저장된 리스트 dp
        // 가장 긴 배열의 길이를 구하기 위해 sort
        Arrays.sort(dp)

        println(dp[N])
    }
}

fun main(args: Array<String>) {
    BOJ_11053().solve()
}