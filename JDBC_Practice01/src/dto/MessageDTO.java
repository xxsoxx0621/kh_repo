package dto;

import java.sql.Date;

public class MessageDTO {
	private int seq_num;
	private String writer;
	private String message;
	private Date reg_date;
	
	public MessageDTO() {}
	
	public MessageDTO(int seq_num, String writer, String message, Date reg_date) {
		super();
		this.seq_num = seq_num;
		this.writer =writer;
		this.message = message;
		this.reg_date = reg_date;
	}
	public Date getReg_date() {
		return reg_date;
	}

	public void setReg_date(Date reg_date) {
		this.reg_date = reg_date;
	}

	public int getSeq_num() {
		return seq_num;
	}

	public void setSeq_num(int seq_num) {
		this.seq_num = seq_num;
	}

	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}

}
