package controller;

import domain.BTree;
import domain.BTreeNode;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;

public class TransversalTourController {

    @FXML
    private Button btnInOrder;

    @FXML
    private Button btnPostOrder;

    @FXML
    private Button btnPreOrder;

    @FXML
    private Button btnRandomize;

    @FXML
    private Label tourNameLabel;
    private double dVertical = 50;
    private int counter = 1;
    @FXML
    private Pane treePane;

    private BTree btree = new BTree();

    @FXML
    public void initialize() {
        fill();
    }
    public void fill() {
        int size =util.Utility.random(6, 35);
        for (int i = 0; i < size; i++) {
            btree.add("" + util.Utility.random(0, 50));
            displayTree();
        }
    }
    public void displayTree() {
        if (btree.getRoot() != null) {
            displayTree(btree.getRoot(), treePane.getPrefWidth() / 2, dVertical, treePane.getPrefWidth() / 4);
        }
    }

    private void displayTree(BTreeNode root, double x, double y, double dHorizontal) {
        if (root.left != null) {
            treePane.getChildren().add(new Line(x - dHorizontal, y + dVertical, x, y));
            displayTree(root.left, x - dHorizontal, y + dVertical, dHorizontal / 2);
        }
        if (root.right != null) {
            treePane.getChildren().add(new Line(x + dHorizontal, y + dVertical, x, y));
            displayTree(root.right, x + dHorizontal, y + dVertical, dHorizontal / 2);
        }
        Circle c = new Circle(x, y, 15);
        c.setStroke(Color.BLACK);
        c.setFill(Color.LIGHTCORAL);
        treePane.getChildren().addAll(c, new Text(x - 4, y + 4, (String) root.data));
    }

    public void displayInOrder() {
        counter = 1;
        if (btree.getRoot() != null) {
            displayInOrder(btree.getRoot(), treePane.getPrefWidth() / 2, dVertical, treePane.getPrefWidth() / 4);
        }
    }

    private void displayInOrder(BTreeNode node, double x, double y, double dHorizontal) {
        if (node != null) {
            displayInOrder(node.left, x - dHorizontal, y + dVertical, dHorizontal / 2);
            treePane.getChildren().addAll(new Text(x - 5, y + 30, "" + counter));
            counter++;
            displayInOrder(node.right, x +dHorizontal, y + dVertical, dHorizontal / 2);
        }
    }

    public void displayBSTPreOrder() {
        counter = 1;
        if (btree.getRoot() != null) {
            displayBSTPreOrder(btree.getRoot(), treePane.getPrefWidth() / 2, dVertical, treePane.getPrefWidth() / 4);
        }
    }
    private void displayBSTPreOrder(BTreeNode node, double x, double y, double dHorizontal) {
        if (node != null) {
            treePane.getChildren().addAll(new Text(x - 5, y + 30, "" + counter));
            counter++;
            displayBSTPreOrder(node.left, x - dHorizontal, y + dVertical, dHorizontal / 2);
            displayBSTPreOrder(node.right, x + dHorizontal, y + dVertical, dHorizontal / 2);

        }
    }
    public void displayBSTPostOrder() {
        counter = 1;
        if (btree.getRoot() != null) {
            displayBSTPostOrder(btree.getRoot(), treePane.getPrefWidth() / 2, dVertical, treePane.getPrefWidth() / 4);
        }
    }

    private void displayBSTPostOrder(BTreeNode node, double x, double y, double dHorizontal) {
        if (node != null) {
            displayBSTPostOrder(node.left, x - dHorizontal, y + dVertical, dHorizontal / 2);
            displayBSTPostOrder(node.right, x + dHorizontal, y + dVertical, dHorizontal / 2);
            treePane.getChildren().addAll(new Text(x - 5, y + 30, "" + counter));
            counter++;
        }
    }

    @FXML
    void btnInOrder(ActionEvent event) {
        treePane.getChildren().clear();
        displayTree();
        tourNameLabel.setText("In Order Transversal Tour (L-N-R)");
        displayInOrder();
    }

    @FXML
    void btnPostOrder(ActionEvent event) {
        treePane.getChildren().clear();
        displayTree();
        tourNameLabel.setText("Post Order Transversal Tour (L-R-N)");
        displayBSTPostOrder();
    }

    @FXML
    void btnPreOrder(ActionEvent event) {
        treePane.getChildren().clear();
        displayTree();
        tourNameLabel.setText("Pre Order Transversal Tour (N-L-R)");
        displayBSTPreOrder();
    }

    @FXML
    void btnRandomize(ActionEvent event) {
        tourNameLabel.setText("");
        treePane.getChildren().clear(); // Clear the pane
        btree.clear();
        fill();
        int random= util.Utility.random(1,3);
        if (random==1){btnPreOrder(event);}
        if (random==2){btnInOrder(event);}
        if (random==3){btnPostOrder(event);}
    }


}
