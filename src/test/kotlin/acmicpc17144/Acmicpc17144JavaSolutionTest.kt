package acmicpc17144

import java.io.BufferedReader
import java.io.ByteArrayInputStream
import java.io.InputStreamReader
import java.util.*
import kotlin.test.Test

class Acmicpc17144JavaSolutionTest {
    @Test
    fun spreadTest1() {
        val input = "3 3 1\n" +
                "5 0 0\n" +
                "0 0 0\n" +
                "0 0 0"
        val expect = "3 3 1\n" +
                "3 1 0\n" +
                "1 0 0\n" +
                "0 0 0"
        spread(input, expect)
    }

    @Test
    fun spreadTest2() {
        val input = "3 3 1\n" +
                "0 0 0\n" +
                "0 46 0\n" +
                "0 0 0"
        val expect = "3 3 1\n" +
                "0 9 0\n" +
                "9 10 9\n" +
                "0 9 0"
        spread(input, expect)
    }

    @Test
    fun spreadTest3() {
        val input = "3 3 1\n" +
                "0 30 7\n" +
                "-1 10 0\n" +
                "-1 0 20"
        val expect = "3 3 1\n" +
                "6 15 11\n" +
                "-1 10 7\n" +
                "-1 6 12"
        spread(input, expect)
    }

    @Test
    fun spreadTest4() {
        val input = "7 8 1\n" +
                "0 0 0 0 0 0 0 9\n" +
                "0 0 0 0 3 0 0 8\n" +
                "-1 0 5 0 0 0 22 0\n" +
                "-1 8 0 0 0 0 0 0\n" +
                "0 0 0 0 0 10 43 0\n" +
                "0 0 5 0 15 0 0 0\n" +
                "0 0 40 0 0 0 20 0"
        val expect = "7 8 1\n" +
                "0 0 0 0 0 0 1 8\n" +
                "0 0 1 0 3 0 5 6\n" +
                "-1 2 1 1 0 4 6 5\n" +
                "-1 5 2 0 0 2 12 0\n" +
                "0 1 1 0 5 10 13 8\n" +
                "0 1 9 4 3 5 12 0\n" +
                "0 8 17 8 3 4 8 4"
        spread(input, expect)
    }

    @Test
    fun cleanTest1() {
        val input = "7 8 1\n" +
                "0 0 0 0 0 0 1 8\n" +
                "0 0 1 0 3 0 5 6\n" +
                "-1 2 1 1 0 4 6 5\n" +
                "-1 5 2 0 0 2 12 0\n" +
                "0 1 1 0 5 10 13 8\n" +
                "0 1 9 4 3 5 12 0\n" +
                "0 8 17 8 3 4 8 4"
        val expect = "7 8 1\n" +
                "0 0 0 0 0 1 8 6\n" +
                "0 0 1 0 3 0 5 5\n" +
                "-1 0 2 1 1 0 4 6\n" +
                "-1 0 5 2 0 0 2 12\n" +
                "0 1 1 0 5 10 13 0\n" +
                "0 1 9 4 3 5 12 8\n" +
                "8 17 8 3 4 8 4 0"
        clean(input, expect)
    }

    @Test
    fun cleanTest2() {
        val input = "4 3 1\n" +
                "6 15 11\n" +
                "-1 10 7\n" +
                "-1 6 12\n" +
                "9 10 11"
        val expect = "4 3 1\n" +
                "15 11 7\n" +
                "-1 0 10\n" +
                "-1 0 6\n" +
                "10 11 12"
        clean(input, expect)
    }

    private fun spread(input: String, expect: String) {
        val bufferedReader = getBufferedReader(input)
        val solution17144 = getSolution17144(bufferedReader)

        val source = stringToArray(input)
        val destination = stringToArray(expect)

        val spreaded = solution17144.spread(source)
        assert(spreaded.equal(destination))
    }

    private fun clean(input: String, expect: String) {
        val bufferedReader = getBufferedReader(input)
        val solution17144 = getSolution17144(bufferedReader)

        val source = stringToArray(input)
        val destination = stringToArray(expect)

        val clean = solution17144.clean(source)
        assert(clean.equal(destination))
    }

    private fun getBufferedReader(input: String): BufferedReader {
        return BufferedReader(InputStreamReader(ByteArrayInputStream(input.toByteArray())))
    }

    private fun getSolution17144(reader: BufferedReader): Solution17144 {
        return Acmicpc17144.convertInput(reader)
    }

    private fun stringToArray(input: String): Array<IntArray> {
        val bufferedReader = getBufferedReader(input)
        var stringTokenizer = StringTokenizer(bufferedReader.readLine())

        val height = stringTokenizer.nextToken().toInt()
        val width = stringTokenizer.nextToken().toInt()

        val array = arrayListOf<IntArray>()
        for (x in 0 until height) {
            array.add(IntArray(width))
            stringTokenizer = StringTokenizer(bufferedReader.readLine())
            for (y in 0 until width) {
                array[x][y] = stringTokenizer.nextToken().toInt()
            }
        }

        return array.toTypedArray()
    }

    private fun Array<IntArray>.equal(other: Array<IntArray>): Boolean {
        val height = this.size
        if (height != other.size) return false

        for (index in 0 until height) {
            val width = this[index].size
            if (width != other[index].size) return false
            for (index2 in 0 until width) {
                if (this[index][index2] != other[index][index2]) return false
            }
        }

        return true
    }
}