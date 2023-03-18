package acmicpc17144

import org.junit.jupiter.api.Test
import java.io.ByteArrayInputStream
import java.io.InputStreamReader

class Acmicpc17144JavaTest {
    @Test
    fun case1() {
        val input = "7 8 1\n" +
                "0 0 0 0 0 0 0 9\n" +
                "0 0 0 0 3 0 0 8\n" +
                "-1 0 5 0 0 0 22 0\n" +
                "-1 8 0 0 0 0 0 0\n" +
                "0 0 0 0 0 10 43 0\n" +
                "0 0 5 0 15 0 0 0\n" +
                "0 0 40 0 0 0 20 0"
        val expect = 188
        solveProblem(input, expect)
    }

    @Test
    fun case2() {
        val input = "7 8 2\n" +
                "0 0 0 0 0 0 0 9\n" +
                "0 0 0 0 3 0 0 8\n" +
                "-1 0 5 0 0 0 22 0\n" +
                "-1 8 0 0 0 0 0 0\n" +
                "0 0 0 0 0 10 43 0\n" +
                "0 0 5 0 15 0 0 0\n" +
                "0 0 40 0 0 0 20 0"
        val expect = 188
        solveProblem(input, expect)
    }

    @Test
    fun case3() {
        val input = "7 8 3\n" +
                "0 0 0 0 0 0 0 9\n" +
                "0 0 0 0 3 0 0 8\n" +
                "-1 0 5 0 0 0 22 0\n" +
                "-1 8 0 0 0 0 0 0\n" +
                "0 0 0 0 0 10 43 0\n" +
                "0 0 5 0 15 0 0 0\n" +
                "0 0 40 0 0 0 20 0"
        val expect = 186
        solveProblem(input, expect)
    }

    @Test
    fun case4() {
        val input = "7 8 4\n" +
                "0 0 0 0 0 0 0 9\n" +
                "0 0 0 0 3 0 0 8\n" +
                "-1 0 5 0 0 0 22 0\n" +
                "-1 8 0 0 0 0 0 0\n" +
                "0 0 0 0 0 10 43 0\n" +
                "0 0 5 0 15 0 0 0\n" +
                "0 0 40 0 0 0 20 0"
        val expect = 178
        solveProblem(input, expect)
    }

    @Test
    fun case5() {
        val input = "7 8 5\n" +
                "0 0 0 0 0 0 0 9\n" +
                "0 0 0 0 3 0 0 8\n" +
                "-1 0 5 0 0 0 22 0\n" +
                "-1 8 0 0 0 0 0 0\n" +
                "0 0 0 0 0 10 43 0\n" +
                "0 0 5 0 15 0 0 0\n" +
                "0 0 40 0 0 0 20 0"
        val expect = 172
        solveProblem(input, expect)
    }

    @Test
    fun case6() {
        val input = "7 8 20\n" +
                "0 0 0 0 0 0 0 9\n" +
                "0 0 0 0 3 0 0 8\n" +
                "-1 0 5 0 0 0 22 0\n" +
                "-1 8 0 0 0 0 0 0\n" +
                "0 0 0 0 0 10 43 0\n" +
                "0 0 5 0 15 0 0 0\n" +
                "0 0 40 0 0 0 20 0"
        val expect = 71
        solveProblem(input, expect)
    }

    @Test
    fun case7() {
        val input = "7 8 30\n" +
                "0 0 0 0 0 0 0 9\n" +
                "0 0 0 0 3 0 0 8\n" +
                "-1 0 5 0 0 0 22 0\n" +
                "-1 8 0 0 0 0 0 0\n" +
                "0 0 0 0 0 10 43 0\n" +
                "0 0 5 0 15 0 0 0\n" +
                "0 0 40 0 0 0 20 0"
        val expect = 52
        solveProblem(input, expect)
    }

    @Test
    fun case8() {
        val input = "7 8 50\n" +
                "0 0 0 0 0 0 0 9\n" +
                "0 0 0 0 3 0 0 8\n" +
                "-1 0 5 0 0 0 22 0\n" +
                "-1 8 0 0 0 0 0 0\n" +
                "0 0 0 0 0 10 43 0\n" +
                "0 0 5 0 15 0 0 0\n" +
                "0 0 40 0 0 0 20 0"
        val expect = 46
        solveProblem(input, expect)
    }

    private fun solveProblem(input: String, expect: Int) {
        assert(Acmicpc17144.solveProblem(InputStreamReader(ByteArrayInputStream(input.toByteArray()))) == expect)
    }
}