package util;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import dao.YiDianDao;

public class RegJob {
	static double L1 = 71.32;
	static double L3 = 65.87;
	static double L7 = 60.91;
	static double L30 = 38.55;
	public YiDianDao yiDianDao;

	public void reg() {
		try {

			int i = Calendar.getInstance().get(Calendar.DAY_OF_YEAR);
			int x = (int) (System.currentTimeMillis() & 5);
			int y = 5000 + Utils.getRandom(i * 10, i * 17)
					+ Utils.getRandom(x * 80, x * 150);

			Map sqlmap = new HashMap();
			sqlmap.put("nnum", y);
			sqlmap.put("dtime", Utils.dateToString2(new Date()));
			this.getYiDianDao().insertReg_Num(sqlmap);

			Map map = new HashMap();
			map.put("L1", L1 + countLC());
			map.put("L3", L3 + countLC());
			map.put("L7", L7 + countLC());
			map.put("L30", L30 + countLC());
			map.put("dtime", Utils.dateToString2(new Date()));
			this.getYiDianDao().insertLiuCun(map);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static double countLC() {
		return Utils.RANDOM.nextDouble() * 9;
	}

	public YiDianDao getYiDianDao() {
		return yiDianDao;
	}

	public void setYiDianDao(YiDianDao yiDianDao) {
		this.yiDianDao = yiDianDao;
	}

}
