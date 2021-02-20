package lotto.view;

import java.util.List;
import java.util.stream.Collectors;
import lotto.domain.lotto.LottoTicket;

public class TicketsView {

    private TicketsView() {
    }

    public static void printTickets(List<LottoTicket> lottoTickets) {
        printLottoTicketCount(lottoTickets.size());

        for (LottoTicket lottoTicket : lottoTickets) {
            printLottoTicket(lottoTicket);
        }

        System.out.println();
    }

    private static void printLottoTicketCount(int lottoTicketCount) {
        System.out.printf("%d개를 구매했습니다.\n", lottoTicketCount);
    }

    private static void printLottoTicket(LottoTicket lottoTicket) {
        String numbers = lottoTicket.toUnmodifiableList().stream()
                .map(lottoNumber -> Integer.toString(lottoNumber.toInt()))
                .collect(Collectors.joining(", "));
        System.out.println("[" + numbers + "]");
    }

}