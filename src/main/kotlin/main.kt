const val VISA = "Visa"
const val MASTERCARD = "Mastercard"
const val MAESTRO = "Maestro"
const val MIR = "Mir"
const val VK = "VKPay"

fun main() {
    printCommission(transferSum = 100)
    printCommission(lastTransferSum = 1500_00, transferSum = 100_00)
    printCommission(MAESTRO, 50_000_00, 1_111_00)
    printCommission(MAESTRO, 750_000_00, 1_111_00)
    printCommission(MIR, 500_000_00, 1_500)
    printCommission(VK, 5_000_00, 100_570_00)
    printCommission(VISA, 50_000_00, 100_00)
    printCommission(VISA, 50_000_00, 28_900_00)
    printCommission(MASTERCARD, 50_000_00, 10_000_50)

}

fun calculateCommission(cardType: String = VK, lastTransferSum: Int = 0, transferSum: Int): Int {
    return when (cardType) {
        MASTERCARD, MAESTRO -> {
            return if (lastTransferSum < 75_000_00) 0 else transferSum * 6 / 1000 + 20_00
        }
        VISA, MIR -> {
            val percentCommission = transferSum * 75 / 10000
            return if (percentCommission < 35_00) 35_00 else percentCommission
        }
        else -> 0
    }
}

fun printCommission(cardType: String = VK, lastTransferSum: Int = 0, transferSum: Int) {
    val commission = calculateCommission(cardType, lastTransferSum, transferSum)
    println("${commission / 100} рублей ${commission % 100} копеек")
}