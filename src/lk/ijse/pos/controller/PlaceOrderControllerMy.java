/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.pos.controller;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import java.math.BigDecimal;
import java.net.URL;
import java.sql.Array;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lk.ijse.pos.business.FactoryBO;
import lk.ijse.pos.business.custom.AddOrderBOCustom;
import lk.ijse.pos.business.custom.CustomerBOCustom;
import lk.ijse.pos.business.custom.ItemBOCustom;
import lk.ijse.pos.business.custom.ItemDetailBOCustom;
import lk.ijse.pos.business.custom.OrderBOCustom;
import lk.ijse.pos.dto.CustomerDTO;
import lk.ijse.pos.dto.ItemDTO;
import lk.ijse.pos.dto.ItemDetailDTO;
import lk.ijse.pos.dto.OrdersDTO;
import lk.ijse.pos.main.StartUp;
import lk.ijse.pos.view.util.tblmodel.OrderTM;

/**
 * FXML Controller class
 *
 * @author Sahan Rajakaruna
 */
public class PlaceOrderControllerMy implements Initializable {

    @FXML
    private Label lblStock;
    @FXML
    private Label lblUnitPrice;
    @FXML
    private Label lblDescript;
    @FXML
    private Label lblCustName;
    @FXML
    private JFXTextField txtOrderId;
    @FXML
    private JFXDatePicker dtpOrderDate;
    @FXML
    private JFXComboBox<String> cmbCustId;
    @FXML
    private JFXComboBox<String> cmbItemCode;
    @FXML
    private JFXTextField txtQty;
    @FXML
    private TableView<OrderTM> tblOrder;
    @FXML
    private Label lblTotal;
    @FXML
    private AnchorPane root;

    private ItemDetailBOCustom itemdetailBO;

    private AddOrderBOCustom addOrderBOCustom;
    private OrderBOCustom orderBo;
    private boolean result = false;
    private ArrayList<OrderTM> orderTm = new ArrayList<>();

    /**
     * Initializes the controller class.
     */
    public PlaceOrderControllerMy() {

        this.itemdetailBO = (ItemDetailBOCustom) FactoryBO.getInstance().getBO(FactoryBO.BOTyps.itemdetail);
        this.orderBo = (OrderBOCustom) FactoryBO.getInstance().getBO(FactoryBO.BOTyps.order);
        this.addOrderBOCustom = (AddOrderBOCustom) FactoryBO.getInstance().getBO(FactoryBO.BOTyps.addorder);

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        tblOrder.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("code"));
        tblOrder.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("desc"));
        tblOrder.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("unitPrice"));
        tblOrder.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("qty"));
        tblOrder.getColumns().get(4).setCellValueFactory(new PropertyValueFactory<>("total"));

        getCutomerId();
        getItemCodes();
    }

    @FXML
    private void cmbOnAction(ActionEvent event) {

        getCustomername(cmbCustId.getValue());
    }

    @FXML
    private void cmbCodeOnAction(ActionEvent event) throws Exception {
        getItemName(cmbItemCode.getValue());
    }

    @FXML
    private void btnAddOnAction(ActionEvent event) {
        OrdetToTable();

    }

    @FXML
    private void btnRemoveAction(ActionEvent event) {
        
        OrderTM selectedItem = tblOrder.getSelectionModel().getSelectedItem();
        orderTm.remove(selectedItem);
        tblOrder.getItems().remove(tblOrder.getSelectionModel().getSelectedItem());
        tblOrder.getSelectionModel().clearSelection();
        calculatTotal();
        
    }

    @FXML
    private void btnPlaceOrderOnAction(ActionEvent event) throws Exception {

        result = addOrderBOCustom.addOrder(new OrdersDTO(txtOrderId.getText(), cmbCustId.getValue(), (Date.valueOf(dtpOrderDate.getValue()))), orderTm);

        if (result) {
            new Alert(Alert.AlertType.INFORMATION, "Done").show();
            txtOrderId.setText("");
            txtQty.setText("");
            lblCustName.setText("");
            lblDescript.setText("");
            lblStock.setText("");
            lblUnitPrice.setText("");
            lblTotal.setText("");
            txtOrderId.requestFocus();
        }
    }

    @FXML
    private void onclick(ActionEvent event) {
    }

    @FXML
    private void navigateToHome(MouseEvent event) {
        StartUp.navigateToHome(root, (Stage) this.root.getScene().getWindow());
    }

    private CustomerBOCustom customer = (CustomerBOCustom) FactoryBO.getInstance().getBO(FactoryBO.BOTyps.customer);
    private ItemBOCustom item = (ItemBOCustom) FactoryBO.getInstance().getBO(FactoryBO.BOTyps.item);

    public void getCutomerId() {
        try {
            ArrayList<CustomerDTO> allCustomers = customer.getAllCustomers();
            ArrayList<String> customerID = new ArrayList<>();
            for (CustomerDTO allCustomer : allCustomers) {

                customerID.add(allCustomer.getId());
            }

            cmbCustId.setItems(FXCollections.observableList(customerID));

        } catch (Exception e) {
            System.out.println(e);

        }

    }

    public void getCustomername(String id) {
        try {
            CustomerDTO findByid = customer.findByid(id);
            lblCustName.setText(findByid.getName());

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    private void getItemCodes() {
        try {
            ArrayList<ItemDTO> allItems = item.getAllItems();
            ArrayList<String> allCodes = new ArrayList<>();
            for (ItemDTO allItem : allItems) {

                allCodes.add(allItem.getCode());
            }

            cmbItemCode.setItems(FXCollections.observableArrayList(allCodes));
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    private void getItemName(String code) throws Exception {

        ItemDTO findByid = item.findByid(code);
        lblDescript.setText(findByid.getDescription());
        lblStock.setText(String.valueOf(findByid.getQtyOnHand()));
        lblUnitPrice.setText(findByid.getUnitPrice().toString());

    }

    private boolean find = false;

    private void OrdetToTable() {

        if (Integer.parseInt(txtQty.getText()) > Integer.parseInt(lblStock.getText())) {
            new Alert(Alert.AlertType.ERROR, "Sorry ! Qty is Greater than Stock").show();
            return;
        }


        for (OrderTM orderTMs : orderTm) {

            if (orderTMs.getCode() == cmbItemCode.getValue()) {
                orderTMs.setQty(orderTMs.getQty() + Integer.parseInt(txtQty.getText()));
                
                 
                BigDecimal unitPrice = new BigDecimal(lblUnitPrice.getText());  
                BigDecimal qty = new BigDecimal(orderTMs.getQty());
                orderTMs.setTotal(unitPrice.multiply(qty));
                tblOrder.getItems().clear();
                tblOrder.setItems(FXCollections.observableArrayList(orderTm));
                calculatTotal();
                return;

            }
            }
        BigDecimal total = new BigDecimal(lblUnitPrice.getText()).multiply(new BigDecimal(txtQty.getText()));
        OrderTM orderTM = new OrderTM(txtOrderId.getText(), cmbItemCode.getValue(), lblDescript.getText(), new BigDecimal(lblUnitPrice.getText()), total, Integer.parseInt(txtQty.getText()));
        orderTm.add(orderTM);
        tblOrder.setItems(FXCollections.observableArrayList(orderTm));
         calculatTotal();
        lblDescript.setText("");
        lblStock.setText("");
        lblUnitPrice.setText("");
        txtQty.setText("");
        txtQty.requestFocus();
    }
    private void calculatTotal(){
        BigDecimal fulltotal = new BigDecimal(0);
        for (OrderTM orderTM : orderTm) {
            
            fulltotal = fulltotal.add(orderTM.getTotal());
            
            
        }
        lblTotal.setText("Rs " + fulltotal);
    }
    
}
