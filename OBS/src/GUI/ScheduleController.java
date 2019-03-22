package GUI;

import java.io.IOException;
import java.net.URL;

import com.jfoenix.controls.JFXButton;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

public class ScheduleController {

    @FXML
    private Pane RightPane;

    @FXML
    private JFXButton CreateCustomSchedule;

    @FXML
    private JFXButton CreateAutomaticSchedule;

    @FXML
    private Pane MiddlePane;

    @FXML
    private Pane LeftPane;

    @FXML
    private GridPane ScheduleGrid;

    @FXML
    void LoadNewCusomCourseController(ActionEvent event) 
    {
    	Pane newLoadedPane;
		try 
		{
			newLoadedPane = FXMLLoader.load(getClass().getResource("/gui/NewCustomCourse.fxml"));
			MiddlePane.getChildren().add(newLoadedPane);
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
    	
    }

}