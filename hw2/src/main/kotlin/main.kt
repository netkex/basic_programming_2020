@file: JvmName("main")

fun fibonacci(num: Int): Int {
    val fibNumbers = MutableList(num + 1) {1}
    for (i in 3..num) {
        fibNumbers[i] = fibNumbers[i - 1] + fibNumbers[i - 2]
    }
    return fibNumbers[num]
}


fun main(args: Array<String>) {
    if(args.isEmpty()) {
        println("sorry, there aren't any arguments")
    }
    for (input in args) {
        if (input.toIntOrNull() == null) {
            println("$input isn't a number")
            continue
        }
        if(input.toInt() <= 0) {
            println("$input isn't a positive number")
            continue
        }
        val num = input.toInt()
        println("The $num fibonacci number is ${fibonacci(num)}")
    }
}