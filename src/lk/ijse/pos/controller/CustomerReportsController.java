/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.pos.controller;

import com.jfoenix.controls.JFXButton;
import java.io.InputStream;
import java.net.URL;
import java.util.HashMap;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lk.ijse.pos.db.DBConnection;
import lk.ijse.pos.main.StartUp;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;

/**
 * FXML Controller class
 *
 * @author sahanr
 */
public class CustomerReportsController implements Initializable {

    @FXML
    private AnchorPane root;
    @FXML
    private JFXButton btnAllCustomer;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void navigateToHome(MouseEvent event) {
        StartUp.navigateToHome(root, (Stage) this.root.getScene().getWindow());
    }

    @FXML
    private void btnAllCustomerOnClick(ActionEvent event) throws Exception {
                                   

                    HashMap<String, Object> params = new HashMap<>();

                    InputStream resourceAsStream = getClass().getResourceAsStream("/lk/ijse/pos/reports/AllCustomers.jasper");
                    JasperPrint jasperPrint = JasperFillManager.fillReport(resourceAsStream, null,DBConnection.getInstance().getConnection());
                    JasperViewer jasperViewer = new JasperViewer(jasperPrint,false);
                    jasperViewer.setVisible(true);
    }
    
}
