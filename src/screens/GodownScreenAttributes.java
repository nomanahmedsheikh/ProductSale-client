//package screens;
//
//import javafx.event.ActionEvent;
//import javafx.event.EventHandler;
//import javafx.scene.control.Button;
//import javafx.scene.control.TableView;
//import models.Product;
//
//import java.util.ArrayList;
//import java.util.List;
//
///**
// * Created by nomanahmedsheikh on 11/02/18.
// */
//
//public class GodownScreenAttributes extends AbstractScreenAttributes<Product> {
//    @Override
//    protected void populateTableData(TableView tableView) {
//        super.populateTableData(tableView);
//    }
//
//    @Override
//    protected List<Button> addAdditionalButtonsInHBox() {
//        final Button addButton = new Button("Add New Product");
//        addButton.setOnAction(new EventHandler<ActionEvent>() {
//            @Override
//            public void handle(ActionEvent actionEvent) {
//                AddProductScreen addProduct = new AddProductScreen();
//                addProduct.start();
//            }
//        });
//        List<Button> toAdd = new ArrayList<>();
//        toAdd.add(addButton);
//        return toAdd;
//    }
//
//    public GodownScreenAttributes(Class<Product> productDetailsClass, LookupService<Product> lookupService) {
//        super(productDetailsClass, lookupService);
//    }
//}