package lotto.domain.user;

public class PurchaseLottoCount {

    private static final String ERROR_WRONG_INPUT_COUNT = "[ERROR] 올바른 정수값을 입력해주세요";

    private final int manualLottoCount;
    private final int autoLottoCount;

    public PurchaseLottoCount(final String count, final int maxCount) {
        checkInputCount(count, maxCount);
        int countNum = Integer.parseInt(count);
        this.manualLottoCount = countNum;
        this.autoLottoCount = maxCount - countNum;
    }

    private void checkInputCount(final String count, final int maxCount) {
        checkDivideCount(checkValidateInt(count), maxCount);
    }

    private int checkValidateInt(final String count) {
        try {
            return Integer.parseInt(count);
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException(ERROR_WRONG_INPUT_COUNT);
        }
    }

    private void checkDivideCount(final int count, final int maxCount) {
        if (count <= 0 || count > maxCount) {
            throw new IllegalArgumentException(ERROR_WRONG_INPUT_COUNT);
        }
    }

    public int getManualLottoCount() {
        return manualLottoCount;
    }

    public int getAutoLottoCount() {
        return autoLottoCount;
    }
}
