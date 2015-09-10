package dao;

import java.util.List;
import java.util.Map;

import model.Pay;
import model.PayManage;

public interface PayDao {

	List<Pay> getPay(Map sqlmap);

	int getPaycount(Map sqlmap);

	List<PayManage> getPayManage(Map sqlmap);

}
