package GUI;

import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import entity.Course;
import entity.Department;
import entity.Semester;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Main extends Application
{
	public static  ScheduleController scheduleController;
	public static  MultiSelectionController mutliSelectionController;
	public static Stage primaryStage;
	  public void start(Stage primaryStage) throws IOException 
	  {
		  	Main.primaryStage=primaryStage;
		  	FXMLLoader loader=new FXMLLoader(getClass().getResource("/GUI/LoadingPanel.fxml")); // load the FXML file
	        Parent root = (Parent) loader.load();
		    Scene scene=new Scene(root, 282, 341);
		    primaryStage.getIcons().add(new Image(getClass().getResourceAsStream("/icons/date_and_time_clock-512.png")));
		    primaryStage.setScene( scene );
		    primaryStage.setTitle( "Schedule" );
		    primaryStage.initStyle(StageStyle.UNDECORATED);
		    primaryStage.setOnCloseRequest(e->
			{
				try
				{
					Runtime.getRuntime().exec("taskkill /F /IM chromedriver.exe");
				}
				catch (IOException ex)
				{
					util.GUI.alertErrorWithOptionWithExit("Failed to kill chromedriver.\nReason:not windows.","kill chromedriver error","exit");
					ex.printStackTrace();
				}
				System.exit(0);
			});
		    primaryStage.show();
	  }

	public static void main(String[] args) 
	{
		createDataBaseDepartments();
		launch(args);
	}

	private static void createDataBaseDepartments()
	{

        ExecutorService pool = Executors.newFixedThreadPool(15);
        pool.execute(()->loadSoftware());
        pool.execute(()->loadMech());
        pool.execute(()->loadInus());
        pool.execute(()->loadInfor());
        pool.execute(()->loadBio());
        pool.execute(()->loadMath());
        pool.execute(()->loadPhy());
        pool.shutdown();
        try
        {
            pool.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
        }
        catch (InterruptedException e)
        {
        }
        for(Department d: Department.department)
            for(Semester s: d.getSemesters())
                for(Course c: s.getCourses())
                    Department.Courselist.add(c);
	}


	private static void loadSoftware()
	{
		Department d=new Department("הנדסת תוכנה");
		Department.department.add(d);
		Semester s=new Semester("סמסטר א'",false);
		Course c=new Course();
		c.setName("אנגלית בסיסי");
		c.setID("11063");
		s.add(c);
		c=new Course();
		c.setName("אנגלית מתקדמים א'");
		c.setID("11064");
		s.add(c);
		c=new Course();
		c.setName("מבוא לפיזיקה אקדמית");
		c.setID("11179");
		s.add(c);
		c=new Course();
		c.setName("מיומנות למידה");
		c.setID("11947");
		s.add(c);
		c=new Course();
		c.setName("חדווא 1מ");
		c.setID("11004");
		s.add(c);
		c=new Course();
		c.setName("אלגברה 1מח");
		c.setID("11002");
		s.add(c);
		c=new Course();
		c.setName("מערכות ספרתיות");
		c.setID("61740");
		s.add(c);
		c=new Course();
		c.setName("מבוא למדעי המחשב");
		c.setID("61741");
		s.add(c);
		c=new Course();
		c.setName("אוריינות בעברית");
		c.setID("11351");
		s.add(c);
		d.add(s);

		s=new Semester("סמסטר ב'",false);
		c=new Course();
		c.setName("חדווא 2מ");
		c.setID("11006");
		s.add(c);
		c=new Course();
		c.setName("אלגברה 2מח");
		c.setID("11020");
		s.add(c);
		c=new Course();
		c.setName("אנגלית מתקדמים ב'");
		c.setID("11060");
		s.add(c);
		c=new Course();
		c.setName("מתמטיקה דיסקרטית 1");
		c.setID("61743");
		s.add(c);
		c=new Course();
		c.setName("ארגון ותכנון המחשב");
		c.setID("61744");
		s.add(c);
		c=new Course();
		c.setName("מבוא לתכנות מערכות");
		c.setID("61745");
		s.add(c);
		d.add(s);


		s=new Semester("סמסטר ג'",false);
		c=new Course();
		c.setName("טורים,התמרות ומשוואת דיפרנציאליות");
		c.setID("11129");
		s.add(c);
		c=new Course();
		c.setName("לוגיקה");
		c.setID("61746");
		s.add(c);
		c=new Course();
		c.setName("מבני נתונים");
		c.setID("61747");
		s.add(c);
		c=new Course();
		c.setName("ארכיטקטורה ומבנה המחשב");
		c.setID("61748");
		s.add(c);
		c=new Course();
		c.setName("מתמתיקה דיסקרטית 2");
		c.setID("61749");
		s.add(c);
		c=new Course();
		c.setName("מבוא להנדסת תוכנה");
		c.setID("61750");
		s.add(c);
		d.add(s);

		s=new Semester("סמסטר ד'",false);
		c=new Course();
		c.setName("מכניקה להנדסת תוכנה");
		c.setID("11158");
		s.add(c);
		c=new Course();
		c.setName("תכנות מונחה עצמים");
		c.setID("61751");
		s.add(c);
		c=new Course();
		c.setName("מערכות הפעלה");
		c.setID("61752");
		s.add(c);
		c=new Course();
		c.setName("אלגורתמים");
		c.setID("61753");
		s.add(c);
		c=new Course();
		c.setName("מערכות מסדי נתונים מ");
		c.setID("61755");
		s.add(c);
		d.add(s);

		s=new Semester("סמסטר ה'",false);
		c=new Course();
		c.setName("אנגלית טכנית יישומית - תכנה");
		c.setID("11069");
		s.add(c);
		c=new Course();
		c.setName("שיטות הנדסיות לפיתוח תכנה");
		c.setID("61756");
		s.add(c);
		c=new Course();
		c.setName("מבוא לבדיקות תוכנה");
		c.setID("61757");
		s.add(c);
		c=new Course();
		c.setName("אוטומטים וחישוביות");
		c.setID("61759");
		s.add(c);
		c=new Course();
		c.setName("הסתברות להנדסת תוכנה");
		c.setID("61760");
		s.add(c);
		c=new Course();
		c.setName("ממשק אדם מחשב");
		c.setID("61769");
		s.add(c);
		d.add(s);

		s=new Semester("סמסטר ו'",false);
		c=new Course();
		c.setName("חשמל ומגנטיות להנדסת תכנה");
		c.setID("11159");
		s.add(c);
		c=new Course();
		c.setName("מבנה מערכות הפעלה וזמן אמת");
		c.setID("61758");
		s.add(c);
		c=new Course();
		c.setName("כריית נתונים ומערכות לומדות");
		c.setID("61761");
		s.add(c);
		c=new Course();
		c.setName("תורת הקומפלציה");
		c.setID("61763");
		s.add(c);
		c=new Course();
		c.setName("גרפיקה ממוחשבת");
		c.setID("61764");
		s.add(c);
		d.add(s);

		s=new Semester("סמסטר ז'",false);
		c=new Course();
		c.setName("רשתות מחשבים");
		c.setID("61765");
		s.add(c);
		c=new Course();
		c.setName("פרויקט בהנדסת תכנה שלב א'");
		c.setID("61766");
		s.add(c);
		c=new Course();
		c.setName("אבטחת מידע וקריפטולוגיה");
		c.setID("61767");
		s.add(c);
		c=new Course();
		c.setName("תכנות מקבילי ומבוזר וטכנולוגית ענן");
		c.setID("61768");
		s.add(c);
		c=new Course();
		c.setName("ממשק אדם מחשב מ'");
		c.setID("61770");
		s.add(c);
		d.add(s);

		s=new Semester("סמסטר ח'",false);
		c=new Course();
		c.setName("פרויקט בהנדסת תכנה שלב ב'");
		c.setID("61765");
		s.add(c);
		d.add(s);


		s=new Semester("אשכול מדעים",true);
		c=new Course();
		c.setName("פיזיקה מודרנית");
		c.setID("11198");
		s.add(c);
		c=new Course();
		c.setName("מבוא לביולוגיה מולקולרית");
		c.setID("41942");
		s.add(c);
		c=new Course();
		c.setName("תורת המשחקים");
		c.setID("61957");
		s.add(c);
		c=new Course();
		c.setName("תורת המידע");
		c.setID("61958");
		s.add(c);
		c=new Course();
		c.setName("מחשבים קוונטים");
		c.setID("61989");
		s.add(c);
		c=new Course();
		c.setName("תכנות מדעי");
		c.setID("61991");
		s.add(c);
		c=new Course();
		c.setName("מבוא לחישה ולמידה");
		c.setID("61992");
		s.add(c);
		d.add(s);

		s=new Semester("אשכול אלגורתמים",true);
		c=new Course();
		c.setName("אנליזה נומרית");
		c.setID("61959");
		s.add(c);
		c=new Course();
		c.setName("מבוא לאופטמיזציה");
		c.setID("61960");
		s.add(c);
		c=new Course();
		c.setName("אחזור מידע");
		c.setID("61961");
		s.add(c);
		c=new Course();
		c.setName("גיאומטריה חישובית ומידול");
		c.setID("61962");
		s.add(c);
		c=new Course();
		c.setName("בינה מלאכותית");
		c.setID("61963");
		s.add(c);
		c=new Course();
		c.setName("ויזואליזציה של המידע");
		c.setID("61964");
		s.add(c);
		c=new Course();
		c.setName("ניתוח של נתונתי הרשתות");
		c.setID("61965");
		s.add(c);
		d.add(s);

		s=new Semester("אשכול סמינרים",true);
		c=new Course();
		c.setName("סמינר מערכות לומדות");
		c.setID("61966");
		s.add(c);
		c=new Course();
		c.setName("סמינר באלגוריתמים אקראיים");
		c.setID("61967");
		s.add(c);
		c=new Course();
		c.setName("סמינר באלגורתמים מתקדמים");
		c.setID("61968");
		s.add(c);
		c=new Course();
		c.setName("סמינר באימות תכנה");
		c.setID("61969");
		s.add(c);
		c=new Course();
		c.setName("סמינר באוטומטים");
		c.setID("61970");
		s.add(c);
		d.add(s);

		s=new Semester("אשכול עיבוד אותות ורשתות",true);
		c=new Course();
		c.setName("עיבוד תמונה ספרתי");
		c.setID("61971");
		s.add(c);
		c=new Course();
		c.setName("עיבוד אותות ספרתי DSP");
		c.setID("61972");
		s.add(c);
		c=new Course();
		c.setName("תקשורת אלחוטית ורשתות מחשבים");
		c.setID("61973");
		s.add(c);
		c=new Course();
		c.setName("בדיקת מערכות ספרתיות");
		c.setID("61974");
		s.add(c);
		c=new Course();
		c.setName("דחיסת נתונים");
		c.setID("61975");
		s.add(c);
		c=new Course();
		c.setName("ביולוגיה חישובית");
		c.setID("61976");
		s.add(c);
		d.add(s);

		s=new Semester("אשכול הנדסת תכנה",true);
		c=new Course();
		c.setName("מסדי נתונים מבוזרים");
		c.setID("61834");
		s.add(c);
		c=new Course();
		c.setName("טכנולוגיית WEB מתקדם");
		c.setID("61977");
		s.add(c);
		c=new Course();
		c.setName("אימות תכנה וחומרה");
		c.setID("61978");
		s.add(c);
		c=new Course();
		c.setName("מחשוב ענן");
		c.setID("61979");
		s.add(c);
		c=new Course();
		c.setName("שפות תכנות");
		c.setID("61980");
		s.add(c);
		c=new Course();
		c.setName("הנדסת דרישות");
		c.setID("61981");
		s.add(c);
		d.add(s);

		s=new Semester("אשכול מעבדות",true);
		c=new Course();
		c.setName("מעבדה במידול מערכות אקולוגיות");
		c.setID("61982");
		s.add(c);
		c=new Course();
		c.setName("מעבדה בתכנות מקבילי והטרוגני");
		c.setID("61983");
		s.add(c);
		c=new Course();
		c.setName("מעבדה באופטימיזיציה");
		c.setID("61984");
		s.add(c);
		c=new Course();
		c.setName("מעבדה בפיתוח יישמים באנדרואיד");
		c.setID("61985");
		s.add(c);
		c=new Course();
		c.setName("מעבדה בסחר אלקטורני");
		c.setID("61986");
		s.add(c);
		c=new Course();
		c.setName("מעבדה בכריית נתונים");
		c.setID("61987");
		s.add(c);
		c=new Course();
		c.setName("מעבדה בעיצוב תבניות בתכנה");
		c.setID("61988");
		s.add(c);
		c=new Course();
		c.setName("מעבדה בטכנולוגיות תכנות צד לקוח ושרת");
		c.setID("61990");
		s.add(c);
		d.add(s);

	}


	private static void loadMech()
	{
		Department d=new Department("הנדסת מכונות");
		Department.department.add(d);
		Semester s=new Semester("סמסטר א'",false);
		Course c;
		c=new Course();
		c.setName("אלגברה 1");
		c.setID("11001");
		s.add(c);
		c=new Course();
		c.setName("חדווא 1");
		c.setID("11003");
		s.add(c);
		c=new Course();
		c.setName("אנגלית בסיסי");
		c.setID("11063");
		s.add(c);
		c=new Course();
		c.setName("אנגלית מתקדמים א'");
		c.setID("11064");
		s.add(c);
		c=new Course();
		c.setName("מבוא לפיזיקה אקדמית");
		c.setID("11179");
		s.add(c);
		c=new Course();
		c.setName("כימיה מכ");
		c.setID("41077");
		s.add(c);
		c=new Course();
		c.setName("טכנולוגיה יישומית");
		c.setID("22205");
		s.add(c);
		c=new Course();
		c.setName("מבוא לגרפיקה הנדסית");
		c.setID("22112");
		s.add(c);
		c=new Course();
		c.setName("מבוא יצירתי להנדסת מכונות");
		c.setID("22705");
		s.add(c);
		c=new Course();
		c.setName("מיומנות למידה");
		c.setID("11947");
		s.add(c);
		d.add(s);

		s=new Semester("סמסטר ב'",false);
		c=new Course();
		c.setName("חדווא 2");
		c.setID("11005");
		s.add(c);
		c=new Course();
		c.setName("אנגלית מתקדמים א'");
		c.setID("11064");
		s.add(c);
		c=new Course();
		c.setName("פיזיקה 1מכ");
		c.setID("11218");
		s.add(c);
		c=new Course();
		c.setName("טכנולוגיה יישומית");
		c.setID("22205");
		s.add(c);
		c=new Course();
		c.setName("מבוא יצירתי להנדסת מכונות");
		c.setID("22705");
		s.add(c);
		c=new Course();
		c.setName("מכניקת מוצקים 1");
		c.setID("22305");
		s.add(c);
		c=new Course();
		c.setName("הנדסת חומרים");
		c.setID("22400");
		s.add(c);
		c=new Course();
		c.setName("מבוא לתכנות");
		c.setID("22105");
		s.add(c);
		d.add(s);

		s=new Semester("סמסטר ג'",false);
		c=new Course();
		c.setName("אנגלית מתקדמים ב'");
		c.setID("11060");
		s.add(c);
		c=new Course();
		c.setName("משוואות דיפרנציאליות מכ");
		c.setID("11133");
		s.add(c);
		c=new Course();
		c.setName("פיזיקה 2מכ");
		c.setID("11212");
		s.add(c);
		c=new Course();
		c.setName("תיבם");
		c.setID("22113");
		s.add(c);
		c=new Course();
		c.setName("מכניקת מוצקים 2");
		c.setID("22310");
		s.add(c);
		c=new Course();
		c.setName("מבוא לתהליכי ייצור");
		c.setID("22210");
		s.add(c);
		d.add(s);

		s=new Semester("סמסטר ד'",false);
		c=new Course();
		c.setName("חשמל ואלקטרוניקה מכ");
		c.setID("31375");
		s.add(c);
		c=new Course();
		c.setName("תרמודינמיקה");
		c.setID("22600");
		s.add(c);
		c=new Course();
		c.setName("מעבדה בחוזק וחומרים");
		c.setID("22415");
		s.add(c);
		c=new Course();
		c.setName("קינימטיקה ותורת המנגנונים");
		c.setID("22500");
		s.add(c);
		c=new Course();
		c.setName("מבוא לתכן מכני");
		c.setID("22715");
		s.add(c);
		c=new Course();
		c.setName("אותות ומערכות");
		c.setID("22800");
		s.add(c);
		d.add(s);

		s=new Semester("סמסטר ה'",false);
		c=new Course();
		c.setName("אנליזה נומרית");
		c.setID("22130");
		s.add(c);
		c=new Course();
		c.setName("דינמיקה");
		c.setID("22510");
		s.add(c);
		c=new Course();
		c.setName("מבוא לבקרה");
		c.setID("22810");
		s.add(c);
		c=new Course();
		c.setName("מכניקת זורמים");
		c.setID("22610");
		s.add(c);
		c=new Course();
		c.setName("פרויקט תכן מכני");
		c.setID("22735");
		s.add(c);
		d.add(s);


		s=new Semester("סמסטר ו'",false);
		c=new Course();
		c.setName("תורת הרטט");
		c.setID("22520");
		s.add(c);
		c=new Course();
		c.setName("מעבר חום");
		c.setID("22620");
		s.add(c);
		c=new Course();
		c.setName("מעבדה בתופעות מעבר");
		c.setID("22635");
		s.add(c);
		c=new Course();
		c.setName("תכן הנדסי מתקדם");
		c.setID("22745");
		s.add(c);
		c=new Course();
		c.setName("הסתברות וסטטיסטיקה מכ");
		c.setID("51700");
		s.add(c);
		d.add(s);

		s=new Semester("סמסטר ז'",false);
		c=new Course();
		c.setName("התכנסות בתעשייה");
		c.setID("22900");
		s.add(c);
		c=new Course();
		c.setName("פרויקט מסכם 1");
		c.setID("22921");
		s.add(c);
		c=new Course();
		c.setName("פיזיקה 3מכ");
		c.setID("11213");
		s.add(c);
		d.add(s);

		s=new Semester("סמסטר ח'",false);
		c=new Course();
		c.setName("פרויקט מסכם 2");
		c.setID("22930");
		s.add(c);
		d.add(s);


		s=new Semester("מסלול תכן ייצור 1",false);
		c=new Course();
		c=new Course();
		c.setName("תכן רכיבים מכניים");
		c.setID("22720");
		s.add(c);
		c=new Course();
		c.setName("תהליכי עיבוד שבבי");
		c.setID("22251");
		s.add(c);
		c=new Course();
		c.setName("הנדסת חומרים מתקדמת");
		c.setID("22267");
		s.add(c);
		c=new Course();
		c.setName("חוזק מתקדם");
		c.setID("22268");
		s.add(c);
		c.setName("אלמנטים סופיים");
		c.setID("22163");
		s.add(c);
		c=new Course();
		c.setName("עיבוד פלסטי של מתכות");
		c.setID("22255");
		s.add(c);
		c=new Course();
		c.setName("מערכות ייצור ממוחשבות");
		c.setID("22252");
		s.add(c);
		c=new Course();
		c.setName("תכן מערכות הידראוליות");
		c.setID("22779");
		s.add(c);
		d.add(s);


		s=new Semester("מסלול תכן ייצור 2",false);
		c=new Course();
		c.setName("הנע חשמלי מכ");
		c.setID("31853");
		s.add(c);
		c=new Course();
		c.setName("אוטומציה תעשייתית");
		c.setID("22253");
		s.add(c);
		c=new Course();
		c.setName("מערכות שינוע והובלה");
		c.setID("22776");
		s.add(c);
		c=new Course();
		c.setName("רובוטיקה");
		c.setID("22772");
		s.add(c);
		c=new Course();
		c.setName("מידול וייצור מיקרו התקנים");
		c.setID("22784");
		s.add(c);
		c=new Course();
		c.setName("תכן ואנליזת מבנים מחומרים מורכבים");
		c.setID("22777");
		s.add(c);
		c=new Course();
		c.setName("ביומכניקה שיקומית");
		c.setID("22466");
		s.add(c);
		d.add(s);

		s=new Semester("מסלול חומרים פלסטיים ועיבודם",false);
		c=new Course();
		c.setName("מבנה ותכונות של חומרים פלסטיים");
		c.setID("22450");
		s.add(c);
		c=new Course();
		c.setName("תהליכי עיבוד של חומרים פלסטיים");
		c.setID("22453");
		s.add(c);
		c=new Course();
		c.setName("כשל ואפיון של חומרים פלסטיים");
		c.setID("22458");
		s.add(c);
		c=new Course();
		c.setName("טכנולוגיה של תהליך הזרקה");
		c.setID("22456");
		s.add(c);
		c=new Course();
		c.setName("תכן ואנליזת מבנים מחומרים");
		c.setID("22777");
		s.add(c);
		c=new Course();
		c.setName("נושאים מתקדמים בחומרים פלסטיים");
		c.setID("22484");
		s.add(c);
		c=new Course();
		c.setName("שיטות חישוב והדמיה מולקולרית של פולימרים");
		c.setID("22455");
		s.add(c);
		c=new Course();
		c.setName("מבוא לתכן תבניות הזרקה");
		c.setID("22459");
		s.add(c);
		c=new Course();
		c.setName("אלמנטים סופיים");
		c.setID("22163");
		s.add(c);
		c=new Course();
		c.setName("תכן מוצר מחומרים פלסטיים");
		c.setID("22775");
		s.add(c);
		d.add(s);

		s=new Semester("מסלול מכטרוניקה",false);
		c=new Course();
		c.setName("מבוא למערכות מכטרוניות");
		c.setID("22861");
		s.add(c);
		c=new Course();
		c.setName("מעבדה במכטרוניקה");
		c.setID("22862");
		s.add(c);
		c=new Course();
		c.setName("בקרה מודרנית");
		c.setID("22864");
		s.add(c);
		c=new Course();
		c.setName("תכן מערכות משולבות");
		c.setID("22863");
		s.add(c);
		c=new Course();
		c.setName("הנע חשמלי מכ");
		c.setID("31853");
		s.add(c);
		c=new Course();
		c.setName("רובוטיקה");
		c.setID("22772");
		s.add(c);
		c=new Course();
		c.setName("רובוטיקה תעופתית");
		c.setID("22874");
		s.add(c);
		c=new Course();
		c.setName("מבוא למכניקת הטיס");
		c.setID("22748");
		s.add(c);
		c=new Course();
		c.setName("אלמנטים סופיים");
		c.setID("22163");
		s.add(c);
		c=new Course();
		c.setName("אוטומציה תעשייתית");
		c.setID("22253");
		s.add(c);
		c=new Course();
		c.setName("תכן רכיבים מכניים");
		c.setID("22720");
		s.add(c);
		c=new Course();
		c.setName("מידול וייצור מיקרו התקנים מכניים");
		c.setID("22784");
		s.add(c);
		d.add(s);

		s=new Semester("מסלול ביומכניקה",false);
		c=new Course();
		c.setName("ניתוח הנדסי של מערכות פיזיולוגיות");
		c.setID("22471");
		s.add(c);
		c=new Course();
		c.setName("חומרים ביו-רפואיים");
		c.setID("22481");
		s.add(c);
		c=new Course();
		c.setName("אנטומיה ופיזיולוגיה");
		c.setID("41135");
		s.add(c);
		c=new Course();
		c.setName("מבוא לביומכניקה");
		c.setID("22467");
		s.add(c);
		c=new Course();
		c.setName("יישומים של ביוחמרים");
		c.setID("41591");
		s.add(c);
		c=new Course();
		c.setName("מעבדה במכטרוניקה");
		c.setID("22862");
		s.add(c);
		c=new Course();
		c.setName("מבוא למערכות מכטרוניות");
		c.setID("22861");
		s.add(c);
		c=new Course();
		c.setName("מבנה ותכונות של חומרים פלסטיים");
		c.setID("22450");
		s.add(c);
		c=new Course();
		c.setName("אלמנטים סופיים");
		c.setID("22163");
		s.add(c);
		c=new Course();
		c.setName("רובוטיקה");
		c.setID("22772");
		s.add(c);
		d.add(s);
	}

	private static void loadInus()
	{
		Department d = new Department("הנדסת תעשייה וניהול");
		Department.department.add(d);
		Semester s = new Semester("סמסטר א'", false);
		Course c;
		c = new Course();
		c.setName("אלגברה 1");
		c.setID("11001");
		s.add(c);
		c = new Course();
		c.setName("חדווא 1");
		c.setID("11003");
		s.add(c);
		c = new Course();
		c.setName("אנגלית בסיסי");
		c.setID("11063");
		s.add(c);
		c = new Course();
		c.setName("אנגלית מתקדמים א'");
		c.setID("11064");
		s.add(c);
		c = new Course();
		c.setName("מבוא לפיזיקה אקדמית");
		c.setID("11179");
		s.add(c);
		c = new Course();
		c.setName("מבוא להנדסת תעשייה");
		c.setID("51104");
		s.add(c);
		c = new Course();
		c.setName("מבוא למדעי המחשב לתעונ");
		c.setID("61903");
		s.add(c);
		c = new Course();
		c.setName("מיומנות למידה");
		c.setID("11947");
		s.add(c);
		d.add(s);

		s = new Semester("סמסטר ב'", false);
		c = new Course();
		c.setName("חדווא 2");
		c.setID("11005");
		s.add(c);
		c = new Course();
		c.setName("אנגלית מתקדמים ב'");
		c.setID("11059");
		s.add(c);
		c = new Course();
		c.setName("פיזיקה IE1");
		c.setID("11209");
		s.add(c);
		c = new Course();
		c.setName("גרפיקה הנדסית לתעונ");
		c.setID("21127");
		s.add(c);
		c = new Course();
		c.setName("מתמתיקה דיסקרטית");
		c.setID("51005");
		s.add(c);
		c = new Course();
		c.setName("מבוא לכלכלה");
		c.setID("51600");
		s.add(c);
		c = new Course();
		c.setName("מבוא לתכנות מערכות לתעונ");
		c.setID("61904");
		s.add(c);
		d.add(s);

		s = new Semester("סמסטר ג'", false);
		c = new Course();
		c.setName("אנגלית טכנית יישומית");
		c.setID("11068");
		s.add(c);
		c = new Course();
		c.setName("פיזיקה IE2");
		c.setID("11210");
		s.add(c);
		c = new Course();
		c.setName("חומרים ותהליכי עיבוד לתעונ");
		c.setID("21218");
		s.add(c);
		c = new Course();
		c.setName("הנדסת אנוש");
		c.setID("51138");
		s.add(c);
		c = new Course();
		c.setName("מבוא לשיווק");
		c.setID("51302");
		s.add(c);
		c = new Course();
		c.setName("מערכות ארגוניות");
		c.setID("51425");
		s.add(c);
		c = new Course();
		c.setName("מודלים דטרמייניסטיים בחקבצ");
		c.setID("51702");
		s.add(c);
		c = new Course();
		c.setName("הסתברות");
		c.setID("51709");
		s.add(c);
		d.add(s);

		s = new Semester("סמסטר ד'", false);
		c = new Course();
		c.setName("מערכות ייצור משולבות מחשב");
		c.setID("51141");
		s.add(c);
		c = new Course();
		c.setName("תכן שיטות העבודה");
		c.setID("51215");
		s.add(c);
		c = new Course();
		c.setName("משוואות דיפרנציאליות ומערכות בקרה");
		c.setID("51310");
		s.add(c);
		c = new Course();
		c.setName("חשבונאות פיננסית");
		c.setID("51617");
		s.add(c);
		c = new Course();
		c.setName("מודלים סטוכסטיים בחקבצ");
		c.setID("51703");
		s.add(c);
		c = new Course();
		c.setName("סטטיסטיקה");
		c.setID("51723");
		s.add(c);
		d.add(s);

		s = new Semester("סמסטר ה'", false);
		c = new Course();
		c.setName("מבוא להנדסת חשמל לתעונ");
		c.setID("31322");
		s.add(c);
		c = new Course();
		c.setName("תכן הנדסי");
		c.setID("51013");
		s.add(c);
		c = new Course();
		c.setName("ניהול מערכות ייצור");
		c.setID("51131");
		s.add(c);
		c = new Course();
		c.setName("מעבדה במיבמ(CIM)");
		c.setID("51159");
		s.add(c);
		c = new Course();
		c.setName("ניהול איכות סטטיסטי");
		c.setID("51213");
		s.add(c);
		c = new Course();
		c.setName("יסודות הניהול");
		c.setID("51426");
		s.add(c);
		c = new Course();
		c.setName("סימולציה ספרתית");
		c.setID("51724");
		s.add(c);
		d.add(s);

		s = new Semester("סמסטר ו'", false);
		c = new Course();
		c.setName("תכנון ותפעול תהליך האספקה בארגון");
		c.setID("51132");
		s.add(c);
		c = new Course();
		c.setName("תכנון פרויקטים וניהולם");
		c.setID("51430");
		s.add(c);
		c = new Course();
		c.setName("מתודולוגיות לתפרון בעיות");
		c.setID("51427");
		s.add(c);
		c = new Course();
		c.setName("אפיון וניתוח מערכות מידע");
		c.setID("51429");
		s.add(c);
		c = new Course();
		c.setName("ניהול פיננסי");
		c.setID("51608");
		s.add(c);
		c = new Course();
		c.setName("חשבונאות ניהולית");
		c.setID("51618");
		s.add(c);
		d.add(s);

		s = new Semester("סמסטר ז'", false);
		c = new Course();
		c.setName("כלכלת סביבה");
		c.setID("51623");
		s.add(c);
		c = new Course();
		c.setName("התמחות בתעשייה/באקדמיה");
		c.setID("51012");
		s.add(c);
		c = new Course();
		c.setName("תכן מערך העבודה");
		c.setID("51136");
		s.add(c);
		c = new Course();
		c.setName("פרוייקט גמר סמסטריאלי");
		c.setID("51100");
		s.add(c);
		c = new Course();
		c.setName("פרוייקט גמר שנתי א");
		c.setID("51151");
		s.add(c);
		c = new Course();
		c.setName("פרוייקט גמר שנתי ב");
		c.setID("51152");
		s.add(c);
		d.add(s);
	}


	private static void loadInfor() {
		Department d = new Department("הנדסת מערכות מידע");
		Department.department.add(d);
		Semester s = new Semester("סמסטר א'", false);
		Course c = new Course();
		c.setName("אנגלית בסיסי");
		c.setID("11063");
		s.add(c);
		c = new Course();
		c.setName("אנגלית מתקדמים א'");
		c.setID("11064");
		s.add(c);
		c = new Course();
		c.setName("מבוא לפיזיקה אקדמית");
		c.setID("11179");
		s.add(c);
		c = new Course();
		c.setName("מיומנות למידה");
		c.setID("11947");
		s.add(c);
		c = new Course();
		c.setName("חדווא 1מ");
		c.setID("11004");
		s.add(c);
		c = new Course();
		c.setName("אלגברה 1מח");
		c.setID("11002");
		s.add(c);
		c = new Course();
		c.setName("מערכות ספרתיות");
		c.setID("61740");
		s.add(c);
		c = new Course();
		c.setName("מבוא למדעי המחשב");
		c.setID("61741");
		s.add(c);
		c = new Course();
		c.setName("אוריינות בעברית");
		c.setID("11351");
		s.add(c);
		d.add(s);

		s = new Semester("סמסטר ב'", false);
		c = new Course();
		c.setName("חדווא 2מ");
		c.setID("11006");
		s.add(c);
		c = new Course();
		c.setName("אלגברה 2מח");
		c.setID("11020");
		s.add(c);
		c = new Course();
		c.setName("אנגלית מתקדמים ב'");
		c.setID("11060");
		s.add(c);
		c = new Course();
		c.setName("מתמטיקה דיסקרטית 1");
		c.setID("61743");
		s.add(c);
		c = new Course();
		c.setName("ארגון ותכנון המחשב");
		c.setID("61744");
		s.add(c);
		c = new Course();
		c.setName("מבוא לתכנות מערכות");
		c.setID("61745");
		s.add(c);
		d.add(s);

		s = new Semester("סמסטר ג'", false);
		c = new Course();
		c.setName("הסתברות");
		c.setID("51709");
		s.add(c);
		c = new Course();
		c.setName("לוגיקה");
		c.setID("61746");
		s.add(c);
		c = new Course();
		c.setName("מבני נתונים");
		c.setID("61747");
		s.add(c);
		c = new Course();
		c.setName("מתמתיקה דיסקרטית 2");
		c.setID("61749");
		s.add(c);
		c = new Course();
		c.setName("מבוא להנדסת תוכנה");
		c.setID("61750");
		s.add(c);
		c = new Course();
		c.setName("מבוא להנדסת מערכות מידע");
		c.setID("61830");
		s.add(c);
		d.add(s);

		s = new Semester("סמסטר ד'", false);
		c = new Course();
		c.setName("מכניקה להנדסת תוכנה");
		c.setID("11158");
		s.add(c);
		c = new Course();
		c.setName("תכנות מונחה עצמים");
		c.setID("61751");
		s.add(c);
		c = new Course();
		c.setName("מערכות הפעלה");
		c.setID("61752");
		s.add(c);
		c = new Course();
		c.setName("אלגורתמים");
		c.setID("61753");
		s.add(c);
		c = new Course();
		c.setName("מערכות מסדי נתונים מ");
		c.setID("61755");
		s.add(c);
		d.add(s);

		s = new Semester("סמסטר ה'", false);
		c = new Course();
		c.setName("אנגלית טכנית יישומית - תכנה");
		c.setID("11069");
		s.add(c);
		c = new Course();
		c.setName("מודלים דטרמיניסטים בחקבצ");
		c.setID("51702");
		s.add(c);
		c = new Course();
		c.setName("מודלים סטוכסטיים בחקבצ");
		c.setID("51703");
		s.add(c);
		c = new Course();
		c.setName("סטטיסטיקה למערכות מידע");
		c.setID("51958");
		s.add(c);
		c = new Course();
		c.setName("שיטות הנדסיות לפיתוח תכנה");
		c.setID("61756");
		s.add(c);
		c = new Course();
		c.setName("מבוא לבדיקות תוכנה");
		c.setID("61757");
		s.add(c);
		c = new Course();
		c.setName("ממשק אדם מחשב");
		c.setID("61769");
		s.add(c);
		d.add(s);

		s = new Semester("סמסטר ו'", false);
		c = new Course();
		c.setName("חשמל ומגנטיות להנדסת תכנה");
		c.setID("11159");
		s.add(c);
		c = new Course();
		c.setName("תכנון ותפעול תהליך האספקה בארגון");
		c.setID("51132");
		s.add(c);
		c = new Course();
		c.setName("מערכות אירגונית וניהול");
		c.setID("51957");
		s.add(c);
		c = new Course();
		c.setName("חשבונאות פיננסית");
		c.setID("51617");
		s.add(c);
		c = new Course();
		c.setName("כריית נתונים ומערכות לומדות");
		c.setID("61761");
		s.add(c);
		c = new Course();
		c.setName("מסדי נתונים מבוזרים");
		c.setID("61834");
		s.add(c);
		d.add(s);

		s=new Semester("סמסטר ז'",false);
		c=new Course();
		c.setName("חשבונאות ניהולית ומימון");
		c.setID("51955");
		s.add(c);
		c=new Course();
		c.setName("אבטחת מידע וקריפטולוגיה");
		c.setID("61767");
		s.add(c);
		c=new Course();
		c.setName("ממשק אדם מחשב מ'");
		c.setID("61770");
		s.add(c);
		c=new Course();
		c.setName("ניהול ידע");
		c.setID("61831");
		s.add(c);
		c=new Course();
		c.setName("פרויקט גמר במערכות מידע שלב א'");
		c.setID("61833");
		s.add(c);
		d.add(s);

		s=new Semester("סמסטר ח'",false);
		c=new Course();
		c.setName("מבוא לכלכלה למהנדסים");
		c.setID("51605");
		s.add(c);
		c=new Course();
		c.setName("פרויקט גמר במערכות מידע");
		c.setID("61835");
		s.add(c);
		d.add(s);


		s=new Semester("אשכול מדעים 1",true);
		c=new Course();
		c=new Course();
		c.setName("טורים,התמרות ומשוואת דיפרנציאליות");
		c.setID("11129");
		s.add(c);
		c.setName("פיזיקה מודרנית");
		c.setID("11198");
		s.add(c);
		c=new Course();
		c.setName("מבוא לביולוגיה מולקולרית");
		c.setID("41942");
		s.add(c);
		c=new Course();
		c.setName("תורת המשחקים");
		c.setID("61957");
		s.add(c);
		c=new Course();
		c.setName("תורת המידע");
		c.setID("61958");
		s.add(c);
		c=new Course();
		c.setName("אנליזה נומרית");
		c.setID("61959");
		s.add(c);
		c=new Course();
		c.setName("מבוא לאופטמיזציה");
		c.setID("61960");
		s.add(c);
		d.add(s);

		s=new Semester("אשכול מדעים 2",true);
		c=new Course();
		c.setName("סמינר באלגוריתמים אקראיים");
		c.setID("61967");
		s.add(c);
		c=new Course();
		c.setName("סמינר באלגורתמים מתקדמים");
		c.setID("61968");
		s.add(c);
		c=new Course();
		c.setName("מעבדה במידול מערכות אקולוגיות");
		c.setID("61982");
		s.add(c);
		c=new Course();
		c.setName("מחשבים קוונטים");
		c.setID("61989");
		s.add(c);
		c=new Course();
		c.setName("תכנות מדעי");
		c.setID("61991");
		s.add(c);
		c=new Course();
		c.setName("מבוא לחישה ולמידה");
		c.setID("61992");
		s.add(c);
		d.add(s);

		s=new Semester("אשכול תכן, תפעול וניהול",true);
		c = new Course();
		c.setName("מערכות מלאי");
		c.setID("51106");
		s.add(c);
		c = new Course();
		c.setName("ניהול מערכות ייצור");
		c.setID("51131");
		s.add(c);
		c = new Course();
		c.setName("תכנון משאבים ודרישות חומרים");
		c.setID("51147");
		s.add(c);
		c = new Course();
		c.setName("מבוא לERP ומערכות ארגוניות");
		c.setID("51154");
		s.add(c);
		c = new Course();
		c.setName("אמינות");
		c.setID("51202");
		s.add(c);
		c = new Course();
		c.setName("ניהול איכות סטטיסטי");
		c.setID("51213");
		s.add(c);
		c=new Course();
		c.setName("תכנון פרויקטים וניהולם");
		c.setID("51430");
		s.add(c);
		c=new Course();
		c.setName("סימולציה ספרתית");
		c.setID("51724");
		s.add(c);
		c=new Course();
		c.setName("מעבדה באופטימיזיציה");
		c.setID("61984");
		s.add(c);
		d.add(s);



		s=new Semester("אשכול הנדסת תכנה 1",true);
		c=new Course();
		c.setName("רשתות מחשבים");
		c.setID("61765");
		s.add(c);
		c=new Course();
		c.setName("אחזור מידע");
		c.setID("61961");
		s.add(c);
		c=new Course();
		c.setName("ויזואליזציה של המידע");
		c.setID("61964");
		s.add(c);
		c=new Course();
		c.setName("סמינר מערכות לומדות");
		c.setID("61966");
		s.add(c);
		c=new Course();
		c.setName("דחיסת נתונים");
		c.setID("61975");
		s.add(c);
		c=new Course();
		c.setName("טכנולוגיית WEB מתקדם");
		c.setID("61977");
		s.add(c);
		c=new Course();
		c.setName("מחשוב ענן");
		c.setID("61979");
		s.add(c);
		d.add(s);

		s=new Semester("אשכול הנדסת תכנה 2",true);
		c=new Course();
		c.setName("שפות תכנות");
		c.setID("61980");
		s.add(c);
		c=new Course();
		c.setName("הנדסת דרישות");
		c.setID("61981");
		s.add(c);
		c=new Course();
		c.setName("מעבדה בתכנות מקבילי והטרוגני");
		c.setID("61983");
		s.add(c);
		c=new Course();
		c.setName("מעבדה בפיתוח יישמים באנדרואיד");
		c.setID("61985");
		s.add(c);
		c=new Course();
		c.setName("מעבדה בסחר אלקטורני");
		c.setID("61986");
		s.add(c);
		c=new Course();
		c.setName("מעבדה בכריית נתונים");
		c.setID("61987");
		s.add(c);
		c=new Course();
		c.setName("מעבדה בעיצוב תבניות בתכנה");
		c.setID("61988");
		s.add(c);
		c=new Course();
		c.setName("מעבדה בטכנולוגיות תכנות צד לקוח ושרת");
		c.setID("61990");
		s.add(c);
		d.add(s);


	}

	private static void loadBio()
	{
		Department d = new Department("הנדסת ביוטכנולוגיה");
		Department.department.add(d);
		Semester s=new Semester("סמסטר א'",false);
		Course c=new Course();
		c.setName("אנגלית בסיסי");
		c.setID("11063");
		s.add(c);
	}

	private static void loadMath()
	{
		Department d = new Department("מתמטיקה יישומית");
		Department.department.add(d);
		Semester s = new Semester("סמסטר א'", false);
		Course c = new Course();
		c = new Course();
		c.setName("אלגברה מ");
		c.setID("11002");
		s.add(c);
		c = new Course();
		c.setName("חדווא 1מ");
		c.setID("11004");
		s.add(c);
		c.setName("אנגלית בסיסי");
		c.setID("11063");
		s.add(c);
		c = new Course();
		c.setName("אנגלית מתקדמים א'");
		c.setID("11064");
		s.add(c);
		c = new Course();
		c.setName("מבוא לפיזיקה אקדמית");
		c.setID("11179");
		s.add(c);
		c = new Course();
		c.setName("מתמטיקה דיסקרטית 1");
		c.setID("61743");
		s.add(c);
		c = new Course();
		c.setName("מבוא למדעי המחשב");
		c.setID("61741");
		s.add(c);
		c = new Course();
		c.setName("סמינר בנושאים במתמטיקה");
		c.setID("201154");
		s.add(c);
		d.add(s);

		s = new Semester("סמסטר ב'", false);
		c = new Course();
		c.setName("חדווא 2מ");
		c.setID("11006");
		s.add(c);
		c = new Course();
		c.setName("פיזיקה IE1");
		c.setID("11209");
		s.add(c);
		c = new Course();
		c.setName("מבוא לתכנות מערכות");
		c.setID("61745");
		s.add(c);
		c = new Course();
		c.setName("משוואת דיפרנציאליות רגילות מש");
		c.setID("201005");
		s.add(c);
		c = new Course();
		c.setName("אלגברה לינארית 2");
		c.setID("201174");
		s.add(c);
		d.add(s);

		s = new Semester("סמסטר ג'", false);
		c = new Course();
		c.setName("אנגלית מתקדמים ב'");
		c.setID("11059");
		s.add(c);
		c = new Course();
		c.setName("פיזיקה IE2");
		c.setID("11210");
		c = new Course();
		c = new Course();
		c.setName("תורת ההסתברות מש");
		c.setID("51900");
		s.add(c);
		c = new Course();
		c.setName("אנליזה נומרית מש");
		c.setID("201009");
		s.add(c);
		c.setName("אלגברה מודרנית");
		c.setID("201015");
		s.add(c);
		c.setName("מבוא לאנליזה");
		c.setID("201176");
		s.add(c);
		d.add(s);

		s = new Semester("סמסטר ד'", false);
		c = new Course();
		c.setName("תהליכים אקראיים מש");
		c.setID("51901");
		s.add(c);
		c = new Course();
		c.setName("מבני נתונים");
		c.setID("61747");
		s.add(c);
		c = new Course();
		c.setName("פונקציות מורכבות מש");
		c.setID("201007");
		s.add(c);
		c = new Course();
		c.setName("טורי פורייה והתמרות אינטגרליות מש");
		c.setID("201008");
		s.add(c);
		c.setName("מבוא לאופטימיזציה");
		c.setID("201178");
		s.add(c);
		d.add(s);


		s = new Semester("סמסטר ה'", false);
		c = new Course();
		c.setName("משוואות דיפרנציאליות חלקיות מש");
		c.setID("201006");
		s.add(c);
		c = new Course();
		c.setName("מערכות דינמיות מורכבות");
		c.setID("201180");
		s.add(c);
		d.add(s);

		s = new Semester("סמסטר ו'", false);
		c = new Course();
		c.setName("בניית מודלים מתמטיים");
		c.setID("61934");
		s.add(c);
		c = new Course();
		c.setName("פרויקט מסכם");
		c.setID("201100");
		s.add(c);
		d.add(s);

	}

	private static void loadPhy()
	{
		Department d = new Department("פיזיקה והנדסה אופטית");
		Department.department.add(d);
		Semester s=new Semester("סמסטר א'",false);
		Course c=new Course();
		c.setName("אנגלית בסיסי");
		c.setID("11063");
		s.add(c);
	}


}
