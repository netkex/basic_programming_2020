import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class `sort test` {
    @Test
    fun `check one element in list`() {
        val lst = listOf(1)
        val sortedLst = lst.sorted()
        assertEquals(sortedLst, qsort(lst))
    }

    @Test
    fun `check empty`() {
        val lst = listOf<Int>()
        val sortedLst = lst.sorted()
        assertEquals(sortedLst, qsort(lst))
    }

    @Test
    fun `check random list` () {
        val lst1 = listOf(1, -1, 3)
        val lst2 = listOf(-2, 1, 4, 5, -1, 32)
        val lst3 = listOf(3, 4, 5, 3, 3, 2)
        val sortedLst1 = lst1.sorted()
        val sortedLst2 = lst2.sorted()
        val sortedLst3 = lst3.sorted()
        assertEquals(sortedLst1, qsort(lst1))
        assertEquals(sortedLst2, qsort(lst2))
        assertEquals(sortedLst3, qsort(lst3))
    }
}

internal class `reverse test` {
    @Test
    fun `check one element`() {
        val lst = listOf<Int>(100)
        val reversedLst = lst.reversed()
        assertEquals(reversedLst, reverse(lst))
    }

    @Test
    fun `check empty list`() {
        val lst = listOf<Int>()
        val reversedLst = lst.reversed()
        assertEquals(reversedLst, reverse(lst))
    }

    @Test
    fun `check random list`() {
        val lst1 = listOf(1, -1, 3)
        val lst2 = listOf(-2, 1, 4, 5, -1, 32)
        val lst3 = listOf(3, 4, 5, 3, 3, 2)
        val sortedLst1 = lst1.reversed()
        val sortedLst2 = lst2.reversed()
        val sortedLst3 = lst3.reversed()
        assertEquals(sortedLst1, reverse(lst1))
        assertEquals(sortedLst2, reverse(lst2))
        assertEquals(sortedLst3, reverse(lst3))
    }
}

internal class `sumq test` {
    @Test
    fun `check zero`() {
        assertEquals(0, sumq(0))
    }

    @Test
    fun `check little n`() {
        assertEquals(1, sumq(1))
        assertEquals(5, sumq(2))
        assertEquals(55, sumq(5))
    }

    @Test
    fun `check random big n`() {
        assertEquals(1240, sumq(15))
        assertEquals(338350, sumq(100))
        assertEquals(44870400, sumq(512))
    }
}

internal class `check lengths` {
    @Test
    fun `check empty list`() {
        assertEquals(listOf<Int>(), lengths(listOf<String>()))
    }

    @Test
    fun `check empty string`() {
        assertEquals(listOf(0), lengths(listOf("")))
    }

    @Test
    fun `check one string`() {
        assertEquals(listOf(3), lengths(listOf("abc")))
        assertEquals(listOf(5), lengths(listOf("acnas")))
    }

    @Test
    fun `check random`() {
        assertEquals(listOf(3, 2, 0), lengths(listOf("abc", "ke", "")))
        assertEquals(listOf(10, 3, 2), lengths(listOf("aaaaaaaaaa", "mem", "ob")))
        assertEquals(listOf(1, 2, 3, 4, 5), lengths(listOf("a", "bb", "ccc", "dddd", "eeeee")))
    }
}

internal class `check mapAccumL` {
    @Test
    fun `check simple cases`() {
        assertEquals(Pair(5, listOf(45, 30, 15)),
            listOf(9, 6, 3).mapAccumL(5) {accum, elem -> accum to elem * accum})
        assertEquals(Pair(8, listOf(2, 4, 8)),
            listOf(2, 4, 8).mapAccumL(5) {accum, elem -> elem to elem})
        assertEquals(Pair(5, listOf(5, 5, 5)),
            listOf(2, 4, 8).mapAccumL(5) {accum, elem -> accum to accum})
    }

    @Test
    fun `check complex cases`() {
        assertEquals(Pair(19, listOf(10, 28, 88)),
            listOf(2, 4, 8).mapAccumL(5) {accum, elem -> accum + elem to accum * elem})
        assertEquals(Pair(6, listOf(1, 2, 3)),
            listOf("1", "22", "333").mapAccumL(0) {accum, elem -> accum + elem.length to elem.length})
    }
}

internal class `check filter2` {
    @Test
    fun `check list with one element`() {
        assertEquals(listOf(1),  listOf(1).filter2 {it > 0})
        assertEquals(listOf<Int>(), listOf(5).filter2 { it != 5 })
    }

    @Test
    fun `simple cases`() {
        assertEquals(listOf(1, 2, 3), (1..10).toList().filter2 { it <= 3 })
        assertEquals(listOf(2, 4, 6, 8, 10), (1..10).toList().filter2 { it % 2 == 0 })
    }

    @Test
    fun `check complex cases`() {
        assertEquals(listOf("aba", "c", "kek", "abacaba"),
            listOf("aba", "skmas", "c", "kek", "nba", "ball", "abacaba").toList().filter2 { it == it.reversed() })
        assertEquals(('a'..'z').toList(), ('A'..'z').toList().filter2 { it.isLowerCase() })
    }
}

internal class `check filter3` {
    @Test
    fun `check list with one element`() {
        assertEquals(listOf(1),  listOf(1).filter3 {it > 0})
        assertEquals(listOf<Int>(), listOf(5).filter3 { it != 5 })
    }

    @Test
    fun `simple cases`() {
        assertEquals(listOf(1, 2, 3), (1..10).toList().filter3 { it <= 3 })
        assertEquals(listOf(2, 4, 6, 8, 10), (1..10).toList().filter3 { it % 2 == 0 })
    }

    @Test
    fun `check complex cases`() {
        assertEquals(listOf("aba", "c", "kek", "abacaba"),
            listOf("aba", "skmas", "c", "kek", "nba", "ball", "abacaba").toList().filter3 { it == it.reversed() })
        assertEquals(('a'..'z').toList(), ('A'..'z').toList().filter3 { it.isLowerCase() })
    }
}