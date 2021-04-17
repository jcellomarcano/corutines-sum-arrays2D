import kotlinx.coroutines.*
fun main(args: Array<String>) {

    val even: IntArray = intArrayOf(2, 4, 6)
    val odd: IntArray = intArrayOf(1, 3, 5)

    val oddRules = arrayOf(odd,even, odd)

    val evenRules = arrayOf(even, odd, even)

    val sum = Array(oddRules.size){IntArray(odd.size)}
    runBlocking{
        for (i in oddRules.indices) {
            calculateRow(i, oddRules, evenRules, sum)
        }
    }
    printMatrix(sum)

}


fun calculateRow(i: Int, arg1: Array<IntArray>, arg2: Array<IntArray>, sum:Array<IntArray>){
    GlobalScope.launch {
        for (j in arg1[i].indices){
            println("Sum of $i row & $j col ")
            sum[i][j] = arg1[i][j] + arg2[i][j]
        }
    }
}

fun printMatrix(sum: Array<IntArray>){
    println("Sum of two matrices is: ")
    for (row in sum) {
        for (column in row) {
            print("$column    ")
        }
        println()
    }
}