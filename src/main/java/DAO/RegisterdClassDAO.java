package DAO;

import Bean.RegisterdClass;
import Bean.StudyClass;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RegisterdClassDAO {
    public static boolean addRegisterdClass(Connection conn, RegisterdClass rc){
        PreparedStatement ptmt = null;
        String sql ="INSERT INTO lophocdangky(giangvien_id,lophoc_id) value(?,?)";

        try {
            ptmt = conn.prepareStatement(sql);
            int giangvien_id = rc.getGiaovien_id();
            int lophoc_id= rc.getClass_id();

            ptmt.setInt(1,giangvien_id);
            ptmt.setInt(2,lophoc_id);

            int check =ptmt.executeUpdate();
            if(check != 0){
                return true;
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }


        return false;
    }


    public static List<StudyClass> listRegisterdClass(Connection conn,String giangvien_id){
        List<StudyClass>list =new ArrayList<StudyClass>();

        PreparedStatement ptmt = null;

        String sql ="select lophoc.id,tenlop,tenmonhoc,sotinchi,sokip,sotietlythuyet,sotietthuchanh,thoigian from lophoc inner join lophocdangky on lophoc.id = lophocdangky.lophoc_id  and lophocdangky.giangvien_id = ?;";

        try {
            ptmt= conn.prepareStatement(sql);
            ptmt.setInt(1,Integer.parseInt(giangvien_id));
            ResultSet rs = ptmt.executeQuery();

            while (rs.next()){
                StudyClass sc = new StudyClass();
                int id = rs.getInt("id");
                String tenlop = rs.getString("tenlop");
                String tenmonhoc =rs.getString("tenmonhoc");
                int sotin = rs.getInt("sotinchi");
                int sokip = rs.getInt("sokip");
                int lythuyet = rs.getInt("sotietlythuyet");
                int thuchanh = rs.getInt("sotietthuchanh");
                String thoigian = rs.getString("thoigian");

                sc.setId(id);
                sc.setTenlop(tenlop);
                sc.setTenmonhoc(tenmonhoc);
                sc.setSotin(sotin);
                sc.setSokip(sokip);
                sc.setSokiplythuyet(lythuyet);
                sc.setSokipthuchanh(thuchanh);
                sc.setThoigian(thoigian);
                list.add(sc);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }


        return list;
    }
}
