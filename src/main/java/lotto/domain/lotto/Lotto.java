package lotto.domain.lotto;

import java.util.Collections;
import java.util.List;
import java.util.Set;

public class Lotto {

    private static final String ERROR_CREATE_LOTTO = "[ERROR] 잘못된 숫자 입력입니다.";
    private static final String ERROR_NULL_BLANK = "[ERROR] NULL 또는 공백이 입력되었습니다.";
    private static final int LOTTO_SIZE = 6;
    private final List<Integer> lottoNumbers;

    public Lotto(){
        List<Integer> numberRange = LottoNumber.getRangeLottoNumbers();
        Collections.shuffle(numberRange);
        checkNumbers(numberRange.subList(0, LOTTO_SIZE));
        lottoNumbers = numberRange.subList(0, LOTTO_SIZE);
        Collections.sort(lottoNumbers);
    }

    public Lotto(final List<Integer> lottoNumbers) {
        checkNumbers(lottoNumbers);
        this.lottoNumbers = lottoNumbers;
        Collections.sort(lottoNumbers);
    }

    private void checkNumbers(final List<Integer> lottoNumbers) {
        checkNull(lottoNumbers);
        checkLottoSize(lottoNumbers);
    }

    private void checkNull(final List<Integer> lottoNumbers) {
        if (lottoNumbers == null || lottoNumbers.isEmpty()) {
            throw new IllegalArgumentException(ERROR_NULL_BLANK);
        }
    }

    private static void checkLottoSize(final List<Integer> numbers) {
        if (LOTTO_SIZE != Set.copyOf(numbers).size()) {
            throw new IllegalArgumentException(ERROR_CREATE_LOTTO);
        }
    }

    public boolean contains(final int number) {
        return lottoNumbers.contains(number);
    }

    public List<Integer> getNumbers() {
        return lottoNumbers;
    }
}
