package com.test.util;

public class PageNavigator {

	private String root;
	private boolean nowFirst;
	private boolean nowEnd;
	private int totalArticleCount;
	private int totalPageCount;
	private int pageNo;
	private String navigator;

	public String getRoot() {
		return root;
	}

	public void setRoot(String root) {
		this.root = root;
	}

	public boolean isNowFirst() {
		return nowFirst;
	}

	public void setNowFirst(boolean nowFirst) {
		this.nowFirst = nowFirst;
	}

	public boolean isNowEnd() {
		return nowEnd;
	}

	public void setNowEnd(boolean nowEnd) {
		this.nowEnd = nowEnd;
	}

	public int getTotalArticleCount() {
		return totalArticleCount;
	}

	public void setTotalArticleCount(int totalArticleCount) {
		this.totalArticleCount = totalArticleCount;
	}

	public int getTotalPageCount() {
		return totalPageCount;
	}

	public void setTotalPageCount(int totalPageCount) {
		this.totalPageCount = totalPageCount;
	}

	public int getPageNo() {
		return pageNo;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	public String getNavigator() {
		return navigator;
	}

	public void makeNavigator() {
		StringBuffer tmpNavigator = new StringBuffer();
		
		int listSize = Constance.MEMBER_LIST_SIZE;
		int pageSize = Constance.MEMBER_PAGE_SIZE;
		
		int preLastNo = 0;

		tmpNavigator.append("<table cellpadding='0' cellspacing='0' border='0'>\n");
		tmpNavigator.append(" <tr>\n");
		if (this.isNowFirst()) {
			tmpNavigator.append("  <td><font color='#999999'>\n<a href='javascript:firstArticle(1)'>");
			tmpNavigator.append("   <img src='" + root + "/img/icon_prev02.gif' width='7' height='11' border='0' align='absmiddle' hspace='3'>�ֽŸ��</a>\n");
			tmpNavigator.append("   <img src='" + root + "/img/icon_prev01_dim.gif' width='3' height='11' border='0' align='absmiddle' hspace='3'>\n");
			tmpNavigator.append("   ����</font>\n");
		} else {
			preLastNo = (pageNo - 1) / pageSize * pageSize;
			tmpNavigator.append("  <td>\n<a href='javascript:firstArticle(1)'>");
			tmpNavigator.append("   <img src='" + root + "/img/icon_prev02.gif' width='7' height='11' border='0' align='absmiddle' hspace='3'>�ֽŸ�� </a>\n");
			tmpNavigator.append("   <a href='javascript:memberlist(" + preLastNo + ")'>");
			tmpNavigator.append("   <img src='" + root + "/img/icon_prev01_dim.gif' width='3' height='11' border='0' align='absmiddle' hspace='3'>\n");
			tmpNavigator.append("   ����</a>");
		}
		tmpNavigator.append("  \n</td>\n");
		tmpNavigator.append("  <td style='padding: 0 5 0 5'>\n");
		tmpNavigator.append("   <table cellpadding='0' cellspacing='0' border='0'>\n");
		tmpNavigator.append("    <tr>\n");
		tmpNavigator.append("     <td width='1' nowrap><img src='" + root + "/img/n_tab.gif' width='1'");
		tmpNavigator.append(" height='11' border='0' align='absmiddle'><br>");
		tmpNavigator.append("     </td>\n");
		
		int startPage = preLastNo + 1;
		int endPage = preLastNo + pageSize;
		if(endPage > totalPageCount)
			endPage = totalPageCount;
		
		for (int i = startPage; i <= endPage; i++) {
			if (pageNo == i) {
				tmpNavigator.append("     <td style='padding:0 7 0 7;' nowrap><font class='text_acc_02'><b>" + i + "</b></font></td>\n");
				tmpNavigator.append("     <td width='1' nowrap><img src='" + root + "/img/n_tab.gif' width='1'");
				tmpNavigator.append(" height='11' border='0' align='absmiddle'><br>\n");
			} else {
				tmpNavigator.append("     <td style='padding:0 7 0 7;' nowrap><a href='javascript:memberlist(" + i + ")'>" + i + "</td>\n");
				tmpNavigator.append("     <td width='1' nowrap><img src='" + root + "/img/n_tab.gif' width='1'");
				tmpNavigator.append(" height='11' border='0' align='absmiddle'><br>\n");
			}
		}
		tmpNavigator.append("     </td>\n");
		tmpNavigator.append("    </tr>\n");
		tmpNavigator.append("   </table>\n");
		tmpNavigator.append("  </td>\n");
		tmpNavigator.append("  <td>\n");
		
		if (this.isNowEnd()) {
			tmpNavigator.append("   <font color='#999999'>����<img");
			tmpNavigator.append("   src='" + root + "/img/icon_next01_dim.gif' width='3' height='11'");
			tmpNavigator.append(" border='0' align='absmiddle' hspace='3'> \n");
			tmpNavigator.append("   �����<img src='" + root + "/img/icon_next02_dim.gif' width='7' height='11'");
			tmpNavigator.append(" border='0' align='absmiddle' hspace='3'></font>\n");
		} else {
			int nextFirstNo = endPage + 1;
			tmpNavigator.append("   <a href='javascript:memberlist(" + nextFirstNo + ")'>����<img");
			tmpNavigator.append(" src='" + root + "/img/icon_next01_dim.gif' width='3' height='11'");
			tmpNavigator.append(" border='0' align='absmiddle' hspace='3'></a>\n");
			tmpNavigator.append("   <a href='javascript:memberlist(" + totalPageCount + ")'>�����<img src='" + root + "/img/icon_next02_dim.gif' width='7' height='11'");
			tmpNavigator.append(" border='0' align='absmiddle' hspace='3'>\n");
		}

		tmpNavigator.append("  </td>\n");
		tmpNavigator.append(" </tr>\n");
		tmpNavigator.append("</table>\n");

		this.navigator = tmpNavigator.toString();
	}
}
