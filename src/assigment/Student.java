package assigment;


import java.util.Date;

public abstract class Student 
{
    private String fn,sn,tel,em,add;
    private Date dob;
    private double fees;
    private Course course;
    private long id;
    
   public Student(String fn, String sn,String tel,String em, String add,Date dob,double fees,Course course,long id) {
        this.fn = fn;
        this.sn = sn;
        this.tel= tel;
        this.em = em;
        this.add = add;
        this.dob = dob;
        this.fees = fees;
        this.course = course;
        this.id = id;
    }
   public void payment(double amt)
   {
       fees +=amt;
   }

public String getFn(){
    return fn;
}
   
public void setFn(String fn){
    this.fn =fn;
}
   public String getSn(){
       return sn;
   }
   public void setSn(String sn){
       this.sn = sn;
   }
   public String getTel(){
       return tel;
   }
   public void setTel(String tel){
       this.tel = tel;
   } 
public String getEm(){
    return em;
}

public void setEm(String em){
    this.em = em;
}

public String getAdd(){
    return add;
}
public void setAdd(String add){
    this.add = add;  
}

public Date getDob(){
    return dob;
}
public void setDob(Date dob){
    this.dob = dob;
}
public double getFees(){
    return fees;
}
public void setFees(double fees){
    this.fees = fees;
}

    public Course getCourse(){
        return course;
    }
  public void setCourse(Course course){
      this.course = course;
  }
    
public long getId(){
    return id;
}

public void setId(long id){
    this.id =id;
}

  
      
       
       
   
    
