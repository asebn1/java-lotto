package lotto.domain.lotto;

import java.util.Collections;
import java.util.List;
import java.util.Set;
import lotto.exception.InvalidException;

public class Lotto {
    private static final int LOTTO_SIZE = 6;

    private final List<Integer> lottoNumbers;

    public Lotto(final List<Integer> lottoNumbers) {
        checkNumbers(lottoNumbers);
        this.lottoNumbers = lottoNumbers;
        Collections.sort(lottoNumbers);
    }

    private void checkNumbers(List<Integer> lottoNumbers) {
        checkNull(lottoNumbers);
        checkDuplicateNumber(lottoNumbers);
    }

    private void checkNull(List<Integer> lottoNumbers) {
        if (lottoNumbers == null) {
            throw new IllegalArgumentException(InvalidException.ERROR_NULL_BLANK);
        }
    }

    private static void checkDuplicateNumber(final List<Integer> numbers) {
        if (LOTTO_SIZE != Set.copyOf(numbers).size()) {
            throw new IllegalArgumentException(InvalidException.ERROR_CREATE_LOTTO);
        }
    }

    public boolean contains(final int number) {
        return lottoNumbers.contains(number);
    }

    public List<Integer> getNumbers() {
        return lottoNumbers;
    }
}
