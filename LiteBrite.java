/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import javafx.application.Application;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author narayan
 */
public class LiteBrite extends Application {
	private static ColorPicker colorPicker = new ColorPicker();
	
    @Override
    public void start(final Stage stage) throws Exception {
        int rows = 50;
        int columns = 50;

        stage.setTitle("Enjoy your game");

        HBox rootPane = new HBox();
        Scene scene = new Scene(rootPane, (columns * 10)+235, (rows * 10)+20);
        
        GridPane grid = new GridPane();
        
        grid.getStyleClass().add("game-grid");

        for(int i = 0; i < columns; i++) {
            ColumnConstraints column = new ColumnConstraints(10);
            grid.getColumnConstraints().add(column);
        }

        for(int i = 0; i < rows; i++) {
            RowConstraints row = new RowConstraints(10);
            grid.getRowConstraints().add(row);
        }
        
        
        for (int i = 0; i < columns; i++) {
            for (int j = 0; j < rows; j++) {
                Pane pane = new Pane(); 
                    pane.setOnMouseReleased(e -> {
                    	if(pane.getChildren().isEmpty())
                    	{
                    		pane.getChildren().add(Anims.getAtoms(1));
                    	}
                    	
                    	else
                    	{
                    		pane.getChildren().clear();
                    	}
                    });
                pane.getStyleClass().add("game-grid-cell");
                if (i == 0) {
                    pane.getStyleClass().add("first-column");
                }
                if (j == 0) {
                    pane.getStyleClass().add("first-row");
                }
                grid.add(pane, i, j);
            }
        }

        HBox hbox = new HBox();
        Button b = new Button("Reset board");
        hbox.getChildren().add(b);
        b.setOnMouseClicked(new EventHandler<Event>() {
        	public void handle(Event event) {
        		grid.getChildren().clear();
        		 for (int i = 0; i < columns; i++) 
        		 {
        	            for (int j = 0; j < rows; j++) 
        	            {
        	                Pane pane = new Pane(); 
        	                    pane.setOnMouseReleased(e -> {
        	                    	if(pane.getChildren().isEmpty())
        	                    	{
        	                    		pane.getChildren().add(Anims.getAtoms(1));
        	                    	}
        	                    	
        	                    	else
        	                    	{
        	                    		pane.getChildren().clear();
        	                    	}
        	                    });
        	                pane.getStyleClass().add("game-grid-cell");
        	                if (i == 0) {
        	                    pane.getStyleClass().add("first-column");
        	                }
        	                if (j == 0) {
        	                    pane.getStyleClass().add("first-row");
        	                }
        	                grid.add(pane, i, j);
        	            }
        	     }
        	};
        });
        

        scene.getStylesheets().add(LiteBrite.class.getResource("resources/game.css").toExternalForm());  
        rootPane.getChildren().addAll(colorPicker, grid, hbox);
        stage.setScene(scene);
        stage.show();
    }

    public static class Anims {

        public static Node getAtoms(final int number) {
            //TODO: Add code to create a colored 
        	Rectangle rectangle = new Rectangle(9, 9);
        	rectangle.setFill(colorPicker.getValue());
        	
            return rectangle;
        }

    }

    public static void main(final String[] arguments) {
        Application.launch(arguments);
    }
    
}
