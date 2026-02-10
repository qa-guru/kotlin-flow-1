package Lesson_6

import org.junit.jupiter.api.Test

class EnumTest {

    @Test
    fun testEnum() {
        PaymentCardType.entries
        PaymentCardType.CLOUD_PAYMENT_FAILED
    }
}


enum class PaymentCardType(val cardType: String, val provider: String = "", val isSuccessful: Boolean = false) {
    CLOUD_PAYMENT_SUCCESS("cloudpayment"),
    CLOUD_PAYMENT_FAILED("cloudpayment"),
    SBERBANK_SUCCESS("sber", isSuccessful = true),
    PAYGINE_SUCCESS("paygine"),
    TEST("test", provider = "test", isSuccessful = true);

    fun getIsSuccessfulEntry(): PaymentCardType? {
        return entries.find { it.isSuccessful }
    }
}

//public enum PaymentCardType {
//    CLOUD_PAYMENT_SUCCESS("cloudpayment"),
//    CLOUD_PAYMENT_FAILED("cloudpayment"),
//    SBERBANK_SUCCESS("sber"),
//    PAYGINE_SUCCESS("paygine");
//
//    private final String cardType;
//
//    PaymentCardType(String cardType) {
//        this.cardType = cardType;
//    }
//}