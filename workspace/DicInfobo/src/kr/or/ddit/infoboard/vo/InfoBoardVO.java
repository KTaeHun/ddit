package kr.or.ddit.infoboard.vo;

import java.util.Date;

public class InfoBoardVO {

	private int infoboNum;
	private String infoboTitle;
	private String infoboCon;
	private String infoboDate;
	private int infoboLike;
	private long atchFileId = -1;

	public int getInfoboNum() {
		return infoboNum;
	}

	public void setInfoboNum(int infoboNum) {
		this.infoboNum = infoboNum;
	}

	public String getInfoboTitle() {
		return infoboTitle;
	}

	public void setInfoboTitle(String infoboTitle) {
		this.infoboTitle = infoboTitle;
	}

	public String getInfoboCon() {
		return infoboCon;
	}

	public void setInfoboCon(String infoboCon) {
		this.infoboCon = infoboCon;
	}

		public int getInfoboLike() {
		return infoboLike;
	}

	public void setInfoboLike(int infoboLike) {
		this.infoboLike = infoboLike;
	}

	public String getInfoboDate() {
		return infoboDate;
	}

	public void setInfoboDate(String infoboDate) {
		this.infoboDate = infoboDate;
	}

	public long getAtchFileId() {
		return atchFileId;
	}

	public void setAtchFileId(long atchFileId) {
		this.atchFileId = atchFileId;
	}

	@Override
	public String toString() {
		return "InfoBoardVO [infoboNum=" + infoboNum + ", infoboTitle=" + infoboTitle + ", infoboCon=" + infoboCon
				+ ", infoboDate=" + ", infoboLike=" + infoboLike + ", atchFileId=" + atchFileId + "]";
	}

}
