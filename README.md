 # OBS - Ort Braude Scheduler
 
<p align="center"><img src="https://github.com/ziper02/OBS/blob/master/images/OBS_logo.png"/></p>



## Software description  
This Software developed as personal project. It allows students from Ort Braude college to build their schedule for the semester.  
The software is only client side, it allows to student to automatcly obtain in real time the details of the courses ,and offer them option to build custom schedule as they wish, and also provide optimal schedule according to selected courses.  
  
The data is fetched by [Selenium automation](https://www.selenium.dev/).  
The optimal schedule is based on "Genetic Algoritam" , and rules such as less days to learn, minimum of free hours, etc.
  
## Requirements
For this project need Chrome version 76, The version of ChromeDriver only supports this one.
if you using other version of chrome , you can find out [Here](https://chromedriver.chromium.org/downloads) Chromedriver.exe for your chrome version

## Services  
* Fetching courses (by course id or course name), and get the days and hours of lectures, the name of the lecture , the classroom, etc.
* Fetching few courses in one time.
* Building customized schedule.
* Build optimizted schedule (which achieved by Genetic Algoritam).
* Save picture of the selected schedule.
* Save and load the schedule from TMP file that created by the system.
* After loading file , Vecrication of availability for stored schedule according to Ort Braude website.
* Validation check of schedule (that selected lecture,exercise and lab if needed).


### _<p align="center"> Customized schedule </p>_

![alt text](https://github.com/ziper02/OBS/blob/master/images/obs.JPG "Customized schedule")
  
### _<p align="center"> Fetching few courses</h3> </p>_  
![alt text](https://github.com/ziper02/OBS/blob/master/images/multiselect.JPG "Fetching few courses")
  
### _<p align="center"> Optimizted schedule </p>_ 
![alt text](https://github.com/ziper02/OBS/blob/master/images/autoSchedule.JPG "Optimizted schedule")

