package service;

import com.xiahe.dao.HistoryDao;
import com.xiahe.entity.History;
import com.xiahe.service.Service;
import com.xiahe.service.ServiceImp;
import org.junit.Test;

import java.util.List;

public class HistoryTest {

	@Test
	public void historyInsertS() {
		Service<History> service = new ServiceImp<History>(HistoryDao.class);
		History history = new History();
		history.setUsername("18838947335");
		history.setProxye("192.168.10.3:997304");
		service.insert(history);
	}

	@Test
	public void historySelectsS() {
		Service<History> service = new ServiceImp<History>(HistoryDao.class);
		List<History> selects = service.selects();
		for (History history : selects) {
			System.out.println(history);
		}
	}

}
