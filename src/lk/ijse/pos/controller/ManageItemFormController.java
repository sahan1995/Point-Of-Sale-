/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.pos.controller;

import com.jfoenix.controls.JFXTextField;
import java.math.BigDecimal;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lk.ijse.pos.business.FactoryBO;
import lk.ijse.pos.business.custom.ItemBOCustom;
import lk.ijse.pos.business.custom.impl.CustomerBOCustomImpl;
import lk.ijse.pos.business.custom.impl.ItemBOCustomImpl;
import lk.ijse.pos.dto.ItemDTO;
import lk.ijse.pos.main.StartUp;
import lk.ijse.pos.view.util.tblmodel.ItemTM;

/**
 *
 * @author ranjith-suranga
 */
public class ManageItemFormController implements Initializable {

    @FXML
    private JFXTextField txtItemCode;
    @FXML
    private JFXTextField txtDescription;
    @FXML
    private JFXTextField txtUnitPrice;
    @FXML
    private JFXTextField txtQty;
    @FXML
    private AnchorPane root;
    @FXML
    private TableView<ItemTM> tblItems;

    private ItemBOCustom itemBOCustom = (ItemBOCustom) FactoryBO.getInstance().getBO(FactoryBO.BOTyps.item);

    private void loadAllItems() {
        try {
            ArrayList<ItemDTO> loadallItem = itemBOCustom.getAllItems();
            ObservableList<ItemTM> Olitems = tblItems.getItems();
            Olitems.removeAll(Olitems);
            for (ItemDTO item : loadallItem) {
                ItemTM items = new ItemTM(item.getCode(), item.getDescription(), item.getUnitPrice(), item.getQtyOnHand());
                Olitems.add(items);

            }

        } catch (Exception e) {
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        tblItems.getColumns().get(0).setStyle("-fx-alignment: center");
        tblItems.getColumns().get(2).setStyle("-fx-alignment: center-right");
        tblItems.getColumns().get(3).setStyle("-fx-alignment: center-right");

        tblItems.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("code"));
        tblItems.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("description"));
        tblItems.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("unitPrice"));
        tblItems.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("qtyOnHand"));
        loadAllItems();
    }

    @FXML
    private void navigateToHome(MouseEvent event) {
        StartUp.navigateToHome(root, (Stage) root.getScene().getWindow());
    }

    @FXML
    private void btnSave_OnAction(ActionEvent event) {

        if (tblItems.getSelectionModel().getSelectedIndex() >= 0) {
            updateItem();
            loadAllItems();
        } else {
            saveItems();
            loadAllItems();
        }

    }

    @FXML
    private void btnDelete_OnAction(ActionEvent event) {
        deleteItem();
        loadAllItems();
    }

    private void saveItems() {

        try {
            ItemDTO item = new ItemDTO(txtItemCode.getText(), txtDescription.getText(), new BigDecimal(txtUnitPrice.getText()), Integer.parseInt(txtQty.getText()));
            boolean saveItem = itemBOCustom.saveItem(item);
            if (saveItem == true) {
                Alert a = new Alert(Alert.AlertType.INFORMATION, "Saved");
                txtDescription.setText("");
                txtItemCode.setText("");
                txtQty.setText("");
                txtUnitPrice.setText("");
                txtItemCode.requestFocus();
                a.show();
            }
        } catch (Exception ex) {
            Logger.getLogger(ManageItemFormController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void updateItem() {
        try {
            ItemDTO item = new ItemDTO(txtItemCode.getText(), txtDescription.getText(), new BigDecimal(txtUnitPrice.getText()), Integer.parseInt(txtQty.getText()));
            boolean update = itemBOCustom.updateItems(item);
            if (update == true) {
                Alert a = new Alert(Alert.AlertType.INFORMATION, "Updated");
                txtDescription.setText("");
                txtItemCode.setText("");
                txtQty.setText("");
                txtUnitPrice.setText("");
                txtItemCode.requestFocus();
                a.show();
            }
        } catch (Exception ex) {
            Logger.getLogger(ManageItemFormController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void deleteItem() {
        try {

            String code = tblItems.getSelectionModel().getSelectedItem().getCode();
            boolean deleteItem = itemBOCustom.deleteItem(code);
            if (deleteItem == true) {
                Alert a = new Alert(Alert.AlertType.INFORMATION, "Deleted");
                a.show();
            }

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @FXML
    private void tblItemMouseClick(MouseEvent event) {
        txtItemCode.setText(tblItems.getSelectionModel().getSelectedItem().getCode());

        txtDescription.setText(tblItems.getSelectionModel().getSelectedItem().getDescription());

        txtUnitPrice.setText(tblItems.getSelectionModel().getSelectedItem().getUnitPrice().toString());

        txtQty.setText(tblItems.getSelectionModel().getSelectedItem().getQtyOnHand() + "");

    }

    @FXML
    private void txtItemCodePress(KeyEvent event) {
    }

}
