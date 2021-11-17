package dto;

import java.sql.Date;

public class GuestDTO {
	
	private int seq;
	private String writer;
	private String message;
	private Date write_date;
	
	public GuestDTO() {
		super();
	}
	
	public GuestDTO(int seq, String writer, String message, Date write_date) {
		this.seq = seq;
		this.message = message;
		this.writer = writer;
		this.write_date = write_date;
	}

	public int getSeq() {
		return seq;
	}

	public void setSeq(int seq) {
		this.seq = seq;
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

	public Date getWrite_date() {
		return write_date;
	}

	public void setWrite_date(Date write_date) {
		this.write_date = write_date;
	}

}
