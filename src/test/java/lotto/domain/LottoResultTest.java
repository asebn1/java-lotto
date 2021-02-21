package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import lotto.domain.ticketFactory.TicketFactory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoResultTest {

    LottoResult lottoResult = new LottoResult();

    @DisplayName("당첨티켓과 구매티켓들을 각각 비교하여 각 등수별 당첨횟수를 구한다.")
    @Test
    void checkResult(){
        LottoTicket lottoTicket = TicketFactory.makeFixedTicket(Arrays.asList(1,2,3,4,5,6));
        LottoTickets lottoTickets = new LottoTickets(Arrays.asList(lottoTicket));
        LottoTicket winningTicket = TicketFactory.makeFixedTicket(Arrays.asList(1,2,3,4,5,7));
        WinningLotto winningLotto = new WinningLotto(winningTicket,new LottoNumber(6));

        lottoResult.checkWinnings(lottoTickets, winningLotto);
    }

    @DisplayName("저장된 등수별 당첨횟수를 이용해 총 당청금을 게산한다.")
    @Test
    void calculate(){
        checkResult();
        assertThat(lottoResult.calculateTotalReward()).isEqualTo(30_000_000);
    }

}