package lotto;

import java.util.List;

public interface LottoResultUseCase {

    void createWinLotto(List<Integer> numbers, int bonusNumber);
}
