package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Set;
import org.junit.jupiter.api.Test;

class RandomNumberTest {

    @Test
    public void 로또번호_생성_검증() {
        List<Integer> testValues = RandomNumber.createLottoNumbers();
        assertThat(testValues.size()).isEqualTo(Set.copyOf(testValues).size());
    }
}