package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import model.Blog;
import utility.ConnectionManager;

public class BlogDaoImpl{

	static List<Blog> blogList= new ArrayList<Blog>(); 
	private static final String UPDATE_BLOG = "update blog set blogTitle = ?, blogDescription = ?, postedOn = ? where blogId = ?";
	final String INSERT_BLOG_QUERY = "INSERT INTO blog (blogId, blogTitle, blogDescription, postedOn) VALUES (seq_blog.nextval, ?, ?, ?)";
	final String SELECT_ALL_BLOGS = "Select * from BLOG";
	final String SELECT_BLOG="Select * from BLOG WHERE ID=?";
	private static final String DELETE_BLOG_BY_ID = "delete from blog where blogId = ?";
	void insertBlog(Blog blog) throws SQLException, Exception {
		PreparedStatement ps=ConnectionManager.getConnection().prepareStatement(INSERT_BLOG_QUERY);
		ps.setString(1, blog.getBlogTitle());
		ps.setString(2, blog.getBlogDescription());
		ps.setDate(3,java.sql.Date.valueOf(blog.getPostedOn()));
		ps.executeUpdate();
	}
	List selectAllBlogs() throws SQLException, Exception {

		Blog blog = new Blog();
		
		
		PreparedStatement ps=ConnectionManager.getConnection().prepareStatement(SELECT_ALL_BLOGS);
		
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()) {
			int blogId = rs.getInt("blogId");
			String blogTitle = rs.getString("blogTitle");
			String BlogDescription = rs.getString("blogDescription");
			LocalDate postedOn = rs.getDate("postedOn").toLocalDate();
			System.out.println(blogId);
			System.out.println(blogTitle);
			System.out.println(BlogDescription);
			System.out.println(postedOn);
			
			blog.setBlogId(blogId);
			blog.setBlogTitle(blogTitle);
			blog.setBlogDescription(BlogDescription);
			blog.setPostedOn(postedOn);
			
			blogList.add(blog);
		}
		return blogList;
	}
	Blog selectBlog(int blogid) throws SQLException, Exception {
			
		Blog blog = new Blog();
		
		
		PreparedStatement ps=ConnectionManager.getConnection().prepareStatement(SELECT_BLOG);
		
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()) {
			int blogId = rs.getInt("blogId");
			String blogTitle = rs.getString("blogTitle");
			String BlogDescription = rs.getString("blogDescription");
			LocalDate postedOn = rs.getDate("postedOn").toLocalDate();
			System.out.println(blogId);
			System.out.println(blogTitle);
			System.out.println(BlogDescription);
			System.out.println(postedOn);
			
			blog.setBlogId(blogId);
			blog.setBlogTitle(blogTitle);
			blog.setBlogDescription(BlogDescription);
			blog.setPostedOn(postedOn);
		}
		return blog;
	}
	public boolean deleteBlog(int blogId) throws Exception {
		boolean rowDeleted;
		Connection connection = ConnectionManager.getConnection();
				PreparedStatement statement = connection.prepareStatement(DELETE_BLOG_BY_ID);
			statement.setInt(1, blogId);
			rowDeleted = statement.executeUpdate() > 0;
		
		if(rowDeleted) {
			System.out.println("Blog is deleted");
	}
		else {
			System.out.println("No blog with the given id");
		}
		return rowDeleted;
	}
	
	public boolean updateBlog(Blog blog) throws SQLException, Exception {
		
		PreparedStatement ps = ConnectionManager.getConnection().prepareStatement(UPDATE_BLOG);
		ps.setString(1, blog.getBlogTitle());
		ps.setString(2,blog.getBlogDescription());
		ps.setDate(3, java.sql.Date.valueOf(blog.getPostedOn()));
		ps.setInt(4, blog.getBlogId());
		boolean rowUpdated = ps.executeUpdate() > 0;
		if(rowUpdated)
		{
			System.out.println("Updated Blog");
		}
		else
		{
			System.out.println("Please check");
		}
		return rowUpdated;
	}
}