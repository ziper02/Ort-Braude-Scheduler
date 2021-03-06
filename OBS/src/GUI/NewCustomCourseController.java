package GUI;


import java.util.ArrayList;


import com.jfoenix.controls.JFXButton;

import com.jfoenix.controls.JFXTabPane;
import entity.Course;
import entity.Department;
import entity.Schedule;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;
import javafx.scene.input.InputMethodEvent;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.FlowPane;
import org.controlsfx.control.textfield.AutoCompletionBinding;
import org.controlsfx.control.textfield.TextFields;
import util.GUI;
import util.Scanner;

public class NewCustomCourseController {



    @FXML
    private TextField IDcourseTF;

    @FXML
    private JFXButton SearchBTN;

    @FXML
    public JFXTabPane SelectPane;

    @FXML
    public Tab lectureTAB;

    @FXML
    private FlowPane lecturePane;

    @FXML
    public Tab exerciseTAB;

    @FXML
    private FlowPane exercisePane;

    @FXML
    public Tab labTAB;

    @FXML
    private FlowPane labPane;

    @FXML
    private Label CourseName;
    
	@FXML
    private ProgressIndicator PBar;
	
    
    private Scanner st ;
    
    public Course course;
    
    private Boolean byThread;

	private AutoCompletionBinding<Course> autoCompletionBinding ;

	@FXML 
	public void initialize() 
	{
		byThread=false;
		lecturePane.setVgap(8);
		lecturePane.setHgap(4);
		lecturePane.setPrefWrapLength(300); // preferred width = 300
		exercisePane.setVgap(8);
		exercisePane.setHgap(4);
		exercisePane.setPrefWrapLength(300); // preferred width = 300
		labPane.setVgap(8);
		labPane.setHgap(4);
		labPane.setPrefWrapLength(300); // preferred width = 300
		SelectPane.setVisible(false);
		autoCompletionBinding = TextFields.bindAutoCompletion(IDcourseTF, Department.Courselist.values());
		autoCompletionBinding.setOnAutoCompleted(event -> IDcourseTF.setText(event.getCompletion().getID()));
	}


    @FXML
    void ValidTextSearchChanged(InputMethodEvent event) 
    {
    	//util.GUI.IDcourseTFChanged(IDcourseTF);
    }
	
	
    @FXML
    void keyTypedCourseTF(KeyEvent event) 
    {
    	/*if(IDcourseTF.getText().length()>=1)
		{
			if(IDcourseTF.getText().charAt(0)>'0' ||IDcourseTF.getText().charAt(0)<'9')
			{
				for(int i=0;i<IDcourseTF.getText().length();i++)
				{
					if(IDcourseTF.getText().charAt(i)<'0' ||IDcourseTF.getText().charAt(i)>'9')
					{
						StringBuilder sb = new StringBuilder(IDcourseTF.getText());
						sb.deleteCharAt(i);
						IDcourseTF.setText(sb.toString());
					}
				}
				if(IDcourseTF.getText().length()>6)
				{
					IDcourseTF.setText(IDcourseTF.getText().substring(0, IDcourseTF.getText().length() - 1));
				}
			}
		}*/

    }

    @FXML
    void searchCourse(ActionEvent event) 
    {
		if(IDcourseTF.getText().length()==5)
		{
	    	if(Course.couseExist(Integer.parseInt(IDcourseTF.getText())))
	    	{
	    		course=Course.getCourse(Integer.parseInt(IDcourseTF.getText()));
	    		resultSearchCouse(); 
	    	}
	    	else
	    	{
	             st = new Scanner(IDcourseTF.getText());
	             PBar.setVisible(true);
	             SearchBTN.setDisable(true);
	     		 CourseName.setVisible(false);
	     		 SelectPane.setVisible(false);
	     		 IDcourseTF.setDisable(true);
	             st.start();
	             byThread=true;
	            
	    	}
		}
		else
			util.GUI.infoAlert("לצערנו הקורס אינו זמין במערכת שעות,"+"\n"+"בדוק כי הקלדת נכון את קוד הקורס.", "הקורס לא קיים", "המשך");
    }
    
    public void resultSearchCouse()
    {
    	if(byThread)
    	{
    			course=st.getValue();
    			byThread=false;
    	}
    	if(course==null)
    	{
    		SelectPane.setVisible(false);
    		util.GUI.infoAlert("לצערנו הקורס אינו זמין במערכת שעות,"+"\n"+"בדוק כי הקלדת נכון את קוד הקורס.", "הקורס לא קיים", "המשך");
    		CourseName.setVisible(false);
    		SearchBTN.setDisable(false);
    		PBar.setVisible(false);
    		SelectPane.setVisible(false);
    		IDcourseTF.setDisable(false);
    	}
    	else
    	{
    		if(!Course.couseExist(Integer.parseInt(course.getID())))
    		{
    			Course.addCourse(course);
    		}
 			Platform.runLater(()->
 			{ 
 				boolean countLec=false,countEx=false,countLab=false;
				lecturePane.getChildren().clear();
				exercisePane.getChildren().clear();
				labPane.getChildren().clear();
				CourseName.setText(course.getName());
				for(int i=0;i<course.getSchedule().size();i++)
				{
					Schedule schedule=course.get(i);
					JFXButton button=new JFXButton();
					if(schedule.getTwoTimes())
					{
						button.setText("שם המרצה: "+schedule.getLecturer()+"\r\n" +
								"יום: "+schedule.getDay()+"\r\n" +
								"שעת התחלה: "+schedule.getStartTime()+"\r\n" +
								"שעת סיום: "+schedule.getEndTime()+"\r\n" +
								"כיתה: "+schedule.getClasslec()+"\r\n" +
								"מפגש נוסף:\r\n"+
								"יום: "+schedule.getDayTwo()+"\r\n" +
								"שעת התחלה: "+schedule.getStartTimeTwo()+"\r\n" +
								"שעת סיום: "+schedule.getEndTimeTwo()+"\r\n" +
								"כיתה: "+schedule.getClasslecTwo());
								button.setPrefHeight(180);
    			}
    			else
    			{
    				button.setText("שם המרצה: "+schedule.getLecturer()+"\r\n" + 
							"יום: "+schedule.getDay()+"\r\n" + 
							"שעת התחלה: "+schedule.getStartTime()+"\r\n" + 
							"שעת סיום: "+schedule.getEndTime()+"\r\n" + 
							"כיתה: "+schedule.getClasslec());
    						button.setPrefHeight(90);
    			}					
    			button.setPrefWidth(250);
    			button.setAlignment(Pos.CENTER_LEFT);
    			button.setStyle("-fx-font-size:12px;-fx-background-color:#66cdaa;-fx-text-fill:#fff8f8;");
    			button.setUserData(schedule);
    			button.setOnAction(e -> addToGrid(button.getUserData()));
    			if(schedule.getType().equals("הרצאה")||schedule.getType().equals("שו\"ת"))
    			{
    				countLec=true;
    				lecturePane.getChildren().add(button);
    			}
    			else if(schedule.getType().equals("תרגיל"))
    			{
    				countEx=true;
    				exercisePane.getChildren().add(button);
    			}
    			else
    			{
    				countLab=true;
    				labPane.getChildren().add(button);
    			} 				
    		}
    		if(countLec)
    			lectureTAB.setDisable(false);
    		else
    			lectureTAB.setDisable(true);

    		if(countEx)
    			exerciseTAB.setDisable(false);
    		else
    			exerciseTAB.setDisable(true);

    		if(countLab)
    			labTAB.setDisable(false);
    		else
    			labTAB.setDisable(true);

    		SearchBTN.setDisable(false);
    		PBar.setVisible(false);
    		CourseName.setVisible(true);
    		SelectPane.setVisible(true);
    		IDcourseTF.setDisable(false);
 			});
    	}
    }



	static void addToGrid(Object userData)
	{
			Schedule schedule=(Schedule)userData;
			replaceCourse(schedule);
			ArrayList<Schedule> list = Course.getSchduledCourses();
		for (Schedule value : list)
		{
			if ((schedule.getStartTime().getIndex() >= value.getStartTime().getIndex() && schedule.getEndTime().getIndex() <= value.getEndTime().getIndex() && schedule.getDay().getIndex() == value.getDay().getIndex()) ||
					(schedule.getStartTime().getIndex() < value.getStartTime().getIndex() && schedule.getEndTime().getIndex() > value.getStartTime().getIndex() && schedule.getDay().getIndex() == value.getDay().getIndex()) ||
					(schedule.getStartTime().getIndex() > value.getStartTime().getIndex() && schedule.getStartTime().getIndex() < value.getEndTime().getIndex() && schedule.getDay().getIndex() == value.getDay().getIndex())) {
				GUI.infoAlert("קיימת התנגשות במערכת", "התנגשות", "חזור");
				return;
			}
			if (value.getTwoTimes()) {
				if ((schedule.getStartTime().getIndex() >= value.getStartTimeTwo().getIndex() && schedule.getEndTime().getIndex() <= value.getEndTimeTwo().getIndex() && schedule.getDay().getIndex() == value.getDayTwo().getIndex()) ||
						(schedule.getStartTime().getIndex() < value.getStartTimeTwo().getIndex() && schedule.getEndTime().getIndex() > value.getStartTimeTwo().getIndex() && schedule.getDay().getIndex() == value.getDayTwo().getIndex()) ||
						(schedule.getStartTime().getIndex() > value.getStartTimeTwo().getIndex() && schedule.getStartTime().getIndex() < value.getEndTimeTwo().getIndex() && schedule.getDay().getIndex() == value.getDayTwo().getIndex())) {
					GUI.infoAlert("קיימת התנגשות במערכת", "התנגשות", "חזור");
					return;
				}
			}
			if (schedule.getTwoTimes()) {
				if ((schedule.getStartTimeTwo().getIndex() >= value.getStartTime().getIndex() && schedule.getEndTimeTwo().getIndex() <= value.getEndTime().getIndex() && schedule.getDayTwo().getIndex() == value.getDay().getIndex()) ||
						(schedule.getStartTimeTwo().getIndex() < value.getStartTime().getIndex() && schedule.getEndTimeTwo().getIndex() > value.getStartTime().getIndex() && schedule.getDayTwo().getIndex() == value.getDay().getIndex()) ||
						(schedule.getStartTimeTwo().getIndex() > value.getStartTime().getIndex() && schedule.getStartTimeTwo().getIndex() < value.getEndTime().getIndex() && schedule.getDayTwo().getIndex() == value.getDay().getIndex())) {
					GUI.infoAlert("קיימת התנגשות במערכת", "התנגשות", "חזור");
					return;
				}
				if (value.getTwoTimes()) {
					if ((schedule.getStartTimeTwo().getIndex() >= value.getStartTimeTwo().getIndex() && schedule.getEndTimeTwo().getIndex() <= value.getEndTimeTwo().getIndex() && schedule.getDayTwo().getIndex() == value.getDayTwo().getIndex()) ||
							(schedule.getStartTimeTwo().getIndex() < value.getStartTimeTwo().getIndex() && schedule.getEndTimeTwo().getIndex() > value.getStartTimeTwo().getIndex() && schedule.getDayTwo().getIndex() == value.getDayTwo().getIndex()) ||
							(schedule.getStartTimeTwo().getIndex() > value.getStartTimeTwo().getIndex() && schedule.getStartTimeTwo().getIndex() < value.getEndTimeTwo().getIndex() && schedule.getDayTwo().getIndex() == value.getDayTwo().getIndex())) {
						GUI.infoAlert("קיימת התנגשות במערכת", "התנגשות", "חזור");
						return;
					}
				}
			}
		}
		Platform.runLater(()->
		{ 
			if (schedule.getSplited()) 
			{ //If there is a break
				Main.scheduleController.getScheduleGrid().add(schedule.getGridPaneVBox1(), schedule.getDay().getIndex(), schedule.getStartTime().getIndex(), 1, 5 - schedule.getStartTime().getIndex());
				if (schedule.getDay().getIndex() == 4)
				{//if tuesday 
					Main.scheduleController.getScheduleGrid().add(schedule.getGridPaneVBox2(), schedule.getDay().getIndex(), 8, 1, schedule.getEndTime().getIndex() - 8);
				}
				else 
				{
					Main.scheduleController.getScheduleGrid().add(schedule.getGridPaneVBox2(), schedule.getDay().getIndex(), 6, 1, schedule.getEndTime().getIndex() - 6);
				}
			}
			else 
				Main.scheduleController.getScheduleGrid().add(schedule.getGridPaneVBox1(), schedule.getDay().getIndex(), schedule.getStartTime().getIndex(), 1, schedule.getEndTime().getIndex() - schedule.getStartTime().getIndex());
			if(schedule.getTwoTimes())
			{
				if (schedule.getSplitedTwo()) 
				{ //If there is a break
					Main.scheduleController.getScheduleGrid().add(schedule.getGridPaneVBox3(), schedule.getDayTwo().getIndex(), schedule.getStartTimeTwo().getIndex(), 1, 5 - schedule.getStartTimeTwo().getIndex());
					if (schedule.getDay().getIndex() == 4)
					{//if tuesday 
						Main.scheduleController.getScheduleGrid().add(schedule.getGridPaneVBox4(), schedule.getDayTwo().getIndex(), 8, 1, schedule.getEndTimeTwo().getIndex() - 8);
					}
					else 
					{
						Main.scheduleController.getScheduleGrid().add(schedule.getGridPaneVBox4(), schedule.getDayTwo().getIndex(), 6, 1, schedule.getEndTimeTwo().getIndex() - 6);
					}
				}
				else 
					Main.scheduleController.getScheduleGrid().add(schedule.getGridPaneVBox3(), schedule.getDayTwo().getIndex(), schedule.getStartTimeTwo().getIndex(), 1, schedule.getEndTimeTwo().getIndex() - schedule.getStartTimeTwo().getIndex());
			}
			
			schedule.setSelected(true);
			
		});
		
	}

	
	
	private static void replaceCourse(Schedule schedule)
	{
		ArrayList<Schedule> list = Course.getSchduledCourses();
		for (Schedule value : list)
		{
			if (value.getCourse().getID().equals(schedule.getCourse().getID())) {
				if (value.getType().equals(schedule.getType())) {
					Main.scheduleController.getScheduleGrid().getChildren().remove(value.getGridPaneVBox1());
					if (value.getSplited()) {
						Main.scheduleController.getScheduleGrid().getChildren().remove(value.getGridPaneVBox2());
					}
					if (value.getTwoTimes()) {
						Main.scheduleController.getScheduleGrid().getChildren().remove(value.getGridPaneVBox3());
						if (value.getSplitedTwo()) {
							Main.scheduleController.getScheduleGrid().getChildren().remove(value.getGridPaneVBox4());
						}
					}
					value.setSelected(false);
					return;
				}
			}
		}
	}
	@FXML
    
	void makeSearchWithEnterBtn(KeyEvent event)
    {
    	if(event.getCode().equals(KeyCode.ENTER))
			searchCourse(new ActionEvent());
    }
	


}
