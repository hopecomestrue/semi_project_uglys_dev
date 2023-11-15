package com.veg.seoj.notice.model.service;
import static com.veg.common.JDBCTemplate.close;
import static com.veg.common.JDBCTemplate.getConnection;
import static com.veg.common.JDBCTemplate.commit;
import static com.veg.common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.List;

import com.veg.seoj.notice.model.dao.GenericDAOImpl;
import com.veg.seoj.notice.model.dto.Notice;
public class NoticeService {
	/*private NoticeDao dao=new NoticeDao();*/

	public List<Notice> selectNotice(int cPage,int numPerpage){
		Connection conn=getConnection();
		GenericDAOImpl<Notice, Integer> noticeDAO = new GenericDAOImpl<>(conn, "Notice");
		Notice Some = (Notice)Notice.builder().build();
		int a = (cPage-1)*numPerpage+1;
		int b = cPage*numPerpage;
		List<Notice> result=noticeDAO.getTo(conn,Some,"sql.notice.select",a,b);

		close(conn);
		return result;
	}
	public int selectNoticeCount() {
		Connection conn=getConnection();
		GenericDAOImpl<Notice, Integer> noticeDAO = new GenericDAOImpl<>(conn, "Notice");
//		int result=noticeDAO.selectNoticeCount(conn);
		int result = noticeDAO.count(conn, (Notice)Notice.builder().build(), "sql.notice.selectCount");
		close(conn);
		return result;
	}
	
	public Notice selectNoticeByNo(int noticeNo) {
		Connection conn=getConnection();
		GenericDAOImpl<Notice, Integer> noticeDAO = new GenericDAOImpl<>(conn, "sql.notice.getByNo");
//		Notice n=dao.selectNoticeByNo(conn, noticeNo);
		Notice n = noticeDAO.getById(conn, (Notice)Notice.builder().build(), "sql.notice.getByNo", noticeNo);
		close(conn);
		return n;
	}

	public int insertNotice(Notice n) {
		Connection conn=getConnection();
		GenericDAOImpl<Notice, Notice> noticeDAO = new GenericDAOImpl<>(conn, "Notice");
/*		int result=dao.insertNotice(conn, n);*/
		int result = noticeDAO.addUpdateDelete(conn, (Notice)Notice.builder().build(), "sql.notice.add", n);
		if(result>0) commit(conn);
		else rollback(conn);
		close(conn);
		return result;
	}
	
}
