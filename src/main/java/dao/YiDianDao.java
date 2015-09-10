package dao;

import java.util.List;
import java.util.Map;

import model.CheckIn;
import model.Liucun;
import model.Mo;
import model.ScoreBuySum;
import model.ShareOrder;
import model.User;
import model.YDUser;

/**
 * 后台管理员Dao接口
 * 
 * @author user
 * 
 */
public interface YiDianDao {

	public List<Mo> getShare(Map sqlmap);

	public Integer getShareCount(Map sqlmap);

	public List<Mo> getScoreBuy(Map sqlmap);

	public Integer getScoreBuyCount(Map sqlmap);

	public Integer getGameEnterCount(Map sqlmap);

	public Integer getGameFinishCount(Map sqlmap);

	public Integer getGameEnterCountDistinct(Map sqlmap);

	public Integer getGameFinishCountDistinct(Map sqlmap);

	public List<CheckIn> getCheckIn(Map sqlmap);

	public Integer getCheckInCount(Map sqlmap);

	public List<ShareOrder> getShareOrder(Map sqlmap);

	public List<ScoreBuySum> getScoreBuySum(Map sqlmap);

	public User login(Map sqlmap);

	public Integer getReg_num(Map sqlmap);

	public Integer getReg_numAll(Map sqlmap);

	public void insertReg_Num(Map sqlmap);

	public List<YDUser> queryYDUser(Map sqlmap);

	public Integer queryYDUserCount(Map sqlmap);

	public void insertLiuCun(Map sqlmap);
	
	public List<Liucun> getLiuCun(Map sqlmap);
}
