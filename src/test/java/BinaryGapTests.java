import dev.mati.tasks.BinaryGap;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BinaryGapTests {
    @Test
    void solution2ShouldReturnTheBiggestBinaryGap() {
        int inputVal1 = 1041;
        int inputVal2 = 15;
        int inputVal3 = 32;
        int inputVal4 = 561892;
        int inputVal5 = 6291457;
        int inputVal6 = 328;
        int inputVal7 = 805306373;

        int actualVal1 = BinaryGap.solution2(inputVal1);
        int actualVal2 = BinaryGap.solution2(inputVal2);
        int actualVal3 = BinaryGap.solution2(inputVal3);
        int actualVal4 = BinaryGap.solution2(inputVal4);
        int actualVal5 = BinaryGap.solution2(inputVal5);
        int actualVal6 = BinaryGap.solution2(inputVal6);
        int actualVal7 = BinaryGap.solution2(inputVal7);

        Assertions.assertEquals(5, actualVal1);
        Assertions.assertEquals(0, actualVal2);
        Assertions.assertEquals(0, actualVal3);
        Assertions.assertEquals(3, actualVal4);
        Assertions.assertEquals(20, actualVal5);
        Assertions.assertEquals(2, actualVal6);
        Assertions.assertEquals(25, actualVal7);
    }
}
