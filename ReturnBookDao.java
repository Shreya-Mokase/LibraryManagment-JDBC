import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ReturnBookDao {
	
	public static boolean checkBook(int id){
	boolean status=false;
	try{
		Connection con=DB.getConnection();
		PreparedStatement ps=con.prepareStatement("select * from issuebooks where id=?");
		ps.setInt(1,id);
	    	ResultSet rs=ps.executeQuery();
		status=rs.next();
		con.close();
	}catch(Exception e){System.out.println(e);}
	return status;
}
	public static int delete(int id,int studentid){
		int status=0;
		try{
			Connection con=DB.getConnection();
			
			//status=updatebook(id); //updating quantity and issue
			
			//if(status>0){
			PreparedStatement ps=con.prepareStatement("delete from issuebooks where id=? and studentid=?");
			ps.setInt(1,id);
			ps.setInt(2,studentid);
			status=ps.executeUpdate();
			//}
			
			con.close();
		}catch(Exception e){System.out.println(e);}
		return status;
	}
	
}
