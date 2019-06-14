package lotto.view;

import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.LottoResult;
import lotto.domain.lotto.Lottos;
import lotto.domain.money.Prize;

public class OutputView {
    public static void printLottos(Lottos lottos, int manualLottoCount) {
        System.out.println("수동으로 " + manualLottoCount + "자동으로 "
                + (lottos.size() - manualLottoCount) + " 를 구매했습니다!");

        for (Lotto lotto : lottos.getLottosList()) {
            printLotto(lotto);
        }
    }

    private static void printLotto(Lotto lotto) {
        System.out.println(lotto);
    }

    public static void printStatistics(LottoResult lottoResult) {
        System.out.println("당첨통계");
        System.out.println("---------");
        for (Prize prize : Prize.values()) {
            System.out.println(prize.getMatchCount() + "개 일치" + "(" + prize.getPrizeMoney() + "원)" + " - " + lottoResult.getCount(prize) + "개");
        }
        System.out.printf("총 수익률은 %.2f%%입니다", lottoResult.getProfitRate());
    }
}