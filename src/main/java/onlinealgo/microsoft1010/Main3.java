package onlinealgo.microsoft1010;

import java.util.*;

/**
 * Created by DCLab on 2016/10/10.
 */
public class Main3 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt(), M = in.nextInt(), K = in.nextInt();

        ArrayList<Student> students = new ArrayList<>();

        ArrayList<Office> offices = new ArrayList<>();
        for (int i=0; i<=M; i++) offices.add(new Office(i));

        for (int n=0; n<N; n++){
            int studentId = in.nextInt(), arriveGateTime = in.nextInt(), officeNum = in.nextInt();
            Student s = new Student(studentId, arriveGateTime, officeNum);
            for (int i=1; i<=officeNum; i++){
                int officeId = in.nextInt(), processTime = in.nextInt();
                int arriveTime = 0;
                if (i==1) arriveTime = s.arriveGateTime+K;
                else arriveTime = -1;
                s.setMyOffice(officeId, processTime, arriveTime);

                if (i==1) offices.get(officeId).queue.offer(s);
            }
            students.add(s);
        }

        for (int i=1; i<=M; i++){
            Office office = offices.get(i);
            PriorityQueue<Student> officeQueue = office.queue;
            if(!officeQueue.isEmpty()){
                office.curTime = officeQueue.peek().myOderedOffices.get(office.officeId).arriveTime;
            }
            while (!officeQueue.isEmpty()){
                Student student = officeQueue.poll();
                MyOffice curMyOffice = student.myOderedOffices.get(office.officeId);
                curMyOffice.leaveTime = office.curTime+curMyOffice.processTime;

                Iterator<Map.Entry<Integer, MyOffice>> iterator = student.myOderedOffices.entrySet().iterator();
                while (iterator.hasNext()){
                    Integer key = iterator.next().getKey();
                    if (key==office.officeId){
                        if (iterator.hasNext()){
                            MyOffice nextMyOffice = iterator.next().getValue();
                            nextMyOffice.arriveTime = curMyOffice.leaveTime+K;

                            Office nextOffice = offices.get(nextMyOffice.officeId);
                            nextOffice.queue.offer(student);
                        }
                    }
                }
            }
        }

        for (int n=0; n<N; n++){
            Student student = students.get(n);
            Collection<MyOffice> myOffices = student.myOderedOffices.values();
            int finishTime = 0;
            for (MyOffice myOffice: myOffices){
                finishTime += myOffice.leaveTime-myOffice.arriveTime;
            }
            finishTime += myOffices.size()*K;
            System.out.println(finishTime);
        }
    }

    static class Student{
        int studentId;
        int arriveGateTime, officeNum;
        LinkedHashMap<Integer, MyOffice> myOderedOffices;
        int finishTime;
        public Student(int studentId, int arriveGateTime, int officeNum) {
            this.studentId = studentId;
            this.arriveGateTime = arriveGateTime;
            this.officeNum = officeNum;
            myOderedOffices = new LinkedHashMap<>();
        }
        public void setMyOffice(int officeId, int processTime, int arriveTime){
            MyOffice myOffice = new MyOffice(officeId, processTime);
            if(arriveTime!=-1) myOffice.arriveTime = arriveTime;
            myOderedOffices.put(officeId, myOffice);
        }
    }

    static class MyOffice {
        int officeId, processTime;
        int arriveTime = -1;
        int leaveTime;
        public MyOffice(int officeId, int processTime) {
            this.officeId = officeId;
            this.processTime = processTime;
        }
    }

    static class Office{
        int officeId;
        PriorityQueue<Student> queue;
        int curTime;
        public Office(int officeId) {
            this.officeId = officeId;
            queue = new PriorityQueue<Student>(new Comparator<Student>() {
                @Override
                public int compare(Student o1, Student o2) {
                    MyOffice myOffice1 = o1.myOderedOffices.get(officeId);
                    MyOffice myOffice2 = o2.myOderedOffices.get(officeId);
                    if(myOffice1.arriveTime==myOffice2.arriveTime){
                        return o1.studentId-o2.studentId;
                    }
                    return myOffice1.arriveTime-myOffice2.arriveTime;
                }
            });
        }
    }

}
