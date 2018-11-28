/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.pos.dao.custom.impl;

import java.util.ArrayList;
import lk.ijse.pos.dao.custom.QueryDAO;
import lk.ijse.pos.entity.CustomEntity;
import org.hibernate.Session;

/**
 *
 * @author ranjith-suranga
 */
public class QueryDAOImpl implements QueryDAO {

    private Session session;

    @Override
    public void setSession(Session session) {
        this.session = session;
    }

    @Override
    public ArrayList<CustomEntity> getOrderInformation(String orderId) throws Exception {
        return null;
//        Connection connection = DBConnection.getInstance().getConnection();
//        String sql = "SELECT Customer.name, Orders.date, Orders.id FROM Orders\n"
//                + "INNER JOIN Customer ON Orders.customerId = Customer.id\n"
//                + "WHERE Orders.id = ?";
//        PreparedStatement pstm = connection.prepareStatement(sql);
//        pstm.setObject(1, orderId);
//        ResultSet rst = pstm.executeQuery();
//
//        ArrayList<CustomEntity> alCE = new ArrayList<>();
//
//        while (rst.next()) {
//            alCE.add(new CustomEntity(orderId, rst.getDate(2), rst.getString(1)));
//        }
//        return alCE;
    }

}
