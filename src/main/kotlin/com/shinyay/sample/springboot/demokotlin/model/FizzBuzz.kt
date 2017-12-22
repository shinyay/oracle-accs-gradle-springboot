package com.shinyay.sample.springboot.demokotlin.model

fun fizzBuzzFor(n: Int): String {
    val sb = StringBuilder()
    for (i in 1..n) {
        if (i % 15 == 0) {
            sb.append("FizzBuzz\n")
        } else if (i % 3 == 0) {
            sb.append("Fizz\n")
        } else if (i % 5 == 0) {
            sb.append("Buzz\n")
        } else {
            sb.append("$i\n")
        }
    }
    return sb.toString()
}

fun fizzBuzzWhen(n: Int): String {
    val sb = StringBuilder()
    for (i in 1..n) {
        when {
            i % 15 == 0 -> sb.append("FizzBuzz\n")
            i % 3 == 0 -> sb.append("Fizz\n")
            i % 5 == 0 -> sb.append("Buzz\n")
            else -> sb.append("$i\n")
        }
    }
    return sb.toString()
}

fun fizzBuzzApply(n: Int) = StringBuilder().apply {
    for (i in 1..n) {
        when {
            i % 15 == 0 -> append("FizzBuzz\n")
            i % 3 == 0 -> append("Fizz\n")
            i % 5 == 0 -> append("Buzz\n")
            else -> append("$i\n")
        }
    }
}

fun fizzBuzzMapZip(n: Int): String {
    val numbers = generateSequence(1) { it + 1 }.map { it.toString() }
    val fizz = generateSequence(1) { it + 1 }.map { if (it % 3 == 0) "Fizz" else "" }
    val buzz = generateSequence(1) { it + 1 }.map { if (it % 5 == 0) "Buzz" else "" }
    val fizzBuzz = generateSequence(1) { it + 1 }.map { if (it % 15 == 0) "FizzBuzz" else "" }
    val max = { a: String, b: String -> if (a > b) a else b }
    return numbers
            .zip(fizz, max)
            .zip(buzz, max)
            .zip(fizzBuzz, max)
            .take(n)
            .joinToString("\n")
}

fun fizzBuzzLambda(n: Int): String {
    val fizz = { i: Int -> if (i % 3 == 0) "Fizz" else "" }
    val buzz = { i: Int -> if (i % 5 == 0) "Buzz" else "" }
    val number = { i: Int -> if (i % 3 != 0 && i % 5 != 0) i else "" }
    return generateSequence(1) { it + 1 }.map {fizz(it) + buzz(it) + number(it)}.take(n).joinToString("\n")
}