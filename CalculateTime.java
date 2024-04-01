import java.util.Scanner;
class MyTime
{
int hours;
int minutes;
String amPm;
}

class CalculateTime
{

public static void main(String[] args)
{

Scanner scanner;
MyTime tempTime;
MyTime delayTime;
MyTime endTime;

scanner= new Scanner(System.in);
tempTime = getStartTime(scanner);
while(tempTime.hours != 999)
{
    delayTime = getDelayTime(scanner);
    endTime = computeEndTime(tempTime, delayTime);
    System.out.printf("End time is: %02d:%02d%s\n", endTime.hours, endTime.minutes, endTime.amPm);
    tempTime = getStartTime(scanner);
}

scanner.close();

} //end main

//======================================================================

static MyTime getStartTime(Scanner scanner)
{
    MyTime tempTime;
    tempTime= new MyTime();
    System.out.println("Enter starting time in format \"hour minute am/pm\"\n ex:) 11 40 am:  ");
    tempTime.hours= scanner.nextInt();
    tempTime.minutes= scanner.nextInt();
    tempTime.amPm = scanner.nextLine().toLowerCase().trim();
    return tempTime;
}

//======================================================================

static MyTime getDelayTime(Scanner scanner)
{
    MyTime delayTime;
    delayTime= new MyTime();
    System.out.println("Enter delay time in format \"hours minutes\" \n ex): 12 45: ");
    delayTime.hours= scanner.nextInt();
    delayTime.minutes= scanner.nextInt();
    return delayTime;
}

//======================================================================

static MyTime computeEndTime(MyTime tempTime, MyTime delayTime)
{
    MyTime endTime;
    int tempHours;
    int tempMinutes;
    int finalMins;
    int extraHours;
    int totalHours;

    endTime= new MyTime();
    if(tempTime.amPm.equals("am") && tempTime.hours == 12)
        tempTime.hours = 0;
    else if(tempTime.amPm.equals("pm") && tempTime.hours != 0)
        tempTime.hours += 12;
    tempHours = tempTime.hours + delayTime.hours;
    tempMinutes = tempTime.minutes + delayTime.minutes;
    extraHours= tempMinutes / 60;
    finalMins= tempMinutes % 60;
    totalHours= (tempHours + extraHours) % 24;
    if (totalHours < 12)
        endTime.amPm = "am";
    else
        endTime.amPm = "pm";
    totalHours= totalHours % 12;
    if (totalHours == 0)
        totalHours = 12;
    endTime.hours = totalHours;
    endTime.minutes = finalMins;
    return endTime;
}

//======================================================================

} // end class
