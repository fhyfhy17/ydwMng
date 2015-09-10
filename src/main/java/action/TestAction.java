package action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import model.CheckIn;
import model.EnterAndFinish;
import model.Liucun;
import model.Mo;
import model.Pay;
import model.PayManage;
import model.RegNum;
import model.ScoreBuySum;
import model.ShareOrder;
import model.User;
import model.YDUser;
import net.sf.json.JSONArray;
import util.Utils;

public class TestAction extends BaseAction {

	private static final long serialVersionUID = 1L;

	public void test() {
		try {
			String startTime = request.getParameter("startTime");
			String endTime = request.getParameter("endTime");

			Map sqlmap = new HashMap();
			if (!"".equals(startTime) && startTime != null) {
				sqlmap.put("startTime", startTime);
			}
			if (!"".equals(endTime) && endTime != null) {
				sqlmap.put("endTime", endTime);
			}

			int enterCount = this.getYiDianDao().getGameEnterCount(sqlmap);
			System.out.println(enterCount);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void getShare() {
		String jsonResult = "";
		try {
			String startTime = request.getParameter("startTime");
			String endTime = request.getParameter("endTime");
			String page = request.getParameter("page");
			String rows = request.getParameter("rows");

			Map sqlmap = new HashMap();
			if (!"".equals(startTime) && startTime != null) {
				sqlmap.put("startTime", startTime);
			}
			if (!"".equals(endTime) && endTime != null) {
				sqlmap.put("endTime", endTime);
			}
			if (!"".equals(page) && page != null && !"".equals(rows)
					&& rows != null) {
				sqlmap.put("rowStart", Utils.getRowStart(rows, page));
				sqlmap.put("rowEnd", Utils.getRowEnd(rows, page));
			}
			List<Mo> share = this.getYiDianDao().getShare(sqlmap);
			int shareCount = this.getYiDianDao().getShareCount(sqlmap);
			if (share != null) {
				JSONArray jsonArray = JSONArray.fromObject(share);
				jsonResult = jsonArray.toString();
				jsonResult = "{\"total\":" + shareCount + "," + "\"rows\":"
						+ jsonArray.toString() + "}";
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			response.setCharacterEncoding("UTF-8");
			response.getWriter().write(jsonResult);
			response.getWriter().flush();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void getShareCount() {
		String jsonResult = "";
		try {
			String startTime = request.getParameter("startTime");
			String endTime = request.getParameter("endTime");

			Map sqlmap = new HashMap();
			if (!"".equals(startTime) && startTime != null) {
				sqlmap.put("startTime", startTime);
			}
			if (!"".equals(endTime) && endTime != null) {
				sqlmap.put("endTime", endTime);
			}
			int shareCount = this.getYiDianDao().getShareCount(sqlmap);
			jsonResult = String.valueOf(shareCount);

		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			response.setCharacterEncoding("UTF-8");
			response.getWriter().write(jsonResult);
			response.getWriter().flush();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void getScoreBuy() {
		String jsonResult = "";
		try {
			String startTime = request.getParameter("startTime");
			String endTime = request.getParameter("endTime");
			String page = request.getParameter("page");
			String rows = request.getParameter("rows");

			Map sqlmap = new HashMap();
			if (!"".equals(startTime) && startTime != null) {
				sqlmap.put("startTime", startTime);
			}
			if (!"".equals(endTime) && endTime != null) {
				sqlmap.put("endTime", endTime);
			}

			if (!"".equals(page) && page != null && !"".equals(rows)
					&& rows != null) {
				sqlmap.put("rowStart", Utils.getRowStart(rows, page));
				sqlmap.put("rowEnd", Utils.getRowEnd(rows, page));
			}
			List<Mo> scoreBuy = this.getYiDianDao().getScoreBuy(sqlmap);
			int scoreBuyCount = this.getYiDianDao().getScoreBuyCount(sqlmap);
			if (scoreBuy != null) {
				JSONArray jsonArray = JSONArray.fromObject(scoreBuy);
				jsonResult = jsonArray.toString();
				jsonResult = "{\"total\":" + scoreBuyCount + "," + "\"rows\":"
						+ jsonArray.toString() + "}";
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			response.setCharacterEncoding("UTF-8");
			response.getWriter().write(jsonResult);
			response.getWriter().flush();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void getGameEnterAndFinish() {
		String jsonResult = "";
		try {
			String startTime = request.getParameter("startTime");
			String endTime = request.getParameter("endTime");

			Map sqlmap = new HashMap();
			if (!"".equals(startTime) && startTime != null) {
				sqlmap.put("startTime", startTime);
			}
			if (!"".equals(endTime) && endTime != null) {
				sqlmap.put("endTime", endTime);
			}

			int enterCount = this.getYiDianDao().getGameEnterCount(sqlmap);
			int finishCount = this.getYiDianDao().getGameFinishCount(sqlmap);
			int enterCountDistinct = this.getYiDianDao()
					.getGameEnterCountDistinct(sqlmap);
			int finishCountDistinct = this.getYiDianDao()
					.getGameFinishCountDistinct(sqlmap);

			EnterAndFinish enterAndFinish = new EnterAndFinish();
			enterAndFinish.setEnterCount(enterCount);
			enterAndFinish.setFinishCount(finishCount);
			enterAndFinish.setEnterCountDistinct(enterCountDistinct);
			enterAndFinish.setFinishCountDistinct(finishCountDistinct);

			JSONArray jsonArray = JSONArray.fromObject(enterAndFinish);
			jsonResult = jsonArray.toString();

		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			response.setCharacterEncoding("UTF-8");
			response.getWriter().write(jsonResult);
			response.getWriter().flush();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void getCheckIn() {
		String jsonResult = "";
		try {
			String startTime = request.getParameter("startTime");
			String endTime = request.getParameter("endTime");
			String page = request.getParameter("page");
			String rows = request.getParameter("rows");

			Map sqlmap = new HashMap();
			if (!"".equals(startTime) && startTime != null) {
				sqlmap.put("startTime", startTime);
			}
			if (!"".equals(endTime) && endTime != null) {
				sqlmap.put("endTime", endTime);
			}

			if (!"".equals(page) && page != null && !"".equals(rows)
					&& rows != null) {
				sqlmap.put("rowStart", Utils.getRowStart(rows, page));
				sqlmap.put("rowEnd", Utils.getRowEnd(rows, page));
			}
			List<CheckIn> checkIn = this.getYiDianDao().getCheckIn(sqlmap);
			int checkInCount = this.getYiDianDao().getCheckInCount(sqlmap);
			if (checkIn != null) {
				JSONArray jsonArray = JSONArray.fromObject(checkIn);
				jsonResult = jsonArray.toString();
				jsonResult = "{\"total\":" + checkInCount + "," + "\"rows\":"
						+ jsonArray.toString() + "}";
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			response.setCharacterEncoding("UTF-8");
			response.getWriter().write(jsonResult);
			response.getWriter().flush();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void getCheckInCount() {
		String jsonResult = "";
		try {
			String startTime = request.getParameter("startTime");
			String endTime = request.getParameter("endTime");

			Map sqlmap = new HashMap();
			if (!"".equals(startTime) && startTime != null) {
				sqlmap.put("startTime", startTime);
			}
			if (!"".equals(endTime) && endTime != null) {
				sqlmap.put("endTime", endTime);
			}

			int checkInCount = this.getYiDianDao().getCheckInCount(sqlmap);
			jsonResult = String.valueOf(checkInCount);

		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			response.setCharacterEncoding("UTF-8");
			response.getWriter().write(jsonResult);
			response.getWriter().flush();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void getShareOrder() {
		String jsonResult = "";
		try {
			String startTime = request.getParameter("startTime");
			String endTime = request.getParameter("endTime");

			Map sqlmap = new HashMap();
			if (!"".equals(startTime) && startTime != null) {
				sqlmap.put("startTime", startTime);
			}
			if (!"".equals(endTime) && endTime != null) {
				sqlmap.put("endTime", endTime);
			}

			List<ShareOrder> shareOrder = this.getYiDianDao().getShareOrder(
					sqlmap);

			JSONArray jsonArray = JSONArray.fromObject(shareOrder);
			jsonResult = jsonArray.toString();

		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			response.setCharacterEncoding("UTF-8");
			response.getWriter().write(jsonResult);
			response.getWriter().flush();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void getScoreBuySum() {
		String jsonResult = "";
		try {
			String startTime = request.getParameter("startTime");
			String endTime = request.getParameter("endTime");

			Map sqlmap = new HashMap();
			if (!"".equals(startTime) && startTime != null) {
				sqlmap.put("startTime", startTime);
			}
			if (!"".equals(endTime) && endTime != null) {
				sqlmap.put("endTime", endTime);
			}

			List<ScoreBuySum> scoreBuySum = this.getYiDianDao().getScoreBuySum(
					sqlmap);

			JSONArray jsonArray = JSONArray.fromObject(scoreBuySum);
			jsonResult = jsonArray.toString();

		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			response.setCharacterEncoding("UTF-8");
			response.getWriter().write(jsonResult);
			response.getWriter().flush();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String login() {
		String forward = "false";
		try {
			String userName = request.getParameter("userName");
			String passWord = request.getParameter("passWord");

			Map sqlmap = new HashMap();
			if (!"".equals(userName) && userName != null) {
				sqlmap.put("userName", userName);
			}

			HttpSession session = request.getSession();

			if (!"".equals(userName)) {
				User user = this.getYiDianDao().login(sqlmap);
				if (null != user) {
					if (!"".equals(passWord)) {
						System.out.println("password is ======" + passWord);
						System.out.println("password 1 is ====="
								+ user.getPassWord());
						if (user.getPassWord().equals(passWord)) {
							forward = "success";
							session.setAttribute("admin", user);
							session.setAttribute("group", user.getGroup());
						} else {

						}
					}
				} else {

				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return forward;
	}

	public void getRegNum() {
		String jsonResult = "";
		try {
			String startTime = request.getParameter("startTime");

			Map sqlmap = new HashMap();
			if (!"".equals(startTime) && startTime != null) {
				sqlmap.put("startTime", startTime);

				int regNum = this.getYiDianDao().getReg_num(sqlmap);
				int regNumAll = this.getYiDianDao().getReg_numAll(sqlmap);
				RegNum r = new RegNum();
				r.setRegNum(regNum);
				r.setRegNumAll(regNumAll);

				JSONArray jsonArray = JSONArray.fromObject(r);
				jsonResult = jsonArray.toString();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			response.setCharacterEncoding("UTF-8");
			response.getWriter().write(jsonResult);
			response.getWriter().flush();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void queryYDUser() {
		String jsonResult = "";
		try {
			String nick = toUtf8("nick");
			String username = request.getParameter("username");
			String page = request.getParameter("page");
			String rows = request.getParameter("rows");
			Map sqlmap = new HashMap();
			if (!"".equals(nick) && nick != null) {
				sqlmap.put("nick", nick);
			}
			if (!"".equals(username) && username != null) {
				sqlmap.put("userName", username);
			}
			if (!"".equals(page) && page != null && !"".equals(rows)
					&& rows != null) {
				sqlmap.put("rowStart", Utils.getRowStart(rows, page));
				sqlmap.put("rowEnd", Utils.getRowEnd(rows, page));
			}

			List<YDUser> list = this.getYiDianDao().queryYDUser(sqlmap);
			int count = this.getYiDianDao().queryYDUserCount(sqlmap);
			for (YDUser ydUser : list) {
				String[] s = ydUser.getRegTime().split(" ");
				if (s != null && s.length > 1) {
					ydUser.setRegTime(s[0]);
				}
			}

			if (list != null) {
				JSONArray jsonArray = JSONArray.fromObject(list);
				jsonResult = jsonArray.toString();
				jsonResult = "{\"total\":" + count + "," + "\"rows\":"
						+ jsonArray.toString() + "}";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			response.setCharacterEncoding("UTF-8");
			response.getWriter().write(jsonResult);
			response.getWriter().flush();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void queryLiucun() {
		String jsonResult = "";
		try {
			String startTime = request.getParameter("startTime");

			Map sqlmap = new HashMap();
			if (!"".equals(startTime) && startTime != null) {
				sqlmap.put("startTime", startTime);

				List<Liucun> list = this.getYiDianDao().getLiuCun(sqlmap);

				JSONArray jsonArray = JSONArray.fromObject(list);
				jsonResult = jsonArray.toString();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		try {
			response.setCharacterEncoding("UTF-8");
			response.getWriter().write(jsonResult);
			response.getWriter().flush();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void getPay() {
		String jsonResult = "";
		try {
			String startTime = request.getParameter("startTime");
			String endTime = request.getParameter("endTime");
			String page = request.getParameter("page");
			String rows = request.getParameter("rows");
			User user = (User) session.getAttribute("admin");
			String jieru = request.getParameter("jieru");
			if (user != null) {
				Map sqlmap = new HashMap();
				if ((!"".equals(user.getSid()) && user.getSid() != null)
						|| user.getGroup() == 1) {
					if (user.getGroup() == 1) {
						sqlmap.put("sid", jieru);
					} else {
						sqlmap.put("sid", user.getSid());
					}
					if (!"".equals(startTime) && startTime != null) {
						sqlmap.put("startTime", startTime);
					}
					if (!"".equals(endTime) && endTime != null) {
						sqlmap.put("endTime", endTime);
					}
					if (!"".equals(page) && page != null && !"".equals(rows)
							&& rows != null) {
						sqlmap.put("rowStart", Utils.getRowStart(rows, page));
						sqlmap.put("rowEnd", Utils.getRowEnd(rows, page));
					}
					List<Pay> list = this.getPayDao().getPay(sqlmap);
					int count = this.getPayDao().getPaycount(sqlmap);

					if (list != null) {
						JSONArray jsonArray = JSONArray.fromObject(list);
						jsonResult = jsonArray.toString();
						jsonResult = "{\"total\":" + count + "," + "\"rows\":"
								+ jsonArray.toString() + "}";
					}
				}

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			response.setCharacterEncoding("UTF-8");
			response.getWriter().write(jsonResult);
			response.getWriter().flush();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void getPayManage() {
		String jsonResult = "";
		try {
			String startTime = request.getParameter("startTime");
			String endTime = request.getParameter("endTime");
			String page = request.getParameter("page");
			String rows = request.getParameter("rows");
			String jieru = request.getParameter("jieru");
			User user = (User) session.getAttribute("admin");
			if (user != null) {
				Map sqlmap = new HashMap();
				if ((!"".equals(user.getSid()) && user.getSid() != null)
						|| user.getGroup() == 1) {
					if (user.getGroup() == 1) {
						sqlmap.put("sid", jieru);
					} else {
						sqlmap.put("sid", user.getSid());
					}
					if (!"".equals(startTime) && startTime != null) {
						sqlmap.put("startTime", startTime);
					}
					if (!"".equals(endTime) && endTime != null) {
						sqlmap.put("endTime", endTime);
					}
					if (!"".equals(page) && page != null && !"".equals(rows)
							&& rows != null) {
						sqlmap.put("rowStart", Utils.getRowStart(rows, page));
						sqlmap.put("rowEnd", Utils.getRowEnd(rows, page));
					}

					List<PayManage> list = this.getPayDao()
							.getPayManage(sqlmap);
					PayManage p = new PayManage();
					p.setDtime("合计：");
					for (PayManage payManage : list) {
						p.setAmt(payManage.getAmt() + p.getAmt());
					}
					list.add(p);

					if (list != null) {
						JSONArray jsonArray = JSONArray.fromObject(list);
						jsonResult = jsonArray.toString();
						jsonResult = jsonArray.toString();
					}
				}

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			response.setCharacterEncoding("UTF-8");
			response.getWriter().write(jsonResult);
			response.getWriter().flush();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}