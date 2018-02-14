import annotations.IgnoreField;
import controllers.FirstController;
import javafx.application.Application;
import javafx.application.Preloader;
import javafx.beans.binding.StringBinding;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import models.Product;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;

/**
 * Created by nomanahmedsheikh on 11/02/18.
 */
public class ProductSaleApp extends Application {

    private static final String APPLICATION_NAME = "Product Sale Application";


    @Override
    public void start(Stage stage) throws Exception {
        startNew(stage);
//        stage.setTitle(APPLICATION_NAME);
//        Group root = new Group();
//        stage.setMaximized(true);
//
//        // Create table view
//        TableView tableView = getTableForScreen();
//
//        // Create hbox above table.
//        HBox hBox = getHBox();
//
//        // Create vbox beside table.
//        VBox vBox = getVBox();
//        root.getChildren().addAll(hBox, tableView, vBox);
//
//        Scene scene = new Scene(root, 1300, 1800);
//        scene.setFill(Color.LIGHTGRAY);
//        stage.setScene(scene);
//        stage.show();
    }

    public void startNew (Stage stage) throws Exception{
        FXMLLoader loader = new FXMLLoader();
        URL resource = this.getClass().getResource("/view/first.fxml");
        loader.setLocation(resource);
        Parent root = null;
        try {
            root = loader.<BorderPane>load();
        } catch (IOException e) {
            throw e;
        }

        final FirstController homeController = loader.getController();
        homeController.MainWindow = stage;

        final Scene scene = new Scene(root, 850, 700);
        stage.setScene(scene);

        stage.show();
    }

    private VBox getVBox() {
        return new VBox();
    }

    private HBox getHBox() {
        return new HBox();
    }

    private TableView getTableForScreen() {
        TableView table = new TableView();
        table.setTranslateX(0);
        table.setTranslateY(200);
//        setUpProductTable();
        table.setEditable(true);
        List<String> fieldNames = getFieldNameWithIgnoreCase(Product.class);
        double sizeColumn = 1300.0/(fieldNames.size()+0.7);
        TableColumn<Product, Boolean> radioColumn = getRadioButtonCellColumn();
        table.getColumns().add(radioColumn);
        for (String name : fieldNames) {
            TableColumn<Product,String> tableColumn = new TableColumn<>(beautifyName(name));
            tableColumn.setMinWidth(sizeColumn);
            tableColumn.setCellValueFactory(new PropertyValueFactory<Product,String>(name));
            table.getColumns().add(tableColumn);
        }
//        populateTableData(table);
        table.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        return table;
    }

    private TableColumn<Product, Boolean> getRadioButtonCellColumn() {
        TableColumn<Product, Boolean> radioColumn = new TableColumn<>("Select");
        radioColumn.setCellValueFactory(new PropertyValueFactory<Product, Boolean>("Select"));
        return radioColumn;
    }

    private static List<String> getFieldNameWithIgnoreCase(Class tClass) {
        List<String> toReturn = new ArrayList<>();
        Field[] fields = tClass.getDeclaredFields();
        for (Field field :fields) {
            Annotation[] annotations = field.getAnnotations();
            boolean toIgnore = Arrays.stream(annotations).anyMatch(annotation -> annotation.annotationType().isAssignableFrom(IgnoreField.class));
            if(!toIgnore){
                toReturn.add(field.getName());
            }
        }
        return toReturn;
    }

    private static String beautifyName(String name) {
        String [] words = name.split("(?=[A-Z])");
        if (words.length == 0) {
            return name;
        }
        StringBuilder stringBuilder = new StringBuilder("");
        for (int i = 0; i < words.length - 1; i++) {
            stringBuilder.append(firstLetterUpperCase(words[i]));
            stringBuilder.append(" ");
        }
        stringBuilder.append(firstLetterUpperCase(words[words.length-1]));
        return stringBuilder.toString();
    }

    private static String firstLetterUpperCase(String str) {
        if (str == null || str.length() == 0) {
            return  str;
        }
        if (!Character.isUpperCase(str.charAt(0))) {
            return str.substring(0,1).toUpperCase() + str.substring(1);
        }
        return str;
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}
