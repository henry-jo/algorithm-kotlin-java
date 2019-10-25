package greedy

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

class BOJ_2875 {
    fun solve() {
        val br = BufferedReader(InputStreamReader(System.`in`))
        val st = StringTokenizer(br.readLine(), " ")

        var n = st.nextToken().toInt()
        var m = st.nextToken().toInt()
        var k = st.nextToken().toInt()

        // k를 하나씩 빼가며 그때마다 최선의 선택을 한다.
        // 여자를 기준으로 팀을 이룰 수 있는 수는 n / 2 이고 남자를 기준으로 팀을 이룰 수 있는 수는 m이다.
        // 따라서 n/2이 m보다 크면 여자를 빼준다.
        // 같을 경우에도 여자를 줄이는 것이 경우의 수를 높일 수 있기 때문에 여자를 빼준다.
        while (k > 0) {
            if (n / 2 >= m) {
                n--
            } else {
                m--
            }

            k--
        }

        // 남은 인원을 가지고 만들 수 있는 팀 수를 계산하여 출력
        val result = if (n / 2 > m) m else n / 2

        println(result)
    }
}

fun main(args: Array<String>) {
    BOJ_2875().solve()
}