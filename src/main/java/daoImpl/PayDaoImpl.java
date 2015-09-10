package daoImpl;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import model.CheckIn;
import model.Liucun;
import model.Mo;
import model.Pay;
import model.PayManage;
import model.ScoreBuySum;
import model.ShareOrder;
import model.User;
import model.YDUser;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import dao.PayDao;
import dao.YiDianDao;

public class PayDaoImpl extends SqlMapClientDaoSupport implements PayDao {

	public List<Pay> getPay(Map sqlmap) {
		try {
			return (List<Pay>) this.getSqlMapClient().queryForList(
					"AdminSQL.getPay", sqlmap);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public int getPaycount(Map sqlmap) {
		try {
			return (Integer) this.getSqlMapClient().queryForObject(
					"AdminSQL.getPayCount", sqlmap);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public List<PayManage> getPayManage(Map sqlmap) {
		try {
			return (List<PayManage>) this.getSqlMapClient().queryForList(
					"AdminSQL.getPayManage", sqlmap);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
