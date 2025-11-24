
import kotlin.math.sqrt

fun gcd(a: Int, b: Int): Int {
    return if (b == 0) a else gcd(b, a % b)
}

fun generatePythagoreanTriplets(limit: Int): List<Triple<Int, Int, Int>> {
    val triplets = mutableListOf<Triple<Int, Int, Int>>()

    val maxM = sqrt(limit.toDouble()).toInt()

    for (m in 2..maxM) {
        for (n in 1 until m) {
            if ((m - n) % 2 == 1 && gcd(m, n) == 1) {
                val a = m * m - n * n
                val b = 2 * m * n
                val c = m * m + n * n

                if (c > limit) continue

                var k = 1
                while (k * c <= limit) {
                    val ka = k * a
                    val kb = k * b
                    val kc = k * c
                    val triple = listOf(ka, kb, kc).sorted()
                    triplets.add(Triple(triple[0], triple[1], triple[2]))
                    k++
                }
            }
        }
    }

    return triplets.distinct().sortedBy { it.third }
}

fun main() {   
    val limit = readLine()?.toIntOrNull() ?: return
    print("El máximo valor de la hipotenusa es  $limit.\n\n")

    val triplets = generatePythagoreanTriplets(limit)

    print("\nEl trío pitagórico (a, b, c) para  la hipotenusa,c ≤ $limit es:\n")
    for ((a, b, c) in triplets) {
        println("$a, $b, $c")
    }
}