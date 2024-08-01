package com.example.testvsego

class D:S("e") {

}
fun main(){

    // Функция, которая принимает строку и возвращает её длину
    val stringLength: (String) -> Int = { it.length }

    // Функция, которая принимает список строк и функцию, и применяет эту функцию к каждой строке
    fun applyToEachString(strings: List<String>, operation: (String) -> Int): List<Int> {
        return strings.map(operation)
    }

    fun main() {
        val strings = listOf("Kotlin", "Java", "C++")
        val lengths = applyToEachString(strings, stringLength)
        println(lengths)  // Output: [6, 4, 3]
    }
}