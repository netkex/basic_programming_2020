@file: JvmName("main")

fun <T : Comparable<T>> qsort(list: List<T>): List<T> {
    if(list.size <= 1) return list
    val op = list[list.indices.random()]
    return qsort(list.filter{it < op}) + list.filter{it == op} + qsort(list.filter{it > op})
}

fun <T> reverse(lst: List<T>): List<T> {
    return lst.foldRight(listOf<T>()) {elem, ans -> ans + listOf(elem)}
}

//fun <T> List<T>.reverse2():List<T> {
//    return this.foldRight(listOf<T>()) {elem, ans -> ans + listOf(elem)}
//}

fun <T> List<T>.filter2(
    predicate: (T) -> Boolean
):List<T> {
    return this.fold(listOf<T>()) {result, elem -> if(predicate(elem)) result + listOf(elem) else result}
}

fun <T> List<T>.filter3(
    predicate: (T) -> Boolean
):List<T> {
    return this.foldRight(listOf<T>()) {elem, result -> if(predicate(elem)) result + listOf(elem) else result}
}

fun lengths(list: List<String>): List<Int> {
    return list.map { it.length }
}

fun sumq(n: Int): Int {
    require(n >= 0) {"n must be non-negative, was $n"}
    return (1..n).fold(0) {result, elem -> result + elem * elem}
}

fun <T, R, C> List<T>.mapAccumL(
    initial: R,
    combine: (acc: R, nextElement: T) -> Pair<R, C>
): Pair<R, List<C>> {
    var accumulator = initial
    val ans = mutableListOf<C>()
    for (element: T in this) {
        val (newAccumulator, newElement) = combine(accumulator, element)
        ans.add(newElement)
        accumulator = newAccumulator
    }
    return Pair(accumulator, ans)
}

fun main() {
//    val lines = readLine()!!.split(' ').toList().map {it.toInt()}
    val a = listOf<Int>(1, 3, 2, 2, 2, 4, -1)
    println(sumq(512))
    println(a)
    println(qsort(a))
    println(reverse(a))
    println(a.filter2 { it > 2 })
    println(a.filter3 { it >= 2 })
    println(lengths(listOf("abc", "", "d", "lolkek")))
    println(sumq(5))
    println(listOf("2", "4", "1acsdc").mapAccumL(5) {accum, elem -> accum to elem.length * accum})
}