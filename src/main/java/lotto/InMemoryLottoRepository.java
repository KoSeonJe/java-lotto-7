package lotto;

import java.util.ArrayList;
import java.util.List;

public class InMemoryLottoRepository implements LottoRepository {

    private static final InMemoryLottoRepository INSTANCE = new InMemoryLottoRepository();

    private final List<Lotto> lottoRepository = new ArrayList<>();

    private InMemoryLottoRepository() {

    }

    public static InMemoryLottoRepository getInstance() {
        return INSTANCE;
    }

    @Override
    public void saveAll(List<Lotto> lottos) {
        lottoRepository.addAll(lottos);
    }
}
