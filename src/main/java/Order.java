public class Order extends Thread {
    private int id;
    private Staff staff = new Staff(1);

    public Order(int id){
        this.id = id;
    }
    @Override
    public void run(){
        synchronized (((Integer) staff.getCount())){
            while (staff.getCount()>0){
                staff.setCount(staff.getCount()-1);
                System.out.println("Order id="+id+Thread.currentThread().getName()+"COUNT left="+staff.getCount());
            }
        }
    }
}
