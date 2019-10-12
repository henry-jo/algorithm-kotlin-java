package impl

class BOJ_1212 {
    fun solve() {
        val octalNum = readLine()!!
        val binaryNum = StringBuilder()

        // 2진수로 변환했을 경우 맨 앞자리에 0이 올 순 없으므로 배열을 두개 생성해준다.
        val OCT_STR1 = arrayOf("0", "1", "10", "11", "100", "101", "110", "111")
        val OCT_STR2 = arrayOf("000", "001", "010", "011", "100", "101", "110", "111")

        binaryNum.append(OCT_STR1[octalNum[0] - '0'])

        for(i in 1 until octalNum.length) {
            binaryNum.append(OCT_STR2[octalNum[i] - '0'])
        }

        println(binaryNum.toString())
    }
}

fun main(args: Array<String>) {
    BOJ_1212().solve()
}