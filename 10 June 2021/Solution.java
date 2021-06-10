 // ------------------- O(N^2) solution -------------------

class MyCalendar {

    ArrayList<Booking> calendar;
    public MyCalendar() {
        calendar = new ArrayList<>();
    }

    public boolean book(int start, int end) {

        if (calendar.isEmpty()){
            calendar.add(new Booking(start,end));
            return true;
        }

        for (Booking validBooking : calendar){
            if (start >= validBooking.end || validBooking.start >= end){
                continue;
            }
            else{
                return false;
            }
        }

        calendar.add(new Booking(start,end));
        return true;
    }
}

class Booking{
    int start;
    int end;

    Booking(int start, int end){
        this.start = start;
        this.end = end;
    }
}

// [s1,e1)    [start,end)

// start >= e1    or    s1 >= end


/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */




 // ------------------- O(NlogN) solution -------------------

 class MyCalendar {

     TreeMap<Integer, Integer> calendar;
     public MyCalendar() {
         calendar = new TreeMap();
     }

     public boolean book(int start, int end) {
         Integer prevStart = calendar.floorKey(start);
         Integer nextStart = calendar.ceilingKey(start);

         if ((prevStart == null || start >= calendar.get(prevStart)) && (nextStart == null || nextStart >= end)){
             calendar.put(start,end);
             return true;
         }

         return false;
     }
 }

 /**
  * Your MyCalendar object will be instantiated and called as such:
  * MyCalendar obj = new MyCalendar();
  * boolean param_1 = obj.book(start,end);
  */
