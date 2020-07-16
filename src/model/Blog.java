package model;

import java.time.LocalDate;

public class Blog{
	int blogId;
	private String blogTitle;
	private String blogDescription;
	LocalDate postedOn;
	public int getBlogId() {
		return blogId;
	}
	public String getBlogTitle() {
		return blogTitle;
	}
	public String getBlogDescription() {
		return blogDescription;
	}
	public LocalDate getPostedOn() {
		return postedOn;
	}
	public void setBlogId(int blogId) {
		this.blogId = blogId;
	}
	public void setBlogTitle(String blogTitle) {
		this.blogTitle = blogTitle;
	}
	public void setBlogDescription(String blogDescription) {
		this.blogDescription = blogDescription;
	}
	public void setPostedOn(LocalDate postedOn) {
		this.postedOn = postedOn;
	}
	
	
	
	
	
}