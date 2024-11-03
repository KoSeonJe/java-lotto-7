package lotto.view;

import static lotto.common.ConsoleMessage.*;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import lotto.domain.LottoRank;
import lotto.view.dto.WinningInfo;

public class ApplicationConsoleView implements ApplicationView {

    private static final String LINE_SEPARATOR = System.lineSeparator();

    @Override
    public int requestMoney() {
        println(REQUEST_INPUT_MONEY);
        return Integer.parseInt(Console.readLine());
    }

    @Override
    public void printPurchasedLotto(List<String> lottos) {
        println(LINE_SEPARATOR + lottos.size() + PURCHASE_COUNT_MESSAGE);
        lottos.forEach(this::println);
    }

    @Override
    public String requestWinNumber() {
        println(LINE_SEPARATOR + REQUEST_INPUT_WIN_NUMBER);
        return Console.readLine();
    }

    @Override
    public int requestBonusNumber() {
        println(LINE_SEPARATOR + REQUEST_INPUT_BONUS_NUMBER);
        return Integer.parseInt(Console.readLine());
    }

    @Override
    public void printWinningResult(WinningInfo winningInfo) {
        println(LINE_SEPARATOR + WIN_HEADER);
        for (LottoRank rank : LottoRank.values()) {
            int matchCount = rank.getMatchedCount();
            String prize = rank.getPrize();
            int winCount = winningInfo.getValue(rank.name());
            if (rank.equals(LottoRank.SECOND)) {
                System.out.printf(FIVE_AND_BONUS_MATCH_RESULT, matchCount, prize, winCount);
                continue;
            }
            System.out.printf(DEFAULT_MATCH_RESULT, matchCount, prize, winCount);
        }
    }

    private void println(String message) {
        System.out.println(message);
    }
}
