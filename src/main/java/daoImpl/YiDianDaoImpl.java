package daoImpl;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import model.CheckIn;
import model.Liucun;
import model.Mo;
import model.ScoreBuySum;
import model.ShareOrder;
import model.User;
import model.YDUser;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import dao.YiDianDao;

public class YiDianDaoImpl extends SqlMapClientDaoSupport implements YiDianDao {

	public List<Mo> getShare(Map sqlmap) {
		try {
			return (List<Mo>) this.getSqlMapClient().queryForList(
					"AdminSQL.getShare", sqlmap);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public Integer getShareCount(Map sqlmap) {
		try {
			return (Integer) this.getSqlMapClient().queryForObject(
					"AdminSQL.getShareCount", sqlmap);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	public List<Mo> getScoreBuy(Map sqlmap) {
		try {
			return (List<Mo>) this.getSqlMapClient().queryForList(
					"AdminSQL.getScoreBuy", sqlmap);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public Integer getScoreBuyCount(Map sqlmap) {
		try {
			return (Integer) this.getSqlMapClient().queryForObject(
					"AdminSQL.getScoreBuyCount", sqlmap);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	public Integer getGameEnterCount(Map sqlmap) {

		try {
			return (Integer) this.getSqlMapClient().queryForObject(
					"AdminSQL.getGameEnterCount", sqlmap);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	public Integer getGameFinishCount(Map sqlmap) {
		try {
			return (Integer) this.getSqlMapClient().queryForObject(
					"AdminSQL.getGameFinishCount", sqlmap);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	public List<CheckIn> getCheckIn(Map sqlmap) {
		try {
			return (List<CheckIn>) this.getSqlMapClient().queryForList(
					"AdminSQL.getCheckIn", sqlmap);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public Integer getCheckInCount(Map sqlmap) {
		try {
			return (Integer) this.getSqlMapClient().queryForObject(
					"AdminSQL.getCheckInCount", sqlmap);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	public List<ShareOrder> getShareOrder(Map sqlmap) {
		try {
			return (List<ShareOrder>) this.getSqlMapClient().queryForList(
					"AdminSQL.getShareOrder", sqlmap);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<ScoreBuySum> getScoreBuySum(Map sqlmap) {
		try {
			return (List<ScoreBuySum>) this.getSqlMapClient().queryForList(
					"AdminSQL.getScoreBuySum", sqlmap);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public Integer getGameEnterCountDistinct(Map sqlmap) {

		try {
			return (Integer) this.getSqlMapClient().queryForObject(
					"AdminSQL.getGameEnterCountDistinct", sqlmap);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	public Integer getGameFinishCountDistinct(Map sqlmap) {
		try {
			return (Integer) this.getSqlMapClient().queryForObject(
					"AdminSQL.getGameFinishCountDistinct", sqlmap);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	public User login(Map sqlmap) {
		try {
			return (User) this.getSqlMapClient().queryForObject(
					"AdminSQL.login", sqlmap);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public Integer getReg_num(Map sqlmap) {

		try {
			int i = (Integer) this.getSqlMapClient().queryForObject(
					"AdminSQL.getReg_num", sqlmap);
			return i;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	public Integer getReg_numAll(Map sqlmap) {
		try {
			return (Integer) this.getSqlMapClient().queryForObject(
					"AdminSQL.getReg_numAll", sqlmap);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	public void insertReg_Num(Map sqlmap) {
		try {
			this.getSqlMapClientTemplate().insert("AdminSQL.insertReg_num",
					sqlmap);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public List<YDUser> queryYDUser(Map sqlmap) {
		try {

			List l = (List<YDUser>) this.getSqlMapClientTemplate()
					.queryForList("AdminSQL.queryYDUser", sqlmap);
			return l;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public Integer queryYDUserCount(Map sqlmap) {
		try {
			return (Integer) this.getSqlMapClient().queryForObject(
					"AdminSQL.queryYDUserCount", sqlmap);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	public void insertLiuCun(Map sqlmap) {
		try {
			this.getSqlMapClientTemplate().insert("AdminSQL.insertLiuCun",
					sqlmap);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public List<Liucun> getLiuCun(Map sqlmap) {
		try {
			return (List<Liucun>) this.getSqlMapClient().queryForList(
					"AdminSQL.getLiucun", sqlmap);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
