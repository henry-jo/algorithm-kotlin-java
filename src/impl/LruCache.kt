package impl

import java.util.*

class LruCache {

    fun lruCaching(cacheSize: Int, dataList: List<Int>) {
        val q = LinkedList<Int>()

        dataList.forEach { data ->
            // HIT
            if (q.contains(data)) {
                q.remove(data)
                q.add(data)
            } else { // MISS
                if (q.size < cacheSize) {
                    q.add(data)
                } else {
                    q.poll()
                    q.add(data)
                }
            }
        }
    }
}